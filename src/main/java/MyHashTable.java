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
        ArrayList<int[]> arKeysValues = getArrayOfKeyValue();
        int oldLength = this.hashTable.length;
        this.hashTable = new List[++oldLength];

        for (int[] arKeyValue:arKeysValues) {
            int index = hash(arKeyValue[1]);
            this.hashTable[index] = new List();
            this.hashTable[index].addToTail(arKeyValue[1]);
        }

    }
    public int hash(int newVal) {
        return newVal % this.hashTable.length;
    }

    public void addElem(int newVal) {
        int index = hash(newVal);
        this.hashTable[index].addToTail(newVal);
        if (this.hashTable[index].getListSize() > this.maxListElemCount) {
            this.rebuildHashTable();
        }
    }

    /**
     * Получение эл-та по ключу, это как? Возвратить весь список, привязанный к эл-ту хэштаблицы?
     * Не знаю, каким образом, зная ключ, получить элемент. Обратной хэш функции для остатка от деления не существует
     */
    public List getByKey(int index) {
        if (index < this.hashTable.length) {
            return this.hashTable[index];
        }

        return null;
    }

    /**
     * Удаление эл-та по ключу, тоже самое: не могу из ключа однозначно получить само значение
     * Решил просто обнулять весь список
     */

    public void deleteByIndex(int index) {
        if (index < this.hashTable.length) {
            this.hashTable[index] = null;
        }
    }

    public int[] getKeys() {
        int[] arKeys = new int[this.hashTable.length];
        for (int i = 0; i < this.hashTable.length; i++) {
            arKeys[i] = i;
        }

        return arKeys;
    }

    public ArrayList<int[]> getArrayOfKeyValue() {
        ArrayList <int[]> arKeyValue = new ArrayList<int[]>();
        for (int i = 0; i < this.hashTable.length; i++) {
            this.hashTable[i].getValues(arKeyValue, i);
        }

        return arKeyValue;
    }


}
