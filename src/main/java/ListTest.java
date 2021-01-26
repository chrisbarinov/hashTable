import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListTest {
    private List testList;

    @BeforeEach
    public void setUp() {
        this.testList = new List();
    }

    @Test
    void addToTail() {
        int regionCode = 73;
        String regionName = "Ульяновская область";

        this.testList.addToTail(regionCode, regionName);

        int index = testList.findByValue(regionName);

        //проверяем, что такой регион есть в списке
        Assert.assertTrue(index != -1);
    }


    @Test
    void deleteNodeByValue() {
        int index = 0;
        Integer regionCode = 73;
        String regionName = "Ульяновская область";

        this.testList.addElementByIndex(index, regionCode, regionName);

        index = this.testList.findByValue(regionName);

        //проверяем, что такой регион есть в списке
        Assert.assertTrue(index != -1);

        //удаляем ноду
        this.testList.deleteNodeByValue(regionName);

        index = this.testList.findByValue(regionName);

        //проверяем, что такого региона нет в списке
        Assert.assertTrue(index == -1);

    }

    @Test
    void deleteNodeByIndex() {
        int newIndex = 0;
        Integer regionCode = 73;
        String regionName = "Ульяновская область";

        List testList = new List();
        this.testList.addElementByIndex(newIndex, regionCode, regionName);

        int index = this.testList.findByValue(regionName);

        //проверяем, что такой регион есть в списке
        Assert.assertTrue(index != -1);

        //удаляем ноду
        this.testList.deleteNodeByIndex(newIndex);

        index = this.testList.findByValue(regionName);

        //проверяем, что такого региона нет в списке
        Assert.assertTrue(index == -1);
    }

    @Test
    void addElementByIndex() {
        int index = 0;
        Integer regionCode = 73;
        String regionName = "Ульяновская область";

        this.testList.addElementByIndex(index, regionCode, regionName);

        boolean regionInList = this.testList.contains(regionName);

        //проверяем, что нода в списке есть
        Assert.assertTrue(regionInList);
    }
}