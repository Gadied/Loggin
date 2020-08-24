package com.example.loggin.Adap;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.example.loggin.R;

public class GaleryImagen extends BaseAdapter {
    private Context mContext;
    public int[] imagenArray = {
            R.drawable.uno,
            R.drawable.dos,
            R.drawable.tres,
            R.drawable.cuatro,
            R.drawable.cinco,
            R.drawable.seis,
            R.drawable.siete,
            R.drawable.ocho,
            R.drawable.nueve,
            R.drawable.diez,
            R.drawable.once,
            R.drawable.doce,
            R.drawable.trece,
            R.drawable.catorse,

    };

    public GaleryImagen(Context mContext){

        this.mContext = mContext;
    }
    
    @Override
    public int getCount() {
        return imagenArray.length;
    }

    @Override
    public Object getItem(int i) {
        return imagenArray[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(imagenArray[i]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(
                new GridView.LayoutParams(
                        340,
                        350
                ));
        return imageView;
    }
}
