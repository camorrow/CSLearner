package com.example.codymorrow.cslearner.Comparison;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.codymorrow.cslearner.LanguageChoices.ContextLanguage;
import com.example.codymorrow.cslearner.R;

import static com.example.codymorrow.cslearner.LanguageChoices.ContextLanguage.INITIAL_LANGUAGE_CHOICE;

public class VariableComparison extends LanguageComparisonHome {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_comparison_home);

        Intent languageChoices = getIntent();
        initialLanguageChoice = languageChoices
                .getStringExtra(INITIAL_LANGUAGE_CHOICE);
        contextLanguageChoice = languageChoices
                .getStringExtra(ContextLanguage.CONTEXT_LANGUAGE_CHOICE);

        TextView pageTitle = (TextView) findViewById(R.id.pageTitle);
        String titleFormat = getResources().getString(R.string.variables_title);
        String titleText = String.format(titleFormat, initialLanguageChoice);
        pageTitle.setText(titleText);

        TextView subtitle1 = (TextView) findViewById(R.id.subtitle1);
        String subtitleFormat = getResources().getString(R.string.variables_subtitle1);
        String subtitleText = String.format(subtitleFormat, initialLanguageChoice);
        subtitle1.setText(subtitleText);

        TextView subtitle2 = (TextView) findViewById(R.id.subtitle2);
        subtitleFormat = getResources().getString(R.string.variables_subtitle1);
        subtitleText = String.format(subtitleFormat, contextLanguageChoice);
        subtitle2.setText(subtitleText);

        menuOptions = getResources().getStringArray(R.array.menu_options);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.left_drawer);
        drawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.simple_list_item, menuOptions));
        drawerList.setOnItemClickListener(new DrawerItemClickListener());
    }
}
