package com.example.pierre.sudoku;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import java.util.LinkedList;

public class DrawGrid extends View {

    Case[][] matGrid = new Case[9][9];

    LinkedList<Case> aCases;
    //TODO Récupérer la grid
    public DrawGrid(Context context) {
        super(context);
        aCases = new LinkedList<>();

        //TODO Envoyer grid
        onCreate();
    }

    //TODO Lire la grid pour remplir les numéros
    public void onCreate() {
        Context context = getContext();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int x = size.x;
        int y = size.y;

        //on prend 80% de la taille de l'écran pour la grille
        y = (y*80)/100;

        y = y/9;
        x = x/9;

        //Grille
        int i = 0;
        int j = 0;

        //Génération grille
        while (i < 9) {
            aCases.add(new Case((x*i)+5, (y*j)+5, (x*(i+1))-5, (y*(j+1))-5));
            i++;
            if (i == 9 && j < 8) {
                i = 0;
                j++;
            }
        }

        //Ligne Chiffre
        int k = 0;

        while (k < 9) {
            aCases.add(new Case((x*k)+5, (y*10), (x*(k+1))-5, (y*11)));
            k++;
        }
    }

    @Override
    public void onDraw(Canvas canvas) {
        for (Case aCase : aCases)
            aCase.draw(canvas);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        this.invalidate();
        return true;
    }
}