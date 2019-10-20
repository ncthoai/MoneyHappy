package ducku.com.moneyhappy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button btnDangNhap;
    Toolbar toolbar;
    EditText etxtUserName;
    EditText etxtPassWord;
    String urlCheckLogin = "http://vietsever.tk/views/v_login/checkLogIn.php";
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
                String _username = etxtUserName.getText().toString().trim();
                String _pass = etxtPassWord.getText().toString().trim();

                checkLogin(_username, _pass);
            }
        });
    }

    private void addControls() {
        btnDangNhap=findViewById(R.id.btnDangNhap);
        toolbar=findViewById(R.id.tb);
        etxtUserName = findViewById(R.id.userName);
        etxtPassWord = findViewById(R.id.passWord);
    }

    private void checkLogin(final String userName, final String passWord) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlCheckLogin,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String a = response.trim();
                        String b = userName+passWord;
                        if(response.trim().equals("success")){
                            Toast.makeText(MainActivity.this, "Login OK", Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(MainActivity.this, ManHinhTaoVi.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Login Failse", Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
                ){
                    protected Map getParams() throws AuthFailureError
                    {
                        Map params = new HashMap();
                        params.put("username", userName);
                        params.put("password", passWord);

                        return params;
                    }
                };
                requestQueue.add(stringRequest);
    }
}
