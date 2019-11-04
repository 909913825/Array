import java.util.Arrays;

public class Array {
    /**
     * 这里没有声明capacity，是因为data.length即为他可以存放的容量
     * 声明为private是因为不希望用户从外部直接获得这些信息，否则就是不安全的
     */
    private int[] data; //数组的名称
    private int size;   //数组中的有效元素

    public Array(int capacity){
        data = new int[capacity];
        size = 0;
    }
    //无参的构造函数，默认的数组容量为10
    public Array(){
        this(10);
    }
    //获取数组中的元素个数
    public int getSize(){
        return size;
    }
    //获取数组中的容量
    public int getCapacity(){
        return data.length;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void addLast(int e){
//        add(size,e);
        if (size == data.length){
            //抛出传入的参数错误的异常
            throw new IllegalArgumentException("AddLast failed, Array is already full.");
        }
        data[size] = e;
        size ++;
    }
    public void addFirst(int e){
        add(0,e);
    }
    public void add(int index, int e){
        if (size == data.length){
            //抛出传入的参数错误的异常
            throw new IllegalArgumentException("AddLast failed, Array is already full.");
        }
        if (index < 0 || index > size){
            throw new IllegalArgumentException("AddLast failed, Require index >= 0 and index <= size.");
        }
        for (int i = size - 1; i >= index; i--){
            data[i + 1] = data[i];
        }
        data[index] = e;
        size ++;
//        错误的做法
//        for (int j = index; j < size; j++){
//          data[j + 1]  = data[j];
//        }
//        data[index] = e;
//        size ++;
    }
    int get(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("AddLast failed, Index is illegal.");
        }
        return data[index];
    }
    void set(int index, int e){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("AddLast failed, Index is illegal.");
        }
        data[index] = e;
    }
    public boolean contains(int e){
        for (int i = 0 ;i < size; i ++){
            if (data[i] == e)
                return true;
        }
        return false;
    }
    public int find(int e){
        for (int i = 0 ;i < size; i ++){
            if (data[i] == e)
                return i;
        }
        return -1;
    }
    public int remove(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("AddLast failed, Index is illegal.");
        }
        int ret = data[index];
        for (int i = index; i < size; i ++){
           data[i] = data[i + 1];
        }
        size --;
        return ret;
    }
    public  int removeFirst(){
        return remove(0);
    }
    public int removeLast(){
        return remove(size - 1);
    }
    public void removeElement(int e){
        int index = find(e);
        if (index != -1){
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n",size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++){
            res.append(data[i]);
            if (i != size - 1){
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}
