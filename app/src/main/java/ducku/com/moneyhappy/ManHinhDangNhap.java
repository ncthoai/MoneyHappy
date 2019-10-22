package ducku.com.moneyhappy;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ManHinhDangNhap extends AppCompatActivity {

    EditText EditTextMK;
    EditText EditTextSDT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        addControls();
//        addEvent();
    }

//    private void addEvent() {
//    }

    private void addControls() {
        EditTextMK  = findViewById(R.id.editTextMK);
        EditTextSDT = findViewById(R.id.editTextSDT);
    }
}
