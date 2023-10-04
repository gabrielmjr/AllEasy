package com.mjr.app.alleasy.physical.fragments.hydrodynamics.fluidflow;

import com.mjr.app.alleasy.core.SubtitlesFragment;
import com.mjr.app.alleasy.physical.moldels.PhysicalSubtitle;
import com.mjr.twaire.code.physic.hydrodynamics.fluidflow.Area;
import com.mjr.twaire.code.physic.hydrodynamics.fluidflow.FlowRate1;
import com.mjr.twaire.code.physic.hydrodynamics.fluidflow.FlowRate2;
import com.mjr.twaire.code.physic.hydrodynamics.fluidflow.FlowRate3;
import com.mjr.twaire.code.physic.hydrodynamics.fluidflow.FluidFlow;
import com.mjr.twaire.code.physic.hydrodynamics.fluidflow.Ray;
import com.mjr.twaire.code.physic.hydrodynamics.fluidflow.Speed1;
import com.mjr.twaire.code.physic.hydrodynamics.fluidflow.Speed2;
import com.mjr.twaire.code.physic.hydrodynamics.fluidflow.Time;
import com.mjr.twaire.code.physic.hydrodynamics.fluidflow.Volume;

import java.util.Objects;

public class FluidFlowFragment extends SubtitlesFragment {
    private AreaFragment1 areaFragment1;
    private FlowRateFragment1 flowRateFragment1;
    private FlowRateFragment2 flowRateFragment2;
    private FlowRateFragment3 flowRateFragment3;
    private RayFragment1 rayFragment1;
    private SpeedFragment1 speedFragment1;
    private SpeedFragment2 speedFragment2;
    private TimeFragment1 timeFragment1;
    private VolumeFragment1 volumeFragment1;

    private Area area;
    private FlowRate1 flowRate1;
    private FlowRate2 flowRate2;
    private FlowRate3 flowRate3;
    private Ray ray;
    private Speed1 speed1;
    private Speed2 speed2;
    private Time time;
    private Volume volume;
    
    @Override
    protected void initializeAttributes() {
        areaFragment1 = new AreaFragment1();
        flowRateFragment1 = new FlowRateFragment1();
        flowRateFragment2 = new FlowRateFragment2();
        flowRateFragment3 = new FlowRateFragment3();
        rayFragment1 = new RayFragment1();
        speedFragment1 = new SpeedFragment1();
        speedFragment2 = new SpeedFragment2();
        timeFragment1 = new TimeFragment1();
        volumeFragment1 = new VolumeFragment1();
        FluidFlow fluidFlow = new FluidFlow();
        area = fluidFlow.area();
        flowRate1 = fluidFlow.flowRate1();
        flowRate2 = fluidFlow.flowRate2();
        flowRate3 = fluidFlow.flowRate3();
        ray = fluidFlow.ray();
        speed1 = fluidFlow.speed1();
        speed2 = fluidFlow.speed2();
        time = fluidFlow.time();
        volume = fluidFlow.volume();
        setCalculation();
        super.initializeAttributes();
    }
    
    private void setCalculation() {
        areaFragment1.setCalculation(area);
        flowRateFragment1.setCalculation(flowRate1);
        flowRateFragment2.setCalculation(flowRate2);
        flowRateFragment3.setCalculation(flowRate3);
        rayFragment1.setCalculation(ray);
        speedFragment1.setCalculation(speed1);
        speedFragment2.setCalculation(speed2);
        timeFragment1.setCalculation(time);
        volumeFragment1.setCalculation(volume);
    }
    
    @Override
    protected void initializeSubtitles() {
        Objects.requireNonNull(getSubtitles()).add(new PhysicalSubtitle(areaFragment1));
        getSubtitles().add(new PhysicalSubtitle(flowRateFragment1));
        getSubtitles().add(new PhysicalSubtitle(flowRateFragment2));
        getSubtitles().add(new PhysicalSubtitle(flowRateFragment3));
        getSubtitles().add(new PhysicalSubtitle(rayFragment1));
        getSubtitles().add(new PhysicalSubtitle(speedFragment1));
        getSubtitles().add(new PhysicalSubtitle(speedFragment2));
        getSubtitles().add(new PhysicalSubtitle(timeFragment1));
        getSubtitles().add(new PhysicalSubtitle(volumeFragment1));
    }
}
