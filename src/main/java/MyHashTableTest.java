import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyHashTableTest {
    private MyHashTable table;

    @BeforeEach
    public void setUp() {
        this.table = new MyHashTable(10, 10);
    }

    @Test
    void addElem() {
        Integer regionCode = 73;
        String regionName = "Ульяновская область";
        this.table.addElem(regionCode, regionName);

        //проверяем, что элемент добавился по тому же ключу
        String regionNameInHashTable = this.table.getByKey(regionCode);
        Assert.assertEquals(regionNameInHashTable, regionName);
    }

    @Test
    void deleteByKey() {
        int regionCode = 73;
        String regionName = "Ульяновская область";
        this.table.addElem(regionCode, regionName);

        //удаляем элемент по ключу
        this.table.deleteByKey(regionCode);

        String regionInHashTable = this.table.getByKey(regionCode);
        Assert.assertEquals(null, regionInHashTable);
    }
}