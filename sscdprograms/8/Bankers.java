import java.io.*;
import java.util.*;

class Bankers{
 public static void main(String args[])throws Exception{
 BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
 Scanner sc=new Scanner(System.in);
 
 int count=0,process;
 System.out.println("Enter the no of process:");
 int n=Integer.parseInt(in.readLine());
 int safeSequence[]=new int[n];
 int finish[]=new int[n];
 for(int i=0;i<n;i++)
 {
  finish[i]=0;
 }
 
 System.out.println("Enter thye no Reasources:");
 int m=Integer.parseInt(in.readLine());
 
 System.out.println("Enter the maximum matrix");
 int max[][]=new int[n][m];
 for(int i=0;i<n;i++)
 {
  for(int j=0;j<m;j++)
  {
   max[i][j]=sc.nextInt();
  }
  //sc.next();
 }
 
 
 System.out.println("Enter the allocation Matrix");
 int allocation[][]=new int[n][m];
 for(int i=0;i<n;i++)
 {
  for(int j=0;j<m;j++)
  {
   allocation[i][j]=sc.nextInt();
  }
  //sc.next();
 }
 System.out.println("Enter the available Resourses");
 int available[]=new int[m];
 for(int i=0;i<m;i++)
 {
  available[i]=sc.nextInt();
 }
 
 int need[][]=new int[n][m];
 for(int i=0;i<n;i++)
 {
  for(int j=0;j<m;j++)
  {
   need[i][j]=max[i][j]-allocation[i][j];
  }
  //sc.next();
 }
 do
  {
   System.out.print("\n max matrix:\tallocation matrix:\n");
   for(int i = 0; i < n; i++)
   {
    for(int j = 0; j < m; j++)
	System.out.print(max[i][j]+" ");
    System.out.print("\t\t");
    for(int j = 0; j < m; j++)
	System.out.print(allocation[i][j]+" ");
    System.out.print("\n");
   }
   process = -1;
   for(int i = 0; i < n; i++){
      if(finish[i] == 0){
	process = i ;
	for(int j = 0; j < m; j++){
	   if(available[j] < need[i][j]){
		process = -1;
		break;
	    }
	 }
       }
     if(process != -1)
	 break;
    }
   if(process != -1){
     System.out.print("Process"+ (process + 1)+" completed ");
     safeSequence[count] = process + 1;
     count++;
     for(int j = 0; j < m; j++){
	available[j] += allocation[process][j];
	allocation[process][j] = 0;
	max[process][j] = 0;
	finish[process] = 1;
      }
			}
  }while(count != n && process != -1);
   if(count == n)
   {
     System.out.print("\nThe system is in a safe state!!\n");
     System.out.print("Safe Sequence : < ");
     for(int i = 0; i < n; i++)
	 System.out.print(safeSequence[i]+" , ");
     System.out.print(">\n");
    }
   else
      System.out.print("\nThe system is in an unsafe state!!");
 }
}



 
