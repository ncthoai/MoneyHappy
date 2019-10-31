package ducku.com.moneyhappy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TabHost;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import ducku.com.moneyhappy.adapter.CategoryAdapter;
import ducku.com.moneyhappy.model.Category;

public class ManHinhThuChi extends AppCompatActivity {

    ListView lvCategoryChi, lvCategoryThu;
    ArrayList<Category> arrayCategory;
    CategoryAdapter adapter;
    Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_thu_chi);

        final TabHost tabHost=findViewById(R.id.tabhost);
        tabHost.setup();

        final TabHost.TabSpec tab1=tabHost.newTabSpec("t1");
        tab1.setIndicator("Thu tiền");
        tab1.setContent(R.id.tab1);
        tabHost.addTab(tab1);

        TabHost.TabSpec tab2=tabHost.newTabSpec("t2");
        tab2.setIndicator("Chi tiền");
        tab2.setContent(R.id.tab2);
        tabHost.addTab(tab2);

        addControls();
        addEvents();
        new GetCategoryChi().execute("act=getcategory&iduser=1&type=0");
        new GetCategoryThu().execute("act=getcategory&iduser=1&type=1");


    }

    private void addEvents() {
    }

    private void addControls() {
        lvCategoryChi =  findViewById(R.id.lvchi);

        lvCategoryThu=findViewById(R.id.lvthu);
        arrayCategory = new ArrayList<>();
        res = getResources();
    }

    private class GetCategoryChi extends api {
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
                adapter = new CategoryAdapter(ManHinhThuChi.this, 0, arrayCategory);
                lvCategoryChi.setAdapter(adapter);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private class GetCategoryThu extends api {
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
                adapter = new CategoryAdapter(ManHinhThuChi.this, 0, arrayCategory);
                lvCategoryThu.setAdapter(adapter);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
