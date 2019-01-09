package moban;

public class MainTest {

    public static void main(String[] args) {
        JiuGongBaGuaType jiuGongBaGuaType = new JiuGongBaGuaType();
        jiuGongBaGuaType.acceptQuest(1);
        System.out.println("===============");
        XunXianWenDaoType xunXianWenDaoType = new XunXianWenDaoType();
        xunXianWenDaoType.acceptQuest(1);
    }
}
