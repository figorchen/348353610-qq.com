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
        Tree<Integer> tree = new Tree<>();
//        Integer[] a = new Integer[]{33, 16, 50, 13, 18, 34, 58, 15,17,25,51,66,19,27,55, };
        Integer[] a = new Integer[]{13,8,18,6,10,16,20,18,19};
        for (Integer integer :
                a) {
            tree.insert(integer);
        }
        tree.delete(18);

        System.out.println("树节点数:" + tree.getSize());

        System.out.println("树层数: " + tree.getPlies());

        System.out.println("前序遍历结果: " + tree.preOrder());
        System.out.println("中序遍历结果: " + tree.inOrder());
        System.out.println("后序遍历结果: " + tree.postOrder());


    }
}
