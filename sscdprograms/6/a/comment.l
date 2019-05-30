/* hello hello*/
%{	
  #include<stdio.h>
  int sl=0;int ml=0;
%}

%%
"/*"[a-zA-Z0-9' '\t\n]+"*/" {ml++;}
"//".* {sl++;}
%%

main(int argc,char *argv[])
{
 
  yyin=fopen(argv[1],"r");
  yyout=fopen(argv[2],"w");
  yylex();
  fclose(yyin);
  fclose(yyout);
  printf("\n No of Single line comments are= %d",sl);  
  printf("\n No of Multiline comments are = %d",ml);
   
}  

