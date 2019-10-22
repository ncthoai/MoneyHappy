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
    String Querry;
    //test
    long time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        addControls();
        addEvent();
    }

    private void addEvent() {
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Querry = "act=login&username="+EditTextSDT.getText()+"&password="+EditTextMK.getText();
                //EditTextSDT.setText(Querry);
                time = System.currentTimeMillis();
                new layketqua().execute(Querry);
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
            long temp = System.currentTimeMillis() - time;
            double a = temp / 1000.0;
            EditTextSDT.setText(s+ "- " + a +" sec" );
        }
    }
}
