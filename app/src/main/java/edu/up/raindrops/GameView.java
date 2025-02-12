package edu.up.raindrops;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.Random;

public class GameView extends SurfaceView {


    private ArrayList<Circle> drawing  = new ArrayList<>();

    @Override
    public void setBackgroundColor(int color) {
        super.setBackgroundColor(color);
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        setBackgroundColor(Color.rgb(205,240,255));

        Random rand = new Random();
        int count = rand.nextInt(6) + 6;
        for (int i = 0; i < count; i++)
        {
            drawing.add(new Circle());
        }

    }

    @Override
    public void onDraw( Canvas screen)
    {
       for (Circle newCircle: drawing)
       {
           newCircle.draw(screen);
       }
    }


}
