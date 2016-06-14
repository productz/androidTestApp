package com.example.luna.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MyActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.luna.myfirstapp.MESSAGE";
    public final static String USER_TYPE = "com.example.luna.myfirstapp.USER_TYPE";

    public String userType = "Not Defined";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }

    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message); // Pass the message to the next activity
        intent.putExtra(USER_TYPE, userType); // Pass the user type to the next activity
        startActivity(intent);
    }

    /** Called when the user clicks on the radio buttons */
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_pirates:
                if (checked) {
                    userType = " is a pirate!";
                }
                break;
            case R.id.radio_ninjas:
                if (checked) {
                    userType = " is a ninja!!";
                }
                break;
        }
    }
}
