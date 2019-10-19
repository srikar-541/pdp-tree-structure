package data;

public class ExpressionOperand implements Operand {

  private final Double constant;

  ExpressionOperand(Double constant) {
    this.constant = constant;
  }

  public ExpressionOperand(String s) {
    this.constant = Double.parseDouble(s);
  }

  public double getData() {
    return this.constant;
  }

  @Override
  public Operand add(Operand other) {
    ExpressionOperand otherTemp = (ExpressionOperand) other;
    return new ExpressionOperand(otherTemp.getData() + this.getData());
  }

  @Override
  public Operand subtract(Operand other) {
    ExpressionOperand otherTemp = (ExpressionOperand) other;
    return new ExpressionOperand(this.getData() - otherTemp.getData());
  }

  @Override
  public Operand multiply(Operand other) {
    ExpressionOperand otherTemp = (ExpressionOperand) other;
    return new ExpressionOperand(this.getData() * otherTemp.getData());
  }

  @Override
  public Operand divide(Operand other) {
    ExpressionOperand otherTemp = (ExpressionOperand) other;
    return new ExpressionOperand(this.getData() / otherTemp.getData());
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

  @Override
  public String toString() {
    String s = this.getData()+"";
    if (this.getData() == Math.floor(this.getData())) {
      return s.substring(0, s.length() - 2);
    }
    return s;
  }
}
