/**
 * Copyright (C), 2018-2020
 * FileName: SerializeorDeserialize
 * Author:   xjl
 * Date:     2020/5/12 14:12
 * Description: ces
 */
package Tree;

import java.util.ArrayList;
import java.util.List;

public class SerializeorDeserialize {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    String Serialize(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return null;
        }
        list.add(root.val);
        if (root.left != null) {
            Serialize(root.left);
        }
        if (root.right != null) {
            Serialize(root.right);
        }
        return list.toArray().toString();
    }

}
