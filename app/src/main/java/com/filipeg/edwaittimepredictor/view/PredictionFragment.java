package com.filipeg.edwaittimepredictor.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TimePicker;
import com.filipeg.edwaittimepredictor.R;

public class PredictionFragment extends BaseFragment implements PredictionView {

  private TimePicker timePicker;
  private CalendarView calendarView;
  private Button predictionButton;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    return inflater.inflate(R.layout.prediction_fragment, container, false);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    predictionButton = view.findViewById(R.id.button_predict);
    timePicker = view.findViewById(R.id.prediction_timestamp);
    calendarView = view.findViewById(R.id.prediction_calendar);
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    predictionButton = null;
    timePicker = null;
    calendarView = null;
  }
}
