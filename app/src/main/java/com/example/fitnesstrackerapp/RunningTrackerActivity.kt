package com.example.fitnesstrackerapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitnesstrackerapp.helper.GeneralHelper
import com.example.fitnesstrackerapp.service.StepDetectorService
import kotlinx.android.synthetic.main.activity_running_tracker.*

class RunningTrackerActivity : AppCompatActivity() ,stepsCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_running_tracker)

        val intent = Intent(this, StepDetectorService::class.java)
        startService(intent)

        StepDetectorService.subscribe.register(this)

    }

   override fun subscribeSteps(steps: Int) {
        TV_STEPS.text = steps.toString()
        TV_CALORIES.text = GeneralHelper.getCalories(steps)
        TV_DISTANCE.text = GeneralHelper.getDistanceCovered(steps)
    }



}