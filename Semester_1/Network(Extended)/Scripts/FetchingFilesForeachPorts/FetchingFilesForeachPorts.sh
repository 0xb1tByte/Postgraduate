#!/bin/bash
for ports in 4001 4002 4003 4004 4005 4006 4007 4008 4009 4010
do
	for files in 1MByte 4MByte 8MByte 16MByte 32MByte
	do
    		curl -v -4 -o /dev/null http://www.site.com:$ports/$files
	done
done
