package com.ab.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button mCalculateBMI;
    TextView mCurrentHeight;
    TextView mCurrentWeight;
    ImageView mIncrementWeight,mDecrementWeight;
    SeekBar mSeekBarForHeight;
    RelativeLayout male,female;

    int intWeight = 55;
    int currentProgress;
    String  mintProgress = "170";
    String typeOfUser = "0";
    String weight2 = "55";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        mCalculateBMI = findViewById(R.id.btnCalculateBMI);
        mCurrentWeight = findViewById(R.id.currentWeight);
        mCurrentHeight = findViewById(R.id.CurrentHeight);
        mIncrementWeight = findViewById(R.id.incrementWeight);
        mDecrementWeight = findViewById(R.id.decrementWeight);
        mSeekBarForHeight = findViewById(R.id.seekBarForHeight);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);


        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeOfUser = "Male";
            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeOfUser = "Female";
            }
        });

        mSeekBarForHeight.setMax(300);
        mSeekBarForHeight.setProgress(170);
        mSeekBarForHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentProgress = progress;
                mintProgress = String.valueOf(currentProgress);
                mCurrentHeight.setText(mintProgress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        mIncrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intWeight = intWeight+1;
                weight2 = String.valueOf(intWeight);
                mCurrentWeight.setText(weight2);
            }
        });

        mDecrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intWeight = intWeight-1;
                weight2 = String.valueOf(intWeight);
                mCurrentWeight.setText(weight2);
            }
        });



        mCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (typeOfUser.equals("0")){
                    Toast.makeText(getApplicationContext(),"Select Your Gender First",Toast.LENGTH_SHORT).show();
                }
                else if (mintProgress.equals("0")){
                    Toast.makeText(getApplicationContext(),"Select Your Height First",Toast.LENGTH_SHORT).show();
                }
                else if (intWeight==0 || intWeight<0){
                    Toast.makeText(getApplicationContext(),"Weight Is Incorrect",Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(MainActivity.this,bmiactivity.class);
                    intent.putExtra("gender",typeOfUser);
                    intent.putExtra("height",mintProgress);
                    intent.putExtra("weight",weight2);
                    startActivity(intent);
                }
            }
        });

    }
}