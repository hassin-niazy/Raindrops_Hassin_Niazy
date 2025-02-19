package edu.up.raindrops;

import android.widget.SeekBar;

/**
 * This is controller class for our raindrops.
 */

public class Controller implements SeekBar.OnSeekBarChangeListener {

    //Reference to GameView Class
    private GameView _gameView;

    public Controller (GameView gameView) {

     this._gameView = gameView;
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        if(seekBar.getId() == R.id.rightLeftSeek) {
            _gameView.superstar.setXPos(progress + 25);
            _gameView.invalidate();
        }
        else if(seekBar.getId() == R.id.upDownSeek) {
            _gameView.superstar.setYPos(progress + 25);
            _gameView.invalidate();
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) { /* we are not using it */ }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) { /* we are not using it */ }
}
