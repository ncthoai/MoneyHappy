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
import android.widget.TextView;
import android.widget.Toast;

public class ManHinhHienThiChiTietVi extends AppCompatActivity {

    ImageView imgluunha;
    EditText editnamenha;
    TextView txtsotien;
    LinearLayout line4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_hien_thi_chi_tiet_vi);

        Toolbar tb11 = findViewById(R.id.tb11);
        setSupportActionBar(tb11);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Chi tiết ví");

        addControls();
        addEvents();
    }

    private void addEvents() {
    }

    private void addControls() {
        line4=findViewById(R.id.line4);
        imgluunha=findViewById( R.id.imgluunha);
        editnamenha=findViewById(R.id.editnamenha);
        txtsotien=findViewById(R.id.txtSoTien);

        Intent intent=getIntent();

        String name_ct=intent.getStringExtra("name_wl");
        int amount=intent.getIntExtra("amount_wl",-1);

        editnamenha.setText(name_ct);
        txtsotien.setText(amount+" đ");

        imgluunha.setVisibility(View.INVISIBLE);

    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menuchitietnhom,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.menuedit:
                imgluunha.setVisibility(View.VISIBLE);
                editnamenha.setEnabled(true);
                Toast.makeText(ManHinhHienThiChiTietVi.this,"Bạn đang ở trong trạng thái sửa ví",Toast.LENGTH_LONG).show();
                break;
            case R.id.menudelete:
                //code xử lý khi bấm menu2
                break;
            default:break;
        }

        return super.onOptionsItemSelected(item);
    }

}
