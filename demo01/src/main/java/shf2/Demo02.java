package shf2;

import org.junit.Test;
import shf1.String;

public class Demo02 {
    @Test
    public void test1() {
//        返回虚拟机视图使用的最大内存
        long max = Runtime.getRuntime().maxMemory();
//        返回初始化jvm的总内存
        long total = Runtime.getRuntime().totalMemory();

        System.out.println("max="+max+"字节\t"+(max/(double)1024/1024)+"MB");
        System.out.println("total="+max+"字节\t"+(total/(double)1024/1024)+"MB");

        /**
         * 默认
         * max=3733979136字节	3561.0MB   1/4  最大
         * total=3733979136字节	241.5MB    1/64  初始化
         *
         * OOM:  java内存溢出
         * 1.尝试扩大堆内存
         * 2.分析内存，看一下哪个地方出现了问题
         *      能够看到第几行出错，内存快照分析工具，MAT，JProfiler
         *      Dubug，一行行分析代码！
         *
         *      MAT、Jprofiler作用
         *       分析Dump内存文件，快速定位内存泄露
         *       获得堆中的数据
         *       获得大的对象~
         *
         *
         * max=1029177344字节	981.5MB
         * total=1029177344字节	981.5MB
         *
         * Heap
         *  PSYoungGen      total 305664K, used 36700K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
         *   eden space 262144K, 14% used [0x00000000eab00000,0x00000000eced7108,0x00000000fab00000)
         *   from space 43520K, 0% used [0x00000000fd580000,0x00000000fd580000,0x0000000100000000)
         *   to   space 43520K, 0% used [0x00000000fab00000,0x00000000fab00000,0x00000000fd580000)
         *  ParOldGen       total 699392K, used 0K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
         *   object space 699392K, 0% used [0x00000000c0000000,0x00000000c0000000,0x00000000eab00000)
         *  Metaspace       used 5248K, capacity 5344K, committed 5504K, reserved 1056768K
         *   class space    used 609K, capacity 627K, committed 640K, reserved 1048576K
         *
         *   305664K+699392K=1005056k=981.5m
         *   元空间逻辑上存在，物理上不存在
         */
    }
}
