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
        
        // set up the model
		Point p1 = new Point(50, 50);
		Point p2 = new Point(100, 100);
		final PointSeries points = new PointSeries();
		points.addPoint(p1);
		points.addPoint(p2);
        
        final EditText text1 = (EditText) findViewById(R.id.text1);
        final EditText text2 = (EditText) findViewById(R.id.text2);
        
        final TouchView tv = new TouchView(this, points);
        
		points.setPointSeriesChangeListener(new PointSeries.PointSeriesChangeListener() {
			@Override 
			public void onPointSeriesChange(PointSeries ps) {
				tv.invalidate();
			}
		});
        
        ((ViewGroup) findViewById(R.id.main)).addView(tv);
        
        tv.setOnTouchListener(new View.OnTouchListener() {
        	@Override
        	public boolean onTouch(View v, MotionEvent event) {
        		if (MotionEvent.ACTION_DOWN != event.getAction()) {
        			return false;
        		}
        		
        		// on touch, check model to see if we hit a dot
        		boolean touchedGoal = true;
        		
        		return true;
        	} 
        });

    }
}