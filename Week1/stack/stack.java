/*
스택 
push : O(1)
pop : O(1)
배열 크기 확대/축소 : O(N)
*/

public class stack {
  public static void main(String[] args) {
    myStack s = new myStack();
    s.push(1);
    s.showStack();
    s.push(3);
    s.showStack();
    s.push(4);
    s.showStack();
    s.pop();
    s.showStack();
    System.out.println(s.pop());
    s.showStack();
  }
}

class myStack{
  private int s[]; // 스택을 위한 배열
  private int top; // 스택의 top 항목의 배열 원소 인덱스

  // 스택 생성자
  public myStack(){
    s = new int[1]; // 초기에 크기가 1인 배열 생성
    top = -1;
  }

  // 스택에 있는 항목의 수를 리턴
  public int size(){return top + 1;}

  // 스택이 empty이면 true 리턴
  public boolean isEmpty() {return (top == -1);}

  // 스택 top 항목의 내용만을 리턴
  public int peek(){
    if (isEmpty()) return -1;
    return s[top];
  }

  // push 연산
  public void push(int newItem){
    if (size() == s.length)
      resize(2 * s.length); // 스택을 2배의 크기로 확장
    s[++top] = newItem; // 새 항목을 push
  }

  // pop 연산
  public int pop(){
    if (isEmpty()) {
      System.out.println("스택이 비었습니다.");
      return 0;
    }  
    int item = s[top];
    s[top--] = 0; // 0으로 초기화
    if (size() > 0 && size() == s.length/4)
      resize(s.length/2); // 스택을 1/2 크기로 축소
    return item;  
  }

  // 배열 크기 조절
  private void resize(int newSize){
    int[] t = new int[newSize]; // newSize 크기의 새로운 배열 t 생성
    for (int i = 0; i < top + 1; i++)
      t[i] = s[i]; // 배열 s를 배열 t로 복사
    s = t; // 배열 t를 배열 s로  
  }
  
  // 스택 내용 확인
  public void showStack(){
    for (int i = 0; i < s.length; i++)
      System.out.print(s[i] + " ");
    System.out.println();  
  }
}