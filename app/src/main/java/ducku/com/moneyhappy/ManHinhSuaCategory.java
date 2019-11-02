package ducku.com.moneyhappy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

public class ManHinhSuaCategory extends AppCompatActivity {

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
        radthu=findViewById(R.id.radthu);
        radchi=findViewById(R.id.radchi);


        imghinhh=findViewById(R.id.imghinhh);
        imgVi=findViewById(R.id.imgvi);
        editVi=findViewById(R.id.editvi);
        imgNhomCha=findViewById(R.id.imgNhomCha);
        editNhomCha=findViewById(R.id.editNhomCha);
        editTexttennhom=findViewById(R.id.edittennhom);

    }

    private void addEvents()
    {

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
}
