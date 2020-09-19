package com.ck.test.list;

/**
 * 类    名: LinkList </br>
 * 创建时间: 2020/5/6 </br>
 * 类 描 述: </br>
 * 版   本: 1.0.0 </br>
 *
 * @author : 谌珂 </br>
 */
class LinkList<T> {
    private Node<T> start;

    public Node<T> getStart() {
        return start;
    }

    public void add(T data) {
        if (data != null) {
            Node<T> tNode = new Node<>(data);
            if (start == null) {
                start = tNode;
            } else {
                Node<T> tmp = start;
                while (tmp.hasNext()) {
                    tmp = tmp.getNext();
                }
                tmp.setNext(tNode);
            }
        }
    }

    public void revert() {
        Node<T> prev = null;
        Node<T> current = start;
        while (current.hasNext()) {
            Node<T> next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        current.setNext(prev);
        start = current;
    }


}
