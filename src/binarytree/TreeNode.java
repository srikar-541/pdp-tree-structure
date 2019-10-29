package binarytree;

import data.Operand;

/**
 * Underlying data structure which is used represent data passed to the
 * ExpressionTree and IntervalTree as a tree. The LeafNodes contains only operands
 * and all other GroupNodes contains only operators.
 * The operands and operators are specific to each implementation.
 * If offers basic functionality like evaluating the tree, inorder traversal, preorder
 * traversal and textree representation of the tree.
 */
public interface TreeNode {

  /**
   * Returns the preorder traversal of the tree formed. Returns it as a
   * string.
   * @return    String representation of the preorder traversal of the tree.
   */
  String getPreOrder();

  /**
   * Returns the inorder traversal of the tree formed. Returns it as a
   * string.
   * @return    String representation of the inorder traversal of the tree.
   */
  String getInOrder();

  /**
   * This function evaluates the tree level by level and returns the intermediate result
   * to the level above.
   * @return     The implementation specific operand which is an intermediate result of computing
   *            left and right children.
   */
  Operand calculate();

  /**
   * Based on the value of operatorCount, this method accumulates the string in the StringBuilder
   * recursively, after generating the required formatting.
   * A new StringBuilder object and 0 passed as argument when it is called.
   * @param     result accumulates the output.
   * @param     level signifies the level of tree at which we are in right now.
   */
  void getTextTree(StringBuilder result, int level);
}
