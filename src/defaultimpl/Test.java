package defaultimpl;

public class Test {
    public static void main(String[] args) {
        MyFunImpl myFun = new MyFunImpl();
        System.out.println(myFun.getName());
        System.out.println(myFun.getAge());

        System.out.println("============");
        //类优先原则
        MyFunImpl2 myFunImpl2 = new MyFunImpl2();
        System.out.println(myFunImpl2.getName());
    }
}
