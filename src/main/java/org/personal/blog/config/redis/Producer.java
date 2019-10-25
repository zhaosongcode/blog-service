package org.personal.blog.config.redis;

import org.personal.blog.util.number.NumberTools;
import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;

/**
 * Created by zs on 2019/8/13
 * redis消息生产者
 */
public class Producer extends Thread {

    public static final String MESSAGE_KEY = "message:queue";
    private Jedis jedis;
    private String producerName;
    private volatile int count;

    public Producer(String name) {
        this.producerName = name;
        init();
    }
    private void init() {
        jedis = MyJedisFactory.getJedis();
    }
    public void putMessage(String message) {
        Long size = jedis.lpush(MESSAGE_KEY, message);
        System.out.println(producerName + ": 当前未被处理消息条数为:" + size);
        count++;
    }
    public int getCount() {
        return count;
    }
    @Override
    public void run() {
        try {
            while (true) {
                putMessage(NumberTools.get32UUID());
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws InterruptedException{
        Producer producer = new Producer("myProducer");
        producer.start();
        for(; ;) {
            System.out.println("main : 已存储消息条数:" + producer.getCount());
            TimeUnit.SECONDS.sleep(10);
        }
    }
}
