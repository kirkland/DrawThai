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
		Point p1 = new Point(50, 50);
		Point p2 = new Point(100, 100);
		final PointSeries points = new PointSeries();
		points.addPoint(p1);
		points.addPoint(p2);
		
		// DrawPath instance holds where the user has been so far.
		final DrawPath drawPath = new DrawPath();
        
        final EditText text1 = (EditText) findViewById(R.id.text1);
        final EditText text2 = (EditText) findViewById(R.id.text2);
        
        final TouchView tv = new TouchView(this, points, drawPath);
        
		points.setPointSeriesChangeListener(new PointSeries.PointSeriesChangeListener() {
			@Override 
			public void onPointSeriesChange(PointSeries ps) {
				tv.invalidate();
			}
		});
		
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
        		// update DrawPath with what we've done.
        		drawPath.addEvent(event);
        		
        		// TODO: look at history too
        		if (MotionEvent.ACTION_MOVE == event.getAction()) {
        			points.tellOfMovement(event.getX(), event.getY());
        		}
        		
        		return true;
        	} 
        });

    }
}