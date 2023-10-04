package com.mjr.app.alleasy.physical.fragments.hydrodynamics

import com.mjr.app.alleasy.core.SubtitlesFragment
import com.mjr.app.alleasy.core.model.Subtitle
import com.mjr.app.alleasy.physical.R
import com.mjr.app.alleasy.physical.fragments.hydrodynamics.fluidflow.FluidFlowFragment
import java.util.Objects

class HydrodynamicsFragment : SubtitlesFragment() {
    override fun initializeSubtitles() {
        subtitles!!.add(Subtitle(getText(R.string.fluid_flow), FluidFlowFragment()))
    }
}