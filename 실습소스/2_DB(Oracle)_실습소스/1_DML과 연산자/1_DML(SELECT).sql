-- ��ü ��� ���� ��ȸ
SELECT
    *
FROM
    employee;

-- EMPLOYEE ���̺��� ���, �̸�, ���� ��� ��ȸ

SELECT
    emp_id,
    emp_name,
    salary
FROM
    employee;

SELECT
    *
FROM
    employee;

-- �ǽ����� --
-- 1. JOB ���̺��� ���� ������ ��ȸ

SELECT
    *
FROM
    job;
-- 2. JOB ���̺��� ���޸� ��ȸ

SELECT
    job_name
FROM
    job;
-- 3. DEPARTMENT ���̺��� ��� ���� ��ȸ

SELECT
    *
FROM
    department;
-- 4. EMPLOYEE ���̺��� �̸�, �̸���, ��ȭ��ȣ, ����� ��ȸ

SELECT
    emp_name,
    email,
    phone,
    hire_date
FROM
    employee;
-- 5. EMPLOYEE ���̺��� �����, �����, ���� ��ȸ

SELECT
    hire_date,
    emp_name,
    salary
FROM
    employee;

-- �÷� �� ��� ����
-- EMPLOYEE ���̺��� ������ �̸��� ���� ��ȸ

SELECT
    emp_name,
    salary * 12
FROM
    employee;
    
-- EMPLOYEE ���̺��� ������ �̸��� ���� ��ȸ, ���ʽ��� �ݿ��� ����

SELECT
    emp_name,
    salary * 12,
    ( salary + ( salary * bonus ) ) * 12
FROM
    employee;
-- ��� ���� �� NULL ���� ���ԵǾ� ������ ����� NULL�� ��.

---- �ǽ����� ----
-- 1. EMPLOYEE ���̺��� �̸�, ����, �Ѽ��ɾ�(����+���ʽ�), �Ǽ��ɾ�(�� ���ɾ� - ����3%)
select Emp_name as �̸� , salary*12 as ����, (salary*12)+ bonus as �Ѽ��ɾ�, (salary*12)+ bonus-(((salary*12)+ bonus)*0.3) as �Ǽ��ɾ�
from Employee;
-- 2.EMPLOYEE ���̺��� 
-- �̸�, �����, �ٹ��ϼ�(���� ��¥ - �����) ��ȸ
-- *DATE ���� ������ ��� ���갡��
-- *���� �ð�(��¥)�� ��ȸ�ϴ� Ű���� == SYSDATE
select emp_name, hire_date,to_date(to_char(sysdate-hire_date,'yy/mm/dd')) as �ٹ��ϼ�
from EMPLOYEE;

select * from EMPLOYEE;

SELECT to_char(trunc(sysdate,'dd')  ) FROM dual ; 

select (mod((trunc(sysdate)-hire_date),12) ) as ����� from employee;

   select
 to_date('20090301', 'yyyymmdd')+1 - to_date('20090225', 'yyyymmdd')
from dual;

select 
trunc(sysdate-hire_date)
from employee;

