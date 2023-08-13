package ajiet.cse.signuplab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText loginUsername, loginPassword;
    Button btnLogin;
    String usr, pwd;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginUsername = (EditText) findViewById(R.id.login_Username);
        loginPassword = (EditText) findViewById(R.id.login_Password);
        btnLogin = (Button) findViewById(R.id.btn_Login);
        btnLogin.setOnClickListener(this);

        Bundle bundle = getIntent().getBundleExtra("data");
        usr = bundle.getString("usr");
        pwd = bundle.getString("pwd");

    }

    @Override
    public void onClick(View v) {
        String lUsername = loginUsername.getText().toString();
        String lPassword = loginPassword.getText().toString();

        if(usr.equals(lUsername) && pwd.equals(lPassword)) {
            Toast.makeText(this, "Login Successful !", Toast.LENGTH_SHORT).show();
        } else {
            count += 1;
            if(count == 3) {

                btnLogin.setEnabled(false);
                Toast.makeText(this, "Login Attempts Limit Reached !!!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Login Failed !" + count, Toast.LENGTH_SHORT).show();
            }
        }

    }
}