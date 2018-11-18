package com.filipeg.edwaittimepredictor;

import java.util.Date;

public class PredictionInput {
  private Date dateForPrediction;
  private int hourForPrediction;
  private int minuteForPrediction;

  public PredictionInput(Date dateForPrediction, int hourForPrediction, int minuteForPrediction) {
    this.dateForPrediction = dateForPrediction;
    this.hourForPrediction = hourForPrediction;
    this.minuteForPrediction = minuteForPrediction;
  }

  public Date getDateForPrediction() {
    return dateForPrediction;
  }

  public int getHourForPrediction() {
    return hourForPrediction;
  }

  public int getMinuteForPrediction() {
    return minuteForPrediction;
  }
}
