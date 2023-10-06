package com.mjr.app.alleasy.physics.fragments.hydrodynamics.fluidflow

import com.mjr.app.alleasy.core.R.string.null_field
import com.mjr.app.alleasy.core.utils.Util
import com.mjr.app.alleasy.physics.moldels.Data
import com.mjr.app.alleasy.physics.AbstractPhysicalCalculation
import com.mjr.app.alleasy.physics.adapters.PhysicCalculationsTemplateAdapter
import com.mjr.twaire.code.physic.hydrodynamics.fluidflow.Time

class TimeFragment1: AbstractPhysicalCalculation() {
    override fun setTemplateAttributes() {
        datas?.apply {
            add(Data("V = ", "m³"))
            add(Data("Q = ", "m³/s"))
        }
        formula?.text = (calculation as Time).formula
    }

    override fun onCalculateClickListener() {
        formula?.setOnClickListener{
            val volumeEditText = (dataContainer.findViewHolderForAdapterPosition(0) as PhysicCalculationsTemplateAdapter.ViewHolder).value
            val flowRateEditText = (dataContainer.findViewHolderForAdapterPosition(1) as PhysicCalculationsTemplateAdapter.ViewHolder).value
            val volumeString = volumeEditText.text.toString()
            val flowRateString = flowRateEditText.text.toString()
            if (Util.isEmpty(volumeString)) {
                volumeEditText.error = getText(null_field)
                return@setOnClickListener
            }
            if (Util.isEmpty(flowRateString)) {
                flowRateEditText.error = getText(null_field)
                return@setOnClickListener
            }
            calculate(volumeString, flowRateString)
        }
    }

    private fun calculate(volumeString: String, flowRateString: String) {
        resolution?.text = (calculation as Time).apply {
            volume = java.lang.Double.parseDouble(volumeString)
            flowRate = java.lang.Double.parseDouble(flowRateString)
            calculate()
        }.steps
    }
}