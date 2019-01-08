package com.example.administrator.gia4banh;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner spinner1, spinner3;
    int baohiem, giadamphan, phitruocba, phiduongbo, phibienso, phidangkiem, tong;
    TextView baohiem1, giadamphan1, phitruocba1, phiduongbo1, phibienso1,phidangkiem1, tong1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phidangkiem = 340000;
        phiduongbo = 1560000;
        spinner1 = findViewById(R.id.spinner1);
        spinner3 = findViewById(R.id.spinner3);
        phibienso1 = findViewById(R.id.bienso1);
        phiduongbo1 = findViewById(R.id.phisddb1);
        phidangkiem1 = findViewById(R.id.dangkiem1);
        giadamphan1 = findViewById(R.id.giadamphan1);
        phitruocba1 = findViewById(R.id.phitruocba1);
        tong1 = findViewById(R.id.tong1);
        baohiem1 = findViewById(R.id.baohiem1);

        final DbHelpter db = new DbHelpter(this);

        Resources resources = getResources();

        final String[] pro = resources.getStringArray(R.array.product_aray);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, pro);
        spinner1.setAdapter(adapter);

        final String[] pla = resources.getStringArray(R.array.place_aray);
        ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, pla);
        spinner3.setAdapter(adapter1);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int pos = spinner1.getSelectedItemPosition();
                if (pos > 0) {
                    giadamphan = db.getPrice(pos);
                    giadamphan1.setText(String.valueOf(db.getPrice(pos)) + " đ");
                    baohiem1.setText(String.valueOf(db.getSochongoi(pos)));
                    if (db.getSochongoi(pos) <= 4) {
                        baohiem = 437000;
                        baohiem1.setText(baohiem + " đ");
                    } else {
                        baohiem = 794000;
                        baohiem1.setText(baohiem + " đ");
                    }
                    phiduongbo1.setText("1560000 đ");
                    phidangkiem1.setText("340000 đ");
                    tong = giadamphan + phitruocba + phiduongbo + baohiem + phibienso + phidangkiem;
                    tong1.setText(tong + " đ");
                } else
                    Toast.makeText(MainActivity.this, "Hãy chọn mẫu xe", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int pos = spinner3.getSelectedItemPosition();
                if (pos > 0) {
                    switch (pos) {
                        case 1: {
                            phibienso = 20000000;
                            phibienso1.setText(phibienso + " đ");
                            phitruocba = giadamphan / 100 * 12;
                            phitruocba1.setText(phitruocba + " đ");
                        }
                        break;
                        case 2: {
                            phibienso = 11000000;
                            phibienso1.setText(phibienso + " đ");
                            phitruocba = giadamphan / 100 * 10;
                            phitruocba1.setText(phitruocba + " đ");
                        }
                        break;
                        default: {
                            phibienso = 1000000;
                            phibienso1.setText(phibienso + " đ");
                            phitruocba = giadamphan / 100 * 10;
                            phitruocba1.setText(phitruocba + " đ");
                        }
                        break;
                    }
                    phiduongbo1.setText("1560000 đ");
                    phidangkiem1.setText("340000 đ");
                    tong = giadamphan + phitruocba + phiduongbo + baohiem + phibienso + phidangkiem;
                    tong1.setText(tong + " đ");
                } else
                    Toast.makeText(MainActivity.this, "Hãy chọn tỉnh, thành phố", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
