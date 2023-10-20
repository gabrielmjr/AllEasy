package com.mjr.app.alleasy.fragment.physics.hydrodynamics

import com.mjr.app.alleasy.R
import com.mjr.app.alleasy.fragment.SubtitlesFragment
class HydrodynamicsFragment : SubtitlesFragment() {
    override fun initializeSubtitles() {
        subtitles!!.add(
            com.mjr.app.alleasy.model.Subtitle(
                getText(R.string.fluid_flow),
                com.mjr.app.alleasy.fragment.physics.hydrodynamics.fluidflow.FluidFlowFragment()
            )
        )
    }
}