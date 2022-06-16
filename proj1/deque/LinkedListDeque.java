package deque;

public class LinkedListDeque<BleepBlorp> {

    private class Node {
        private BleepBlorp item;
        private Node next;
        private Node prev;

        public Node(Node prev_item, BleepBlorp this_item, Node next_item) {
            prev = prev_item;
            item = this_item;
            next = next_item;
        }
    }

    /* The first item (if it exists) is at sentinel.next. */
    private Node frontSentinel;
    private Node backSentinel;
    private int size;


    /** Creates an empty timingtest.SLList. */
    public LinkedListDeque() {
        frontSentinel = new Node(null, null,null);
        backSentinel = new Node(null, null,null);
        frontSentinel.next = backSentinel.prev ;
        size = 0;
    }

//    //TODO: 写这个有什么用？看看课件！！
//    public LinkedListDeque(BleepBlorp x) {
//        //frontSentinel其实是一个空的node
//        frontSentinel = new Node(null, null,null);
//        frontSentinel.next = new Node(null, x, null);
//        backSentinel.prev = frontSentinel.next;//TODO 这样写对吗？
//        head = backSentinel.prev;
//        size = 1;
//    }

    /** Adds x to the front of the list. */
    public void addFirst(BleepBlorp x) {
        Node firstNode = new Node(null, x, frontSentinel.next);
        if (frontSentinel.next == null){
            backSentinel.prev = firstNode;
        }
        frontSentinel.next = firstNode;
        size = size + 1;
    }

    /** Returns the first item in the list. */
    public BleepBlorp getFirst() {
        return frontSentinel.next.item;
    }

    /** Adds x to the end of the list. */
    public void addLast(BleepBlorp x) {
        Node lastNode = new Node(backSentinel.prev, x, null);
        if (backSentinel.prev == null){
            frontSentinel.next = lastNode;
        }else{
            backSentinel.prev.next = lastNode;
        }
        backSentinel.prev = lastNode;
        size = size + 1;
    }

    /** returns last item in the list */
    public BleepBlorp getLast() {
        return backSentinel.prev.item;
    }

    /** Returns the size of the list. */
    public int size() {
        return size;
    }

    public boolean isEmpty(){
        if (size == 0){
            return true;
        }else{
            return false;
        }
    }

    public void printDeque(){
        Node start = frontSentinel;
        for(int j=0; j<size; j=j+1){
            System.out.print(start.next.item + " ");
            start = start.next;
        }
        System.out.println();
    }

    public BleepBlorp removeFirst(){
        if (size >0){
            BleepBlorp deleteValue = frontSentinel.next.item;
            if(size > 1){
                Node deleteNode = frontSentinel.next;
                Node newFirst = deleteNode.next;
                newFirst.prev = frontSentinel;
                frontSentinel.next = newFirst;
            } else if (size ==1){
                frontSentinel.next = backSentinel;
                backSentinel.prev = frontSentinel;
            }
            size = size - 1;
            return deleteValue;
        }else{
            return null;
        }
    }

    public BleepBlorp removeLast(){
        if (size >0){
            BleepBlorp deleteValue = backSentinel.prev.item;
            if(size > 1){
                Node deleteNode = backSentinel.prev;
                Node newLast = deleteNode.prev;
                newLast.next = backSentinel;
                backSentinel.prev = newLast;
            } else if (size ==1){
                backSentinel.prev = frontSentinel;
                frontSentinel.next = backSentinel;
            }
            size = size - 1;
            return deleteValue;
        }else{
            return null;
        }
    }

    /*
    public BleepBlorp removeLast(){
        if(size !=0){
            Node deleteNode = backSentinel.prev;
            Node newLast = deleteNode.prev;
            newLast.prev = backSentinel;
            backSentinel.prev = newLast;
            size = size - 1;
            return backSentinel.prev.item;
        }else if(size == 1){
            frontSentinel.next = backSentinel;
            backSentinel.prev = frontSentinel;
            size = 0;
            return null;
        }else{
            return null;
        }
    }
     */

    public BleepBlorp get(int index){
        if (index > size - 1){
            return null;
        }else {
            Node start = frontSentinel.next;
            while (index !=0){
                start = start.next;
                index = index -1;
            }
            return start.item;
        }
    }

//    public Iterator<T> iterator(){}
//    public boolean equals(Object o){}

    public static void main(String[] args) {
        /* Creates a list of one integer, namely 10 */
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        L.addFirst(5);
        L.addFirst(6);
        L.addLast(8);
        L.getFirst();
        L.getLast();
//        System.out.println(L.removeFirst());
        System.out.println(L.get(4));
//        System.out.println(L.size());
        L.printDeque();
    }
}
