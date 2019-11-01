package ducku.com.moneyhappy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class ManHinhHienThiGiaoDich extends AppCompatActivity {

    ImageButton btnimgthemgd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_hien_thi_giao_dich);

        Toolbar tb8 = findViewById(R.id.tb8);
        setSupportActionBar(tb8);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Giao dịch Demo");

        addControls();
        addEvents();
    }

    private void addControls() {
        btnimgthemgd=findViewById(R.id.btnimgthemgd);
    }

    private void addEvents()
    {
        btnimgthemgd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ManHinhHienThiGiaoDich.this, ManHinhGiaoDich.class);
                startActivity(intent);
            }
        });

    }

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
                Intent intent= new Intent(ManHinhHienThiGiaoDich.this,ManHinhTaoVi.class);
                startActivity(intent);
                break;
            case R.id.menuhd:
                //code xử lý khi bấm menu2
                break;
            case R.id.menunhom:
                Intent intent2= new Intent(ManHinhHienThiGiaoDich.this,ManHinhNhom.class);
                startActivity(intent2);
                break;
            default:break;
        }

        return super.onOptionsItemSelected(item);
    }
}
