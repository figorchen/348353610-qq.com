package com.ck.test.tree;

/**
 * 类    名: TreeMain </br>
 * 创建时间: 2020/4/17 </br>
 * 类 描 述: </br>
 * 版   本: 1.0.0 </br>
 *
 * @author : 谌珂 </br>
 */
public class TreeMain {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
//        Integer[] a = new Integer[]{33, 16, 50, 13, 18, 34, 58, 15,17,25,51,66,19,27,55, };
        Integer[] a = new Integer[]{13,8,18,6,10,16,20,18,19};
        for (Integer integer :
                a) {
            binarySearchTree.insert(integer);
        }
        binarySearchTree.delete(18);

        System.out.println("树节点数:" + binarySearchTree.getSize());

        System.out.println("树层数: " + binarySearchTree.getPlies());

        System.out.println("前序遍历结果: " + binarySearchTree.preOrder());
        System.out.println("中序遍历结果: " + binarySearchTree.inOrder());
        System.out.println("后序遍历结果: " + binarySearchTree.postOrder());


    }
}
