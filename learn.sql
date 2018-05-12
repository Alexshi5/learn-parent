--并（union）
--结果：2条记录
select * from emp where empno=7369
union
select * from emp where empno=7788 
--结果：11条记录
select * from emp where sal < 2000 --只有2个20号部门的人，一共8条记录
union 
select * from emp where deptno = 20 --20号部门共有5个人，一共5条记录

--差（except）
--结果：1条记录
select * from emp where deptno=30 --30号部门共有6个人，一共6条记录
minus 
select * from emp where deptno=30 and mgr=7698 --部门经理为7698的员工有5个，一共5条记录

--交（intersection）
--结果：5个
select * from emp where deptno=30 --6个
intersect
select * from emp where deptno=30 and mgr=7698 --5个

--笛卡儿积（若关系R有n列x行，关系S有m列y行，则R和S的笛卡儿积为列n+m，行x*y）
select a.*,b.* from emp a,dept b --第一种
select * from emp cross join dept --第二种

--选择（select）
select * from emp where sal > 3000
--投影（project）（取消某些列之后可能出现重复的行，应取消）
select distinct deptno from emp 
--连接（join）
--向dept中添加列（平均工资）设置10、20、30号部门的平均工资并提交
alter table dept add (avgsal number(10))
update dept set avgsal=3000 where deptno = 10;
update dept set avgsal=2000 where deptno = 20;
update dept set avgsal=1500 where deptno = 30;
commit;
--向emp中添加一条没有部门的员工信息记录并提交
insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(8888,'ZHANG','ENGINEER',7788,sysdate,3000,2000,null);
commit;
--一、非等值连接
select * from emp e join dept d on e.sal > d.avgsal
--二、等值连接（连接的列名可以相同可以不同）
select * from emp e join dept d on e.sal = d.avgsal
select * from emp e join dept d on e.deptno = d.deptno
--三、自然连接（连接的列名必须相同）
select * from emp natural join dept
--外连接
--一、左外连接
select * from emp e left join dept d on e.deptno = d.deptno --员工8888没有部门，只保留左表的悬浮元组，其他属性为null
--二、右外连接
select * from emp e right join dept d on e.deptno = d.deptno --40号部门没有人，只保留右表的悬浮元组，其他属性为null
--三、全外连接
select * from emp e full join dept d on e.deptno = d.deptno --保留两边的悬浮元组，左表和右表各有一条悬浮元组记录，一共16行
--自连接
select * from emp e1 join emp e2 on e1.empno = e2.mgr

