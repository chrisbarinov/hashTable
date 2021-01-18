import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashTableTest {
    //private MyHashTable table;

    //аннотация почему-то не срабатывает - table указывает на null
    /*@Before
    public void setUp() {
        MyHashTable table = new MyHashTable(10, 10);
    }*/

    @Test
    void addElem() {
        MyHashTable table = new MyHashTable(10, 10);

        int newVal = 20;
        table.addElem(newVal);

        //проверяем, что элемент добавился по индексу 0
        List hashElemList = table.getByKey(0);
        Assert.assertNotNull(hashElemList);

        //и что его значение равно 20
        Node nodeToFind = hashElemList.findNodeByValue(newVal);
        Assert.assertEquals(newVal,nodeToFind.getValue());
    }

    @Test
    void getByKey() {
        MyHashTable table = new MyHashTable(10, 10);

        int newVal = 100;
        table.addElem(newVal);

        //проверяем, что элемент добавился по индексу 0
        List hashElemList = table.getByKey(0);
        Assert.assertNotNull(hashElemList);

        //и что его значение равно 100
        Node nodeToFind = hashElemList.findNodeByValue(newVal);
        Assert.assertEquals(newVal,nodeToFind.getValue());
    }

    @Test
    void deleteByIndex() {
        MyHashTable table = new MyHashTable(10, 10);

        int newVal = 300;
        table.addElem(newVal);

        //проверяем, что элемент добавился по индексу 0
        List hashElemList = table.getByKey(0);
        Assert.assertNotNull(hashElemList);

        //и что его значение равно 300
        Node nodeToFind = hashElemList.findNodeByValue(newVal);
        Assert.assertEquals(newVal,nodeToFind.getValue());

        //удаляем все элементы по индексу
        table.deleteByIndex(0);

        List list = table.getByKey(0);
        Assert.assertEquals(null,list);

    }
}