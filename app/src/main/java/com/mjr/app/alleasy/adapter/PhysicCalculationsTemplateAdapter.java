package com.mjr.app.alleasy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mjr.app.alleasy.R;
import com.mjr.app.alleasy.model.Data;

import java.util.ArrayList;

public class PhysicCalculationsTemplateAdapter
        extends RecyclerView.Adapter<PhysicCalculationsTemplateAdapter.ViewHolder> {

    private final Context context;
    public final ArrayList<Data> datas;
    
    public PhysicCalculationsTemplateAdapter (Context context, 
        ArrayList<Data> datas) {
        this.context = context;
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int p2) {
        return new ViewHolder(
                LayoutInflater.from(context)
                        .inflate(R.layout.card_physic_calculations_template, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.symbol.setText(datas.get(position).symbol);
        holder.unit.setText(datas.get(position).unit);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView symbol;
        public EditText value;
        private TextView unit;

        public ViewHolder(View itemView) {
            super(itemView);
            getViews(itemView);
        }

        private void getViews(@NonNull View itemView) {
            symbol = itemView.findViewById(R.id.symbol);
            value = itemView.findViewById(R.id.value);
            unit = itemView.findViewById(R.id.unit);
        }
    }
}
