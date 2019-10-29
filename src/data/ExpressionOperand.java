package data;

/**
 * An operand type specific to the expression tree. It takes in operands of
 * type double. All operations on this data are defined here using methods like
 * add, subtract, multiply and divide.
 */
public class ExpressionOperand implements Operand {

  private final double value;

  /**
   * Creates a new operand object by taking in a double constant as an operand.
   * @param     constant The double data to be stored inside the operand object.
   */
  private ExpressionOperand(double constant) {
    this.value = constant;
  }

  /**
   * Creates a new Operand object by taking input a string object, converting it to
   * double data and assigning it to the class variable.
   *
   * @param     constant The constant which contains double data passed as string.
   */
  public ExpressionOperand(String constant) {
    this.value = Double.parseDouble(constant);
  }

  /**
   * A getter function which is used to return the value stored in the current object.
   * @return    The double data held by the current object.
   */
  public double getValue() {
    return this.value;
  }

  /**
   * This function adds a ExpressionOperand to the current object and returns a
   * new ExpressionOperand object which contains result.
   * @param     other The other ExpressionOperand to be added to this object.
   * @return     A new ExpressionOperand object which contains result data after addition.
   */
  public ExpressionOperand add(ExpressionOperand other) {
    return new ExpressionOperand(this.value + other.value);
  }

  /**
   * This function subtracts a ExpressionOperand to the current object and returns a
   * new ExpressionOperand object which contains result.
   * @param     other The other ExpressionOperand to be subtracted from this object.
   * @return     A new ExpressionOperand object which contains result data after subtraction.
   */
  public ExpressionOperand subtract(ExpressionOperand other) {
    return new ExpressionOperand(this.value - other.value);
  }

  /**
   * This function multiplies a ExpressionOperand with the current object and returns a
   * new ExpressionOperand object which contains result.
   * @param     other The other ExpressionOperand to be multiplied with this object.
   * @return     A new ExpressionOperand object which contains result data after multiplication.
   */
  public ExpressionOperand multiply(ExpressionOperand other) {
    return new ExpressionOperand(this.value * other.value);
  }

  /**
   * This function divided an ExpressionOperand with the current object and returns a
   * new ExpressionOperand object which contains result.
   * @param     other The other ExpressionOperand to be divided to this object.
   * @return     A new ExpressionOperand object which contains result data after division.
   */
  public ExpressionOperand divide(ExpressionOperand other) {
    return new ExpressionOperand(this.value / other.value);
  }

  /**
   * The toString representation of the current object. It returns double data in string format.
   * @return      String representation of the double data stored in this object.
   */
  @Override
  public String toString() {
    return this.getValue() + "";
  }
}
