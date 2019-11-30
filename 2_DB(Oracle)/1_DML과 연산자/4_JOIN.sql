/* 

[JOIN ��� ����]
    ����Ŭ                                     SQL:1999 ǥ�� (ANSI)
    
� ����                                  ��������(INNER JOIN)
                                               JOIN USING / JOIN ON
                                               + �ڿ� ���� (NATURAL JOIN, � ���� ��� �� �ϳ�)
                                               -> ANSI������ ǥ�� ���� ( ����Ŭ���� ����� �� �� ������ ǥ������ �������� ���� )

���� ����                                  ���� �ܺ� ���� ( LEFT OUTER JOIN )                                               
                                               ������ �ܺ� ���� ( RIGHT OUTER JOIN )
                                               ��ü �ܺ� ���� ( FULL OUTER JOIN ) --> ����Ŭ �������� ��� �� ��

�� ����                               JOIN ON
��ü ����

CARTESIAN PRODUCT                ���� ���� ( CROSS JOIN )
(īƼ�� ��)
-> ���̺� ���� �� ����

*/


------------------------------------------------------------------------------------------

-- JOIN 
-- �ϳ� �̻��� ���̺��� �����͸� ��ȸ�ϱ� ���� ����ϴ� ����
-- ���� ����� �ϳ��� Result Set ���� ����

/*   [  JOIN�� �ʿ��� ����  ]
- ������ �����ͺ��̽����� SQL�� �̿��� ���̺� ���� '����'�� �δ� ���.

- ������ �����ͺ��̽�(RDBMS)�� �ּ����� �����͸� ���̺� ��� �־� 
���ϴ� ������ ���̺��� ��ȸ�ؾ� �� ��� 
�ϳ� �̻��� ���̺��� �����͸� �о�;� �ϴ� ��찡 ����.
�� ��, ������ �����͸� �о���� ���� �ƴ� 
���̺� ���� �����(���� ���� ���� ���� �÷�)�� ���谡 �ξ��� �����͸� �����ؾ� ��.
-- 'JOIN'�� ���� �̸� ���� ����

*/

-- ANSI ǥ�� ����
-- ANSI�� �̱� ���� ǥ�� ��ȸ�� ����
-- �̱��� ���ǥ��ȭ�ⱸ ISO�� ���ԵǾ��ִ�.
-- ANSI���� ������ ǥ���� ANSI��� �ϰ�
-- ���⼭ ������ ǥ�� �� ���� ������ ���� 'ASCII�ڵ�'�̴�.

-- ���, ����� �̸�, �μ����� ��� ��ȸ�ϱ�
select emp_id, emp_name, dept_code
from employee;
-- ���, ������� EMPLOYEE ���̺����� ��ȸ ����

select dept_id, dept_title
from department;
-- �μ����� DEPARTMENT ���̺����� ��ȸ ����

--> �μ� �ڵ�(DEPT_ID, DEPT_CODE) �� �� ���̺� ��� ��ȸ ����.
-- > � ���� : ���� �÷� ���� ������ JOIN

-- 1. [ ANSI ] ���� ����( INNER JOIN, ����Ŭ�� � ����( EQUAL JOIN ) )
--> ����Ǵ� �÷��� ���� ��ġ�ϴ� ��鸸 ���ε�.
-- ( ��ġ�ϴ� ���� ���� ���� ���ο��� ���ܵ� )
-- ���� ��ġ�ϴ� ��ȣ�� = �� ���

------------------------------------------------------------------------------------------
--  [ INNER JOIN , � ���� ]
-- JOIN�� �⺻ ���� INNER ����
-- JOIN �� ���� ���� ����

-- ����Ŭ ���� ����
-- FROM ���� ','( �޸� ) �� �����Ͽ� ��ĥ ���̺���� ���
-- WHERE ���� ��ġ�⿡ ���� �÷����� ���

-- 1) ���ῡ ���� �� �÷����� �ٸ� ���. => ���� ���̳� �÷��� �ٸ�
select emp_id, emp_name, dept_title
from employee, department
where dept_code = dept_id;

-- 2) ���ῡ ����� �� �÷����� ���� ���
-- ���, �̸�, ���޸� ��ȸ 
select emp_id, emp_name, job_name
from employee, job
where job.job_code = employee.job_code;

-- 3) ��Ī ���
select emp_id, emp_name, job_name
from employee e, job 
where e.job_code = j.job_code;


------------------------------------------------------------------------------------------
-- ANSI ǥ�� ����
-- 1) ���ῡ ����� �÷����� �ٸ� ���
    --> JOIN ON () ���� ���
