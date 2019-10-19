package data;

import intervals.Interval;

public class IntervalOperand implements Operand{

  private final Interval interval;

  IntervalOperand(Interval interval) {
    this.interval = interval;
  }

  public Interval getData() {
    return this.interval;
  }

  @Override
  public Operand add(Operand other) {
    Interval tempOther = (Interval) other;
    return new IntervalOperand(this.interval.union(tempOther));
  }

  @Override
  public Operand subtract(Operand other) {
    Interval tempOther = (Interval) other;
    return new IntervalOperand(this.interval.intersect(tempOther));
  }

  @Override
  public Operand multiply(Operand other) {
    return null;
  }

  @Override
  public Operand divide(Operand other) {
    return null;
  }

  @Override
  public Operand modulo(Operand other) {
    return null;
  }
}
