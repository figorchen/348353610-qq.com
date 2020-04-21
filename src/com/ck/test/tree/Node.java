package com.ck.test.tree;

/**
 * 类    名: Node </br>
 * 创建时间: 2020/4/17 </br>
 * 类 描 述: </br>
 * 版   本: 1.0.0 </br>
 *
 * @author : 谌珂 </br>
 */
class Node<T> {
    public Node(T value) {
        this.value = value;
    }

    private T value;
    private Node<T> left;
    private Node<T> right;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return value.toString();
//        return detail();
    }

    public String detail() {
        return "value: " + value.toString() + "    左节点: " + (left == null ? "null" : left.getValue()) + "   右节点: " + (right == null ? "null" : right.getValue());
    }
}
