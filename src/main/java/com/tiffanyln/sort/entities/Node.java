package com.tiffanyln.sort.entities;

/**
 * Used in {@see BinaryTreeSort}
 *
 * @param <T>
 */
public class Node<T> {
    private Node left;
    private Node right;
    private T element;

    public Node(Node left, Node right, T element) {
        this.left = left;
        this.right = right;
        this.element = element;
    }

    public Node(T element) {
        this.element = element;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;

        Node<?> node = (Node<?>) o;

        if (getLeft() != null ? !getLeft().equals(node.getLeft()) : node.getLeft() != null) return false;
        if (getRight() != null ? !getRight().equals(node.getRight()) : node.getRight() != null) return false;
        return getElement() != null ? getElement().equals(node.getElement()) : node.getElement() == null;
    }

    @Override
    public int hashCode() {
        int result = getLeft() != null ? getLeft().hashCode() : 0;
        result = 31 * result + (getRight() != null ? getRight().hashCode() : 0);
        result = 31 * result + (getElement() != null ? getElement().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Node{" +
                "left=" + left +
                ", right=" + right +
                ", element=" + element +
                '}';
    }
}
