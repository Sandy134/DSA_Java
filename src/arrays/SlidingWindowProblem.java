
package arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.PriorityQueue;

public class SlidingWindowProblem {
   public static void main(String args[]){
       Scanner in =new Scanner(System.in);
       System.out.println("ENter the value of n:");
       int n=in.nextInt();
       int arr[]=new int[n];
       for(int i=0;i<n;i++){
           arr[i]=in.nextInt();
       }
       System.out.println("Enter the window length");
       int k=in.nextInt();
       PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
       
       for(int i=0;i+k<=n;i++){
           for(int j=i;j<k+i;j++){
               pq.add(arr[j]);
           }
           System.out.println(pq.peek());
           pq.clear();
       }
   } 
}
