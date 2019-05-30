import java.util.*;
import java.io.*;
//import java.Scanner;
class Memory{
 
 public static void main(String args[]){
 Scanner sc=new Scanner(System.in);
 System.out.println("Enter the Process ");
 String s=sc.nextLine();
 int n=s.length();
 int page[]=new int[n+1];
 for(int i=0;i<s.length();i++){
  int l=((int)s.charAt(i))-48;
  page[i]=l;
  System.out.print(" "+l);
 }

 System.out.println("\nEnter the no of Frames ");
 int k=sc.nextInt();
 while(true){
 System.out.println("----------------------------------------------\nchoose any one\n 1.FIFO \n 2.LRU \n 3.Exit");
 int z=sc.nextInt();
 switch(z){
 
 case 1:fifo(page,k);
        break;
 case 2://lru(page,k);
        break;
 case 3:System.exit(0);
 default:System.out.println("Incorrect! option");
         break;
}

}
}
public static void fifo(int page[],int k){
int p=0;
int pagecount=0;
int flag=0;
int frame[]=new int[k+1];
for(int i=0;i<k;i++){
 frame[i]=-1;
}
for(int i=0;i<page.length;i++)
{
 for(int j=0;j<k;j++)
 {
  if(page[i]==frame[j]){
    flag=1;
    break;
  }
 }
  if(flag==0){
    frame[p]=page[i];
    p=(p+1)%k;
    pagecount++;
   }
  else{
   flag=0;
   }

 } 

System.out.println("The no of page faults are"+pagecount);
}
} 

