package ducku.com.moneyhappy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import ducku.com.moneyhappy.adapter.CategoryAdapter;
import ducku.com.moneyhappy.model.Category;

public class ManHinhNhom extends AppCompatActivity {

    ImageView imgadd;
    TextView txtNameWl;
    ImageButton imgchonvi;
    ListView lvCategoryThuChi;
    ArrayList<Category> arrayCategory;
    CategoryAdapter adapter;
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
        Intent intent=getIntent();
        String name_wl= intent.getStringExtra("NameWallet");
        txtNameWl= findViewById(R.id.txtNameWl);
        txtNameWl.setText(name_wl);

        imgadd= findViewById(R.id.imgAdd);


        imgchonvi=findViewById(R.id.imgchonvi);
        lvCategoryThuChi =  findViewById(R.id.lvKhoanChi);


        arrayCategory = new ArrayList<>();

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

        imgadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManHinhNhom.this, ManHinhTaoNhom.class);
                startActivity(intent);
            }
        });

        lvCategoryThuChi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(txtNameWl.getText().toString()=="")
                {
                    Toast.makeText(ManHinhNhom.this,"Bạn chưa chọn ví!, hãy nhấp vào" +
                            " nút bên phải phía trên để chọn ví ^^",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(ManHinhNhom.this, ManHinhHienThiChiTietNhom.class);
                    intent.putExtra("id_ct", arrayCategory.get(position).get_id());
                    intent.putExtra("name_ct", arrayCategory.get(position).get_name());
                    intent.putExtra("img_ct", arrayCategory.get(position).get_img());
                    intent.putExtra("id_parent", arrayCategory.get(position).get_parentId());
                    intent.putExtra("type", arrayCategory.get(position).get_type());

                    intent.putExtra("name_wl", txtNameWl.getText().toString());



                    startActivity(intent);
                }
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
                    int type=obcategory.getInt("type");
                    int idImg=res.getIdentifier(obcategory.getString("img"),"drawable",getPackageName());
                    arrayCategory.add(new Category(id,parent_id,idImg,type,name));
                }
                adapter = new CategoryAdapter(ManHinhNhom.this, 0, arrayCategory);
                lvCategoryThuChi.setAdapter(adapter);

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
                    int type=obcategory.getInt("type");
                    int idImg=res.getIdentifier(obcategory.getString("img"),"drawable",getPackageName());
                    arrayCategory.add(new Category(id,parent_id,idImg,type,name));

                }
                adapter = new CategoryAdapter(ManHinhNhom.this, 0, arrayCategory);
                lvCategoryThuChi.setAdapter(adapter);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}
