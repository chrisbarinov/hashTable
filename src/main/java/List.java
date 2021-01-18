import java.util.ArrayList;

public class List {
    private Node head;
    private Node tail;

    private int listSize;
    private MyHashTable table;

    //инициализация списка
    public List(MyHashTable table) {
        this.head = null;
        this.tail = null;
        this.listSize = 0;
        this.table = table;
    }

    public void getValues(ArrayList<int[]> arKeyValue, int key) {
        Node i = this.head;

        while (i != null) {
            arKeyValue.add(new int[] {key, i.getValue()});
            i = i.getNextNode();
        }
    }

    //добавление в конец списка
    public void addToTail(int newElem) {

        Node newNode = new Node(newElem);

        //Если это первый эл-т
        if (this.head == null) {
            newNode.setNext(newNode);
            newNode.setPrev(newNode);

            this.head = newNode;
            this.tail = newNode;

            this.listSize++;

            if (this.listSize > this.table.maxListElemCount) {
                //перестраиваем хэш-таблицу
                this.table.rebuildHashTable();
            }

            return;
        }

        //если элемент не первый, кидаем его после хвоста и переопределяем хвост
        this.tail.setNext(newNode);
        newNode.setPrev(this.tail);

        this.tail = newNode;

        this.listSize++;
    }

    //поиск элемента по значению
    public Node findNodeByValue(int valToFind) {
        Node i = this.head;

        while (i != null) {
            if (i.getValue() == valToFind) {
                return i;
            }
            i = i.getNextNode();
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
    public void deleteNodeByValue(int valToDelete) {
        Node nodeToDelete = findNodeByValue(valToDelete);

        //пока value находится, удаляем ноду, содержащую его
        while (nodeToDelete != null) {
            this.deleteNode(nodeToDelete);
            nodeToDelete = findNodeByValue(valToDelete);
        }
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

    //удаление элемента по позиции
    public void deleteNodeByIndex(int index) {
        Node nodeToDelete = this.findNodeByPos(index);

        if (nodeToDelete != null) {
            this.deleteNode(nodeToDelete);
        }
    }

    /***
     * Добавление эл-та по индексу
     * Если индекс в списке есть, изменяю по нему элемент
     * Если такого индекса нет, добавляю элемент в хвост списка
     */

    public void addElementByIndex(int index, int val) {
        if (index < this.listSize) {
            //находим элемент и изменяем его
            Node nodeToChange = this.findNodeByPos(index);
            if (nodeToChange != null) {
                nodeToChange.setValue(val);
            }
        } else {
            //добавляем элемент в конец списка
            this.addToTail(val);
        }

    }


}
