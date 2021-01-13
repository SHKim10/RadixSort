import java.util.*;
import java.io.*;
public class Radix{

  public static int nth(int n, int col){
    int a = (int) (n / Math.pow(10, col));
    return Math.abs(a % 10);
  }

  public static int length(int n){
    int a = Math.abs(n);
    int answer = 0;
    while(a > 0){
      answer++;
      a /= 10;
    }
    return Math.max(1, answer);
  }

  public static void merge(SortableLinkedList original, SortableLinkedList[] buckets){
    for (int i = 0; i < buckets.length; i++){
      original.extend(buckets[i]);
    }
  }

  public static void radixSortSimple(SortableLinkedList data){
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    for (int i = 0; i < buckets.length; i++){
      buckets[i] = new SortableLinkedList();
    }
    int pass = 1;
    for (int i = 0; i < pass; i++){
      while (data.size() < 0){
        if (i == 0){
          pass = Math.max(pass, length(data.remove(0)));
        }
        buckets[nth(data.remove(0), i)].add(data.remove(0));
      }
      merge(data,buckets);
    }
  }

  public static void radixSort(SortableLinkedList data){
    SortableLinkedList positive = new SortableLinkedList();
    SortableLinkedList negative = new SortableLinkedList();
    while (data.size() > 0){
      if (data.remove(0) >= 0){
        positive.add(data.remove(0));
      } else {
        negative.add(data.remove(0));
      }
    }
    radixSortSimple(positive);
    radixSortSimple(negative);
    while (negative.size() > 0){
      data.add(negative.remove(negative.size()-1));
    }
    data.extend(positive);
  }
}
