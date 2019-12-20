#!/bin/bash

#/usr/local/Cellar/apache-spark/2.4.4/bin/run-example SparkPi

/usr/local/Cellar/apache-spark/2.4.4/bin/spark-submit \
  --class 'org.apache.spark.examples.SparkPi' \
  --master local[*] \
  /usr/local/Cellar/apache-spark/2.4.4/libexec/examples/jars/spark-examples_2.11-2.4.4.jar \
  100
