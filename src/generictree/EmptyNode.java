package generictree;

import data.Operand;

public class EmptyNode implements GenericTreeNode {
  Operand operand;

  public EmptyNode(Operand d) {
    this.operand = d;
  }

  @Override
  public String getPreOrder() {
    return operand.toString();
  }

  @Override
  public String getInOrder() {
    return operand.toString();
  }

  @Override
  public Operand calculate() {
    return this.operand;
  }
}
