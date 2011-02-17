// Will hold a list of DrawPoints which will represent what the user has inputed
// so far. 

package info.kirklander.draw_thai;

import java.util.LinkedList;

public class DrawPath {
	private LinkedList<DrawPoint> drawPoints = new LinkedList<DrawPoint>();
	private final PointSeries goalPoints;
	
	public interface DrawPathChangeListener {
		void onDrawPathChange(DrawPath drawPath);
	}
	
	public DrawPath(PointSeries goalPoints) {
		this.goalPoints = goalPoints;
		
		goalPoints.setPointSeriesChangeListener(new PointSeries.PointSeriesChangeListener() {
			@Override 
			public void onPointSeriesChange(PointSeries ps) {
				notifyListener();
			}
		});
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
	
	public PointSeries getGoalPoints() {
		return this.goalPoints;
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
	
	// on event down, clear out whatever we had before.
	public void startNewPath(float x, float y) {
		this.drawPoints = new LinkedList<DrawPoint>();
		goalPoints.reset();
	}
}
