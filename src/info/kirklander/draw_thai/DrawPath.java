// Will hold a list of DrawPoints which will represent what the user has inputed
// so far. 

package info.kirklander.draw_thai;

import java.util.LinkedList;

public class DrawPath {
	private final LinkedList<DrawPoint> drawPoints = new LinkedList<DrawPoint>();
	
	public void addDrawPointAtCoords(float x, float y) {
		drawPoints.add(new DrawPoint(x, y));
	}
	
	public LinkedList<DrawPoint> getDrawPoints() {
		return drawPoints;
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
}
