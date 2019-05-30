%{
  #include<stdio.h>
  int pc=0,nc=0;
  
%}

%%
[\+]?[0-9]+	{ pc++; }
[\-][0-9]+	{ nc++; }
%%
 main(int argc,char* argv[])
 {
  if(argc!=2)
  {
    printf("File name missing\n");
    exit(0);
  }
  yyin=fopen(argv[1],"r");
  yylex();
  printf("The no of positive no=%d\n",pc);
  printf("The no of negative no=%d\n",nc);
 }