select emp_id, emp_name, dept_title
from employee
join department on (dept_code = dept_id);

-- 2) ���ῡ ����� �÷����� ���� ���
  --> JOIN USING() ���� ���  ==> �÷����� ���� ��쿡 ����ϴ� ���̱� ������ using���� ���̺��� �ʿ� ����
select emp_id, emp_name, job_name
from employee
join job using(job_code);

-- �μ��� ������ ��ȸ
-- ����Ŭ ���� ����
select dept_title, local_name
from department,location
where department.location_id = location.local_code;
-- ANSI ���� ����

select dept_title, local_name
from department
join location on(location_id = local_code);
------------------------------------------------------------------------------------------

-- 2. �ܺ� ����( OUTER JOIN )
-- �� ���̺� �����ϴ� �÷����� ��ġ���� �ʴ� �൵
-- ���� ����� ���Խ�Ŵ
    --> �ݵ�� OUTER JOIN ���� ����ؾ� ��.

-- INNER JOIN, OUTER JOIN�� ���� ������
select emp_id, emp_name, dept_title
from employee
join department on (dept_code = dept_id);

-- 1) LEFT {OUTER} JOIN
-- ��ġ�⿡ ���� �� ���̺� �� 
-- ���� ����� ���Ը��� �÷� ���� �������� JOIN �� ����

-- ANSI ǥ�� ����
select emp_id, emp_name, dept_title
from employee
left outer join department on (dept_code = dept_id)
--where dept_title is null
;

-- ����Ŭ ����
-- where ���� �÷��� �������� ��,�� ����
select emp_id, emp_name, dept_title
from employee, department
where employee.dept_code = department.dept_id(+)/* and dept_title is null */;
-- (+) : ���� �÷��� ��� ���� ���缭 ������ ���̺� ��� ���� ���ϴ� ��
-- ���ʿ� ����� �÷��� �������� �÷����� �߰��ϰڴ�.


------------------------------------------------------------------------------------------

-- 2) RIGTH [OUTER] JOIN
-- ��ġ�⿡ ����� �� ���̺� ��
-- ������ ����� ���̺��� �÷� ���� �������� JOIN

-- ANSI ǥ�� ����
select emp_id, emp_name, dept_title
from employee
RIGHT OUTER JOIN department on (dept_code = dept_id)
where emp_name is null;
-- DEPARTMENT ���̺��� �ƹ� ���谡 �ξ��� ���� ����
-- �ؿ� ����3��, �����ú�, ���������ΰ� �������� �߰� �� 
-- right join �� ��� �ϱ� ������ left join �� �� ���� ���
select emp_id, emp_name, dept_title
from department
left outer join employee on(dept_code = dept_id);
--where emp_id is null;
-- ������ �Ǵ� ���̺� ������ ����
-- LEFT, RIGHT  JOIN�� ����� ���� �� ����.

-- ����Ŭ ����
select emp_id, emp_name, dept_title
from employee, department
where dept_code(+) = dept_id;
-- �߰��Ǵ� ���̺��ʿ� (+) ����


------------------------------------------------------------------------------------------

-- 3) FULL [OUTER] JOIN 
-- ��ġ�⿡ ����� �� ���̺��� ���� ��� ����
-- ����� ���Խ�Ű�� ����
-- INNER + LEFT + RIGHT
-- ANSI ǥ�� ����
select emp_id, emp_name, dept_title
from employee
full outer join department on (dept_code= dept_id);

-- ����Ŭ ���� ����
select emp_id, emp_name, dept_title
from employee, department;
--where dept_code(+) = dept_id(+); 
--> ����Ŭ ���� ������ FULL OUTER JOIN ��� ����

------------------------------------------------------------------------------------------

-- 3. ���� ���� ( CROSS JOIN, ����Ŭ CARTESIAN PRODUCT ) 
-- ���εǴ� ���̺��� �� ����� ��� ���ε� �����Ͱ� ��ȸ�� (������)
-- AI, ������ �ʿ��� ���� ���
-- Result Set ���� NULL ���� �����ϰ� ��ȸ�� 
-- 

select emp_id, emp_name, dept_title
from employee
cross join department ;

------------------------------------------------------------------------------------------

