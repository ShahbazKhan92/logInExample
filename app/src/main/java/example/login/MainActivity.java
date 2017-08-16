package example.login;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextUserName,editTextPassword;
    Button buttonOk,buttonSave;

    public static final String MyPrefrences = "MyPrefrence";
    public static final String UserName = "nameKey";
    public static final String Password ="passwordKey";


    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUserName = (EditText) findViewById(R.id.editTextUser);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonOk = (Button) findViewById(R.id.okButton);
        buttonSave = (Button) findViewById(R.id.saveButton);

        sharedPreferences=getSharedPreferences(MyPrefrences, Context.MODE_PRIVATE);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,editTextUserName.getText().toString(),Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName=editTextUserName.getText().toString();
                String password=editTextPassword.getText().toString();

                SharedPreferences.Editor editor= sharedPreferences.edit();

                editor.putString(UserName,userName);
                editor.putString(Password, password);

                Toast.makeText(MainActivity.this,sharedPreferences.getString(UserName,userName).toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
