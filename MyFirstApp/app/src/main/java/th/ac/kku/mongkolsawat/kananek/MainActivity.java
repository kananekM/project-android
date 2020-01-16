package th.ac.kku.mongkolsawat.kananek;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button nextButton = (Button) findViewById(R.id.button);
        final EditText nameText = (EditText)findViewById(R.id.editTextName);
        final EditText phoneText = (EditText)findViewById(R.id.editTextPhone);
        phoneText.addTextChangedListener(new PhoneNumberFormattingTextWatcher());


        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                Bundle bundle = new Bundle();
                String name_value = nameText.getText().toString();
                String phone_value = phoneText.getText().toString();
                bundle.putString("name",name_value);
                bundle.putString("phone",phone_value);

                intent.putExtra("bundle",bundle);
                startActivity(intent);
            }
        });

    }

}