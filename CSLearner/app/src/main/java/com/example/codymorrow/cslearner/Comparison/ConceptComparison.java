package com.example.codymorrow.cslearner.Comparison;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.widget.ArrayAdapter;
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

public class ConceptComparison extends LanguageComparisonHome {

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

    @Override
    protected void initializeText(String initialLanguage, String contextLanguage) {
        TextView pageTitle = (TextView) findViewById(R.id.pageTitle);
        String titleFormat = getResources().getString(R.string.concepts_title);
        String titleText = String.format(titleFormat, initialLanguage);
        pageTitle.setText(titleText);

        TextView subtitle1 = (TextView) findViewById(R.id.subtitle1);
        String subtitleFormat = getResources().getString(R.string.concepts_subtitle1);
        String subtitleText = String.format(subtitleFormat, initialLanguage, contextLanguage);
        subtitle1.setText(subtitleText);

        TextView subtitle2 = (TextView) findViewById(R.id.subtitle2);
        subtitle2.setText("");
        TextView content2 = (TextView) findViewById(R.id.content2);
        content2.setText("");

        DatabaseReference reference = FirebaseDatabase.getInstance()
                .getReference()
                .child("infoText")
                .child(initialLanguage + contextLanguage)
                .child("Concept");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                infoText homescreenContent = dataSnapshot.getValue(infoText.class);

                TextView content1 = (TextView) findViewById(R.id.content1);
                TextView content2 = (TextView) findViewById(R.id.content2);
                content1.setText(homescreenContent.content1);
                content2.setText(homescreenContent.content2);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //Read permissions are never denied, thus this line should never be read
                Log.e("Things", "onDataChange: Permissions may have changed from universal access");
            }
        });
    }
}
