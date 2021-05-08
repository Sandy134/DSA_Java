
package generictrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

public class TraversalsGenTree {
    
      static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>(); 
    }
      
     static class Pair{
         Node n;
         int count;

        public Pair(Node n, int count) {
            this.n = n;
            this.count = count;
        }
         
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
        
//        ArrayDeque<Pair> dq = new ArrayDeque<>();
//        dq.add(new Pair(root,1));
//        String pre = "";
//        String post = "";
//        while(!dq.isEmpty()){
//            Pair current = dq.peek();
//            if(current.count==1){
//                pre+=current.n.data+",";
//                for(Node temp:current.n.children){
//                    dq.add(new Pair(temp,1));
//                }
//                current.count = 2;
//            }
//            else{
//                post+=current.n.data+",";
//                dq.remove();
//            }
//         }
//        
//        System.out.println(pre);
//        System.out.println(post);

          traverse(root);
          System.out.println();
    }
    public static void traverse(Node node){
        
        System.out.println("Node pre: "+node.data); //eulers left, on the way deep in the recursion
         for(Node child:node.children){
             //edge pre
             System.out.println("Edge pre "+node.data+"->"+child.data);
             traverse(child);
             System.out.println("Edge post "+node.data+"->"+child.data);
             //edge post
         }
         
         System.out.println("Node post: "+node.data);//on the way out of  recursion
         
         
    }
   
}
