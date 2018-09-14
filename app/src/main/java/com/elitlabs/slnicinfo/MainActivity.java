package com.elitlabs.slnicinfo;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String nic_no;
    String sex;
    int month[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int day;
    int mo = 0, da = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onButtonClick(View view){

        EditText t1 = (EditText)findViewById(R.id.nic_txt);

        TextView R1 = (TextView)findViewById(R.id.textView_nic);
        TextView R2 = (TextView)findViewById(R.id.textView_year);
        TextView R3 = (TextView)findViewById(R.id.textView_month);
        TextView R4 = (TextView)findViewById(R.id.textView_date);
        TextView R5 = (TextView)findViewById(R.id.textView_sex);

        Button  btn = (Button)findViewById(R.id.button);

        String nic_no = t1.getText().toString();

        if (nic_no.equals("")){
            Toast.makeText(MainActivity.this,"Please Enter the NIC", Toast.LENGTH_SHORT).show();
        }
        else{

            R1.setText(nic_no);

            // Get Year
            int year = (1900 + Integer.parseInt(nic_no.substring(0, 2)));
            R2.setText(Integer.toString(year));

            // Get Sex
            int s = Integer.parseInt(nic_no.substring(2, 5));

            if (s > 500){
                 sex = "Female";
            }
            else{
                 sex = "Male";
            }
            R5.setText(sex); // sex

            //Get month
            int d = Integer.parseInt(nic_no.substring(2, 5));
            if (d > 500){
                 day = (d - 500);
            }
            else{
                 day = d;
            }

            for(int i = 0; i < month.length; i++){
                if(day < month[i]){
                    mo = i + 1;
                    da = day;
                    break;
                }
                else{
                    day = day - month[i];
                }
            }

            R3.setText(Integer.toString(mo)); // month
            R4.setText(Integer.toString(da)); // day


        }

    }
}
