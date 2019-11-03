package ducku.com.moneyhappy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

public class ManHinhSuaCategory extends AppCompatActivity {

    LinearLayout linear;
    int type;
    RadioButton radthu,radchi;
    ImageView imgVi, imgNhomCha, imghinhh;
    EditText editVi,editNhomCha,editTexttennhom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_sua_category);

        Toolbar tb9 = findViewById(R.id.tb9);
        setSupportActionBar(tb9);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Sửa nhóm");

        addControls();
        addEvents();
    }

    private void addControls() {
        linear=findViewById(R.id.linear);
        radthu=findViewById(R.id.radthu);
        radchi=findViewById(R.id.radchi);


        imghinhh=findViewById(R.id.imghinhh);
        imgVi=findViewById(R.id.imgvi);
        editVi=findViewById(R.id.editvi);
        imgNhomCha=findViewById(R.id.imgNhomCha);
        editNhomCha=findViewById(R.id.editNhomCha);
        editTexttennhom=findViewById(R.id.edittennhom);

        Intent intent=getIntent();
        String tennhom=intent.getStringExtra("name_ct");
        int id_ct=intent.getIntExtra("id_ct",-1);
        int img_ct=intent.getIntExtra("img_ct",-1);
        type=intent.getIntExtra("type",-1);
        String tenvi=intent.getStringExtra("name_wl");

        if(id_ct!=-1) {
            editTexttennhom.setText(tennhom);
            imghinhh.setImageResource(img_ct);
        }

        if(type==0)
        {
            radchi.setChecked(true);
        }
        else
            radthu.setChecked(true);

        editVi.setText(tenvi);




    }

    private void addEvents()
    {
        linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ManHinhSuaCategory.this,ManHinhLoadNhomCha1.class);
                intent.putExtra("type",type);
                startActivityForResult(intent,1);
            }
        });
        imgNhomCha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ManHinhSuaCategory.this,ManHinhLoadNhomCha1.class);
                intent.putExtra("type",type);
                startActivityForResult(intent,1);
            }
        });

        editNhomCha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ManHinhSuaCategory.this,ManHinhLoadNhomCha1.class);
                intent.putExtra("type",type);
                startActivityForResult(intent,1);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menutaonhom,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                int id_category =data.getIntExtra("id_ct",-1);
                String NameCT=data.getStringExtra("name_ct");
                int Img_cha=data.getIntExtra("img",-1);

                if(id_category!=-1) {
                    editNhomCha.setText(NameCT);
                    imgNhomCha.setImageResource(Img_cha);
                }
            }

            if(resultCode ==RESULT_CANCELED)
            {
                editNhomCha.setText("Có thể chọn nhóm cha hoặc không");
            }
        }
    }
}
