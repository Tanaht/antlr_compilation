#!/bin/sh

# run.sh: runs a compiled parser generated with ANTLR
# exemple: ./run.sh TP1 < tests/test1.ttl

# Tests if the user has given an argument
if [ $# -lt 2 ]
then
  echo "run.sh - runs a compiled parser generated with ANTLR"
  echo "syntax: ./run.sh <parser file (without .class)> [ <params> ]"
  exit 1
fi

# Tests if the ANTLR file is readable
ANTLR_JAR=../antlr-3.5.2-complete.jar
if [ ! -r $ANTLR_JAR ]
then
  echo "error: could not read ANTLR Jar file: $ANTLR_JAR"
  echo "check if file exists and is readable"
  exit 2
fi

export CLASSPATH=.:../antlr-3.5.2-complete.jar

java $* < $2


