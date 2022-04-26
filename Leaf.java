class BinaryTreeException extends Exception
{
    public BinaryTreeException(String message)
    {
        super(message);
    }
}

/**
 * a Leaf class inheriting from the Node class
 * @author Arkadiusz Trojanowski
 */
public class Leaf extends Node
{
    private Node parent;

    /**
     * a function that checks if the leaves array's length equals 2 - if yes then exception is thrown, if no then the constuctor is called
     * @param value the value of the node
     * @param parent the parent of the node
     * @return the created Node
     * @throws BinaryTreeException an exception to secure arrays' max length
     */
    public static Leaf createLeaf(int value, Node parent) throws BinaryTreeException
    {
        if(parent.getLeaves().size() == 2)
            throw new BinaryTreeException("a parent already has two leaves");
        return new Leaf(value, parent);
    }
    /**
     * the Leaf constructor
     * @param value the desired value
     * @param parent the parent of the leaf
     */
    private Leaf(int value, Node parent)
    {
        super(value);
        this.parent = parent;
        parent.getLeaves().add(this);
    }

    /**
     * a parent getter
     * @return a reference to the parent node
     */
    public Node getParent()
    {
        return parent;
    }

    @Override
    public boolean equals(Object o)
    {
        Leaf l = (Leaf)o;
        if(l.getValue() == this.value && l.getLeaves().size() == this.leaves.size() && l.getParent().getValue() == this.parent.getValue())
        {
            if(leaves.isEmpty())
                return true;
            for(int i = 0; i < leaves.size(); ++i)
                if(leaves.get(i).equals(l.getLeaves().get(i)))
                    return true;
        }
        return false;
    }
}