-- 4. �� ���� ( NON EQUAL JOIN )
-- '�����ϴ� �÷��� ������ ��쿡�� ���'
-- '='(��ȣ)�� ������� �ʴ� ���� 
--> ���� �����Ͽ� ���� '��' 
--> �����ϴ� ���� ���� ���� ���� �� ������ �����Ͽ� ���� �����?
-- ������ �÷� ���� ��ġ�ϴ� ��찡 �ƴ� 
-- ���� ������ ���ԵǴ� ����� �����ϴ� ����

-- �����, �޿�, �޿� ���
-- ����� �޿��� ���� �˸��� �޿�������� ��ȸ�� ��
select emp_name, salary, e.sal_level
from employee e
join sal_grade s on (salary between min_sal and max_sal);

------------------------------------------------------------------------------------------

-- 5. ��ü ���� ( SELF JOIN )
-- �ڱⰡ �ڽ��� JOIN 
-- ���, �̸�, �μ��ڵ�, ������ ��ȸ
select emp_id, emp_name, manager_id
from employee;

-- ANSI ǥ�� ����
select e.emp_id, e.emp_name, e.dept_code, e.manager_id, m.emp_name
from employee e
join employee m on (e.manager_id = m.emp_id);

-- ����Ŭ ���� ����
select e.emp_id, e.emp_name, e.dept_code, e.manager_id,m.emp_name
from employee e, employee m
where e.manager_id = m.emp_id;

 
------------------------------------------------------------------------------------------

--6. �ڿ� ���� ( NATURAL JOIN )
-- ������ Ÿ�԰� �̸��� ���� �÷��� �ִ� ���̺�� ���� ���ν�
-- ���ΰ� ������ ������ ǥ���� ���

-- * �ݵ�� �� ���̺� ���� ������ �÷���, Ÿ���� ���� �÷��� �ʿ�
--> ���� ��� �������� �߻�
select emp_name, job_name
from employee e 
join job j on (e.job_code = j.job_code);

select emp_name, job_name
from employee 
join job using (job_code);

select emp_name, job_name
from employee
natural join job; 
-- ������ �÷���� Ÿ���� ã�Ƽ� �˾Ƽ� ����


------------------------------------------------------------------------------------------


-- 7. ���� ���� 
-- N ���� ���̺���� �����Ͽ� ��ȸ�� ���
-- ���� ������ �ſ� �߿���!

-- ���, �����, �μ��ڵ�, �μ���, ������
select emp_id, emp_name, dept_code, dept_title, local_name
from employee
join department on (dept_code = dept_id) 
join location on (location_id = local_code);

-- ���� ������ ��Ű�� ���� ���
select emp_id, emp_name, dept_code, dept_title, local_name
from employee
left join location on (location_id = local_code)
join department on (dept_code = dept_id);

-- FROM ������ JOIN �߻� �� 
-- ���������� ���ʴ�� JOIN�� �ѹ� ������ �� ����
-- RESULT SET�� ���Ӱ� �������
--> JOIN ������ ���Ѿ� ��
-- (RESULT SET�� ���̺�� ��� ����)

-- ���ΰ��谡 ����� �ξ����� ���� ���·� ���� �÷� ���� �� ���� �߻�

-- ��� �� ������ �ϵ���, �̿����� ��ȸ ����� �����ؼ� ��ȸ�ϱ�
select emp_id, emp_name, dept_code, dept_title, local_name
from employee
left join department on (dept_code = dept_id) 
left join location on (location_id = local_code);
-- join ��  inner join�� null���� ������ ����� ������
--> null ���� �������� ���� ��� ���̺� left join �ʿ�


-- ����Ŭ ����
select emp_id, emp_name, dept_code, dept_title, local_name
from employee  , department , location 
where dept_code = dept_id and 
location_id = local_code;


-- ������ �븮�̸鼭 �ƽþ� ������ �ٹ��ϴ� ���� ��ȸ
-- ���, �̸�, ���޸�, �μ���, �ٹ�������, �޿��� ��ȸ�ϼ���

-- ����Ŭ ����
select emp_id, emp_name, job_name ,dept_title, local_name, salary
from employee e , department, location, job j
where (dept_code = dept_id) and
(location_id = local_code) and
(e.job_code= j.job_code) and
job_name = '�븮' and
local_name = 'ASIA1';


-- ANSI ����
select emp_id, emp_name, job_name ,dept_title, local_name, salary
from employee
left join department on (dept_code = dept_id)
left join location on (location_id = local_code)
 join job using (job_code)
where job_name = '�븮' and
local_name = 'ASIA1';



select emp_id, emp_name, job_name ,dept_title, local_name, salary
from employee
left join department on (dept_code = dept_id)
left join location on (location_id = local_code)
natural join job  
where job_name = '�븮' and 
dept_title= 'ASIA1';


