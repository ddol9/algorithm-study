import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
        static Node[] tree = new Node[26];
        static StringBuilder preOrder = new StringBuilder();
        static StringBuilder inOrder = new StringBuilder();
        static StringBuilder postOrder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (tree[parent - 'A'] == null) {
                tree[parent - 'A'] = new Node(parent);
            }

            if (left != '.') {
                tree[left-'A'] = new Node(left);
                tree[parent-'A'].left = tree[left-'A'];
            }

            if (right != '.') {
                tree[right-'A'] = new Node(right);
                tree[parent-'A'].right = tree[right-'A'];
            }
        }

        preorder(tree[0]);
        inorder(tree[0]);
        postorder(tree[0]);

        System.out.println(preOrder.toString());
        System.out.println(inOrder.toString());
        System.out.println(postOrder.toString());
    }

    static void preorder(Node node) {
        if (node == null) return;
        preOrder.append(node.data);
        preorder(node.left);
        preorder(node.right);
    }

    static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        inOrder.append(node.data);
        inorder(node.right);
    }

    static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        postOrder.append(node.data);
    }
}

class Node {
    char data;
    Node left;
    Node right;
    public Node(char data) {
        this.data = data;
        left = null;
        right = null;
    }
}
