package BinaryTree;

/**
 * @program: algorithm
 * @ClassName BinarySortTree
 * @description:
 * @author: 许
 * @create: 2020-04-16 01:04
 * @Version 1.0
 **/


/**
 * 二叉排序树
 *
 *      A                     3
 *    B  C     C>B>A       1     5
 *    相同放左右都行
 *
 *    数组  7   3   10  12  5  1  9
 *
 *                   7
 *             6            11
 *          3      5     9     12
 *       2   1   4        10
 *
 *          中序遍历即可得到结果
 *
 */
public class BinarySortTree {

    public static void main(String[] args) {
        int arr[] = {7,6,10,3,5,9,12,2,1,4,11};
        BSTree bsTree = new BSTree();
        bsTree.root = new sNode(arr[0]);
        createBinarySortTree(arr,bsTree.root);

        infixOrder(bsTree.root);
        bsTree.delNode(7);
        System.out.println();
        infixOrder(bsTree.root);
    }
    /**
     *  删除节点
     *      1、删除叶子结点，直接删除
     *      2、删除节点有一颗子树
     *      3、删除节点有两颗子树
     */



    public static sNode createBinarySortTree(int arr[],sNode root){
        for (int i = 1; i < arr.length; i++) {
                insert(root,arr[i]);
        }
        return root;
    }
    //中序遍历
    public static void infixOrder(sNode node){
        if (node == null) {
            return;
        }
        if (node.left != null) {
            infixOrder(node.left);
        }
        System.out.printf(node.value+" ");
        if (node.right != null) {
            infixOrder(node.right);
        }
    }

    public static void insert(sNode node, int value){
        //小于节点，应该插入左边
        if (value < node.value){
            //如果没有节点，则可以直接插入
            if (node.left == null) {
                node.left = new sNode(value);
                return;
            }else{
                //递归循环左节点
                insert(node.left,value);
            }
        }else{
            //大于或等于节点，插入右边
            if (node.right == null) {
                node.right = new sNode(value);
                return;
            }else{
                insert(node.right,value);
            }
        }

    }
}

class BSTree{
    sNode root;

    /**
     * @param node   传入的节点（当做二叉排序树的根节点）
     * @return      返回的以node为根节点的二叉排序树的最小节点的值
     */
    public int delRightTreeMin(sNode node){
        sNode target = node;
        while(target.left !=null){
            target = target.left;
        }
        delNode(target.value);
        return target.value;
    }

    public void delNode(int value){
        if (root == null) {
            return;
        }else{
            sNode node = search(value);
            if (node == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            sNode parent =  searchParent(value);
            //删除节点为叶子节点
            if (node.left == null && node.right == null) {
                if (parent.left != null && parent.left.value == node.value) {
                    parent.left = null;
                }else if(parent.right != null && parent.right.value == node.value){
                    parent.right = null;
                }
            }else if(node.left != null && node.right != null){
                //两颗子树
                int minVal = delRightTreeMin(node.right);
                node.value = minVal;
            }else{
                //一颗子树
                //要删除的节点有左节点
                //节点的左节点 < 要删除的节点
                if(node.left != null){
                    if (parent!=null) {

                        //是parent的左子树: node.value<parent.value
                        if (parent.left.value == value) {
                            parent.left = node.left;
                        }else{
                            //是parent的右子树: node.value>parent.value
                            parent.right = node.left;
                        }
                    }else{
                        root = node.left;
                    }
                }else{
                    if (parent!=null) {
                        //要删除的节点有右节点
                        //节点的左节点 > 要删除的节点
                        //是parent的左子树: node.value<parent.value
                        if (parent.left.value == value) {
                            parent.left = node.right;
                        }else{
                            //是parent的右子树: node.value>parent.value
                            parent.right = node.right;
                        }
                    }else{
                        root = node.right;
                    }
                }
            }
        }
    }

    public sNode search(int value){
        if (root == null) {
            return null;
        }else{
            return root.search(value);
        }
    }

    public sNode searchParent(int value){
        if (root == null) {
            return null;
        }else{
            return root.searchParent(value);
        }
    }
}

class sNode{
    int value;
    sNode left;
    sNode right;

    @Override
    public String toString() {
        return "sNode{" +
                "value=" + value +
                '}';
    }
    public sNode search(int value){
        if (value == this.value) {
            return this;
        }else if(value < this.value){
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        }else{
            if (this.right==null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    public sNode searchParent(int value){
        if( this.left != null && this.left.value == value ||
                this.right != null && this.right.value == value ){
            return this;
        }else{
            //头结点
            if(value < this.value && this.left != null){
                return this.left.searchParent(value);
            }else if(value >= this.value && this.right != null){
                return this.right.searchParent(value);
            }else{
                //没有父节点
                return null;
            }
        }

    }

    public sNode(int value) {
        this.value = value;
    }
}
