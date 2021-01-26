import java.util.ArrayList;

public class List <K, V> {
    private Node head;
    private Node tail;

    private int listSize;

    //инициализация списка
    public List() {
        this.head = null;
        this.tail = null;
        this.listSize = 0;
    }

    public int getListSize() {
        return this.listSize;
    }

    public void getValues(ArrayList<Object[]> arKeyValue) {
        Node i = this.head;

        while (i != null) {
            arKeyValue.add(new Object[] {(Integer) i.getKey(), (String) i.getValue()});
            i = i.getNextNode();
        }
    }

    //Добавление эл-та по индексу
    public void addElementByIndex(int index, int regionCode, String regionName) {
        if (this.listSize == 0) {
            this.addToTail(regionCode, regionName);
            return;
        }

        if (index < this.listSize) {
            //проверяем, есть ли уже элемент с таким ключом
            Node nodeToFind = this.findByCode(regionCode);
            if (nodeToFind != null) {
                nodeToFind.setValue(regionName);
                return;
            }
            //если элемента нет, продолжаем работу метода
            //находим элемент
            Node nodeToChange = this.findNodeByPos(index);
            if (nodeToChange != null) {
                Node<Integer, String> newNode = new Node<>(regionCode, regionName);
                Node prevNode = nodeToChange.getPrevNode();
                if (prevNode != null) {
                    prevNode.setNext(newNode);
                }
                nodeToChange.setPrev(newNode);
                newNode.setNext(nodeToChange);
            }
        }

    }

    //добавление в конец списка
    public void addToTail(int regionCode, String regionName) {
        //проверяем, есть ли уже элемент с таким ключом
        Node nodeToFind = this.findByCode(regionCode);
        if (nodeToFind != null) {
            nodeToFind.setValue(regionName);
            return;
        }

        //если элемента нет, добавляем новый
        Node<Integer, String> newNode = new Node<>(regionCode, regionName);

        //Если это первый эл-т
        if (this.head == null) {
            newNode.setNext(newNode);
            newNode.setPrev(newNode);

            this.head = newNode;
            this.tail = newNode;

            this.listSize++;
            return;
        }

        //если элемент не первый, кидаем его после хвоста и переопределяем хвост
        this.tail.setNext(newNode);
        newNode.setPrev(this.tail);

        this.tail = newNode;

        this.listSize++;
    }

    private Node findByCode(Integer regionCode) {
        Node i = this.head;

        while (i != null) {
            if (i.getKey().equals(regionCode)) {
                return i;
            }
            i = i.getNextNode();
        }

        return null;
    }

    public ArrayList<Integer> getKeys() {
        ArrayList<Integer> keys = new ArrayList<>();
        Node i = this.head;

        while (i != null) {
            keys.add((Integer) i.getKey());
            i = i.getNextNode();
        }

        return keys;
    }

    public String getValueByKey(Integer regionCode) {
        Node nodeToFind = this.findByCode(regionCode);
        if (nodeToFind != null) {
            return nodeToFind.getValue().toString();
        }

        return null;
    }

    //поиск индекса по значению
    public int findByValue(String regionNameToFind) {
        Node i = this.head;
        int pos = 0;

        while (i != null) {
            if (i.getValue().equals(regionNameToFind)) {
                return pos;
            }
            i = i.getNextNode();
            pos++;
        }

        return -1;
    }

    public boolean contains(String regionNameToFind) {
        Node i = this.head;

        while (i != null) {
            if (i.getValue().equals(regionNameToFind)) {
                return true;
            }
            i = i.getNextNode();
        }

        return false;
    }

    //поиск элемента по значению
    private Node findNodeByValue(String regionNameToDelete) {
        Node i = this.head;

        while (i != null) {
            if (i.getValue().equals(regionNameToDelete)) {
                return i;
            }
            i = i.getNextNode();
        }

        return null;
    }

    //поиск элемента по позиции
    private Node findNodeByPos(int index) {
        Node curNode = this.head;
        int i = 0;

        while (curNode != null) {
            if (i++ == index) {
                return curNode;
            }
            curNode = curNode.getNextNode();
        }

        return null;
    }

    private void deleteNode(Node nodeToDelete) {

        if (this.listSize == 1) {
            this.head = null;
            this.tail = null;
        }

        Node nextNode = nodeToDelete.getNextNode();
        Node prevNode = nodeToDelete.getPrevNode();

        if (nextNode != null) {
            nextNode.setPrev(nodeToDelete.getPrevNode());
        }

        if (prevNode != null) {
            prevNode.setNext(nodeToDelete.getNextNode());
        }

        this.listSize--;
    }

    //удаление ноды по значению
    public void deleteNodeByValue(String regionNameToDelete) {
        Node nodeToDelete = findNodeByValue(regionNameToDelete);

        //пока value находится, удаляем ноду, содержащую его
        while (nodeToDelete != null) {
            this.deleteNode(nodeToDelete);
            nodeToDelete = findNodeByValue(regionNameToDelete);
        }
    }

    //удаление элемента по позиции
    public void deleteNodeByIndex(int index) {
        Node nodeToDelete = this.findNodeByPos(index);

        if (nodeToDelete != null) {
            this.deleteNode(nodeToDelete);
        }
    }

    public void deleteNodeByKey(Integer regionCode) {
        Node nodeToDelete = this.findByCode(regionCode);

        if (nodeToDelete != null) {
            this.deleteNode(nodeToDelete);
        }
    }

}
