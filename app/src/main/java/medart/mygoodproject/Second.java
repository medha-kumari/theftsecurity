package medart.mygoodproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Welcome to pc on 12/7/2016.
 */

public class Second extends AppCompatActivity implements View.OnClickListener{
    Button btn1,btn2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        btn1=(Button)findViewById(R.id.btnn1);
        btn2=(Button)findViewById(R.id.btnn2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==btn1) {
            startService(new Intent(Second.this, MyService.class));
        }
            else if(v==btn2) {
            stopService(new Intent(Second.this, MyService.class));
        }

        }

    }

