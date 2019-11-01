package ducku.com.moneyhappy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ManHinhHienThiChiTietNhom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_hien_thi_chi_tiet_nhom);

        Toolbar tb6 = findViewById(R.id.tb6);
        setSupportActionBar(tb6);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("");
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
                Intent intent= new Intent(ManHinhHienThiChiTietNhom.this,ManHinhNhom.class);
                startActivity(intent);
                break;
            case R.id.menuedit:
                //code xử lý khi bấm menu1
                break;
            case R.id.menudelete:
                //code xử lý khi bấm menu2
                break;
            case R.id.menu4:
                //code xử lý khi bấm menu3
                break;
            default:break;
        }

        return super.onOptionsItemSelected(item);
    }
}
