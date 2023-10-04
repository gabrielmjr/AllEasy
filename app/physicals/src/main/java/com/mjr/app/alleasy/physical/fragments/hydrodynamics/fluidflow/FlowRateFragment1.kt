package com.mjr.app.alleasy.physical.fragments.hydrodynamics.fluidflow

import com.mjr.app.alleasy.core.R.string.null_field
import com.mjr.app.alleasy.physical.moldels.Data
import com.mjr.app.alleasy.core.utils.Util
import com.mjr.app.alleasy.physical.AbstractPhysicalCalculation
import com.mjr.app.alleasy.physical.adapters.PhysicCalculationsTemplateAdapter
import com.mjr.twaire.code.physic.hydrodynamics.fluidflow.FlowRate1

class FlowRateFragment1: AbstractPhysicalCalculation() {
    override fun setTemplateAttributes() {
        datas.apply {
            add(Data("v = ", "m³"))
            add(Data("∆t = ", "s"))
            formula.text = (calculation as FlowRate1).formula
        }
    }

    override fun onCalculateClickListener() {
        formula?.setOnClickListener{
            val volumeEditText = (dataContainer.findViewHolderForAdapterPosition(0) as PhysicCalculationsTemplateAdapter.ViewHolder).value
            val deltaTimeEditText = (dataContainer.findViewHolderForAdapterPosition(1) as PhysicCalculationsTemplateAdapter.ViewHolder).value
            val volumeString = volumeEditText.text.toString()
            val deltaTimeString = deltaTimeEditText.text.toString()
            if (Util.isEmpty(volumeString)) {
                volumeEditText.error = getText(null_field)
                return@setOnClickListener
            }
            if (Util.isEmpty(deltaTimeString)) {
                deltaTimeEditText.error = getText(null_field)
                return@setOnClickListener
            }
            calculate(volumeString, deltaTimeString)
        }
    }

    private fun calculate(volumeString: String, deltaTimeString: String) {
        resolution?.text = (calculation as FlowRate1).apply {
            volume  = java.lang.Double.parseDouble(volumeString)
            deltaTime = java.lang.Double.parseDouble(deltaTimeString)
            calculate()
        }.steps
    }
}