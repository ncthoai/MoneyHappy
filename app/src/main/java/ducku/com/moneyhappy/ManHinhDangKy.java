package ducku.com.moneyhappy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ManHinhDangKy extends AppCompatActivity {

    Button btnDangKy;
    EditText EditTextSDT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        //addEvent();
        addControls();


        new layketqua().execute("name=hajiwon1023");
    }

    private void addEvent() {

        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //do ect
            }
        });

    }
    private void addControls() {
        btnDangKy   = findViewById(R.id.btnDangKy);
        EditTextSDT = findViewById(R.id.editTextSDT);
    }

    private class layketqua extends api {
        @Override
        protected void onPostExecute(String s) {
            EditTextSDT.setText(s);
        }
    }

}
