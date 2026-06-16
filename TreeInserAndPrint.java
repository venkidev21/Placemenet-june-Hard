import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int d){
        data=d;
        left=null;
        right=null;
    }
}
class Tree{
    Node root;
    void insert(Scanner sc){
        int data=sc.nextInt();
        root=new Node(data);
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp=q.remove();
            System.out.println("Eneter left of"+" "+temp.data);
            int k=sc.nextInt();
            if(k!=-1) {
                Node n=new Node(k);
                q.add(n);
            
            temp.left=n;
            }
            System.out.println("Eneter right of"+" "+temp.data);
            k=sc.nextInt();
            if(k!=-1) {
                Node n=new Node(k);
                q.add(n);
                temp.right=n;
            }
        }
    }
    void print(){
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node t=q.poll();
            System.out.print(t.data+" ");
            if(t.left!=null) q.add(t.left);
            if(t.right!=null) q.add(t.right);
        }
    }
}
class TreeInserAndPrint{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Tree t=new Tree();
        t.insert(sc);
        t.print();
    }
}