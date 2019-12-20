#!/bin/bash

#  /Users/xdj/IdeaProjects/Java/scala/build/libs/scala.jar
#/usr/local/Cellar/apache-spark/2.4.4/bin/spark-submit \
#  --class "SparkDemo" \
#  --master local[4] \
#  scala/build/libs/scala.jar

# 编译
./gradlew :scala:build

#/usr/local/Cellar/apache-spark/2.4.4/bin/spark-submit \
#  --class "SparkDemo" \
#  --master local[4] \
#  --conf spark.driver.extraJavaOptions=-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=5005 \
#  scala/build/libs/scala.jar

/usr/local/Cellar/apache-spark/2.4.4/bin/spark-submit \
  --class "SparkDemo" \
  --master local[4] \
  scala/build/libs/scala.jar

