package nankai.plant;

import nankai.globaldata.GlobalData;
import mutl.touch.sample.R;
import mutl.touch.sample.R.layout;
import mutl.touch.sample.R.menu;
import android.opengl.Visibility;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class PlantActivity extends Activity {

	private int index=0; 
	private String strIntroduce;
	private Bitmap bmpShow;
	private TextView textIntroduce;
	private ImageView imageShow;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_plant);
		textIntroduce=(TextView)findViewById(R.id.textView1);
		imageShow=(ImageView)findViewById(R.id.imageView1);
		
		Intent intent=getIntent();
		index=intent.getExtras().getInt(GlobalData.INFO);
		strIntroduce=GlobalData.hashMapPlantIntroduce.get(GlobalData.arraylistPlantName.get(index));
		bmpShow=GlobalData.getBigBitmapFromAssets(this,GlobalData.arraylistPlantName.get(index) );
		
		textIntroduce.setBackgroundColor(Color.argb(0, 0, 255, 0));
		textIntroduce.setText(strIntroduce);
		imageShow.setVisibility(View.GONE);
		textIntroduce.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				textIntroduce.setVisibility(View.GONE);
				imageShow.setImageBitmap(bmpShow);
				imageShow.setVisibility(View.VISIBLE);
				
			}
		});
		
		imageShow.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		
		
		
	}

	

}
