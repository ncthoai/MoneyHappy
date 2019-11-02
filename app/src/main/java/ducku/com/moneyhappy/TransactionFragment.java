package ducku.com.moneyhappy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ducku.com.moneyhappy.adapter.TransactionAdapter;
import ducku.com.moneyhappy.model.Transaction;

public class TransactionFragment extends Fragment {

    private static final String KEY_MONTH = "month";
    private static final String KEY_YEAR = "year";

    public static TransactionFragment newInstance(int month, int year) {
        TransactionFragment fragment = new TransactionFragment();
        Bundle agrs = new Bundle();
        agrs.putInt(KEY_MONTH, month);
        agrs.putInt(KEY_YEAR, year);
        fragment.setArguments(agrs);
        return fragment;
    }

    private int month, year;

    private List<Transaction> transactionList = new ArrayList<>();
    private TransactionAdapter adapter;
    private RecyclerView rvTransaction;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        month = getArguments().getInt(KEY_MONTH);
        year = getArguments().getInt(KEY_YEAR);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.transaction_fragment, null);

        RecyclerView rvTransaction = view.findViewById(R.id.rvTransaction);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        adapter = new TransactionAdapter(getContext(), transactionList);
        rvTransaction.setLayoutManager(layoutManager);
        rvTransaction.setAdapter(adapter);

        loadData();
        return view;
    }

    private void loadData() {
        // load your data here, in this, I create some example of data
        if(month % 2 == 0 ) {
            for (int i = 1; i <= month; i++) {
                Transaction transaction = new Transaction(i,  R.drawable.icon_fb, i, i, "Giao dịch thứ " + i, "mô tả thứ " + i, i * 1000);
                transactionList.add(transaction);
            }
        }
        else  {
            for (int i = 1; i <= 20; i++) {
                Transaction transaction = new Transaction(i,  R.drawable.icon_gg, i, i, "Giao dịch thứ " + i, "mô tả thứ " + i, i * 10500);
                transactionList.add(transaction);
            }
        }
        // change data to display on view
        adapter.notifyDataSetChanged();
    }
}
