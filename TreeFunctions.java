import java.util.ArrayList;

/**
 * contains the tree methods created for the tasks
 * @author: Arkadiusz Trojanowski
 */
public class TreeFunctions
{
    /** 
     * a method for capturing an exception and parsing the arguments forward
     * @param value the value of a desired node
     * @param parent the parent node
     * @return a Leaf object, if the exception is thrown then it's null
     */
    public static Leaf createLeaf(int value, Node parent)
    {
        try
        {
            return Leaf.createLeaf(value, parent);
        }
        catch(BinaryTreeException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * a recursive method for finding nodes without children
     * @param node the checked node
     * @param nodes the actual array of nodes without children
     */
    private static void ccn(Node node, ArrayList<Node> nodes)
    {
        if(node.getLeaves().size() == 0)
            nodes.add(node);
        if(node.getLeaves().size() >= 1)
            ccn(node.getLeaves().get(0), nodes);
        if(node.getLeaves().size() == 2)
            ccn(node.getLeaves().get(1), nodes);
    }
    /**
     * an initiating method for finding nodes without children
     * @param start the starting node
     * @return an integer count of nodes without children
     */
    public static int calculateChildrenlessNodes(Node start)
    {
        ArrayList<Node> nodes = new ArrayList<>();

        ccn(start, nodes);

        System.out.println(nodes);

        return nodes.size();
    }

    /**
     * a recursive method for finding the longest path between nodes
     * @param node the examined node
     * @param nodes the actual array of nodes on the longest path
     */
    private static void clp(Node node, ArrayList<Node> nodes)
    {
        if(node.getLeaves().size() == 1)
            clp(node.getLeaves().get(0), nodes);
        else if(node.getLeaves().size() == 2)
        {
            ArrayList<Node> n1 = new ArrayList<>();
            ArrayList<Node> n2 = new ArrayList<>();
            clp(node.getLeaves().get(1), n1);
            clp(node.getLeaves().get(1), n2);
            if(n1.size() > n2.size())
                nodes.addAll(n1);
            else nodes.addAll(n2);
        }

        nodes.add(node);
    }
    /**
     * an initiating method for finding the one of the longest paths on the three from the root node
     * @param start the starting node
     * @return an integer length of the longest path
     */
    public static int calculateLongestPath(Node start)
    {
        ArrayList<Node> nodes = new ArrayList<>();

        clp(start, nodes);

        for(int i = nodes.size() - 1; i > 0; --i)
            System.out.print(nodes.get(i) + " -> ");
        if(nodes.size() > 0)
            System.out.println(nodes.get(0));

        return nodes.size();
    }

    /**
     * a recursive method for copying values of the leaves
     * @param node1 a copy of the node
     * @param node an original node
     */
    private static void copyLeaf(Node node1, Node node)
    {
        for(var l : node.getLeaves())
        {
            Leaf leaf = createLeaf(l.getValue(), node1);
            copyLeaf(leaf, l);
        }
    }
    /**
     * an initiating method for copying the whole tree 
     * @param root the root node
     * @return a Node object of the root of the copied tree
     */
    public static Node copyTree(Node root)
    {
        Node root1 = new Node(root.getValue());
        
        copyLeaf(root1, root);

        return root1;
    }
}