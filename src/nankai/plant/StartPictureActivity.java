package nankai.plant;

import mutl.touch.sample.R;
import mutl.touch.sample.R.layout;
import mutl.touch.sample.R.menu;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;

public class StartPictureActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.startpictureactivity);
		
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				 intent.setClass(StartPictureActivity.this, MainActivity.class);
				 StartPictureActivity.this.startActivity(intent);
				 StartPictureActivity.this.finish();
				 StartPictureActivity.this.overridePendingTransition(R.anim.zoom_enter,R.anim.zoom_exit);
			}
		}, 1000);
	
	}


 
}
