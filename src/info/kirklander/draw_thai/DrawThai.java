package info.kirklander.draw_thai;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class DrawThai extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final EditText text1 = (EditText) findViewById(R.id.text1);
        final EditText text2 = (EditText) findViewById(R.id.text2);
        
        final TouchView tv = new TouchView(this);
        
        ((ViewGroup) findViewById(R.id.main)).addView(tv);
        
        tv.setOnTouchListener(new View.OnTouchListener() {
        	@Override
        	public boolean onTouch(View v, MotionEvent event) {
        		if (MotionEvent.ACTION_DOWN != event.getAction()) {
        			return false;
        		}
        		
        		// circle is at 100,100, so tell distance from that point.
        		float ydif = Math.abs(event.getX() - 100);
        		float xdif = Math.abs(event.getY() - 100);
        		float distance = (float) Math.sqrt(xdif*xdif + ydif*ydif);
        		
        		text1.setText("" + distance);
        		
        		return true;
        	} });

    }
}