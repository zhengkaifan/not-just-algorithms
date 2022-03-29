package com.caidaxing.javaCommunity.community;

class Node{
    int val;
    Node next;
    public Node() {}
    public Node(int val) {
        this.val = val;
    }
}

class MyLinkedList {
    // size 存储链表元素的个数
    int size;
    // 虚拟头结点
    Node head;

    // 初始化链表
    public MyLinkedList() {
        size = 0;
        head = new Node(0);
    }

    // 获取第index个结点的数值
    public int get(int index) {
        // 如果index非法，返回-1
        if (index < 0 || index >= size) {
            return -1;
        }
        Node currentNode = head;
        // 包含一个虚拟头结点，所以查找第 index + 1 个结点
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }

    // 在链表最前面插入一个结点
    public void addAtHead(int val) { 
        addAtIndex(0, val);
    }

    // 在链表的最后插入一个结点
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    //在第 index 个结点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新心头节点
    // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
    // 如果 index 大于链表的长度，则说明返回空
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size ++;
        // 找到要插入节点的前驱
        Node pred = head;
        for (int i = 0; i <index; i++) {
            pred = pred.next;
        }
        Node toAdd = new Node(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }
    // 删除第 index 个节点
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        // 找到要删除节点的前驱
        Node pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        // 删除节点，将要删除的节点，前一个节点指向被删除节点的下一个节点
        pred.next = pred.next.next;
    }


}