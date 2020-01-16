package th.ac.kku.mongkolsawat.kananek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener{

    EditText editText1,editText2;
    TextView textView1;
    Button addBt;
    float val1,val2,result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        textView1 = (TextView) findViewById(R.id.result);
        addBt = (Button) findViewById(R.id.add);

        addBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == addBt) {
            val1 = Float.parseFloat("" + editText1.getText());
            val2 = Float.parseFloat("" + editText2.getText());
            result = val1 + val2;
            textView1.setText(" = "+result);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("op1",editText1.getText().toString());
        outState.putString("op2",editText2.getText().toString());
        outState.putString("result",textView1.getText().toString());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        editText1.setText(savedInstanceState.getString("op1"));
        editText2.setText(savedInstanceState.getString("op2"));
        textView1.setText(savedInstanceState.getString("result"));

    }



}
