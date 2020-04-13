package com.example.saferoute1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowPath extends AppCompatActivity {
    TextView tvSource;
    ListView lvRoute;
    int sourceIndex , destinationIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_path);

        tvSource = findViewById(R.id.source);

        String source = getIntent().getStringExtra("from");
        String destination = getIntent().getStringExtra("to");


        String places[] = DataClass.places;
        for( int i =0 ; i<9; i++){
            if(source.equals(places[i])){
                sourceIndex =i;
            }
            if(destination.equals(places[i])){
                destinationIndex =i;
            }
        }
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.dijkstraAlgo(DataClass.graph , sourceIndex , destinationIndex );
        Log.e("path ---->" , String.valueOf(dijkstra.path));
        ArrayList<String> route =new ArrayList<>();

        for( int i : dijkstra.path){
            route.add(places[i]);
        }
        for(String s: route){
            Log.e("path in string" ,s );
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.single_item,route);
        lvRoute = findViewById(R.id.route);
        lvRoute.setAdapter(adapter);


    }
}
