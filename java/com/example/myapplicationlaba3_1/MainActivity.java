package com.example.myapplicationlaba3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplicationlaba3.R;

public class MainActivity extends AppCompatActivity {

    EditText valueN;
    TextView textView;
    TextView textResultYY;
    TextView textResultXX;
    TextView sqrtN;
    TextView processCount;
    TextView newValueN;
    TextView iterSqrtN;
    TextView iterationCount;
    double number;
    double sqrtFromN;
    double finalRes;
    int iter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valueN = findViewById(R.id.valueN);
        textView = findViewById(R.id.resultX);
        textResultXX =  findViewById(R.id.resultXX);
        textResultYY =  findViewById(R.id.resultYY);
        sqrtN =  findViewById(R.id.sqrtN);
        processCount = findViewById(R.id.processCount);
        newValueN = findViewById(R.id.newValueN);
        iterSqrtN = findViewById(R.id.iterSqrtN);
        iterationCount = findViewById(R.id.iterationCount);

    }

    public void onCountClick(View view){
        sqrtN.setText(null);
        number = Double.parseDouble(valueN.getText().toString());
        sqrtFromN = Math.sqrt(number);
        sqrtFromN = Math.ceil(sqrtFromN);
        sqrtN.append(Double.toString(sqrtFromN));
    }

    public void onIterationClick(View view){
        Button button = findViewById(R.id.iteration);
        double numberInProcess = Math.pow(sqrtFromN,2) - number;
        finalRes = Math.sqrt(numberInProcess);
        if ((finalRes % 1) == 0){
            processCount.setText(null);
            iterSqrtN.setText(null);
            iterSqrtN.setText(null);
            iterationCount.setText(null);
            iter++;
            iterationCount.append(Integer.toString(iter));
            iterSqrtN.append(String.format("%2s",Double.toString(finalRes)));
            String outputProcess = sqrtFromN + "^2 - " + number + " = " + numberInProcess;
            processCount.append(outputProcess);
            textResultYY.append(Double.toString(finalRes));
            textResultXX.append(Double.toString(sqrtFromN));
            button.setEnabled(false);

        }else{
            iterationCount.setText(null);
            newValueN.setText(null);
            processCount.setText(null);
            iterSqrtN.setText(null);

            iter++;
            iterationCount.append(Integer.toString(iter));
            iterSqrtN.append(String.format("%2s",Double.toString(finalRes)));
            String outputProcess = sqrtFromN + "^2 - " + number + " = " + numberInProcess;
            processCount.append(outputProcess);
            sqrtFromN++;
            newValueN.append(Double.toString(sqrtFromN));
        }
    }

    public void resetClick(View view){
        Button button = findViewById(R.id.iteration);
        button.setEnabled(true);
        iter = 0;
        sqrtN.setText(null);
        valueN.setText(null);
        textResultYY.setText(null);
        textResultXX.setText(null);
        processCount.setText(null);
        newValueN.setText(null);
        iterSqrtN.setText(null);
    }
}
