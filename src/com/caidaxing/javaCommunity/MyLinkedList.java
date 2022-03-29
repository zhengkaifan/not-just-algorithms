package com.caidaxing.javaCommunity;



import java.io.IOException;

/**
 * @Author: caidaxing
 * @Date: 2022/03/28/22:57
 * @Description: 实现一个单链表的增删改查操作
 */

class Node {
    int val;
    //指针，指向下一个结点位置
    Node next;
    public Node() {}
    public Node(int val){
        this.val = val;
    }
}
public class MyLinkedList {

    //虚拟头结点
    Node head;
    //存储链表长度，可用于遍历链表
    int size;
    //初始化
    public MyLinkedList() {
        head = new Node(0);
        size = 0;
    }

    //插入节点(位置，新的值)
    public void insert(int index,int number) {
        if(index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        Node newNode = new Node(number);
        Node prev = head;
        //找到要插入位置前一个节点
        for(int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }

    //删除节点，将要删除的节点，前一个节点指向被删除节点的下一个节点
    public int delete(int index) {
        //查找位置非法，返回-1
        if(index < 0 && index >= size || head == null) {
            return -1;
        }
        Node cur = head;
        for(int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        size--;
        //删除头节点只要让第二个成为头节点即可
        cur.next = cur.next.next;
        return 0;
    }

    //更新，和查找类似，找到对应位置的节点，改变节点的值即可；
    public int update(int index, int newValue) {
        //查找位置非法，返回-1
        if(index < 0 && index >= size) {
            return -1;
        }
        Node cur = head;
        for(int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        cur.val = newValue;
        return cur.val;
    }

    //查找,从头节点开始遍历，找到index + 1 个结点的数值即可
    public int search(int index) {
        //查找位置非法，返回-1
        if(index < 0 && index >= size) {
            return -1;
        }
        Node cur = head;
        for(int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }



    //打印节点
    public void print() {
        Node cur = head;
        for (int i = 0; i < size; i++) {
            System.out.print(cur.val + ",");
            cur = cur.next;
        }
    }

    public static void main(String[] args) throws Exception {
        MyLinkedList myLinkedList = new MyLinkedList();
        // 插入数据
        myLinkedList.insert(0,0);
        myLinkedList.insert(1,1);
        myLinkedList.insert(2,2);
        myLinkedList.insert(3,3);
        //输出测试
        myLinkedList.print();
        System.out.println(myLinkedList.size);
        //修改测试
        myLinkedList.update(1, 3);
        myLinkedList.print();
        System.out.println();
        // 删除测试
        myLinkedList.delete(2);
        myLinkedList.print();
        System.out.println();
        //查找测试
        System.out.println(myLinkedList.search(2));
    }

}
