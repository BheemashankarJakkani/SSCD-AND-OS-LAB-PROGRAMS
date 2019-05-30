#include<stdio.h>
#include<string.h>
#include<ctype.h>
void main()
{ 
 int j=0,i;
 char c[5000];
 FILE *fpointer;
 fpointer=fopen("read.txt","r");
 while(fgets(c,5000,fpointer)!=NULL)
 {
   i=0;
   while(c[i]!='\0')
   {
    if(c[i]=='/')
    {
     i++;
     if(c[i]=='/')
     {
       j++;
       break;
     }
    }
    i++;
   }
 
 }
 printf("The no of comment line are %d ",j); 
}
 
