package BinaryTree;

/**
 * @program: algorithm
 * @ClassName BalancedBinaryTree
 * @description:
 * @author: 许
 * @create: 2020-04-16 03:28
 * @Version 1.0
 **/

/**
 * 平衡二叉树AVL树  :  未完待续！
 *     1
 *       2
 *         3
 *           4
 *             5
 *                6
 *     这样的二叉排序树尴尬不？
 *     需要平衡！！！
 *
 *     平衡二叉树：高度差不超过1的二叉排序树 （左右旋转....）
 */
public class BalancedBinaryTree {

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        avlTree.root = new bNode(4);
        avlTree.addNode(3);
        avlTree.addNode(6);
        avlTree.addNode(5);
        avlTree.addNode(7);
        avlTree.addNode(8);
        avlTree.addNode(9);
        avlTree.addNode(2);
        avlTree.addNode(1);

        bNode root = avlTree.root;
        root.infixOrder();

        System.out.println();
//        root.leftRotate();
        root.infixOrder();
//        System.out.println(root.height());
//        System.out.println(root.leftHeight());
//        System.out.println(root.rightHeight());
    }


}
class AVLTree{
    bNode root;
    public void addNode(int value){
        addNode(root,value);
    }
    public void isNeedRote(){
        int leftHeight = root.leftHeight();
        int rightHeight = root.rightHeight();
        if(leftHeight - rightHeight >1 || rightHeight - leftHeight >1){
            System.out.println("需要转向");
        }
    }

    public void addNode(bNode node,int value){
        if (node == null) {
            node = new bNode(value);
        }else{
            //如果小于root的值，放在左边
            if(value < node.value){

                if (node.left == null) {
                    node.left = new bNode(value);

                    isNeedRote();

                }else{
                    addNode(node.left,value);
                }

            }else{
                if (node.right == null) {
                    node.right = new bNode(value);

                    isNeedRote();

                }else{
                    addNode(node.right,value);
                }
            }
        }
    }
}
class bNode{
    int value;
    bNode left;
    bNode right;

    @Override
    public String toString() {
        return "bNode{" +
                "value=" + value +
                '}';
    }
//        avlTree.addNode(3);
//        avlTree.addNode(6);
//        avlTree.addNode(5);
//        avlTree.addNode(7);
//        avlTree.addNode(8);
//        avlTree.addNode(9);
//        avlTree.addNode(2);
//        avlTree.addNode(1);
    /**
     *                       4
     *                  3           6
     *                         5        7
     *                                       8
     */
    public void leftRotate(){
        bNode node = new bNode(value);
        node.left = left;
        node.right = right.left;
        value = right.value;
        right = right.right;
        left = node;
    }

    public int leftHeight(){
        if (left == null) {
            return 0;
        }
        return left.height();
    }
    public int rightHeight(){
        if (right == null) {
            return 0;
        }
        return right.height();
    }
    public int height(){
        return Math.max(left == null ? 0 : left.height(),right == null ? 0 : right.height() )+1;
    }

    public bNode(int value) {
        this.value = value;
    }

    public void infixOrder(){
        if (this == null) {
            return;
        }
        if(this.left != null){
            this.left.infixOrder();;
        }
        System.out.printf(this.value+" ");
        if(this.right != null){
            this.right.infixOrder();;
        }

    }

}
