package com.cwp

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  *
  * @author : 蔡文平
  * @date : 2019/12/09 12:40
  * @description :
  */
object KafkaReceiverWordCount {
  def main(args: Array[String]): Unit = {
    if(args.length != 4) {
      System.err.println("Usage: KafkaReceiverWordCount <zkQuorum> <group> <topics> <numThreads>")
    }
    val Array(zkQuorum, group, topics, numThreads) = args
    val conf: SparkConf = new SparkConf().setAppName("cwp_kafka_receiver").setMaster("local[2]")
    val ssc: StreamingContext = new StreamingContext(conf, Seconds(5))
    val topicMap: Map[String, Int] = topics.split(",").map((_, numThreads.toInt)).toMap
    // TODO... Spark Streaming如何对接Kafka
    val messages: ReceiverInputDStream[(String, String)] = KafkaUtils.createStream(ssc, zkQuorum, group,topicMap)
    // TODO... 自己去测试为什么要取第二个
    messages.map(_._2).flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_).print()
    ssc.start()
    ssc.awaitTermination()
  }
}
