package com.mjr.app.alleasy.physical.fragments.kinematics.urm

import com.mjr.app.alleasy.physical.AbstractPhysicalCalculation
import com.mjr.app.alleasy.physical.moldels.Data
import com.mjr.twaire.code.physic.kinematics.mru.Displacement1

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