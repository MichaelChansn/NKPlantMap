package nankai.globaldata;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.PointF;

public class StoreData {
	
	//
	public static final String sharePreID="HEHE";
	public static final String DATANUMBER="number";
	public static final String DATAPOINT="point";
	public static final String DATAPLANTNAME="name";
	public static final String DATAMATRIX="matrix";
			
	public static void storedataTosharedPreferences(Context context)
	{
		SharedPreferences sharedPreferences = context.getSharedPreferences(sharePreID, Context.MODE_PRIVATE);
		SharedPreferences.Editor edit = sharedPreferences.edit(); //�༭�ļ� 
		
		
		//�ȴ洢ֲ�����
		edit.putInt(DATANUMBER, GlobalData.globalIndex);
		//�洢����ֵ�����
		for(int i=0;i<GlobalData.globalIndex;i++)
		{
			//  �洢��ʽpointi-->X:Y
			edit.putString(DATAPOINT+i, GlobalData.arraylistPointF.get(i).x+":"+GlobalData.arraylistPointF.get(i).y);
			
		}
		//�洢ֲ�����ƺ����
		for(int ii=0;ii<GlobalData.globalIndex;ii++)
		{
			//  �洢��ʽnamei-->name
			edit.putString(DATAPLANTNAME+ii, GlobalData.arraylistPlantName.get(ii));
			
		}
		float[] values = new float[9];
		GlobalData.globalMatrix.getValues(values);
		for(int j=0;j<9;j++)
		{
			edit.putFloat(DATAMATRIX+j, values[j]);
			
		}
		edit.commit();
	}
	
	
	
	public static boolean getDataFromSharePerferences(Context context)
	{
		GlobalData.initparams();//��ʼ����������
		
		
		SharedPreferences sharedPreferences = context.getSharedPreferences(sharePreID, Context.MODE_PRIVATE);
		GlobalData.globalIndex=sharedPreferences.getInt(DATANUMBER, 0);
		if(GlobalData.globalIndex==0)//���û������
		{
			return false;
		}
		else
		{
			//��ȡ����ֵ
			
			for(int i=0;i<GlobalData.globalIndex;i++)
			{
				String str[]=sharedPreferences.getString(DATAPOINT+i, "null").split(":");
				PointF pf=new PointF(Float.parseFloat(str[0]), Float.parseFloat(str[1]));
				GlobalData.arraylistPointF.set(i, pf);
			}
			//��ȡֲ������ֵ
			for(int j=0;j<GlobalData.globalIndex;j++)
			{
				String str=sharedPreferences.getString(DATAPLANTNAME+j, "null");
				GlobalData.arraylistPlantName.set(j, str);
				//setHashMapThrumbnail(context, str);
			}
			//��ȡmatrixֵ
			float[] values = new float[9];
			for(int k=0;k<9;k++)
			{
				values[k]=sharedPreferences.getFloat(DATAMATRIX+k, 0);
			}
			GlobalData.globalMatrix.setValues(values);
			return true;
		}
		
		
	}
	
	/*private static void setHashMapThrumbnail(Context context,String str)
	{
		if(!GlobalData.hashMapPlantThrumbnail.containsKey(str))
		{
		GlobalData.hashMapPlantThrumbnail.put(str, GlobalData.getSmallBitmapFromAssets(context, str));
		}
		
	}
*/
}