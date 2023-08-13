package ajiet.cse.callandsaveapplication;

import static android.view.View.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText phoneNumberEditText;
    Button delBtn, callBtn, saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneNumberEditText = findViewById(R.id.phoneNumber_EditText);
        delBtn = findViewById(R.id.del_Btn);
        callBtn = findViewById(R.id.call_Btn);
        saveBtn = findViewById(R.id.save_Btn);

        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNumberEditText.setText("");
            }
        });
        callBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = phoneNumberEditText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: " + phoneNumber));
                startActivity(intent);
            }
        });
        saveBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = phoneNumberEditText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
                intent.putExtra(ContactsContract.Intents.Insert.PHONE, phoneNumber);
                startActivity(intent);
            }
        });
    }
    public void inputNumber(View V) {
        Button btn = (Button) V;
        String digit = btn.getText().toString();
        String phoneNumber = phoneNumberEditText.getText().toString();
        phoneNumberEditText.setText(phoneNumber+digit);
    }
}
