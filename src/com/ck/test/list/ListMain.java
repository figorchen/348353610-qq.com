package com.ck.test.list;

/**
 * 类    名: ListMain </br>
 * 创建时间: 2020/5/6 </br>
 * 类 描 述: </br>
 * 版   本: 1.0.0 </br>
 *
 * @author : 谌珂 </br>
 */
public class ListMain {

    public static void main(String[] args) {
        LinkList<Integer> list = new LinkList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.revert();

        Node<Integer> current = list.getStart();
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }
}
