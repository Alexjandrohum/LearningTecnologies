package com.grupopakar.grupopakarapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.grupopakar.grupopakarapp.R;
import com.grupopakar.grupopakarapp.activity.Modulos;
import com.grupopakar.grupopakarapp.dto.TiendaDTO;
import com.grupopakar.grupopakarapp.util.Mensaje;

import java.util.List;

/**
 * Created by antonio.ruiz on 2019-05-06
 */
public class TabTiendasAdapter extends RecyclerView.Adapter {
    private List<TiendaDTO> tiendas;
    private Context context;

    public TabTiendasAdapter(Context context, List<TiendaDTO> tiendas) {
        this.tiendas = tiendas;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TiendasHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento_tienda, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((TiendasHolder) holder).bind(tiendas.get(position));
    }

    @Override
    public int getItemCount() {
        return tiendas.size();
    }

    public void setItems(List<TiendaDTO> tiendas) {
        this.tiendas = tiendas;
        notifyDataSetChanged();
    }

    private class TiendasHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        private final TextView tvNombre;
        private final LinearLayout layout;

        TiendasHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            layout = itemView.findViewById(R.id.layout);
            layout.setOnClickListener(this);
            layout.setOnLongClickListener(this);
        }

        void bind(TiendaDTO tienda) {
            tvNombre.setText(tienda.getNombreTienda());
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.layout) {
                Intent intent = new Intent(context, Modulos.class);
                intent.putExtra("tienda", tiendas.get(getAdapterPosition()));
                context.startActivity(intent);
            }
        }

        @Override
        public boolean onLongClick(View v) {
            Mensaje.muestraMensajeCorto(context, tiendas.get(getAdapterPosition()).toString());
            return true;
        }
    }
}
