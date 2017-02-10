package sources.datastructures.custom.maps;

import java.util.List;
import java.util.Set;

/**
 * Created by mman on 09.02.17.
 */
public interface BasicMap<K, V> {

    public V put(K key, V value);

    public V get(K key);

    public boolean remove(K key);

    public boolean containsKey(K key);

    public List<K> getKeys();

    public Set<BasicMap.Entry<K, V>> getEntrySet();

    interface Entry<K, V> {

        K getKey();

        V getValue();

        void setValue(V newValue);
    }

}
