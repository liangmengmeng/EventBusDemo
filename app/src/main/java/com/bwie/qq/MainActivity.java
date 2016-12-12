package com.bwie.qq;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button bt;
    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(getApplicationContext(), "Authorize succeed", Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText( getApplicationContext(), "Authorize fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText( getApplicationContext(), "Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };
    private Button bt_weixin;
    private Button bt_xinlang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = (Button) findViewById(R.id.bt_qq);
        bt_weixin = (Button) findViewById(R.id.bt_weixin);
        bt_xinlang = (Button) findViewById(R.id.bt_wxinlang);
        //QQ登录
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UMShareAPI mShareAPI = UMShareAPI.get( MainActivity.this );
                mShareAPI.doOauthVerify(MainActivity.this, SHARE_MEDIA.QQ, umAuthListener);
            }
        });
        //微信登录
        bt_weixin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UMShareAPI mShareAPI = UMShareAPI.get( MainActivity.this );
                mShareAPI.doOauthVerify(MainActivity.this, SHARE_MEDIA.WEIXIN, umAuthListener);
            }
        });
        //新浪微博登录
        bt_xinlang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UMShareAPI mShareAPI = UMShareAPI.get( MainActivity.this );
                mShareAPI.doOauthVerify(MainActivity.this, SHARE_MEDIA.SINA, umAuthListener);
            }
        });
    }

}
