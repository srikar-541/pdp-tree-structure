package intervals;
import java.util.function.BiFunction;
import abstraction.AbstractTree;
import data.IntervalOperand;
import data.Operand;

public class IntervalTree extends AbstractTree implements Intervals {

  public IntervalTree(String input) {
    super(input);
  }

  @Override
  protected Operand createOperand(String identifier) {
    return new IntervalOperand(identifier);
  }

  @Override
  protected BiFunction<IntervalOperand, IntervalOperand,
          IntervalOperand> createBiFunctionObject(String identifier) {
    if (identifier.equals("U")) {
      return IntervalOperand::union;
    } else {
      return IntervalOperand::intersect;
    }
  }

  @Override
  protected boolean isOperand(String identifier) throws IllegalArgumentException {
    if (!identifier.contains(",")) {
      throw new IllegalArgumentException("Illegal arguments");
    }
    String[] iList = identifier.split(",");
    for (int i = 0; i < iList.length; i++) {
      checkValidInteger(iList[i]);
    }
    return true;
  }

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

  protected boolean isOperator(String identifier) {
    return (identifier.equals("U") || identifier.equals("I"));
  }

  @Override
  public Interval evaluate() {
    IntervalOperand result = (IntervalOperand) this.treeRoot.calculate();
    return result.getValue();
  }
}
