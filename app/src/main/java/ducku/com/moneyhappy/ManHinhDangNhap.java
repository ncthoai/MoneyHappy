package ducku.com.moneyhappy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import ducku.com.moneyhappy.model.Preferences;

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
                new GoiDangNhap().execute("act=login&phone="+tempSDT+"&password="+tempPassword);
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
                String accountId = obj.getString("account_id");
                String checkWallet = obj.getString("wallet");
                if(accountId.equals("false")){
                    //bla bla
                    twMsg.setText("Thong tin khong chinh xac \n Du lieu mau: PHONE/PW: 0329571692/123456");
                } else {
                    //bla bla
                    twMsg.setText("Dang nhap thanh cong");
                    Preferences.saveUser(ManHinhDangNhap.this, accountId);
                    Intent intent;

                    if(checkWallet.equals("true")) {
                        intent=new Intent(ManHinhDangNhap.this, HomeActivity.class);
                    }
                    else {
                        intent=new Intent(ManHinhDangNhap.this, ManHinhTaoVi.class);
                    }
                    startActivity(intent);
                }
                //xoa pass
                txtPassword.setText("");

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }


}
