#include<stdio.h>
void main()
{
 int i=0;
 char s[100];
 printf("Enter the string \n");
 scanf("%s",s);
 printf("%s\n",s);
while(s[i]!='\0')
 {
  i++;
  
 }
 printf("The length of the String is %d \n",i);

 }
