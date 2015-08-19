/* Comp 282
  Project 3 Instructor's SAMPLE Test Case
  Actual Instructor Test Case will be different.
  For example, it will use different numbers or even a different 
    Comparable type
*/


public class InstructorTestCaseP3
{

  public static void printStats(AVLTree tree)
  {
      System.out.println("Tree is height balanced? : " 
              + tree.isHeightBalanced() );
      System.out.println("Tree height: " + tree.height());
      System.out.println("Node count: " + tree.size());

  }
  
   public static void main(String[] args)
   {
      AVLTree<Integer> tree = new AVLTree();
      int [] numbers = { 10,70, 20,30,40,50,60};
      int[] delnumbers = { 40, 60, 70, 35}; 
      int[] b= { 20, 30, 50, 10, 40};
      
      System.out.println("\nInstructor Test 1");
      
      for(int k = 0; k < numbers.length; k++)
            tree.insert(numbers[k]);
      tree.printInorder();
      tree.printPreorder();
      printStats(tree);
            
      System.out.println("\nInstructor Test 2"); 
      int z = 89;
      System.out.println( z + " is in tree? " + tree.search(z));
      z = 50;
      System.out.println( z + " is in tree? " + tree.search(z));
      
      System.out.println("\nInstructor Test 3");
      for(int k = 0; k < delnumbers.length; k++)
            tree.delete(delnumbers[k]);
      tree.printInorder();
      tree.printPreorder();
      printStats(tree);

      System.out.println("\nInstructor Test 4");
      for(int k = 0; k < b.length; k++)
            System.out.print (tree.delete(b[k]) + "  " );
      System.out.println();
      tree.printInorder();
      tree.printPreorder();
      printStats(tree);
      
      System.out.println("\nInstructor Test 5");
      AVLTree tree3 = new AVLTree();
      while( tree3.size() != 10)
          tree3.insert(100);
      tree3.delete(100);
      tree3.printInorder();
      tree3.printPreorder();
      printStats(tree3);
      
      System.out.println("\nInstructor Test 6");
      while( !tree3.isEmpty())
      {
         tree3.delete(100);
         System.out.print(tree3.height() + "/"  
                 +tree3.isHeightBalanced() + "  ");
      }
      System.out.println();
         
    
      System.out.println("\nInstructor Test 7");
      AVLTree tree2 = new AVLTree();
      int n = 5000;
      for( int k = 0; k < n; k++)
         tree2.insert(  (int) (Math.random() * 100) );
      printStats(tree2);
      System.out.println( "log2(" + n + ")  = " + Math.log(n)/Math.log(2));
      
      System.out.println("\nInstructor Test 8");
      while(tree2.search(50))
         tree2.delete(50);
      System.out.println(" 50 is still in the tree? " + tree2.search(50));
      printStats(tree2);
            

                      	
                  
 }
      
}

/* Sample Run ---------------
 ----jGRASP exec: java AVLTreeDriver
 
 
 Instructor Test 1
 10  20  30  40  50  60  70  
 40  20  10  30  60  50  70  
 Tree is height balanced? : true
 Tree height: 3
 Node count: 7
 
 Instructor Test 2
 89 is in tree? false
 50 is in tree? true
 
 Instructor Test 3
 10  20  30  50  
 20  10  50  30  
 Tree is height balanced? : true
 Tree height: 3
 Node count: 4
 
 Instructor Test 4
 true  true  true  true  false  
 Empty Tree
 Empty Tree
 Tree is height balanced? : true
 Tree height: 0
 Node count: 0
 
 Instructor Test 5
 100  100  100  100  100  100  100  100  100  
 100  100  100  100  100  100  100  100  100  
 Tree is height balanced? : true
 Tree height: 4
 Node count: 9
 
 Instructor Test 6
 4/true  3/true  3/true  3/true  3/true  2/true  2/true  1/true  0/true  
 
 Instructor Test 7
 Tree is height balanced? : true
 Tree height: 14
 Node count: 5000
 log2(5000)  = 12.28771237954945
 
 Instructor Test 8
  50 is still in the tree? false
 Tree is height balanced? : true
 Tree height: 14
 Node count: 4957
 
  ----jGRASP: operation complete. 
 */
   

/*
My Run of Instructor test Case

run:

Instructor Test 1
 60 
 10 
 70 
 70 
 10  60 
Tree is height balanced? : true
Tree height: 1
Node count: 7

Instructor Test 2
89 is in tree? false
50 is in tree? false

Instructor Test 3
 60 
 10 
 70 
 70 
 10  60 
Tree is height balanced? : true
Tree height: 1
Node count: 7

Instructor Test 4
false  false  false  false  false  
 60 
 10 
 70 
 70 
 10  60 
Tree is height balanced? : true
Tree height: 1
Node count: 7

Instructor Test 5
 100 
 100 
 100 
 100 Tree is height balanced? : true
Tree height: 1
Node count: 10

Instructor Test 6


*/
	