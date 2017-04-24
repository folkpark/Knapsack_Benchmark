import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//A Dynamic Programming based solution for 0-1 Knapsack problem
class Knapsack
{

 // A utility function that returns maximum of two integers
 static int max(int a, int b) { return (a > b)? a : b; }
   
// Returns the maximum value that can be put in a knapsack of capacity W
 static int knapSack(int W, int wt[], int val[], int n)
 {
      int i, w;
      int K[][] = new int[n+1][W+1];
   
  // Build table K[][] in bottom up manner
  for (i = 0; i <= n; i++)
  {
      for (w = 0; w <= W; w++)
      {
          if (i==0 || w==0)
               K[i][w] = 0;
          else if (wt[i-1] <= w)
                K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
          else
                K[i][w] = K[i-1][w];
      }
   }
   
   return K[n][W];
 }
   
   // Driver program to test above function
   public static void main(String args[]) throws FileNotFoundException
   {
        
        Scanner values = new Scanner(new File("KnapsackValues.txt"));
        int[] val = new int[1000];
        int i = 0;
        while(values.hasNextInt())
        {
             val[i++] = values.nextInt();
        }
        
        Scanner weights = new Scanner(new File("KnapsackWeights.txt"));
        int[] wt = new int[1000];
        int j = 0;
        while(weights.hasNextInt())
        {
             wt[j++] = weights.nextInt();
        }
        
        int  W = 5000;
        int n = val.length;
        int trials = 100;
        
        for(int k=0;k<trials;k++){
        	long duration = 0;
    		long start = System.nanoTime();
    		knapSack(W, wt, val, n);
    		long end = System.nanoTime();
    		duration = end - start;
    		System.out.println(duration);
        }
    
   }
}
