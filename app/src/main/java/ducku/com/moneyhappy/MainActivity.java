package ducku.com.moneyhappy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Button btnDangNhap;
    Button btnDangKy;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvent();
    }

    private void addEvent() {
        setSupportActionBar(toolbar);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, ManHinhDangNhap.class);
                startActivity(intent1);
            }
        });

        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, ManHinhDangKy.class);
                startActivity(intent2);
            }
        });

    }

    private void addControls() {
        btnDangNhap = findViewById(R.id.btnDangNhap);
        btnDangKy   = findViewById(R.id.btnDangKy);
        toolbar     = findViewById(R.id.tb);
    }
}
