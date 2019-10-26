package data;

import intervals.Interval;

public class IntervalOperand implements Operand {

  private final Interval interval;

  private IntervalOperand(Interval interval) {
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

  public Interval getValue() {
    return this.interval;
  }

  public IntervalOperand union(IntervalOperand other){
    return new IntervalOperand(interval.union(other.interval));
  }

  public IntervalOperand intersect(IntervalOperand other){
    return new IntervalOperand(interval.intersect(other.interval));
  }
  @Override
  public String toString() {
    return interval.toString();
  }


}
