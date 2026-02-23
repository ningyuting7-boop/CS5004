package problem2;

/**
 * The ListOfStrings interface represents an immutable
 * recursive List Abstract Data Type (ADT) that stores Strings.
 *
 * A ListOfStrings is either:
 *  - an EmptyList, or
 *  - a NonEmptyList consisting of a String (first) and another ListOfStrings (rest).
 *
 * This ADT supports common list operations such as checking
 * emptiness, computing size, membership testing, duplicate detection,
 * and filtering based on string length.
 *
 * Implementations of this interface should not expose their internal
 * representation.
 */
public interface ListOfStrings {

  /**
   * Checks whether this list is empty.
   *
   * @return true if the list contains no elements, false otherwise
   */
  boolean isEmpty();

  /**
   * Returns the total number of elements in this list.
   *
   * @return the size of the list
   */
  int size();

  /**
   * Determines whether the given string exists in this list.
   *
   * @param s the string to search for
   * @return true if the string is contained in the list, false otherwise
   */
  boolean contains(String s);

  /**
   * Determines whether this list contains all elements
   * of the given list.
   *
   * @param other another ListOfStrings
   * @return true if every element in 'other' is contained
   *         in this list, false otherwise
   */
  boolean containsAll(ListOfStrings other);

  /**
   * Returns a new list where all strings whose length
   * is greater than the given maximum length are removed.
   *
   * @param maxLength the maximum allowed string length
   * @return a new filtered ListOfStrings
   */
  ListOfStrings filterLargerThan(int maxLength);

  /**
   * Checks whether this list contains at least one duplicate element.
   *
   * @return true if duplicates exist, false otherwise
   */
  boolean hasDuplicates();

  /**
   * Returns a new list with all duplicate elements removed.
   * The original list remains unchanged.
   *
   * @return a new ListOfStrings without duplicates
   */
  ListOfStrings removeDuplicates();

}