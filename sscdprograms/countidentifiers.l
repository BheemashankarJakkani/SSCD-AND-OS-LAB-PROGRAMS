%{
  #include<stdio.h>
  int id=0;
 
%}

%%
[0-9]+  ;
^[a-z|A-Z][0-9|a-z|A-Z]*	{id++;}
%%
 main()
 {
  printf("Enter the String\n");
  yylex();
  printf("The no of identifires=%d",id);
 }


