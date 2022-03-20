package shf2;

import org.junit.Test;

import java.util.Random;

public class Hello {
    /**
     * java.lang.OutOfMemoryError: Java heap space
     */
    @Test
    public void test() {
        String str = "dfsfsdgsdf";
        while (true){
            str+= str+new Random().nextInt(88888888)+new Random().nextInt(99999999);
        }
    }


    /**
     * 轻GC
     * [GC (Allocation Failure) [PSYoungGen: 1536K->488K(2048K)] 1536K->732K(7680K), 0.0016191 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * [GC (Allocation Failure) [PSYoungGen: 2024K->488K(2048K)] 2268K->979K(7680K), 0.0011965 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * [GC (Allocation Failure) [PSYoungGen: 2024K->504K(2048K)] 2515K->1283K(7680K), 0.0006218 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * [GC (Allocation Failure) [PSYoungGen: 2040K->504K(2048K)] 2819K->1584K(7680K), 0.0006093 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * [GC (Allocation Failure) [PSYoungGen: 2027K->504K(2048K)] 3108K->1953K(7680K), 0.0009564 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * [GC (Allocation Failure) [PSYoungGen: 1988K->504K(2048K)] 3438K->2609K(7680K), 0.0006861 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * [GC (Allocation Failure) [PSYoungGen: 1781K->352K(2048K)] 3887K->3721K(7680K), 0.0011050 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * [GC (Allocation Failure) [PSYoungGen: 1213K->192K(2048K)] 5415K->4929K(7680K), 0.0012208 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     *
     * 重GC
     * [Full GC (Ergonomics) [PSYoungGen: 192K->0K(2048K)] [ParOldGen: 4737K->2224K(5632K)] 4929K->2224K(7680K), [Metaspace: 5236K->5236K(1056768K)], 0.0065053 secs] [Times: user=0.17 sys=0.00, real=0.01 secs]
     *
     * 轻GC
     * [GC (Allocation Failure) [PSYoungGen: 862K->32K(2048K)] 5582K->5584K(7680K), 0.0009448 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     *
     * 重GC
     * [Full GC (Ergonomics) [PSYoungGen: 32K->0K(2048K)] [ParOldGen: 5552K->2640K(5632K)] 5584K->2640K(7680K), [Metaspace: 5236K->5236K(1056768K)], 0.0047977 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
     *
     * 轻GC
     * [GC (Allocation Failure) [PSYoungGen: 61K->0K(2048K)] 4365K->4303K(7680K), 0.0003720 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * [GC (Allocation Failure) [PSYoungGen: 0K->0K(2048K)] 4303K->4303K(7680K), 0.0003000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     *
     * 重GC
     * [Full GC (Allocation Failure) [PSYoungGen: 0K->0K(2048K)] [ParOldGen: 4303K->3468K(5632K)] 4303K->3468K(7680K), [Metaspace: 5236K->5236K(1056768K)], 0.0074437 secs] [Times: user=0.11 sys=0.02, real=0.01 secs]
     * [GC (Allocation Failure) [PSYoungGen: 0K->0K(2048K)] 3468K->3468K(7680K), 0.0004733 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     *
     * [Full GC (Allocation Failure) [PSYoungGen: 0K->0K(2048K)] [ParOldGen: 3468K->3411K(5632K)] 3468K->3411K(7680K), [Metaspace: 5236K->5233K(1056768K)], 0.0072392 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
     *
     * java.lang.OutOfMemoryError: Java heap space
     *
     * 	at java.util.Arrays.copyOf(Arrays.java:3332)
     * 	at java.lang.AbstractStringBuilder.ensureCapacityInternal(AbstractStringBuilder.java:124)
     * 	at java.lang.AbstractStringBuilder.append(AbstractStringBuilder.java:674)
     * 	at java.lang.StringBuilder.append(StringBuilder.java:214)
     * 	at shf2.Hello.test(Hello.java:15)
     * 	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
     * 	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
     * 	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
     * 	at java.lang.reflect.Method.invoke(Method.java:498)
     * 	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:59)
     * 	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
     * 	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:56)
     * 	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
     * 	at org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)
     * 	at org.junit.runners.BlockJUnit4ClassRunner$1.evaluate(BlockJUnit4ClassRunner.java:100)
     * 	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:366)
     * 	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:103)
     * 	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:63)
     * 	at org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)
     * 	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)
     * 	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)
     * 	at org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)
     * 	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)
     * 	at org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)
     * 	at org.junit.runners.ParentRunner.run(ParentRunner.java:413)
     * 	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
     * 	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:69)
     * 	at com.intellij.rt.junit.IdeaTestRunner$Repeater$1.execute(IdeaTestRunner.java:38)
     * 	at com.intellij.rt.execution.junit.TestsRepeater.repeat(TestsRepeater.java:11)
     * 	at com.intellij.rt.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:35)
     * 	at com.intellij.rt.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:235)
     * 	at com.intellij.rt.junit.JUnitStarter.main(JUnitStarter.java:54)
     *
     * Heap
     *  PSYoungGen      total 2048K, used 466K [0x00000000ffd80000, 0x0000000100000000, 0x0000000100000000)
     *   eden space 1536K, 30% used [0x00000000ffd80000,0x00000000ffdf4838,0x00000000fff00000)
     *   from space 512K, 0% used [0x00000000fff80000,0x00000000fff80000,0x0000000100000000)
     *   to   space 512K, 0% used [0x00000000fff00000,0x00000000fff00000,0x00000000fff80000)
     *  ParOldGen       total 5632K, used 3411K [0x00000000ff800000, 0x00000000ffd80000, 0x00000000ffd80000)
     *   object space 5632K, 60% used [0x00000000ff800000,0x00000000ffb54d68,0x00000000ffd80000)
     *  Metaspace       used 5320K, capacity 5466K, committed 5504K, reserved 1056768K
     *   class space    used 616K, capacity 626K, committed 640K, reserved 1048576K
     */
}
