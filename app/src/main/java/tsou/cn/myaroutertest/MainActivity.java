package tsou.cn.myaroutertest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import tsou.cn.myaroutertest.utils.FragmentUtils;

public class MainActivity extends AppCompatActivity {
    private ViewPager mMViewPager;
    private TabLayout mToolbarTab;

    /**
     * 图标
     */
    private int[] tabIcons = {
            R.drawable.tab_home,
            R.drawable.tab_weichat,
            R.drawable.tab_recommend,
            R.drawable.tab_user
    };
    private String[] tab_array;
    private DemandAdapter mDemandAdapter;
    private ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        // 给viewpager设置适配器
        setViewPagerAdapter();
        setTabBindViewPager();
        setItem();
    }

    private void initData() {
        tab_array = getResources().getStringArray(R.array.tab_main);
        fragments.clear();
        fragments.add(FragmentUtils.getHomeFragment());
        fragments.add(FragmentUtils.getChatFragment());
        fragments.add(FragmentUtils.getRecomFragment());
        fragments.add(FragmentUtils.getMeFragment());
    }

    private void initView() {
        mMViewPager = findViewById(R.id.mViewPager);
        mToolbarTab = findViewById(R.id.toolbar_tab);
    }

    private void setViewPagerAdapter() {
        mDemandAdapter = new DemandAdapter(getSupportFragmentManager());
        mMViewPager.setAdapter(mDemandAdapter);
    }

    private void setTabBindViewPager() {
        mToolbarTab.setupWithViewPager(mMViewPager);
    }

    private void setItem() {
        /**
         * 一定要在设置适配器之后设置Icon
         */
        for (int i = 0; i < mToolbarTab.getTabCount(); i++) {
            mToolbarTab.getTabAt(i).setCustomView(getTabView(i));
        }
    }

    public View getTabView(int position) {
        View view = LayoutInflater.from(this).inflate(R.layout.item_tab, null);
        ImageView tab_image = view.findViewById(R.id.tab_image);
        TextView tab_text = view.findViewById(R.id.tab_text);
        tab_image.setImageResource(tabIcons[position]);
        tab_text.setText(tab_array[position]);
        return view;
    }

    /**
     * 适配器
     */
    public class DemandAdapter extends FragmentStatePagerAdapter {
        public DemandAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}