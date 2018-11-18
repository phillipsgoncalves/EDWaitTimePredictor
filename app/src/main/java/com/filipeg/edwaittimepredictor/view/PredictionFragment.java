package com.filipeg.edwaittimepredictor.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import com.filipeg.edwaittimepredictor.R;
import com.filipeg.edwaittimepredictor.presenter.PredictorPresenter;
import com.jakewharton.rxbinding.view.RxView;
import rx.Observable;

public class PredictionFragment extends BaseFragment implements PredictionView {

  private LinearLayout timePickerLayout;
  private TimePicker timePicker;
  private LinearLayout calendarViewLayout;
  private CalendarView calendarView;
  private Button predictionButton;
  private TextView predictionIntroMessage;
  private Button submitTimeButton;

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
    predictionIntroMessage = view.findViewById(R.id.prediction_intro_message);
    timePickerLayout = view.findViewById(R.id.prediction_time_picker_layout);
    timePicker = view.findViewById(R.id.prediction_timepicker);
    calendarViewLayout = view.findViewById(R.id.prediction_calendar_layout);
    calendarView = view.findViewById(R.id.prediction_calendar);
    submitTimeButton = view.findViewById(R.id.submit_time_for_prediction);
    attachPresenter(new PredictorPresenter(this));
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    predictionButton = null;
    predictionIntroMessage = null;
    timePickerLayout = null;
    timePicker = null;
    calendarViewLayout = null;
    calendarView = null;
    submitTimeButton = null;
  }

  @Override public Observable<Void> predictButtonClick() {
    return RxView.clicks(predictionButton);
  }

  @Override public void showTimePicker() {
    hidePredictionIntroductionView();
    timePickerLayout.setVisibility(View.VISIBLE);
  }

  @Override public Observable<Void> submitTimeClick() {
    return RxView.clicks(submitTimeButton);
  }

  @Override public void showDatePicker() {
    hideTimePicker();
    calendarViewLayout.setVisibility(View.VISIBLE);
  }

  private void hideTimePicker() {
    timePickerLayout.setVisibility(View.GONE);
  }

  private void hidePredictionIntroductionView() {
    predictionIntroMessage.setVisibility(View.GONE);
    predictionButton.setVisibility(View.GONE);
  }
}
