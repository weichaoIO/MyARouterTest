package tsou.cn.module_me.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;

import tsou.cn.lib_base.utils.RouteUtils;
import tsou.cn.module_me.R;

@Route(path = RouteUtils.Me_Test)
public class TestActivity extends AppCompatActivity {
    /**
     * 数据接收页面
     */
    private TextView mTextView;
    /**
     * eventBus返回数据
     */
    private Button mBtnBackData;
    private String extra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
        initData();
        initView();
    }

    private void initData() {
        extra = getIntent().getStringExtra("extra");

    }

    private void initView() {
        mTextView = (TextView) findViewById(R.id.textView);
        mBtnBackData = (Button) findViewById(R.id.btn_back_data);
        mBtnBackData.setText("finish");
        mBtnBackData.setVisibility(View.GONE);
        mTextView.setText("extra==>" + extra);
    }
}