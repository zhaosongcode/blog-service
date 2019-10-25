package org.personal.blog.config.redis;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by zs on 2019/8/13
 * 消费者
 */
public class Customer extends Thread {

    private String customerName;
    private volatile int count;
    private Jedis jedis;
    public Customer(String name) {
        this.customerName = name;
        init();
    }
    private void init() {
        jedis = MyJedisFactory.getJedis();
    }
    public void processMessage() {
        List<String> messages = jedis.brpop(0, Producer.MESSAGE_KEY, "testKey");
        if(messages.size() != 0) {
            //由于该指令可以监听多个Key,所以返回的是一个列表
            // 列表由2项组成，1) 列表名，2)数据
            String keyName = messages.get(0);
            //如果返回的是MESSAGE_KEY的消息
            if(Producer.MESSAGE_KEY.equals(keyName)) {
                String message = messages.get(1);
                handle(message);
            }
        }
        System.out.println("=======================");
    }
    public void handle(String message) {
        System.out.println(customerName + " 正在处理消息,消息内容是: " + message + " 这是第" + count + "条");
    }
    @Override
    public void run() {
        while (true) {
            processMessage();
        }
    }
    public static void main(String[] args) {
        Customer customer = new Customer("yamikaze");
        customer.start();
    }
}
