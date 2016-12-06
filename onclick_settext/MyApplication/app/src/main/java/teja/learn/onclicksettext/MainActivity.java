package teja.learn.onclicksettext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView txtCounter;

    private int count = 0;

    void setCount(int val) {
        if (count != val) {
            count = val;
            txtCounter.setText(String.format(Locale.getDefault(), "Clicked %d timed!", count));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        txtCounter = (TextView) findViewById(R.id.txtCounter);
        /* NOTE: Old way using anonymous class
        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setCount(count + 1);
            }
        });
        */
        btnAdd.setOnClickListener((View v) -> {
            setCount(count + 1);
        });
    }
}
