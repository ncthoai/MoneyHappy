package ducku.com.moneyhappy.model;

import android.content.res.Resources;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import ducku.com.moneyhappy.R;
import ducku.com.moneyhappy.adapter.TransactionAdapter;
import ducku.com.moneyhappy.api;

public class TransactionAPI extends api {

    private List<Transaction> transactionList;
    private TransactionAdapter adapter;


    protected void onPostExecute(String s) {

        try {
            JSONArray array = new JSONArray(s);
            for(int i=0;i<array.length();i++)
            {
                JSONObject object=array.getJSONObject(i);
                int id=object.getInt("id");
                int type_id=object.getInt("type_id");
                int wallet_id=object.getInt("wallet_id");
                int category_id=object.getInt("category_id");
                String category_name=object.getString("category_name");
                String descript=object.getString("descript");
                int imgage_category= R.drawable.icon_fb;
                int image_wallet=R.drawable.icon_gg;
                int amount=object.getInt("amount");
                String created=object.getString("created");
                Transaction transaction = new Transaction(id, type_id, wallet_id, category_id, amount, imgage_category, image_wallet, category_name, created, descript);
                transactionList.add(transaction);

            }
            adapter.notifyDataSetChanged();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
