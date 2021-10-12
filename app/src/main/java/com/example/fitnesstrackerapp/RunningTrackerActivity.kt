package com.example.fitnesstrackerapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.example.fitnesstrackerapp.helper.GeneralHelper
import com.example.fitnesstrackerapp.service.StepDetectorService
import kotlinx.android.synthetic.main.activity_running_tracker.*

class RunningTrackerActivity : AppCompatActivity() ,stepsCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_running_tracker)

//        setSupportActionBar(Toolbar)

        val intent = Intent(this, StepDetectorService::class.java)
        startService(intent)

        StepDetectorService.subscribe.register(this)


    }

   override fun subscribeSteps(steps: Int) {
        TV_STEPS.text = steps.toString()
        TV_CALORIES.text = GeneralHelper.getCalories(steps)
        TV_DISTANCE.text = GeneralHelper.getDistanceCovered(steps)
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.main_menu,menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        var itemview=item.itemId
//
//        when(itemview)
//        {
//            R.id.resetButton -> Toast.makeText(applicationContext,"RESET BUTTON CLICKED",Toast.LENGTH_SHORT).show()
//        }
//
//        return false
//
//
//    }



}