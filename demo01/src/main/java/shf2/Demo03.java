package shf2;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Out Of Memory
 * -ea -Xms1m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError
 *
 * -Xms 设置初始化内存分配大小  1/64
 * -Xmx 设置最大分配内存 默认 1/4
 * -XX:+PrintGCDetails
 * -XX:+HeapDumpOnOutOfMemoryError  OOM DUMP
 *
 */
public class Demo03 {
    byte[] array = new byte[1 * 1024 * 1024]; //1m

    public static void main(String[] args) {
        ArrayList<Demo03> list = new ArrayList<>();
        int count = 0;

        try {
            while (true){
                list.add(new Demo03());
                count=count+1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}
