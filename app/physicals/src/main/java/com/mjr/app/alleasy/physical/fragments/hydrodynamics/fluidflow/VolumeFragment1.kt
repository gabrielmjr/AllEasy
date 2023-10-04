package com.mjr.app.alleasy.physical.fragments.hydrodynamics.fluidflow

import com.mjr.app.alleasy.core.R.string.null_field
import com.mjr.app.alleasy.core.utils.Util
import com.mjr.app.alleasy.physical.AbstractPhysicalCalculation
import com.mjr.app.alleasy.physical.moldels.Data
import com.mjr.app.alleasy.physical.adapters.PhysicCalculationsTemplateAdapter
import com.mjr.twaire.code.physic.hydrodynamics.fluidflow.Volume

class VolumeFragment1: AbstractPhysicalCalculation() {
    override fun setTemplateAttributes() {
        datas?.apply {
            add(Data("∆t = ", "s"))
            add(Data("Q = ", "m³/s"))
        }
    }

    override fun onCalculateClickListener() {
        formula?.setOnClickListener{
            val deltaTimeEditText = (dataContainer.findViewHolderForAdapterPosition(0) as PhysicCalculationsTemplateAdapter.ViewHolder).value
            val flowRateEditText = (dataContainer.findViewHolderForAdapterPosition(1) as PhysicCalculationsTemplateAdapter.ViewHolder).value
            val deltaTimeString = deltaTimeEditText.text.toString()
            val flowRateString = flowRateEditText.text.toString()
            if (Util.isEmpty(deltaTimeString)) {
                deltaTimeEditText.error = getText(null_field)
                return@setOnClickListener
            }
            if (Util.isEmpty(flowRateString)) {
                flowRateEditText.error = getText(null_field)
                return@setOnClickListener
            }
            calculate(deltaTimeString, flowRateString)
        }
        formula?.text = (calculation as Volume).formula
    }

    private fun calculate(deltaTimeString: String, flowRateString: String) {
        resolution?.text = (calculation as Volume).apply {
            deltaTime = java.lang.Double.parseDouble(deltaTimeString)
            flowRate = java.lang.Double.parseDouble(flowRateString)
            calculate()
        }.steps
    }
}