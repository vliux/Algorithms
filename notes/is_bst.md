【问题】
给定一颗二叉树，检查它是否为Binary search tree。

【错误解法】
遍历二叉树，对每个node，分别检查它的value是否大于左儿子，并小于右儿子。
这个解法的错误在于其仅比较了节点和其直接儿子的value。实际上二叉搜索树中任意一个节点的值必须是落在一个范围内，该范围由其所有上层父节点+祖父节点确定。

【资源】
https://youtu.be/MILxfAbIhrE
IsBST.java