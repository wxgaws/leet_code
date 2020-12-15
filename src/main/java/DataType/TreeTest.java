package DataType;

import java.util.*;

public class TreeTest {
    public class ListNode<T> {
        T val;
        ListNode<T> left, right;

        ListNode(T val) {
            this.val = val;
        }
    }

    public ListNode create() {
        ListNode<String> nodeA = new ListNode<>("A");
        ListNode<String> nodeB = new ListNode<>("B");
        ListNode<String> nodeC = new ListNode<>("C");
        ListNode<String> nodeD = new ListNode<>("D");
        ListNode<String> nodeE = new ListNode<>("E");
        ListNode<String> nodeF = new ListNode<>("F");
        ListNode<String> nodeG = new ListNode<>("G");
        ListNode<String> nodeH = new ListNode<>("H");
        nodeA.left = nodeB;
        nodeA.right = nodeC;
        nodeB.left = nodeD;
        nodeD.right = nodeG;
        nodeC.left = nodeE;
        nodeC.right = nodeF;
        nodeF.left = nodeH;
        return nodeA;
    }

    public void preOrderTraverse(ListNode<String> root) {
        System.out.println("先根遍历-非递归");
        Stack<ListNode<String>> stack = new Stack<>();
        ListNode<String> p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                System.out.printf(p.val);
                stack.push(p);
//                //debug
//                System.out.println("stack=" + stackToString(stack) + ", " + p.val + ", p_out=" + ((p.left != null) ? p.left.val : "^"));
                p = p.left;
            } else {
                System.out.printf("^");
                p = stack.pop();
                p = p.right;
//                //debug
//                System.out.println("stack=" + stackToString(stack) + ", ^" + ", p_out=" + ((p != null) ? p.val : "^"));
            }
        }

        //没有本句，无法输出空树、最后一个空右结点
        System.out.printf("^\n");

    }

    public String stackToString(Stack<ListNode<String>> stack) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < stack.size(); i++) {
            list.add(stack.get(i).val);
        }
        return list.toString();
    }

    public void preOrderTraverseReverse(ListNode<String> root) {
        System.out.println("先根遍历-递归");
        _preOrderTraverseReverse(root);
        System.out.printf("\n");

    }

    public void _preOrderTraverseReverse(ListNode<String> root) {
        if (root == null) {
            System.out.printf("^");
            return;
        }
        System.out.printf(root.val);
        _preOrderTraverseReverse(root.left);
        _preOrderTraverseReverse(root.right);
    }

    public void inOrderTraverse(ListNode<String> root) {
        System.out.println("中根遍历-非递归");
        Stack<ListNode<String>> stack = new Stack<>();
        ListNode<String> p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
//                //debug
//                System.out.println("stack=" + stackToString(stack) + ", " + p.val + ", p_out=" + ((p.left != null) ? p.left.val : "^"));
                p = p.left;
            } else {
                System.out.printf("^");
                p = stack.pop();
                System.out.printf(p.val);
                p = p.right;
//                //debug
//                System.out.println("stack=" + stackToString(stack) + ", ^" + ", p_out=" + ((p != null) ? p.val : "^"));
            }
        }

        //没有本句，无法输出空树、最后一个空右结点
        System.out.printf("^\n");
    }

    public void inOrderTraverseReverse(ListNode<String> root) {
        System.out.println("中根遍历-递归");
        _inOrderTraverseReverse(root);
        System.out.printf("\n");

    }

    public void _inOrderTraverseReverse(ListNode<String> root) {
        if (root == null) {
            System.out.printf("^");
            return;
        }
        _inOrderTraverseReverse(root.left);
        System.out.printf(root.val);
        _inOrderTraverseReverse(root.right);
    }

    public void postOrderTraverse(ListNode<String> root) {
        System.out.println("后根遍历-非递归");
        Stack<ListNode<String>> stack = new Stack<>();
        ListNode<String> p = root;
        ListNode<String> pre = null;//用来判断是否从右子树回到该结点
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
//                //debug
//                System.out.println("stack=" + stackToString(stack) + ", " + p.val + ", p_out=" + ((p.left != null) ? p.left.val : "^"));
//                pre = p;//若注释，不影响结果
                p = p.left;
            } else {
                p = stack.peek();
                if (p.left == null && p.right != pre) System.out.printf("^");//从左子树过来的

                //右子树非空，且没有访问过
                if (p.right != null && p.right != pre) {
                    pre = p;//若注释，无法正确输出^
                    p = p.right;
                } else {
                    if (p.right == null) System.out.printf("#");
                    System.out.printf(p.val);
                    pre = p;//若注释，无限循环
                    stack.pop();
                    p = null;

                }

            }


            //debug
//            System.out.println("stack=" + stackToString(stack) + ", ^" + ", p_out=" + ((p != null) ? p.val : "^") + ", pre_out=" + ((pre != null) ? pre.val : "^"));

        }

        //没有本句，无法输出空树、最后一个空右结点
        System.out.printf("\n");
    }

    public void postOrderTraverseReverse(ListNode<String> root) {
        System.out.println("后根遍历-递归");
        _postOrderTraverseReverse(root, "^");
        System.out.printf("\n");

    }

    public void _postOrderTraverseReverse(ListNode<String> root, String tag) {
        if (root == null) {
            System.out.printf(tag);
            return;
        }
        _postOrderTraverseReverse(root.left, "^");
        _postOrderTraverseReverse(root.right, "#");
        System.out.printf(root.val);
    }

    public void preOrderTraverse2(ListNode<String> root) {
        Stack<ListNode<String>> stack = new Stack<>();
        stack.push(root);
        ListNode<String> cur;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (cur != null) {
                if (cur.right != null) stack.push(cur.right);//右
                if (cur.left != null) stack.push(cur.left);//左
                stack.push(cur);//中
                stack.push(null);
            } else {
                cur = stack.pop();
                System.out.printf(cur.val);
            }
        }

        System.out.printf("\n");

    }


    public void inOrderTraverse2(ListNode<String> root) {
        Stack<ListNode<String>> stack = new Stack<>();
        stack.push(root);
        ListNode<String> cur;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (cur != null) {
                if (cur.right != null) stack.push(cur.right);//右
                stack.push(cur);//中
                stack.push(null);
                if (cur.left != null) stack.push(cur.left);//左
            } else {
                cur = stack.pop();
                System.out.printf(cur.val);
            }
        }

        System.out.printf("\n");

    }


    public void postOrderTraverse2(ListNode<String> root) {
        Stack<ListNode<String>> stack = new Stack<>();
        stack.push(root);
        ListNode<String> cur;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (cur != null) {
                stack.push(cur);//中
                stack.push(null);
                if (cur.right != null) stack.push(cur.right);//右
                if (cur.left != null) stack.push(cur.left);//左
            } else {
                cur = stack.pop();
                System.out.printf(cur.val);
            }
        }

        System.out.printf("\n");

    }


    public static void main(String[] args) {
        TreeTest tree = new TreeTest();
        ListNode<String> root = tree.create();
//        tree.preOrderTraverse(root);
//        tree.preOrderTraverse2(root);
//        tree.preOrderTraverseReverse(root);
//        tree.inOrderTraverse(root);
//        tree.inOrderTraverse2(root);
//        tree.inOrderTraverseReverse(root);
        tree.postOrderTraverse(root);
        tree.postOrderTraverse2(root);
        tree.postOrderTraverseReverse(root);


        ListNode<String> root2 = null;
//        tree.preOrderTraverse(root2);
//        tree.preOrderTraverseReverse(root2);

    }

}
