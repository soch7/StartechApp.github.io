package com.example.project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class InvestorAdapter extends RecyclerView.Adapter<InvestorAdapter.InvestorViewHolder>{

    List<Investor> InvestorList;
    public InvestorAdapter(List<Investor> InvestorList) {
        this.InvestorList=InvestorList;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public InvestorViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.investor_row_item,parent,false);
        InvestorViewHolder viewHolder=new InvestorViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull InvestorViewHolder holder, int position) {


        Investor investor=InvestorList.get(position);
        holder.nameTextView.setText(investor.getName());
        holder.investmentTextView.setText(investor.getInvestment());
        holder.ideaPreferencesTextView.setText(investor.getIdeaPreferences());
        holder.qualificationTextView.setText(investor.getQualification());
        holder.emailTextView.setText(investor.getEmail());
        holder.phoneTextView.setText(investor.getPhone());

        boolean isExpanded=InvestorList.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded?View.VISIBLE:View.GONE);

    }

    @Override
    public int getItemCount() {

        return InvestorList.size();
    }

    class InvestorViewHolder extends RecyclerView.ViewHolder {
        //ImageView imageView;
        TextView nameTextView,investmentTextView,ideaPreferencesTextView,qualificationTextView;
        TextView emailTextView,phoneTextView;
        ConstraintLayout expandableLayout;

        public InvestorViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);


            nameTextView=itemView.findViewById(R.id.nameTextView);
            investmentTextView=itemView.findViewById(R.id.investmentTextView);
            ideaPreferencesTextView=itemView.findViewById(R.id.ideaPreferencesTextView);
            qualificationTextView=itemView.findViewById(R.id.qualificationTextView);
            emailTextView=itemView.findViewById(R.id.emailTextView);
            phoneTextView=itemView.findViewById(R.id.phoneTextView);

            expandableLayout=itemView.findViewById(R.id.expandableLayout);


            nameTextView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Investor investor=InvestorList.get(getAdapterPosition());
                    investor.setExpanded(!investor.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }

    }
}


