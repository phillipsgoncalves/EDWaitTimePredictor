package com.filipeg.edwaittimepredictor.presenter;

import com.filipeg.edwaittimepredictor.PredictionManager;
import com.filipeg.edwaittimepredictor.view.PredictionView;
import com.filipeg.edwaittimepredictor.view.View;

public class PredictorPresenter implements Presenter {
  private static final String TAG = "PredictorPresenter";
  private PredictionView view;
  private PredictionManager predictionManager;

  public PredictorPresenter(PredictionView view) {
    this.view = view;
  }

  @Override public void present() {
    handlePredictButtonClick();
    handleSubmitTimeForPredictionButtonClick();
    handleSubmitDateForPredictionButtonClick();
  }

  private void handleSubmitDateForPredictionButtonClick() {
    view.getLifecycleEvent()
        .filter(event -> event.equals(View.LifecycleEvent.CREATE))
        .flatMap(__ -> view.submitDateClick())
        .doOnNext(__ -> predictionManager.submitPrediction())
        .compose(view.bindUntilEvent(View.LifecycleEvent.DESTROY))
        .subscribe(created -> {
        }, Throwable::printStackTrace);
  }

  private void handleSubmitTimeForPredictionButtonClick() {
    view.getLifecycleEvent()
        .filter(event -> event.equals(View.LifecycleEvent.CREATE))
        .flatMap(__ -> view.submitTimeClick())
        .doOnNext(__ -> view.showDatePicker())
        .compose(view.bindUntilEvent(View.LifecycleEvent.DESTROY))
        .subscribe(created -> {
        }, Throwable::printStackTrace);
  }

  private void handlePredictButtonClick() {
    view.getLifecycleEvent()
        .filter(event -> event.equals(View.LifecycleEvent.CREATE))
        .flatMap(__ -> view.predictButtonClick())
        .doOnNext(__ -> view.showTimePicker())
        .compose(view.bindUntilEvent(View.LifecycleEvent.DESTROY))
        .subscribe(created -> {
        }, Throwable::printStackTrace);
  }
}
