package Btap_duyetThuTuPostorder;

public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }
}
