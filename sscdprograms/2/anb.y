%{
 #include<stdio.h>
 #include<stdlib.h>
 int count=0;
%}
%token A B
%%
S: X B 
X: A X {count++;}
|;
%%

int yyerror()
{
 printf("Error");
 exit(0);
}
int main()
{
 int n;
 printf("Enter the no of a");
 scanf("%d",&n);
 printf("Enter the Expression ");
 yyparse();
 if(count==n)
 {
  printf("A:%d\tn:%d\n",count,n);
  printf("valid\n");
 }
 else{
  printf("A:%d\tn:%d\n",count,n);
  printf("Invalid\n");
 }
 return 0;
 }
