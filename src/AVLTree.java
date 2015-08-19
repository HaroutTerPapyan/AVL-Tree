/*
Harout Ter-Papyan
Comp 282
Project 3
AVLTree.java
*/
class AVLNode<E extends Comparable<E>> {
	 //non-public class

	private E item;

	private AVLNode<E> parent;

	AVLNode<E> left; //leftChild

	AVLNode<E> right; //rightChild

	private int height;
	
	public AVLNode (E item) { 
		this.item = item;
		right = null;
		left = null;
		parent = null;
	}

	public AVLNode(E item, AVLNode<E> p, AVLNode<E> lft, AVLNode<E> rt) {
		this.item = item;
		right = rt;
		left = lft;
		parent = p;
	}
	
	public E getItem() {
		return item;
	}

	public void setItem(E item) {
		this.item = item;
	}

	public AVLNode<E> getParent() {
		return parent;
	}

	public void setParent(AVLNode<E> parent) {
		this.parent = parent;
	}

	public AVLNode<E> getLeft() {
		return left;
	}

	public void setLeft(AVLNode<E> left) {
		this.left = left;
	}

	public AVLNode<E> getRight() {
		return right;
	}

	public void setRight(AVLNode<E> right) {
		this.right = right;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String toString(){
		return " " + item + " ";
	}
}
public class AVLTree<E extends Comparable<E>> {

	private AVLNode<E> root;
	int size;
    private AVLNode<E> item;

	/*------ public methods------*/

	public AVLTree() {
            root = null;
            size = 0;
	}
        public void AVLTree( E item) {
		root = new AVLNode<E>(item);
		size = 0;
	}

        
	public boolean isEmpty() {
            if(root == null) 
                return true;
            else
                return false;
		
	}
        
        public void makeEmpty() {
            root = null;
        }

	public int size() {
		return size;
	}

	public int height() {
		if(isEmpty())
			return 0;
		else{
			int leftHeight = 0;
			int rightHeight = 0;

			if(leftHeight > rightHeight)
				return leftHeight + 1;
			else
				return rightHeight + 1;
		}
	}

	private int height(AVLNode<E> t){
		if(t == null){
			return 0;
		}
		else{
			int leftHeight = 0;
			int rightHeight = 0;
			if(root.getLeft() != null)
				leftHeight = height(t.getLeft());
			if(root.getRight() != null)
				rightHeight = height(t.getRight());
			if(leftHeight > rightHeight)
				return leftHeight + 1;
			else
				return rightHeight + 1;
		}
	}
	
	public boolean search (E item) {
            	AVLNode<E> p = root;
		
		while (p != null) {
			if (item.compareTo(p.getItem()) == 0)
				return true;
			else if(item.compareTo(p.getItem()) < 0)
				p = p.getLeft();
			else
				p = p.getRight();
		}
		return false;
            
/*

		if(isEmpty())
			return false;
		else{
			AVLNode<E> p = root;
			while(p != null){
				if(item.compareTo(p.getItem()) < 0){
					p = p.getLeft();
				}
				else if(item.compareTo(p.getItem()) > 0){
					p = p.getRight();
				}
				else
					return true;
			}
			return false;
		}
*/		
	}
        
	public void insert (E item) { //Duplicates ok 
 
          	AVLNode<E> par = null;
		AVLNode<E> p = root;
                AVLNode<E> w = new AVLNode(item);
		
		while(p != null) {
			if (item.compareTo(p.getItem())== 0)
				System.out.println();
			else if (item.compareTo(p.getItem()) < 0) {
				par = p;
				p = p.getLeft();
                                par.setLeft(w);
			}
			else {
				par = p;
				p = p.getRight();
                                par.setRight(w);
			}
		}

		//set parent field of w;
		w.setParent(par);
		
		size++;
/*               
                AVLNode<E> node = root;
                if(root == null) {
                    root = new AVLNode(item);
                }

                while(node != null) {
                    if(node.getItem().compareTo(item) > 0){
                        if(node.getLeft() == null) {
                            node = new AVLNode(item, node.getParent(), 
                                    null, null);
                                root.setLeft(root.getLeft());

                            root.setLeft(node);
                         }
                        node = node.getLeft();
                    }
                    else {
                        if(node.getRight() == null) {
                            node = new AVLNode(item, node.getParent(), 
                                    null, null);
                                root.setRight(root.getRight());
                            root.setRight(node);
                        }
                        node = node.getRight();
                    }
                }
                size++;
                if(!isHeightBalanced()){
                    triNodeRestructure(root);
		}
*/
        } 



	public boolean delete (E item) {
		//
            
		return false;
	}

   
	public boolean isHeightBalanced() {
		if(isEmpty())
			return true;
		else{
			int l = height(root.getLeft());
			int r = height(root.getRight());
			if(Math.abs(l - r) > 1)
				return false;
			else
				return (rheight(root.getLeft()) 
                                        && rheight(root.getRight()));
		}
	}

	public void printPreorder() {
		printPreorder(item);
	}

	private void printPreorder(AVLNode<E> t){  
            if (t != null) {
                printPreorder(t.getRight());
                System.out.print(t.toString());
                printPreorder(t.getLeft());
            }

	}
	
	public void printInorder() {
		printInorder(root);
	}
	
	private void printInorder(AVLNode<E> t){  
            if (t != null) {
                printInorder(t.getLeft());
                System.out.println(t.toString());
                printInorder(t.getRight());
            }
                
	}

	/*----- Private Methods ----*/

	private boolean rheight(AVLNode<E> t){
		if(t == null)
			return true;
		else{
			int a = 0;
			int b = 0;
			if(t.getLeft() != null)
				a = height(t.getLeft());
			if(t.getRight() != null)
				b = height(t.getRight());
			if(Math.abs(a -b) > 1)
				return false;
			else
				return (rheight(t.getLeft()) 
                                        && rheight(t.getRight()));
		}
	}


	private AVLNode<E> triNodeRestructure(AVLNode<E> x) {

		AVLNode<E> y = x.getParent();
		AVLNode<E> z = x.getParent().getParent();
		AVLNode<E> ggparent = z.getParent(); //may be null

		AVLNode<E> a,b,c;
		AVLNode<E> t1,t2,t3,t4;

		if (x == y.getLeft() && y == z.getLeft()) {

			//x is left of y and y is left of x

			a = x;
			b = y;
			c = z;
			t1 = x.getLeft();
			t2 = y.getRight();
			t3 = y.getRight();
			t4 = z.getRight();

		}

		else if (x==y.getRight() && y == z.getLeft()) {
			//x right of y and y left of x

			a = x;
			b = y;
			c = z;
			t1 = y.getLeft();
			t2 = x.getLeft();
			t3 = x.getRight();
			t4 = z.getRight();

		}

		else if (x == y.getRight() && y == z.getRight()) {
			//x right of y and y left of x

			a = y;
			b = x;
			c = z;
			t1 = y.getLeft();
			t2 = x.getLeft();
			t3 = x.getRight();
			t4 = z.getRight();

		}

		else if (x == y.getRight() && y == z.getRight()) {

			//x right of y and y right of x

			a = y;
			b = x;
			c = z;
			t1 = y.getLeft();
			t2 = x.getLeft();
			t3 = x.getRight();
			t4 = z.getRight();


		}
		//
		return root;
        }
}