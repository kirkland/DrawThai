package info.kirklander.draw_thai;

import info.kirklander.draw_thai.DrawPath.DrawPoint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View;

public class TouchView extends View {
	private final PointSeries points;
	private final DrawPath drawPath;
	
	public TouchView(Context context, PointSeries points, DrawPath drawPath) {
		super(context);
		
		this.points = points;
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
		
		// holds previous coords so we can draw line from them to current point
		float prev_x = 0, prev_y = 0;
		
		paint.setColor(Color.BLACK);
		for (DrawPoint drawPoint : drawPath.getDrawPoints()) {
			if (prev_x != 0 && prev_y != 0) {
				canvas.drawLine(prev_x, prev_y, drawPoint.getX(), drawPoint.getY(), paint);
			}
			prev_x = drawPoint.getX(); prev_y = drawPoint.getY();
		}
		
		for (Point point : points.getPoints()) {
			paint.setColor(point.color());
			canvas.drawCircle(point.getX(), point.getY(), Point.RADIUS, paint);
		}

	}
}
