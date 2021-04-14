package main.com.vmware.talentboost.algorithms.sort;

import main.com.vmware.talentboost.algorithms.util.Node;

public class MergeSort {

   public static <T extends Comparable<T>> Node<T> sort(Node<T> head) {
      if (head == null || head.next == null) {
         return head;
      }

      throw new UnsupportedOperationException("Not implemented yet.");
   }
}
