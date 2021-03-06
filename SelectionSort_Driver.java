 // name:     date:
import java.util.*;
import java.io.*;
public class SelectionSort_Driver
{
   public static void main(String[] args) throws Exception
   {
     //Part 1, for doubles
      int n = (int)(Math.random()*100)+20;
      double[] array = new double[n];
      for(int k = 0; k < array.length; k++)
         array[k] = Math.random()*100;	
      
      Selection.sort(array);
      print(array);
      if( isAscending(array) )
         System.out.println("In order!");
      else
         System.out.println("Out of order  :-( ");
      System.out.println();
      
      //Part 2, for Strings
      int size = 100;
      Scanner sc = new Scanner(new File("declaration.txt"));
      Comparable[] arrayStr = new String[size];
      for(int k = 0; k < arrayStr.length; k++)
         arrayStr[k] = sc.next();	
   
      Selection.sort(arrayStr);
      print(arrayStr);
      System.out.println();
      
      if( isAscending(array) )
         System.out.println("In order!");
      else
         System.out.println("Out of order  :-( ");
   }
   public static void print(double[] a)
   {
      for(double d: a)         //for-each
         System.out.print(d+" ");
      System.out.println();
   }
   public static void print(Object[] papaya)
   {
      for(Object abc : papaya)     //for-each
         System.out.print(abc+" ");
   }
   public static boolean isAscending(double[] a)
   {
      boolean k=true;
      for(int j=0;j<a.length-1;j++)
      {
         if(a[j]>a[j+1])
            k=false;
         
      }
      return k;
   }
   @SuppressWarnings("unchecked")//this removes the warning for Comparable
   public static boolean isAscending(Comparable[] a)
   {
     boolean k=true;
      for(int j=0;j<a.length-1;j++)
      {
         if(a[j].compareTo(a[j+1])>0)
            k=false;
         
      }
      return k;
   }
}
//*********************************************
//name:    date:
class Selection
{
   public static void sort(double[] array)
   {
      for(int k=array.length-1;k>=0;k--)
      {
         int x=findMax(array,k);
         swap(array,k,x);
      }
      
   }
   private static int findMax(double[] array, int upper)//"upper" controls where the inner															//loop of the Selection Sort ends
   {
      double max=array[0];
      int maxIndex=0;
      for(int k=0;k<=upper;k++)
      {
        if(max<array[k])
        {
            max=array[k];
            maxIndex=k;
        }  
      }
      return maxIndex;
   }
   private static void swap(double[] array, int a, int b)
   {
      double x=array[a];
      double y=array[b];
      array[a]=y;
      array[b]=x;

   }   	
   
	/*******  for Comparables ********************/
   @SuppressWarnings("unchecked")//this removes the warning for Comparable
    public static void sort(Comparable[] array)
   {
      for(int k=array.length-1;k>=0;k--)
      {
         int x=findMax(array,k);
         swap(array,k,x);
      }
   
   }
   @SuppressWarnings("unchecked")
    public static int findMax(Comparable[] array, int upper)
   {
      int maxIndex=0;
      for(int k=0;k<=upper;k++)
      {
        if(array[maxIndex].compareTo(array[k])<0)
        {
            maxIndex=k;
        }  
      }
      return maxIndex;
   }
   public static void swap(Object[] array, int a, int b)
   {
      Object x=array[a];
      Object y=array[b];
      array[a]=y;
      array[b]=x;
   
   }
}
