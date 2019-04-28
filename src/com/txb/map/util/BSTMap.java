package com.txb.map.util;

//基于BST实现映射类
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

  private class Node {
      K key;
      V value;
      Node left;
      Node right;

      public Node(K key, V value) {
          this(key, value, null, null);
      }

      public Node(K key, V value, Node left, Node right) {
          this.key = key;
          this.value = value;
          this.left = left;
          this.right = right;
      }

      public Node() {
          this(null, null, null, null);
      }
  }

  private Node root;
  private int size;


  public BSTMap() {
      root = null;
      size = 0;
  }

  @Override
  public void add(K key, V value) {
      root = add(root, key, value);
  }

  private Node add(Node node, K key, V value) {
      if (node == null) {
          size++;
          return new Node(key, value);
      }

      if (node.key.compareTo(key) > 0) {
          node.left = add(node.left, key, value);
      } else if (node.key.compareTo(key) < 0) {
          node.right = add(node.right, key, value);
      } else {
          node.value = value;
      }
      return node;

  }

  @Override
  public V remove(K key) {
      Node node = getNode(key);
      if (node != null) {
          root = remove(root, key);
          return node.value;
      }
      return null;
  }

  private Node remove(Node node, K key) {
      if (node == null) {
          return null;
      }
      if (key.compareTo(node.key) < 0) {
          node.left = remove(node.left, key);
          return node;
      } else if (key.compareTo(node.key) > 0) {
          node.right = remove(node.right, key);
          return node;
      } else {//找到要删除的节点

          if (node.left == null) {
              Node rightNode = node.right;
              size--;
              node.right = null;
              return rightNode;
          }
          if (node.right == null) {
              Node leftNode = node.left;
              node.left = null;
              size--;
              return leftNode;
          }

          //删除节点左右节点都存在
          //找到后继结点
          Node successor = minimum(node.right);
          //删除最小节点，并且后继结点的右节点指向该删除后的节点
          successor.right = removeMin(node.right);
          //要删除的做节点赋值给后继结点
          successor.left = node.left;
          //删除节点
          node.left = node.right = null;
          //返回这个后继结点
          return successor;
      }
  }


  //返回以node为根节点的最小值的e节点
  private Node minimum(Node node) {
      if (node.left == null) {
          return node;
      }
      return minimum(node.left);
  }

  private Node removeMin(Node node) {
      if (node.left == null) {
          //找到最小值，保留最小值右节点
          Node rightNode = node.right;
          node.right = null;
          size--;
          //并且返回这个右节点
          return rightNode;
      }

      node.left = removeMin(node.left);
      return node;
  }

  @Override

  public boolean contains(K key) {
      return getNode(key) != null;
  }

  @Override
  public V get(K key) {
      Node node = getNode(key);
      return node == null ? null : node.value;
  }

  @Override
  public void set(K key, V value) {
      Node node = getNode(key);
      if (node != null) {
          node.value = value;
      } else {
          throw new IllegalArgumentException(key + " does not exist ");
      }
  }

  @Override
  public int getSize() {
      return size;
  }

  @Override
  public boolean isEmpty() {
      return size == 0;
  }

  private Node getNode(K key) {
      return getNode(root, key);
  }

  private Node getNode(Node node, K key) {
      if (node == null) {
          return null;
      }
      if (key.compareTo(node.key) > 0) {
          return getNode(node.right, key);
      } else if (key.compareTo(node.key) < 0) {
          return getNode(node.left, key);
      } else {
          return node;
      }
  }
}
