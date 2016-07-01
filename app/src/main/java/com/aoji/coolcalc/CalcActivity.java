package com.aoji.coolcalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity {

    String leftValue = "";
    String rightValue = "";
    String runningNumber = "";
    Operations currentOperation;
    int result = 0;

    TextView resultView;

    public enum  Operations {
        ADD, SUBSTRACT, DIVIDE, MULTIPLY, EQUAL
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        Button oneBtn = (Button) findViewById(R.id.oneBtn);
        Button twoBtn = (Button) findViewById(R.id.twoBtn);
        Button threeBtn = (Button) findViewById(R.id.threeBtn);
        Button fourBtn = (Button) findViewById(R.id.fourBtn);
        Button fiveBtn = (Button) findViewById(R.id.fiveBtn);
        Button sixBtn = (Button) findViewById(R.id.sixBtn);
        Button sevenBtn = (Button) findViewById(R.id.sevenBtn);
        Button eightBtn = (Button) findViewById(R.id.eightBtn);
        Button nineBtn = (Button) findViewById(R.id.nineBtn);
        Button zeroBtn = (Button) findViewById(R.id.zeroBtn);

        ImageButton calcBtn = (ImageButton) findViewById(R.id.calcBtn);
        ImageButton dividebtn = (ImageButton) findViewById(R.id.divideBtn);
        ImageButton multiplyBtn = (ImageButton) findViewById(R.id.multiBtn);
        ImageButton substractBtn = (ImageButton) findViewById(R.id.substractBtn);
        ImageButton addBtn = (ImageButton) findViewById(R.id.addBtn);

        Button clearBtn = (Button) findViewById(R.id.clearBtn);

        resultView = (TextView) findViewById(R.id.resultsText);

        resultView.setText("0");

        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(1);

            }
        });

        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(2);

            }
        });

        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(3);

            }
        });

        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(4);

            }
        });

        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(5);

            }
        });

        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(6);

            }
        });

        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(7);

            }
        });

        eightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(8);

            }
        });

        nineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(9);

            }
        });

        zeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberPressed(0);

            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftValue = "";
                rightValue="";
                result = 0;
                runningNumber = "";
                currentOperation = null;
                resultView.setText("0");
            }
        });

        multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operations.MULTIPLY);

            }
        });

        dividebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operations.DIVIDE);

            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operations.ADD);

            }
        });

        substractBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operations.SUBSTRACT);

            }
        });

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operations.EQUAL);

            }
        });
    }

    void processOperation(Operations operation) {
        if (currentOperation != null){

            if (runningNumber != "") {
                rightValue = runningNumber;
                runningNumber = "";

                switch (currentOperation) {
                    case ADD:
                        result = Integer.parseInt(leftValue) + Integer.parseInt(rightValue);
                        break;
                    case SUBSTRACT:
                        result = Integer.parseInt(leftValue) - Integer.parseInt(rightValue);
                        break;
                    case MULTIPLY:
                        result = Integer.parseInt(leftValue) * Integer.parseInt(rightValue);
                        break;
                    case DIVIDE:
                        result = Integer.parseInt(leftValue) / Integer.parseInt(rightValue);
                        break;
                }

                leftValue = String.valueOf(result);
                resultView.setText(leftValue);
            }

        }else {
            leftValue = runningNumber;
            runningNumber = "";
        }
        currentOperation = operation;
    }

    void  numberPressed(int number) {
        runningNumber += String .valueOf(number);
        resultView.setText(runningNumber);
    }
}
