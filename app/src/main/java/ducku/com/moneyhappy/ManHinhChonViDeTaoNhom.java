package ducku.com.moneyhappy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import ducku.com.moneyhappy.adapter.WalletAdapter;
import ducku.com.moneyhappy.model.Wallet;

public class ManHinhChonViDeTaoNhom extends AppCompatActivity {

    ListView lvWallet;
    ArrayList<Wallet> arrayWallet;
    WalletAdapter adapter;
    Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chon_vi_de_tao_nhom);

        Toolbar tb5 = findViewById(R.id.tb5);
        setSupportActionBar(tb5);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Chọn Ví");

        addControls();
        addEvents();

        new GetWallet().execute("act=loadwallet");
    }

    private void addEvents() {
        lvWallet.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(ManHinhChonViDeTaoNhom.this, ManHinhTaoNhom.class);
                intent.putExtra("Name",arrayWallet.get(position).get_name());
                startActivity(intent);
            }
        });
    }

    private void addControls() {
        lvWallet = (ListView) findViewById(R.id.lvgetwl);
        arrayWallet = new ArrayList<>();
        res = getResources();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                Intent intent= new Intent(ManHinhChonViDeTaoNhom.this,ManHinhTaoNhom.class);
                startActivity(intent);
                break;
            case R.id.menu1:
                //code xử lý khi bấm menu1
                break;
            default:break;
        }

        return super.onOptionsItemSelected(item);
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

                adapter = new WalletAdapter(ManHinhChonViDeTaoNhom.this, R.layout.custom_listview_wallet, arrayWallet);
                lvWallet.setAdapter(adapter);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
