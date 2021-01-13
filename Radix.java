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
    for(int i = 0; i < buckets.length; i++){
      original.extend(buckets[i]);
    }
  }

  public static void radixSortSimple(SortableLinkedList data){
    int pass = 0;
    int element = data.remove(0);
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    for(int i = 0; i < 10; i++){
      buckets[i] = new SortableLinkedList();
    }
    for(int i = 0; i < data.size(); i++){
      pass = Math.max(pass, length(data.get(0)));
      data.add(element);
    }
    for(int i = 0; i < pass; i++){
      while(data.size() > 0){
        buckets[nth(data.get(0), i)].add(element);
        merge(data,buckets);
      }
    }
  }

  public static void radixSort(SortableLinkedList data){

  }
}
