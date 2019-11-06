package ducku.com.moneyhappy;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;

import ducku.com.moneyhappy.adapter.IconAdapter;

public class ManHinhLoadIcon extends AppCompatActivity  {

    TextView tv1;
    GridView gv1;
    Integer[]mThumbIds;
    IconAdapter adapter = null;
    Bundle myBackupBundle;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            myBackupBundle = savedInstanceState;
            setContentView(R.layout.activity_man_hinh_chon_icon);
            tv1 = (TextView) findViewById(R.id.tv1);
            mThumbIds = new Integer[]{R.drawable.chi_bank, R.drawable.chi_browser, R.drawable.chi_bus, R.drawable.chi_conversation, R.drawable.chi_fries, R.drawable.chi_phone, R.drawable.chi_sick, R.drawable.chi_taxi, R.drawable.chi_wine, R.drawable.thu_boss, R.drawable.thu_palm, R.drawable.thu_map, R.drawable.thu_satute};
            gv1 = (GridView) findViewById(R.id.gridview);
            adapter = new IconAdapter(this, mThumbIds);
            gv1.setAdapter(adapter);
            gv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                    Object o = gv1.getItemAtPosition(position);
                    Toast.makeText(ManHinhLoadIcon.this, "Selected", Toast.LENGTH_SHORT).show();
                }
            });
        }
    };
    //private void addControl()
   // {
//        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.);
//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
//        byte[] byteArray = stream.toByteArray();
    //}

