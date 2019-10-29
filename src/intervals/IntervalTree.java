package intervals;

import java.util.function.BiFunction;

import abstraction.AbstractTree;
import data.IntervalOperand;
import data.Operand;

/**
 * This is an implementation of the IntervalTree which contains operands
 * in the form of Interval class and contains union and intersect operators.
 * It offers various functions like printing the data in infix format, prefix format
 * , evaluates the expression and returns the formatted text of the expression passed.
 */
public class IntervalTree extends AbstractTree implements Intervals {

  /**
   * Creates a new IntervalTree object which takes in a string, parses,
   * validates the inputs and creates a tree which contains operators and operands.
   * @param     input The string passed which is separated by spaces which contains operators like
   *                  I for intersect, U for union and operands of type Interval.
   *                  Any invalid characters will be caught.
   */
  public IntervalTree(String input) {
    super(input);
  }

  /**
   * This function creates an operand of type IntervalOperand and returns it.
   * It needs data of type Interval.
   *
   * @param identifier The identifier is a valid string which carries Interval data.
   * @return Returns a new IntervalOperand data passed as parameter.
   */
  @Override
  protected Operand createOperand(String identifier) {
    return new IntervalOperand(identifier);
  }

  /*
  This function returns a bifunction specific to the operator passed as an arguments.
  This function is applied while evaluating the expression.

  Returns new Bifunction which take operands of type IntervalOperand.
  If passed U, it returns a bifunction specific to union.
   */
  @Override
  protected BiFunction<IntervalOperand, IntervalOperand,
          IntervalOperand> createBiFunctionObject(String identifier) {
    if (identifier.equals("U")) {
      return IntervalOperand::union;
    } else {
      return IntervalOperand::intersect;
    }
  }

  /**
   * Checks if the input passed is an operand. It accepts only Interval object data.
   * Example of Interval data is 1,2 . It cannot have double variables.
   * If any other input is passed it throws an exception.
   * @param     identifier A token passed as input for which the validation has to be done.
   * @return    true if the input passed is valid else false.
   * @throws    IllegalArgumentException Throws exception if any of the validations fail.
   */
  @Override
  protected boolean isOperand(String identifier) throws IllegalArgumentException {
    if (!identifier.contains(",")) {
      throw new IllegalArgumentException("Illegal arguments");
    }
    String[] iList = identifier.split(",");
    if (iList.length < 2) {
      throw  new IllegalArgumentException("Invalid data");
    }
    for (int i = 0; i < iList.length; i++) {
      checkValidInteger(iList[i]);
    }
    return true;
  }

  /**
   * Helper method which takes in an identifier as input and does validations
   * on it like checking if it's an integer, contains any characters other than
   * digits etc.
   *
   * @param     identifier The identifier on which the validation like valid integer,
   *                       comma missing is to be done.
   */
  private void checkValidInteger(String identifier) {
    if (identifier.contains(".")) {
      throw new IllegalArgumentException("Illegal arguments");
    }
    int i = 0;
    if (identifier.charAt(0) == '-' || identifier.charAt(0) == '+') {
      i = 1;
    }
    while (i < identifier.length()) {
      char c = identifier.charAt(i);
      if (!Character.isDigit(c)) {
        throw new IllegalArgumentException("Illegal arguments");
      }
      i++;
    }
  }

  /*
  This function tells if the identifier passed in is an operator specific to IntervalTree
  It only accepts U and I. U - union I - intersect.
   */
  @Override
  protected boolean isOperator(String identifier) {
    return (identifier.equals("U") || identifier.equals("I"));
  }

  /*
  This function evaluates the given expression. If there is not intersection between
  the given intervals it gives a new Interval as Integer.MIN_VALUE, Integer.MIN_VALUE;
  Rest all the operations perform as expected.
   */
  @Override
  public Interval evaluate() {
    IntervalOperand result = (IntervalOperand) this.treeRoot.calculate();
    return result.getValue();
  }
}
