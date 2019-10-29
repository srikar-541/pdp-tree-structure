package data;

/**
 * This is a marker interface which is an interface for the operands specific
 * to each implementation.
 * Instead of pushing data into validation of type interval operand and
 * expression operand, we encapsulate all operands and use this type
 * to push data into the validation stack.
 * This design pattern doesn't just confine to validation but it is a way
 * to get both the implementations under the same category.
 * Any operand of different type can be encapusulated within this interface
 * which makes the code reusable.
 */
public interface Operand {
}
