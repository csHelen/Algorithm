package array;

/**
 * @program: algorithm
 * @ClassName QueueTest
 * @description:
 * @author: 许
 * @create: 2020-04-13 00:02
 * @Version 1.0
 **/

import java.util.Scanner;

/**
 * 队列:可用 数组 或 链表 来实现
 *  先进先出，后进后出
 */
public class QueueTest {

    //数组实现的队列
    static class ArrayQueue{
        private int maxSize;    //数组最大容量
        private int front;      //队列头
        private int rear;       //队列尾
        private int[] arr;      //模拟队列

        public ArrayQueue(int maxQueueSize){
            this.maxSize = maxQueueSize;
            this.arr = new int[maxSize];
            this.front = 0;    //指向队列的第一个元素
            this.rear = 0;     //指向队列的队列尾的 后 一个位置 所以设置maxSize要+1
        }

        public boolean isFull(){
//            return rear == maxSize - 1;
            return (rear + 1) % maxSize == front;
        }

        public boolean isEmpty(){
            return rear == front;
        }

        public void addQueue(int n){
            if (isFull()) {
                System.out.println("队列已满");
                return;
            }
            arr[rear] = n;
            rear = (rear +1) % maxSize;


        }

        public int get(){
            if (isEmpty()) {
                System.out.println("队列为空");
                throw new RuntimeException("队列为空，不能取数据");
            }
            int value = arr[front];
            front = (front + 1) % maxSize;
            return value;
        }

        public void show(){
            if (isEmpty()) {
                System.out.println("队列为空");
                return;
            }
            for (int i = front; i < front + size(); i++) {
                System.out.printf("arr[%d]====%d\n",i%maxSize,arr[i%maxSize]);
            }
        }
        //显示队列头数据，不取出
        public int headQueue(){
            if (isEmpty()) {
                System.out.println("队列为空");
                throw new RuntimeException("队列为空");
            }
            return arr[front];
        }

        public int size(){
            return (rear + maxSize - front) % maxSize;
        }

    }


    //链表节点
    static class HeroNode{
        public String data;
        public HeroNode next;
        public HeroNode(String ndata){
            data = ndata;
        }
    }

    public static void show(HeroNode head){

        if (head.next == null) {
            return;
        }
        HeroNode temp = head.next;
        while(true){
            System.out.println(temp.data);
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
    }

    public static void reverseShow(HeroNode temp){
        if (temp == null) {
            return;
        }
        String data = temp.data;
        reverseShow(temp.next);
        if (data!=null) {
            System.out.println(data);
        }

    }

    public static void main(String[] args) {
        HeroNode head = new HeroNode(null);
        head.next = new HeroNode("a");
        head.next.next = new HeroNode("b");
        head.next.next.next = new HeroNode("c");
        reverseShow(head);


//        ArrayQueue arrayQueue = new ArrayQueue(4);
//        char key = ' ';
//        Scanner scanner = new Scanner(System.in);
//        boolean loop = true;
//        while(loop){
//            System.out.println("s(show):显示队列");
//            System.out.println("e(exit):退出程序");
//            System.out.println("a(add):添加数据到队列");
//            System.out.println("g(get):从队列取出数据");
//            System.out.println("h(head):查看队列头数据");
//            key = scanner.next().charAt(0);
//            switch (key){
//                case 's':
//                    arrayQueue.show();
//                    break;
//                case 'e':
//                   scanner.close();
//                   loop = false;
//                   break;
//                case 'a':
//                    System.out.println("请输入数字：");
//                    int value = scanner.nextInt();
//                    arrayQueue.addQueue(value);
//                    break;
//                case 'g':
//                    try {
//                        System.out.println("取出的数据是："+arrayQueue.get());
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    break;
//                case 'h':
//                    try {
//                        System.out.println("队列头数据为 "+arrayQueue.headQueue());
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    break;
//            }
//        }


    }

}
