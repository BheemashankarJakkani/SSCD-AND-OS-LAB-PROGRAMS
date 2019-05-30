import java.io.*;
import java.util.*;

class Solution{
 public static void main(String args[]) throws Exception{
  int total_time=0;
  BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
  System.out.println("Enter the Time quanta");
  int time_quanta=Integer.parseInt(in.readLine());
  System.out.println("Enter the no of process");
  int nop=Integer.parseInt(in.readLine());
  int[] completion_time=new int[nop+1];
  System.out.println("Enter the Burst Time");
  String bt[]=in.readLine().split(" ");
  int btarray[]=new int[bt.length];
  for(int i=0;i<bt.length;i++)
  {
    btarray[i]=Integer.parseInt(bt[i]);
  }

  Queue<Integer> btime=new LinkedList<>();
  for(int i=0;i<btarray.length;i++)
  {
    btime.add(btarray[i]);
  }
  Queue<Integer> process=new LinkedList<>();
  for(int i=1;i<=nop;i++)
  {
    process.add(i);
    completion_time[i]=0;
    
  }
  
  while(process.isEmpty()==false)
  {
   int p=process.remove();
   int b=btime.remove();
   if((b-time_quanta)<=0){
     total_time+=b;
     completion_time[p]=total_time;
    }
   else{
     b-=time_quanta;
     total_time+=time_quanta;
     process.add(p);
     btime.add(b);
    }
 }
//  System.out.println("The Turn arround Time is"+((float)total_time/(float)nop));
  System.out.println("----------------------------------------------------------------------------------------");
  System.out.println("Processno\tarrivaltime\tcompletiontime\tTurn_arround_time\tWaitingTime");
  System.out.println("----------------------------------------------------------------------------------------");
  int sumTAT=0;  
  int sumWaitTime=0;
  for(int i=1;i<=nop;i++)
  {
    
    System.out.print(" P"+i+"\t");
    System.out.print("\t"+(i-1)+"\t");
    System.out.print("\t"+completion_time[i]+"\t");
    System.out.print("\t"+(completion_time[i]-(i-1))+"\t");
    System.out.print("\t\t"+((completion_time[i]-(i-1))-(btarray[i-1]))+"\t");
    sumTAT+=(completion_time[i]-(i-1));
    sumWaitTime+=((completion_time[i]-(i-1))-(btarray[i-1]));
    System.out.println();
  }
  System.out.println("----------------------------------------------------------------------------------------");
  System.out.println("The Avg Turn_arround_Time is given by "+((float)sumTAT/(float)nop));
  System.out.println("The Avg WaitingTime is given by "+((float)sumWaitTime/(float)nop));
  
}
}
  
