package com.mjr.app.alleasy.physical.fragments.kinematics.urm

import com.mjr.app.alleasy.physical.AbstractPhysicalCalculation
import com.mjr.app.alleasy.physical.moldels.Data

class URMTime3Fragment : AbstractPhysicalCalculation() {
    override fun setTemplateAttributes() {
        datas.apply {
            add(Data("Si = ", "s"))
            add(Data("S = ", "s"))
            add(Data("∆v = ú", "m/s"))
        }
        formula!!.text = calculation.formula
    }

    override fun onCalculateClickListener() {

    }
}