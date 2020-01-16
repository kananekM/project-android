package th.ac.kku.mongkolsawat.kananek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        TextView green = (TextView)findViewById(R.id.green);

        green.setText("Green");
        green.setGravity(Gravity.CENTER);
        green.setTextSize(30);

    }
}
