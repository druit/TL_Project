package com.tlproject.omada1.tl_project;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tlproject.omada1.tl_project.Controller.UserController;
import com.tlproject.omada1.tl_project.Model.User;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Bundle extras = getIntent().getExtras();
        String User = extras.getString("User");
        com.tlproject.omada1.tl_project.Model.User curruser = new User();
        curruser.setUser(User);

        TextView username=(TextView) findViewById(R.id.username);
        TextView lvl=(TextView) findViewById(R.id.lvl);
        TextView curexp=(TextView) findViewById(R.id.curexp);
        TextView nextlvlexp=(TextView) findViewById(R.id.nextlvlexp);
        ProgressBar exp=(ProgressBar) findViewById(R.id.expbar);

        username.setText(curruser.getUsername());
        lvl.setText(String.valueOf(curruser.getLvl()));
        UserController control=new UserController();
        int expcur=curruser.getExp();
        int nextexp=control.expforLvl(curruser);
        curexp.setText(String.valueOf(expcur));
        nextlvlexp.setText(String.valueOf(nextexp));
        int prog=(expcur*100)/nextexp;
        exp.getProgressDrawable().setColorFilter(Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);
        exp.setProgress(prog);
    }

    public void back(View view) {
        finish();
    }
}
