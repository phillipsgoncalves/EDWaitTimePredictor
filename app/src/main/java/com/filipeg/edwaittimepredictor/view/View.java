package com.filipeg.edwaittimepredictor.view;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import com.filipeg.edwaittimepredictor.presenter.Presenter;
import com.trello.rxlifecycle.LifecycleTransformer;
import rx.Observable;

public interface View {

  @NonNull @CheckResult <T> LifecycleTransformer<T> bindUntilEvent(
      @NonNull LifecycleEvent lifecycleEvent);

  Observable<LifecycleEvent> getLifecycleEvent();

  void attachPresenter(Presenter presenter);

  enum LifecycleEvent {
    CREATE, START, RESUME, PAUSE, STOP, DESTROY,
  }
}
