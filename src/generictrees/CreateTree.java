
package generictrees;

import java.util.ArrayList;
import java.util.Stack;


public class CreateTree {
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
        
        display(root);
        }
    
        public static void display(Node node){
            String str = node.data+"->";
            for(Node child:node.children){
                str = str + child.data + " ";
                
            }
            System.out.println(str);
            
            for(Node child:node.children){
                display(child);
            }
        }
        
}

