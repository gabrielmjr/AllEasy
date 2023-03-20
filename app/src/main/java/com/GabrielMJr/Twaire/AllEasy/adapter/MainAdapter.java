package com.GabrielMJr.Twaire.AllEasy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.GabrielMJr.Twaire.AllEasy.R;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
	private Context context;
	private List<CharSequence> optionsItems;

	public MainAdapter(Context context,
					   List<CharSequence> optionsItems) {
		this.context = context;
		this.optionsItems = optionsItems;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int p2) {
		return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.card_main, parent, false));
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		holder.label.setText(optionsItems.get(position));
	}

	@Override
	public int getItemCount() {
		return optionsItems.size();
	}

    public class ViewHolder extends RecyclerView.ViewHolder {
		private TextView label;

		public ViewHolder(View itemView) {
			super(itemView);
			getViews(itemView);
		}

		private void getViews(View itemView) {
			label = itemView.findViewById(R.id.label);
		}
	}
}
