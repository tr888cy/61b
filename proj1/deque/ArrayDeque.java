package deque;

public class ArrayDeque<BleepBlorp> {
    private BleepBlorp[] array;
    private int length = 8;
    private int head;

//    private int nextFirst = startPosition - 1;


    //Creates an empty array deque.
    public ArrayDeque(int start){
        array = (BleepBlorp[])new Object[length];
        length = 8;
        start = head;
    }

    private int nextFirst(){
        int nextFirst;
        if(head>1){
            nextFirst = head - 1;
        }else{
            nextFirst = length-1;
        }
        return nextFirst;
    }

    private int nextLast(){
        int nextLast;
        if(head < length){
            nextFirst = head - 1;
        }else{
            nextFirst = length-1;
        }
        return nextFirst;
    }


    public void addFirst(BleepBlorp x) {
        array[nextFirst()] = x;
        head = head -1;
    }

    public void addLast(BleepBlorp x){
        array[]
    }
//
//    public void addFirst(T item){}
//    public void addLast(T item){}
//    public boolean isEmpty(){}
    public int size(){
        return length;
    }
//    public void printDeque(){}
//    public T removeFirst(){}
//    public T removeLast(){}
//    public T get(int index){}
//    public Iterator<T> iterator(){}
//    public boolean equals(Object o){}



}
