package com.example.pierre.sudoku;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ChoiceGrid extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_choice_grid);
       final ListView listGrid = (ListView) findViewById(R.id.listGrid);
       final ArrayList<ListGrid> grids = new ArrayList();
       int file = 0;
       String line = "";
       int level = this.getIntent().getExtras().getInt("key");

       //On sélectionne le fichier correspondant au niveau
       //de difficulté choisi
       if (level == 1) {
           file = R.raw.level1;
       }

       else if (level == 2) {
           file = R.raw.level2;
       }

       else {
           file = R.raw.level3;
       }

       //On le lis
       InputStream iStream = getResources().openRawResource(file);
       BufferedReader bReader = new BufferedReader(new InputStreamReader(iStream));

       int i = 1;

       do {
           try {
               line = bReader.readLine();
           }

           catch (IOException e) {
               e.printStackTrace();
           }

           //On ajoute chaque ligne à la liste de grille
           grids.add(new ListGrid(i, level, 0, line));
           i++;
       }

       while (line != null);

       //On envoie la grille qui a été touchée dans la liste (via sa position)
       listGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Bundle bun = new Bundle();
               bun.putString("grid", grids.get(position).toString());
               Intent intent = new Intent(ChoiceGrid.this, DisplayGrid.class);
               intent.putExtras(bun);
               startActivity(intent);
           }
       });

       listGrid.setAdapter(new Adapter(this, grids));
    }
}