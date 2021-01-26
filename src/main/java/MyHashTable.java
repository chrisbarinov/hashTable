import java.util.ArrayList;

public class MyHashTable {
    private List[] hashTable;
    public int maxListElemCount;

    public MyHashTable(int tableLength, int listElemCount) {
        this.hashTable = new List[tableLength];
        for (int i = 0; i < tableLength; i++) {
            this.hashTable[i] = new List();
        }
        this.maxListElemCount = listElemCount;
    }

    public void rebuildHashTable() {
        //получаем все значения из текущей таблицы
        ArrayList<Object[]> arKeysValues = getArrayOfKeyValue();
        int oldLength = this.hashTable.length;
        this.hashTable = new List[++oldLength];

        for (Object[] arKeyValue:arKeysValues) {
            int index = hash(arKeyValue[0].hashCode());
            if (this.hashTable[index] == null) {
                this.hashTable[index] = new List();
            }
            this.hashTable[index].addToTail((Integer) arKeyValue[0], (String) arKeyValue[1]);
        }

    }
    private int hash(int hashCode) {
        return hashCode % this.hashTable.length;
    }

    public void addElem(Integer key, String value) {
        int index = this.hash(key.hashCode());
        this.hashTable[index].addToTail(key, value);
        if (this.hashTable[index].getListSize() > this.maxListElemCount) {
            this.rebuildHashTable();
        }
    }

    /**
     * Получение элемента по ключу
     */
    public String getByKey(Integer key) {
        int index = this.hash(key.hashCode());
        return this.hashTable[index].getValueByKey(key);
    }

    /**
     * Удаление эл-та по ключу
     */

    public void deleteByKey(Integer key) {
        int index = this.hash(key.hashCode());
        this.hashTable[index].deleteNodeByKey(key);
    }

    public ArrayList<Integer> getKeys() {
        ArrayList<Integer> keyList = new ArrayList<>();
        for (int i = 0; i < this.hashTable.length; i++) {
            keyList.addAll(this.hashTable[i].getKeys());
        }

        return keyList;
    }

    public ArrayList<Object[]> getArrayOfKeyValue() {
        ArrayList <Object[]> arKeyValue = new ArrayList<>();
        for (int i = 0; i < this.hashTable.length; i++) {
            this.hashTable[i].getValues(arKeyValue);
        }

        return arKeyValue;
    }


}
