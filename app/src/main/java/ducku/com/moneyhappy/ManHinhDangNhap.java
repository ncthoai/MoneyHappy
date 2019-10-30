package ducku.com.moneyhappy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class ManHinhDangNhap extends AppCompatActivity {

    EditText txtSDT,txtPassword;
    TextView twMsg;
    Button btnDangNhap;

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
                String tempSDT      = txtSDT.getText().toString();
                String tempPassword = txtPassword.getText().toString();
                new GoiDangNhap().execute("act=login&username="+tempSDT+"&password="+tempPassword);
            }
        });
    }

    private void addControls() {
        txtSDT=findViewById(R.id.txtSDT);

        txtSDT.setSelection(0);
        txtPassword=findViewById(R.id.txtPassword);

        twMsg = findViewById(R.id.textView2);

        btnDangNhap = findViewById(R.id.btnDangNhap);
    }

    private class GoiDangNhap extends api {
        @Override
        protected void onPostExecute(String s) {

            JSONObject obj = null;
            try {
                obj = new JSONObject(s);
                String result = obj.getString("result");
                if(result.equals("true")){
                    //bla bla
                    twMsg.setText("Dang nhap thanh cong");
                    Intent intent=new Intent(ManHinhDangNhap.this, ManHinhTaoVi.class);
                    startActivity(intent);
                } else {
                    //bla bla
                    twMsg.setText("Thong tin khong chinh xac \n Du lieu mau: PHONE/PW: 0329571692/123456");
                }
                //xoa pass
                txtPassword.setText("");

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }


}
