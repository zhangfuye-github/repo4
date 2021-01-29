package com.tensquare.test;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * @Auther: 张夫业
 * @Date: 2021/1/27
 * @Description:
 */
public class MongoDemo {
    public static void main(String[] args) {
        //创建连接
        MongoClient mongoClient=new MongoClient("192.168.43.128");
        //打开数据库
        MongoDatabase spitdb = mongoClient.getDatabase("spitdb");
        //获取集合
        MongoCollection<Document> spit = spitdb.getCollection("spit");
        //查询获取文档集合
        FindIterable<Document> documents = spit.find();
        for (Document document : documents) {
            System.out.println(document);
        }
    }
}
