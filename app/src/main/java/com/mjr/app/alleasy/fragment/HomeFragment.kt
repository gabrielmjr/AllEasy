package com.mjr.app.alleasy.fragment

import com.mjr.app.alleasy.physical.R
import com.mjr.app.alleasy.core.SubtitlesFragment
import com.mjr.app.alleasy.core.model.Subtitle
import com.mjr.app.alleasy.physical.fragments.hydrodynamics.HydrodynamicsFragment
import com.mjr.app.alleasy.physical.fragments.kinematics.KinematicsFragment

class HomeFragment: SubtitlesFragment() {
    override fun initializeSubtitles() {
        subtitles?.apply {
            add(Subtitle(requireContext().getText(R.string.hydrodynamics), HydrodynamicsFragment()))
            add(Subtitle(requireContext().getText(R.string.kinematics), KinematicsFragment()))
        }
    }
}