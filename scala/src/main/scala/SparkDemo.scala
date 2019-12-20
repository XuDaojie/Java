import org.apache.spark.sql.SparkSession

object SparkDemo {
    def main(args: Array[String]): Unit = {
        // Hello World!
//        val spark = SparkSession.builder.appName("SparkDemo").getOrCreate()
//        val textFile = spark.read.textFile("/usr/local/Cellar/apache-spark/2.4.4/README.md")
//        println(s"count: ${textFile.count()}")
//        spark.stop()

        val logFile = "/usr/local/Cellar/apache-spark/2.4.4/README.md" // Should be some file on your system
        val spark = SparkSession.builder.appName("SparkDemo").getOrCreate()
//        val logData = spark.read.textFile(logFile).cache()
        val logData = spark.read.textFile(logFile)
        logData.foreach(println)

        //        val numAs = logData.filter(line => line.contains("a")).count()
//        val numBs = logData.filter(line => line.contains("b")).count()
//        println(s"Lines with a: $numAs, Lines with b: $numBs")
        spark.stop()

    }
}
