import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int d){
        data=d;
    }
}
class Tree{
    Node root;
    Tree(){
        // directAdd Tree
        root=new Node(4);
        root.left=new Node(5);
        root.right=new Node(6);
        root.left.left=new Node(7);
        root.left.right=new Node(8);
         root.right.left=new Node(1);
        root.right.right=new Node(2);

    }
    //  inver tree using Recuseeion
    Node  InverTree_recusion(Node root){
        InverTree_help(root);
        return root;
        
    }
    void InverTree_help(Node root){
        // post oder traves
        if(root==null) return;
        InverTree_help(root.left);
        InverTree_help(root.right);
        // swap Node left <-> right
        Node t=root.left;
        root.left=root.right;
        root.right=t;

    }
    //  inver tree using bfs que
    Node InverTree_bfs(Node root){
        // ithukku namba que use pannuvom\
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp=q.remove();
            if(temp.left!=null) q.add(temp.left);
            if(temp.right!=null) q.add(temp.right);
            // swap
            Node k=temp.left;
            temp.left=temp.right;
            temp.right=k;
        }
        return root;

    }
    // Inver tree Dfs Stack use panni
    Node InverTree_Dfs(Node root){
        // ithukku namba stack use pnnuvom
        Stack<Node> st=new Stack<>();
        st.add(root);
        while(!st.isEmpty()){
            Node temp=st.pop();
            if(temp.left!=null) st.push(temp.left);
            if(temp.right!=null) st.push(temp.right);
             // swap
            Node k=temp.left;
            temp.left=temp.right;
            temp.right=k;
        }
        return root;
    }
    void print(Node root){
         Stack<Node> st=new Stack<>();
        st.add(root);
        while(!st.isEmpty()){
            Node temp=st.pop();
            System.out.print(temp.data+" ");
            if(temp.left!=null) st.push(temp.left);
            if(temp.right!=null) st.push(temp.right);
           
        }
        System.out.println();
    }
}
class InvertTree{
    public static void main(String[] args) {
        Tree n=new Tree();
        n.print(n.root);
        n.InverTree_recusion(n.root);
        n.print(n.root);
        // n.InverTree_bfs(n.root);
        // n.InverTree_Dfs(n.root);
    }
}