# queue 가져오고 선언하세요
from queue import Queue
q = Queue()

# N을 입력받고 큐에 N장의 카드를 넣으세요
N = int(input())
for i in range(1, N+1):
    q.put(i)

# 버린 카드를 모아둘 list 선언하세요
output = []

# queue에서 작업을 수행하세요
# queue에 카드가 남아있을 때 수행
while (q.qsize() > 0): # q.qsize() : queue에 남아있는 원소 수 반환
    # 카드 버리기
    outCard = q.get()
    output.append(outCard)
    # queue에 카드가 남았을 때, 맨 앞 카드를 맨 뒤로 보내기
    if (q.qsize() > 0):
        inCard = q.get()
        q.put(inCard)

# 버리는 카드들과 남은 카드를 출력하세요
print(*output)