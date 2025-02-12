package edu.up.raindrops;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

/** This is the main class for the drawing circles */
public class Circle {

    protected int xPos; //x-Position
    protected int yPos; //y-Position
    protected int radius = 30; //circle size.
    protected Random random = new Random();
    protected Paint paint; // Color of the circle.

    //Random Color Method;
    protected void paint(){

        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);

        paint = new Paint();
        paint.setColor(Color.rgb(red,green,blue));
    }

    //Default constructor
    public Circle() {

        //place Circle in a random position
        xPos = random.nextInt(800) + 20;
        yPos = random.nextInt(800) + 20;
        paint();
    }

    //User-defined constructor:
    public Circle (int _xPos, int _yPos) {
        xPos = _xPos;
        yPos = _yPos;
        paint();
    }

    public void draw (Canvas screen) {

        screen.drawCircle(xPos, yPos, radius, paint);

    };

} //Class Circle for all the circle drawn on the screen.
