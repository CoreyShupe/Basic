#!/usr/bin/env bash

output() {
  printf "|"
  for((i = 0; i < $1; i++)) {
    printf "  |"  
  }
  printf -- "--"
  if $2 == true ;
  then
    printf "/"
  fi
  echo "$3"
}

rundir() {
  if [[ "$1" == */ ]]
  then
    local FOUND=$1
  else
    local FOUND="$1/"
  fi
  for d in $(find $FOUND* -maxdepth 0 -type d)
  do
    output $2 true "$(basename $d)"
    rundir $d $(($2 + 1))
  done
  for h in $(find $FOUND.* -maxdepth 0 -type d)
  do
    local BNAME=$(basename $h)
    if [[ "$BNAME" =~ [A-Za-z0-9] ]]
    then
      output $2 true "$BNAME (content hidden)"
    fi
  done
  for f in $(find $FOUND* -maxdepth 0 -type f)
  do
    output $2 false "$(basename $f)"
  done
}

if [ -n "$1" ]
then
  BASE=$1
else
  BASE=$PWD
fi

if [ -d $BASE ]
then
  rundir $BASE 0
else
  echo "$BASE is not a valid directory."
fi
