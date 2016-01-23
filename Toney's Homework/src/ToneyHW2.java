/* Chad Toney
** 6-25-2015
** Professor Jon Youn
** CSCI 3320/8325
** Programming Assignment 2
*/

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;


public class ToneyHW2
{  
   private static Random rand = new Random();
   
   public static void main(String[] args)
   {
      //Variables
      int min = -9999;
      int max = 9999;
      int N = 0;
      int K = 0;
      int J = 0;
      Scanner scan = new Scanner(System.in);
      ArrayList<Integer> list = new ArrayList<Integer>();
      
         //Menu and input for which algorithm the user wishes to use
         System.out.println("1. Quadratic algorithm \n2. Logarithmic algorithm");
         System.out.println("3. Linear algorithm \n4. Exit the program \nChoose an algorithm: ");
         J = scan.nextInt();
         
         //Exit Command if J == 4
         if(J == 4)
         {
            System.exit(0); 
         }
         
         //User input for how many numbers to generate
         System.out.print("Enter size of random array: ");
         N = scan.nextInt();
         
         int[] a = new int[N];
         
         //for loop to print N random numbers
         for (int i = 0; i < N; i++)
         {
            list.add(randInt(min,max));   
         }
         
         //for loop to convert arraylist list to an array a
         for(int i = 0; i < list.size(); i++)
         {
            a[i] = list.get(i);
         }
         
         //Prints the list of numbers if less than 50
         if (N <50)
         {
            System.out.println(list + "\n");
         }
         
         //User input for the value of K
         System.out.println("Enter the K value: ");
         K = scan.nextInt();
         
         
         //Quadratic algorithm choice
            //Prints out the algorithm results
         long startTime = System.nanoTime();
         if(J == 1)
         {
            quadratic(list, K);           
         }
   
         //Logarithmic algorithm choice
         else if (J == 2)
         {
            quicksort(a, 0 , a.length - 1);
            if(N < 50)
               printArray(a);
            findK(a, K);
         }
         
         //Linear algorithm choice
         else if (J == 3)
         {
            linear(a);
         }
         
         //Choice if the user inputs anything besides 1,2,3,4
         else
         {
            System.out.println("Invalid selection");
         }
         long endTime = System.nanoTime();
         long duration = endTime - startTime;
         System.out.println("Execution Time in nanoseconds: " + duration);
   }
   
   //random number generator
   public static int randInt(int min, int max)
   {
   Random r = new Random();
   int R = r.nextInt((max-min) + 1 ) + min;
   // 9999-(-9999) + 1) -9999
   
   return R;
   }
   
   //Method for the O(N^2)
   public static int quadratic(ArrayList<Integer> list, int K) 
   {
      int sum = 0;
      
      System.out.println("Running the O(N^2) algorithm...");
      
      for(int i = 0; i < list.size(); i++) 
      {
         for(int j = i; j < list.size(); j++) 
         {
            sum = list.get(i) + list.get(j); 
            if(sum == K)
            {
               System.out.println("K = " + K + ", (" + list.get(i) + " + " + list.get(j) + ")");
               System.out.println("Yes, there are two numbers whose sum equals to K");
               j = list.size();
               break;
            }
            else
            {
            }                          
         }
         
      if(sum == K)
      {
         break;
      }
      
      }
      
      //Prints this message if there is no solution for K
      if(sum != K)
      {
         System.out.println("No, the algorithm could not find two numbers whose sum equals K");
      }
      return sum;
   }
   
   //Method for O(N log N)
   public static void quicksort(int[] a, int left, int right)
     {
          if (left < right)
          {
               int pivot = randomizedPartition(a, left, right);
               quicksort(a, left, pivot);
               quicksort(a, pivot + 1, right);
          }
     }
   
   //Method to pick a random number to start partitioning
   private static int randomizedPartition(int[] a, int left, int right)
   {
      int swapIndex = left + rand.nextInt(right - left) + 1;
      swap(a, left, swapIndex);
      return partition(a, left, right);
   }
   
   //Method to partition
   private static int partition(int[] a, int left, int right)
   {
      int pivot = a[left];
      int i = left - 1;
      int j = right + 1;
      
      while (true)
      {
         do
              j--;
         while (a[j] > pivot);

         do
              i++;
         while (a[i] < pivot);

         if (i < j)
              swap(a, i, j);
         else
              return j;
      }
   }
   
   //Method for swapping during quicksort 
   private static void swap(int[] a, int i, int j)
   {
      int tmp = a[i];
      a[i] = a[j];
      a[j] = tmp;
   }   
   //Method to print out the logarithmic algorithm
   public static void printArray(int[] a)
   {
      for(int i : a)
      {
         System.out.print(i+" ");
      }
      System.out.println("");
   }
   
   //Method to find which two numbers add up to get K
   public static int findK(int[] a, int K)
   {
      int sum = 0;
      
      for(int i = 0; i < a.length; i++)
      {
         for(int j = 0; j < a.length; j++)
         {
            sum = a[i] + a[j];
            
            if(sum == K)
            {
               System.out.println("K = " + K + " ( " + a[i] + "+ " + a[j] + ")");
               System.out.println("Yes, there are two numbers whose sum equals to K");
               break;
            }
         }
         if(sum == K)
         {
            break;
         }
      }
      if(sum != K)
      {
         System.out.println("No, the algorithm could not find two numbers whose sum equals to K");
      }
      return K;
   }
   
   //Method for O(N)
   public static int[] linear(int[] a) 
   {
      int sum = 0;
      int[] b = new int[a.length];
      int m = a[0];
      int exp = 1;
      
      for (int x = 0; x < a.length; x++)
      {
         a[x] += 9999;
      }
      for (int i = 0; i < a.length; i++)
      { 
        if (a[i] > m)
                m = a[i];
        while (m / exp > 0)
        {
            int[] bucket = new int[a.length];
 
            for (i = 0; i < a.length; i++)
                bucket[(a[i] / exp) % 10]++;
            for (i = 1; i < 10; i++)
                bucket[i] += bucket[i - 1];
            for (i = a.length - 1; i >= 0; i--)
                b[--bucket[(a[i] / exp) % 10]] = a[i];
            for (i = 0; i < a.length; i++)
                a[i] = b[i];
            exp *= 10;        
        }
      for (int x = 0; x < a.length; x++)
      {
         a[x] -= 9999;
      }
      }
      if(a.length < 50)
      {
         for (int i = 0; i < a.length; i++)
         {
               System.out.print(a[i]+" ");
         }
      }
      System.out.println(""); 
      return a;
   }
}