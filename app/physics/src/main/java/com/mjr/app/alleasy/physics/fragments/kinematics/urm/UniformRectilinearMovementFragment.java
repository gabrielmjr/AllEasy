package com.mjr.app.alleasy.physics.fragments.kinematics.urm;

import com.mjr.app.alleasy.core.SubtitlesFragment;
import com.mjr.app.alleasy.physics.R;
import com.mjr.app.alleasy.physics.moldels.PhysicalSubtitle;
import com.mjr.twaire.code.physic.kinematics.mru.MRU;

import java.util.Objects;

public class UniformRectilinearMovementFragment extends SubtitlesFragment {
        private URMDisplacement1Fragment displacement1Fragment;
        private URMDisplacement2Fragment displacement2Fragment;
        private URMDisplacement3Fragment displacement3Fragment;
        private URMDisplacement4Fragment displacement4Fragment;
        private URMDisplacement5Fragment displacement5Fragment;
        private URMDisplacement6Fragment displacement6Fragment;
        private URMSpeed1Fragment speed1Fragment;
        private URMSpeed2Fragment speed2Fragment;
        private URMTime1Fragment time1Fragment;
        private URMTime2Fragment time2Fragment;
        private URMTime3Fragment time3Fragment;
        private URMTime4Fragment time4Fragment;
        private URMTime5Fragment time5Fragment;

        @Override
        protected void initializeAttributes() {
                displacement1Fragment = new URMDisplacement1Fragment();
                displacement2Fragment = new URMDisplacement2Fragment();
                displacement3Fragment = new URMDisplacement3Fragment();
                displacement4Fragment = new URMDisplacement4Fragment();
                displacement5Fragment = new URMDisplacement5Fragment();
                displacement6Fragment = new URMDisplacement6Fragment();
                speed1Fragment = new URMSpeed1Fragment();
                speed2Fragment = new URMSpeed2Fragment();
                time1Fragment = new URMTime1Fragment();
                time2Fragment = new URMTime2Fragment();
                time3Fragment = new URMTime3Fragment();
                time4Fragment = new URMTime4Fragment();
                time5Fragment = new URMTime5Fragment();
                setCalculation(new MRU());
                super.initializeAttributes();
        }

        private void setCalculation(MRU mru) {
                displacement1Fragment.setCalculation(mru.displacement1());
                displacement2Fragment.setCalculation(mru.displacement2());
                displacement3Fragment.setCalculation(mru.displacement3());
                displacement4Fragment.setCalculation(mru.displacement4(0, 0));
                displacement5Fragment.setCalculation(mru.displacement5(0, 0));
                displacement6Fragment.setCalculation(mru.displacement6(0, 0, 0));
                speed1Fragment.setCalculation(mru.speed1(0, 0));
                speed2Fragment.setCalculation(mru.speed2(0, 0, 0, 0));
                time1Fragment.setCalculation(mru.time1(0, 0));
                time2Fragment.setCalculation(mru.time2(0, 0));
                time3Fragment.setCalculation(mru.time3(0, 0, 0));
                time4Fragment.setCalculation(mru.time4(0, 0));
                time5Fragment.setCalculation(mru.time5(0, 0));
        }

        @Override
        protected void initializeSubtitles() {
                Objects.requireNonNull(getSubtitles()).add(new PhysicalSubtitle(getText(R.string.kinematic_urm_displacement1), displacement1Fragment));
                getSubtitles().add(new PhysicalSubtitle(getText(R.string.kinematic_urm_displacement2), displacement2Fragment));
                getSubtitles().add(new PhysicalSubtitle(getText(R.string.kinematic_urm_displacement3), displacement3Fragment));
                getSubtitles().add(new PhysicalSubtitle(getText(R.string.kinematic_urm_displacement4), displacement4Fragment));
                getSubtitles().add(new PhysicalSubtitle(getText(R.string.kinematic_urm_displacement5), displacement5Fragment));
                getSubtitles().add(new PhysicalSubtitle(getText(R.string.kinematic_urm_displacement6), displacement6Fragment));
                getSubtitles().add(new PhysicalSubtitle(getText(R.string.kinematic_urm_speed1), new URMSpeed1Fragment()));
                getSubtitles().add(new PhysicalSubtitle(getText(R.string.kinematic_urm_speed2), new URMSpeed2Fragment()));
                getSubtitles().add(new PhysicalSubtitle(getText(R.string.kinematic_urm_time1), new URMTime1Fragment()));
                getSubtitles().add(new PhysicalSubtitle(getText(R.string.kinematic_urm_time2), new URMTime2Fragment()));
                getSubtitles().add(new PhysicalSubtitle(getText(R.string.kinematic_urm_time3), new URMTime3Fragment()));
                getSubtitles().add(new PhysicalSubtitle(getText(R.string.kinematic_urm_time4), new URMTime4Fragment()));
                getSubtitles().add(new PhysicalSubtitle(getText(R.string.kinematic_urm_time5), new URMTime5Fragment()));
        }
}