package com.example.assignment02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText editTextName, editTextAge;
    String selectedMood;
    TextView textViewSelectedMood, textViewProgress;
    ImageView myMood, imageViewMainMood;
    public static final String KEY_PROFILE = "PROFILE";

     ActivityResultLauncher<Intent> startActivityForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode() == RESULT_OK) {
                Intent data = result.getData();

                selectedMood = data.getStringExtra(SelectMoodActivity.KEY_MOOD);
                textViewSelectedMood.setText(selectedMood);

                if(textViewSelectedMood.getText().toString().equals("I am not well!")) {
                    imageViewMainMood.setImageResource(R.drawable.not_well);
                } else if(textViewSelectedMood.getText().toString().equals("I am sad!")) {
                    imageViewMainMood.setImageDrawable(getDrawable(R.drawable.sad));
                } else if(textViewSelectedMood.getText().toString().equals("I am just ok")) {
                    imageViewMainMood.setImageDrawable(getDrawable(R.drawable.ok));
                } else if(textViewSelectedMood.getText().toString().equals("I am good!")) {
                    imageViewMainMood.setImageDrawable(getDrawable(R.drawable.good));
                } else if(textViewSelectedMood.getText().toString().equals("I am very good!!")) {
                    imageViewMainMood.setImageDrawable(getDrawable(R.drawable.very_good));
                }
                }

             else {
            }
        }
    });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        textViewSelectedMood = findViewById(R.id.textViewSelectedMood);
        imageViewMainMood = findViewById(R.id.imageViewMainMood);

        setTitle("Main");

        findViewById(R.id.buttonSubmit).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String age = editTextAge.getText().toString();
                String feeling = textViewSelectedMood.getText().toString();

                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter name!", Toast.LENGTH_SHORT).show();
                } else if (age.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter age!", Toast.LENGTH_SHORT).show();
                } else if (feeling.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Tell us how you feel!", Toast.LENGTH_SHORT).show();
                } else {
                    // registration fields filled out > submit > profile activity
                    Profile profile = new Profile(name, age, feeling);
                    Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                    intent.putExtra(KEY_PROFILE, profile);
                    startActivity(intent);
                }
            }
        });



        findViewById(R.id.buttonMood).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //from main activity > tell us > select mood activity
                Intent intent = new Intent(MainActivity.this, SelectMoodActivity.class);
                startActivityForResult.launch(intent);
            }
        });
    }
}