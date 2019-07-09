# 1.变量声明：不需要声明，使用前赋值

counter = 100
price = 100.5
name = '小张'
print(counter)
print(price)
print(name)

# 2.多变量赋值

a = b = c = name # 多个同类型变量赋值
print(a)
print(b)
print(c)

a,b,c = True,10,'小张' # 多个不同类型变量赋值
print(a)
print(b)
print(c)

# 3.六个标准数据类型：Number(数字)、String(字符串)、List(列表)、Tuple(元组)、Set(集合)、Dictionary(字典)

#Number包括int float bool complex
a,b,c,d = 10,10.5,True,4+3j
print(type(a)) #<class 'int'>
print(type(b)) #<class 'float'>
print(type(c)) #<class 'bool'>
print(type(d)) #<class 'complex'>
#判断是否是某种类型
print(isinstance(a,int)) # True
#删除对象引用
var1 = 555
print(var1)
del var1
#print(var1) #NameError: name 'var1' is not defined

#List是可变的
var2 = [789,'abc',True,70.5]
print(var2)
var2[2] = [] #[789, 'abc', True, 70.5]
print(var2) #[789, 'abc', [], 70.5]
#按步长截取字符串
print(var2[1][1]) #b
print(var2[1][0:2:2]) #在0到2之间按步长2截取：a
#逆向翻转字符串
print(var2[1][-1::-1]) #第一个-1表示最后一个元素,中间为空表示移动到列表末尾，第二个-1表示逆向：cba
