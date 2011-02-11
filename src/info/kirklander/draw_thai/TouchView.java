package info.kirklander.draw_thai;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View;

public class TouchView extends View {
	public TouchView(Context context) {
		super(context);
		
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
		canvas.drawColor(Color.RED);
		
		Paint paint = new Paint();
		paint.setStyle(Style.FILL);
		paint.setColor(Color.BLUE);

//		canvas.drawCircle(100, 100, 5, paint);
		
		// TODO: all this shit should be in DrawThai
		Point p1 = new Point(50, 50);
		Point p2 = new Point(100, 100);
		PointSeries points = new PointSeries();
		points.addPoint(p1);
		points.addPoint(p2);
		
		points.setPointSeriesChangeListener(new PointSeries.PointSeriesChangeListener() {
			@Override 
			public void onPointSeriesChange(PointSeries ps) {
				
			}
		});
		
		for (Point point : points.getPoints()) {
			canvas.drawCircle(point.getX(), point.getY(), Point.RADIUS, paint);
		}

	}
}
