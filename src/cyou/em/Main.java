package cyou.em;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Contains<String, String> contains = new Contains<>();
        contains.put(ICompoment.KEY_COM_BAG, "BAG_DATA").put(ICompoment.KEY_COM_EQUIP, "EEQUIP_DATA");

        //通过枚举，给Entity组装组件
        EntityPlayer entityPlayer = new EntityPlayer();
        Arrays.stream(ECom.values()).forEach(x -> entityPlayer.addCompoment(x.getName(), x.getFunction().apply(contains)));

        System.out.println(entityPlayer.compsCout());
        entityPlayer.lookMap();

        System.out.println(ECom.of("PLayerBag"));
        System.out.println(ECom.of("PlayerEquip"));
        System.out.println(ECom.of("AAAAA"));
    }
}
