package defaultimpl;

/**
 * 接口的默认实现, default关键字
 * 接口中可以有静态方法
 */
public interface MyFun1 {

    default String getName () {
        return "哈哈哈";
    }

    default int getAge () {
        return 10;
    }

    static void sayHello () {
        System.out.println("Hello");
    }
}
