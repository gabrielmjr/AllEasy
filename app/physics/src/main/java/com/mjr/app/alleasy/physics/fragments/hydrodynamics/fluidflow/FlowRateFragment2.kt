package com.mjr.app.alleasy.physics.fragments.hydrodynamics.fluidflow

import com.mjr.app.alleasy.core.R.string.null_field
import com.mjr.app.alleasy.core.utils.Util
import com.mjr.app.alleasy.physics.AbstractPhysicalCalculation
import com.mjr.app.alleasy.physics.moldels.Data
import com.mjr.app.alleasy.physics.adapters.PhysicCalculationsTemplateAdapter
import com.mjr.twaire.code.physic.hydrodynamics.fluidflow.FlowRate2

class FlowRateFragment2: AbstractPhysicalCalculation() {
    override fun setTemplateAttributes() {
        datas?.apply {
            add(Data("A = ", "m²"))
            add(Data("v = ", "m/s"))
            formula?.text = (calculation as FlowRate2).formula
        }
    }

    override fun onCalculateClickListener() {
        formula?.setOnClickListener{
            val areaEditText = (dataContainer.findViewHolderForAdapterPosition(0) as PhysicCalculationsTemplateAdapter.ViewHolder).value
            val velocityEditText = (dataContainer.findViewHolderForAdapterPosition(1) as PhysicCalculationsTemplateAdapter.ViewHolder).value
            val areaString = areaEditText.text.toString()
            val velocityString = velocityEditText.text.toString()
            if (Util.isEmpty(areaString)) {
                areaEditText.error = getText(null_field)
                return@setOnClickListener
            }
            if (Util.isEmpty(velocityString)) {
                velocityEditText.error = getText(null_field)
                return@setOnClickListener
            }
            calculate(areaString, velocityString)
        }
    }

    private fun calculate(areaString: String, velocityString: String) {
        resolution?.text = (calculation as FlowRate2).apply {
            area = java.lang.Double.parseDouble(areaString)
            velocity = java.lang.Double.parseDouble(velocityString)
            calculate()
        }.steps
    }
}