%{
 #include<stdio.h>
 #include<stdlib.h>
%}
%token num;
%left '+''-'
%left '*''/'

%%
input:exp{printf("The Solution is :%d\n",$$);exit(0);}

exp:exp'+'exp{$$=$1+$3;}
    |exp'-'exp{$$=$1-$3;}
    |exp'*'exp{$$=$1*$3;}
    |exp'/'exp{if($3==0)
               { printf("Divide by zero Error");}
               else
                 $$=$1/$3;
                }
    |'('exp')' {$$=$2;}
    |num {$$=$1;};

%%

int yyerror()
{ 
 printf("error");
 exit(0);
 
}
int main()
{
 printf("Enter the Expression ");
 yyparse();
}


