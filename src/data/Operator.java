package data;

import java.util.function.BiFunction;

/**
 * A class containing operator data in the form of string.
 * It takes in arguments like "+", "U" etc. It is common to both the Interval and Expression Tree
 * implementations.
 */
public class Operator {

  private String operator;
  private BiFunction biFunction;

  /**
   * Creates a new operator object which takes in the operator as a string and
   * a bifunction which is to be applied to the current operator.
   * An operator of type '+' takes in a bifunction which does addition.
   * An operator of type 'I' takes in a bifunction which does intersection.
   * @param       operator  The operator which is to be assigned to this class' operator.
   * @param       converter The bifunction which tells which operation to be perfomed by
   *                        this operator.
   *
   */
  public Operator(String operator, BiFunction converter) {
    this.operator = operator;
    this.biFunction = converter;
  }

  /**
   * This function returns the result by applying the bifunction to the operands passed to this
   * method.
   * @param       first The first operand of the operation.
   * @param       second The second operand of the operation.
   * @return      Returns an operand object returned by applying the bifunction on the first
   *              and second operands.
   */
  public Operand evaluate(Operand first, Operand second) {
    return (Operand) biFunction.apply(first, second);
  }

  /**
   * Returns the current operator as a string format.
   * @return    The operator the current object stores in string format.
   */
  @Override
  public String toString() {
    return this.operator;
  }
}
