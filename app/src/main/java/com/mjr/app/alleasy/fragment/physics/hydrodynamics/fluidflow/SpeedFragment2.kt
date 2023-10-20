package com.mjr.app.alleasy.fragment.physics.hydrodynamics.fluidflow

import com.mjr.app.alleasy.R
import com.mjr.app.alleasy.model.Data
import com.mjr.app.alleasy.activity.AbstractPhysicalCalculation
import com.mjr.app.alleasy.adapter.PhysicCalculationsTemplateAdapter
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
            if (com.mjr.app.alleasy.utils.Util.isEmpty(flowRateString)) {
                flowRateEditText.error = getText(R.string.null_field)
                return@setOnClickListener
            }
            if (com.mjr.app.alleasy.utils.Util.isEmpty(rayString)) {
                rayEditText.error = getText(R.string.null_field)
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