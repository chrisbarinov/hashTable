import org.junit.Assert;
import org.junit.Before;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {
    private MyHashTable table;

    @org.junit.jupiter.api.Test
    void addToTail() {
        this.table = new MyHashTable(10, 10);

        int newVal = 10;

        List testList = new List(this.table);
        testList.addToTail(newVal);

        Node nodeToFind = testList.findNodeByValue(newVal);

        //проверяем, что нода найдена (метод возвратил не null-значение)
        Assert.assertNotNull(nodeToFind);

        //и что ее значение равно 10
        Assert.assertEquals(newVal, nodeToFind.getValue());
    }

    @org.junit.jupiter.api.Test
    void findNodeByValue() {
        this.table = new MyHashTable(10, 10);
        int index = 0;
        int newVal = 1000;

        List testList = new List(this.table);
        testList.addElementByIndex(index, newVal);

        Node nodeToFind = testList.findNodeByValue(newVal);

        //проверяем, что нода найдена (метод возвратил не null-значение)
        Assert.assertNotNull(nodeToFind);

        //и что ее значение равно 30
        Assert.assertEquals(newVal, nodeToFind.getValue());
    }

    @org.junit.jupiter.api.Test
    void deleteNodeByValue() {
        this.table = new MyHashTable(10, 10);
        int index = 0;
        int newVal = 2000;

        List testList = new List(this.table);
        testList.addElementByIndex(index, newVal);

        Node nodeToFind = testList.findNodeByValue(newVal);

        //проверяем, что нода найдена (метод возвратил не null-значение)
        Assert.assertNotNull(nodeToFind);

        //и что ее значение равно 2000
        Assert.assertEquals(newVal, nodeToFind.getValue());

        //удаляем ноду
        testList.deleteNodeByValue(newVal);

        nodeToFind = testList.findNodeByValue(newVal);

        //проверяем, что нода не найдена
        Assert.assertEquals(null,nodeToFind);

    }

    @org.junit.jupiter.api.Test
    void deleteNodeByIndex() {
        this.table = new MyHashTable(10, 10);
        int index = 0;
        int newVal = 3000;

        List testList = new List(this.table);
        testList.addElementByIndex(index, newVal);

        Node nodeToFind = testList.findNodeByValue(newVal);

        //проверяем, что нода найдена (метод возвратил не null-значение)
        Assert.assertNotNull(nodeToFind);

        //и что ее значение равно 3000
        Assert.assertEquals(newVal, nodeToFind.getValue());

        //удаляем ноду
        testList.deleteNodeByIndex(index);

        nodeToFind = testList.findNodeByValue(newVal);

        //проверяем, что нода не найдена
        Assert.assertEquals(null,nodeToFind);
    }

    @org.junit.jupiter.api.Test
    void addElementByIndex() {
        this.table = new MyHashTable(10, 10);
        int index = 0;
        int newVal = 30;

        List testList = new List(this.table);
        testList.addElementByIndex(index, newVal);

        Node nodeToFind = testList.findNodeByValue(newVal);

        //проверяем, что нода найдена (метод возвратил не null-значение)
        Assert.assertNotNull(nodeToFind);

        //и что ее значение равно 30
        Assert.assertEquals(newVal, nodeToFind.getValue());
    }
}