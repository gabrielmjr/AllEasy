package com.mjr.app.alleasy.physical.fragments.hydrodynamics.fluidflow

import com.mjr.app.alleasy.core.R.string.null_field
import com.mjr.app.alleasy.core.utils.Util
import com.mjr.app.alleasy.physical.moldels.Data
import com.mjr.app.alleasy.physical.AbstractPhysicalCalculation
import com.mjr.app.alleasy.physical.adapters.PhysicCalculationsTemplateAdapter
import com.mjr.twaire.code.physic.hydrodynamics.fluidflow.Speed2

class SpeedFragment2: AbstractPhysicalCalculation() {
    override fun setTemplateAttributes() {
        datas?.apply {
            add(Data("V = ", "m³"))
            add(Data("Q = ", "m³/s"))
        }
        formula?.text = (calculation as Speed2).formula
    }

    override fun onCalculateClickListener() {
        formula?.setOnClickListener{
            val flowRateEditText = (dataContainer.findViewHolderForAdapterPosition(0) as PhysicCalculationsTemplateAdapter.ViewHolder).value
            val rayEditText = (dataContainer.findViewHolderForAdapterPosition(1) as PhysicCalculationsTemplateAdapter.ViewHolder).value
            val flowRateString = flowRateEditText.text.toString()
            val rayString = rayEditText.text.toString()
            if (Util.isEmpty(flowRateString)) {
                flowRateEditText.error = getText(null_field)
                return@setOnClickListener
            }
            if (Util.isEmpty(rayString)) {
                rayEditText.error = getText(null_field)
                return@setOnClickListener
            }
            calculate(flowRateString, rayString)
        }
    }

    private fun calculate(flowRateString: String, rayString: String) {
        resolution?.text = (calculation as Speed2).apply {
            flowRate = java.lang.Double.parseDouble(flowRateString)
            ray = java.lang.Double.parseDouble(rayString)
            calculate()
        }.steps
    }
}