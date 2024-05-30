/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function(root, p, q) {
    const findPath = function(root, target) {
        let path = [];
        let current = root;
        
        while (current.val !== target.val) {
            path.push(current);
            if (target.val < current.val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if (current) {
            path.push(current);
        }
        return path;
    }
    
    let pathP = findPath(root, p);
    let pathQ = findPath(root, q);

    let i = 0;
    while (i < pathP.length && i < pathQ.length && pathP[i] === pathQ[i]) {
        i++;
    }
    
    return pathP[i - 1];

};