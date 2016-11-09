package note.com.chapter_01;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    @InjectView(R.id.button)
    Button mButton;


    /*第一章:Activity的生命周期和启动模式

    1.1 Activity的生命周期全面分析

    1.1.1 典型情况下的生命周期分析

    (1)Acticity第一次被启动  onCreate()->onStart()->onResume()

    (2)用户打开新的Activity或者切换到桌面的时候 onPause()->onStop()

    (3)当用户再次回到原Activity的时候 onRestart()->onStart()->onResume()

    (4)当用户按住Back键时 onPause()->onStop()->onDestroy()


    1.1.2异常情况下的生命周期

    (1)当系统配置发生变化时,Activity就会被销毁并且重新创建(比如手机横竖屏切换)

    意外销毁: onPause()->onSaveInstanceState()->onStop()->onDestroy()

    重新创建:onCreate()->onRestoreInstanceState()->onStart()->onResume()

    (2)资源内存不足导致优先级低的Activity被杀死

    Activity的优先级:

    前台Activity,正在和用户交互的Activity,有优先级别最高

    可见但非前台Activity,优先级次之

    后台Activity即已经被暂停的Activity,优先级最低

    (3)如果我们不想系统重新创建Activity,可以给Activity指定configChanges属性

    如果不想让屏幕旋转时重新创建,可以给onfigChanges属性添加orientation这个值

     android:configChanges="orientation"

     android:configChanges="orientation|mcc|mnc|locale|touchscreen|keyboard
             |keyboardHidden|navigation|screenLayout|fontScale|uiMode|screenSize
             |smallestScreenSize|layoutDirection">


     1.2 Activity的启动模式

     1.2.1 Activity的launchMode

     默认情况下,当我们多次启动同一个Activity的时候,系统会创建多个实例并把它们一一放入任务栈中
     当我们按住back键的时候,Activity会一一回退。任务栈是一种先进后出的栈结构

     目前有四种启动模式:standard,singleTop,singleTask,singleInstance

     (1)standard(标准模式):

     系统默认的模式,每启动一个Activity都会重新创建一个新的实例,不管这个实例是否已经存在

     (2)singleTop(栈顶复用模式)

     如果新的Activity已经处于任务栈的栈顶,那么此Activity不会被重新创建,同时它的onNewIntent方法
     会被调用,如果新的Activity的实例已经存在但不是位于栈顶,那么新Activity实例仍然会被重新创建

     (3)singleTask(栈内复用模式)

     只要一个Activity在栈中存在,那么多次启动此Activity都不会重新创建实例

     (4)singleInstance(单实例模式)
    */


    /**
     * Activity 被创建 ,这是生命周期的第一个方法,在这个方法里做一些初始化工作
     * 比如调用setContentView去加载布局文件
     * @param savedInstanceState
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e(TAG, "onCreate()方法执行了");

        ButterKnife.inject(this);

        clickEvent();

        //option+command+k   对生命周期进行排序(Android studio的插件 LifeCycle)

        //control+shift+a    ADB工具类(Android studio的插件 ADB idea)

    }

    /**
     * Activity正在重新启动,一般情况下,当前Activity从不可见变为可见状态时,此方法会被调用
     * <p/>
     * 比如用户按住Home键或者用户打开了一个新的Acivity,这时当前的Activity就会暂停,也就是onPause和onStop
     * <p/>
     * 被执行了,接着用户又回到了这个Activity,就会出现这种情况
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart()方法执行了");
    }

    /**
     * 表示Actiivty正在被启动,即将开始,这是Activity已经可见了,但是还没有出现在前台,还无法和用户交互
     * <p/>
     * 可以理解为Activity已经显示出来了,但是我们还看不到
     */
    @Override
    protected void onStart() {
        super.onStart();

        Log.e(TAG, "onStart()方法执行了");
    }

    /**
     * Activity已经可见了,并且出现在前台开始活动
     */

    @Override
    protected void onResume() {
        super.onResume();

        Log.e(TAG, "onResume()方法执行了");
    }

    /**
     * Activity正在停止,接着onStop方法会被调用
     */
    @Override
    protected void onPause() {
        super.onPause();

        Log.e(TAG, "onPause()方法执行了");
    }

    /**
     * Activity即将停止,可以做一些回收工作,但不能耗时
     */
    @Override
    protected void onStop() {
        super.onStop();

        Log.e(TAG, "onStop()方法执行了");
    }

    /**
     * Activity即将被销毁,最后的一个回调,可以做一些回收工作和资源的释放
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.e(TAG, "onDestroy()方法执行了");
    }

    private void clickEvent()
    {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(mIntent);
            }
        });
    }


    /**
     * 当系统配置发生变化的时候会调用该方法
     * @param newConfig
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        Log.e(TAG,"onConfigurationChanged方法执行了");
    }
}
