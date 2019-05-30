%{
  #include<stdio.h>
  int count=0;
  char a;
%}

%%
[a|e|i|o|u|A|E|I|O|U]   { count++; }
%%
 main()
 {
  printf("Enter the String\n");
  yylex();
  printf("The no of a=%d",count);
 }


