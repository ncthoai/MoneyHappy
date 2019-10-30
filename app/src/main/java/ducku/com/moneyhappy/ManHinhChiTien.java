package ducku.com.moneyhappy;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ManHinhChiTien extends AppCompatActivity {

    LinearLayout choiceCategory;
    EditText edtCategory;
    TextView txtIdCategory;
    EditText edtWallet;
    TextView txtIdWallet;
    ImageView imgWallet;
    ImageView imgCategory;
    ImageView imgcalendar;
    Calendar calendar=Calendar.getInstance();
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

    EditText edtMoney, edtDescript, edtCalendar;

    int idCategory, idImgCategory, idWallet, idImgWallet;
    String nameCategory, nameWallet;

    // btn save
    LinearLayout convertBtnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chi_tien);

        addControls();
        addEvents();
    }

    private void addEvents() {
        edtCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ManHinhChiTien.this, LoadCategoryActivity.class);
                intent.putExtra("id_wallet", idWallet);
                intent.putExtra("name_wallet", nameWallet);
                intent.putExtra("image_wallet", idImgWallet);
                startActivity(intent);
            }
        });

        edtWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ManHinhChiTien.this, LoadWalletActivity.class);
                intent.putExtra("id_category", idCategory);
                intent.putExtra("name_category", nameCategory);
                intent.putExtra("image_category", idImgCategory);
                startActivity(intent);
            }
        });


        convertBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtCalendar.getText().toString().isEmpty() || edtMoney.getText().toString().isEmpty() || txtIdCategory.getText().toString().isEmpty() || txtIdWallet.getText().toString().isEmpty()) {
                    // Show notify here
                    Toast.makeText(ManHinhChiTien.this, "Chọn danh mục, Ví và Ko để trống trường ...", Toast.LENGTH_SHORT).show();
                }
                else{
                    // Handle logic Save here

                    String descript = edtDescript.getText().toString();
                    String created = edtCalendar.getText().toString();
                    String monney = edtMoney.getText().toString();
                    String url = "act=save_transaction&wallet_id="+idWallet+"&category_id="+idCategory+"&descript="+descript+"&created="+created+"&amount="+monney;
                    new SaveTransaction().execute("act=save_transaction&wallet_id="+idWallet+"&category_id="+idCategory+"&descript="+descript+"&created="+created+"&amount="+monney);
                }
            }
        });

        //Xử lý hiển thị DatePicker
        imgcalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyNgay();
            }
        });
    }

    private void xuLyNgay() {
        final Calendar calendar=Calendar.getInstance();
        int ngay=calendar.get(Calendar.DATE);
        int thang=calendar.get(Calendar.MONTH);
        int nam=calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog= new DatePickerDialog(this, AlertDialog.THEME_DEVICE_DEFAULT_DARK, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(i,i1,i2);
                SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd/MM/yyyy");
                edtCalendar.setText(simpleDateFormat.format(calendar.getTime()));
            }
        },nam,thang,ngay);
        datePickerDialog.show();
    }


    private void addControls() {

        choiceCategory = findViewById(R.id.choiceCategory);
        edtCategory = findViewById(R.id.edtCategory);
        edtWallet = findViewById(R.id.edtWallet);
        txtIdCategory = findViewById(R.id.txtIdCategory);
        txtIdWallet = findViewById(R.id.txtIdWallet);
        imgCategory = findViewById(R.id.imgQuestion);
        imgWallet = findViewById(R.id.imgWallet);



        edtCalendar = findViewById(R.id.edtCalendar);
        edtDescript = findViewById(R.id.edtDescript);
        edtMoney = findViewById(R.id.edtMoney);
        convertBtnSave = findViewById(R.id.convertBtnSave);

        //Xử lý ngày
        imgcalendar=findViewById(R.id.imgCalendar);
        calendar=Calendar.getInstance();
        edtCalendar.setText(sdf.format(calendar.getTime()));


        Intent intent = getIntent();
        idCategory = intent.getIntExtra("id_category", -1);
        nameCategory = intent.getStringExtra("name_category");
        idImgCategory = intent.getIntExtra("image_category", -1);
        idWallet = intent.getIntExtra("id_wallet", -1);
        nameWallet = intent.getStringExtra("name_wallet");
        idImgWallet = intent.getIntExtra("image_wallet", -1);

        if( idCategory != -1) {
            edtCategory.setText(nameCategory);
            txtIdCategory.setText(idCategory+"");
            imgCategory.setImageResource(idImgCategory);
        }

        if( idWallet != -1) {
            edtWallet.setText(nameWallet);
            txtIdWallet.setText(idWallet + "");
            imgWallet.setImageResource(idImgWallet);
        }
    }


    private class SaveTransaction extends api { // hiện tại mặc định save là khoản chi
        protected void onPostExecute(String s) {

            JSONObject obj = null;
            try {
                obj = new JSONObject(s);
                String result = obj.getString("result");
                if(result.equals("true")){
                    Toast.makeText(ManHinhChiTien.this, "Save Success!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(ManHinhChiTien.this, "Error!", Toast.LENGTH_LONG).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
