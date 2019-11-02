package ducku.com.moneyhappy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bindView();
    }

    private void bindView() {

        ViewPager pager = findViewById(R.id.vpTransaction);
        PageTransactionAdapter pageTransactionAdapter = new PageTransactionAdapter(getSupportFragmentManager());
//        pageTransactionAdapter.add(TransactionFragment.newInstance(10, 2019), "Thang 10");
//        pageTransactionAdapter.add(TransactionFragment.newInstance(11, 2019), "Thang 11");
        pager.setAdapter(pageTransactionAdapter);

        TabLayout tabMonTransaction = findViewById(R.id.tabMonthTransaction);
        tabMonTransaction.setupWithViewPager(pager);

        pager.setCurrentItem(pageTransactionAdapter.getCount() - 1);
    }

}
