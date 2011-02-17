package info.kirklander.draw_thai;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class DrawThai extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // set up points model (these are the goals that the user must move over in order)
        // showing Gor Gai now as a proof of concept.
        // TODO: store this data more better like
        final PointSeries points = new PointSeries();
        points.addPoint(new Point(75, 300));
        points.addPoint(new Point(75, 250));
        points.addPoint(new Point(75, 200));
        points.addPoint(new Point(100, 175));
        points.addPoint(new Point(75, 150));
        points.addPoint(new Point(125, 125));
        points.addPoint(new Point(175, 150));
        points.addPoint(new Point(175, 150));
        points.addPoint(new Point(175, 200));
        points.addPoint(new Point(175, 250));
        points.addPoint(new Point(175, 300));
        
		// DrawPath instance holds where the user has been so far.
		final DrawPath drawPath = new DrawPath(points);
        
        final EditText text1 = (EditText) findViewById(R.id.text1);
        final EditText text2 = (EditText) findViewById(R.id.text2);
        
        final TouchView tv = new TouchView(this, drawPath);
		
        // redraw view whenever model changes
		drawPath.setDrawPathChangeListener(new DrawPath.DrawPathChangeListener() {
			@Override
			public void onDrawPathChange(DrawPath drawPath) {
				tv.invalidate();
			}
		});
        
        ((ViewGroup) findViewById(R.id.main)).addView(tv);
        
        tv.setOnTouchListener(new View.OnTouchListener() {
        	@Override
        	public boolean onTouch(View v, MotionEvent event) {
        		if (MotionEvent.ACTION_MOVE == event.getAction()) {
        			drawPath.addDrawPointAtCoords(event.getX(), event.getY());
        			
        			// TODO: update points from within drawPath
        			points.tellOfMovement(event.getX(), event.getY());
        		} else if (MotionEvent.ACTION_DOWN == event.getAction()) {
        			drawPath.startNewPath(event.getX(), event.getY());
        		}
        		
        		return true;
        	} 
        });

    }
}