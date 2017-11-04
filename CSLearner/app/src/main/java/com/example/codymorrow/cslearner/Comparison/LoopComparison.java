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

public class LoopComparison extends LanguageComparisonHome {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syntax_comparison_three_sections);

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
        String titleFormat = getResources().getString(R.string.loops_title);
        String titleText = String.format(titleFormat, initialLanguage);
        pageTitle.setText(titleText);

        TextView subtitle1 = (TextView) findViewById(R.id.subtitle1);
        TextView subtitle2 = (TextView) findViewById(R.id.subtitle2);
        TextView subtitle3 = (TextView) findViewById(R.id.subtitle3);
        String subtitleText1;
        String subtitleText2;
        String subtitleText3;

        if (!initialLanguage.equals(contextLanguage)) {
            String subtitleFormat = getResources().getString(R.string.loops_subtitle1);
            subtitleText1 = String.format(subtitleFormat, initialLanguage, contextLanguage);
            subtitleFormat = getResources().getString(R.string.loops_subtitle2);
            subtitleText2 = String.format(subtitleFormat, initialLanguage, contextLanguage);
            subtitleFormat = getResources().getString(R.string.loops_subtitle3);
            subtitleText3 = String.format(subtitleFormat, initialLanguage, contextLanguage);
        } else {
            String subtitleFormat = getResources().getString(R.string.loops_no_context_subtitle1);
            subtitleText1 = String.format(subtitleFormat, initialLanguage);
            subtitleFormat = getResources().getString(R.string.loops_no_context_subtitle2);
            subtitleText2 = String.format(subtitleFormat, initialLanguage);
            subtitleFormat = getResources().getString(R.string.loops_no_context_subtitle3);
            subtitleText3 = String.format(subtitleFormat, initialLanguage);
        }
        subtitle1.setText(subtitleText1);
        subtitle2.setText(subtitleText2);
        subtitle3.setText(subtitleText3);


        //Images
        ImageView initialContent1 = (ImageView) findViewById(R.id.initialContent1);
        ImageView initialContent2 = (ImageView) findViewById(R.id.initialContent2);
        ImageView initialContent3 = (ImageView) findViewById(R.id.initialContent3);
        ImageView contextContent1 = (ImageView) findViewById(R.id.contextContent1);
        ImageView contextContent2 = (ImageView) findViewById(R.id.contextContent2);
        ImageView contextContent3 = (ImageView) findViewById(R.id.contextContent3);

        switch(initialLanguage) {
            case "Java":
                initialContent1.setImageResource(R.drawable.java_while);
                initialContent2.setImageResource(R.drawable.java_do_while);
                initialContent3.setImageResource(R.drawable.java_for);
                break;
            case "C":
                initialContent1.setImageResource(R.drawable.c_while);
                initialContent2.setImageResource(R.drawable.c_do);
                initialContent3.setImageResource(R.drawable.c_for);
                break;
            case "C++":
                initialContent1.setImageResource(R.drawable.cplus_while);
                initialContent2.setImageResource(R.drawable.cplus_do);
                initialContent3.setImageResource(R.drawable.cplus_for);
                break;
            case "Python":
                initialContent1.setImageResource(R.drawable.python_while);
                initialContent2.setImageResource(R.drawable.python_do_while);
                initialContent3.setImageResource(R.drawable.python_for);
                break;
            case "Swift":
                initialContent1.setImageResource(R.drawable.swift_while);
                initialContent2.setImageResource(R.drawable.swift_do);
                initialContent3.setImageResource(R.drawable.swift_for);
                break;
        }

        if (!contextLanguage.equals(initialLanguage))
            switch(contextLanguage) {
                case "Java":
                    contextContent1.setImageResource(R.drawable.java_while);
                    contextContent2.setImageResource(R.drawable.java_do_while);
                    contextContent3.setImageResource(R.drawable.java_for);
                    break;
                case "C":
                    contextContent1.setImageResource(R.drawable.c_while);
                    contextContent2.setImageResource(R.drawable.c_do);
                    contextContent3.setImageResource(R.drawable.c_for);
                    break;
                case "C++":
                    contextContent1.setImageResource(R.drawable.cplus_while);
                    contextContent2.setImageResource(R.drawable.cplus_do);
                    contextContent3.setImageResource(R.drawable.cplus_for);
                    break;
                case "Python":
                    contextContent1.setImageResource(R.drawable.python_while);
                    contextContent2.setImageResource(R.drawable.python_do_while);
                    contextContent3.setImageResource(R.drawable.python_for);
                    break;
                case "Swift":
                    contextContent1.setImageResource(R.drawable.swift_while);
                    contextContent2.setImageResource(R.drawable.swift_do);
                    contextContent3.setImageResource(R.drawable.swift_for);
                    break;
            }
        else {
            contextContent1.setImageResource(0);
            contextContent2.setImageResource(0);
            contextContent3.setImageResource(0);
        }
    }
}
