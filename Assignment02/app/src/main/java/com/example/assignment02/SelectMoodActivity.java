package com.example.assignment02;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SelectMoodActivity extends AppCompatActivity {

    SeekBar mySeekBar;
    ImageView myMood;
    public static final String KEY_MOOD = "MOOD";
    TextView textViewSeekBarStatus, textViewMyFeelings, textViewSelectedMood;
    String mood = "none";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_mood);

        setTitle("Select Mood");

        mySeekBar = findViewById(R.id.seekBar);
        myMood = findViewById(R.id.myMood);
        textViewSeekBarStatus = findViewById(R.id.textViewSeekBarStatus);
        textViewMyFeelings = findViewById(R.id.textViewMyFeelings);
        mySeekBar.setMax(4);

        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
               // String mood = null;
                if(progress == 0) {
                    myMood.setImageResource(R.drawable.not_well);
                    textViewMyFeelings.setText("I am not well!");
                    mood = "I am not well!";
                } else if(progress == 1) {
                    myMood.setImageResource(R.drawable.sad);
                    textViewMyFeelings.setText("I am sad!");
                    mood = "I am sad!";
                } else if(progress == 2) {
                    myMood.setImageResource(R.drawable.ok);
                    textViewMyFeelings.setText("I am just ok");
                    mood = "I am just ok";
                } else if(progress == 3) {
                    myMood.setImageResource(R.drawable.good);
                    textViewMyFeelings.setText("I am good!");
                    mood = "I am good!";
                } else if(progress == 4) {
                    myMood.setImageResource(R.drawable.very_good);
                    textViewMyFeelings.setText("I am very good!!");
                    mood = "I am very good!!";
                }
                textViewSeekBarStatus.setText(String.valueOf(progress));

                //finish();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

        });

       findViewById(R.id.buttonSubmitFeelings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mood == "none") {
                    Toast.makeText(SelectMoodActivity.this, "Tell us how you feel!", Toast.LENGTH_SHORT).show();
                } else {
                    int selectedID = mySeekBar.getProgress();
                    Intent intent = new Intent();
                    intent.putExtra(SelectMoodActivity.KEY_MOOD, mood);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });


        findViewById(R.id.buttonCancel).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(mood != "none") {
                    mood.equals("none");
                    textViewMyFeelings.setText("");
                }
                finish(); //closes the screen, goes back to previous activity
            }
        });
    }
}