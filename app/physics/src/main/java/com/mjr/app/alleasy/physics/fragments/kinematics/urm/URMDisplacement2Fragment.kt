package com.mjr.app.alleasy.physics.fragments.kinematics.urm

import com.mjr.app.alleasy.physics.AbstractPhysicalCalculation
import com.mjr.app.alleasy.physics.moldels.Data

class URMDisplacement2Fragment : AbstractPhysicalCalculation() {
    override fun setTemplateAttributes() {
      datas!!.apply {
          add(Data("∆t = ", "s"))
          add(Data("v = ", "m/s"))
      }
        formula!!.text = calculation.formula
    }

    override fun onCalculateClickListener() {
        //TODO("Not yet implemented")
    }
}