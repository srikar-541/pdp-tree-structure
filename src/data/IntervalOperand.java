package data;

import intervals.Interval;

public class IntervalOperand implements Operand {

  private final Interval interval;

  IntervalOperand(Interval interval) {
    this.interval = interval;
  }

  public IntervalOperand(String s) {
    String[] input = s.split(",");
    int from = Integer.parseInt(input[0]);
    int to = Integer.parseInt(input[1]);
    if (from > to) {
      throw new IllegalArgumentException("illegal ");
    }
    this.interval = new Interval(from, to);
  }

  public Interval getData() {
    return this.interval;
  }

  @Override
  public Operand add(Operand other) {
    /*Interval tempOther = ((IntervalOperand)other).getData();
    return new IntervalOperand(this.interval.union(tempOther));*/
    return null;
  }

  @Override
  public Operand union(Operand other) {
    Interval tempOther = ((IntervalOperand) other).getData();
    return new IntervalOperand(this.interval.union(tempOther));
  }

  @Override
  public Operand intersect(Operand other) {
    Interval tempOther = ((IntervalOperand) other).getData();
    return new IntervalOperand(this.interval.intersect(tempOther));
  }

  @Override
  public Operand subtract(Operand other) {
    Interval tempOther = ((IntervalOperand) other).getData();
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
