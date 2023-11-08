A, B = input().split()

flag = True
result = 1

arr = [3, 5, 7, 9]

while B != A:
    if int(B[len(B) - 1]) in arr:
        flag = False
        break
    if B[len(B) - 1] == '1':
        B = B[:-1]
        if B == "":
            B = "0"
    else:
        B = str(int(B)//2)
    result += 1
    if int(A) > int(B):
        flag = False
        break

if flag:
    print(result)
else:
    print(-1)