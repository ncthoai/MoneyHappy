package ducku.com.moneyhappy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import ducku.com.moneyhappy.adapter.CategoryAdapter;
import ducku.com.moneyhappy.model.Category;

public class ManHinhThuChi extends AppCompatActivity {

    ListView lvCategory;
    ArrayList<Category> arrayCategory;
    CategoryAdapter adapter;
    Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_thu_chi);

        TabHost tabHost=findViewById(R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec tab1=tabHost.newTabSpec("t1");
        tab1.setIndicator("Thu tiền");
        tab1.setContent(R.id.tab1);
        tabHost.addTab(tab1);

        TabHost.TabSpec tab2=tabHost.newTabSpec("t2");
        tab2.setIndicator("Chi tiền");
        tab2.setContent(R.id.tab2);
        tabHost.addTab(tab2);

        addControls();
        addEvents();
        new GetCategory().execute("act=getcategory&iduser=1&type=1");
    }

    private void addEvents() {
    }

    private void addControls() {
        lvCategory =  findViewById(R.id.lvtest);
        arrayCategory = new ArrayList<>();
        res = getResources();
    }

    private class GetCategory extends api {
        @Override
        protected void onPostExecute(String s) {

            try {
                JSONArray array = new JSONArray(s);
                Log.d("Log",array.length()+"");
//                for (int i = 0 ; i < array.length(); i++) {
//                    JSONObject category = array.getJSONObject(i);
//                    int id = category.getInt("id");
//                    int parent_id = category.getInt("parent_id");
//                    String name =category.getString("name");
//                    int idImg = res.getIdentifier(category.getString("image_name") , "drawable", getPackageName());
//
//                    arrayCategory.add(new Category(id, parent_id, idImg, name));
//
//                    adapter.notifyDataSetChanged();
//                }

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
                lvCategory.setAdapter(adapter);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
