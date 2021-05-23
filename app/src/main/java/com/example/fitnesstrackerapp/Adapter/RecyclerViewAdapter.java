package com.example.fitnesstrackerapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnesstrackerapp.Interface.ItemClickListener;
import com.example.fitnesstrackerapp.Model.Exercise;
import com.example.fitnesstrackerapp.R;
import com.example.fitnesstrackerapp.ViewExercise;

import java.util.List;

class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{


    public ImageView image;
    public TextView text;

    private ItemClickListener itemClickListener;

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        image=(ImageView)itemView.findViewById(R.id.ex_img);
        text=(TextView)itemView.findViewById(R.id.ex_name);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
   itemClickListener.onClick(view,getAdapterPosition());

    }
}

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private final List<Exercise> exerciseList;
    private final Context context;

    public RecyclerViewAdapter(List<Exercise> exerciseList, Context context) {
        this.exerciseList = exerciseList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View itemView =inflater.inflate(R.layout.item_exercise,parent,false);

      return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
          holder.image.setImageResource(exerciseList.get(position).getImage_id());
          holder.text.setText(exerciseList.get(position).getName());

          holder.setItemClickListener(new ItemClickListener() {
              @Override
              public void onClick(View view, int position) {
                  //call to New Activity
                 Intent intent=new Intent(context, ViewExercise.class);
                 intent.putExtra("image_id",exerciseList.get(position).getImage_id());
                 intent.putExtra("name",exerciseList.get(position).getName());

                  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                 context.startActivity(intent);

              } 
          });
    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }
}
