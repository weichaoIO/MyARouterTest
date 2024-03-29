package tsou.cn.module_chat.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;

import tsou.cn.lib_base.utils.RouteUtils;
import tsou.cn.module_chat.R;

@Route(path = RouteUtils.Chat_ForResult)
public class ForResultActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * finish
     */
    private Button mFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_result);
        initView();
    }

    private void initView() {
        mFinish = (Button) findViewById(R.id.finish);
        mFinish.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.finish) {
            Intent intent = new Intent();
            intent.putExtra("name", "ForResult返回的数据");
            setResult(999, intent);
            finish();
        } else {
        }
    }
}