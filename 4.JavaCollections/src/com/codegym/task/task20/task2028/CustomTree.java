package com.codegym.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Build a tree (part 1)

*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    private static final String LEFT = "LEFT_CHILD";
    private static final String RIGHT = "RIGHT_CHILD";
    Entry<String> root;

    public CustomTree() {
        root= new Entry<>("Root");
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String name) {
            this.elementName = name;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;

        }

        public void checkChildren() {
            if (leftChild != null)
                availableToAddLeftChildren = false;
            if (rightChild != null)
                availableToAddRightChildren = false;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

    }

    @Override
    public boolean add(String s) {
        Queue<Entry<String>> nodes = new LinkedList<>(Collections.singletonList(root));

        while (!nodes.isEmpty()) {
            Entry<String> currentNode = nodes.poll();

            if (currentNode.isAvailableToAddChildren()) {
                if (currentNode.availableToAddLeftChildren)
                    return appendChild(s, currentNode, LEFT);
                if (currentNode.availableToAddRightChildren)
                    return appendChild(s, currentNode, RIGHT);
            } else {
                if (currentNode.leftChild != null)
                    nodes.offer(currentNode.leftChild);
                if (currentNode.rightChild != null)
                    nodes.offer(currentNode.rightChild);
            }
        }

        return false;
    }

    private boolean appendChild(String s, Entry<String> node, final String child) {
        switch (child) {
            case LEFT: {
                node.leftChild = new Entry<>(s);
                node.leftChild.parent = node;
                node.checkChildren();
                return true;
            }

            case RIGHT: {
                node.rightChild = new Entry<>(s);
                node.rightChild.parent = node;
                node.checkChildren();
                return true;
            }
        }

        return false;
    }


    public String getParent(String elementName) {
        Queue<Entry<String>> nodes = new LinkedList<>(Collections.singletonList(root));

        while (!nodes.isEmpty()) {
            Entry<String> node = nodes.poll();

            if (node.elementName.equals(elementName))
                return node.parent.elementName;

            if (node.leftChild != null)
                nodes.offer(node.leftChild);
            if (node.rightChild != null)
                nodes.offer(node.rightChild);
        }

        return null;
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException("Not supported operation");
    }

    public boolean remove(Object o) {
        if (!o.getClass().getSimpleName().equals("String"))
            throw new UnsupportedOperationException("You can add only string variables.");


        Queue<Entry<String>> nodes = new LinkedList<>(Collections.singletonList(root));

        while (!nodes.isEmpty()) {
            Entry<String> node = nodes.poll();

            if (node.elementName.equals(o)) {
                if (node.parent.leftChild == node) {
                    node.parent.leftChild = null;
                    node.parent.availableToAddLeftChildren = true;
                }

                if (node.parent.rightChild == node) {
                    node.parent.rightChild = null;
                    node.parent.availableToAddRightChildren = true;
                }

                return true;
            }

            if (node.leftChild != null)
                nodes.offer(node.leftChild);
            if (node.rightChild != null)
                nodes.offer(node.rightChild);


        }



        return false;

    }


    @Override
    public String get(int index) {
        throw new UnsupportedOperationException("Not supported operation");
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException("Not supported operation");
    }

    @Override
    public void add(int index, String s) {
        throw new UnsupportedOperationException("Not supported operation");
    }



    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported operation");
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported operation");
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException("Not supported operation");
    }

    @Override
    public int size() {
        int count = -1;

        Queue<Entry<String>> nodes = new LinkedList<>(Collections.singletonList(root));

        while (!nodes.isEmpty()) {
            Entry<String> node = nodes.poll();
            count++;

            if (node.leftChild != null)
                nodes.offer(node.leftChild);
            if (node.rightChild != null)
                nodes.offer(node.rightChild);
        }

        return count;
    }
}
