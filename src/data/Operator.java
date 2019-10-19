package data;

public class Operator implements Data {

  String operator;

  public Operator(String op) {
    this.operator = op;
  }

  @Override
  public Data add(Data other) {
    return null;
  }

  @Override
  public Data subtract(Data other) {
    return null;
  }

  @Override
  public Data multiply(Data other) {
    return null;
  }

  @Override
  public Data divide(Data other) {
    return null;
  }

  @Override
  public Data modulo(Data other) {
    return null;
  }

  @Override
  public String toString() {
    return this.operator;
  }
}
