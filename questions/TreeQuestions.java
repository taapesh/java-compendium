import java.util.Stack;
import java.util.TreeMap;

public class TreeQuestions {

    // TreeMap differs from HashMap in that the elements are sorted
    // according to the natural order of the keys.
    public static TreeMap<String, Integer> createIdMap(String[] names) {
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
        int id = 0;
        for (String name: names) {
            treeMap.put(name, id++);
        }
        // TreeMap returned will be sorted by name
        return treeMap;
    }

    // To get different traversal orders, change when the pop occurs.
    // Can continue down the left branch and push nodes onto the stack
    // and only pop when there is no more nodes left in branch.
    public static void traverseBinaryTree(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode currentNode = root;

        while (currentNode == null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            if (currentNode == null && !stack.isEmpty()) {
                BinaryTreeNode n = stack.pop();
                // Visit the node
                currentNode = n.right;
            }
        }
    }

    // Given a sorted array of unique integer elements,
    // write an algorithm to produce a binary search tree
    // with minimal depth
    public static BinaryTreeNode minimalBST(int[] a) {
        return minimalBST(a, 0, a.length - 1);
    }

    public static BinaryTreeNode minimalBST(int[] a, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        BinaryTreeNode n = new BinaryTreeNode(a[mid]);
        n.left = minimalBST(a, start, mid - 1);
        n.right = minimalBST(a, mid + 1, end);
        return n;
    }

    public static void main(String[] args) {

    }
}
