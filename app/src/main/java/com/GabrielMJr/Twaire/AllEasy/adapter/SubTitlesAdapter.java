package com.GabrielMJr.Twaire.AllEasy.adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.GabrielMJr.Twaire.AllEasy.R;
import java.util.List;

public class SubTitlesAdapter extends RecyclerView.Adapter<SubTitlesAdapter.ViewHolder> {
	private Context context;
	private List<String> subTitles;
	private OnSubtitleClickListener subTitleClickListener;
	
	public SubTitlesAdapter(Context context,
							List<String> subTitles,
							OnSubtitleClickListener subTitleClickListener) {
		this.context = context;
		this.subTitles = subTitles;
		this.subTitleClickListener = subTitleClickListener;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int p2) {
		return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.card_subtitles, parent, false));
	}

	@Override
    public void onBindViewHolder(ViewHolder holder, int position) {
		holder.label.setText(subTitles.get(position));
	}

	@Override
	public int getItemCount() {
		return subTitles.size();
	}

    public class ViewHolder extends RecyclerView.ViewHolder implements OnClickListener {
		private TextView label;
		
		public ViewHolder(View itemView) {
			super(itemView);
			getViews(itemView);
			setListeners(itemView);
		}
		
		private void getViews (View itemView) {
			label = itemView.findViewById(R.id.label);
		}
		
		private void setListeners(View itemView) {
			itemView.setOnClickListener(this);
		}
		
		@Override
		public void onClick(View view) {
			if (getAdapterPosition() == RecyclerView.NO_POSITION) 
				return;
			subTitleClickListener.onItemClickListener(getAdapterPosition());
		}
	}
	
	public static interface OnSubtitleClickListener {
		public void onItemClickListener(int position)
	}
}
