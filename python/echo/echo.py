#!/bin/python
import sys;

out = ""
for x in range(1, len(sys.argv)):
  out += sys.argv[x]
  if x + 1 < len(sys.argv):
      out += " "
print(out)
