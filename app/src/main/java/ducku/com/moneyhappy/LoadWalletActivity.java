package ducku.com.moneyhappy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import ducku.com.moneyhappy.adapter.WalletAdapter;
import ducku.com.moneyhappy.model.Category;
import ducku.com.moneyhappy.model.Wallet;

public class LoadWalletActivity extends AppCompatActivity {

    ListView lvWallet;
    ArrayList<Wallet> arrayWallet;
    WalletAdapter adapter;
    Resources res;

    int idCategory, idImgCategory;
    String nameCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_wallet);

        addControls();
        addEvent();
        new GetWallet().execute("act=loadwallet");
    }


    private void addControls() {
        lvWallet = (ListView) findViewById(R.id.lv_wallet);
        arrayWallet = new ArrayList<>();
        adapter = new WalletAdapter(this, R.layout.custom_listview_wallet, arrayWallet);
        lvWallet.setAdapter(adapter);
        res = getResources();

        Intent intent = getIntent();
        idCategory = intent.getIntExtra("id_category", -1);
        nameCategory = intent.getStringExtra("name_category");
        idImgCategory = intent.getIntExtra("image_category", -1);

    }

    private void addEvent() {

        lvWallet.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(LoadWalletActivity.this, ManHinhChiTien.class);
                intent.putExtra("id_wallet", arrayWallet.get(position).get_id());
                intent.putExtra("name_wallet", arrayWallet.get(position).get_name());
                intent.putExtra("image_wallet", arrayWallet.get(position).get_img());

                intent.putExtra("id_category", idCategory);
                intent.putExtra("name_category", nameCategory);
                intent.putExtra("image_category", idImgCategory);

                startActivity(intent);
            }
        });
    }

    private class GetWallet extends api {
        @Override
        protected void onPostExecute(String s) {

            try {
                JSONArray array = new JSONArray(s);

                for (int i = 0 ; i < array.length(); i++) {
                    JSONObject wallet = array.getJSONObject(i);
                    int id = wallet.getInt("id");
                    int amount = wallet.getInt("amount");
                    String name =wallet.getString("name");
                    int idImg = res.getIdentifier(wallet.getString("image_name") , "drawable", getPackageName());
                    arrayWallet.add(new Wallet(id, amount, idImg, name));
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}
