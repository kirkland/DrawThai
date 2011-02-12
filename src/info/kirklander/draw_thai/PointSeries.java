package info.kirklander.draw_thai;

import java.util.LinkedList;

public class PointSeries {
	private final LinkedList<Point> points = new LinkedList<Point>();
	private Point currentGoalPoint;
	
	public interface PointSeriesChangeListener {
		void onPointSeriesChange(PointSeries pointSeries);
	}
	
	private PointSeriesChangeListener pointSeriesChangeListener;
	public void setPointSeriesChangeListener(PointSeriesChangeListener l) {
		pointSeriesChangeListener = l;
	}

	public void addPoint(Point new_point) {
		points.add(new_point);
		notifyListener();
	}
	
	public LinkedList<Point> getPoints() {
		return points;
	}
	
	private void notifyListener() {
		if (null != pointSeriesChangeListener) {
			pointSeriesChangeListener.onPointSeriesChange(this);
		}
	}
	
	public boolean pointAtLocation(float x, float y) {
		boolean rv = false;
		for (Point point : points) {
			if (point.insidePoint(x, y) == true) {
				rv = true;
				break;
			}
		}
		return rv;
	}
	
	public void tellOfMovement(float x, float y) {
		if (null == currentGoalPoint) {
			currentGoalPoint = this.points.getFirst();
		}

		// our only goal is the next ordered point
		if (currentGoalPoint.insidePoint(x, y) == true) {
			currentGoalPoint.changeStatus(Point.TOUCHED);
			int prevIndex = points.indexOf(currentGoalPoint);
			
			if (prevIndex + 1 != points.size()) {
				currentGoalPoint = points.get(prevIndex + 1); // ridiculous way to do things
			}
			
			notifyListener();
		}
	}
}
