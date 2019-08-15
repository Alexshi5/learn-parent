package data_structure.linear_list;

import java.io.Serializable;
import java.util.NoSuchElementException;

/**
 * 线性表的链式存储结构实现
 */
public class MyLinkedList<E> implements Serializable {

    private static final long serialVersionUID = -1595184995773622074L;

    //集合大小
    private int size;

    private MyNode<E> first; //首节点
    private MyNode<E> last; //尾节点

    public MyLinkedList(){}

    private static class MyNode<E>{
        E item;
        MyNode<E> next;
        MyNode<E> pre;
        MyNode(MyNode<E> pre, E elem, MyNode<E> next){
            this.item = elem;
            this.next = next;
            this.pre = pre;
        }
    }

    /**
     * 获取集合元素个数
     * @return
     */
    public int size(){return size;}

    /**
     * 清除集合中的元素
     */
    public void clear(){
        for(MyNode<E> node = first; node != null;){
            MyNode<E> next = node.next;
            node.item = null;
            node.pre = null;
            node.next = null;
            node = next;
        }
        first = last = null;
        size = 0;
    }

    /**
     * 获取集合中的元素
     * @param index
     * @return
     */
    public E getElem(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        MyNode<E> node = null;
        if(index >= (index >> 1)){
            node = last;
            for(int i = size - 1; i > index; i--){
                node = node.pre;
            }
        }else {
            node = first;
            for(int i = 0; i < index; i++){
                node = node.next;
            }
        }
        return node.item;
    }

    /**
     * 头插法
     * @param e
     */
    public void addFirst(E e){
        final MyNode<E> f = first;
        final MyNode<E> newNode = new MyNode<>(null, e, f);
        if(f == null){
            last = newNode;
        }else {
            f.pre = newNode;
        }
        first = newNode;
        size++;
    }

    /**
     * 尾插法
     * @param e
     */
    public void addLast(E e){
        final MyNode<E> l = last;
        final MyNode<E> newNode = new MyNode<>(l, e, null);
        if(l == null){
            first = newNode;
        }else {
            l.next = newNode;
        }
        last = newNode;
        size++;
    }

    /**
     * 头删除
     */
    public E removeFirst(){
        final MyNode<E> f = first;
        if(f == null){
            throw new NoSuchElementException();
        }
        final E element = f.item;
        final MyNode<E> next = f.next;
        if(next == null){
            last = null;
        }else {
            next.pre = null;
        }
        first = next;
        size--;
        return element;
    }

    /**
     * 尾删除
     */
    public E removeLast(){
        final MyNode<E> l = last;
        if(l == null){
            throw new NoSuchElementException();
        }
        final MyNode<E>  pre = l.pre;
        final E element = l.item;
        if(pre == null){
            first = null;
        }else {
           pre.next = null;
        }
        last = pre;
        size--;
        return element;
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.addLast(0);
        System.out.println("集合中元素个数：" + myLinkedList.size);
        System.out.print("集合中元素分别为：");
        for(int i = 0; i < myLinkedList.size; i++){
            System.out.print(myLinkedList.getElem(i));
        }

        //循环添加元素
        System.out.println();
        for(int j = 0; j < 10; j++){
            myLinkedList.addLast(j);
        }
        System.out.println("集合中元素个数：" + myLinkedList.size);
        System.out.print("集合中元素分别为：");
        for(int i = 0; i < myLinkedList.size; i++){
            System.out.print(myLinkedList.getElem(i) + " ");
        }

        //删除集合中的尾元素
        System.out.println();
        myLinkedList.removeLast();
        System.out.println("集合中元素个数：" + myLinkedList.size);
        System.out.print("集合中元素分别为：");
        for(int i = 0; i < myLinkedList.size; i++){
            System.out.print(myLinkedList.getElem(i) + " ");
        }

        //清除集合中的元素.
        System.out.println();
        myLinkedList.clear();
        System.out.println("集合中元素个数：" + myLinkedList.size);
        System.out.print("集合中元素分别为：");
        for(int i = 0; i < myLinkedList.size; i++){
            System.out.print(myLinkedList.getElem(i) + " ");
        }
    }
}
