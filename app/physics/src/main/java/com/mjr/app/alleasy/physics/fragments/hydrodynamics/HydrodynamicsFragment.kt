package com.mjr.app.alleasy.physics.fragments.hydrodynamics

import com.mjr.app.alleasy.core.SubtitlesFragment
import com.mjr.app.alleasy.core.model.Subtitle
import com.mjr.app.alleasy.physics.R
import com.mjr.app.alleasy.physics.fragments.hydrodynamics.fluidflow.FluidFlowFragment

class HydrodynamicsFragment : SubtitlesFragment() {
    override fun initializeSubtitles() {
        subtitles!!.add(Subtitle(getText(R.string.fluid_flow), FluidFlowFragment()))
    }
}