package com.wjzabc.easylockscreen;

import android.app.Service;
import android.app.WallpaperInfo;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;

public class LockScreenService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Button btn = new Button(this);
        btn.setText("����");
        btn.setOnTouchListener(new OnTouchListener() {
            
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    
                    break;
                case MotionEvent.ACTION_MOVE:
                    
                    break;
                case MotionEvent.ACTION_UP:
                    
                    break;

                default:
                    break;
                }
                return false;
            }
        });
        
        btn.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                PowerManager mPowerMgr = (PowerManager) getSystemService(Context.POWER_SERVICE);
                mPowerMgr.goToSleep(SystemClock.uptimeMillis());
            }
        });
        
        LayoutParams wmParams = new LayoutParams();

        //����window type  
        wmParams.type = LayoutParams.TYPE_PHONE;   
        //����ͼƬ��ʽ��Ч��Ϊ����͸��  
        wmParams.format = PixelFormat.RGBA_8888;   
        //���ø������ڲ��ɾ۽���ʵ�ֲ���������������������ɼ����ڵĲ�����  
        wmParams.flags = LayoutParams.FLAG_NOT_FOCUSABLE;        
        //������������ʾ��ͣ��λ��Ϊ����ö�  
        wmParams.gravity = Gravity.LEFT | Gravity.TOP;         
        // ����Ļ���Ͻ�Ϊԭ�㣬����x��y��ʼֵ�������gravity  
        wmParams.x = 0;  
        wmParams.y = 0;  
        //�����������ڳ�������    
        wmParams.width = WindowManager.LayoutParams.WRAP_CONTENT;  
        wmParams.height = WindowManager.LayoutParams.WRAP_CONTENT;  
        
        /*// �����������ڳ������� 
        wmParams.width = 200; 
        wmParams.height = 80;*/ 
        
        wm.addView(btn, wmParams);
        
        
    }
    
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub
        return super.onStartCommand(intent, flags, startId);
        
    }
    
    @Override
    @Deprecated
    public void onStart(Intent intent, int startId) {
        // TODO Auto-generated method stub
        super.onStart(intent, startId);
    }

}
