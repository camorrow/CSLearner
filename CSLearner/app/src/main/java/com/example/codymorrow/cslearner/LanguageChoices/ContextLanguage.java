package com.example.codymorrow.cslearner.LanguageChoices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.codymorrow.cslearner.Comparison.LanguageComparisonHome;
import com.example.codymorrow.cslearner.R;

public class ContextLanguage extends AppCompatActivity {
    public static final String CONTEXT_LANGUAGE_CHOICE = "com.example.CSLearner.ContextLanguage";
    public static final String INITIAL_LANGUAGE_CHOICE = "com.example.CSLearner.HomeScreen";
    private String initialLanguageChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_language);

        Intent homeIntent = getIntent();
        initialLanguageChoice = homeIntent.getStringExtra(HomeScreen.LANGUAGE_CHOICE);

        String strSecondLanguageHintFormat = getResources().getString(R.string.second_language_selection_hint);
        String strSecondLanguageHintMsg = String.format(strSecondLanguageHintFormat, initialLanguageChoice);
        TextView contextLanguageSubtext = (TextView) findViewById(R.id.contextLanguageSubtext);
        contextLanguageSubtext.setText(strSecondLanguageHintMsg);
    }

    public void selectContextJava(View view) {
        String contextLanguageChoice = "Java";
        Intent nextIntent = new Intent(this, LanguageComparisonHome.class);
        nextIntent.putExtra(INITIAL_LANGUAGE_CHOICE, initialLanguageChoice);
        nextIntent.putExtra(CONTEXT_LANGUAGE_CHOICE, contextLanguageChoice);
        startActivity(nextIntent);
    }

    public void selectContextC(View view) {
        String contextLanguageChoice = "C";
        Intent nextIntent = new Intent(this, LanguageComparisonHome.class);
        nextIntent.putExtra(INITIAL_LANGUAGE_CHOICE, initialLanguageChoice);
        nextIntent.putExtra(CONTEXT_LANGUAGE_CHOICE, contextLanguageChoice);
        startActivity(nextIntent);
    }

    public void selectContextCPlus(View view) {
        String contextLanguageChoice = "C++";
        Intent nextIntent = new Intent(this, LanguageComparisonHome.class);
        nextIntent.putExtra(INITIAL_LANGUAGE_CHOICE, initialLanguageChoice);
        nextIntent.putExtra(CONTEXT_LANGUAGE_CHOICE, contextLanguageChoice);
        startActivity(nextIntent);
    }

    public void selectContextPython(View view) {
        String contextLanguageChoice = "Python";
        Intent nextIntent = new Intent(this, LanguageComparisonHome.class);
        nextIntent.putExtra(INITIAL_LANGUAGE_CHOICE, initialLanguageChoice);
        nextIntent.putExtra(CONTEXT_LANGUAGE_CHOICE, contextLanguageChoice);
        startActivity(nextIntent);
    }

    public void selectContextSwift(View view) {
        String contextLanguageChoice = "Swift";
        Intent nextIntent = new Intent(this, LanguageComparisonHome.class);
        nextIntent.putExtra(INITIAL_LANGUAGE_CHOICE, initialLanguageChoice);
        nextIntent.putExtra(CONTEXT_LANGUAGE_CHOICE, contextLanguageChoice);
        startActivity(nextIntent);
    }
}
