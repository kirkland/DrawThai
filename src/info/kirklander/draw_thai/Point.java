package info.kirklander.draw_thai;

public class Point {
	private final float x, y;
	private final float radius = (float) 10.0;
	
	public Point(float new_x, float new_y) {
		this.x = new_x;
		this.y = new_y;
	}
	
	public float getX() { return x; }
	public float getY() { return y; }
	
	public float distance(Point other_point) {
		return distance(other_point.getX(), other_point.getY());
	}
	
	public float distance(float other_x, float other_y) {
		float dx = Math.abs(other_x - x);
		float dy = Math.abs(other_y - y);
		return (float) Math.sqrt(dx*dx - dy*dx);
	}
}
