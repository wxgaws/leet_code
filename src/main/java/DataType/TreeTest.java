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

    public void preOrderTranverse(ListNode<String> root) {
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

    public void preOrderTranverseReverse(ListNode<String> root) {
        System.out.println("先根遍历-递归");
        _preOrderTranverseReverse(root);
        System.out.printf("\n");

    }

    public void _preOrderTranverseReverse(ListNode<String> root) {
        if (root == null) {
            System.out.printf("^");
            return;
        }
        System.out.printf(root.val);
        _preOrderTranverseReverse(root.left);
        _preOrderTranverseReverse(root.right);
    }

    public static void main(String[] args) {

        TreeTest tree = new TreeTest();
        ListNode<String> root = tree.create();
        tree.preOrderTranverse(root);
        tree.preOrderTranverseReverse(root);

        ListNode<String> root2 = null;
        tree.preOrderTranverse(root2);
        tree.preOrderTranverseReverse(root2);

    }

}
