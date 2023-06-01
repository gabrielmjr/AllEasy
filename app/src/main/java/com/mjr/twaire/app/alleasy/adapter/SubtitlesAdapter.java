package com.mjr.twaire.app.alleasy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.model.Subtitle;
import java.util.List;

public class SubtitlesAdapter extends RecyclerView.Adapter<SubtitlesAdapter.ViewHolder> {
	private Context context;
	private List<Subtitle> subTitles;
	private OnSubtitleClickListener subtitleClickListener;
	
	public SubtitlesAdapter(Context context,
							List<Subtitle> subTitles,
							OnSubtitleClickListener subtitleClickListener) {
		this.context = context;
		this.subTitles = subTitles;
		this.subtitleClickListener = subtitleClickListener;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int p2) {
		return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.card_subtitles, parent, false));
	}

	@Override
    public void onBindViewHolder(ViewHolder holder, int position) {
		holder.label.setText(subTitles.get(position).getLabel());
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
			subtitleClickListener.onSubtitleClick((getAdapterPosition()));
		}
	}
	
	public interface OnSubtitleClickListener {
		public void onSubtitleClick(int position);
	}
}
