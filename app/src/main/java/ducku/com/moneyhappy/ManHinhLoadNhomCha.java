package ducku.com.moneyhappy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import ducku.com.moneyhappy.adapter.CategoryAdapter;
import ducku.com.moneyhappy.model.Category;

public class ManHinhLoadNhomCha extends AppCompatActivity {

    ListView lvCategory;
    ArrayList<Category> arrayCategory;
    CategoryAdapter adapter;
    Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_load_nhom_cha);

        Toolbar tb7 = findViewById(R.id.tb7);
        setSupportActionBar(tb7);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Nhóm cha");

        addControls();
        addEvents();

        new GetCategory().execute("act=getcategory&iduser=1&type=0&onlyparent=true");

    }

    private void addEvents() {
        lvCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent= new Intent(ManHinhLoadNhomCha.this, ManHinhTaoNhom.class);
                intent.putExtra("id_category", arrayCategory.get(position).get_id());
                intent.putExtra("NameCT",arrayCategory.get(position).get_name());
                intent.putExtra("Img",arrayCategory.get(position).get_img());
                startActivity(intent);
            }
        });
    }

    private void addControls() {
        lvCategory = (ListView) findViewById(R.id.lvctcha);
        arrayCategory = new ArrayList<>();
        res = getResources();



    }

    private class GetCategory extends api {
        @Override
        protected void onPostExecute(String s) {

            try {
                JSONArray array = new JSONArray(s);

                for(int i=0;i<array.length();i++)
                {
                    JSONObject obcategory=array.getJSONObject(i);
                    int id=obcategory.getInt("cid");
                    int parent_id=obcategory.getInt("parent");
                    String name=obcategory.getString("cname");
                    int idImg=res.getIdentifier(obcategory.getString("img"),"drawable",getPackageName());
                    arrayCategory.add(new Category(id,parent_id,idImg,name));

                    Log.d("Log",name);
                }
                adapter = new CategoryAdapter(ManHinhLoadNhomCha.this, 0, arrayCategory);
                lvCategory.setAdapter(adapter);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
