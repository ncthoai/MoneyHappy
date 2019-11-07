package ducku.com.moneyhappy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ducku.com.moneyhappy.R;
import ducku.com.moneyhappy.model.Transaction;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder> {

    private Context context;
    private List<Transaction> transactionList;

    public TransactionAdapter(Context context, List<Transaction> transactionList) {
        this.context = context;
        this.transactionList = transactionList;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.deal_item, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return transactionList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        // get deal item from list at position
        Transaction transaction = transactionList.get(position);

        // display info to item view holder
        viewHolder.tvNameCategory.setText(transaction.getDescription());
        viewHolder.tvDescription.setText(transaction.getDescription());
        viewHolder.tvPrice.setText(String.valueOf(transaction.getAmount()));
        viewHolder.tvPrice2.setText(String.valueOf(transaction.getAmount()));
        viewHolder.ivThumbnailCategory.setImageResource(transaction.getImageCategory());
        viewHolder.ivThumbnailWallet.setImageResource(transaction.getImageWallet());
        viewHolder.tvCreated.setText(transaction.getCreated());
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNameCategory;
        TextView tvDescription;
        TextView tvPrice;
        TextView tvPrice2;
        TextView tvCreated;
        ImageView ivThumbnailCategory;
        ImageView ivThumbnailWallet;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameCategory = itemView.findViewById(R.id.tvNameCategory);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            ivThumbnailCategory = itemView.findViewById(R.id.ivThumbnailCategory);
            ivThumbnailWallet = itemView.findViewById(R.id.ivThumbnailWallet);
            tvCreated = itemView.findViewById(R.id.tvCreated);
            tvPrice2 = itemView.findViewById(R.id.tvPrice2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showItem(getAdapterPosition());
                }
            });
        }
    }

    private void showItem(int position) {
        Transaction transaction = transactionList.get(position);
        Toast.makeText(context, transaction.getDescription(), Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(context, ManHinhGiaoDich.class);
//        context.startActivity(intent);
    }
}