------------------------------------------------------------------------------------------

-- 1. �ֹι�ȣ�� 70��� ���̸鼭 ������ �����̰�, ���� ���������� ��������
-- �����, �ֹι�ȣ, �μ���, ���޸��� ��ȸ�Ͻÿ�.
select emp_name, emp_no, dept_title,job_name
from employee
join job using(job_code)
join department on (dept_code=dept_id)
where substr(emp_no,8,1)='2' and emp_name like '��%';

select emp_name, emp_no, dept_title, job_name
from employee e, department, job j 
where e.job_code = j.job_code and
dept_code = dept_id and
substr(emp_no,8,1)='2' and emp_name like '��%';

-- 2. �̸��� '��'�ڰ� ���� �������� ���, �����, �μ����� ��ȸ�Ͻÿ�.
select emp_id, emp_name, job_name
from employee
join department on (dept_code=dept_id)
join job using(job_code)
where emp_name like '%��%';

select emp_id, emp_name, job_name
from employee e, department, job j
where dept_code = dept_id and
e.job_code = j.job_code and
emp_name like '%��%';


-- 3. �ؿܿ��� 1��, 2�ο� �ٹ��ϴ� �����
-- �����, ���޸�, �μ��ڵ�, �μ����� ��ȸ�Ͻÿ�.
select emp_name, job_name, dept_code, dept_title
from employee
join department on (dept_code=dept_id)
join job using(job_code)
where dept_title in( '�ؿܿ���1��','�ؿܿ���2��') ;

select emp_name, job_name, dept_code, dept_title
from employee e, department, job j
where dept_code = dept_id and
e.job_code = j.job_code and
dept_title in ('�ؿܿ���1��','�ؿܿ���2��');

--4. ���ʽ�����Ʈ�� �޴� �������� �����, ���ʽ�����Ʈ, �μ���, �ٹ��������� ��ȸ�Ͻÿ�.
select emp_name, bonus,dept_title, local_name
from employee
join department on (dept_code=dept_id)
join location on (location_id = local_code)
where bonus is not null;

select emp_name, bonus, dept_title, local_name
from employee, department, location
where dept_code = dept_id and
location_id = local_code and
bonus is not null;
--5. �μ��� �ִ� ����� �����, ���޸�, �μ���, ������ ��ȸ
select emp_name, job_name, dept_title, local_name 
from employee
join department on (dept_code=dept_id)
join job using (job_code)
join location on (location_id = local_code)
where dept_title is not null;

select emp_name, job_name, dept_title, local_name
from employee e, department, job j, location
where dept_code = dept_id and
e.job_code = j.job_code and
location_id = local_code and
dept_title is not null;

-- 6. �޿���޺� �ּұ޿�(MIN_SAL)���� ���� �޴� ��������
--�����, ���޸�, �޿�, ����(���ʽ�����)�� ��ȸ�Ͻÿ�.
--������ ���ʽ�����Ʈ�� �����Ͻÿ�.
select  emp_name, job_name, salary, SALARY + (SALARY * NVL(BONUS,0))*12
from employee
join job using (job_code)
join sal_grade  using (sal_level)
where min_sal < SALARY + (SALARY * NVL(BONUS,0))*12;


-- 7.�ѱ�(KO)�� �Ϻ�(JP)�� �ٹ��ϴ� ��������
-- �����, �μ���, ������, �������� ��ȸ�Ͻÿ�.
select  emp_name, dept_title, local_name, 
decode(national_code, 'KO','�ѱ�','CH','�߱�', 'JP','�Ϻ�', 'RU', '���þ�' ) ������
from employee
join department on(dept_code = dept_id)
join location on (location_id = local_code)
where national_code in('KO' ,'JP');

-- 8. ���� �μ��� �ٹ��ϴ� �������� �����, �μ��ڵ�, �����̸��� ��ȸ�Ͻÿ�.
-- SELF JOIN ���
select e.emp_name, e.dept_code, n.emp_name
from employee e 
join employee n on (n.dept_code = e.dept_code);

-- 9. ���ʽ�����Ʈ�� ���� ������ �߿��� �����ڵ尡 J4 �� J7 �� �������� �����, ���޸�, �޿���
-- ��ȸ�Ͻÿ�.
-- ��, JOIN, IN ����� ��
select emp_name, job_name, salary
from employee
join job using(job_code)
where bonus is null and
job_code in ('J4','J7');

