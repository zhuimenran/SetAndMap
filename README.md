# SetAndMap
集合和映射的各种实现及其基本操作

#2019.4
用二分搜索树，链表实现set
用链表，二分搜索树实现map

#2019.5
集合(Set)和映射(Map)基础总结
Set介绍
基于链表实现Set
基于二叉搜索树实现Set
基于二叉平衡树实现Set
使用Set解决LeetCode-804. Unique Morse Code Words
使用Set解决LeetCode-349. Intersection of Two Arrays
Map介绍
基于链表实现Map
基于二叉搜索树实现Map
基于二叉平衡树实现Map
使用Map解决LeetCode-350. Intersection of Two Arrays II
Set和Map的一些对比和总结

#Set介绍
Set是不允许重复的集合容器；
Set可以分为有序集合和无需集合；
有序集合基于搜索树实现，JDK底层是红黑树，即TreeSet；
无序集合基于Hash表实现，JDK底层是HashMap包装之后，即HashSet

基于链表实现Set
首先看一下单链表的实现，下面的实现中使用SingleList实现:
先看Set接口中需要实现的方法:
public interface Set<E> {
    void add(E e);
    boolean contains(E e);
    void remove(E e);
    int getSize();
    boolean isEmpty();
}


Map介绍
Map的键不允许重复，如果重复插入键相同的，则新的value覆盖原来的value；
Map可以分为有序Map和无序Map；
有序Map基于搜索树实现，JDK底层使用红黑树实现，即TreeMap；
无序Map基于Hash表实现，JDK底层使用Hash表底层实现，即HashMap；

基于链表实现Map
和普通的单链表不同的:

结点内部是key,value的键值对；
getNode()，返回key对应的结点，方便操作；
在add()操作的时候，如果已经存在key对应的结点，就更新value即可；
基于二叉搜索树实现Map
和二叉搜索树中的操作差不多，注意:

在添加的时候，如果已经存在，也就是key相等的话就直接更新value即可；
增加getNode()方法: 返回以node为根节点的二分搜索树中，key所在的节点；
大部分对于e(也就是结点值)的操作，就是对key的操作；
