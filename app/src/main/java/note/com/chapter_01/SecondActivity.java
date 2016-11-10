package note.com.chapter_01;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by zhoujian on 16/9/11.
 */
public class SecondActivity extends Activity {

    private static final String TAG = "SecondActivity";
    private String mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate()方法执行了");
        if(savedInstanceState!=null){
            mName = savedInstanceState.getString("name");
            Log.e(TAG,"onCreate="+mName);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart()方法执行了");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart()方法执行了");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume()方法执行了");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause()方法执行了");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop()方法执行了");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy()方法执行了");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("name","周建");
        Log.e(TAG,"onSaveInstanceState方法执行了");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //快捷键:option+command+f   快速提取变量
        String mName =  savedInstanceState.getString("name");
        Log.e(TAG,"onRestoreInstanceState="+mName);
    }
}
