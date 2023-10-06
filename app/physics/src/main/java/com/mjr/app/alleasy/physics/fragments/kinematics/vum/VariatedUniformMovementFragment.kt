package com.mjr.app.alleasy.physics.fragments.kinematics.vum

import com.mjr.app.alleasy.core.SubtitlesFragment
import com.mjr.app.alleasy.physics.R
import com.mjr.app.alleasy.physics.moldels.PhysicalSubtitle

class VariatedUniformMovementFragment : SubtitlesFragment() {
    override fun initializeSubtitles() {
        subtitles!!.apply {
            add(PhysicalSubtitle(getText(R.string.kinematic_vum_acceleration1), VUMAcceleration1()))
            add(PhysicalSubtitle(getText(R.string.kinematic_vum_acceleration2), VUMAcceleration2()))
            add(PhysicalSubtitle(getText(R.string.kinematic_vum_acceleration3), VUMAcceleration3()))
            add(PhysicalSubtitle(getText(R.string.kinematic_vum_acceleration4), VUMAcceleration4()))
            add(PhysicalSubtitle(getText(R.string.kinematic_vum_speed1), VUMSpeed1()))
            add(PhysicalSubtitle(getText(R.string.kinematic_vum_speed2), VUMSpeed2()))
            add(PhysicalSubtitle(getText(R.string.kinematic_vum_speed3), VUMSpeed3()))
            add(PhysicalSubtitle(getText(R.string.kinematic_vum_speed4), VUMSpeed4()))
            add(PhysicalSubtitle(getText(R.string.kinematic_vum_time1), VUMTime1()))
            add(PhysicalSubtitle(getText(R.string.kinematic_vum_time2), VUMTime2()))
            add(PhysicalSubtitle(getText(R.string.kinematic_vum_time3), VUMTime3()))
            add(PhysicalSubtitle(getText(R.string.kinematic_vum_time4), VUMTime4()))
            add(PhysicalSubtitle(getText(R.string.kinematic_vum_time5), VUMTime5()))
            add(PhysicalSubtitle(getText(R.string.kinematic_vum_time6), VUMTime6()))
        }
    }
}