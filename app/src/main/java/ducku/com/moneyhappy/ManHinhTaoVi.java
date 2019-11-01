package ducku.com.moneyhappy;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ManHinhTaoVi extends AppCompatActivity {

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_tao_vi);

        toolbar=findViewById(R.id.tb1);
        setSupportActionBar(toolbar);

        adControls();
        addEvent();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menutaovi,menu);
        return true;
    }
    @Override
    public  boolean onOptionsItemSelected(MenuItem item)
    {
        //Bắt sự kiện (+)
        switch (item.getItemId())
        {
            case R.id.menu1:
                Intent intent= new Intent(ManHinhTaoVi.this, ManHinhGiaoDich.class);
                startActivity(intent);
                break;
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void addEvent() {

    }

    private void adControls() {


    }
}
