package data;

import intervals.Interval;

/**
 * An operand type specific to the interval tree. It takes in operands of
 * type Interval. All operations on this data are defined here using methods like
 * union, intersect.
 */
public class IntervalOperand implements Operand {

  private final Interval interval;

  /**
   * Creates a new operand object by taking in a Interval object as an operand.
   * @param     interval The data of type Interval to be stored inside the operand object.
   */
  private IntervalOperand(Interval interval) {
    this.interval = interval;
  }

  /**
   * Creates a new operand object by taking in an Interval object represented in string format.
   * @param     intervalString The interval string which contains string representation of
   *                           interval object.
   */
  public IntervalOperand(String intervalString) {
    String[] input = intervalString.split(",");
    int from = Integer.parseInt(input[0]);
    int to = Integer.parseInt(input[1]);
    if (from > to) {
      throw new IllegalArgumentException("illegal ");
    }
    this.interval = new Interval(from, to);
  }

  /**
   * Getter function for the current object's data.
   * @return      Returns the current object's interval.
   */
  public Interval getValue() {
    return this.interval;
  }

  /**
   * It performs the union operation on the current object and IntervalOperand object
   * passed as an input and returns a new object containing updated data.
   * @param     other  the other IntervalOperand object which is to unioned to this object.
   * @return    A new IntervalOperand object which contains data after performing union of two
   *            Interval Objects.
   */
  public IntervalOperand union(IntervalOperand other) {
    return new IntervalOperand(this.interval.union(other.interval));
  }

  /**
   * It performs the intersect operation on the current object and IntervalOperand object
   * passed as an input and returns a new object containing updated data.
   * @param     other  the other IntervalOperand object which is to intersected to this object.
   * @return    A new IntervalOperand object which contains data after performing intersection of
   *            two Interval Objects.
   */
  public IntervalOperand intersect(IntervalOperand other) {
    return new IntervalOperand(this.interval.intersect(other.interval));
  }

  /**
   * The toString representation of the current object. It returns interval object data
   * in string format. It calls the toString() method of interval class.
   * @return      String representation of the Interval data stored in this object.
   */
  @Override
  public String toString() {
    return interval.toString();
  }
}
