package ru.alunev.android.pmptest.activity;

import ru.alunev.android.pmptest.R;
import ru.alunev.android.pmptest.info.AtivityIntents;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class StartTestActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);

        Intent start = new Intent(AtivityIntents.startIntent);
        startActivity(start);
    }
}
