package cyou.em;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 容器-用来包装数据
 * @param <K>
 * @param <V>
 */
public class Contains<K, V> {

    Map<K, V> map = new HashMap<>();

    /**
     * builder模式
     * @param key
     * @param object
     * @return
     */
    public Map<K, V> put (K key, V object) {
        map.put(key, object);
        return map;
    }

    public V get (K key) {
        return map.get(key);
    }

}
