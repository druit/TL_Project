package com.tlproject.omada1.tl_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.tlproject.omada1.tl_project.Controller.UserController;


public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void RegistClick(View view) {
        EditText username=(EditText) findViewById(R.id.usernamer);
        EditText password=(EditText) findViewById(R.id.passwordr);
        EditText cpassword=(EditText) findViewById(R.id.cpassword);
        String Username=username.getText().toString();
        String Password=password.getText().toString();
        String cPassword=cpassword.getText().toString();
        UserController control=new UserController();
        if(control.Regist(Username,Password,cPassword,this)) {
            String usr = Username + ";" + Password + ";1;0;";
            Intent intent = new Intent(RegisterActivity.this, MapsActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("User", usr);
            startActivity(intent);
        }
    }
}
