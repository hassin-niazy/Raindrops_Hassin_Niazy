/**
 * @Author Hassinullah Niazy
 * This is my app that I designed for Assignment Part A of CS301 course.
 * This app will randomly draw circles on the screen between 6 - 12 circles each time the app runs.
 * The color of these circle are also generated randomly so, the circle will be drawn on different colors.
 */

package edu.up.raindrops;
import android.os.Bundle;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Control seek Bars to communicate with GameView.
        SeekBar seekBarX = findViewById(R.id.rightLeftSeek); //This Seek Bar controls left and right movement or X direction.
        SeekBar seekBarY = findViewById(R.id.upDownSeek); //This Seek Bar controls up and down movement or Y direction
        GameView game = findViewById(R.id.gameScreen);
        Controller control = new Controller(game);
        seekBarX.setOnSeekBarChangeListener(control);
        seekBarY.setOnSeekBarChangeListener(control);
    }
}