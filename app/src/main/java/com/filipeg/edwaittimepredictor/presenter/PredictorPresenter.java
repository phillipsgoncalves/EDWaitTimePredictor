package com.filipeg.edwaittimepredictor.presenter;

import com.filipeg.edwaittimepredictor.view.PredictionView;
import com.filipeg.edwaittimepredictor.view.View;

public class PredictorPresenter implements Presenter {
  private static final String TAG = "PredictorPresenter";
  private PredictionView view;

  public PredictorPresenter(PredictionView view) {
    this.view = view;
  }

  @Override public void present() {
    handlePredictButtonClick();
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
