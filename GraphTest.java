public class GraphTest{
   public static void main(String args[]){
      Graph test = new Graph();
      
      test.DFS(0);
      System.out.println("Output: " + test.isCycle());
   }
}