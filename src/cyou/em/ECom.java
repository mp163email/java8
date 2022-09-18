package cyou.em;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 枚举-通过枚举来构建组件
 */
public enum ECom {

    PLayerBag("PLayerBag", contains -> new ComBag(contains.get(ICompoment.KEY_COM_BAG))),
    PlayerEquip("PlayerEquip", contains -> new ComEquip(contains.get(ICompoment.KEY_COM_EQUIP)));

    static Map<String, ECom> map;

    static {
        map = Arrays.stream(ECom.values()).collect(Collectors.toMap(x -> x.getName(), x -> x));
    }

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Function<Contains<String, String>, ICompoment> function;

     ECom(String name, Function<Contains<String, String>, ICompoment> function) {
        this.name = name;
        this.function = function;
    }

    public static ECom of (String eName) {
        return Optional.ofNullable(map.get(eName)).orElse(null);
    }
}
