package tsou.cn.module_chat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;

import tsou.cn.lib_base.utils.RouteUtils;

@Route(path = RouteUtils.Chat_Fragment_Main)
public class MainFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weichat, null);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}