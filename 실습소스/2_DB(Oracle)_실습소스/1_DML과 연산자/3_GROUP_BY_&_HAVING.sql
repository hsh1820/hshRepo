/*  SELECT ���� �ؼ� ����
SELECT �÷��� AS ��Ī, ����, �Լ���, ...
FROM ������ ���̺��
WHERE �÷��� | �Լ��� �񱳿����� �񱳰�
GROUP BY �׷����� ���� �÷���
HAVING �׷��Լ��� �񱳿����� �񱳰� 
ORDER BY �÷��� | ��Ī | �÷����� ���Ĺ�� [ NULLS FIRST / LAST ];

*/


-- EMPLOYEE ���̺���
-- �μ��ڵ尡 D5 �̸� �ѹ���, D6�̸� ��ȹ��
-- D9�̸� �����η� ó���Ͻÿ�
-- ��, �μ��ڵ尡 D5, D6, D9�� ������ ������ ��ȸ
-- => CASE ���� ���
-- �μ��ڵ� ������������ ����

SELECT emp_name, dept_code,
CASE 
    WHEN dept_code='D5' THEN '�ѹ���'
    WHEN dept_code='D6' THEN '��ȹ��'
    WHEN dept_code='D9' THEN '������'
END
FROM employee
WHERE dept_code IN ('D5','D6','D9')
ORDER BY dept_code;


------------------------------------------------------------------------------------------------

-- GROUP BY ��
-- ���� ������ ������ ��ϵ� �÷��� ������
-- ���� ������ �ϳ��� �׷����� �����ִ� ����

-- GROUP BY �÷��� | �Լ��� [, �÷��� | �Լ��� ... ]
--> ���� ���� ���� ��� �ϳ��� ó���� �������� �����
-- �׷����� ���� ���� ���ؼ� SELECT ������ �׷��Լ��� �����
SELECT nvl(dept_code,0), SUM(salary)
FROM employee/* ;  ���� �߻� */
GROUP BY dept_code;  -- SUM(SALARY) -> �μ����� GROUP BY �Ǿ� ��ȸ

-- EMPLOYEE ���̺��� 
-- �μ��ڵ�, �׷�(=�μ��� �׷�����)�� �޿��� �հ�, �׷캰 �޿��� ���(����ó��), �ο����� ��ȸ
-- �μ��ڵ� ������ ����
-- ���� ����ó���� FLOOR / TRUNC ���� ���
SELECT dept_code �μ��ڵ�, 
SUM(salary) �հ�, 
floor(AVG(salary)) ���, 
COUNT(*) �ο���
FROM employee
GROUP BY dept_code
ORDER BY dept_code;

-- EMPLOYEE ���̺��� 
-- �μ��ڵ�� �׷캰 ���ʽ��� �޴� ����� ���� ��ȸ
-- �μ��ڵ� ������ ����
SELECT dept_code, COUNT(bonus)
FROM employee
WHERE bonus IS NOT NULL 
GROUP BY dept_code
ORDER BY dept_code;

-- EMPLOYEE���̺��� ������ ���� �� �޿� ���(����ó��), �޿� �հ�, �ο� �� ��ȸ�ϰ�
-- �ο����� �������� ����
SELECT 
decode(substr(emp_no,8,1),'1', '��', '2','��') AS ����,
floor(AVG(salary)) ���,
SUM(salary) �հ�,
COUNT(*) �ο���
FROM employee
GROUP BY decode(substr(emp_no,8,1),'1', '��', '2','��') 
ORDER BY �ο��� DESC;
--  SELECT ���� �ؼ� ������ GROUP BY �� ���� �ʱ� ������ ��Ī�� �������� ���� �����̹Ƿ� ���Ұ�

-- EMPLOYEE���̺��� �μ� �ڵ� ���� ���� ������ ����� �޿� �հ踦 ��ȸ�ϰ�
-- �μ� �ڵ� ������ ����

