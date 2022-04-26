public class Main
{
    public static void main(String[] args)
    {
        //creating the root and the array of potential leaves
        Node root = new Node(5);
        Leaf[] l = new Leaf[10];

        //setting values and connecting to parent
        l[0] = TreeFunctions.createLeaf(3, root);
        l[1] = TreeFunctions.createLeaf(7, root);
        l[2] = TreeFunctions.createLeaf(2, l[0]);
        l[3] = TreeFunctions.createLeaf(5, l[0]);
        l[4] = TreeFunctions.createLeaf(1, l[1]);
        l[5] = TreeFunctions.createLeaf(0, l[1]);
        l[6] = TreeFunctions.createLeaf(2, l[5]);
        l[7] = TreeFunctions.createLeaf(8, l[5]);
        l[8] = TreeFunctions.createLeaf(5, l[7]);
        //trying to add a third leaf to the root, should throw an exception
        l[9] = TreeFunctions.createLeaf(0, root);
        System.out.println();

        //task 1
        System.out.println("number of nodes without any children: " + TreeFunctions.calculateChildrenlessNodes(root));
        System.out.println();

        //task 2
        System.out.println("the longest route in the tree from the root: " + TreeFunctions.calculateLongestPath(root));
        System.out.println();

        //creating a second, independent instance with the same values and connections
        Node root1 = TreeFunctions.copyTree(root);

        //check if the tree is copied properly
        System.out.println("number of nodes without any children: " + TreeFunctions.calculateChildrenlessNodes(root1));
        System.out.println("the longest route in the tree from the root: " + TreeFunctions.calculateLongestPath(root1));
        System.out.println();

        //task 3
        System.out.println("the trees have the same values and connections: " + root.equals(root1));
        System.out.println();

        //creating another two binary trees to make additional tests
        Node root2 = new Node(1);
        Leaf[] l2 = new Leaf[5];
        l2[0] = TreeFunctions.createLeaf(2, root2);
        l2[1] = TreeFunctions.createLeaf(3, root2);
        l2[2] = TreeFunctions.createLeaf(4, l2[1]);
        l2[3] = TreeFunctions.createLeaf(5, l2[2]);
        l2[4] = TreeFunctions.createLeaf(6, l2[2]);

        Node root3 = new Node(10);
        Leaf[] l3 = new Leaf[5];
        l3[0] = TreeFunctions.createLeaf(9, root3);
        l3[1] = TreeFunctions.createLeaf(8, l3[0]);
        l3[2] = TreeFunctions.createLeaf(7, l3[1]);
        l3[3] = TreeFunctions.createLeaf(6, l3[1]);
        l3[4] = TreeFunctions.createLeaf(5, l3[3]);

        //additional tests

        System.out.println("number of nodes without any children: " + TreeFunctions.calculateChildrenlessNodes(root2));
        System.out.println("the longest route in the tree from the root: " + TreeFunctions.calculateLongestPath(root2));
        System.out.println();

        System.out.println("number of nodes without any children: " + TreeFunctions.calculateChildrenlessNodes(root3));
        System.out.println("the longest route in the tree from the root: " + TreeFunctions.calculateLongestPath(root3));
        System.out.println();

        System.out.println("the trees have the same values and connections: " + root2.equals(root3));
    }
}