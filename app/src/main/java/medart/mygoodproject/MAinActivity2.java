package medart.mygoodproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Welcome to pc on 12/7/2016.
 */

public class MAinActivity2 extends AppCompatActivity  {
    Button  submit;
    EditText txt1, txt2, txt3, txt4, txt5,txt6;
    static String user, mob, email, pas1, rpas1,serial;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit = (Button) findViewById(R.id.btn3);
        txt1 = (EditText) findViewById(R.id.editText1);
        txt2 = (EditText) findViewById(R.id.editText2);
        txt3 = (EditText) findViewById(R.id.editText3);
        txt4 = (EditText) findViewById(R.id.editText4);
        txt5 = (EditText) findViewById(R.id.editText5);
        txt6 = (EditText) findViewById(R.id.editText6);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = txt1.getText().toString();
                email = txt2.getText().toString();
                pas1 = txt5.getText().toString();
                rpas1 = txt6.getText().toString();
                mob = txt3.getText().toString();
                serial=txt4.getText().toString();
                if (!pas1.equals(rpas1)) {
                    Toast.makeText(MAinActivity2.this, "Password not retyped correctly", Toast.LENGTH_LONG).show();
                } else if (user == null || pas1 == null || email == null || mob == null)
                    Toast.makeText(MAinActivity2.this, "Fields are empty", Toast.LENGTH_LONG).show();
                else {
                    Intent i = new Intent(MAinActivity2.this, Second.class);
                    startActivity(i);
                }

            }
        });
    }
}