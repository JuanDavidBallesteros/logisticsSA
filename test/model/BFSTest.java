package model;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BFSTest {

    public void setupScenery1(){

    BSTNode n1 = new BSTNode(1);
    BSTNode n2 = new BSTNode(2);
    BSTNode n3 = new BSTNode(3);
    BSTNode n4 = new BSTNode(4);
    BSTNode n5 = new BSTNode(5);
    BSTNode n6 = new BSTNode(6);

    BFSTest bfs = new BFS();
    int [] arr = {1,2,3,4,5,6};
    BSTNode tree;
    }

    @Test
    void testValueExistsIn() {
        setupScenery1();
        BSTNode node = bfs.valueExistsIn(tree, 4);

        Assert.assertTrue(node instanceof BSTNode);
        BSTNode nullNode = bfs.valueExistsIn(tree, 99);
        Assert.assertNull(nullNode);
    }

    @Test
    void testValueExistsInR() {
        setupScenery1();
        BSTNode node = bfs.valueExistsInR(tree, 4);

        Assert.assertTrue(node instanceof BSTNode);

        BSTNode nullNode = bfs.valueExistsIn(tree, 99);
        Assert.assertNull(nullNode);
    }
    @Test
    void testCreateBST() {
        setupScenery1();

        Assert.assertEquals(3, tree.data);
    }
    @Test 
    void testCommonAncestor() {
        setupScenery1();
        BSTNode node = bfs.hasCommonAncestor(tree, 4, 6);
        Assert.assertTrue(node instanceof BSTNode);
        Assert.assertEquals(5, node.data);
    }
}