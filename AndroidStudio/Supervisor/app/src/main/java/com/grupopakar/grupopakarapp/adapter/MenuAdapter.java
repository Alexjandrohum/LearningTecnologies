package com.grupopakar.grupopakarapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.grupopakar.grupopakarapp.R;
import com.grupopakar.grupopakarapp.activity.Inicio;
import com.grupopakar.grupopakarapp.dto.MenuDTO;

public class MenuAdapter extends RecyclerView.Adapter {
    private MenuDTO[] elementos;
    private final Context context;
    private int focusedItem = 0;

    public MenuAdapter(MenuDTO[] elementos, Context context) {
        this.elementos = elementos;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MenuHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.elemento_menu, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((MenuHolder) holder).bind(elementos[position]);
    }

    @Override
    public int getItemCount() {
        return elementos.length;
    }

    public void setChecked(int position) {
        int temp = focusedItem;
        focusedItem = position;
        notifyItemChanged(temp);
        notifyItemChanged(focusedItem);
    }

    public void clear() {
        elementos = null;
        notifyDataSetChanged();
    }

    public void setBadge(int i, int count) {
        elementos[i].setUnread(count);
        notifyDataSetChanged();
    }

    private class MenuHolder extends RecyclerView.ViewHolder {
        final RelativeLayout layout;
        final TextView tvTitulo;

        MenuHolder(View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.layout);
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
        }

        void bind(MenuDTO menu) {
            tvTitulo.setText(menu.getTitulo());
            if (focusedItem != getLayoutPosition()) {
                layout.setBackgroundColor(context.getResources().getColor(R.color.azul_oscuro_scpakar));
            } else {
                layout.setBackgroundColor(context.getResources().getColor(R.color.yellow_a400));
            }
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    layout.setBackgroundColor(context.getResources().getColor(R.color.yellow_a400));
                    notifyItemChanged(focusedItem);
                    focusedItem = getLayoutPosition();
                    notifyItemChanged(focusedItem);
                    ((Inicio) context).setNavigationMenuItem(getLayoutPosition());
                }
            });
        }
    }
}
