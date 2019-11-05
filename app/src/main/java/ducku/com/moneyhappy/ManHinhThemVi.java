package ducku.com.moneyhappy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ManHinhThemVi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_them_vi);


        Toolbar tb10 = findViewById(R.id.tb10);
        setSupportActionBar(tb10);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle("Thêm ví");

        addControls();
        addEvents();
    }

    private void addEvents() {
    }

    private void addControls() {
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menutaonhom,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.menu1:
                //code xử lý khi bấm menu1
                break;
            default:break;
        }

        return super.onOptionsItemSelected(item);
    }
}
