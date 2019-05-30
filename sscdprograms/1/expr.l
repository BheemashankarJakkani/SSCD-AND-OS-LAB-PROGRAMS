%{
 #include<stdio.h>
 #include<stdlib.h>
 int v=0,op=0,id=0;
%}
%%
[0-9]|[a-z]|[A-Z]+ {id++;printf("\nIdentifier:");ECHO;}
[+|*]       {op++;printf("\nOperator: ");ECHO;}
"(" {v++;}
")" {v--;}
%%
void main()
{
 printf("Enter the Expression\n");
 yylex();
 if(v==0 && (op+1)==id)
 {
   printf("\nValid");
   printf("\nid=%d ,op=%d ",id,op);
 }
 else{ 
 
  printf("\nInvalid");
  printf("\nid=%d ,op=%d ",id,op);

 }
} 
