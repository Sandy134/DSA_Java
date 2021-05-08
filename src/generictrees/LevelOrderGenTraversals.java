
package generictrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;
import sun.nio.cs.ArrayDecoder;


public class LevelOrderGenTraversals {
    
    static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    public static void main(String args[]){
         Node root = null ;
        Stack<Node> s = new Stack<>();
        int arr[]={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        for(int i=0;i<arr.length;i++){
            if(arr[i]==-1){
                s.pop();
            }else{
                Node t = new Node(); 
                t.data = arr[i];
                if(!s.empty()){
                     
                     s.peek().children.add(t);
                     
                }
                else{
                    root =t;
                }
             s.push(t);  
            }
        }
        
        ArrayDeque<Node>dq = new ArrayDeque<>();
        dq.add(root);
        while(!dq.isEmpty()){
            Node current = dq.remove();
            System.out.print(current.data+" ");
            for(Node temp:current.children){
                dq.add(temp);
            }
        }
        System.out.println();
    }
}
