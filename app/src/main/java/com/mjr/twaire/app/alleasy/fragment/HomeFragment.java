package com.mjr.twaire.app.alleasy.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.GridLayoutManager;
import com.mjr.twaire.app.alleasy.BaseFragment;
import com.mjr.twaire.app.alleasy.R;
import com.mjr.twaire.app.alleasy.activity.physic.vaz.FluidFlow_ActivityMain;
import com.mjr.twaire.app.alleasy.adapter.MainAdapter;
import com.mjr.twaire.app.alleasy.model.Subtitle;
import java.util.ArrayList;

public class HomeFragment extends BaseFragment implements MainAdapter.OnOptionsClickListener {
    private RecyclerView recyclerView;
    private MainAdapter mainAdapter;
    private ArrayList<Subtitle> optionsItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    protected void getViews() {
        recyclerView = getViewContainer().findViewById(R.id.main_recycler_view);
    }

    @Override
    protected void initializeAttributes() {
        optionsItems = new ArrayList<>();
        mainAdapter = new MainAdapter(getActivity().getApplicationContext(), optionsItems, this);
        initializeSubtitles();
    }

    private void initializeSubtitles() {
        optionsItems.add(new Subtitle(getText(R.string.combinatorial_analysis), FluidFlow_ActivityMain.class));
        optionsItems.add(new Subtitle(getText(R.string.kinematics), FluidFlow_ActivityMain.class));
        optionsItems.add(new Subtitle(getText(R.string.functions), FluidFlow_ActivityMain.class));
        optionsItems.add(new Subtitle(getText(R.string.fluid_flow), FluidFlow_ActivityMain.class));
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 3));
        recyclerView.setAdapter(mainAdapter);
    }

    @Override
    public void onOptionsClick(int position) {
    	startActivity(new Intent(getActivity().getApplicationContext(), optionsItems.get(position).getClassId()));
    }
}