package ducku.com.moneyhappy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import ducku.com.moneyhappy.adapter.CategoryAdapter;
import ducku.com.moneyhappy.model.Category;

public class ManHinhNhom extends AppCompatActivity {

    ImageButton imgchonvi;
    ListView lvCategoryChi, lvCategoryThu;
    ArrayList<Category> arrayCategory, arrayCategory2;
    CategoryAdapter adapter, adapter2;
    Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_nhom);

        addControls();
        addEvents();
        new GetCategoryChi().execute("act=getcategory&iduser=1&type=0");
        new GetCategoryThu().execute("act=getcategory&iduser=1&type=1");
    }

    private void addControls() {
        imgchonvi=findViewById(R.id.imgchonvi);
        lvCategoryChi =  findViewById(R.id.lvKhoanChi);
        lvCategoryThu=findViewById(R.id.lvkhoanthu);

        arrayCategory = new ArrayList<>();
        arrayCategory2 = new ArrayList<>();

        res = getResources();
    }

    private void addEvents()
    {
        imgchonvi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ManHinhNhom.this,ManHinhVi.class);
                startActivity(intent);
            }
        });
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
                adapter2 = new CategoryAdapter(ManHinhNhom.this, 0, arrayCategory2);
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
                adapter = new CategoryAdapter(ManHinhNhom.this, 0, arrayCategory);
                lvCategoryThu.setAdapter(adapter);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
