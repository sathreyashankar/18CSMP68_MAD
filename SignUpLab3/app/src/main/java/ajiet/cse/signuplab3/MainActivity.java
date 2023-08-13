package ajiet.cse.signuplab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText signupUsername, signupPassword;
    Button btnSignup;
    String regularExpression = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!])[A-Za-z\\d@$!]{8,}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signupUsername = (EditText) findViewById(R.id.signup_Username);
        signupPassword = (EditText) findViewById(R.id.signup_Password);
        btnSignup = (Button) findViewById(R.id.btn_Signup);
        btnSignup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String username = signupUsername.getText().toString();
        String password = signupPassword.getText().toString();

        if(validatePassword(password)) {
            Bundle bundle = new Bundle();
            bundle.putString("usr", username);
            bundle.putString("pwd", password);

            Intent it = new Intent(this, LoginActivity.class);
            it.putExtra("data", bundle);

            startActivity(it);
        } else {
            Toast.makeText(getBaseContext(), "Invalid Password !", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validatePassword(String password) {
        Pattern pattern = Pattern.compile(regularExpression);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();   // returns True if it matches, else it returns False !
    }
}