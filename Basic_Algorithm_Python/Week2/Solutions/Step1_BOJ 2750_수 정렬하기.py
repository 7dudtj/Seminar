# N을 입력받으세요
N = int(input())

# N개의 수가 담길 리스트를 만드세요
list = []

# N개의 수를 입력받아서 리스트에 저장하세요
# Hint: list.append() 함수를 사용하세요
for _ in range(0, N):
    value = int(input())
    list.append(value)

# 리스트를 오름차순으로 정렬하세요
# Hint: list.sort() 함수를 사용하세요
list.sort()

# 정렬된 결과를 출력하세요
for i in range(0, N):
    print(list[i])