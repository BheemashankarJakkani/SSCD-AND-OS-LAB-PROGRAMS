%{
  #include<stdio.h>
  #include "y.tab.h"
  extern yylval;
%}
%%

"a" {return A;}
"b" {return B;}
%%