SELECT dept_code, job_code, SUM(salary)
FROM employee
GROUP BY dept_code, job_code
HAVING SUM(salary) >= 3000000
ORDER BY dept_code;
-- GROUP �� ���� ������ �������

-- �׷� �Լ��� ���� �� �׷쿡 ���� ������ ������ �� ����ϴ� ����* 
-- HAVING �÷��� | �Լ��� �񱳿����� �񱳰� 

-- �μ��� �޿� ����� 300�� �̻��� �μ� ��ȸ
-- HAVING ������ ��
SELECT dept_code, floor(AVG(salary))
FROM employee
WHERE salary >= 3000000
GROUP BY dept_code
ORDER BY dept_code;
--> �� �μ����� �޿��� 3000000�̻��� �������� �޿��� ��հ��� ���Ǿ� ��ȸ��

-- HAVING ���
SELECT dept_code, floor(AVG(salary))
FROM employee
GROUP BY dept_code
HAVING floor(AVG(salary)) >= 3000000
ORDER BY dept_code;

-- EMPLOYEE ���̺���
-- �μ��� �׷��� �޿� �հ� �� 9�鸸���� �ʰ��ϴ� �μ���
-- �μ��ڵ�� �޿� �հ踦 ��ȸ
-- �μ��ڵ� ������ ����
SELECT dept_code �μ��ڵ�, SUM(salary) �޿��հ�
FROM employee
GROUP BY dept_code
HAVING SUM(salary) > 9000000
ORDER BY dept_code;

-- [ ���� ] SUBQUERY
-- �޿� �հ谡 ���� ���� �μ��� 
-- �μ��ڵ�� �μ� �հ踦 ��ȸ
SELECT dept_code, SUM(salary)
FROM employee
GROUP BY dept_code
HAVING  SUM(salary) = 
(SELECT MAX(SUM(salary))
FROM employee
GROUP BY dept_code)
;

SELECT * FROM employee;


------------------------------------------------------------------------------------------------

-- SET OPERATION (���� ����)
/*
    - ���������� ������ ���� �� �׿� �ش��ϴ�
    ���� ���� ����� ���� �����ϰ� ���� �� ����ϴ� ����
    
    - �ʺ��ڵ��� ����ϱ� ���ٴ� ������ �ִ�.
        --> ������ ��� ����� �ϴ��� �����ϱ� ���� ����
        --> ��� ���� ������ �þ�� ������ �ӵ����ϰ� �߻�
        
    UNION (������) == OR
    INTERSECT (������) == AND
    UNION ALL == UNION + INTERSECT
        --> �ߺ��� ����� �� �� ���Ե�
    MINUS (������) --> �ߺ� ����    
*/

-- UNION : ���� ���� ���� ����� �ϳ��� ��ġ�� ������
-- �ߺ��� ������ �ϳ��� ��ħ == �ߺ��� ���� ������ �ϳ��� ������

-- EMPLOYEE ���̺���
-- �μ��ڵ尡 'D5'�� ������
-- �޿��� 300�� �̻��� ������
-- ���, �̸�, �μ��ڵ�, �޿��� ��ȸ
SELECT emp_id,emp_name, dept_code,salary
FROM employee
WHERE dept_code = 'D5' 

-- EMPLOYEE ���̺���
-- �μ��ڵ尡 'D5'�� ������
-- �޿��� 300�� �ʰ��� ������
-- ���, �̸�, �μ��ڵ�, �޿��� ��ȸ
UNION

SELECT emp_id,emp_name, dept_code,salary
FROM employee
WHERE salary > 3000000;

-- �� ���� ���� OR ������ �̿��ؼ� ��ȸ�ϱ�
SELECT emp_id,emp_name, dept_code, salary
FROM employee
WHERE salary > 3000000 OR dept_code = 'D5';

SELECT emp_id,emp_name, dept_code, salary
FROM employee
WHERE dept_code = 'D5'
INTERSECT
SELECT emp_id,emp_name, dept_code, salary
FROM employee
WHERE salary > 3000000;


