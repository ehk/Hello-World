package com.sds.mi.cif;

import java.text.SimpleDateFormat;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class Test extends Activity {
    SensorManager sm;
    SensorEventListener accL;
    SensorEventListener oriL;    
    Sensor oriSensor;
    Sensor accSensor;
    TextView ax, ay, az;
    TextView ox, oy, oz;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
//        Intent intent = new Intent(this, SensorService.class);
//        startService(intent);
//        
//        System.out.println("intent");
//        try {
//        	Thread.sleep(5000);
//        } catch (InterruptedException ie) {
//        	ie.printStackTrace();
//        }
//        
//        stopService(intent); 
        
        
        
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);    // SensorManager 인스턴스를 가져옴            
        oriSensor = sm.getDefaultSensor(Sensor.TYPE_ORIENTATION);    // 방향 센서
        accSensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);    // 가속도 센서
        oriL = new oriListener();        // 방향 센서 리스너 인스턴스
        accL = new accListener();       // 가속도 센서 리스너 인스턴스
        ax = (TextView)findViewById(R.id.acc_x);
        ay = (TextView)findViewById(R.id.acc_y);
        az = (TextView)findViewById(R.id.acc_z);
        ox = (TextView)findViewById(R.id.ori_x);
        oy = (TextView)findViewById(R.id.ori_y);
        oz = (TextView)findViewById(R.id.ori_z);
    }
    
    @Override
    public void onResume() {
        super.onResume();
                
        sm.registerListener(accL, accSensor, SensorManager.SENSOR_DELAY_NORMAL);    // 가속도 센서 리스너 오브젝트를 등록
        sm.registerListener(oriL, oriSensor, SensorManager.SENSOR_DELAY_NORMAL);    // 방향 센서 리스너 오브젝트를 등록
    }
    
    @Override 
    public void onPause() {
        super.onPause();
        
       sm.unregisterListener(oriL);    // unregister acceleration listener
       sm.unregisterListener(accL);    // unregister orientation listener
    }
    
    
    private class accListener implements SensorEventListener {

    	int nextAcc = 0, accSize = 100;
    	int nextSam = 0, samSize = 20;
    	
    	AccelerometerData[] accs = new AccelerometerData[accSize];
    	Sample[] samples = new Sample[samSize];
    	
    	
        public void onSensorChanged(SensorEvent event) {  // 가속도 센서 값이 바뀔때마다 호출됨
        	
        	if(nextAcc < accSize)
        	{
        		accs[nextAcc] = new AccelerometerData();
        		//long time = new Date().getTime();
        		long time = System.currentTimeMillis();
        		SimpleDateFormat formatter = new SimpleDateFormat("MMdd - hh:mm:ss");
        		String timeStr = formatter.format(time);
        		System.out.println("timestamp: " + timeStr);
        		
        		accs[nextAcc].id = Integer.toString(nextAcc);
        		accs[nextAcc].timestamp = time;
	        	accs[nextAcc].x = (double) event.values[0];
	        	accs[nextAcc].y = (double) event.values[1];
	        	accs[nextAcc].z = (double) event.values[2];
	        	nextAcc++;
        	}
        	else
        	{
        		//System.out.println("100");
        		nextAcc = 0;
        	}
	        	
        	
        	
        	
        	ax.setText(Float.toString(event.values[0]));
            ay.setText(Float.toString(event.values[1]));
            az.setText(Float.toString(event.values[2]));
            
            
//            Log.i("SENSOR", "Acceleration changed.");
//            Log.i("SENSOR", "  Acceleration X: " + event.values[0]
//                          + ", Acceleration Y: " + event.values[1]
//                           + ", Acceleration Z: " + event.values[2]);
        }
        
        public void onAccuracyChanged(Sensor sensor, int accuracy) {    
        }
    }
    
    private class oriListener implements SensorEventListener {
        public void onSensorChanged(SensorEvent event) {  // 방향 센서 값이 바뀔때마다 호출됨
            ox.setText(Float.toString(event.values[0]));
            oy.setText(Float.toString(event.values[1]));
            oz.setText(Float.toString(event.values[2]));
//            Log.i("SENSOR", "Orientation changed.");
//            Log.i("SENSOR", "  Orientation X: " + event.values[0]
//                          + ", Orientation Y: " + event.values[1]
//                          + ", Orientation Z: " + event.values[2]);
        }
        
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            
        }
    }
}
