package generictree;

import data.Operand;

public interface GenericTreeNode {

  String getPreOrder();

  String getInOrder();

  Operand calculate();
}
