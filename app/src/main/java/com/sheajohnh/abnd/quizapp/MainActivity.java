package com.sheajohnh.abnd.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int NUMBER_OF_QUESTIONS = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnReset = (Button) findViewById(R.id.buttonReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetQuiz();
            }
        });

        Button btnScoreQuiz = (Button) findViewById(R.id.buttonScoreQuiz);
        btnScoreQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int resultTotal = scoreQuestion1()
                        + scoreQuestion2()
                        + scoreQuestion3()
                        + scoreQuestion4()
                        + scoreQuestion5();

                int percentCorrect = resultTotal * (100 / NUMBER_OF_QUESTIONS);

                String message = "You got " + String.valueOf(percentCorrect) + "% correct.";

                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }

    private int scoreQuestion1() {
        RadioButton radioButton1 = (RadioButton) findViewById(R.id.question_1_radiobutton_1);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.question_1_radiobutton_2);
        RadioButton radioButton3 = (RadioButton) findViewById(R.id.question_1_radiobutton_3);

        return (!radioButton1.isChecked() && radioButton2.isChecked() && !radioButton3.isChecked()) ? 1 : 0;
    }

    private int scoreQuestion2() {
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.question_2_checkbox_1);
        CheckBox checkBox2  = (CheckBox) findViewById(R.id.question_2_checkbox_2);
        CheckBox checkBox3  = (CheckBox) findViewById(R.id.question_2_checkbox_3);
        CheckBox checkBox4  = (CheckBox) findViewById(R.id.question_2_checkbox_4);

        return (checkBox1.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && !checkBox4.isChecked()) ? 1 : 0;
    }

    private int scoreQuestion3() {
        EditText editText = (EditText) findViewById(R.id.question_3_edittext);

        if (editText.getText().toString().equalsIgnoreCase("Arya")) {
            return 1;
        } else {
            return 0;
        }
    }

    private int scoreQuestion4() {
        RadioButton radioButton1 = (RadioButton) findViewById(R.id.question_4_radiobutton_1);
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.question_4_radiobutton_2);

        return (!radioButton1.isChecked() && radioButton2.isChecked()) ? 1 : 0;
    }

    private int scoreQuestion5() {
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.question_5_checkbox_1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.question_5_checkbox_2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.question_5_checkbox_3);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.question_5_checkbox_4);

        return (!checkBox1.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && !checkBox4.isChecked()) ? 1 : 0;
    }

    private void resetQuiz() {
        resetQuestion1();
        resetQuestion2();
        resetQuestion3();
        resetQuestion4();
        resetQuestion5();
    }

    private void resetQuestion1() {
        int[] ids = new int[] {R.id.question_1_radiobutton_1,
                R.id.question_1_radiobutton_2, R.id.question_1_radiobutton_3};

        resetCompoundButtons(ids);
    }

    private void resetQuestion2() {
        int[] ids = new int[] {R.id.question_2_checkbox_1,
                R.id.question_2_checkbox_2, R.id.question_2_checkbox_3, R.id.question_2_checkbox_4};

        resetCompoundButtons(ids);
    }

    private void resetQuestion3() {
        EditText editText = (EditText) findViewById(R.id.question_3_edittext);
        editText.setText("");
    }

    private void resetQuestion4() {
        int[] ids = new int[] {R.id.question_4_radiobutton_1,
                R.id.question_4_radiobutton_2};

        resetCompoundButtons(ids);
    }

    private void resetQuestion5() {
        int[] ids = new int[] {R.id.question_5_checkbox_1,
                R.id.question_5_checkbox_2, R.id.question_5_checkbox_3, R.id.question_5_checkbox_4};

        resetCompoundButtons(ids);
    }

    private void resetCompoundButtons(int[] ids) {
        CompoundButton compoundButton;

        for (int id : ids) {
            compoundButton = (CompoundButton) findViewById(id);
            compoundButton.setChecked(false);
        }
    }
}