-- EMPLOYEE ���̺��� ������ �̸��� ����(��Ī : ����(��)),
-- ���ʽ��� �ݿ��� ����(��Ī : �� �ҵ�(��)), ��ȸ�ϱ�
-- (���ʽ��� �ݿ��� ���� = (�޿�+(�޿�*���ʽ�)) *12
select emp_name, 
salary*12 as "����(��)", 
(salary*12)+((salary*12)*bonus) as "�� �ҵ�(��)"
from employee;

-- ���ͷ�

-- EMPLOYEE ���̺��� ������ 
-- ���, �̸�, �޿�, ����(������ : ��) ��ȸ
select emp_id, emp_name, salary,
'��' as ���� 
from employee;

-- DISTINCT
-- �÷��� ���Ե� �ߺ����� �� ������ ǥ���ϰ��� �� �� 
-- ����ϴ� Ű����

-- EMPLOYEE ���̺��� ������ ���� �ڵ� ��ȸ
select * from employee;
select job_code from employee;
-- EMPLOYEE ���̺��� ������ ���� �ڵ� �ߺ� �����Ͽ� ��ȸ
select DISTINCT job_code from employee ;

-- ***** where �� *****
-- ��ȸ�� ���̺��� ������ �´� ���� ���� ���� ��󳻴� ����
/* [ǥ����]
SELECT �÷���
FROM ���̺��
WHERE ���ǽ�;
*/

-- * �񱳿�����
-- =(����), > (ũ��), < (�۴�) >= (ũ�ų�����), <=(�۰ų� ����)
-- !=, ^=, <> (�����ʴ�)
select * from employee;
-- EMPLOYEE ���̺��� �μ��ڵ尡 'D9'�� ������ �̸�, �μ��ڵ� ��ȸ
select emp_name, employee.dept_code
from employee
where dept_code = 'D9';
-- EMPLOYEE ���̺��� �޿��� 4000000 �̻��� ������ �̸�, �޿� ��ȸ
select emp_name, salary
from employee
where salary > 4000000 ;
-- EMPLOYEE ���̺��� �μ��ڵ尡 D9�� �ƴ� ����� ���, �̸�, �μ��ڵ� ��ȸ
select emp_id, emp_name,dept_code 
from employee
where dept_code <> 'D9';

-- EMPLOYEE ���̺��� ��� ���ΰ� N �� ������ ��ȸ�ϰ�
-- �ٹ� ���θ� '������' ���� ǥ���Ͽ�
-- ���, �̸�, �����, �ٹ����θ� ��ȸ
select emp_id, emp_name,hire_date,'������' as �ٹ�����
from employee
where ent_yn = 'N';

-- EMPLOYEE ���̺���
-- �� ���ɾ�(�Ѽ��ɾ�(����+���ʽ�) - (����*���� %3)�� 5õ���� �̻��� ����� 
-- �̸�, ����, �Ǽ��ɾ�, ����� ��ȸ
select emp_name, salary,((salary + (salary*bonus))*12)-(salary*12*0.03) as �Ǽ��ɾ�, hire_date
from employee
where ((salary+(salary*bonus))*12)-(salary*12*0.03) >= 50000000;

-- EMPLOYEE ���̺��� �μ��ڵ尡 'D6' �̰�
-- �޿��� 200�� �̻� �޴� ������
-- �̸�, �μ��ڵ�, �޿��� ��ȸ
select emp_name, dept_code, salary
from employee
where dept_code = 'D6' and salary > 2000000;
-- EMPLOYEE ���̺��� �μ��ڵ尡 'D6' �̰ų�
-- �޿��� 200�� �̻� �޴� ������
-- �̸�, �μ��ڵ�, �޿��� ��ȸ
select emp_name, dept_code, salary
from employee
where dept_code = 'D6' or salary > 2000000;

-- EMPLOYEE ���̺��� 
-- �޿��� 350���� �̻� 600���� ���Ϸ� �޴� ������
-- ���, �̸�, �޿�, �μ��ڵ�, �����ڵ带 ��ȸ
select emp_name, dept_code, salary, dept_code, job_code
from employee
where salary > 3500000 and salary > 6000000;

select *
from employee;

-- �ǽ� ���� -- 
-- 1. EMPLOYEE ���̺��� ������ 4000000�̻��̰� job_code�� j2�� ����� ��ü ���� ��ȸ
select *
from employee
where salary > 4000000 and job_code = 'J2';
-- 2. EMPLOYEE ���̺��� dept_code�� d9�̰ų� d5�� �����
-- ������� 02�� 1�� 1�� ���� ���� �����
-- �̸�, �μ��ڵ�, ����� ��ȸ
-- tip ���� ������ ��� ���� �߿� ���� ������ �˻��ؾߵǴ� ��� ���θ� ���� ��
select emp_name, dept_code, hire_date
from employee
where (dept_code = 'D9' or dept_code = 'D5') and hire_date < '020101';

-- BETWEEN 'a' and 'b'
-- >> a �̻� b ����

-- EMPLOYEE ���̺��� 
-- �޿��� 350���� �̻� 600���� ���Ϸ� �޴� ������
-- ���, �̸�, �޿�, �μ��ڵ�, �����ڵ带 ��ȸ
select emp_id, emp_name, salary, dept_code
from employee
where salary BETWEEN 3500000 and 6000000;

-- EMPLOYEE ���̺��� 
-- �޿��� 350���� �̸� 600���� �ʰ��� �޴� ������
-- ���, �̸�, �޿�, �μ��ڵ�, �����ڵ带 ��ȸ
select emp_id, emp_name, salary, dept_code
from employee
where salary NOT BETWEEN 3500000 and 6000000;
-- NOT Ű����� �÷��� �Ǵ� BETWEEN �տ� ���̴°� ����

-- EMPLOYEE ���̺��� 
-- ������� '90/01/01' ~ '01/01/01' �� ����� 
-- ��� ���� ��ȸ
select *
from EMPLOYEE
where HIRE_DATE between '900101' and '010101';

-- ���� ������(||)
-- ���� �÷��� �ϳ��� �÷��� �� ó�� �����ϰų� 
-- �÷��� ���ͷ��� ������ �� �ִ�.

-- EMPLOYEE ���̺��� ���, �̸�, �޿��� �����Ͽ� ��ȸ
select emp_id || emp_name || salary 
from employee;

-- �÷��� ���ͷ� ����
select emp_name || '�� ������' || salary || '�� �Դϴ�.' as �޼���
from employee;

-- ** LIKE
-- ���Ϸ��� ���� ������ Ư�� ������ ������Ű���� ��ȸ �� ��
-- �񱳴���÷��� LIKE '��������'
-- �������� �˻� ����
/* 
1) ��������
'A%' (A�� �����ϴ� ��)
'%A' (A�� ������ ��)
'%A%' (A�� ���ԵǴ� ��)

2) ���ڼ� 
'_' : (�� ����)
'__' : (�� ����)
*/
-- from employee ���� 
-- ���� ������ ����� 
-- ���, �̸�, ����� ��ȸ
select emp_id, emp_name, hire_date
from employee
where emp_name like '��%';

-- from employee ���� �̸��� '��'�� ���Ե� ������
-- �̸�, �ֹι�ȣ, �μ��ڵ� ��ȸ
select emp_name, emp_no, dept_code
from employee
where emp_name like '%��%';

-- EMPLOYEE ���̺��� 
-- ��ȭ��ȣ �� ��° �ڸ��� 7�� �����ϴ� ����� 
-- ���, �̸�, ��ȭ��ȣ ��ȸ
select emp_id, emp_name, phone
from employee
where phone like '___7%';

-- EMPLOYEE ���̺��� 
-- �̸��� �� �ձ��ڰ� ���ڸ��� �����
-- ���, �̸�, �̸��� �ּ� ��ȸ
select emp_id, emp_name, email
from employee
where email like '____%';

select emp_id, emp_name, email
from employee
where email like '___@_%'ESCAPE '@';

-- NOT LIKE
-- Ư�� ������ �������� �ʴ� ���� ��ȸ

-- EMPLOYEE ���̺��� 
-- �达 ���� �ƴ� ����� ���, �̸�, ����� ��ȸ
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE /*NOT*/ EMP_NAME NOT LIKE '��%';

-- EMPLOYEE ���̺���
-- �̸� ���� '��'���� ������ ����� �̸� ��ȸ
SELECT emp_name
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%��';

-- EMPLOYEE ���̺���
-- ��ȭ��ȣ ó�� 3�ڸ��� 010�� �ƴ� ����� �̸�, ��ȭ��ȣ�� ��ȸ

SELECT emp_name, PHONE
FROM EMPLOYEE
WHERE PHONE NOT LIKE '010%';
-- EMPLOYEE ���̺���
-- �����ּ� '_'�� ���� 4�� �̸鼭 DEPT_CODE�� D9 �Ǵ� D6�̰�
-- ������� 90/01/01 ~ 00/12/01�̰�,
-- �޿��� 270�� �̻��� ����� ��ü�� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE (EMAIL LIKE '____#_%' ESCAPE '#') AND 
(DEPT_CODE = 'D9' OR DEPT_CODE = 'D6') AND
(hire_date BETWEEN '900101' AND  '001201') AND
(salary >= 2700000);

-- IS NULL : �÷����� NULL�� ���
-- IS NOT NULL : �÷����� NULL�� �ƴ� ���

-- EMPLOYEE ���̺���
-- ���ʽ��� ���� �ʴ� �����
-- ���, �̸�, �޿�, ���ʽ� ��ȸ
SELECT emp_id, emp_NAME, salary, bonus
FROM EMPLOYEE
WHERE bonus IS NULL;

-- EMPLOYEE ���̺���
-- ���ʽ��� �޴� �����
-- ���, �̸�, �޿�, ���ʽ� ��ȸ
SELECT emp_id, emp_NAME, salary, bonus
FROM EMPLOYEE
WHERE bonus IS NOT NULL;

-- EMPLOYEE ���̺���
-- �����ڵ� ����, �μ���ġ�� ���� ���� ����� 
-- �����, ������, �μ��ڵ� ��ȸ
SELECT EMP_NAME, MANAGER_ID, DEPT_CODE
FROM employee
WHERE MANAGER_ID IS NULL AND DEPT_CODE IS NULL;

-- EMPLOYEE ���̺���
-- �μ� ��ġ�� �޾����� 
-- ���ʽ��� ���޹��� ���ϴ� �����
-- �̸�, ���ʽ�, �μ��ڵ� ��ȸ
SELECT emp_name, boNUS, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL
AND bonus IS NULL;

-- ���Ϸ��� ���� ��Ͽ� ��ġ�ϴ� ���� ������ TRUE�� ��ȯ�ϴ� ������
-- �񱳴���÷��� IN(XXX,...);

-- EMPLOYEE ���̺���
-- D6 �μ��� D8�μ������� 
-- �̸�, �μ��ڵ�, �޿� ��ȸ

-- IN ��� X
SELECT emp_name, DEPT_CODE, salary
FROM employee
WHERE DEPT_CODE = 'D6' OR dept_code = 'D8';

-- IN ��� O
SELECT emp_name, DEPT_CODE, salary
FROM employee
WHERE DEPT_CODE IN ('D6','D8');

-- ������ �켱����
/*
1. ��� ������
2. ���� ������
3. �� ������
4. IS NULL / IS NOT NULL , LIKE, IN / NOT IN
5. BETWEEN AND / NOT BETWEEN AND
6. �� ������ - NOT
7. �� ������ - AND 
8. �� ������ - OR // OR �� �����͵� AND �� ���� Ȯ��
*/

--------------------------------------------------------

-- *** ORDER BY ��
-- SELECT�� ����� ������ �� �ۼ��ϴ� ����
-- SELECT ���� ���� �������� �ۼ�
-- SELECT ���� ���� �� ���� ������ 
-- ���� ���� : 1 FROM -> 2 WHERE -> 3 SELECT -> 5 ORDER BY
/* [ǥ����]
SELECT �÷���[,�÷���,...]
FROM ���̺��
[WHERE ���ǽ�]
[ORDER BY �÷��� | ��Ī | �÷����� ���Ĺ�� [NULLS FIRST | LAST]]
--[NULLS FIRST | LAST] : NULL ���� ���� �������� ��ġ
-- NULLS FIRST : ���� ������ �÷��� NULL ���� ������ �պκп� �����ϱ�
-- NULLS LAST : NULLS FIRST�� �ݴ�
*/

-- EMPLOYEE ���̺���
-- �޿� �������� ������� 
-- �̸�,�޿�, �μ��ڵ�, �����ڵ�, ����� ��ȸ
SELECT emp_name, SALARY, DEPT_CODE, job_code, hire_date
FROM employee
ORDER BY SALARY ; -- ASC : ��������(��������)

-- EMPLOYEE ���̺���
-- ���� �������� ������� 
-- �̸�,����, �μ��ڵ�, �����ڵ�, ����� ��ȸ
SELECT emp_name, (SALARY*12) AS ����, DEPT_CODE, job_code, hire_date
FROM employee
ORDER BY 2 DESC;
ORDER BY (SALARY*12) DESC;
ORDER BY '����' DESC;