package com.filipeg.edwaittimepredictor.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuInflater;
import com.filipeg.edwaittimepredictor.presenter.Presenter;
import com.trello.rxlifecycle.LifecycleTransformer;
import com.trello.rxlifecycle.RxLifecycle;
import com.trello.rxlifecycle.android.FragmentEvent;
import com.trello.rxlifecycle.components.support.RxFragment;
import rx.Observable;

public abstract class BaseFragment extends RxFragment
    implements com.filipeg.edwaittimepredictor.view.View {

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public void onDestroy() {
    super.onDestroy();
  }

  @Override public void setUserVisibleHint(boolean isVisibleToUser) {
    super.setUserVisibleHint(isVisibleToUser);
  }

  @Override public void startActivityForResult(Intent intent, int requestCode) {
    super.startActivityForResult(intent, requestCode);
  }

  @Override
  public void startActivityForResult(Intent intent, int requestCode, @Nullable Bundle options) {
    super.startActivityForResult(intent, requestCode, options);
  }

  @Override public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    super.onCreateOptionsMenu(menu, inflater);
  }

  @Override public void onPrepareOptionsMenu(Menu menu) {
    super.onPrepareOptionsMenu(menu);
  }

  @NonNull @Override
  public final <T> LifecycleTransformer<T> bindUntilEvent(@NonNull LifecycleEvent lifecycleEvent) {
    return RxLifecycle.bindUntilEvent(getLifecycleEvent(), lifecycleEvent);
  }

  @Override public Observable<LifecycleEvent> getLifecycleEvent() {
    return lifecycle().flatMap(event -> convertToEvent(event));
  }

  @Override public void attachPresenter(Presenter presenter) {
    presenter.present();
  }

  @NonNull private Observable<LifecycleEvent> convertToEvent(FragmentEvent event) {
    switch (event) {
      case ATTACH:
      case CREATE:
        return Observable.empty();
      case CREATE_VIEW:
        return Observable.just(LifecycleEvent.CREATE);
      case START:
        return Observable.just(LifecycleEvent.START);
      case RESUME:
        return Observable.just(LifecycleEvent.RESUME);
      case PAUSE:
        return Observable.just(LifecycleEvent.PAUSE);
      case STOP:
        return Observable.just(LifecycleEvent.STOP);
      case DESTROY_VIEW:
        return Observable.just(LifecycleEvent.DESTROY);
      case DETACH:
      case DESTROY:
        return Observable.empty();
      default:
        throw new IllegalStateException("Unrecognized event: " + event.name());
    }
  }
}
