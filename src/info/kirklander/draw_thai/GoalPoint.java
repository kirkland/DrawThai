package info.kirklander.draw_thai;

import android.graphics.Color;

public class GoalPoint extends Point {
	public float x,y;
	
	public static final float RADIUS = (float) 10.0;
	
	public static final int UNTOUCHED = 0;
	public static final int TOUCHED = 0;
	public int status;
	
	GoalPoint() {
		super();
		status = UNTOUCHED;
	}
	
	GoalPoint(float x, float y) {
		this.x = x;
		this.y = y;
		status = UNTOUCHED;
	}
	
	public int color() {
		if (this.status == TOUCHED) {
			return Color.RED;
		} else {
			return Color.BLUE;
		}
	}
}
