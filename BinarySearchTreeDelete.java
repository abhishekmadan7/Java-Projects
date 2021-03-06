import java.util.*;

public class BinarySearchTreeDelete
{
   private static TreeNode root = null;
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("Input string: ");
      String s = sc.nextLine();
   	         				//Case 1:  		ECSBPWANR 
   								//Case 2a:  	SNTPOR    
   								//Case 2b:	   HBRNVJSZIK  
   								//Case 3.a.i:  DBNACFSEJHM 
   								//Case 3.a.ii: NFSAKPXGQ 
   								//Case 3b:     RNVGPCAE 
   								//Case root:   N
   								//on the handout: HDJAGKFEOLTMNSU
      root = buildTree( root, s );
      System.out.println( display(root, 0) );
      System.out.print("Delete? ");
      String target = sc.next();
      if( contains( root, target ) )
      {
         root = delete( root, target );
         System.out.println("\n" + target+" deleted.");
      }
      else
         System.out.println("\n" + target+" not found");
      System.out.println( display(root, 0) );
   }
   public static TreeNode buildTree(TreeNode t, String s)
   {
      for(int k = 0; k < s.length(); k++)
         t = insert(t, "" + s.charAt(k));
      return t;
   }
	/**************************
	Recursive algorithm to build a BST:  if the node is null, insert the 
	new node.  Else, if the item is less, set the left node and recur to 
	the left.  Else, if the item is greater, set the right node and recur 
	to the right.   
	*****************************/
   public static TreeNode insert(TreeNode t, String s)
   {  	
      if(t==null)
         return new TreeNode(s);
      if(s.compareTo(t.getValue()+"")<0)
         t.setLeft(insert(t.getLeft(), s));
      else
         t.setRight(insert(t.getRight(), s));
      return t;
   }
   
   private static String display(TreeNode t, int level)
   {
      String toRet = "";
      if(t == null)
         return "";
      toRet += display(t.getRight(), level + 1); //recurse right
      for(int k = 0; k < level; k++)
         toRet += "\t";
      toRet += t.getValue() + "\n";
      toRet += display(t.getLeft(), level + 1); //recurse left
      return toRet;
   }
   
   public static boolean contains( TreeNode current, String target )
   {
      while(current != null)
      {
         int compare = target.compareTo((String)current.getValue());
         if( compare == 0 )
            return true;
         else if(compare<0)
            current = current.getLeft();
         else if(compare>0)
            current = current.getRight();
      }
      return false;
   }
   public static TreeNode delete(TreeNode current, String target)
   {
      TreeNode root = current;
      TreeNode parent = null;
      while(current !=null)
      {
         int compare = target.compareTo((String)current.getValue());
         if(compare == 0)
            break;
         parent = current;
         if(compare < 1)
            current = current.getLeft();
         else
            current = current.getRight();
      }
      if(current.getLeft() == null && current.getRight() == null)
      { 
         if(((String) current.getValue()).compareTo((String) parent.getValue()) > 0)
            parent.setRight(null);
         else
            parent.setLeft(null);  
      }
      else if((current.getRight()!=null && current.getLeft()==null) || (current.getRight()==null && current.getLeft()!=null))
      {
         if(current.getRight() != null)
         {
            if(((String) current.getValue()).compareTo((String) parent.getValue()) > 0)
               parent.setRight(current.getRight());
            else
               parent.setLeft(current.getRight());
     
         }
         else
         {
            if(((String) current.getValue()).compareTo((String) parent.getValue()) > 0)
               parent.setRight(current.getLeft());
            else
               parent.setLeft(current.getLeft());
         }
      }
      else if(current.getRight() != null && current.getLeft() != null)
      {
         TreeNode pT = current;
         TreeNode cT = current.getLeft();
         while(cT.getRight() != null) 
         {
            pT = cT;
            cT = cT.getRight();
         }
         current.setValue(cT.getValue());
         if(cT.getLeft() == null)
            pT.setRight(null);
         else
            pT.setRight(cT.getLeft());
      }
      return root;  //never reached
   }

}