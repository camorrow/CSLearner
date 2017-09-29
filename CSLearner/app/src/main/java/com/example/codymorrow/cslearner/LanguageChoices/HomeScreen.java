package com.example.codymorrow.cslearner.LanguageChoices;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.codymorrow.cslearner.R;

public class HomeScreen extends AppCompatActivity {
    public static final String LANGUAGE_CHOICE = "com.example.CSLearner.Homescreen";

    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }

    public void selectJava(View view) {
        String languageChoice = "Java";
        Intent intent = new Intent(this, ContextLanguage.class);
        intent.putExtra(LANGUAGE_CHOICE, languageChoice);
        startActivity(intent);
    }

    public void selectC(View view) {
        String languageChoice = "C";
        Intent intent = new Intent(this, ContextLanguage.class);
        intent.putExtra(LANGUAGE_CHOICE, languageChoice);
        startActivity(intent);
    }

    public void selectCPlus(View view) {
        String languageChoice = "C++";
        Intent intent = new Intent(this, ContextLanguage.class);
        intent.putExtra(LANGUAGE_CHOICE, languageChoice);
        startActivity(intent);
    }

    public void selectPython(View view) {
        String languageChoice = "Python";
        Intent intent = new Intent(this, ContextLanguage.class);
        intent.putExtra(LANGUAGE_CHOICE, languageChoice);
        startActivity(intent);
    }

    public void selectSwift(View view) {
        String languageChoice = "Swift";
        Intent intent = new Intent(this, ContextLanguage.class);
        intent.putExtra(LANGUAGE_CHOICE, languageChoice);
        startActivity(intent);
    }

}
