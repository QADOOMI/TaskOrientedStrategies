package com.example.mostafa.task_orientedstrategies;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<ItemView> items;
    private Context context;

    public ListAdapter(List<ItemView> items , Context context){
        this.items = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.item_list , parent , false);

    return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
         ItemView i = items.get(position);


        ViewHolder.setHeadText(i.getHead());
        ViewHolder.setScoreText(i.getScore());

        ViewHolder.setItemClick(new ListAdapter.ItemClickListener(){
            @Override
            public void onClickItem(View view, int position) {
                Intent i = new Intent(context, Strategy.class);
                switch(position){
                    case 0 :
                        i.putExtra(KeyWord.level , 1);
                    break;
                    case 1 :
                        i.putExtra(KeyWord.level , 2);
                        break;
                    case 2 :
                        i.putExtra(KeyWord.level , 3);
                        break;
                    case 3 :
                        i.putExtra(KeyWord.level , 4);
                        break;
                    case 4 :
                        i.putExtra(KeyWord.level , 5);
                        break;
                    case 5 :
                        i.putExtra(KeyWord.level , 6);
                        break;
                    case 6 :
                        i.putExtra(KeyWord.level , 7);
                        break;
                    case 7 :
                        i.putExtra(KeyWord.level , 8);
                        break;
                    case 8 :
                        i.putExtra(KeyWord.level , 9);
                        break;
                }
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }



    public interface ItemClickListener {

        public void onClickItem(View view , int position);
    }


}
class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private static TextView headText , scoreText;

    private static ListAdapter.ItemClickListener itemClick;

    public ViewHolder(View itemView) {
        super(itemView);

        headText = (TextView)itemView.findViewById(R.id.head);
        scoreText = (TextView)itemView.findViewById(R.id.score);

        itemView.setOnClickListener(this);
    }

    public static void setItemClick(ListAdapter.ItemClickListener itemClick) { ViewHolder.itemClick = itemClick; }

    public static void setHeadText(String headText) {
        ViewHolder.headText.setText(headText);
    }

    public static void setScoreText(String scoreText) {
        ViewHolder.scoreText.setText(scoreText);
    }

    @Override
    public void onClick(View v) {
        itemClick.onClickItem(v , getAdapterPosition());
    }
}