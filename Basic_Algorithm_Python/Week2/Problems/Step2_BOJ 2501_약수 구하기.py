# N과 K를 받으세요
N, K = 0, 0 # 여기를 수정해주세요

# 전체탐색을 통해 약수를 찾으세요
num = 0
answer = 0
for i in range(1, N+1):
    # 약수를 찾았을 때
    if (N%i == 0): 
        continue # 여기를 수정해주세요
    # K번째 약수를 찾았을 때
    if (num == K):
        continue # 여기를 수정해주세요
        break # for문 탈출

# 정답을 출력하세요
print(answer)