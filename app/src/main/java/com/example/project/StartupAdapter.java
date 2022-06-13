package com.example.project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StartupAdapter extends RecyclerView.Adapter<StartupAdapter.StartupViewHolder>{

    List<Startup> StartupList;
    public StartupAdapter(List<Startup> StartupList) {
        this.StartupList=StartupList;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public StartupViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.row_item,parent,false);
        StartupViewHolder viewHolder=new StartupViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull StartupViewHolder holder, int position) {

        //puts data inside the view
        Startup startup=StartupList.get(position);
        holder.nameTextView.setText(startup.getName());
        holder.shortDescTextView.setText(startup.getShortDesc());
        holder.startupIdeaTextView.setText(startup.getStartupIdea());
        holder.qualificationTextView.setText(startup.getQualification());
        holder.locationTextView.setText(startup.getLocation());
        holder.emailTextView.setText(startup.getEmail());
        holder.phoneTextView.setText(startup.getPhone());

        boolean isExpanded=StartupList.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        //imageview same
    }

    @Override
    public int getItemCount() {

        return StartupList.size();
    }

    class StartupViewHolder extends RecyclerView.ViewHolder {
        //ImageView imageView;
        TextView nameTextView,shortDescTextView,startupIdeaTextView,qualificationTextView,locationTextView;
        TextView emailTextView,phoneTextView;
        ConstraintLayout expandableLayout;

        public StartupViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);


            nameTextView=itemView.findViewById(R.id.nameTextView);
            shortDescTextView=itemView.findViewById(R.id.shortDescTextView);
            startupIdeaTextView=itemView.findViewById(R.id.startupIdeaTextView);
            qualificationTextView=itemView.findViewById(R.id.qualificationTextView);
            locationTextView=itemView.findViewById(R.id.locationTextView);
            emailTextView=itemView.findViewById(R.id.emailTextView);
            phoneTextView=itemView.findViewById(R.id.phoneTextView);

            expandableLayout=itemView.findViewById(R.id.expandableLayout);


            nameTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Startup startup=StartupList.get(getAdapterPosition());
                    startup.setExpanded(!startup.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }



//        @Override
//        public void onClick(View view) {
//            //something to do on clicking list item
//
//
//        }
    }
}
