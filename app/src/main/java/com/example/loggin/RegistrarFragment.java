package com.example.loggin;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class RegistrarFragment extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener {
    RequestQueue rq;
    JsonRequest jrq;
    EditText txtUser, txtPwd, txtNames;
    Button btnSesion, btnRegistrar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_registrar, container, false);
        txtUser = (EditText) vista.findViewById(R.id.txtuser);
        txtPwd = (EditText) vista.findViewById(R.id.txtpwd);
        txtNames= (EditText) vista.findViewById(R.id.txtNames);

        btnSesion = (Button) vista.findViewById(R.id.btnsesion);
        btnRegistrar = (Button) vista.findViewById(R.id.btnregistrar);
        rq = Volley.newRequestQueue(getContext());

        btnSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciar_sesion();
            }
        });


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrar_usuario();
            }
        });


        return vista;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getContext(), "No Se pudó registrar el usuario " +error.toString()+ txtUser.getText().toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(getContext(), "Se ha registrado corectamente " + txtUser.getText().toString(), Toast.LENGTH_SHORT).show();
        limpiarCajas();
    }

    void limpiarCajas() {
        txtNames.setText("");
        txtUser.setText("");
        txtPwd.setText("");
    }
    void iniciar_sesion() {

        SesionFragment fr=new SesionFragment();

        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.escenario,fr)
                .addToBackStack(null)
                .commit();
    }

    void registrar_usuario(){
        String url = "http://192.168.1.57/Aplicacion/registrar.php?names=" +txtNames.getText().toString()+"&user="+ txtUser.getText().toString() +
                "&pwd=" + txtPwd.getText().toString();

        jrq = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        rq.add(jrq);
    }


}