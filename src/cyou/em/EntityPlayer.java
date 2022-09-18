package cyou.em;

import java.util.HashMap;

/**
 * 承载组件的实体
 */
public class EntityPlayer {

    //组件列表
    private HashMap<String, ICompoment> compomentMap = new HashMap<>();

    //添加组件
    public void addCompoment(String key, ICompoment compoment) {
        compomentMap.put(key, compoment);
    }

    //查看内容
    public void lookMap () {
        compomentMap.forEach((k, v) -> System.out.println(k + "--" + v.getComData()));
    }

    public int compsCout () {
        return compomentMap.size();
    }

}
