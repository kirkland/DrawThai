package info.kirklander.draw_thai;

import java.util.LinkedList;

public class PointSeries {
	private final LinkedList<Point> points = new LinkedList<Point>();
	
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
}
