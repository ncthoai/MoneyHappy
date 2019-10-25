package ducku.com.moneyhappy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class ManHinhDangKy extends AppCompatActivity {

    Button btnDangKy;
    EditText EditTextSDT;
    TextView twThongBao, twTieuDeKhung;
    String Status = "phone";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        addControls();
        addEvent();
    }

    private void addEvent() {

        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String QueryString = "act=register&"+Status+"="+EditTextSDT.getText().toString();
                Toast.makeText(ManHinhDangKy.this, "query string:\n\n"+ QueryString+"\n\n", Toast.LENGTH_SHORT).show();
                new goiDangKy().execute(QueryString);
            }
        });

    }
    private void addControls() {
        btnDangKy     = findViewById(R.id.btnDangKy);
        EditTextSDT   = findViewById(R.id.editTextSDT);
        twThongBao    = findViewById(R.id.twThongBao);
        twTieuDeKhung = findViewById(R.id.twSDT);
    }

    private class goiDangKy extends api {
        @Override
        protected void onPostExecute(String s) {
            JSONObject obj = null;
            try {
                obj = new JSONObject(s);
                String result = obj.getString("result");

                // Xu ly dang ky sdt
                if(Status.equals("phone")){
                    if(result.equals("OTP")){
                        //bla bla
                        twThongBao.   setText("Da gui ma OTP den "+EditTextSDT.getText().toString());
                        twTieuDeKhung.setText("Nhap ma OTP:");
                        btnDangKy.    setText("Xác Nhận");
                        Status = "phone="+EditTextSDT.getText().toString()+"&otp";
                        EditTextSDT.  setText("");

                    } else if(result.equals("ALREADY_EXIST")) {
                        twThongBao.setText("SDT da ton tai");

                    }else {
                        twThongBao.setText("Khong co ket noi den sv");

                    }
                }
                //Xu ly kich haot tai khoan
                else {
                    if(result.equals("true")) {
                        twThongBao.setText("Kich hoat thanh cong -> di den tao mk");
                    }
                    else{
                        twThongBao.setText("Sai ma OTP");
                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            Toast.makeText(ManHinhDangKy.this, "WEBSERVER-re:\n\n"+s+"\n\n", Toast.LENGTH_SHORT).show();
        }
    }

}
