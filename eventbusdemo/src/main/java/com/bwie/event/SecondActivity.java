package com.bwie.event;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class SecondActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv = (TextView) findViewById(R.id.tv2);

        //注册EventBus，哪里需要值哪里就需要注册
        EventBus.getDefault().register(this);

    }
    //这两种注解都行，如果有不是同一个响应订阅类型的时候就需要在前面指定，只要逗号拼接这个sticky = true就行
    //@Subscribe(threadMode = ThreadMode.MainThread,sticky = true) //在ui线程执行
    @Subscribe(sticky = true)
    public void onEventMainThread(FirstEvent event) {
        String msg = "onEventMainThread收到了消息：" + event.getMsg();
        Log.d("harvic", msg);
        tv.setText(msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
    //生命周期
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);//反注册EventBus
    }

}
