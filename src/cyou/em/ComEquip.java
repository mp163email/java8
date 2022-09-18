package cyou.em;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 组件二：装备组件
 */
public class ComEquip implements  ICompoment{

    public ComEquip (String equipData) {
        this.equipData = equipData;
    }

    @Getter
    @Setter
    private String equipData;

    @Override
    public String getComData() {
        return equipData;
    }
}
