package com.mjr.twaire.app.alleasy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.model.Data;
import java.util.ArrayList;

public class PhysicCalculationsTemplateAdapter
        extends RecyclerView.Adapter<PhysicCalculationsTemplateAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Data> datas;
    
    public PhysicCalculationsTemplateAdapter (Context context, 
        ArrayList<Data> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int p2) {
        return new ViewHolder(
                LayoutInflater.from(context)
                        .inflate(R.layout.card_physic_calculations_template, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.symbol.setText(datas.get(position).getSymbol());
        holder.unit.setText(datas.get(position).getUnit());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView symbol;
        private EditText value;
        private TextView unit;

        public ViewHolder(View itemView) {
            super(itemView);
            getViews(itemView);
        }

        private void getViews(View itemView) {
            symbol = itemView.findViewById(R.id.symbol);
            value = itemView.findViewById(R.id.value);
            unit = itemView.findViewById(R.id.unit);
        }
    }
}
