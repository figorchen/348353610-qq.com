package com.ck.test.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 类    名: BinarySearchTree </br>
 * 创建时间: 2020/4/17 </br>
 * 类 描 述: </br>
 * 版   本: 1.0.0 </br>
 *
 * @author : 谌珂 </br>
 */
class BinarySearchTree<T extends Comparable<T>> {
    // 根节点
    private Node<T> root;
    // 总层数
    private int plies;
    // 节点数
    private int size;

    public int getPlies() {
        return plies;
    }

    public int getSize() {
        return size;
    }

    // 前序遍历
    public List<Node<T>> preOrder() {
        ArrayList<Node<T>> list = new ArrayList<>(size);
        preOrder(list, root);
        return list;
    }

    private void preOrder(List<Node<T>> list, Node<T> node) {
        if (node == null) {
            return;
        }
        list.add(node);
        preOrder(list, node.getLeft());
        preOrder(list, node.getRight());
    }

    // 前序遍历
    public List<Node<T>> inOrder() {
        ArrayList<Node<T>> list = new ArrayList<>(size);
        inOrder(list, root);
        return list;
    }

    private void inOrder(List<Node<T>> list, Node<T> node) {
        if (node == null) {
            return;
        }
        inOrder(list, node.getLeft());
        list.add(node);
        inOrder(list, node.getRight());
    }

    // 后序遍历
    public List<Node<T>> postOrder() {
        ArrayList<Node<T>> list = new ArrayList<>(size);
        postOrder(list, root);
        return list;
    }

    private void postOrder(List<Node<T>> list, Node<T> node) {
        if (node == null) {
            return;
        }
        postOrder(list, node.getLeft());
        postOrder(list, node.getRight());
        list.add(node);
    }

    public void insert(T data) {
        if (data == null) {
            return;
        }
        if (!isNodeValid(root)) {
            root = new Node<>(data);
            size++;
            return;
        }
        insert(data, root, 1);
        size++;
    }

    private void insert(T data, Node<T> node, int currentPlies) {
        int nextPlies = currentPlies + 1;
        int compare = data.compareTo(node.getValue());
        if (compare < 0) {
            if (!isNodeValid(node.getLeft())) {
                node.setLeft(new Node<>(data));
                if (plies < nextPlies) {
                    plies = nextPlies;
                }
            } else {
                insert(data, node.getLeft(), nextPlies);
            }
        } else {
            if (!isNodeValid(node.getRight())) {
                node.setRight(new Node<>(data));
                if (plies < nextPlies) {
                    plies = nextPlies;
                }
            } else {
                insert(data, node.getRight(), nextPlies);
            }
        }
    }

    public List<Node<T>> find(T data) {
        if (data == null) {
            return null;
        }
        ArrayList<Node<T>> list = new ArrayList<>();
        find(data, root, list);
        return list;
    }

    private void find(T data, Node<T> node, List<Node<T>> list) {
        if (!isNodeValid(node)) {
            return;
        }
        int compare = data.compareTo(node.getValue());
        if (compare < 0) {
            find(data, node.getLeft(), list);
        } else if (compare == 0) {
            list.add(node);
            find(data, node.getRight(), list);
        } else {
            find(data, node.getRight(), list);
        }
    }

    public void delete(T data) {
        if (data == null) {
            return;
        }
        root = delete(data, root);
    }

    private Node<T> delete(T data, Node<T> node) {
        System.out.println(node);
        if (!isNodeValid(node)) {
            return null;
        }
        int compare = data.compareTo(node.getValue());
        if (compare < 0) {
            node.setLeft(delete(data, node.getLeft()));
        } else if (compare > 0){
            node.setRight(delete(data, node.getRight()));
        } else {
            if (!isNodeValid(node.getLeft()) && !isNodeValid(node.getRight())) {
                // 下面没有节点, 直接删除这个节点
                return null;
            } else if (isNodeValid(node.getLeft()) && isNodeValid(node.getRight())){
                node.setLeft(delete(data, node.getLeft()));
                node.setRight(delete(data, node.getRight()));
                // 下面有两个节点, 找到右子树的最小节点, 替换当前节点
                Node<T> minNode = node.getRight();
                Node<T> minParentNode = node.getRight();
                while (isNodeValid(minNode)) {
                    if (isNodeValid(minNode.getLeft())) {
                        minParentNode = minNode;
                        minNode = minNode.getLeft();
                    } else if (isNodeValid(minNode.getRight())) {
                        minParentNode = minNode;
                        minNode = minNode.getRight();
                    } else {
                        break;
                    }
                }
                if (minParentNode.getLeft() != null && minParentNode.getLeft().getValue().compareTo(minNode.getValue()) == 0) {
                    minParentNode.setLeft(null);
                } else if (minParentNode.getRight() != null && minParentNode.getRight().getValue().compareTo(minNode.getValue()) == 0) {
                    minParentNode.setRight(null);
                }
                minNode.setLeft(node.getLeft());
                minNode.setRight(node.getRight());
                return minNode;
            } else {
                Node<T> notNullNode;
                // 下面只有一个节点, 返回那个非空节点, 并继续探测这个非空节点
                if (isNodeValid(node.getLeft())) {
                    notNullNode =  node.getLeft();
                } else {
                    notNullNode =  node.getRight();
                }
                notNullNode = delete(data, notNullNode);
                return notNullNode;
            }
        }
        return node;
    }

    private boolean isNodeValid(Node node) {
        if (node != null && node.getValue() != null) {
            return true;
        }
        return false;
    }
}
