package com.GabrielMJr.Twaire.AllEasy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
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
	public SubTitlesAdapter.ViewHolder onCreateViewHolder(ViewGroup p1, int p2) {
		return null;
	}

	@Override
    public    void onBindViewHolder(SubTitlesAdapter.ViewHolder p1, int p2) {
	}

	@Override
	public int getItemCount() {
		return 0;
	}

    public class ViewHolder extends RecyclerView.ViewHolder implements OnClickListener {
		public ViewHolder(View itemView) {
			super(itemView);
			setListeners(itemView);
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
