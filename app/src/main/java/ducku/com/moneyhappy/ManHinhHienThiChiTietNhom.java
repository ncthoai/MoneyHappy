package ducku.com.moneyhappy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DownloadManager;
import android.content.Intent;
import android.content.res.Resources;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import ducku.com.moneyhappy.adapter.CategoryAdapter;
import ducku.com.moneyhappy.model.Category;

public class ManHinhHienThiChiTietNhom extends AppCompatActivity {

    int type;
    int id_ct;
    int img_ct;
    ArrayList<Category> arrayCategory;
    Resources res;
    ImageView imgct,imgvi,imgnhomcha,imgnhom;
    TextView txtct,txtvi,txtnhomcha,txttype;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_hien_thi_chi_tiet_nhom);

        Toolbar tb6 = findViewById(R.id.tb6);
        setSupportActionBar(tb6);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Chi tiết nhóm");
        
        addControls();
        addEvents();

    }

    private void addEvents() {
        imgnhom = (ImageView) findViewById(R.id.imgnhom);
        imgnhom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int2 = new Intent(view.getContext(),ManHinhLoadIcon.class);
                startActivity(int2);
            }
        });
    }

    private void addControls() {

        imgct=findViewById(R.id.imgnhom);
        txtct=findViewById(R.id.txtnhomhienthi);

        imgnhomcha=findViewById(R.id.imgnhomcha);
        txtnhomcha=findViewById(R.id.txtNhomCha);

        imgvi=findViewById(R.id.imgvi);
        txtvi=findViewById(R.id.txtTenVi);

        txttype=findViewById(R.id.txttype);

        Intent intent=getIntent();
        id_ct=intent.getIntExtra("id_ct",-1);
        img_ct=intent.getIntExtra("img_ct",-1);
        String name_ct=intent.getStringExtra("name_ct");
        int id_parent=intent.getIntExtra("id_parent",-1);
        type=intent.getIntExtra("type",-1);
        String name_wl=intent.getStringExtra("name_wl");

        ReadJSOn("https://vietsever.tk/?act=getcategory&cid="+id_parent+"");

        if(id_ct!=-1)
        {
            imgct.setImageResource(img_ct);
            txtct.setText(name_ct);
            txtvi.setText(name_wl);
        }
        if(type==0)
        {
            txttype.setText("Khoản chi");
        }
        else
            txttype.setText("Khoản thu");


        if(id_parent==0)
        {
            imgnhomcha.setVisibility(View.INVISIBLE);
            txtnhomcha.setVisibility(View.INVISIBLE);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menuchitietnhom,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.menuedit:
                Intent intent= new Intent(ManHinhHienThiChiTietNhom.this,ManHinhSuaCategory.class);
                intent.putExtra("name_ct",txtct.getText().toString());
                intent.putExtra("id_ct",id_ct);
                intent.putExtra("img_ct",img_ct);
                intent.putExtra("type",type);
                intent.putExtra("name_wl",txtvi.getText().toString());
                startActivity(intent);
                break;
            case R.id.menudelete:
                //code xử lý khi bấm menu2
                break;
            default:break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void ReadJSOn(String url)
    {

        RequestQueue requestQueue= Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            txtnhomcha.setText(response.getString("cname"));
                           int img=ManHinhHienThiChiTietNhom.this.getResources().getIdentifier(
                                   response.getString("img"),
                                   "drawable",
                                   ManHinhHienThiChiTietNhom.this.getPackageName()
                           );

                           imgnhomcha.setImageResource(img);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonObjectRequest);

    }
}
