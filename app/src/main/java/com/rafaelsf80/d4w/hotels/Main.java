package com.rafaelsf80.d4w.hotels;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ViewAnimator;

/**
 * A simple launcher activity containing a summary sample description, sample log and a custom
 * {@link android.support.v4.app.Fragment} which can display a view.
 * <p>
 * For devices with displays with a width of 720dp or greater, the sample log is always visible,
 * on other devices it's visibility is controlled by an item on the Action Bar.
 */
public class Main extends FragmentActivity {

    public static final String TAG = "Main";

    // Whether the Log Fragment is currently shown
    private boolean mLogShown;
    public SlidingTabsColorsFragment fragment;
    public static ImageView img;
    public ActionBar actionBar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        actionBar = getActionBar();
        
        actionBar.setTitle(R.string.app_name);
        actionBar.setSubtitle(R.string.subtitle);
        
        // Load data and start fragments on PostExecute
        new DataTask(this, savedInstanceState).execute();
              
        // Set first image #0. Subsequent updates through static function showPicture()
        img = (ImageView) findViewById(R.id.imageHotelActivity);
        img.setImageResource(R.drawable.img1);
    }

    public static void showPicture(int i) {
    	Log.d("Main", "Showing image: "+Integer.toString(i));
       	switch(i){
		case 0:
			img.setImageResource(R.drawable.img1);
			break;
		case 1:
			img.setImageResource(R.drawable.img2);
			break;
		case 2:
			img.setImageResource(R.drawable.img3);
			break;
		case 3:
			img.setImageResource(R.drawable.img4);
			break;
		case 4:
			img.setImageResource(R.drawable.img5);
			break;
       	}
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem logToggle = menu.findItem(R.id.menu_toggle_log);
        logToggle.setVisible(findViewById(R.id.sample_output) instanceof ViewAnimator);
        logToggle.setTitle(mLogShown ? R.string.sample_hide_log : R.string.sample_show_log);

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_toggle_log:
                mLogShown = !mLogShown;
                ViewAnimator output = (ViewAnimator) findViewById(R.id.sample_output);
                if (mLogShown) {
                    output.setDisplayedChild(1);
                } else {
                    output.setDisplayedChild(0);
                }
                supportInvalidateOptionsMenu();
                return true;
        }
        return super.onOptionsItemSelected(item);
    } 
}
