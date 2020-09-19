package com.ck.test.list;

/**
 * 类    名: Node </br>
 * 创建时间: 2020/5/6 </br>
 * 类 描 述: </br>
 * 版   本: 1.0.0 </br>
 *
 * @author : 谌珂 </br>
 */
class Node<T> {
    public Node(T data) {
        this.data = data;
    }

    private Node<T> next;
    private T data;

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean hasNext() {
        return next != null;
    }
}
