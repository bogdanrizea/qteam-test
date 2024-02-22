package com.softwaretestingboard.magento.helpers;

public enum ItemColor {
  Blue("Blue"),
  ORANGE("Orange"),
  PURPLE("Purple"),
  YELLOW("Yellow"),
  BLACK("Black"),
  GREEN("Green"),
  GRAY("Gray"),
  WHITE("White");

  public final String itemColor;

  private ItemColor(String itemColor) {
    this.itemColor = itemColor;
  }
}
