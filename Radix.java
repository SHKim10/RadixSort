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

  public static void merge(MyLinkedList original, MyLinkedList[]buckets){
    for(int i = 0; i < buckets.length; i++){
      original.extend(buckets[i]);
    }
  }
}
