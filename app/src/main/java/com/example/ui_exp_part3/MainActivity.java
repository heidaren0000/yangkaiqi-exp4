package com.example.ui_exp_part3;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ImageView imageButton;

    private CheckBox chineseCheckbox;
    private CheckBox englishCheckbox;
    private Button checkboxConfirmButton;
    private int checkboxSelectedRID;

    private RadioButton maleRadio;
    private RadioButton femaleRadio;
    private Button radioConfirmButton;
    private int radioSelectedRID;

    @Override
    protected void onCreate(Bundle savedInstanceStates) {
        super.onCreate(savedInstanceStates);
        setContentView(R.layout.activity_main);

        imageButton = findViewById(R.id.button_image);

        chineseCheckbox = findViewById(R.id.checkbox_chinese);
        englishCheckbox = findViewById(R.id.checkbox_english);
        checkboxConfirmButton = findViewById(R.id.button_checkbox_confirm);

        maleRadio = findViewById(R.id.radio_male);
        femaleRadio = findViewById(R.id.radio_female);
        radioConfirmButton = findViewById(R.id.button_radio_confrim);

        // Image Button
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogDisplay(getResources().getString(R.string.picture_dialog_text), MainActivity.this);
            }
        });

        // CheckBoxs
        chineseCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                checkboxSelectedRID = R.string.chinese_checkbox_text;
            }
        });
        englishCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                checkboxSelectedRID = R.string.english_checkbox_text;
            }
        });
        checkboxConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogDisplay(getResources().getString(R.string.checkbox_dialog_text_template).concat(getResources().getString(checkboxSelectedRID)), MainActivity.this);
            }
        });

        // Radio Button
        radioConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogDisplay(getResources().getString(R.string.radio_dialog_text_template).concat(getResources().getString(radioSelectedRID)), MainActivity.this);
            }
        });
    }

    private void dialogDisplay(String text2show, Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(text2show)
                .setPositiveButton(R.string.dialog_close, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // nothing really happens
                    }
                });
        builder.create().show();
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.radio_female:
                if(checked) {
                    Log.d("onRadioButtonClicked", "female radio selected: ");
                    radioSelectedRID = R.string.female_radio_text;
                }
                break;
            case R.id.radio_male:
                if(checked) {
                    radioSelectedRID = R.string.male_radio_text;
                }
                break;
        }
    }
}
