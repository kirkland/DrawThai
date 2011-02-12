package info.kirklander.draw_thai;

import android.graphics.Color;

public class Point {
	private final float x, y;
	static final float RADIUS = (float) 10.0;
	
	public static final int TOUCHED = 0;
	public static final int UNTOUCHED = 1;
	
	private int status;
	
	public Point(float new_x, float new_y) {
		this.x = new_x;
		this.y = new_y;
		this.status = UNTOUCHED;
	}
	
	public float getX() { return x; }
	public float getY() { return y; }
	
	public float distance(Point other_point) {
		return distance(other_point.getX(), other_point.getY());
	}
	
	public float distance(float other_x, float other_y) {
		float dx = Math.abs(other_x - x);
		float dy = Math.abs(other_y - y);
		return (float) Math.sqrt(dx*dx + dy*dy);
	}
	
	public boolean insidePoint(float x, float y) {
		if (distance(x,y) < RADIUS) {
			return true;
		} else {
			return false;
		}
	}
	
	public void changeStatus(int status) {
		this.status = status;
	}
	
	public int color() {
		if (this.status == TOUCHED) {
			return Color.RED;
		} else {
			return Color.BLUE;
		}
	}
}
