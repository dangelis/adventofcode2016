#!/usr/bin/python

import sys

# Open a file
input = open(sys.argv[1], "r+")

tri_count = 1
tri_array = []
valid_tri_count = 0;
for line in input:
    tri_array.append(line)
    if tri_count % 3 == 0:
        r1c1 = tri_array[0][:5].strip()
        r1c2 = tri_array[0][5:10].strip()
        r1c3 = tri_array[0][10:15].strip()
        r2c1 = tri_array[1][:5].strip()
        r2c2 = tri_array[1][5:10].strip()
        r2c3 = tri_array[1][10:15].strip()
        r3c1 = tri_array[2][:5].strip()
        r3c2 = tri_array[2][5:10].strip()
        r3c3 = tri_array[2][10:15].strip()


        if int(r1c1) + int(r2c1) > int(r3c1) and int(r1c1) + int(r3c1) > int(r2c1) and int(r2c1) + int(r3c1) > int(r1c1):
            valid_tri_count += 1
        if int(r1c2) + int(r2c2) > int(r3c2) and int(r1c2) + int(r3c2) > int(r2c2) and int(r2c2) + int(r3c2) > int(r1c2):
            valid_tri_count += 1
        if int(r1c3) + int(r2c3) > int(r3c3) and int(r1c3) + int(r3c3) > int(r2c3) and int(r2c3) + int(r3c3) > int(r1c3):
            valid_tri_count += 1

        tri_array = []
        tri_count = 0

    tri_count += 1    

# Close opend file
input.close()

print "Valid triangles = {}".format(valid_tri_count)
#1544 
