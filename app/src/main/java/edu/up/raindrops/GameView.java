/**
 * @Author Hassinullah Niazy
 * This is my main class for app view that draws circles around the screen.
 * This is class is based on my learnings from CS301 class codings so, far, which is based from the LeArt Class in our lecture.
 *
 */

package edu.up.raindrops;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.Random;

public class GameView extends SurfaceView {

    Circle superstar; //The Super Circle
    Random rand = new Random();
    int count = rand.nextInt(6) + 6;

    private ArrayList<Circle> drawing  = new ArrayList<>(); //Array of Circles

    @Override
    public void setBackgroundColor(int color) {
        super.setBackgroundColor(color);
    }

    //This class show all the drawings on the screen.
    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        setBackgroundColor(Color.rgb(205,240,255));
        for (int i = 0; i < count; i++)
        {
            drawing.add(new Circle());
        }
     //Random Circle to be controlled by Seekbars.
        superstar = drawing.get(0);

    }

    @Override
    public void onDraw( Canvas screen)
    {
       for (Circle newCircle: drawing)
       {
           newCircle.draw(screen); //Draw circles from ArrayList on the screen.

       }

       int deleteMe = -1; // to remove merged circles from the screen.

        //loop to compare the arraylist circles with main circle, if in borders to merge it.
        for (int i = 1; i < drawing.size(); i++)
        {
            Circle cand = drawing.get(i);
            int a = cand.getXPos() - superstar.getXPos();
            int b = cand.getYPos() - superstar.getYPos();
            int c = (int) Math.sqrt(a*a+b*b);

            if(c < 60 ){
                superstar.avgColor(drawing.get(i));
                deleteMe = i;
            }
        }

        //merging the circle.
        if(deleteMe > -1){
            drawing.remove(deleteMe);};


    }


}
