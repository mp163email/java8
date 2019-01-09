package defaultimpl;

/**
 * 接口的默认实现
 */
public interface MyFun2 {

    default String getName() {
        return "呵呵";
    }

    default int getAge() {
        return 20;
    }
}
