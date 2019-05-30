%{	
  #include<stdio.h>
  int sl=0;int ml=0;
%}

%%
"/*"[^*/]*"*/"  {ml++;}
"//".* {sl++;}
%%

main(int argc,char *argv[])
{
 
  yyin=fopen("text.c","r");
  yyout=fopen("output.c","w");
  yylex();
  fclose(yyin);
  fclose(yyout);
  printf("\n No of Single line comments are= %d",sl);  
  printf("\n No of Multiline comments are = %d",ml);
   
}  

