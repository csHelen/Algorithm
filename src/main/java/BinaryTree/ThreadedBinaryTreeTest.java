package BinaryTree;

/**
 * @program: algorithm
 * @ClassName ThreadedBinaryTreeTest
 * @description:
 * @author: 许
 * @create: 2020-04-15 11:57
 * @Version 1.0
 **/

/**
 * 线索二叉树
 *      其实就是二叉树 -指针的有效利用
 *          为了方便遍历 前序 中序 后序
 *          而构建的拥有 前驱后续 指针的二叉树
 *          所以可以构建出 三个线索二叉树
 */
public class ThreadedBinaryTreeTest {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode h1 = new HeroNode(1,"1");
        HeroNode h3 = new HeroNode(3,"3");
        HeroNode h6 = new HeroNode(6,"6");
        HeroNode h8 = new HeroNode(8,"8");
        HeroNode h10 = new HeroNode(10,"10");
        HeroNode h14 = new HeroNode(14,"14");
        /**
         *                1
         *           3         6
         *        8    10    14
         */
        binaryTree.root = h1;
        h1.left = h3;
        h1.right = h6;
        h3.left = h8;
        h3.right = h10;
        h6.left = h14;

        //编写中序线索化方法-
        //之后遍历都会采用中序遍历的方式输出
        binaryTree.threadedNodes();
        binaryTree.threadedList();

    }

}
class BinaryTree {
    HeroNode root;
    HeroNode pre = null;
    public void threadedNodes(){
        threadedNodes(root);
    }
    //遍历  中序线索二叉树
    public void threadedList(){
        HeroNode node = root;
        while (node != null) {
            while (node.leftType == 0) {
                node = node.left;
            }
            System.out.println(node);
            while (node.rightType == 1) {
                node = node.right;
                System.out.println(node);
            }

            //替换遍历这个遍历的节点
            node = node.right;
        }

    }

    //编写中序线索化方法-
    public void threadedNodes(HeroNode node){
        if (node == null) {
            return;
        }
        //中序线索化步骤
        //先线索化左子树 - 当前 - 右子树
        threadedNodes(node.left);

        //处理当前节点的前驱节点
        if (node.left == null) {
            //让当前节点的左指针指向前驱节点
            node.left = pre;
            node.leftType = 1;
        }
        //处理当前节点的后继节点
        if (pre!=null && pre.right == null) {
            pre.right = node;
            pre.rightType = 1;
        }
        //！！！每处理一个节点后，让当前节点是下一个节点的前驱节点
        pre = node;

        threadedNodes(node.right);

    }


}
class HeroNode {
    int no;
    String name;
    HeroNode left;
    HeroNode right;
    int leftType;   //0:指向左子树，1：指向前驱
    int rightType;  //0：指向右子树 1：后继节点

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}