package moban;

public abstract class GeneralType implements QuestType {

    @Override
    public boolean isAccept(int questId) {
        return false;
    }

    //通用接任务逻辑
    @Override
    public void acceptQuest(int questId) {
        if (isAccept(questId)) {
            before(questId);
            System.out.println("任务可接");
            after(questId);
        } else {
            System.out.println("任务不可接");
        }
    }

    /**
     * 接任务之前, 可供子类实现
     * @param questId
     */
    protected void before (int questId) {

    }

    /**
     * 接任务之后, 可供子类实现
     * @param questId
     */
    protected void after (int questId) {

    }

}
