package com.mjr.app.alleasy.fragment

import com.mjr.app.alleasy.R
import com.mjr.app.alleasy.fragment.physics.hydrodynamics.HydrodynamicsFragment
import com.mjr.app.alleasy.fragment.physics.kinematics.KinematicsFragment
import com.mjr.app.alleasy.model.Subtitle
class HomeFragment: SubtitlesFragment() {
    override fun initializeSubtitles() {
        subtitles?.apply {
            add(Subtitle(requireContext().getText(R.string.hydrodynamics),
                HydrodynamicsFragment()
            ))
            add(Subtitle(requireContext().getText(R.string.kinematics),
                KinematicsFragment()
            ))
        }
    }
}