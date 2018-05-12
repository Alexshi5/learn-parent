--����union��
--�����2����¼
select * from emp where empno=7369
union
select * from emp where empno=7788 
--�����11����¼
select * from emp where sal < 2000 --ֻ��2��20�Ų��ŵ��ˣ�һ��8����¼
union 
select * from emp where deptno = 20 --20�Ų��Ź���5���ˣ�һ��5����¼

--�except��
--�����1����¼
select * from emp where deptno=30 --30�Ų��Ź���6���ˣ�һ��6����¼
minus 
select * from emp where deptno=30 and mgr=7698 --���ž���Ϊ7698��Ա����5����һ��5����¼

--����intersection��
--�����5��
select * from emp where deptno=30 --6��
intersect
select * from emp where deptno=30 and mgr=7698 --5��

--�ѿ�����������ϵR��n��x�У���ϵS��m��y�У���R��S�ĵѿ�����Ϊ��n+m����x*y��
select a.*,b.* from emp a,dept b --��һ��
select * from emp cross join dept --�ڶ���

--ѡ��select��
select * from emp where sal > 3000
--ͶӰ��project����ȡ��ĳЩ��֮����ܳ����ظ����У�Ӧȡ����
select distinct deptno from emp 
--���ӣ�join��
--��dept������У�ƽ�����ʣ�����10��20��30�Ų��ŵ�ƽ�����ʲ��ύ
alter table dept add (avgsal number(10))
update dept set avgsal=3000 where deptno = 10;
update dept set avgsal=2000 where deptno = 20;
update dept set avgsal=1500 where deptno = 30;
commit;
--��emp�����һ��û�в��ŵ�Ա����Ϣ��¼���ύ
insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(8888,'ZHANG','ENGINEER',7788,sysdate,3000,2000,null);
commit;
--һ���ǵ�ֵ����
select * from emp e join dept d on e.sal > d.avgsal
--������ֵ���ӣ����ӵ�����������ͬ���Բ�ͬ��
select * from emp e join dept d on e.sal = d.avgsal
select * from emp e join dept d on e.deptno = d.deptno
--������Ȼ���ӣ����ӵ�����������ͬ��
select * from emp natural join dept
--������
--һ����������
select * from emp e left join dept d on e.deptno = d.deptno --Ա��8888û�в��ţ�ֻ������������Ԫ�飬��������Ϊnull
--������������
select * from emp e right join dept d on e.deptno = d.deptno --40�Ų���û���ˣ�ֻ�����ұ������Ԫ�飬��������Ϊnull
--����ȫ������
select * from emp e full join dept d on e.deptno = d.deptno --�������ߵ�����Ԫ�飬�����ұ����һ������Ԫ���¼��һ��16��
--������
select * from emp e1 join emp e2 on e1.empno = e2.mgr

