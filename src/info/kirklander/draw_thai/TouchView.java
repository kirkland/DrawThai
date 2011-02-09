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

		canvas.drawCircle(100, 100, 5, paint);
	}
}
