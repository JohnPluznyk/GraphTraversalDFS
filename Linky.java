public class Linky{
   
  // represents a node the singly linked list 
    static class Node{
      int data; // this is the data that will be attached to the node
      Node next; //this is telling where the node to point to
      
      public Node(int data){ //basic constructor
         this.data = data;
         this.next = null;
      }
   }
   // intialzing head
   public static Node head = null; 
   // intialzing tail
   public static Node tail = null;
   
   //addNode() is a method that will add one to the link list
   public static void addNode(int data){
      //create a new node
      
      Node newNode = new Node(data);
      //checs if the list is empty
      if(head == null){
         head = newNode;
         tail = newNode;
      }
      
      else{
         //newNode will be added after tail such that tails next will point to newNode
         tail.next = newNode;
         //newNode will become new tail of the list
         tail = newNode;
      
       }
      }
      public static void display(){
         Node current = head;
         
         if(head == null){
            System.out.println("List is empty");
            return;
         }
         System.out.println("Nodes of singly linked list: ");
         
         while(current != null){
         
            System.out.print(current.data + " ");
            current = current.next;
         }
         System.out.println();
         
      }
      
   }
   
