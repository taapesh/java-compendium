import java.util.ArrayList;

// Basic tree implementation, can wrap this in a Tree class, but not necessary
public class TreeNode {
    public String name;
    public ArrayList<TreeNode> children;
    public int value;

    public TreeNode(int value) {
        this.value = value;
        children = new ArrayList<>();
    }

    public void addChild(TreeNode node) {
        children.add(node);
    }

    public void removeChild(TreeNode node) {
        children.remove(node);
    }
}
