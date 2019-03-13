package com.example.gallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final String name[]={"1","2","3","4","5"};

    private final int imgId[]={R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView=(RecyclerView) findViewById(R.id.Gallery);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager= new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Cell> cells=prepareData();
        MyAdapter adapter=new MyAdapter(getApplicationContext(),cells);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<Cell> prepareData()
    {
        ArrayList<Cell> thisimage=new ArrayList<>();

        for(int i=0; i<name.length;i++)
        {
            Cell cell=new Cell();
            cell.setTitle(name[i]);
            cell.setImg(imgId[i]);
            thisimage.add(cell);
        }

        return thisimage;
    }
}
