#include<stdio.h>
void main()
{
 int i=0,j=0;
 char s[100],t[100];
 printf("Enter the string1 \n");
 scanf("%s",s);
 printf("Enter the string2 \n");
 scanf("%s",t);
 printf("%s\n",s);
 printf("%s\n",t);
while(s[i]!='\0')
 {
  i++;
  
 }
 while(t[j]!='\0')
 {
  s[i]=t[j];
  i++;
  j++;
 }
 
printf("The cancatinated string is %s \n",s);
}


