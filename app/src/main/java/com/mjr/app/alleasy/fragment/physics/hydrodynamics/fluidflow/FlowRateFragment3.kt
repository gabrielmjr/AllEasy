package com.mjr.app.alleasy.fragment.physics.hydrodynamics.fluidflow

import com.mjr.app.alleasy.R
import com.mjr.app.alleasy.activity.AbstractPhysicalCalculation
import com.mjr.app.alleasy.model.Data
import com.mjr.app.alleasy.adapter.PhysicCalculationsTemplateAdapter
import com.mjr.twaire.code.physic.hydrodynamics.fluidflow.FlowRate3

class FlowRateFragment3: AbstractPhysicalCalculation() {
    override fun setTemplateAttributes() {
        datas?.apply {
            add(Data("r = ", "m"))
            add(Data("v = ", "m/s"))
            add(Data("π = ", "3.14"))
        }
        formula?.text = (calculation as FlowRate3).formula
    }

    override fun onCalculateClickListener() {
        formula?.setOnClickListener{
            val rayEditText = (dataContainer.findViewHolderForAdapterPosition(0) as PhysicCalculationsTemplateAdapter.ViewHolder).value
            val velocityEditText = (dataContainer.findViewHolderForAdapterPosition(1) as PhysicCalculationsTemplateAdapter.ViewHolder).value
            val pi = 3.14
            val rayString = rayEditText.text.toString()
            val velocityString = velocityEditText.text.toString()
            if (com.mjr.app.alleasy.utils.Util.isEmpty(rayString)) {
                rayEditText.error = getText(R.string.null_field)
                return@setOnClickListener
            }
            if (com.mjr.app.alleasy.utils.Util.isEmpty(velocityString)) {
                velocityEditText.error = getText(R.string.null_field)
                return@setOnClickListener
            }
            calculate(rayString, velocityString)
        }
    }

    private fun calculate(rayString: String, velocityString: String) {
        resolution?.text = (calculation as FlowRate3).apply {
            ray = java.lang.Double.parseDouble(rayString)
            velocity = java.lang.Double.parseDouble(velocityString)
            calculate()
        }.steps
    }
}