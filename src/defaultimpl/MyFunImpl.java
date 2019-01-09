package defaultimpl;

/**
 * 实现的两个接口都有getName, 这时候需要制定实现哪一个
 */
public class MyFunImpl implements MyFun1, MyFun2 {

    @Override
    public String getName() {
        return MyFun2.super.getName();
    }

    @Override
    public int getAge() {
        return MyFun1.super.getAge();
    }
}
