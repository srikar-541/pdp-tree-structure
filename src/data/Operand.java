package data;

public interface Operand {

  public Operand add(Operand other);

  public Operand subtract(Operand other);

  public Operand multiply(Operand other);

  public Operand divide(Operand other);

  public Operand modulo(Operand other);

  public Operand union(Operand other);

  public Operand intersect(Operand other);
}
