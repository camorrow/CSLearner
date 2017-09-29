package com.example.codymorrow.cslearner.Comparison;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.codymorrow.cslearner.LanguageChoices.ContextLanguage;
import com.example.codymorrow.cslearner.LanguageChoices.HomeScreen;
import com.example.codymorrow.cslearner.R;

import static com.example.codymorrow.cslearner.LanguageChoices.ContextLanguage.CONTEXT_LANGUAGE_CHOICE;
import static com.example.codymorrow.cslearner.LanguageChoices.ContextLanguage.INITIAL_LANGUAGE_CHOICE;

public class LanguageComparisonHome extends AppCompatActivity {
    protected String initialLanguageChoice;
    protected String contextLanguageChoice;
    protected String[] menuOptions;
    protected DrawerLayout drawerLayout;
    protected ListView drawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_comparison_home);

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

    protected void goHome(View view) {
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
    }

    protected class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            chooseItem(position);
        }
    }

    protected void chooseItem(int position) {
        Intent nextIntent;
        switch (position) {
            case 0:
                nextIntent = new Intent(this, ConceptComparison.class);
                nextIntent.putExtra(INITIAL_LANGUAGE_CHOICE, initialLanguageChoice);
                nextIntent.putExtra(CONTEXT_LANGUAGE_CHOICE, contextLanguageChoice);
                startActivity(nextIntent);
                break;
            case 1:
                nextIntent = new Intent(this, VariableComparison.class);
                nextIntent.putExtra(INITIAL_LANGUAGE_CHOICE, initialLanguageChoice);
                nextIntent.putExtra(CONTEXT_LANGUAGE_CHOICE, contextLanguageChoice);
                startActivity(nextIntent);
                break;
            case 2:
                nextIntent = new Intent(this, ConditionalComparison.class);
                nextIntent.putExtra(INITIAL_LANGUAGE_CHOICE, initialLanguageChoice);
                nextIntent.putExtra(CONTEXT_LANGUAGE_CHOICE, contextLanguageChoice);
                startActivity(nextIntent);
                break;
            case 3:
                nextIntent = new Intent(this, LoopComparison.class);
                nextIntent.putExtra(INITIAL_LANGUAGE_CHOICE, initialLanguageChoice);
                nextIntent.putExtra(CONTEXT_LANGUAGE_CHOICE, contextLanguageChoice);
                startActivity(nextIntent);
                break;
            case 4:
                nextIntent = new Intent(this, MethodComparison.class);
                nextIntent.putExtra(INITIAL_LANGUAGE_CHOICE, initialLanguageChoice);
                nextIntent.putExtra(CONTEXT_LANGUAGE_CHOICE, contextLanguageChoice);
                startActivity(nextIntent);
                break;
        }
    }

    protected void initializeText(String initialLanguage, String contextLanguage) {
        String strInitialLanguageInfoHeaderFormat = getResources().getString(R.string.initial_language_info_header);
        String strInitialLanguageInfoHeaderText = String.format(strInitialLanguageInfoHeaderFormat,
                initialLanguage);
        TextView initialLanguageNameText = (TextView) findViewById(R.id.subtitle1);
        initialLanguageNameText.setText(strInitialLanguageInfoHeaderText);

        String strContextLanguageInfoHeaderFormat = getResources().getString(R.string.context_language_info_header);
        String strContextLanguageInfoHeaderText = String.format(strContextLanguageInfoHeaderFormat,
                initialLanguage, contextLanguage);
        TextView initialDiffersFromContextText =
                (TextView) findViewById(R.id.subtitle2);
        initialDiffersFromContextText.setText(strContextLanguageInfoHeaderText);
    }
}
