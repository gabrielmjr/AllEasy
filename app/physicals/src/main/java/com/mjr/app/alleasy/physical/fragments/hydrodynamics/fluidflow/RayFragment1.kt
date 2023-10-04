package com.mjr.app.alleasy.physical.fragments.hydrodynamics.fluidflow

import com.mjr.app.alleasy.core.R.string.null_field
import com.mjr.app.alleasy.core.utils.Util
import com.mjr.app.alleasy.physical.moldels.Data
import com.mjr.app.alleasy.physical.AbstractPhysicalCalculation
import com.mjr.app.alleasy.physical.adapters.PhysicCalculationsTemplateAdapter
import com.mjr.twaire.code.physic.hydrodynamics.fluidflow.Ray

class RayFragment1: AbstractPhysicalCalculation() {
    override fun setTemplateAttributes() {
        datas?.apply {
            add(Data("Q = ", "m³/s"))
            add(Data("A = ", "m²"))
        }
        formula?.text = (calculation as Ray).formula
    }

    override fun onCalculateClickListener() {
        formula?.setOnClickListener{
            val flowRateEditText = (dataContainer.findViewHolderForAdapterPosition(0) as PhysicCalculationsTemplateAdapter.ViewHolder).value
            val velocityEditText = (dataContainer.findViewHolderForAdapterPosition(1) as PhysicCalculationsTemplateAdapter.ViewHolder).value
            val flowRateString = flowRateEditText.text.toString()
            val velocityString = velocityEditText.text.toString()
            if (Util.isEmpty(flowRateString)) {
                flowRateEditText.error = getText(null_field)
                return@setOnClickListener
            }
            if (Util.isEmpty(velocityString)) {
                velocityEditText.error = getText(null_field)
                return@setOnClickListener
            }
            calculate(flowRateString, velocityString)
        }
    }

    private fun calculate(flowRateString: String, velocityString: String) {
        resolution?.text = (calculation as Ray).apply {
            flowRate = java.lang.Double.parseDouble(flowRateString)
            velocity = java.lang.Double.parseDouble(velocityString)
            calculate()
        }.steps
    }
}