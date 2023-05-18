package com.mjr.twaire.app.alleasy.adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.model.Subtitle;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
	private Context context;
	private List<Subtitle> optionsItems;

	private OnOptionsClickListener optionsClickListener;

	public MainAdapter(Context context,
					   List<Subtitle> optionsItems,
					   OnOptionsClickListener optionsClickListener) {
		this.context = context;
		this.optionsItems = optionsItems;
		this.optionsClickListener = optionsClickListener;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int p2) {
		return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.card_main, parent, false));
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		holder.label.setText(optionsItems.get(position).getLabel());
	}

	@Override
	public int getItemCount() {
		return optionsItems.size();
	}

    public class ViewHolder extends RecyclerView.ViewHolder implements OnClickListener {
		private TextView label;

		public ViewHolder(View itemView) {
			super(itemView);
			getViews(itemView);
			setListeners(itemView);
		}

		private void getViews(View itemView) {
			label = itemView.findViewById(R.id.label);
		}

		private void setListeners(View itemView) {
			itemView.setOnClickListener(this);
		}

		@Override
		public void onClick(View view) {
			if (getAdapterPosition() == RecyclerView.NO_POSITION)
				return;
			optionsClickListener.onOptionsClick(getAdapterPosition());
		}
	}

	public static interface OnOptionsClickListener {
		public abstract void onOptionsClick(int position);
	}
}
