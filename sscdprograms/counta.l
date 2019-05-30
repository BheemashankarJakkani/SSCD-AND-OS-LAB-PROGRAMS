%{
  #include<stdio.h>
  int count=0;
  char a;
%}

%%
[a]	{ count++; }
%%
 main()
 {
  printf("Enter the String\n");
  yylex();
  printf("The no of a=%d",count);
 }

