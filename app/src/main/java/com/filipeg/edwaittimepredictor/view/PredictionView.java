package com.filipeg.edwaittimepredictor.view;

import com.filipeg.edwaittimepredictor.PredictionInput;
import rx.Observable;

public interface PredictionView extends View {
  Observable<Void> predictButtonClick();

  void showTimePicker();

  Observable<Void> submitTimeClick();

  void showDatePicker();

  Observable<PredictionInput> submitDateClick();
}
