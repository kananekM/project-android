package th.ac.kku.mongkolsawat.kananek;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        final TextView showText = (TextView)findViewById(R.id.textView3) ;
        Intent intent = getIntent();
        Bundle js = intent.getBundleExtra("bundle");
        showText.setText(js.getString("name")+getString(R.string.textPlus)+ js.getString("phone"));


    }
}
