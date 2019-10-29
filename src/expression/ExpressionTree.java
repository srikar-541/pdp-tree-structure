package expression;

import java.util.function.BiFunction;
import abstraction.AbstractTree;
import data.ExpressionOperand;
import data.Operand;

/**
 * This is an implementation of the ExpressionTree which contains operands
 * in the form of double and contains plus minus star slash operators.
 * It offers various functions like printing the data in infix format, prefix format
 * , evaluates the expression and returns the formatted text of the expression passed.
 */
public class ExpressionTree extends AbstractTree implements Expression {

  /**
   * Creates a new ExpressionTree object which takes in a string, parses,
   * validates the inputs and creates a tree which contains operators and operands.
   * @param     input The string passed which is separated by spaces which contains operators,
   *                  operands. Any invalid characters will be caught.
   */
  public ExpressionTree(String input) {
    super(input);
  }

  /**
   * This function creates an operand of type ExpressionOperand and returns it.
   * It needs data of type double.
   *
   * @param identifier The identifier is a valid string which carries double value.
   * @return Returns a new ExpressionOperand data passed as parameter.
   */
  @Override
  protected Operand createOperand(String identifier) {
    return new ExpressionOperand(identifier);
  }

  /**
   * Checks if the input passed is an operand. It accepts only double data.
   * If any other input is passed it throws an exception.
   * @param     identifier A token passed as input for which the validation has to be done.
   * @return    true if the input passed is valid else false.
   * @throws    IllegalArgumentException Throws exception if any of the validations fail.
   */
  @Override
  protected boolean isOperand(String identifier) throws IllegalArgumentException {
    boolean doubleValue = false;
    int i = 0;
    if (identifier.charAt(0) == '-' || identifier.charAt(0) == '+') {
      i = 1;
    }
    while (i < identifier.length()) {
      char c = identifier.charAt(i);
      if (c == '.') {
        if (doubleValue) {
          throw new IllegalArgumentException("Invalid data");
        }
        doubleValue = true;
      } else if (!Character.isDigit(c)) {
        throw new IllegalArgumentException("Give valid input");
      }
      i++;
    }
    return true;
  }

  /*For the scope of the assignment, we are not handling the modulo operator because modulo
  doesn't work on double data. We need to do type checking of data if we want to include
  modulo operation.
  This function tells if the identifier passed in is an operator specific to ExpressionTree
  It only accepts plus minus slash and start. plus - add minus - subtract * - multiply
  slash - divide.
  */
  @Override
  protected boolean isOperator(String identifier) {
    return (identifier.equals("+") || identifier.equals("-")
            || identifier.equals("/") || identifier.equals("*"));
  }

  /**
   * This method evaluates the given expression. If division is to be perfomed and
   * the divisor is 0, this method returns Positive Infinity or Negative Infinity or NaN
   * depending on the dividend.
   * Rest all the operations perform as expected.
   * @return    The double result after evaluating the complete tree.
   */
  @Override
  public double evaluate() {
    ExpressionOperand eo = ((ExpressionOperand) this.treeRoot.calculate());
    return eo.getValue();
  }

  /**
   * This method gives the scheme expression of the given expression tree input.
   * Example : for "3 2 + 65.12 -" we get "(- (+ 3.0 2.0) 65.12)"
   * @return    String which represents the scheme expression of the given input.
   */
  @Override
  public String schemeExpression() {
    return this.treeRoot.getPreOrder();
  }

  /*
  This function returns a bifunction specific to the operator passed as an arguments.
  This function is applied while evaluating the expression.

  Returns new Bifunction which take operands of type ExpressionOperand.
  If passed plus, it returns a bifunction specific to addition.
   */
  @Override
  protected BiFunction<ExpressionOperand, ExpressionOperand,
          ExpressionOperand> createBiFunctionObject(String identifier) {
    if (identifier.equals("+")) {
      return ExpressionOperand::add;
    }
    else if (identifier.equals("-")) {
      return ExpressionOperand::subtract;
    }
    else if (identifier.equals("*")) {
      return ExpressionOperand::multiply;
    }
    return ExpressionOperand::divide;
  }

  /**
   * Returns the infix format of the current expression. This format is same as
   * doing an inorder traversal on the tree which contains this data.
   * @return      A string containing the infix formatted data.
   */
  public String infix() {
    return this.treeRoot.getInOrder();
  }


}
