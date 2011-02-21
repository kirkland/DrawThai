package info.kirklander.draw_thai;

import android.graphics.Color;

public class GoalPoint extends Point {
	public static final int UNTOUCHED = 0;
	public static final int TOUCHED = 1;
	public int status;
	
	GoalPoint(float x, float y) {
		this.x = x;
		this.y = y;
		this.radius = (float) 10.0;
		this.status = UNTOUCHED;
	}
	
	public int color() {
		if (this.status == TOUCHED) {
			return Color.RED;
		} else {
			return Color.BLUE;
		}
	}
}
