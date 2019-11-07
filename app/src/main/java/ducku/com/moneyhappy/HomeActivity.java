package ducku.com.moneyhappy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import ducku.com.moneyhappy.adapter.PageTransactionAdapter;
import ducku.com.moneyhappy.adapter.TransactionAdapter;
import ducku.com.moneyhappy.model.Transaction;

public class HomeActivity extends AppCompatActivity {

    private List<Transaction> transactionList = new ArrayList<>();
    private TransactionAdapter adapter;
    private RecyclerView rvDeal;
    ViewPager pager;
    PageTransactionAdapter pageTransactionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bindView();
    }

    private void bindView() {

        pager = findViewById(R.id.vpTransaction);
        pageTransactionAdapter = new PageTransactionAdapter(getSupportFragmentManager());
//        pageTransactionAdapter.add(TransactionFragment.newInstance(10, 2019), "Thang 10");
//        pageTransactionAdapter.add(TransactionFragment.newInstance(11, 2019), "Thang 11");
        pager.setAdapter(pageTransactionAdapter);

        TabLayout tabMonTransaction = findViewById(R.id.tabMonthTransaction);
        tabMonTransaction.setupWithViewPager(pager);

        pager.setCurrentItem(6);

//        pager.setOffscreenPageLimit(1);
        //pager.setCurrentItem(pageTransactionAdapter.getCount());

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(HomeActivity.this, position+"", Toast.LENGTH_SHORT).show();
                pager.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


}
