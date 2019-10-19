package data;

import intervals.Interval;

public class IntervalData implements Operand{

  private final Interval interval;

  IntervalData(Interval interval) {
    this.interval = interval;
  }

  public Interval getData() {
    return this.interval;
  }

  @Override
  public Operand add(Operand other) {
    Interval tempOther = (Interval) other;
    return new IntervalData(this.interval.union(tempOther));
  }

  @Override
  public Operand subtract(Operand other) {
    Interval tempOther = (Interval) other;
    return new IntervalData(this.interval.intersect(tempOther));
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
