package com.journaldev.recyclerviewcardview;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>  {
    private  final RecyclerviewInterface recyclerviewInterface;


    private ArrayList<DataModel> dataSet;

    public CustomAdapter(ArrayList<DataModel> dataSet,RecyclerviewInterface recyclerviewInterface) {

        this.dataSet = dataSet;
        this.recyclerviewInterface = recyclerviewInterface;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder  {
       CardView cardView;
       TextView textViewName;
       TextView textViewVersion;
        ImageView imageViewIcon;

       public MyViewHolder (View itemView , final RecyclerviewInterface recyclerviewInterface)
       {
           super(itemView);

           cardView = (CardView) itemView.findViewById(R.id.card_view);
           textViewName = ( TextView) itemView.findViewById(R.id.textViewName);
           textViewVersion = ( TextView) itemView.findViewById(R.id.textViewVersion);
           imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);

           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   if (recyclerviewInterface != null){

                        int pos = getAdapterPosition();

                        if(pos!= RecyclerView.NO_POSITION){

                            recyclerviewInterface.onItemClick(pos);
                        }

                   }
               }
           });

       }

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext() ).inflate(R.layout.cards_layout , parent ,false);

        MyViewHolder myViewHolder = new MyViewHolder(view , recyclerviewInterface);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder,  int listPosition) {

        TextView textViewName = viewHolder.textViewName;
        TextView textViewVersion = viewHolder.textViewVersion;
        ImageView imageView = viewHolder.imageViewIcon;
        CardView cardView = viewHolder.cardView;

        textViewName.setText(dataSet.get(listPosition).getName());
        textViewVersion.setText(dataSet.get(listPosition).getVersion());
        imageView.setImageResource(dataSet.get(listPosition).getImage());




    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}


