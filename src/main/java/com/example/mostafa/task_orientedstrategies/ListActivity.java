package com.example.mostafa.task_orientedstrategies;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private static RecyclerView list;
    private static RecyclerView.Adapter adapter;
    public final static List<ItemView> items = new ArrayList<>();
    private static Context mContext;

    public ListActivity(){}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mContext = getApplicationContext();
        list = (RecyclerView)findViewById(R.id.startegies);
        list.setHasFixedSize(true);
        list.setLayoutManager(new LinearLayoutManager(this));


                    ItemView it = new ItemView("Emphesize Problem Solving" );
                    items.add(it);

                    ItemView it1 = new ItemView("Provide Task-Oriented Organization" );
                    items.add(it1);

                    ItemView it2 = new ItemView("Encourage User Control of Information" );
                    items.add(it2);

                    ItemView it3 = new ItemView("Orient Pages Semanticly" );
                    items.add(it3);

                    ItemView it4 = new ItemView("Facilitae Rotine Tasks and Complex Tasks" );
                    items.add(it4);

                    ItemView it5 = new ItemView("Design For Users" );
                    items.add(it5);

                    ItemView it6 = new ItemView("Facilitate Communication Tasks" );
                    items.add(it6);

                    ItemView it7 = new ItemView("Ecourage User Communities" );
                    items.add(it7);

                    ItemView it8 = new ItemView("Support Cognitive Processing" );
                    items.add(it8);


        adapter = new ListAdapter(items , this);


        list.setAdapter(adapter);
        runLayoutAnimation(list);
    }

    public static RecyclerView getList() {
        return list;
    }

    public static void setList(RecyclerView list) {
        ListActivity.list = list;
    }

    public static RecyclerView.Adapter getAdapter() {
        return adapter;
    }

    public static void setAdapter(List<ItemView> i) { ListActivity.adapter = new ListAdapter(i , ListActivity.mContext); }

    public static List<ItemView> getItems() {
        return items;
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        for(int i = 0 ; i < items.size() ; i++){
            savedInstanceState.putString("score"+i , items.get(i).getScore());
        }

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        for(int i = 0 ; i < KeyWord.scores.length ; i++)
            items.get(i).setScore(savedInstanceState.getString("score"+i));


        adapter = new ListAdapter(items , this);


        list.setAdapter(adapter);
        runLayoutAnimation(list);
    }
    private void runLayoutAnimation(final RecyclerView recyclerView) {
        final Context context = recyclerView.getContext();
        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(context, R.anim.fall_down_layout);

        recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }

    @Override
    protected void onStart() {
        super.onStart();

        runLayoutAnimation(list);
    }

}
