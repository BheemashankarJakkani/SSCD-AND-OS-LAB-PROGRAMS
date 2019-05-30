#include<stdio.h>
#include<string.h>
#include<stdlib.h>

char st[60];
char a[30];
int len,i=0,top=-1;
void check(){

	int j=top;
	if(st[j]=='T' && st[j-1]=='+' && st[j-2]=='E')
	{
		if(a[i+1]=='*')
		{
			printf("%s\t%s\t Don't reduce T+E to E\n",st,a);
			return;
		}


		else{
			st[j]=' ';
			st[j-1]=' ';
			top=top-2;
			j=top;
			st[j]='E';
			printf("%s\t%s\t reduced E+T to E \n",st,a);
			check();

		}
	}
		if(st[j]=='T')
		{
		st[j]='E';
		printf("%s\t%s\t reduced T to E \n",st,a);
		check();
		}

		if(st[j]=='F' && st[j-1]=='*' && st[j-2]=='T')
		{
			st[j]=' ';
			st[j-1]=' ';
			top=top-2;
			j=top;
			st[j]='T';
			printf("%s\t%s\t reduced T*F to T \n",st,a);
			check();
		}

		if(st[j]=='F')
		{
		st[j]='T';
		printf("%s\t%s\t reduced F to T \n",st,a);
		check();
		}

		if(st[j]=='(' && st[j-1]=='E' && st[j-2]==')')
		{
			st[j]=' ';
			st[j-1]=' ';
			top=top-2;
			j=top;
			st[j]='F';
			printf("%s\t%s\t reduced id to F \n",st,a);
			check();


	}
	if(st[j]=='d' && st[j-1] == 'i'){
		st[j]=' ';
		st[j-1]='F';
		top--;
		j=top;
		printf("%s\t%s\t Reduce id to F\n",st,a);
		check();
	}
		return;
}
void main()
{
printf("enter an expression\n");
//gets(a);
scanf("%s",a);
len=strlen(a);
printf("Stack \t  Expression\t Action\n");
for(i=0;i<len;i++)
{
	if(a[i]=='i' && a[i+1]=='d')
        {
		st[++top]='i';
		st[++top]='d';
		a[i]=' ';
		a[i+1]=' ';
		i++;
	        printf("%s\t %s\t Shift \n ",st,a);
		check();
		//continue;
	}
	else
  {
	st[++top]=a[i];
	a[i]=' ';
	printf("%s\t %s\t Shift \n ",st,a);
	check();
	}
}
//return;
}
