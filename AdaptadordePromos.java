package com.example.jorge.adaptable;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * {@link BaseAdapter} para poblar Promos en un grid view
 */

public class AdaptadordePromos extends BaseAdapter {
    private Context context;

    public AdaptadordePromos(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return Promo.ITEMS.length;
    }

    @Override
    public Promo getItem(int position) {
        return Promo.ITEMS[position];
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.grid_item, viewGroup, false);
        }

        ImageView imagenPromo = (ImageView) view.findViewById(R.id.imagen_promo);
        TextView nombrePromo = (TextView) view.findViewById(R.id.nombre_promo);

        final Promo item = getItem(position);
        Glide.with(imagenPromo.getContext())
                .load(item.getIdDrawable())
                .into(imagenPromo);

        nombrePromo.setText(item.getNombre());

        return view;
    }

}