package com.example.fitnesstrackerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.fitnesstrackerapp.Adapter.RecyclerViewAdapter;
import com.example.fitnesstrackerapp.Model.Exercise;

import java.util.ArrayList;
import java.util.List;

public class YogaActivity extends AppCompatActivity {

    List<Exercise> exerciseList=new ArrayList<>();   //Exercise is a model class
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga);

        initData();

        recyclerView=(RecyclerView)findViewById(R.id.list_ex);
        adapter=new RecyclerViewAdapter(exerciseList,getBaseContext());
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);



    }

    private void initData() {

        exerciseList.add(new Exercise(R.drawable.sukhasana10,"Bridge / Bandha Sarvangasana"));
        exerciseList.add(new Exercise(R.drawable.downwardfacingdogpose3,"Downward Facing Dog / Adho Mukha Svanasana"));
        exerciseList.add(new Exercise(R.drawable.sukhasana5,"Child Pose / Balasana"));
        exerciseList.add(new Exercise(R.drawable.sukhasana10,"Easy Pose / Sukhasana"));
        exerciseList.add(new Exercise(R.drawable.low_lunge,"Warrior 1 / Virabhadrasana I"));
        exerciseList.add(new Exercise(R.drawable.upward_bow,"Warrior 2 / Virabhadrasana II"));
        exerciseList.add(new Exercise(R.drawable.crescent_lunge,"Triangle / Trikonasana"));
        exerciseList.add(new Exercise(R.drawable.warrior_pose,"Four-Limbed Staff / Chaturanga"));
        exerciseList.add(new Exercise(R.drawable.bow_pose,"Chair / Utkatasana"));
        exerciseList.add(new Exercise(R.drawable.warrior_pose_2,"Tree / Vrksasana"));
        exerciseList.add(new Exercise(R.drawable.warrior_pose_2,"Boat / Navasana"));
        exerciseList.add(new Exercise(R.drawable.warrior_pose_2,"Crow / Bakasana"));
        exerciseList.add(new Exercise(R.drawable.warrior_pose_2,"Arm Balance / Pincha Mayurasana"));
        exerciseList.add(new Exercise(R.drawable.warrior_pose_2,"King Dancer / Natarajasana"));
        exerciseList.add(new Exercise(R.drawable.warrior_pose_2,"Corpse / Savasana"));
    }


}