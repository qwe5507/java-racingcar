package dev.djoon.racingcar.domain.util;

public class TestRandomNumbers extends RandomNumbers {

  @Override
  public int nextInt(GameConstant bound) {
    return GameConstant.VALID_BOUNDARY.value() + 1;
  }
}