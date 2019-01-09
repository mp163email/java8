package moban;

public class XunXianWenDaoType extends GeneralType {

    @Override
    public boolean isAccept(int questId) {
        return false;
    }

    @Override
    protected void before(int questId) {
        super.before(questId);
    }

    @Override
    protected void after(int questId) {
        super.after(questId);
    }
}
