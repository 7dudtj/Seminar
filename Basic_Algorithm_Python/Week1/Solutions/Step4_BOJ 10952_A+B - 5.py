# A와 B를 정수형으로 입력받으세요
A, B = map(int, input().split())

# A와 B가 모두 0일때까지 while문을 돌리세요
while (A != 0 or B != 0):
    # A+B를 출력하세요
    print(A+B)

    # 다시 A와 B를 정수형으로 입력받으세요
    A, B = map(int, input().split())