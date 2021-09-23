/*
큐
add : O(1) 
remove : O(1)
배열 크기 확대/축소 : O(N)
*/

public class queue {
  public static void main(String[] args) {
    myQueue mq = new myQueue();
    mq.showQueue();
    mq.add(1);
    mq.showQueue();
    mq.add(3);
    mq.showQueue();
    mq.add(2);
    mq.showQueue();
    mq.add(5);
    mq.showQueue();
    mq.add(6);
    mq.showQueue();
    mq.remove();
    mq.showQueue();
    System.out.println(mq.remove());
    mq.showQueue();
    mq.remove();
    mq.showQueue();
    mq.remove();
    mq.showQueue();
    mq.remove();
    mq.showQueue();
  }
}

class myQueue{
  private int[] q; // 큐를 위한 배열
  private int front, rear, size;

  // 큐 생성자
  public myQueue(){
    q = new int[2]; // 초기에 크기가 2인 배열 생성
    front = rear = size = 0;
  }

  // 큐에 있는 항목의 수 리턴
  public int size(){return size;}

  // 큐가 empty이면 true를 리턴
  public boolean isEmpty(){return (size == 0);}

  // 큐 삽입 연산
  public void add(int newItem){
    if ((rear+1)%q.length == front) // 비어있는 원소가 1개뿐인 경우(즉, 큐가 full인 경우)
      resize(2 * q.length); // 큐의 크기를 2배로 확장
    rear = (rear+1) % q.length;
    q[rear] = newItem; // 새 항목을 add
    size++;  
  }

  // 큐 삭제 연산
  public int remove(){
    if (isEmpty()) {
        System.out.println("큐가 비었습니다.");
        return 0;
    }
    front = (front+1) % q.length;
    int item = q[front];
    q[front] = 0;
    size--;
    if (size > 0 && size == q.length/4) // 쿠의 항목수가 배열 크기의 1/4가 되면
      resize(q.length/2); // 큐를 1/2 크기로 축소
    return item;  
  }

  // 큐의 배열 크기 조절
  private void resize(int newSize){
    int[] t = new int[newSize]; // newSize 크기의 새로운 배열 t 생성
    for (int i = 1, j = front + 1; i < size + 1; i++, j++){
      t[i] = q[j%q.length]; // 배열 q의 항목들을 t[1]로부터 복사
    }
    front = 0;
    rear = size;
    q = t; // 배열 t를 배열 q로
  }
  
  // 큐의 내용 확인
  public void showQueue(){
    System.out.println("front : " + front + ", rear : " + rear + ", size : " + size());
    for (int i = 0; i < q.length; i++){
      System.out.print(q[i] + " ");
    }
    System.out.println();
  }
}