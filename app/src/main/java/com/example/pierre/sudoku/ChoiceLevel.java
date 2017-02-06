package com.example.pierre.sudoku;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class ChoiceLevel extends Activity implements View.OnClickListener {
    private Button lvl1, lvl2, lvl3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_level);

        lvl1 = (Button) findViewById(R.id.Level1);
        lvl2 = (Button) findViewById(R.id.Level2);
        lvl3 = (Button) findViewById(R.id.Level3);

        lvl1.setOnClickListener(this);
        lvl2.setOnClickListener(this);
        lvl3.setOnClickListener(this);
    }

    public void onClick(View v) {
        int id = v.getId();
        Bundle bun = new Bundle();
        bun.putInt("key", id);
        Intent intent = new Intent(ChoiceLevel.this, ChoiceGrid.class);
        intent.putExtras(bun);
        startActivity(intent);
    }
}