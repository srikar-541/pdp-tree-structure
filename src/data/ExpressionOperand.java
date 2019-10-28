package data;

public class ExpressionOperand implements Operand {

  private final double value;

  private ExpressionOperand(double constant) {
    this.value = constant;
  }

  public ExpressionOperand(String s) {
    this.value = Double.parseDouble(s);
  }

  public double getValue() {
    return this.value;
  }

  public ExpressionOperand add(ExpressionOperand other) {
    return new ExpressionOperand(this.value + other.value);
  }

  public ExpressionOperand subtract(ExpressionOperand other) {
    return new ExpressionOperand(this.value - other.value);
  }

  public ExpressionOperand multiply(ExpressionOperand other) {
    return new ExpressionOperand(this.value * other.value);
  }

  public ExpressionOperand divide(ExpressionOperand other) {
    return new ExpressionOperand(this.value / other.value);
  }

  @Override
  public String toString() {
    return this.getValue() + "";
  }
}
