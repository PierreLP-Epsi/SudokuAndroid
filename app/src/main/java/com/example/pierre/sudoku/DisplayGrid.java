package com.example.pierre.sudoku;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class DisplayGrid extends Activity {
    DrawGrid drawGrid;
    private String grid;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = this.getIntent().getExtras();
        grid = bundle.getString("grid");

        Log.d("Grid = ", grid);

        drawGrid = new DrawGrid(this);
        drawGrid.setBackgroundColor(Color.BLACK);
        setContentView(drawGrid);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
