public class LinkedListStack{
   
   static class Node{
      int data; // this is the data that will be attached to the node
      Node next; //this is telling where the node to point to
      
      public Node(int data){ //basic constructor
         this.data = data;
         this.next = null;
      }
   }

   private Node top;
   private int size;
   
   LinkedListStack(){
      top = null;
      size = 0;
   }
   
   void push(int value){
      Node oldTop = top;
      top = new Node(value);
      top.next = oldTop;
      size ++;
   }
   
   int pop(){
      if(size == 0)
         throw new StackException("Stack is empty");
      int val = top.data;
      top = top.next;
      size --;
      return val;
   }
   
   int peek(){
      if (size == 0)
         throw new StackException("Stack is empty");
      return top.data;
   }
   
   public class StackException extends RuntimeException{
      public StackException(String message){
         super(message);
      }
   }
}