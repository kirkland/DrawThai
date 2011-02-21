package info.kirklander.draw_thai;

import info.kirklander.draw_thai.DrawPath.DrawPoint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View;

public class TouchView extends View {
	// since we can't see what's under our figure, add this as an offset
	static float TOUCH_OFFSET = (float) 0.0;
	
	private final DrawPath drawPath;
	
	public TouchView(Context context, DrawPath drawPath) {
		super(context);
		
		this.drawPath = drawPath;
		
		// TODO: a smarter way to fill in all available space
		setMinimumWidth(1000);
		setMinimumHeight(1000);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(getSuggestedMinimumWidth(), getSuggestedMinimumHeight());
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(Color.WHITE);
		
		Paint paint = new Paint();
		paint.setStyle(Style.FILL);
		
		for (Point point : drawPath.getGoalPoints().getPoints()) {
			paint.setColor(point.color());
			canvas.drawCircle(point.getX(), point.getY(), Point.RADIUS, paint);
		}
		
		// holds previous coords so we can draw line from them to current point
		float prev_x = 0, prev_y = 0;
		
		paint.setColor(Color.BLACK);
		paint.setStrokeWidth(10);
		for (DrawPoint drawPoint : drawPath.getDrawPoints()) {
			if (prev_x != 0 && prev_y != 0) {
				canvas.drawLine(prev_x, prev_y - TOUCH_OFFSET, drawPoint.getX(), drawPoint.getY() - TOUCH_OFFSET, paint);
			}
			prev_x = drawPoint.getX(); prev_y = drawPoint.getY();
		}
	}
}
