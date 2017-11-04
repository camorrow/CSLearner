package com.example.codymorrow.cslearner.Comparison;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.codymorrow.cslearner.LanguageChoices.ContextLanguage;
import com.example.codymorrow.cslearner.R;

import static com.example.codymorrow.cslearner.LanguageChoices.ContextLanguage.INITIAL_LANGUAGE_CHOICE;

public class MethodComparison extends LanguageComparisonHome {

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
        String titleFormat = getResources().getString(R.string.methods_title);
        String titleText = String.format(titleFormat, initialLanguage);
        pageTitle.setText(titleText);

        TextView subtitle1 = (TextView) findViewById(R.id.subtitle1);
        String subtitleFormat;
        String subtitleText;
        if (!initialLanguage.equals(contextLanguage)) {
            subtitleFormat = getResources().getString(R.string.methods_subtitle1);
            subtitleText = String.format(subtitleFormat, initialLanguage, contextLanguage);
        } else {
            subtitleFormat = getResources().getString(R.string.methods_no_context_subtitle1);
            subtitleText = String.format(subtitleFormat, initialLanguage);
        }
        subtitle1.setText(subtitleText);

        TextView subtitle2 = (TextView) findViewById(R.id.subtitle2);
        subtitleText = getResources().getString(R.string.methods_subtitle2);
        subtitle2.setText(subtitleText);

        //Images
        ImageView initialContent1 = (ImageView) findViewById(R.id.initialContent1);
        ImageView contextContent1 = (ImageView) findViewById(R.id.contextContent1);

        switch(initialLanguage) {
            case "Java":
                initialContent1.setImageResource(R.drawable.java_func);
                break;
            case "C":
                initialContent1.setImageResource(R.drawable.c_func);
                break;
            case "C++":
                initialContent1.setImageResource(R.drawable.cplus_func);
                break;
            case "Python":
                initialContent1.setImageResource(R.drawable.python_func);
                break;
            case "Swift":
                initialContent1.setImageResource(R.drawable.swift_func);
                break;
        }

        if (!contextLanguage.equals(initialLanguage))
            switch(contextLanguage) {
                case "Java":
                    contextContent1.setImageResource(R.drawable.java_func);
                    break;
                case "C":
                    contextContent1.setImageResource(R.drawable.c_func);
                    break;
                case "C++":
                    contextContent1.setImageResource(R.drawable.cplus_func);
                    break;
                case "Python":
                    contextContent1.setImageResource(R.drawable.python_func);
                    break;
                case "Swift":
                    contextContent1.setImageResource(R.drawable.swift_func);
                    break;
            }
        else {
            contextContent1.setImageResource(0);
        }
    }
}
