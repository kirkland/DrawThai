package info.kirklander.draw_thai;

import java.util.LinkedList;

public class Game {
	private LinkedList<GoalPoint> goalPoints;
	private LinkedList<Point> drawPoints;
	private GoalPoint currentGoalPoint;
	
	Game() {
		this.goalPoints = new LinkedList<GoalPoint>();
		this.drawPoints = new LinkedList<Point>();
	}
	
	// points the user must try to go through
	public void addGoalPoint(float x, float y) {
		this.goalPoints.add(new GoalPoint(x, y));
		notifyListener();
	}
	
	public LinkedList<GoalPoint> getGoalPoints() {
		return this.goalPoints;
	}
	
	public LinkedList<Point> getDrawPoints() {
		return this.drawPoints;
	}
	
	// on event down, clear out whatever we had before.
	public void startNewDrawPath(float x, float y) {
		// start new draw path
		this.drawPoints = new LinkedList<Point>();
		
		// reset each goalpoint
		for (GoalPoint gp : goalPoints) {
			gp.status = GoalPoint.UNTOUCHED;
		}
	}
	
	// user is tracing w/ finger
	public void addDrawPoint(float x, float y) {
		Point new_point = new Point(x, y);
		drawPoints.add(new_point);
		
		// light up goal point if we hit it
		if (null == this.currentGoalPoint) {
			this.currentGoalPoint = this.goalPoints.getFirst();
		}
		if (new_point.intersects((Point) this.currentGoalPoint)) {
			this.currentGoalPoint.status = GoalPoint.TOUCHED;
			
			// TODO: refactor
			int prevIndex = goalPoints.indexOf(currentGoalPoint);
			if (prevIndex + 1 != goalPoints.size()) {
				this.currentGoalPoint = goalPoints.get(prevIndex + 1);
			}
		}
		
		notifyListener();
	}
	
	// listener
	public interface GameChangeListener {
		void onGameChange(Game game);
	}
	
	private GameChangeListener gameChangeListener;
	public void setGameChangeListener(GameChangeListener l) {
		gameChangeListener = l;
	}
	
	private void notifyListener() {
		if (null != gameChangeListener) {
			gameChangeListener.onGameChange(this);
		}
	}
}
