package info.kirklander.draw_thai;

public class Point {
	public float x, y;
	public float radius;
	
	public Point() {
		this.x = (float) 0.0;
		this.y = (float) 0.0;
		this.radius = (float) 10.0;
	}
	
	public Point(float x, float y) {
		this.x = x;
		this.y = y;
		this.radius = (float) 10.0;
	}
	
	public float distance(Point other_point) {
		return distance(other_point.x, other_point.y);
	}
	
	public float distance(float other_x, float other_y) {
		float dx = Math.abs(other_x - x);
		float dy = Math.abs(other_y - y);
		return (float) Math.sqrt(dx*dx + dy*dy);
	}
	
	// true if distance between centers of each point is less than combined radius
	public boolean intersects(Point other_point) {
		if (distance(other_point.x, other_point.y) < this.radius + other_point.radius) {
			return true;
		} else {
			return false;
		}
	}
}
