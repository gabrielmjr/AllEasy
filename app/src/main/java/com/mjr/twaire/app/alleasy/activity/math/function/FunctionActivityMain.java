package com.mjr.twaire.app.alleasy.activity.math.function;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.activity.BaseActivity;
import com.mjr.twaire.app.alleasy.adapter.SubTitlesAdapter;
import com.mjr.twaire.app.alleasy.adapter.SubTitlesAdapter.OnSubtitleClickListener;
import com.mjr.twaire.app.alleasy.model.Activity;
import java.util.ArrayList;
import java.util.List;

public class FunctionActivityMain extends BaseActivity implements OnSubtitleClickListener {
    private RecyclerView subTitleRecycler;
    private SubTitlesAdapter subtitlesAdapter;
    private List<Activity> subTitles;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
    }

    @Override
    protected void initializeActivity () {
        setContentView(R.layout.activity_subtitles);
    }

    @Override
    protected void getViews() {
        setToolBar((Toolbar)findViewById(R.id.toolbar));
        subTitleRecycler = findViewById(R.id.subtitles_recycler_view);
    }

    @Override 
    protected void initializeAttributes() {
        subTitles = new ArrayList<>();
        subtitlesAdapter = new SubTitlesAdapter(getApplicationContext(), subTitles, this);
        buildRecyclerView();
    }

    private void buildRecyclerView() {
        subTitles.add(new Activity(getText(R.string.second_degree_function), FSG.class));
        subTitleRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        subTitleRecycler.setAdapter(subtitlesAdapter);
    }

    @Override
    public void onSubTitleClick(int position) {
        startActivity(new Intent(getApplicationContext(), subTitles.get(position).getClassId()));
    }
}
