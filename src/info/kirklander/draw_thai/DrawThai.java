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
        game.addGoalPoint(75, 300);
        game.addGoalPoint(75, 250);
        game.addGoalPoint(75, 200);
        game.addGoalPoint(100, 175);
        game.addGoalPoint(75, 150);
        game.addGoalPoint(125, 125);
        game.addGoalPoint(175, 150);
        game.addGoalPoint(175, 150);
        game.addGoalPoint(175, 200);
        game.addGoalPoint(175, 250);
        game.addGoalPoint(175, 300);
        
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