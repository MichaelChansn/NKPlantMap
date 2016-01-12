package nankai.plant;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;

import nankai.globaldata.GlobalData;
import nankai.globaldata.StoreData;
import mutl.touch.sample.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.FloatMath;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class MainActivity extends Activity {

	private SurfaceView surfaceNanKaiMap;
	private SurfaceHolder surfaceHolderNanKaiMap;
	private static final int NONE = 0;
	private static final int DRAG = 1;
	private static final int ZOOM = 2;
	private int mode = NONE;
	private Matrix globalMatrix = new Matrix();
	private Matrix savedMatrix = new Matrix();
	private Matrix tmpMatrix=new Matrix();
	private PointF start = new PointF();
	private PointF mid = new PointF();
	private float oldDist;
	private  Bitmap  bmp;
	private int scaleWidth=0;
	private int scaleHeight=0;
	private int screenWidth=0;
	private int screenHeight=0;
	
	
	private boolean isSetOK=false;
	private ArrayList<PointF> pointCacheList=new ArrayList<PointF>(20);
	private Point pointhit=new Point();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		surfaceNanKaiMap=(SurfaceView)findViewById(R.id.surfaceView_nankaiMap);
		surfaceHolderNanKaiMap=surfaceNanKaiMap.getHolder();
		
		surfaceNanKaiMap.setOnTouchListener(new SurfaceViewNanKaiMapOnTouchListener());
		surfaceHolderNanKaiMap.addCallback(new SurfaceViewCallback());
		
		//ʹ��BitmapFactory.decodeResource������ȡ��ͼƬ���ڴ����
		//bmp=BitmapFactory.decodeResource(getResources(), R.drawable.nkditu);
		//ʹ��BitmapFactory.decodeStream���Դ����ͼƬ
//		BufferedInputStream bis = null;
//		try {
//			bis = new BufferedInputStream(getAssets().open("nkditu.jpg"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	    bmp = BitmapFactory.decodeStream(bis);
		
		/**
		 * ���Ƶ����ķ�Χ
		 */
		 WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
		 scaleWidth = wm.getDefaultDisplay().getWidth();
	     
		 
	     /**
	      * ���ݲ�ͬ�ֱ������ò�ͬ������ͼ
	      */
		 if(scaleWidth>480)
		    {
			 scaleWidth=53;
			 scaleHeight=70;
		    }
		    else
		    	if(scaleWidth>320 && scaleWidth<=480)
		    	{
		    		scaleWidth=26;
			    	scaleHeight=40; 
		    	}
		    	else
			    {
			    	scaleWidth=15;
			    	scaleHeight=25; 
			    }
		
		//��������ø��߼��ķ�����ȡͼƬ
		bmp=GlobalData.getMap(this, R.drawable.nkditu);
		//��ȡ����ͼ
		GlobalData.bmpThrumbnail=GlobalData.getSmallBitmapThrumbnail(this,R.drawable.tubiao);
		for(int i=0;i<500;i++)
		{
			pointCacheList.add(i, new PointF(0, 0));
			
		}
		
		// �жϳ����ǲ��ǵ�һ������
		if(StoreData.getDataFromSharePerferences(this))
		{
			//�Ѿ����ú�ֲ���ͼ��
			globalMatrix.set(GlobalData.globalMatrix);
			setpointCacheList();
			isSetOK=true;
		}
		else
		{
			//��һ�����г��򣬻�û���õ�ͼ��
			//globalMatrix=new Matrix();
			/**
			 * ���ú��Ժ�򿪴˴���
			 */
			
			 try {
				 if(GlobalData.copyXMLTosharedPreferences(this))
				 {
				
				System.out.println("д��ɹ�");
				StoreData.getDataFromSharePerferences(this);
				globalMatrix.set(GlobalData.globalMatrix);
				setpointCacheList();
				isSetOK=true;
				 }
				 else
				 {
					 System.out.println("����ʧ��");
					 isSetOK=false;
				 }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("д��ʧ��");
				isSetOK=false;
			}
			
			
			/**
			 * ���������ʱ��򿪴˴���
			 *
			isSetOK=false;
		     */
		
		}
		

	}

	private  class SurfaceViewCallback implements Callback 
	{

		@Override
		public void surfaceChanged(SurfaceHolder holder, int format, int width,
				int height) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void surfaceCreated(SurfaceHolder holder) {
			// TODO Auto-generated method stub
			//�мǣ���û�����activity�ĳ�ʼ��֮ǰ��oncreate���������е�view��û��ʾ��activity�ϣ����е�view�Ĵ�С����0
			screenWidth=surfaceNanKaiMap.getWidth();//wm.getDefaultDisplay().getWidth();
		     System.out.println("surfaceview�Ŀ����"+screenWidth);
		     screenHeight=surfaceNanKaiMap.getHeight();//wm.getDefaultDisplay().getHeight();
			showNanKaiMap();
			
		}

		@Override
		public void surfaceDestroyed(SurfaceHolder holder) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	private class SurfaceViewNanKaiMapOnTouchListener implements OnTouchListener  
	{

		@Override
		public boolean onTouch(View v, MotionEvent event) {
			// TODO Auto-generated method stub
			switch (event.getAction() & MotionEvent.ACTION_MASK) {
			case MotionEvent.ACTION_DOWN:
				savedMatrix.set(globalMatrix);
				start.set(event.getX(), event.getY());
				pointhit.set((int)event.getX(),(int)event.getY());
				mode = DRAG;
				break;
			case MotionEvent.ACTION_UP:
			case MotionEvent.ACTION_POINTER_UP:
				mode = NONE;
				
				//�жϵ����¼�
				if(pointhit.x>(event.getX()-scaleWidth) && pointhit.x<(event.getX()+scaleWidth) && pointhit.y>(event.getY()-scaleHeight) && pointhit.y<(event.getY()+scaleHeight))//(pointhit.equals((int)event.getX(), (int)event.getY()))
				{
					//�����¼�
					if(isSetOK)
					{
						//������Ӧ��activity
						pointInPlace(event);
					}
					else
					{
						//����ֲ������
						
						PointF pf=new PointF(event.getX(), event.getY());
						setThambnailPoints(pf);
						System.out.println(event.getX()+"   "+event.getY());
					}
				}
			
					//��������
					setGlobalPointF();
			
				break;
			/*case MotionEvent.ACTION_POINTER_UP:
				
				
				//��������
				setGlobalPointF();
				mode = NONE;
				
				break;*/
			case MotionEvent.ACTION_POINTER_DOWN:
				oldDist = spacing(event);
				if (oldDist > 10f) 
				{
					savedMatrix.set(globalMatrix);
					midPoint(mid, event);
					mode = ZOOM;
					//��������
					setGlobalPointF();
				}
				break;
			case MotionEvent.ACTION_MOVE:
				if (mode == DRAG) {
					
					if(Math.abs(event.getX() - start.x)>10 || Math.abs(event.getY()- start.y)>10)
					{
						globalMatrix.set(savedMatrix);
						globalMatrix.postTranslate(event.getX() - start.x, event.getY()- start.y);
					
						if(GlobalData.matrixCheck(globalMatrix,bmp, screenWidth, screenHeight))
						{
					
					       setpointCacheListInMove(event.getX(),event.getY());
					       tmpMatrix.set(globalMatrix);
						}
						else
						{
							globalMatrix.set(tmpMatrix);
						}
					}
					
				} else if (mode == ZOOM) {
					float newDist = spacing(event);
					if (newDist > 10f) {
					
						
						
						float scale = newDist / oldDist;
						
						
						globalMatrix.set(savedMatrix);
						globalMatrix.postScale(scale, scale, mid.x, mid.y);
						if(GlobalData.matrixCheck(globalMatrix,bmp, screenWidth, screenHeight))
						{
					
							setpointCacheListInZoom(event,scale);
							tmpMatrix.set(globalMatrix);
						}
						else
						{
							globalMatrix.set(tmpMatrix);
						}
						
						
												
					}
					
				
				break;
		       }

			
			
		}
		
			drawSurfacePicture();
			return true;
		}
		
	}
	
	
	public boolean ischose=false;
	public String strChosed=null;
	//String[] str=new String[] {GlobalData.jinYeNvZhenChinese,GlobalData.jinYeNvZhenChinese };
	
	private void setThambnailPoints( final PointF pf)
	{
		
		
		new AlertDialog.Builder(this)
		.setTitle("��ѡ��")
		.setIcon(android.R.drawable.ic_dialog_info)
		.setSingleChoiceItems(GlobalData.globalChinese,
		0, new DialogInterface.OnClickListener() {

		public void onClick(DialogInterface dialog,int which) {
			
			ischose=true;
			strChosed=GlobalData.globalChinese[which];
			GlobalData.globalIndex++;
			
			 pointCacheList.set(GlobalData.globalIndex-1, new PointF(pf.x, pf.y));
			 System.out.println(pf.x+"����֮ǰ"+ pf.y);
			 GlobalData.arraylistPointF.set(GlobalData.globalIndex-1, new PointF(pf.x, pf.y));
			 GlobalData.arraylistPlantName.set(GlobalData.globalIndex-1, GlobalData.hashMapPlantChinesetoEnglish.get(strChosed));
			// GlobalData.hashMapPlantThrumbnail.put(GlobalData.hashMapPlantChinesetoEnglish.get(strChosed), GlobalData.getSmallBitmapFromAssets(MainActivity.this, GlobalData.hashMapPlantChinesetoEnglish.get(strChosed)));
			
			/* Canvas canvs=surfaceHolderNanKaiMap.lockCanvas();
				canvs.drawBitmap(bmp, globalMatrix, null);
				//������������ֲ������ͼ
				for(int i=0;i<GlobalData.arraylistPointF.size();i++)
				{
					canvs.drawBitmap( GlobalData.hashMapPlantThrumbnail.get(GlobalData.arraylistPlantName.get(i)) , GlobalData.arraylistPointF.get(i).x,  GlobalData.arraylistPointF.get(i).y, null);
				}
				surfaceHolderNanKaiMap.unlockCanvasAndPost(canvs);*/
			 drawSurfacePicture();
		    dialog.dismiss();
		}
		})
		.setNegativeButton("ȡ��",new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				ischose=false;
				//GlobalData.globalIndex--;
			}
		}).show();
		
		
