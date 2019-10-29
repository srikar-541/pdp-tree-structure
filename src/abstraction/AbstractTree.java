package abstraction;

import java.util.Stack;
import java.util.function.BiFunction;

import binarytree.GroupNode;
import binarytree.LeafNode;
import binarytree.TreeNode;
import data.Operand;
import data.Operator;

/**
 * This class abstracts the common functionality of ExpressionTree and IntervalTree and any other
 * tree which can be added later. It has basic methods like validation of input, inorder, preorder
 * traversal etc.
 */
public abstract class AbstractTree {
  /**
   * treeRoot Root of the tree which is used to maintain underlying data for easy evaluation.
   * validationStack  This stack is used to validate the input passed to the constructor as a
   * string.
   */
  protected TreeNode treeRoot;
  private Stack<TreeNode> validationStack;

  /**
   * IntervalTree or ExpressionTree accepts input in the form of string separated by spaces. This
   * constructor parses the inputs, creates nodes and throws exception if the input is invalid. It
   * instantiates a new stack which is used for input validation. It removes any leading and
   * trailing spaces before passing it to parse method, throws exception if input passed is null or
   * empty string.
   * It ignores multiple spaces in between terms.
   *
   * @param input Input passed as string separated by spaces.
   */
  protected AbstractTree(String input) {
    validationStack = new Stack<>();
    if (input == null) {
      throw new IllegalArgumentException("Illegal Arugmnets");
    }
    input = input.trim();
    if (input.length() == 0) {
      throw new IllegalArgumentException("Illegal Arugmnets");
    }
    validateInput(input.trim());
  }

  /**
   * Returns a string that is the textual representation of the tree structure. IntervalTree and
   * ExpressionTree both carry this method hence abstracted.
   *
   * @return Tree representation of the string input.
   */
  public String textTree() {
    StringBuilder result = new StringBuilder();
    treeRoot.getTextTree(result, 0);
    return result.toString();
  }

  /**
   * Mandates the implementations of this class to override the isOperator because the operator
   * types are different in different implementations of this. Example: ExpressionTree accepts plus
   * minus star slash operators whereas IntervalTree accepts union and intersection operators.
   *
   * @param identifier A token passed as input for which the validation has to be done.
   * @return Returns true if the identifier is a valid operator else false.
   */
  protected abstract boolean isOperator(String identifier);

  /**
   * Mandates the implementations of this class to override the isOperand because the operand types
   * are different in different implementations. Example: ExpressionTree accepts operands only in
   * number format whereas IntervalTree accepts Interval class operands.
   *
   * @param identifier A token passed as input for which the validation has to be done.
   * @return Returns true if the identifier passed is a valid operand else false.
   * @throws IllegalArgumentException Throws exception if the identifier contains multiple decimal
   *                                  points like 1.2.2 or 1,2,2 etc.
   */
  protected abstract boolean isOperand(String identifier) throws IllegalArgumentException;

  /**
   * Used to validate if the input passed as a constructor argument is incomplete. If there are more
   * than 1 elements in the stack it means the input is incomplete.
   */
  private void isInvalidAfterParsing() {
    if (validationStack.size() == 1) {
      this.treeRoot = validationStack.pop();
      return;
    }
    if (validationStack.size() > 1) {
      throw new IllegalArgumentException("Exception");
    }
  }

  /**
   * Validates the input passed to the ExpressionTree and IntervalTree. It does basic validation
   * like valid operators, operands, invalid string input like more operators that operands, invalid
   * placing of operators and operands. Incomplete expression/intervals will throw exception.
   *
   * @param input The trimmed string passed to the constructor.
   * @throws IllegalArgumentException Throws exception if any of the validations fail.
   */
  private void validateInput(String input) throws IllegalArgumentException {
    String[] terms = input.split(" ");
    for (String term : terms) {
      if (term.length() == 0) {
        continue;
      }
      if (isOperator(term)) {
        if (validationStack.size() < 2) {
          throw new IllegalArgumentException("Illegal arguments");
        } else {
          TreeNode right = validationStack.pop();
          TreeNode left = validationStack.pop();
          BiFunction biFunction = createBiFunctionObject(term);
          Operator operator = new Operator(term, biFunction);
          this.treeRoot = new GroupNode(operator, left, right);
          validationStack.push(this.treeRoot);
        }
      } else if (isOperand(term)) {
        Operand operand = createOperand(term);
        validationStack.push(new LeafNode(operand));
      }
    }
    isInvalidAfterParsing();
  }

  /**
   * Mandating the createOperand functionality because each implementation will create operands of
   * different types.
   *
   * @param identifier The identifier is a validated operand specific to the implementation.
   * @return Returns the created operand which contains the data passed as parameter.
   */
  protected abstract Operand createOperand(String identifier);

  /**
   * Creates and returns a bifunction which takes types as operands specific to each implementation.
   * This bifunction is used in evaluate function to avoid unnecessary typecasting. Example:
   * BiFunction of ExpressionTree takes in ExpressionOperand and BiFunction of IntervalTree takes in
   * IntervalOperand as type input. When evaluate method is called by ExpressionTree or
   * IntervalTree, this bifunction is applied on the arguments and the result is returned.
   *
   * @param identifier The operator for which a new bifunction has to be created.
   * @return Returns a new bifunction which will be passed as input to operator class.
   */
  protected abstract BiFunction createBiFunctionObject(String identifier);
}
