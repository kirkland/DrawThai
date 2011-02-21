package info.kirklander.draw_thai;

public class Point {
	public float x, y;
	
	public Point() {
		this.x = (float) 0.0;
		this.y = (float) 0.0;
	}
	
	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public float distance(Point other_point) {
		return distance(other_point.x, other_point.y);
	}
	
	public float distance(float other_x, float other_y) {
		float dx = Math.abs(other_x - x);
		float dy = Math.abs(other_y - y);
		return (float) Math.sqrt(dx*dx + dy*dy);
	}
}
