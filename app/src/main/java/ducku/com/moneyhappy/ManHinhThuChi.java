package ducku.com.moneyhappy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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
    ArrayList<Category> arrayCategory, arrayCategory2;
    CategoryAdapter adapter, adapter2;
    Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_thu_chi);

        Toolbar tb =  findViewById(R.id.tb2);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Củ cải");


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

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                Intent intent= new Intent(ManHinhThuChi.this,ManHinhChiTien.class);
                startActivity(intent);
                break;
            case R.id.menu1:
                //code xử lý khi bấm menu1
                break;
            case R.id.menu2:
                //code xử lý khi bấm menu2
                break;
            case R.id.menu4:
                //code xử lý khi bấm menu3
                break;
            default:break;
        }

        return super.onOptionsItemSelected(item);
    }
    private void addEvents() {
    }

    private void addControls() {
        lvCategoryChi =  findViewById(R.id.lvchi);
        lvCategoryThu=findViewById(R.id.lvthu);

        arrayCategory = new ArrayList<>();
        arrayCategory2 = new ArrayList<>();

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
                    arrayCategory2.add(new Category(id,parent_id,idImg,name));
                    Log.d("Log",name);
                }
                adapter2 = new CategoryAdapter(ManHinhThuChi.this, 0, arrayCategory2);
                lvCategoryChi.setAdapter(adapter2);

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
