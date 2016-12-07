#!/usr/bin/python

import sys

# Open a file
input = open(sys.argv[1], "r+")

valid_tri_count = 0;
for line in input:
    #print line
    s1 = line[:5].strip()
    s2 = line[5:10].strip()
    s3 = line[10:15].strip()
    if int(s1) + int(s2) > int(s3) and int(s1) + int(s3) > int(s2) and int(s2) + int(s3) > int(s1):
        valid_tri_count += 1

# Close opend file
input.close()

print "Valid triangles = {}".format(valid_tri_count)
# 869 - first answer

