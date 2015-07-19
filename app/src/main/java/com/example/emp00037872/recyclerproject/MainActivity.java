package com.example.emp00037872.recyclerproject;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    private List<Person> persons;
    RecyclerView rv;
    RVAdapter adapter;
    LinearLayoutManager llm;
    RecyclerView.ItemAnimator itemAnimator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateDate(200);
        itemAnimator = new DefaultItemAnimator();
        adapter = new RVAdapter(persons);
        llm = new LinearLayoutManager(this);
        rv = (RecyclerView)findViewById(R.id.rv);
        //rv.setHasFixedSize(true);





//        rv.addOnItemTouchListener(
//                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(View view, int position) {
//                        int itemPosition = rv.getChildPosition(view);
//                        String item = persons.get(itemPosition).getName();
//                        Toast.makeText(getApplicationContext(), item, Toast.LENGTH_SHORT).show();
//                    }
//                })
//        );
        rv.setAdapter(adapter);
        rv.setLayoutManager(llm);
        rv.setItemAnimator(itemAnimator);


    }
    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Person("Test 1 ", "Text 1"));
        persons.add(new Person("Test 2 ", "Text 2"));
        persons.add(new Person("Test 3 ", "Text 3"));
        persons.add(new Person("Test 4 ", "Text 4"));
        persons.add(new Person("Test 5 ", "Text 5"));
        persons.add(new Person("Test 6 ", "Text 6"));
        persons.add(new Person("Test 7 ", "Text 7"));
        persons.add(new Person("Test 8 ", "Text 8"));
        persons.add(new Person("Test 9 ", "Text 9"));
        persons.add(new Person("Test 10 ", "Text 10"));
        persons.add(new Person("Test 11 ", "Text 11"));
        persons.add(new Person("Test 12 ", "Text 12"));
        persons.add(new Person("Test 13 ", "Text 13"));
        persons.add(new Person("Test 14 ", "Text 14"));
        persons.add(new Person("Test 15 ", "Text 15"));
    }
    private void populateDate(int count){
        persons = new ArrayList<>();
        for(int i=0;i<count;i++){
            persons.add(new Person("Test " + (i+1), "Text "+(i+1)));
        }

    }


}
