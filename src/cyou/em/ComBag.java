package cyou.em;

import lombok.Getter;
import lombok.Setter;

/**
 * 组件一：背包组件
 */
public class ComBag implements ICompoment{

    public ComBag (String bagData) {
        this.bagData = bagData;
    }

    @Getter
    @Setter
    private String bagData;

    public void setBagData (String bagData) {
        this.bagData = bagData;
    }

    @Override
    public String getComData() {
        return bagData;
    }
}