//		if(ischose)
//		{
//		 GlobalData.arraylistPointF.set(GlobalData.globalIndex-1, new PointF(event.getX(), event.getY()));
//		 GlobalData.arraylistPlantName.set(GlobalData.globalIndex-1, GlobalData.hashMapPlantChinesetoEnglish.get(strChosed));
//		 GlobalData.hashMapPlantThrumbnail.put(GlobalData.hashMapPlantChinesetoEnglish.get(strChosed), GlobalData.getBitmapFromAssets(MainActivity.this, GlobalData.hashMapPlantChinesetoEnglish.get(strChosed)+"SMALL"));
//		}
//		else
//		{
//			GlobalData.globalIndex--;
//		}
		
	}
	
	/**
	 * ����pointCacheList�ƶ���ʱ��
	 */
	void setpointCacheListInMove(float eventX,float eventY)
	{
		
		
		for(int i=0;i<GlobalData.globalIndex;i++)
		{
		 PointF pf=	GlobalData.arraylistPointF.get(i);
		 
		 pointCacheList.set(i, new PointF(pf.x+(eventX-start.x), pf.y+(eventY-start.y)));
		}
	}
	/**
	 * ����pointCacheList�����ŵ�ʱ��
	 */
	void setpointCacheListInZoom(MotionEvent event,float scale)
	{
		for(int i=0;i<GlobalData.globalIndex;i++)
		{
		  PointF pf=	GlobalData.arraylistPointF.get(i);
		  pointCacheList.set(i, new PointF((pf.x-mid.x)*scale+mid.x,(pf.y-mid.y)*scale+mid.y));
		}
	}
	
	
	/**
	 * ���д��������ж�
	 */
	void pointInPlace(MotionEvent event)
	{
		for(int i=0;i<GlobalData.globalIndex;i++)
		{
			PointF pf=GlobalData.arraylistPointF.get(i);
			//�ж��ǲ��Ǵ���ͼ�귶Χ֮�ڣ�ͼ���С��30*30��
			if(event.getX()>(pf.x-scaleWidth/2) && event.getX()<(pf.x+scaleWidth/2) &&event.getY()>(pf.y-scaleHeight) && event.getY()<pf.y)
			{
				Intent intent=new Intent(MainActivity.this, PlantActivity.class);
				intent.putExtra(GlobalData.INFO, i);
				startActivity(intent);
			}
		}
	}
	
	/**
	 * ��ʼ��pointCacheList����
	 */
	private void setpointCacheList()
	{
		for(int i=0;i<GlobalData.globalIndex;i++)
		{
			pointCacheList.set(i, GlobalData.arraylistPointF.get(i));
		}
	}
	
	
	/**
	 * �������µ�����ֵ
	 */
	private void setGlobalPointF()
	{
		for(int i=0;i<GlobalData.globalIndex;i++)
		{
			GlobalData.arraylistPointF.set(i, pointCacheList.get(i));
		}
	}
	/*
	 * �����϶��ľ��� 
	 */
	private float spacing(MotionEvent event) 
	{
		float x = event.getX(0) - event.getX(1);
		float y = event.getY(0) - event.getY(1);
		return FloatMath.sqrt(x * x + y * y);
	}

	/*
	 * ��������֮����м��
	 */
	private void midPoint(PointF point, MotionEvent event) 
	{
		float x = event.getX(0) + event.getX(1);
		float y = event.getY(0) + event.getY(1);
		point.set(x / 2, y / 2);
	}
	private synchronized void drawSurfacePicture()
	{
	
			Canvas canvs=surfaceHolderNanKaiMap.lockCanvas();
			canvs.drawColor(Color.GRAY);
			canvs.drawBitmap(bmp, globalMatrix, null);
			//������������ֲ������ͼ
			for(int i=0;i<GlobalData.globalIndex;i++)
			{
				//canvs.drawBitmap( GlobalData.hashMapPlantThrumbnail.get(GlobalData.arraylistPlantName.get(i)) , pointCacheList.get(i).x-15,  pointCacheList.get(i).y-15, null);
			
				canvs.drawBitmap( GlobalData.bmpThrumbnail , pointCacheList.get(i).x-(scaleWidth/2),  pointCacheList.get(i).y-scaleHeight, null);
			}
			surfaceHolderNanKaiMap.unlockCanvasAndPost(canvs);
		
		
	}
	
	
	private void showNanKaiMap()
	{
		if(!isSetOK)
		{
		Canvas canvs=surfaceHolderNanKaiMap.lockCanvas();
		//Bitmap bmp=BitmapFactory.decodeResource(getResources(), R.drawable.nkditu);	 
       	  //���ű���,��֤ͼƬ�߶Ⱥ��ֻ���Ļ�߶�һ��
       	  float fx=(float)surfaceNanKaiMap.getHeight()/bmp.getHeight();
       	  //��x���y���϶��Ŵ�fx�����ȱ�����
       	globalMatrix.setScale(fx, fx, 0, 0);

		canvs.drawBitmap(bmp, globalMatrix, null);
       	 
		surfaceHolderNanKaiMap.unlockCanvasAndPost(canvs);
		}
		else
		{
			Canvas canvs=surfaceHolderNanKaiMap.lockCanvas();
			canvs.drawBitmap(bmp, globalMatrix, null);
			//������������ֲ������ͼ
			for(int i=0;i<GlobalData.globalIndex;i++)
			{
				//canvs.drawBitmap( GlobalData.hashMapPlantThrumbnail.get(GlobalData.arraylistPlantName.get(i)) , GlobalData.arraylistPointF.get(i).x-15,  GlobalData.arraylistPointF.get(i).y-15, null);
			
				canvs.drawBitmap( GlobalData.bmpThrumbnail , pointCacheList.get(i).x-(scaleWidth/2),  pointCacheList.get(i).y-scaleHeight, null);
			}
			surfaceHolderNanKaiMap.unlockCanvasAndPost(canvs);
		}
	}
	
	
	
	
	
	
	
	
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		//�˳�֮ǰ�������ݵ��ֻ�
		GlobalData.globalMatrix.set(globalMatrix);
		StoreData.storedataTosharedPreferences(this);
		super.onDestroy();
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		switch(item.getItemId())
		{
		case R.id.action_settings:
			this.finish();
		
		}
		return super.onOptionsItemSelected(item);
	}
	

}
