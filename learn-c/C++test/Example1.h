//统计某一字符串对象（仅由字符串和空格组成）有多少个单词，同时保存所有单词在字符串中的起始地址（该字符串不超过100个单词）

#include <iostream>
using namespace std;
#include <string>
class str{
	string s;
	int n,a[100],j,l;
public:
	str(string &a){
		s=a;
		n=0;
		j=0;
		l=0;
	}
	int *geta(){
		return a;
	}
	void test(){
		for(int i=0;i<s.size();i++){
			if(s[i]==''&&i!=0){//出现空格且空格不在字符串的首位置
				a[n] = l;//数组a[]记下单词的起始地址
				n++;//单词个数+1
				l = i+1;//l指向下个单词的起始位置
			}
		}

		//最后一个字符不是空格时，需要单独统计最后一个单词
		if(s[s.size()-1]!=''){
			a[n] = l;
			n++;
		}
	}
};
