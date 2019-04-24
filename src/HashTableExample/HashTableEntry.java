package HashTableExample;

/**
 * Created by nirmal on 14/1/18.
 */
public class HashTableEntry {
    Object key;
    Object value;

    HashTableEntry(Object key , Object value){
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }
}
