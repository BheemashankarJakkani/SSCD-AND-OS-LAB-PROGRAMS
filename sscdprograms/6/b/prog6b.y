%{
#include<stdio.h>
#include<stdlib.h>
int id=0,dig=0,key=0,op=0;
%}
%token DIGIT ID KEY OP
%%
input : DIGIT input {dig++;}
	|ID input {id++;}
	|KEY input {key++;}
	|OP input {op++;}
	|DIGIT {dig++;}
	|ID {id++;}
	|KEY {key++;}
	|OP {op++;}
%%

//extern int yylex();
//extern int yyparse();
extern FILE* yyin;

void main(){
	FILE* myfile = fopen("text.c","r");
	if(!myfile){
		printf("Can't open file\n");
		exit(0);
	}
	yyin = myfile;
	do{
		yyparse();
	}while(!feof(yyin));
	printf("numbers = %d\nkeywords=%d\nIdentifiers=%d\noperator=%d\n",dig,key,id,op);
}

int yyerror(){
	printf("EER,parse error! Message:\n");
	return -1;
}
