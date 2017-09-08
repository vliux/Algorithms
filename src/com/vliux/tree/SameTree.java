package com.vliux.tree;

import com.vliux.util.TreeNode;

/**
 * Created by vliux on 2017/9/8.
 * https://www.youtube.com/watch?v=ySDDslG8wws&list=PLrmLmBdmIlpv_jNDXtJGYTPNQ2L1gdHxu&index=4
 * Compare two trees, check if they are equal in data and structure both.
 */
public class SameTree {
    public static boolean isSameByTushar(TreeNode r1, TreeNode r2){
        if(r1 == null && r2 == null) return true;
        if(r1 == null || r2 == null) return false;
        return r1.value == r2.value
                && isSameByTushar(r1.left, r2.left)
                && isSameByTushar(r1.right, r2.right);
    }

    public static boolean isSameByVliux(TreeNode r1, TreeNode r2){
        if(r1 == null && r2 == null) return true;
        else if(r1 != null && r2 != null && r1.value == r2.value)
            return isSameByVliux(r1.left, r2.left)
                && isSameByVliux(r1.right, r2.right);
        else return false;
    }

}
