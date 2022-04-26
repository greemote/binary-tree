import java.util.ArrayList;

/**
 * a Node class containing the value and the array of its object's leaves
 * @author Arkadiusz Trojanowski
 */
public class Node
{
    protected Integer value;
    protected ArrayList<Node> leaves;

    /**
     * a constructor that assigns the value of the node and allocates an empty array of leaves
     * @param value the new value
     */
    public Node(int value)
    {
        this.value = Integer.valueOf(value);
        leaves = new ArrayList<>();
    }

    /**
     * a value getter
     * @return the integer value of the node
     */
    public int getValue()
    {
        return value.intValue();
    }
    /**
     * a leaves array getter
     * @return a reference to the leaves array
     */
    public ArrayList<Node> getLeaves()
    {
        return leaves;
    }

    @Override
    public String toString()
    {
        return value.toString();
    }

    @Override
    public boolean equals(Object o)
    {
        Node n = (Node)o;
        if(n.getValue() == this.value && n.getLeaves().size() == this.leaves.size())
        {
            if(leaves.isEmpty())
                return true;
            for(int i = 0; i < leaves.size(); ++i)
                if(leaves.get(i).equals(n.getLeaves().get(i)))
                    return true;
        }
        return false;
    }
}