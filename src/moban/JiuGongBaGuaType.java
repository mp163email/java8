package moban;

public class JiuGongBaGuaType extends GeneralType {
    @Override
    public boolean isAccept(int questId) {
        System.out.println("九宫八卦任务是否可接");
        return true;
    }

    @Override
    protected void before(int questId) {
        System.out.println("九宫八卦接任务之前");
    }

    @Override
    protected void after(int questId) {
        System.out.println("九宫八卦接任务之后");
    }
}
