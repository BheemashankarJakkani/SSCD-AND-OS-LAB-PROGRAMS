%{
#include<stdio.h>
#include<stdlib.h>
%}
%token num;
%left '+''-'
%left '*''/'

%%
input:exp{printf("%d\n",$$);exit(0);}

exp:exp'+'exp{$$=$1+$3;}
    |exp'-'exp{$$=$1-$3;}
    |exp'*'exp{$$=$1*$3;}
    |exp'/'exp{if($3==0) 
                 { printf("devide by Zero error\n");}
                else 
                   $$=$1/$3;
                }
    |'('exp')'{$$=$2;}
    |num {$$=$1;};
%%
int yyerror()
{
 printf("error");
 exit(0);
}

int main()
{
 printf("Enter an Expression\n");
 yyparse();
}
