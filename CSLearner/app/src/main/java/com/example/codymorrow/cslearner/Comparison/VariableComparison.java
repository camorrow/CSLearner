package com.example.codymorrow.cslearner.Comparison;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.codymorrow.cslearner.DatabaseTypes.infoText;
import com.example.codymorrow.cslearner.LanguageChoices.ContextLanguage;
import com.example.codymorrow.cslearner.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.example.codymorrow.cslearner.LanguageChoices.ContextLanguage.INITIAL_LANGUAGE_CHOICE;

public class VariableComparison extends LanguageComparisonHome {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syntax_comparison_one_section);

        Intent languageChoices = getIntent();
        initialLanguageChoice = languageChoices
                .getStringExtra(INITIAL_LANGUAGE_CHOICE);
        contextLanguageChoice = languageChoices
                .getStringExtra(ContextLanguage.CONTEXT_LANGUAGE_CHOICE);

        initializeText(initialLanguageChoice, contextLanguageChoice);

        menuOptions = getResources().getStringArray(R.array.menu_options);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.left_drawer);
        drawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.simple_list_item, menuOptions));
        drawerList.setOnItemClickListener(new DrawerItemClickListener());
    }

    @Override
    protected void initializeText(String initialLanguage, String contextLanguage) {
        //Text
        TextView pageTitle = (TextView) findViewById(R.id.pageTitle);
        String titleFormat = getResources().getString(R.string.variables_title);
        String titleText = String.format(titleFormat, initialLanguage);
        pageTitle.setText(titleText);

        TextView subtitle1 = (TextView) findViewById(R.id.subtitle1);
        String subtitleFormat;
        String subtitleText;

        if (!initialLanguage.equals(contextLanguage)) {
            subtitleFormat = getResources().getString(R.string.variables_subtitle1);
            subtitleText = String.format(subtitleFormat, initialLanguage, contextLanguage);
        } else {
            subtitleFormat = getResources().getString(R.string.variables_no_context_subtitle1);
            subtitleText = String.format(subtitleFormat, initialLanguage);
        }
        subtitle1.setText(subtitleText);

        TextView subtitle2 = (TextView) findViewById(R.id.subtitle2);
        subtitle2.setText("");

        //Images
        ImageView initialContent1 = (ImageView) findViewById(R.id.initialContent1);
        ImageView contextContent1 = (ImageView) findViewById(R.id.contextContent1);

        switch(initialLanguage) {
            case "Java":
                initialContent1.setImageResource(R.drawable.java_var);
                break;
            case "C":
                initialContent1.setImageResource(R.drawable.c_var);
                break;
            case "C++":
                initialContent1.setImageResource(R.drawable.cplus_var);
                break;
            case "Python":
                initialContent1.setImageResource(R.drawable.python_var);
                break;
            case "Swift":
                initialContent1.setImageResource(R.drawable.swift_var);
                break;
        }

        if (!contextLanguage.equals(initialLanguage))
            switch(contextLanguage) {
                case "Java":
                    contextContent1.setImageResource(R.drawable.java_var);
                    break;
                case "C":
                    contextContent1.setImageResource(R.drawable.c_var);
                    break;
                case "C++":
                    contextContent1.setImageResource(R.drawable.cplus_var);
                    break;
                case "Python":
                    contextContent1.setImageResource(R.drawable.python_var);
                    break;
                case "Swift":
                    contextContent1.setImageResource(R.drawable.swift_var );
                    break;
            }
        else {
            contextContent1.setImageResource(0);
        }

    }
}
