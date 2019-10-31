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

    public class ViewHolder {
        ImageView img;
        TextView txtName, txtAmount;
    }


    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder = new ViewHolder();

            // ánh xạ View
            holder.txtName = (TextView) convertView.findViewById(R.id.txtName);
            holder.txtAmount = (TextView) convertView.findViewById(R.id.txtAmount);
            holder.img = (ImageView) convertView.findViewById(R.id.imageviewImg);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        // gán giá trị
        Wallet wallet = walletList.get(i);
        holder.txtName.setText(wallet.get_name());
        holder.txtAmount.setText(wallet.get_amount()+" đ");
        holder.img.setImageResource(wallet.get_img());

        return convertView;
    }

}
