package com.mjr.app.alleasy.fragment.physics.hydrodynamics.fluidflow

import com.mjr.app.alleasy.R
import com.mjr.app.alleasy.activity.AbstractPhysicalCalculation
import com.mjr.app.alleasy.model.Data
import com.mjr.app.alleasy.adapter.PhysicCalculationsTemplateAdapter
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
            if (com.mjr.app.alleasy.utils.Util.isEmpty(areaString)) {
                areaEditText.error = getText(R.string.null_field)
                return@setOnClickListener
            }
            if (com.mjr.app.alleasy.utils.Util.isEmpty(velocityString)) {
                velocityEditText.error = getText(R.string.null_field)
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