package com.example.lesson_11;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.Toast;

public class search_city extends AppCompatActivity {
    final String TAG = "lifecycle";
    Boolean isSave = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_city);
        String instanceState;
        if (savedInstanceState == null){
            instanceState = "Первый запуск!";
            Log.d(TAG, "Первый запуск!");
        }
        else{
            instanceState = "Повторный запуск!";
            Log.d(TAG, "Повторный запуск!");
        }
        Toast.makeText(getApplicationContext(), instanceState + " onCreate()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Activity started");

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Toast.makeText(getApplicationContext(), "onSaveInstanceState", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Activity saved");
        CheckBox sunRise = findViewById(R.id.sunrise);
        outState.putBoolean("is checked", sunRise.isChecked());
        CheckBox sunSet = findViewById(R.id.sunset);
        outState.putBoolean("is checked", sunSet.isChecked());
        CheckBox pressure = findViewById(R.id.pressure);
        outState.putBoolean("is checked", pressure.isChecked());
        CheckBox speedOfWind = findViewById(R.id.speed_of_wind);
        outState.putBoolean("is checked", speedOfWind.isChecked());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        Toast.makeText(getApplicationContext(), "Повторный запуск!! - onRestoreInstanceState()", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Activity restarted");
        CheckBox sunRise = findViewById(R.id.sunrise);
        CheckBox sunSet = findViewById(R.id.sunset);
        CheckBox pressure = findViewById(R.id.pressure);
        CheckBox speedOfWind = findViewById(R.id.speed_of_wind);
        assert savedInstanceState != null;
        isSave = savedInstanceState.getBoolean("is checked", sunRise.isChecked());
        sunRise.setChecked(isSave);
        isSave = savedInstanceState.getBoolean("is checked", sunSet.isChecked());
        sunSet.setChecked(isSave);
        isSave = savedInstanceState.getBoolean("is checked", pressure.isChecked());
        pressure.setChecked(isSave);
        isSave = savedInstanceState.getBoolean("is checked", speedOfWind.isChecked());
        speedOfWind.setChecked(isSave);
        super.onRestoreInstanceState(savedInstanceState, persistentState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Activity resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Activity paused");
    }



    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Activity stopped");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "onRestart", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Activity restarted");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Activity destroyed");
    }


    protected void initView(){
        CheckBox sunRise = findViewById(R.id.sunrise);
        CheckBox sunSet = findViewById(R.id.sunset);
        CheckBox pressure = findViewById(R.id.pressure);
        CheckBox speedOfWind = findViewById(R.id.speed_of_wind);
    }
}



