package info.kirklander.draw_thai;

import android.content.Context;
import android.view.View;

public class GameView extends View {
	public GameView(Context context, Game game) {
		super(context);
		
		// TODO: a smarter way to fill in all available space
		setMinimumWidth(1000);
		setMinimumHeight(1000);
	}
}
