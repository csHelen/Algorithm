package BinaryTree;

/**
 * @program: algorithm
 * @ClassName BinaryTreeTest
 * @description:
 * @author: 许
 * @create: 2020-04-15 02:58
 * @Version 1.0
 **/
public class BinaryTreeTest {

//    public static void main(String[] args) {
//        BinaryTree binaryTree = new BinaryTree();
//        HeroNode h1 = new HeroNode(1, "长江");
//        HeroNode h2 = new HeroNode(2, "松花江");
//        HeroNode h3 = new HeroNode(3, "黑龙江");
//        HeroNode h4 = new HeroNode(4, "黄河");
//        HeroNode h5 = new HeroNode(5, "尼罗河");
//
//        binaryTree.root = h1;
//        h1.left = h2;
//        h1.right = h3;
//        h3.right = h4;
//        h3.left = h5;
//        /**
//         *              h1
//         *           h2       h3
//         *                 h5    h4
//         */
//
////
//        binaryTree.preOrder();
////        binaryTree.infixOrder();
////        binaryTree.postOrder();
//        binaryTree.delete(1);
//        System.out.println();
//        binaryTree.preOrder();
//    }
//
//}
//
//class BinaryTree {
//    HeroNode root;
//
//    public void delete(int no){
//        if (root != null) {
//            if (root.no == no) {
//                root = null;
//            }else{
//                root.delete(no);
//            }
//        }else{
//            System.out.println("树为空");
//        }
//    }
//
//    public void preOrder() {
//        if (root != null) {
//            root.preOrder();
//        } else {
//            System.out.println("空二叉树");
//        }
//    }
//
//    public HeroNode preOrderSearch(int no){
//        if (root != null) {
//            return root.preOrderSearch(no);
//        }else{
//            return null;
//        }
//    }
//
//    public void infixOrder() {
//        if (root != null) {
//            root.infixOrder();
//        } else {
//            System.out.println("空二叉树");
//        }
//    }
//    public HeroNode infixOrderSearch(int no){
//        if (root != null) {
//            return root.infixOrderSearch(no);
//        }else{
//            return null;
//        }
//    }
//
//    public void postOrder() {
//        if (root != null) {
//            root.postOrder();
//        } else {
//            System.out.println("空二叉树");
//        }
//    }
//    public HeroNode postOrderSearch(int no){
//        if (root != null) {
//            return root.postOrderSearch(no);
//        }else{
//            return null;
//        }
//    }
//}
//
//class HeroNode {
//    int no;
//    String name;
//    HeroNode left;
//    HeroNode right;
//
//    public HeroNode(int no, String name) {
//        this.no = no;
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return "HeroNode{" +
//                "no=" + no +
//                ", name='" + name + '\'' +
//                '}';
//    }
//
//    public void delete(int no){
//        /**
//         *
//         */
//
//        if (this.left != null && this.left.no == no) {
//            this.left = null;
//        }
//        if (this.right != null && this.right.no == no) {
//            this.right = null;
//        }
//        if (this.left !=null) {
//            this.left.delete(no);
//        }
//        if (this.right !=null) {
//            this.right.delete(no);
//        }
//    }
//
//
//    //前序遍历
//    public void preOrder() {
//        System.out.println(this);
//        if (this.left != null) {
//            this.left.preOrder();
//        }
//        if (this.right != null) {
//            this.right.preOrder();
//        }
//    }
//
//    public HeroNode preOrderSearch(int no) {
//        if (this.no == no) {
//            return this;
//        }
//        HeroNode heroNode = null;
//        if (this.left != null) {
//            heroNode = this.left.preOrderSearch(no);
//        }
//        if (heroNode != null) {
//            return heroNode;
//        }
//        if (this.right != null) {
//            heroNode = this.right.preOrderSearch(no);
//        }
//        return heroNode;
//    }
//
//    //中序遍历
//    public void infixOrder() {
//
//        if (this.left != null) {
//            this.left.infixOrder();
//        }
//        System.out.println(this);
//        if (this.right != null) {
//            this.right.infixOrder();
//        }
//    }
//    public HeroNode infixOrderSearch(int no){
//        HeroNode heroNode = null;
//        if (this.left != null) {
//            heroNode = this.left.infixOrderSearch(no);
//        }
//        if (heroNode != null) {
//            return heroNode;
//        }
//        if(this.no == no){
//            return this;
//        }
//
//        if (this.right != null) {
//            heroNode = this.right.infixOrderSearch(no);
//        }
//        return heroNode;
//    }
//
//    //后序遍历
//    public void postOrder() {
//        if (this.left != null) {
//            this.left.postOrder();
//        }
//        if (this.right != null) {
//            this.right.postOrder();
//        }
//        System.out.println(this);
//    }
//    public HeroNode postOrderSearch(int no){
//        HeroNode heroNode = null;
//        if (this.left != null) {
//            heroNode = this.left.postOrderSearch(no);
//        }
//        if (heroNode != null) {
//            return heroNode;
//        }
//        if (this.right != null) {
//            heroNode = this.right.postOrderSearch(no);
//        }
//        if (heroNode != null) {
//            return heroNode;
//        }
//        if(this.no == no){
//            return this;
//        }
//        return heroNode;
//    }

}
