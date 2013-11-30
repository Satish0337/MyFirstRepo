#nclude<stdio.h>

int main(){

char a[10];
char *p;
int count=0;
printf("Enter The String\n");
scanf("%s",&a);
p=&a;
while(*p!='\0'){
++count;
++p;
}
printf("%d",count);




return 0;
}