package com.example.assignment02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    TextView textViewName, textViewAge, textViewProfileFeelings;
    Button buttonBack;
    ImageView imageViewProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        setTitle("Profile");

        textViewName = findViewById(R.id.textViewName);
        textViewAge = findViewById(R.id.textViewAge);
        textViewProfileFeelings = findViewById(R.id.textViewProfileFeelings);
        buttonBack = findViewById(R.id.buttonBack);
        imageViewProfile = findViewById(R.id.imageViewProfile);

        if(getIntent() != null && getIntent().hasExtra(MainActivity.KEY_PROFILE)) {
            Profile profile = (Profile) getIntent().getSerializableExtra(MainActivity.KEY_PROFILE);

            textViewName.setText(profile.getName());
            textViewAge.setText(profile.getAge());
            textViewProfileFeelings.setText(profile.getFeeling());

            if(textViewProfileFeelings.getText().equals("I am not well!")) {
                imageViewProfile.setImageResource(R.drawable.not_well);
            } else if(textViewProfileFeelings.getText().equals("I am sad!")) {
                imageViewProfile.setImageDrawable(getDrawable(R.drawable.sad));
            } else if(textViewProfileFeelings.getText().equals("I am just ok")) {
                imageViewProfile.setImageDrawable(getDrawable(R.drawable.ok));
            } else if(textViewProfileFeelings.getText().equals("I am good!")) {
                imageViewProfile.setImageDrawable(getDrawable(R.drawable.good));
            } else if(textViewProfileFeelings.getText().equals("I am very good!!")) {
                imageViewProfile.setImageDrawable(getDrawable(R.drawable.very_good));
        }
    }


        findViewById(R.id.buttonBack).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish(); //closes the screen, goes back to previous activity
            }
        });
    }
}

