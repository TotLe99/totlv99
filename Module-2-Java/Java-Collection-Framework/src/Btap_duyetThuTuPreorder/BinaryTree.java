package Btap_duyetThuTuPreorder;

import Btap_XoaTrongTree.BinaryDeleteTree;

public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);

    }
}
