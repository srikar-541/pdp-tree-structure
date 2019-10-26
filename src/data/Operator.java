package data;

import java.util.function.BiFunction;

public class Operator  {

  private String operator;
  private BiFunction f;

  public Operator(String op, BiFunction converter) {
    this.operator = op;
    this.f = converter;
  }

  public Operand evaluate(Operand one, Operand two){
    return (Operand) f.apply(one,two);
  }

  @Override
  public String toString() {
    return this.operator;
  }

  public void getTextTree(StringBuilder result, int operatorCount) {
    for (int i=0;i<3*operatorCount;i++){
      result.append(" ");
    }
  }
}
