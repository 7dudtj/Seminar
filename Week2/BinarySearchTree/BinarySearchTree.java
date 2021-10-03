/*
이진탐색트리
탐색 : O(h)
삽입 : O(h)
삭제 : O(h)
*/

public class BinarySearchTree {
    public static void main(String[] args) {
      BST bst = new BST(50, "apple");
      System.out.println(bst.getRoot().getKey());
      System.out.println(bst.getRoot().getValue());
      System.out.println(bst.get(50));
      bst.put(30, "Lemon");
      bst.put(80, "Mange");
      bst.put(10, "Cherry");
      bst.put(40, "Orange");
      bst.put(90, "Lime");
      bst.put(35, "pear");
      System.out.println("min : " + bst.min());
      bst.deleteMin();
      System.out.println("min : " + bst.min());
      bst.delete(30);
      bst.delete(35);
      System.out.println("min : " + bst.min());
    }
}
  
class Node <Key extends Comparable<Key>, Value>{
    private Key id;
    private Value name;
    private Node left, right;

    // 노드 생성자
    public Node(Key newId, Value newName){
      id = newId;
      name = newName;
      left = right = null;
    }

    // get과 set 메소드들
    public Key getKey(){return id;}
    public Value getValue(){return name;}
    public Node getLeft(){return left;}
    public Node getRight(){return right;}
    public void setKey(Key newId){id = newId;}
    public void setValue(Value newName){name = newName;}
    public void setLeft(Node newLeft){left = newLeft;}
    public void setRight(Node newRight){right = newRight;}
}
  
class BST<Key extends Comparable<Key>, Value>{
    public Node root;
    public Node getRoot(){return root;}

    // BST 생성자
    public BST(Key newId, Value newName){
      root = new Node(newId, newName);
    }

    // 탐색 연산
    public Value get(Key k){return get(root, k);}
    public Value get(Node n, Key k){
      if (n == null) return null; // k를 발견 못함
      int t = n.getKey().compareTo(k);
      if (t > 0) return get(n.getLeft(), k); // if (k < 노드 n의 id) 왼쪽 서브트리 탐색
      else if (t < 0) return get(n.getRight(), k); // if (k > 노드 n의 id) 오른쪽 서브트리 탐색
      else return (Value) n.getValue(); // k를 가진 노드 발견
    }

    // 삽입 연산
    public void put(Key k, Value v){root = put(root, k, v);}
    public Node put(Node n, Key k, Value v){
      if (n == null) return new Node(k,v);
      int t = n.getKey().compareTo(k);
      if (t > 0) n.setLeft(put(n.getLeft(), k, v)); // 왼쪽 서브트리에 삽입
      else if (t < 0) n.setRight(put(n.getRight(), k, v)); // 오른쪽 서브트리에 삽입
      else n.setValue(v); // 노드 n의 name을 v로 갱신
      return n;
    }

    // 최솟값 찾기
    public Key min(){
      if (root == null) return null;
      return (Key) min(root).getKey();
    }
    private Node min(Node n){
      if (n.getLeft() == null) return n;
      return min(n.getLeft());
    }

    // 최솟값 삭제 연산
    public void deleteMin(){
      if (root == null) System.out.println("empty 트리");
      root = deleteMin(root);
    }
    public Node deleteMin(Node n){
      if (n.getLeft() == null) return n.getRight(); // if (n의 왼쪽자식 == null) n의 오른쪽자식 리턴
      n.setLeft(deleteMin(n.getLeft())); // if (n의 왼쪽자식 != null), n의 왼쪽자식으로 재귀호출
      return n;
    }

    // 삭제 연산
    public void delete(Key k){root = delete(root, k);}
    public Node delete(Node n, Key k){
      if (n == null) return null;
      int t = n.getKey().compareTo(k);
      if (t > 0) n.setLeft(delete(n.getLeft(), k)); // 왼쪽 자식으로 이동
      else if (t < 0) n.setRight(delete(n.getRight(), k)); // 오른쪽 자식으로 이동
      else{ // 삭제할 노드 발견
        if (n.getRight() == null) return n.getLeft(); // case 0, 1
        if (n.getLeft() == null) return n.getRight(); // case 1
        // case 2
        Node target = n; 
        n = min(target.getRight()); // 삭제할 노드 자리롤 옮겨올 노드 찾아서 n이 가리키게 함
        n.setRight(deleteMin(target.getRight()));
        n.setLeft(target.getLeft());
      }
      return n;
    }
}