select emp_name, job_name, salary
from employee e, job j
where  e.job_code = j.job_code and
bonus is null and 
j.job_code in ('J4', 'J7');





------------------------------------------------------------------------------------------



-- 1. �л� �̸��� �ּ����� ǥ���Ͻÿ�. ��, ��� ����� '�л��̸�','�ּ���' �� �ϰ�, ������ �̸����� �������� ǥ���ϵ����Ѵ�.
select student_name "�л��̸�",
student_address "�ּ���"
from tb_student
order by student_name ;



-- 2. �������� �л����� �̸��� �ֹι�ȣ�� ���ư� ���� ������ ȭ�鿡 ����Ͻÿ�
select student_name ,
student_ssn
from tb_student
where absence_yn = 'Y'
order by student_ssn desc;
-- 3. �ּ����� �������� ��⵵�� �л��� �� 1900 ��� �й��� ���� �л����� �̸��� �й�, �ּҸ� �̸��� ������������ ȭ�鿡 ����Ͻÿ�. ��, ����������
-- '�л��̸�','�й�', '������ �ּ�' �� ��µǵ��� �Ѵ�.
select student_name, student_no, student_address
from tb_student
where student_address like '����%' or student_address like '���%' and
substr(student_no,1,1) <> 'A' 
order by student_name;

-- 4. ���� ���а� ���� �� ���� ���̰� ���� ������� �̸��� Ȯ���� �� �ִ� SQ������ �ۼ��Ͻÿ�, (���а��� '�а��ڵ�'�� �а� ���̺�(TB_DEPARTMENT)�� ��ȸ�ؼ� ã�Ƴ���������)
select professor_name, professor_ssn
from tb_professor
where department_no = 005
order by professor_ssn  ;


-- 5. 2004�� 2�б⿡ 'C3118100' ������ ������ �л����� ������ ��ȸ�Ϸ��� �Ѵ�. ������ ���� �л����� ǥ���ϰ�, ������ ������ �й��� ���� �л����� ǥ���ϴ� 
-- ������ �ۼ��غ��ÿ�.
select student_no , point
from tb_student
join tb_grade using (student_no)
where class_no = 'C3118100' and 
term_no = 200402
order by point desc  ,student_no  ;


select student_no, student_name, department_name
from tb_student
join tb_department using (department_no)
order by student_no;

select class_name , department_name
from tb_class
join tb_department using (department_no)
;


select class_name , professor_name
from tb_class
join tb_class_professor using(class_no)
join tb_professor using(professor_no)
order by professor_no ;

select class_name , professor_name
from tb_class 
join tb_class_professor  using (class_no)
join tb_department  using (department_no)
join tb_professor using (professor_no)

where category = '�ι���ȸ';



select student_no, student_name,  round(avg(point),1) "��ü ����"
from tb_student
join tb_grade using(student_no)
join tb_department using(department_no)
join tb_class using(class_no)
where  department_name = '�����а�'
group by student_no, student_name;

select department_name, student_name, professor_name
from tb_student
join tb_department using(department_no)
join tb_professor on( COACH_PROFESSOR_NO = professor_no)
where student_no = 'A313047';
;

select student_name, term_no term_name
from tb_student
join tb_grade using(student_no)
join tb_class using(class_no)
where substr(term_no,1,4) = 2007 and
class_name = '�ΰ������'
group by student_name, term_no
;

select class_name, department_name,category, professor_no
from tb_class
 join tb_department using (department_no)
left join tb_class_professor using(class_no)
where category = '��ü��' and
professor_no is null
;

select student_name,  
decode(professor_name, null,'�������� ������',professor_name)  ��������
from tb_student
join tb_department using(department_no)
left join tb_professor on ( COACH_PROFESSOR_NO = professor_no)
where department_name = '���ݾƾ��а�'
order by student_no 
;

select student_no, student_name, department_name, round(avg(point),1)
from tb_student
join tb_department using (department_no)
join tb_grade using (student_no)
where absence_yn = 'N' 
group by student_no, student_name, department_name
having avg(point) >= 4.0
;

select class_no, class_name, round(avg(point),8)
from tb_grade
join tb_class using( class_no)
join tb_department using(department_no)
where department_name = 'ȯ�������а�' and 
class_type <> '������'
group by class_no, class_name;

select t.student_name, t.student_address
from tb_student t
join tb_student s on (s.department_no = t.department_no)
where t.department_no = 017;



select * from tb_student;
select * from tb_class;
select * from tb_class_professor;
select * from tb_department;
select * from tb_grade;
select * from tb_professor;





