SELECT emp_id,emp_name, dept_code, salary
FROM employee
WHERE dept_code = 'D5'
UNION ALL
SELECT emp_id,emp_name, dept_code, salary
FROM employee
WHERE salary > 3000000;




SELECT emp_id,emp_name, dept_code, salary
FROM employee
WHERE dept_code = 'D5'
MINUS
SELECT emp_id,emp_name, dept_code, salary
FROM employee
WHERE salary > 3000000;




------------------------------------------------------------------------------------------
SELECT *
FROM tb_class;

SELECT *
FROM tb_department;



SELECT DISTINCT(department_name),CATEGORY
FROM tb_department;

SELECT DISTINCT(department_name)|| '�� ������ ' || CAPACITY ||'�Դϴ�.'  AS "�а��� ����"
FROM tb_department;



SELECT *
FROM tb_student;

SELECT student_name
FROM tb_student
WHERE  student_no = 'A513079' OR
student_no = 'A513090' OR 
student_no = 'A513091' OR 
student_no = 'A513110' OR
student_no = 'A513119';


SELECT *
FROM tb_department;

SELECT department_name, CATEGORY
FROM tb_department
WHERE CAPACITY >= 20 AND CAPACITY <= 30;

SELECT *
FROM tb_student;

SELECT professor_name
FROM tb_professor
WHERE department_no IS NULL;

SELECT student_name
FROM tb_student
WHERE coach_professor_no IS NULL;


SELECT class_no
FROM tb_class
WHERE preattending_class_no IS NOT NULL;



SELECT *
FROM tb_department;

SELECT DISTINCT CATEGORY
FROM tb_department;


SELECT *
FROM tb_student;

SELECT student_no, student_name, student_ssn
FROM tb_student
WHERE absence_yn <> 'Y' AND 
substr(entrance_date,1,2)='02' AND
substr(student_address,1,3) = '���ֽ�'
;


SELECT *
FROM tb_student;

SELECT student_no, student_name, entrance_date
FROM tb_student
WHERE department_no = '002';


SELECT S
FROM tb_professor;

SELECT professor_name,professor_ssn
FROM tb_professor
WHERE LENGTH(professor_name) <> 3;

SELECT professor_name �����̸�, 
round(months_between(sysdate,TO_DATE(substr(professor_ssn,1,2),'YY'))/12+100) ����
FROM tb_professor
ORDER BY ����;

SELECT substr(professor_name,2,3) �̸�
FROM tb_professor;

SELECT *
FROM tb_student;

SELECT student_no, student_name
FROM tb_student
WHERE floor(ABS(entrance_date - TO_DATE(substr(student_ssn,1,6)))/365) < 20;

SELECT to_char(TO_DATE(20201225),'DAY')
FROM dual;

SELECT to_char(TO_DATE('99/10/11','RR/MM/DD'),'RRRRMMDD')
FROM dual;


SELECT student_no, student_name
FROM tb_student
WHERE substr(student_no,1,1) <> 'A';

SELECT round(AVG(POINT),1) ����
FROM tb_grade
WHERE student_no = 'A517178';
SELECT *
FROM tb_student;

SELECT department_no �а���ȣ,
COUNT(*) "�л���(��)"
FROM tb_student
GROUP BY department_no
ORDER BY department_no ;

SELECT * 
FROM tb_student;

SELECT COUNT(*)
FROM tb_student
WHERE coach_professor_no IS NULL ;



SELECT *
FROM tb_grade
WHERE  student_no = 'A112113';
GROUP BY term_no ;

SELECT *
FROM tb_grade
WHERE student_no = 'A112113'
;
SELECT AVG(POINT)
FROM tb_grade
WHERE student_no = 'A112113'
GROUP BY term_no
 ;

SELECT substr(term_no,1,4),substr(term_no,5,2), round(AVG(POINT),1)
FROM tb_grade
WHERE student_no = 'A112113'
GROUP BY ROLLUP(substr(term_no,1,4)), ROLLUP(substr(term_no,5,2))
ORDER BY 1,2;


