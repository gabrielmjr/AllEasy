package com.mjr.app.alleasy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mjr.app.alleasy.R;
import com.mjr.app.alleasy.model.Subtitle;

import java.util.List;

public class SubtitlesAdapter extends RecyclerView.Adapter<SubtitlesAdapter.ViewHolder> {
	private final Context context;
	private final List<Subtitle> subTitles;
	private final OnSubtitleClickListener subtitleClickListener;
	
	public SubtitlesAdapter(Context context,
							List<Subtitle> subTitles,
							OnSubtitleClickListener subtitleClickListener) {
		this.context = context;
		this.subTitles = subTitles;
		this.subtitleClickListener = subtitleClickListener;
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int p2) {
		return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.card_subtitles, parent, false));
	}

	@Override
    public void onBindViewHolder(ViewHolder holder, int position) {
		holder.label.setText(subTitles.get(position).label);
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
		
		private void getViews (@NonNull View itemView) {
			label = itemView.findViewById(R.id.label);
		}
		
		private void setListeners(@NonNull View itemView) {
			itemView.setOnClickListener(this);
		}
		
		@Override
		public void onClick(View view) {
			if (getAdapterPosition() == RecyclerView.NO_POSITION) 
				return;
			subtitleClickListener.onSubtitleClick((getAdapterPosition()));
		}
	}
	
	public interface OnSubtitleClickListener {
		void onSubtitleClick(int position);
	}
}
