package data;

import java.util.function.BiFunction;

public class Operator {

  private String operator;
  private BiFunction biFunction;

  public Operator(String operator, BiFunction converter) {
    this.operator = operator;
    this.biFunction = converter;
  }

  public Operand evaluate(Operand first, Operand second) {
    return (Operand) biFunction.apply(first, second);
  }

  @Override
  public String toString() {
    return this.operator;
  }
}
