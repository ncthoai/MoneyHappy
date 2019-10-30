package ducku.com.moneyhappy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ducku.com.moneyhappy.R;
import ducku.com.moneyhappy.model.Category;
import ducku.com.moneyhappy.model.Wallet;

public class WalletAdapter extends BaseAdapter {


    private Context context;
    private  int layout;
    private List<Wallet> walletList;

    public WalletAdapter(Context context, int layout, List<Wallet> walletList) {
        this.context = context;
        this.layout = layout;
        this.walletList = walletList;
    }

    @Override
    public int getCount() {
        return walletList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Wallet wallet = walletList.get(i);
        convertView = inflater.inflate(layout, null);



        // ánh xạ View
        TextView txtName = (TextView) convertView.findViewById(R.id.txtName);
        TextView txtAmount = (TextView) convertView.findViewById(R.id.txtAmount);
        ImageView img = (ImageView) convertView.findViewById(R.id.imageviewImg);


        // gán giá trị
        txtName.setText(wallet.get_name());
        txtAmount.setText(wallet.get_id()+" đ");
        img.setImageResource(wallet.get_img());

        return convertView;
    }

}
