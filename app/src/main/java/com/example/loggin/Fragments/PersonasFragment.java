package com.example.loggin.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loggin.Adaptadores.AdapterPersonas;
import com.example.loggin.Entidades.Persona;
import com.example.loggin.Interfaces.iComunicaFragments;
import com.example.loggin.R;

import java.util.ArrayList;

public class PersonasFragment extends Fragment {

    //private OnFragmentInteractionListener mListener;


    AdapterPersonas adapterPersonas;
    RecyclerView recyclerViewPersonas;
    ArrayList<Persona> listaPersonas;

    EditText txtnombre;

    Activity actividad;
    iComunicaFragments interfaceComunicaFragments;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.personas_fragment,container,false);
        txtnombre = view.findViewById(R.id.txtnombre);

        recyclerViewPersonas = view.findViewById(R.id.recyclerView);
        listaPersonas = new ArrayList<>();
        cargarLista();
        mostrarData();
        return view;
    }
    public void cargarLista(){
        listaPersonas.add(new Persona("Las Vocales","Son 5",R.drawable.vocales));
        listaPersonas.add(new Persona("Los Numeros","Del 1 al 9",R.drawable.numeros));
        listaPersonas.add(new Persona("Los Colores","Primarios y Secundarios",R.drawable.colores));
        listaPersonas.add(new Persona("El Abecedario","Son 24 letras",R.drawable.abecedario));
        listaPersonas.add(new Persona("Las Frutas","Tipos de Frutas",R.drawable.frutas));
        listaPersonas.add(new Persona("Los Animales","Mamiferos ",R.drawable.animales));
        listaPersonas.add(new Persona("Las Notas Musicales","Son 7 Notas",R.drawable.notas));
    }
    private void mostrarData(){
        recyclerViewPersonas.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterPersonas = new AdapterPersonas(getContext(), listaPersonas);
        recyclerViewPersonas.setAdapter(adapterPersonas);

        adapterPersonas.setOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String nombre = listaPersonas.get(recyclerViewPersonas.getChildAdapterPosition(view)).getNombre();
               txtnombre.setText(nombre);
               Toast.makeText(getContext(), "Seleccionó: "+listaPersonas.get(recyclerViewPersonas.getChildAdapterPosition(view)).getNombre(), Toast.LENGTH_SHORT).show();

                interfaceComunicaFragments.enviarPersona(listaPersonas.get(recyclerViewPersonas.getChildAdapterPosition(view)));

            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof Activity){

            this.actividad= (Activity) context;

            interfaceComunicaFragments= (iComunicaFragments) this.actividad;

        }

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    /*
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/
}
