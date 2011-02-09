package info.kirklander.draw_thai;

import java.util.LinkedList;

public class PointSeries {
	private final LinkedList<Point> points = new LinkedList<Point>();
	
	public void addPoint(Point new_point) {
		points.add(new_point);
	}
	
	public LinkedList<Point> getPoints() {
		return points;
	}
}
