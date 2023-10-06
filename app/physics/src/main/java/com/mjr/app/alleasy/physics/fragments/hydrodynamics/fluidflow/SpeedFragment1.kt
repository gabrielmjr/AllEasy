package com.mjr.app.alleasy.physics.fragments.hydrodynamics.fluidflow

import com.mjr.app.alleasy.core.R.string.null_field
import com.mjr.app.alleasy.core.utils.Util
import com.mjr.app.alleasy.physics.moldels.Data
import com.mjr.app.alleasy.physics.AbstractPhysicalCalculation
import com.mjr.app.alleasy.physics.adapters.PhysicCalculationsTemplateAdapter
import com.mjr.twaire.code.physic.hydrodynamics.fluidflow.Speed1

class SpeedFragment1: AbstractPhysicalCalculation() {
    override fun setTemplateAttributes() {
        datas?.apply {
            add(Data("Q = ", "m³/s"))
            add(Data("A = ", "m²"))
        }
        formula?.text = (calculation as Speed1).formula
    }

    override fun onCalculateClickListener() {
        formula?.setOnClickListener{
            val flowRateEditText = (dataContainer.findViewHolderForAdapterPosition(0) as PhysicCalculationsTemplateAdapter.ViewHolder).value
            val areaEditText = (dataContainer.findViewHolderForAdapterPosition(1) as PhysicCalculationsTemplateAdapter.ViewHolder).value
            val flowRateString = flowRateEditText.text.toString()
            val areaString = areaEditText.text.toString()
            if (Util.isEmpty(flowRateString)) {
                flowRateEditText.error = getText(null_field)
                return@setOnClickListener
            }
            if (Util.isEmpty(areaString)) {
                areaEditText.error = getText(null_field)
                return@setOnClickListener
            }
            calculate(flowRateString, areaString)
        }
    }

    private fun calculate(flowRateString: String, areaString: String) {
        resolution?.text = (calculation as Speed1).apply {
            flowRate = java.lang.Double.parseDouble(flowRateString)
            area = java.lang.Double.parseDouble(areaString)
            calculate()
        }.steps
    }
}