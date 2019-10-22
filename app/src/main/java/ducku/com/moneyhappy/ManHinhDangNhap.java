package ducku.com.moneyhappy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ManHinhDangNhap extends AppCompatActivity {
    Button btnDangNhap;
    EditText EditTextMK;
    EditText EditTextSDT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        addControls();
//        addEvent();
    }

    private void addEvent() {
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new layketqua().execute("name=hajiwon1023");
            }
        });
    }

    private void addControls() {
        EditTextMK  = findViewById(R.id.editTextMK);
        EditTextSDT = findViewById(R.id.editTextSDT);
        btnDangNhap = findViewById(R.id.btnDangNhap);
    }

    private class layketqua extends api {
        @Override
        protected void onPostExecute(String s) {
            EditTextSDT.setText(s);
        }
    }
}
