package ru.alunev.android.pmptest.activity;

import ru.alunev.android.pmptest.R;
import android.os.Bundle;
import android.preference.PreferenceActivity;

public class GlobalPreferencesActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }

}
