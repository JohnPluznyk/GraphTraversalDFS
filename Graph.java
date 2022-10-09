import java.util.Scanner;

public class Graph{
   Scanner sc = new Scanner(System.in);
   
   int[][] graph;  //graph used for adjaceny matrix
   private String answer = ""; //answer that will be returned
   Linky list = new Linky(); //used a linklist to help me understand how DFS was traversing through the graph
   LinkedListStack parents = new LinkedListStack();  //linked list to keep track of each childs parents
   boolean[] visited;    //boolean array to keep track of which nodes we have already visited
   
   //below is the constructor for the code
   public Graph(){
      System.out.print("Number of Nodes and Edges: ");  //needed for edge infomation
      String graphInformation = sc.nextLine(); //takes in number of nodes and edges
      int nodes, edges;
      
      String[] arrGraphInfo = graphInformation.split(" ", 0); //this allowed the user to enter nodes and edges as a string
      nodes = Integer.parseInt(arrGraphInfo[0]);
      edges = Integer.parseInt(arrGraphInfo[1]);
            
      graph = new int[nodes][nodes];//creates the graph by knowing the number of nodes that the user wishes to use;
      
      visited = new boolean[graph.length]; // sets length of array to help keep track of nodes which are visited
      //below makes an empty graph with all the nodes now time to fill in the edge infomration
      for(int i = 0; i<graph.length; i++)
         for(int j = 0; j<graph[i].length; j++)
            graph[i][j] = 0;
      
      System.out.print("Edge Information: ");
      String edgeInfo = sc.nextLine();
      edgeInfo = edgeInfo.replaceAll("\\s", "");
      int y = 0;
      //now take substring of opening pratehnse and closing then split the , of that substring and take edge info
      while(edgeInfo.length() != 0){ // while x is less then and not equal to edge Info
       
         if(edgeInfo.charAt(0) == '('){  // if x is at the postion of an opening pratehnse
            y = edgeInfo.indexOf(')');  //set y to psotion of closing partehnse
            
            String edge = edgeInfo.substring(1,y); //will get just the single edge  one mistake here
            String[] e = edge.split(",", 0); //splits the edge into an array e that has the two edge values
            
            graph[Integer.parseInt(e[0])][Integer.parseInt(e[1])] = 1; //take the edge values and put the into the array 
            graph[Integer.parseInt(e[1])][Integer.parseInt(e[0])] = 1;
            
            edgeInfo = edgeInfo.substring(y);
         }
         else
           edgeInfo = edgeInfo.substring(1); 
      } 
   }
   
  //make sure that the user is allowed to input the connections instead of mannualy inputing the connections myself
   
   void DFS(int start){
      //int start, pertains to row bc all the values on their rows should show their connectio
      
      list.addNode(start); //add node to linked list to know that we visited node helps visualize
      
      for(int i = 0; i<graph[start].length; i++){
         if(graph[start][i] == 1){ //if there is a connection
            
            visited[start] = true;
            
            graph[start][i] = 2; //change connection between nodes on graph to 2
            graph[i][start] = 2; //this change will let us know that this connection has been used
            
            parents.push(start); //this lets us know that the node that came before it
            DFS(i); //Recusive DFS statement
            
            list.addNode(start); // when revisting a node add it back to the linked list so we know where we are
           }
          
          //else if connection has already been visited and answer has not already been filled with a cycle
          else if(graph[start][i] == 2  && i != parents.peek() && visited[i] == true && answer.isEmpty() == true){
              
              answer += ("("+ start + ", " + parents.peek() + ") ");  //get first nodes that caused cycle

             while(parents.peek() != start){ //stop when it comes across node that found cycle
               answer += ("("+ parents.pop() + ", " + parents.peek() + ") ");  //append all the other nodes that...
             }                                                                 //...contributed to cylce
              return; // when the code is done travseing the cycle needs to get out of that recursive iteration so we call return
          }   
       }
       
       //if the answer has elmentents that means the above code has found a cylce in the graph
       if(answer.length() > 0)
         return;  
       parents.pop(); //for loop is done go back to its parent
       //end of DFS method
    }
 
      
  public void viewList(){
      list.display();
  }
      
  public String isCycle(){
   if(answer.length() == 0)
      return "This graph does not contain a cylce";
   return "This graph forms a cylce, and " + answer + "forms the cylce";
  }
  
   
   public String toString(){
      String x = "";
   
      for(int i = 0; i<graph.length; i++){
         for(int j = 0; j<graph[i].length; j++)
            x += (graph[i][j]) + " ";
        x += "\n";    
         }
      return x;
   }
   
}