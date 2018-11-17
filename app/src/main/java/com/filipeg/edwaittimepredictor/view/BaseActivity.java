package com.filipeg.edwaittimepredictor.view;

import android.support.annotation.NonNull;
import com.filipeg.edwaittimepredictor.presenter.Presenter;
import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.RxLifecycle;
import com.trello.rxlifecycle.android.ActivityEvent;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import rx.Observable;

public abstract class BaseActivity extends RxAppCompatActivity implements View {

  @NonNull @Override
  public final <T> LifecycleTransformer<T> bindUntilEvent(@NonNull LifecycleEvent lifecycleEvent) {
    return RxLifecycle.bindUntilEvent(getLifecycleEvent(), lifecycleEvent);
  }

  @Override public Observable<LifecycleEvent> getLifecycleEvent() {
    return lifecycle().map(event -> convertToEvent(event));
  }

  @Override public void attachPresenter(Presenter presenter) {
    presenter.present();
  }

  @NonNull private LifecycleEvent convertToEvent(ActivityEvent event) {
    switch (event) {
      case CREATE:
        return LifecycleEvent.CREATE;
      case START:
        return LifecycleEvent.START;
      case RESUME:
        return LifecycleEvent.RESUME;
      case PAUSE:
        return LifecycleEvent.PAUSE;
      case STOP:
        return LifecycleEvent.STOP;
      case DESTROY:
        return LifecycleEvent.DESTROY;
      default:
        throw new IllegalStateException("Unrecognized event: " + event.name());
    }
  }
}
