package th.ac.kku.mongkolsawat.kananek;

import android.graphics.Point;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    EditText editText1, editText2;
    TextView textView1, showStatus;
    Switch status;
    Button bt1;
    RadioGroup rg;
    float val1 = 0, val2 = 0;
    float result = 0;
    long start, stop;
    Double timeCurrent;
    int width, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = (EditText) findViewById(R.id.e1);
        editText2 = (EditText) findViewById(R.id.e2);
        textView1 = (TextView) findViewById(R.id.text1);
        showStatus = (TextView) findViewById(R.id.status);
        status = (Switch) findViewById(R.id.sw);
        bt1 = (Button) findViewById(R.id.bt1);
        rg = (RadioGroup) findViewById(R.id.gRadio);
        callMethod();
        showToast("Width = " + width + " ,Height = " + height);


    }

    public void callMethod() {
        bt1.setOnClickListener(this);
        rg.setOnCheckedChangeListener(this);
        status.setOnCheckedChangeListener(this);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;

    }

    public void onClick(View v) {
        if (v == bt1) {
            calculate(rg.getCheckedRadioButtonId());
        }
    }


    private void calculate(int id) {
        acceptNumber();
        switch (rg.getCheckedRadioButtonId()) {
            case R.id.radio1:
                result = val1 + val2;
                break;
            case R.id.radio2:
                result = val1 - val2;
                break;
            case R.id.radio3:
                result = val1 * val2;
                break;
            case R.id.radio4:
                if (val2 == 0) {
                    showToast("Please divide by non-zero number");
                } else
                    result = val1 / val2;
                break;
        }

        stop = System.currentTimeMillis();
        timeCurrent = Double.valueOf(stop - start);
        Log.d("calculation", " computation time = " + timeCurrent);
        Log.d("start", " time = " + start);
        Log.d("stop", " stop = " + stop);

        textView1.setText("= " + result);

    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        calculate(rg.getCheckedRadioButtonId());
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            showStatus.setText("NO");
        } else
            showStatus.setText("OFF");
    }

    private void acceptNumber() {
        start = System.currentTimeMillis();
        try {
            val1 = Float.parseFloat("" + editText1.getText());
            val2 = Float.parseFloat("" + editText2.getText());
        } catch (NumberFormatException nf) {
            showToast("Please enter only a number");
        }
    }

    private void showToast(String msg) {
        Toast toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM, 0, 100);
        toast.show();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.manu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            Toast.makeText(MainActivity.this,
                    "Choose action settings", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
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
