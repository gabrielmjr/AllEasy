package com.mjr.app.alleasy.fragment.physics.hydrodynamics.fluidflow

import com.mjr.app.alleasy.R
import com.mjr.app.alleasy.model.Data
import com.mjr.app.alleasy.activity.AbstractPhysicalCalculation
import com.mjr.app.alleasy.adapter.PhysicCalculationsTemplateAdapter
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
            if (com.mjr.app.alleasy.utils.Util.isEmpty(volumeString)) {
                volumeEditText.error = getText(R.string.null_field)
                return@setOnClickListener
            }
            if (com.mjr.app.alleasy.utils.Util.isEmpty(flowRateString)) {
                flowRateEditText.error = getText(R.string.null_field)
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