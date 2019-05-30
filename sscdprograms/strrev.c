#include<stdio.h>
void main()
{
 int i=0,j,t;
 char s[100],r[100];
 printf("Enter the string \n");
 scanf("%s",s);
 printf("%s\n",s);
while(s[i]!='\0')
 {
  i++;
  
 }
 t=0;
 for(j=i-1;j>=0;j--)
 {
   r[t]=s[j];
   t++;
 }
 printf("The reversed string is %s \n",r);

 }
