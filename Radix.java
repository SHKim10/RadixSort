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

  public static void merge(MyLinkedList original,MyLinkedList[]buckets){
    /*Merge all of the linked lists in the bucket array into your original linked list.
    This is O(buckets.length) which should be 10 when we use this later.
    The bucket[0] list will be merged first, then the bucket[1] etc.*/
  }
}
