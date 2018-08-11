#!/bin/python
import os;
import sys;

def write_file(where, is_dir, length):
  out = "|"
  for _ in range(0, length):
    out += "  |"
  out += "--"
  if is_dir: out += "/"
  out += where
  print(out)

def walk_dir(directory, length):
  hdirs = list()
  execs = list()
  for f in os.listdir(directory):
    if os.path.isdir(os.path.join(directory, f)):
      if f[0] == '.':
        hdirs.append(f)
      else:
        write_file(f, True, length)
        walk_dir(os.path.join(directory, f), length + 1)       
    else:
      execs.append(f)
  [write_file(x + " (content hidden)", True, length) for x in hdirs]
  [write_file(x, False, length) for x in execs]

where = os.getcwd() if len(sys.argv) == 1 else sys.argv[1]
if os.path.isdir(where):
  print(where)
  walk_dir(where, 0)
else:
  print(f"{where} is not a valid directory.")
