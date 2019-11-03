package ducku.com.moneyhappy.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ducku.com.moneyhappy.TransactionFragment;

public class PageTransactionAdapter extends FragmentStatePagerAdapter {

    public static final  int NUM_TAB = 21;

    public PageTransactionAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Calendar calendar = getCalendarAt(position);

        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);

        return TransactionFragment.newInstance(month, year);
    }

    @Override
    public int getCount() {
        return NUM_TAB;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        Calendar calendar = getCalendarAt(position);

        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);

        return "Tháng " + month + " / " + year;
    }

    private Calendar getCalendarAt(int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, i - NUM_TAB + 1);

        return calendar;
    }
}