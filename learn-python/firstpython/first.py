# 1.演示Hello World
print("Hello World")

# 2.演示if else语句
if True:
    print("true")
else:
    print("false")

# 3.多行语句
string1 = "one" +\
         "two" +\
         "three"
print(string1)

string2 = ['one', 'two',
           'three']
print(string2)

# 4.截取字符串
string3 = "this is python"
print(string3[0:-1]) #第一到倒数第一字符串：this is pytho
print(string3[0]) #第一个字符串：t
print(string3[2:4]) #第三个开始到第4个：is
print(string3[2:]) #第三个开始之后的所有字符串：is is python
print(string3 *2) #输出两次字符串：this is pythonthis is python
print(string3 + '00') #连接字符串：this is python00

# 5.控制台等待用户输入
#input("按下Enter键后退出：")

# 6.不换行输出
print('00',end='')
print('1',end='')

# 7.导入sys模块
import sys
print()
print('import sys module')
print(sys.path[0])