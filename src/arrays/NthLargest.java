
package arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class NthLargest {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        int k=in.nextInt();
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        
        for(int i=0;i<n;i++){
            if(pq.size()<k){
                pq.add(a[i]);
            }
            else{
                if(a[i] > pq.peek()){
                    pq.remove();
                    pq.add(a[i]);
                }
            }
        }
        System.out.println(pq.peek());
        
    }
}
