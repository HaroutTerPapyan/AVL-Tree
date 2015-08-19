/*
Harout Ter-Papyan
Comp 282
Project 3
AVLTest.java
*/


/*
 * To change this license header, choose License Headers in 
      Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Harout
 */
public class AVLTest {
    
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
	      
	    System.out.println("\nInserting values: ");
	      
                for(int k = 0; k < numbers.length; k++){
	            tree.insert(numbers[k]);
                    System.out.println("inserted: " + numbers[k]);
            }

            System.out.println("\nprinted in order :");
            tree.printInorder();
            
            System.out.println("\nprinted pre order :");
	    tree.printPreorder();
            System.out.println("\n");
	    printStats(tree);
	            
	    System.out.println("\nChecking Search"); 
	    int z = 89;
	    System.out.println( z + " is in tree? " + tree.search(z));
	    z = 50;
	    System.out.println( z + " is in tree? " + tree.search(z));
	      
	    System.out.println("\nChecking Delete: ");
	    for(int k = 0; k < delnumbers.length; k++)
	            tree.delete(delnumbers[k]);
	    tree.printInorder();
	    tree.printPreorder();
	    printStats(tree);


	    System.out.println("\nInserting More Values: ");
	    AVLTree tree2 = new AVLTree();
	    int n = 5000;
	    for( int k = 0; k < n; k++)
	        tree2.insert(  (int) (Math.random() * 100) );
	    printStats(tree2);
	    System.out.println( "log2(" + n + ")  = " 
                    + Math.log(n)/Math.log(2));
	      
	    System.out.println("\nCheck Search 2: ");
	    while(tree2.search(3))
	        tree2.delete(3);
	    System.out.println("Is 3 still in the tree? " + tree2.search(3));
	    printStats(tree2);
	            

	                      	
	                  
	}
    
}

/*
****************************OUTPUT********************************
run:

Inserting values: 
inserted: 10
inserted: 70
inserted: 20
inserted: 30
inserted: 40
inserted: 50
inserted: 60

printed in order :
 60 
 10 
 70 

printed pre order :
 70 
 10  60 


Tree is height balanced? : true
Tree height: 1
Node count: 7

Checking Search
89 is in tree? false
50 is in tree? false

Checking Delete: 
 60 
 10 
 70 
 70 
 10  60 
Tree is height balanced? : true
Tree height: 1
Node count: 7

Inserting More Values: 
Tree is height balanced? : true
Tree height: 1
Node count: 5000
log2(5000)  = 12.28771237954945

Check Search 2: 
Is 3 still in the tree? false
Tree is height balanced? : true
Tree height: 1
Node count: 5000
BUILD SUCCESSFUL (total time: 0 seconds)


*/
