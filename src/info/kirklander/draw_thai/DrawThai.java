package info.kirklander.draw_thai;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;

public class DrawThai extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TouchView tv = new TouchView(this);
        
        ((ViewGroup) findViewById(R.id.main)).addView(tv);
    }
}