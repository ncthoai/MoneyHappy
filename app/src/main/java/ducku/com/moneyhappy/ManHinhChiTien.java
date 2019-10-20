package ducku.com.moneyhappy;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class ManHinhChiTien extends AppCompatActivity  {

    Spinner spLoai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chi_tien);
        
        addControls();
        addEvents(); 
    }

    private void addEvents() {
    }

    private void addControls() {

        spLoai=findViewById(R.id.spin);
        String[] loai = new String[]{
                "Thu tiền",
                "Chi tiền",
        };

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,R.layout.custom_spinner
        ,loai);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spLoai.setAdapter(spinnerArrayAdapter);



    }



}
