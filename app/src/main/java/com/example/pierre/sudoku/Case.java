package com.example.pierre.sudoku;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Case {
    int xStart, yStart, xStop, yStop, number;
    boolean canWrite;
    private Paint paint;

    public Case(int xStart, int yStart, int xStop, int yStop) {
        this.xStart = xStart;
        this.yStart = yStart;
        this.xStop = xStop;
        this.yStop = yStop;
        this.number = number;
        paint = new Paint();
        paint.setColor(Color.GRAY);
        if(number > 0) {
            canWrite= false;
        }
        else {
            canWrite = true;
        }
    }

    public void draw(Canvas canvas) {
        canvas.drawRect(xStart, yStart, xStop, yStop, paint);
    }
}
