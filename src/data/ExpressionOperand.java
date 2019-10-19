package data;

public class ExpressionOperand implements Operand {

  private final Double d;

  ExpressionOperand(Double d) {
    this.d = d;
  }

  public ExpressionOperand(String s) {
    this.d = Double.parseDouble(s);
  }

  public double getData() {
    return this.d;
  }

  @Override
  public Operand add(Operand other) {
    ExpressionOperand otherTemp = (ExpressionOperand) other;
    return new ExpressionOperand(otherTemp.d + this.d);
  }

  @Override
  public Operand subtract(Operand other) {
    ExpressionOperand otherTemp = (ExpressionOperand) other;
    return new ExpressionOperand(this.d - otherTemp.d);
  }

  @Override
  public Operand multiply(Operand other) {
    ExpressionOperand otherTemp = (ExpressionOperand) other;
    return new ExpressionOperand(this.d * otherTemp.d);
  }

  @Override
  public Operand divide(Operand other) {
    ExpressionOperand otherTemp = (ExpressionOperand) other;
    return new ExpressionOperand(this.d / otherTemp.d);
  }

  @Override
  public Operand modulo(Operand other) {
    return null;
  }

  @Override
  public Operand union(Operand other) {
    return null;
  }

  @Override
  public Operand intersect(Operand other) {
    return null;
  }
}
