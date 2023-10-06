package com.mjr.app.alleasy.physics.fragments.kinematics.urm

import com.mjr.app.alleasy.physics.AbstractPhysicalCalculation
import com.mjr.app.alleasy.physics.moldels.Data

class URMDisplacement1Fragment: AbstractPhysicalCalculation() {
    override fun setTemplateAttributes() {
        datas?.apply {
            add(Data("Si = ", "m"))
            add(Data("S = ", "m"))
        }
        formula?.text = calculation.formula
    }

    override fun onCalculateClickListener() {

    }
}