/**
 * @Author Hassinullah Niazy
 * This is my main class for the circle that draws circles around the screen.
 * This is class is based on my learnings from CS301 class codings so, far, which is based from the Spot Class in our lecture.
 *
 */

package edu.up.raindrops;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import java.util.Random;

/** This is the main class for the Circles to draw */
public class Circle {

    protected int xPos; //x-Position
    protected int yPos; //y-Position
    protected int radius = 30; //circle size.
    protected int red; //RGB: Red
    protected int green; //RGB: Green
    protected int blue; //RGB: Blue
    protected Random random = new Random();
    protected Paint paint; // Color of the circle.

    //Random Color Method;
    protected void paint(){

        red = random.nextInt(256);
        green = random.nextInt(256);
        blue = random.nextInt(256);

        paint = new Paint();
        paint.setColor(Color.rgb(red,green,blue));
    }


    //Make this raindrop's color the average of it's color and another
    public void avgColor(Circle other) {
        this.red = (this.red + other.red) / 2;
        this.green = (this.green + other.green) / 2;
        this.blue = (this.blue + other.blue) / 2;

        this.paint.setColor(Color.rgb(this.red,this.green,this.blue));

    }

    //Default constructor
    public Circle() {

        //place Circle in a random position
        xPos = random.nextInt(800) + 50;
        yPos = random.nextInt(800) + 50;
        paint();
    }


    //User-defined constructor:
    public Circle (int _xPos, int _yPos) {
        xPos = _xPos;
        yPos = _yPos;
        paint();
    }

    //Setter methods for x and y positions of the circle.
    public void setXPos( int _xPos)
    {
        this.xPos = _xPos;
    }
    public void setYPos( int _yPos)
    {
        this.yPos = _yPos;
    }

    //Getter methods for x and y positions of the circle.
    public int getXPos(){ return xPos; };
    public int getYPos(){ return yPos; };

    public void draw (Canvas screen) {

        screen.drawCircle(xPos, yPos, radius, paint);

    };

} //Class Circle for all the circle drawn on the screen.
