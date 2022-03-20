package shf1;

/**
 * 双亲委派机制：安全
 * 1. APP--》EXC---》BOOT（最终执行）
 *
 * 1.类加载器收到类加载的请求 Application
 * 2.将这个请求向上委托给父类加载器去完成，一直向上委托，知道启动类加载器  BOOT
 * 3.启动加载器检查是否能够加载当前的这个类，能加载就结束，使用当前的加载器，否则，抛出异常，通知子加载器进行加载
 */
public class String {
    @Override
    public java.lang.String toString(){
        return "Hello";
    }

    public static void main(String[] args) {
        String string = new String();
        string.toString();
    }
}
