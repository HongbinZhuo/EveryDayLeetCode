package MKP;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {

        ArrayStack stack = new ArrayStack(4);
        boolean flag = true;
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            System.out.println("根据提示使用栈的功能：");
            System.out.println("push:向栈中添加数据");
            System.out.println("pop:从栈中弹出数据");
            System.out.println("list:显示栈中所有数据");
            System.out.println("exit:退出程序");

            key = scanner.next();
//			key = scanner.nextLine();    //区别：next()在读取到空白符的时候结结束；nextLine()在读取到回车时结束
//		 								该处如果使用nextLine()，当调用“push”时，因为nextInt()读取到空白符前的数据时结束了，然后把回车“\r”留给了nextLine();所以会出问题。
            switch (key) {
                case "push":
                    System.out.println("请输入想要添加的数：");
                    int num = scanner.nextInt();
                    try {
                        stack.push(num);
                        System.out.println("添加成功~");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "pop":
                    try {
                        System.out.println("当前栈顶元素为：" + stack.pop());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "list":
                    try {
                        stack.list();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    flag = false;
                    scanner.close();
                    break;

                default:
                    break;
            }
        }
        System.out.println("已退出程序~");
    }
}

class ArrayStack {

    private int maxSize;
    private int arr[];
    private int top;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        top = -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int num) {
//	public void push(int num) throws Exception{      这样写的话在方法调用时必须手动捕捉异常
        if (isFull()) {
            System.out.println("栈满，" + num + "插入失败");
        }
        arr[++top] = num;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，pop失败");
        }
        int value = arr[top--];
        return value;
    }

    public void list() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        for (int i = top; i > -1; i--) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }
}

