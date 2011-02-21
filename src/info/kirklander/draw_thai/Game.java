package info.kirklander.draw_thai;

import java.util.LinkedList;

public class Game {
	private LinkedList<GoalPoint> goalPoints;
	private LinkedList<Point> drawPoints;
	
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
		drawPoints.add(new Point(x, y));
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
