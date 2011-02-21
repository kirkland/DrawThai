package info.kirklander.draw_thai;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class DrawThai extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final Game game = new Game();
        
        // these are the goals that the user must move over in order
        // showing Gor Gai now as a proof of concept.
        // TODO: store this data more better like
        game.addGoalPoint((float) 75.0, (float) 300.0);
        game.addGoalPoint((float) 75, (float) 250);
        game.addGoalPoint((float) 75, (float) 200);
        game.addGoalPoint((float) 100, (float) 175);
        game.addGoalPoint((float) 75, (float) 150);
        game.addGoalPoint((float) 125, (float) 125);
        game.addGoalPoint((float) 175, (float) 150);
        game.addGoalPoint((float) 175, (float) 150);
        game.addGoalPoint((float) 175, (float) 200);
        game.addGoalPoint((float) 175, (float) 250);
        game.addGoalPoint((float) 175, (float) 300);
        
        // create view and display it
        final GameView gv = new GameView(this, game);
        ((ViewGroup) findViewById(R.id.main)).addView(gv);
        
        // redraw view whenever model changes
		game.setGameChangeListener(new Game.GameChangeListener() {
			@Override
			public void onGameChange(Game game) {
				gv.invalidate();
			}
		});
        
        gv.setOnTouchListener(new View.OnTouchListener() {
        	@Override
        	public boolean onTouch(View v, MotionEvent event) {
        		if (MotionEvent.ACTION_MOVE == event.getAction()) {
        			game.addDrawPoint(event.getX(), event.getY());
        		} else if (MotionEvent.ACTION_DOWN == event.getAction()) {
        			game.startNewDrawPath(event.getX(), event.getY());
        		}
        		
        		return true;
        	} 
        });

    }
}