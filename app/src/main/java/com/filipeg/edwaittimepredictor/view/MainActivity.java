package com.filipeg.edwaittimepredictor.view;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.filipeg.edwaittimepredictor.R;

public class MainActivity extends BaseActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    if (savedInstanceState == null) {
      navigateToPredictionFragment();
    }
  }

  public void navigateToPredictionFragment() {
    FragmentManager manager = getSupportFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.replace(R.id.main_fragment_container, new PredictionFragment());
    transaction.commit();
  }
}
