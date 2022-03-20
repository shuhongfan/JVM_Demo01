package shf2;

public class Demo05 {
}

/**
 * JMM
 * 1.什么是JVM？
 *  JMM： Java内存模型(Java Memory Model,JMM)
 *
 *  2.它是干嘛的？
 *  作用： 缓存一致性协议，用于定义数据读写的规则
 *  JMM定义了线程工作内存和主内存之间的抽象关系：线程之间的共享变量存储在主内存（Main Memory）中，
 *  每个线程都有一个私有的本地内存（Local Memory）
 *
 *  线程工作内存，每个线程都有自己的工作区域，都是从主内存拷贝的
 *  解决共享对象可见性这个问题： volilate
 *
 *
 */
