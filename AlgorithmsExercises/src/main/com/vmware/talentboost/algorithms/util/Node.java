package main.com.vmware.talentboost.algorithms.util;

public class Node<T extends Comparable<T>> {

   public final T value;
   public Node<T> next;

   public Node(T value) {
      this(value, null);
   }

   public Node(T value, Node<T> next) {
      if (value == null) {
         throw new IllegalArgumentException("The value cannot be null.");
      }
      this.value = value;
      this.next = next;
   }
}
