package com.mjr.app.alleasy.fragment.physics.hydrodynamics.fluidflow

import com.mjr.app.alleasy.R
import com.mjr.app.alleasy.utils.Util.isEmpty
import com.mjr.app.alleasy.activity.AbstractPhysicalCalculation
import com.mjr.app.alleasy.model.Data
import com.mjr.app.alleasy.adapter.PhysicCalculationsTemplateAdapter
import com.mjr.twaire.code.physic.hydrodynamics.fluidflow.Area

class AreaFragment1 : AbstractPhysicalCalculation() {
    override fun setTemplateAttributes() {
        datas?.apply {
            add(Data("Q = ", "m³/s"))
            add(Data("v = ", "m/s"))
        }
        formula?.text = (calculation as Area).formula
    }

    override fun onCalculateClickListener() {
        formula?.setOnClickListener{
            val flowRateEditText = (dataContainer.findViewHolderForAdapterPosition(0) as PhysicCalculationsTemplateAdapter.ViewHolder).value
            val velocityEditText = (dataContainer.findViewHolderForAdapterPosition(1) as PhysicCalculationsTemplateAdapter.ViewHolder).value
            val flowRateString = flowRateEditText.text.toString()
            val velocityString = velocityEditText.text.toString()
            if (isEmpty(flowRateString)) {
            flowRateEditText.error = getText(R.string.null_field)
            return@setOnClickListener
            }
            if (isEmpty(velocityString)) {
                velocityEditText.error = getText(R.string.null_field)
                return@setOnClickListener
            }
            calculate(flowRateString, velocityString)
        }
    }

    private fun calculate(flowRateString: String, velocityString: String) {
        resolution?.text = (calculation as Area).apply {
            flowRate = java.lang.Double.parseDouble(flowRateString)
            velocity = java.lang.Double.parseDouble(velocityString)
            calculate()
        }.steps
    }
}