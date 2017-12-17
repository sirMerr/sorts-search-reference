package com.tiffanyln.sort;

import com.tiffanyln.sort.entities.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * In a binary tree, each element has left and/or right, or no node. Left nodes have smaller values than
 * their parent, right nodes have higher values than their parents.
 *
 * For the purpose of demonstrating how this sort works, and to use a {@code Set} (LinkedHashSet),
 * this will be using an integer set that gets passed to the sort. It is possible to use other Objects
 * and Collections, since our node uses a generic type, you can easily replace {@code <Integer>} with whatever you
 * want and change the conditions accordingly.
 *
 * @author sirMerr
 */
public class BinaryTreeSort {
    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    private Set<Integer> arrToSort;
    // The utmost parent node which has mini child nodes
    public Node<Integer> root;

    public BinaryTreeSort(LinkedHashSet<Integer> arrToSort) {
        this.arrToSort = arrToSort;
        // Puts the first element as the root node. We could use our insert method,
        // but it's more straightforward to set the root separately.
        root = new Node<>(arrToSort.iterator().next());
        arrToSort.remove(arrToSort.iterator().next());
    }

    public void sort() {
        for (int element: arrToSort) {
            insert(root, element);
        }
    }

    private Node<Integer> insert(Node<Integer> node, int element) {
        log.debug("insert(node: " + node + ", element: " + element + ")");
        // Means there is no value set this node. so you can set it
        // to the element given.
        if (node == null) {
            return new Node<>(element);
        }

        if (node.getElement() > element) {
            // In the tree, the new element is smaller than the parent node element,
            // so it gets added to the left node of the parent.
            node.setLeft(insert(node.getLeft(), element));
        } else {
            // Here, the new element is bigger than the parent node element,
            // so it gets added to the right node of the parent
            node.setRight(insert(node.getRight(), element));
        }

        // At this point, this instance of the node tree is filled and returned.
        // If using root, at the end of this recursive method, the entire tree should be
        // filled and returned, because each branch got populated :D
        return node;
    }

    /**
     * Displays the binary tree in ascending order. Mostly
     * for demo and testing purposes.
     *
     * Recursive method which goes through each left and right node
     * within the tree and displays it
     *
     * @param node
     */
    public String displayAsc(Node<Integer> node) {
        String result = "";
        if (node == null)
            return "";
        result += displayAsc(node.getLeft());
        result += node.getElement() + ",";
        result += displayAsc(node.getRight());
        return result;
    }

    /**
     * Displays the binary tree in descending order. Mostly
     * for demo and testing purposes.
     *
     * Recursive method which goes through each left and right node
     * within the tree and displays it
     *
     * @param node
     */
    public String displayDesc(Node<Integer> node) {
        String result = "";
        if (node == null)
            return "";
        result += displayAsc(node.getRight());
        result += node.getElement() + ",";
        result += displayAsc(node.getLeft());
        return result;
    }

}
