package alabs.gsheetwithimage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView inside;
    String message = "No SMS Now";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bildirim);

        inside = (TextView) findViewById(R.id.textView);

        if (getIntent().getExtras() !=null){
            message = getIntent().getExtras().getString("message");

            if (message == null){

                message = "No New SMS";
            }
        }

        inside.setText("Bildirim: "+message);


    }
}
