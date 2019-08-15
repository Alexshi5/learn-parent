package data_structure.linear_list;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 线性表的顺序存储结构实现
 */
public class MyArrayList<E> implements Serializable{

    private static final long serialVersionUID = -7568057488280387295L;

    //静态常量——空的对象数组
    private static final Object[] EMPTY_ELEMENTDATA = {};

    //静态常量——空的默认容量对象数组
    private static final Object[] DEFAULT_EMPTY_ELEMENTDATA = {};

    //默认容量
    private static final int DEFAULT_CAPACITY = 10;

    //对象数组
    transient Object[] elementData;

    //数组个数
    private int size;

    //静态常量——要分配的最大数组长度(有些虚拟机在数组中会保留一些头信息，尝试分配更多将可能出现错误)
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public MyArrayList(){this.elementData = DEFAULT_EMPTY_ELEMENTDATA;}

    public MyArrayList(int capacity){
        if(capacity > 0){
            this.elementData = new Object[capacity];
        }else if(capacity == 0){
            this.elementData = EMPTY_ELEMENTDATA;
        }else {
            throw new IllegalArgumentException("Illegal Capacity: "+ capacity);
        }
    }

    /**
     * 获取集合元素个数
     * @return
     */
    public int size(){return size;}

    /**
     * 向集合中添加元素
     * @param e
     * @return
     */
    public boolean add(E e){
        int minCapacity = size + 1;
        if(elementData == DEFAULT_EMPTY_ELEMENTDATA){
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }

        //如果添加元素的索引下标大于数组长度，即进行扩容
        if((minCapacity - elementData.length) > 0){
            this.grow(minCapacity);
        }
        elementData[size++] = e;
        return true;
    }

    private void grow(int minCapacity){
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1); //扩容为原来的1.5倍
        if((minCapacity - newCapacity) > 0){
            newCapacity = minCapacity;
        }
        if((newCapacity - MAX_ARRAY_SIZE) > 0){
            if(minCapacity < 0){
                throw new OutOfMemoryError();
            }else {
                newCapacity = minCapacity > MAX_ARRAY_SIZE ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
            }
        }
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    /**
     * 清除集合元素
     */
    public void clear(){
        for(int i = 0; i < elementData.length; i++){
            elementData[i] = null;
        }
        size = 0;
    }

    /**
     * 删除集合元素
     * @param index 元素索引
     * @return
     */
    public boolean remove(int index){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        //当要删除的元素不是最后一个时，需要将数组中的元素全部前移
        if(index < elementData.length - 1){
            for(int i = 0; i < elementData.length; i++){
                if(i >= index && i < size){
                    elementData[i] = elementData[i+1];
                }
            }
        }
        elementData[--size] = null;
        return true;
    }

    /**
     * 获取集合元素
     * @param index 元素索引
     * @return
     */
    public E getElem(int index){
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        return (E) elementData[index];
    }

    /**
     * 获取集合容量
     * @return
     */
    public int getCapacity(){
        return elementData.length;
    }

    public static void main(String[] args) throws Exception{
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(0);
        System.out.println("集合的容量：" + myArrayList.getCapacity());
        System.out.println("集合中元素个数：" + myArrayList.size);
        System.out.print("集合中元素分别为：");
        for(int j = 0; j < myArrayList.size; j++){
            System.out.print(myArrayList.getElem(j) + " ");
        }

        //循环添加元素
        System.out.println();
        for(int i = 0; i < 10; i++){
            myArrayList.add(i);
        }
        System.out.println("集合的容量：" + myArrayList.getCapacity());
        System.out.println("集合中元素个数：" + myArrayList.size);
        System.out.print("集合中元素分别为：");
        for(int j = 0; j < myArrayList.size; j++){
            System.out.print(myArrayList.getElem(j) + " ");
        }

        //删除元素
        System.out.println();
        myArrayList.remove(5);
        System.out.println("集合的容量：" + myArrayList.getCapacity());
        System.out.println("集合中元素个数：" + myArrayList.size);
        System.out.print("集合中元素分别为：");
        for(int j = 0; j < myArrayList.size; j++){
            System.out.print(myArrayList.getElem(j) + " ");
        }

        //清除集合中的元素.
        System.out.println();
        myArrayList.clear();
        System.out.println("集合的容量：" + myArrayList.getCapacity());
        System.out.println("集合中元素个数：" + myArrayList.size);
        System.out.print("集合中元素分别为：");
        for(int j = 0; j < myArrayList.size; j++){
            System.out.print(myArrayList.getElem(j) + " ");
        }
        //System.in.read();
    }
}
