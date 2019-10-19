package data;

public class DoubleData implements Operand {

  private final Double d;

  DoubleData(Double d) {
    this.d = d;
  }

  public DoubleData(String s) {
    this.d = Double.parseDouble(s);
  }

  public double getData() {
    return this.d;
  }

  @Override
  public Operand add(Operand other) {
    DoubleData otherTemp = (DoubleData) other;
    return new DoubleData(otherTemp.d + this.d);
  }

  @Override
  public Operand subtract(Operand other) {
    DoubleData otherTemp = (DoubleData) other;
    return new DoubleData(this.d - otherTemp.d);
  }

  @Override
  public Operand multiply(Operand other) {
    DoubleData otherTemp = (DoubleData) other;
    return new DoubleData(this.d * otherTemp.d);
  }

  @Override
  public Operand divide(Operand other) {
    DoubleData otherTemp = (DoubleData) other;
    return new DoubleData(this.d / otherTemp.d);
  }

  @Override
  public Operand modulo(Operand other) {
    return null;
  }
}
