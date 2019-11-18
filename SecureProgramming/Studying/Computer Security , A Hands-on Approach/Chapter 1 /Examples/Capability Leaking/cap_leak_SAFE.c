#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>

void main() 
{
int fd;
char *v[2];
/* 
- Assume that /etc/zzz is an important system file and it is owned by root with permission 0644
- Before running this program m you must  create the file /etc/zzz first 
*/
fd = open("/etc/zzz",O_RDWR | O_APPEND);
if( fd == -1)
{
// print out the file descriptor value
printf("Cannot open /etc/zzz\n");
exit(0);
} // end if 

printf("fd is %d\n",fd);
// this line is to fix the Capability Leaking by closing the file descriptor
close(fd);
// permanently disable the privilege by making the effective uid the same as the real id
setuid(getuid());
// execute the /bin/sh
v[0] = "/bin/sh";
v[1] = 0;
execve(v[0],v,0);
} // end main
