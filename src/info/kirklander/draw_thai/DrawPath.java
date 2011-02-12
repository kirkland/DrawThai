// Will hold a list of DrawPoints which will represent what the user has inputed
// so far. 

package info.kirklander.draw_thai;

import info.kirklander.draw_thai.PointSeries.PointSeriesChangeListener;

import java.util.LinkedList;

import android.view.MotionEvent;

public class DrawPath {
	private final LinkedList<DrawPoint> drawPoints = new LinkedList<DrawPoint>();
	
	public interface DrawPathChangeListener {
		void onDrawPathChange(DrawPath drawPath);
	}
	
	private DrawPathChangeListener drawPathChangeListener;
	public void setDrawPathChangeListener(DrawPathChangeListener l) {
		drawPathChangeListener = l;
	}
	
	public void addDrawPointAtCoords(float x, float y) {
		drawPoints.add(new DrawPoint(x, y));
		notifyListener();
	}
	
	public LinkedList<DrawPoint> getDrawPoints() {
		return drawPoints;
	}
	
	// TODO: maybe passing a MotionEvent to this is a violation of MVC.
	public void addEvent(MotionEvent event) {
		 for (int i = 0, n = event.getHistorySize(); i < n; i++) {
			 addDrawPointAtCoords(event.getHistoricalX(i), event.getHistoricalY(i));
		 }
	}
	
	private void notifyListener() {
		if (null != drawPathChangeListener) {
			drawPathChangeListener.onDrawPathChange(this);
		}
	}
	
	public class DrawPoint {
		float x,y;
		
		public DrawPoint(float x, float y) {
			this.x = x; this.y = y;
		}
		
		public float getX() {
			return this.x;
		}
		
		public float getY() {
			return this.y;
		}
	}
}
