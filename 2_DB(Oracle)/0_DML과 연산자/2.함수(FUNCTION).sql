-- �Լ�(FUCTION)
-- �÷��� ���� �о ����� ����� ������

-- ������(SINGLE ROW) �Լ�
--> �÷��� ��ϵ� N���� ���� �о N���� ����� ����

-- �׷�(GROUP) �Լ�
--> �÷��� ��ϵ� N���� ���� �о 1���� ����� ����



----------------------------------------------------------------------

-- 1. ���� ���� �Լ�
-- LENGTH(����) / LENGTHB(������ ����Ʈ ����)
SELECT LENGTH('����Ŭ'), LENGTHB('����Ŭ')
-- ����Ŭ 11G XE ������ ����1���� 3BYTE�� ���
-- NVARCHAR2 : ���� 1���� �����ڵ� ������ �޾Ƽ� ���� 1���� 2BYTE�� ����Ÿ�� ���氡��
FROM DUAL;
/*
����Ŭ Express Edtion (XE����)��
�ѱ��� 3byte�� �ν�

2byte�� �ν� ��Ű�� ���� ���
����Ǵ� �÷��� Ÿ���� NVARCHAR2�� ����
*/

-- EMPLOYEE ���̺���
-- ��� ����� �̸�, �̸���, �̸��� ����, �̸��� ����Ʈ ũ�� ��ȸ
SELECT EMP_NAME, EMAIL, LENGTH(EMAIL), LENGTHB(EMAIL)
FROM employee;

----------------------------------------------------------------------
-- INSTR
--> INSTR('���ڿ�' | '�÷���', '����', ã�� ��ġ�� ���۰�, [����])
-- ���������� �⺻�� : 1 

SELECT INSTR('AABAACAABBAA','B',4,2) 
FROM DUAL;

----------------------------------------------------------------------
-- LTRIM / RTRIM �� �ڽ��Ҷ� �ѹ��� ���

-- TRIM
-- �־��� �÷��̳� ���ڿ��� �� / �� / ���ʿ� �ִ� ������ ���ڸ� ����
-- ���ڸ� �������� ���� ��� ��������
-- ������ ��ġ�� �������� ���� ��� ���� �������Ű� �⺻��
-- �޸𸮸� ���̰�, ������ ���� �� �ִ� ���� ���� ���
SELECT TRIM('            �鵿��                 ') FROM DUAL;

-- ���� ���� ����
SELECT TRIM( BOTH 'Z' FROM 'ZZZKHZZZ') FROM DUAL;
SELECT TRIM('Z' FROM 'ZZZKHZZZ') FROM DUAL;

-- ���� ���� ����
SELECT TRIM(LEADING 'Z' FROM 'ZZZKHZZZ ') FROM DUAL;

-- ���� ���� ����
SELECT TRIM(TRAILING 'Z' FROM 'ZZZKHZZZ') FROM DUAL;

----------------------------------------------------------------------
-- ** SUBSTR
-- �÷��̳� ���ڿ����� ������ ��ġ���� ������ ������ ���ڿ���
-- �߶󳻾� ��ȯ ( �ڹٿ� String subString()�� ������)
-- ���鵵 �ϳ��� ���ڷ� ������
--> SUBSTR(STRING, POSITION , [LENGTH])
----> STRING : ���� Ÿ�� �÷� �Ǵ� ���ڿ�
----> POSITION : ���ڿ��� �߶� ��ġ, ����� ���۹������, ������ ������ ����
----> LENGTH : ��ȯ�� ���� ����(���� �� ������) (���� �ۼ��� NULL ����)
SELECT SUBSTR('SHOWMETHEMONEY',1,4) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY',4) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY',5,2) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY',7,3) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY',-8,3) FROM DUAL;

-- EMPLOYEE ���̺���
-- EMP_NAME, EMAIL@���ĸ� ������ ���̵� ��ȸ
SELECT EMP_NAME, SUBSTR(EMAIL,1,INSTR(EMAIL,'@')-1)
FROM EMPLOYEE;

-- REPLACE
-- �÷��� ���� �Ǵ� ���ڿ����� Ư�� ����(��)�� ������ ����(��)�� ��ȯ �� ��ȯ 
--> REPLACE(STRING, ��ȯ�� ����(��), ��ȯ�� ����(��))
SELECT REPLACE('����� ������ ���ﵿ', '���ﵿ', '�Ｚ��') FROM DUAL;

SELECT EMAIL, REPLACE(EMAIL,'kh.or.kr', 'gmail.com') as ��ȯ��
from employee;

----------------------------------------------------------------------

-- ROUND : �ݿø�
--> ROUND( ���� | ���ڷε� �÷� [, ��ġ])
SELECT ROUND(123.456) FROM DUAL;
SELECT ROUND(123.678) FROM DUAL;
-- �ݿø��Ͽ� �Ҽ��� ù °�ڸ� ���� ��ȸ
SELECT ROUND(123.456,1) FROM DUAL;
SELECT ROUND(123.456,2) FROM DUAL;

SELECT ROUND(123.456, -2) FROM DUAL;

----------------------------------------------------------------------


-- EXTRACT  : ��, ��, �� ������ �����Ͽ� ��ȯ
-- EXTRACT(YEAR FROM ��¥Ÿ��) : �⵵ ��ȯ
-- EXTRACT(MONTH FROM ��¥Ÿ��) : ����ȯ
-- EXTRACT(DAY FROM ��¥Ÿ��) : �� ��ȯ

-- EMPLOYEE ���̺���
-- ��� ����� �̸�, �Ի� �⵵, �Ի��, �Ի��� ��ȸ
SELECT EMP_NAME, EXTRACT(YEAR FROM HIRE_DATE) "�Ի�⵵",
EXTRACT(MONTH FROM HIRE_DATE)"�Ի� ��",
EXTRACT(DAY FROM HIRE_DATE) "�Ի� ��"
FROM EMPLOYEE;


------------- �ǽ�����----------------------------
-- 1. EMPLOYEE ���̺��� �����, �Ի���-����, ����-�Ի��� ��ȸ
-- ��, ��Ī�� �ٹ��ϼ�1, �ٹ��ϼ�2�� �ϰ�
-- ��� ����ó��, ����� �ǵ��� ó��
SELECT EMP_NAME, ABS(FLOOR(hire_date-SYSDATE)) AS �ٹ��ϼ�1, 
FLOOR(ABS(SYSDATE-HIRE_DATE)) AS �ٹ��ϼ�2
FROM EMPLOYEE;
-- ���� �����ϰ� ���밪���� ����� ���밪 ������ ������ ���� +1 ��������

-- 2. EMPLOYEE ���̺��� ����� Ȧ���� �������� ���� ��� ��ȸ
SELECT * 
FROM employee
WHERE  NOT MOD(EMP_ID,2) = 0;
-- ��Ģ�����δ� ����ȯ�� ���� Ÿ���� �����ִ� ���� ����
WHERE MOD(TO_NUMBER(EMP_ID),2)=1;
-- 3. EMPLOYEE ���̺��� �ٹ� ����� 20��(240����) �̻��� ���� ���� ��ȸ
SELECT *
FROM employee
WHERE TRUNC(MONTHS_BETWEEN(SYSDATE,hire_date)) >= 240;

SELECT *
FROM employee
WHERE ADD_MONTHS(hire_date,240) < SYSDATE ;

-- 4. EMPLOYEE ���̺��� �����, �Ի���, �Ի��� ���� �ٹ��ϼ��� ��ȸ
SELECT EMP_NAME, hire_date, LAST_DAY( HIRE_DATE)-hire_date AS �Ի���Ǳٹ��ϼ�
FROM EMPLOYEE;
EXTRACT(DAY FROM LAST_DAY(hire_date)) - EXTRACT(DAY FROM HIRE_DATE);

-- ��¥ ���� ����
-- DDL����
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';

----------------------------------------------------------------------

-- 4. ����ȯ �Լ�
-- TO_CHAR( ��¥ | ����[, FORMAT]) 
---> ��¥ �Ǵ� ������ �����͸� ������ �����ͷ� ����
----> FORMAT�� �����Ǿ������� �ش� ���� ���·� ����
SELECT TO_CHAR(1234) FROM DUAL;
SELECT TO_CHAR(1234, '99999') FROM DUAL;
-- 5ĭ�� ���� �� ������ ����, ��ĭ�� ������ ä��
SELECT TO_CHAR(1234, '00000') FROM DUAL;


SELECT TO_CHAR(1234, '$99999') FROM DUAL;
-- 5ĭ ���������� ���� ������ ������ ȭ����� ��ȯ

-- �ڸ��� �޸��� ����
SELECT TO_CHAR(1234, 'L999,999,999') FROM DUAL;

SELECT TO_CHAR(1234, '000,000,000') FROM DUAL;

SELECT TO_CHAR(1000, '9.9EEEE') FROM DUAL;

SELECT TO_CHAR(1234,'999') FROM DUAL;
--> ������ ������ ������ �Ѿ� �� ��� #���� ��µ�

-- EMPLOYEE ���̺���
-- �����, �޿� ��ȸ
-- ��, �޿��� '\9,000,000'�������� ǥ���� ��
SELECT EMP_NAME, TO_CHAR(salary, 'L9,000,000') "�޿�"
FROM EMPLOYEE;

------------------------------------------------------------------------------------------
-- ��¥ �����Ϳ� ���� �����ϱ�
SELECT TO_CHAR(SYSDATE, 'AM HH:MI:SS') FROM DUAL;
-- AM, PM �� ����, ������ ǥ��� �������� �ᱹ SYSDATE �������� �������

SELECT  TO_CHAR(SYSDATE,'YYYY-MM-DD PM HH:MI:SS') FROM DUAL;
SELECT  TO_CHAR(SYSDATE,'YYYY-MM-DD DAY HH:MI:SS') FROM DUAL;
SELECT  TO_CHAR(SYSDATE,'YYYY-MM-DD DY HH:MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YEAR, Q') ||'�б�' FROM DUAL;

-- EMPLOYEE ���̺꿡��
-- ��� ����� �̸�, ����� ��ȸ
-- �� , ������� '2019-11-14' �������� ��ȸ�� ��
SELECT EMP_NAME, TO_CHAR(hire_date,'YYYY"��"MM"��"DD"��"') �����  
FROM EMPLOYEE;

------------------------------------------------------------------------------------
-- TO_DATE : ���� �Ǵ� ������ �����͸� ��¥������ ��ȯ
SELECT TO_DATE('20191114') FROM DUAL;
SELECT TO_DATE('20191114','YYYYMMDD') FROM DUAL;
SELECT TO_DATE(20191114,'YYYYMMDD') FROM DUAL;

SELECT TO_DATE('191114','YYMMDD') FROM DUAL;

SELECT TO_CHAR(TO_DATE('191114','YYMMDD'),'YYYY-MM-DD') FROM DUAL;

SELECT TO_DATE('981114','YYMMDD') FROM DUAL;
SELECT TO_CHAR(TO_DATE('981114','YYMMDD'),'YYYY-MM-DD') FROM DUAL;-- 2000�⵵�� ����
SELECT TO_CHAR(TO_DATE('981114','RRMMDD'),'RRRR-MM-DD') FROM DUAL; -- 1900�⵵�� ����

-- EMPLOYEE ���̺���
-- 2000�⵵ ���� �Ի��� ����� 
-- ���, �̸�, �Ի��� ��ȸ
SELECT EMP_ID, EMP_NAME, hire_date
FROM EMPLOYEE
WHERE hire_date >= TO_DATE('000101', 'YYMMDD');

-------------------------------------------------------------------------------
-- TO_NUMBER
SELECT TO_NUMBER('123456789') FROM DUAL;
SELECT '100' + '100' FROM DUAL;
-- ���ڰ� ���ο� ���ڸ� �����ϹǷ�
-- ����Ŭ�� �ڵ����� ���ڷ� ����ȯ�� ������
SELECT '1,000' + '1,000' FROM DUAL;
-- ���ڰ� ���ΰ� ���� + ������ ���·� �ڵ� ����ȯ �Ұ�

SELECT TO_NUMBER('1,000', '9,999') + TO_NUMBER('1,000', '9,999') FROM DUAL;

-------------------------------------------------------------------------------
-- 5. NULL ó�� �Լ�
-- NVL( �÷���, �÷����� NULL�� �� ������ ��)
SELECT EMP_NAME, NVL( BONUS,0)
FROM EMPLOYEE;

SELECT EMP_NAME, (SALARY*12) + (SALARY*12*NVL(BONUS,0) ) AS �Ѽ��ɾ�
FROM EMPLOYEE;


 -- NVL2 (�÷���, ���氪1, ���氪2)
-- �ش� �÷��� ���� ������ ���氪1�� ����
-- �ش� �÷��� NULL �̸� ���氪2�� ����

-- EMPLOYEE ���̺���
-- ���� ���ʽ��� �޴� ����� ���ʽ��� 0.8��
-- ���ʽ��� ���� ���ߴ� ����� ���ʽ��� 0.3���� �����Ͽ�
-- �̸�, ���� ���ʽ�, ����� ���ʽ� ��ȸ
SELECT EMP_NAME, BONUS, NVL2(BONUS, 0.8 , 0.3) 
FROM EMPLOYEE;

-- NULLIF (�񱳴��1, �񱳴��2)
-- �� ���� ���� �����ϸ� NULL, �ٸ��� �񱳴��1 ��ȯ
SELECT NULLIF('123','2123') FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'MM'),
       TO_CHAR(SYSDATE, 'MONTH'),
       TO_CHAR(SYSDATE, 'MON'),
       TO_CHAR(SYSDATE, 'RM')
FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'YYYY'), TO_CHAR(SYSDATE, 'RRRR'),
       TO_CHAR(SYSDATE, 'YY'), TO_CHAR(SYSDATE, 'RR'),
       TO_CHAR(SYSDATE, 'YEAR')
FROM DUAL;



-- �Լ� ���� ����

--1. EMPLOYEE ���̺���
--  ������� �ֹι�ȣ�� ��ȸ
--  ��, �ֹι�ȣ 9��° �ڸ����� �������� '*'���ڷ� ä��
--  �� : ȫ�浿 771120-1******
-- HINT. ���� ������
SELECT EMP_NAME,  SUBSTR(EMP_NO,1,8)|| '******' AS �ֹι�ȣ
FROM EMPLOYEE;
--2. EMPLOYEE ���̺���
--  ������, �����ڵ�, ����(��) ��ȸ
--  ��, �Ѽ��ɾ��� ��57,000,000 ���� ǥ��
--  (�Ѽ��ɾ��� ���ʽ��� ����� 1��ġ �޿�)
SELECT EMP_NAME, JOB_CODE, TO_CHAR((SALARY*12*BONUS),'L999,999,999')
FROM EMPLOYEE;
-- 3. EMPLOYEE ���̺���
--   �μ��ڵ尡 D5, D9�� ������ �߿��� 2004�⵵�� �Ի��� ������ 
--   ��� ����� �μ��ڵ� �Ի��� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, hire_date
FROM EMPLOYEE
WHERE (DEPT_CODE = 'D5' OR DEPT_CODE = 'D9') AND
(HIRE_DATE > '040101') AND (HIRE_DATE < '041231');

WHERE DEPT_CODE IN('D5', 'D9')
AND TO_NUMBER(SUBSTR(HIRE_DATE,1,2))= 4;
-- 4. EMPLOYEE ���̺���
--   ������, �Ի���, �Ի��� ���� �ٹ��ϼ� ��ȸ
--   ��, �Ի��� ���� �ٹ��ϼ��� �����ؼ� +1 �� ��
SELECT EMP_NAME, HIRE_DATE,  (LAST_DAY( HIRE_DATE)-hire_date)+1 AS "�ٹ��ϼ� +1"
FROM EMPLOYEE;
--5. EMPLOYEE ���̺���
--  ������, �μ��ڵ�, �������, ����(��) ��ȸ
--  ��, ��������� �ֹι�ȣ���� �����ؼ�, 
--  ������ ������ �����Ϸ� ��µǰ� ��.
--  ���̴� �ֹι�ȣ���� �����ؼ� ��¥�����ͷ� ��ȯ�� ����, ���
SELECT EMP_NAME, DEPT_CODE,  TO_CHAR(TO_DATE(SUBSTR(EMP_NO,1,6), 'RRMMDD'),'RR"��"MM"��"DD"��"') AS �������, ROUND(MONTHS_BETWEEN(SYSDATE,TO_DATE(SUBSTR(EMP_NO,1,6),'RRMMDD'))/12) AS ����
FROM EMPLOYEE;

SELECT * FROM EMPLOYEE;

------------------------------------------------------------------------------------------------

-- 6. �����Լ�
-- ���� ���� ��쿡 ������ �� �� �ִ� ��� ����

-- DECODE( ���� | �÷���, ���ǰ�1, ���ð�1, ���ǰ�2, ���ð�2 ... , �⺻��)
-- ���ϰ��� �ϴ� �� �Ǵ� �÷��� ���ǽİ� ���ǰ��� ������
-- �ش� ���ð��� ��ȯ
-- ��� ���ǰ��� ����ġ�Ǹ� �⺻�� ��ȯ
-- ��ġ�ϴ� ���� Ȯ���ϴ� �Լ�(Java�� switch�� ���)

-- EMPLOYEE ���̺���
-- ��� ����� ���, �̸�, �ֹε�Ϲ�ȣ, ������ ��ȸ
SELECT EMP_ID, EMP_NAME, EMP_NO,
    DECODE(SUBSTR(EMP_NO,8,1),'1','��','2', '��') AS ����
FROM EMPLOYEE;

-- ������ �޿��� �λ��ϰ��� �Ѵ�
-- �����ڵ尡 J7 �� ������ 10% �λ�
-- �����ڵ尡 J6 �� ������ 15% �λ�
-- �����ڵ尡 J5 �� ������ 20% �λ�
-- �� �� ������ ������ 5%�λ�
-- EMPLOYEE ���̺��� 
-- �̸�, �����ڵ�, �λ� �� �޿�, �λ� �� �޿� ��ȸ
SELECT EMP_NAME, JOB_CODE, salary AS "�λ� �� �޿�",  
DECODE(JOB_CODE,
'J7',SALARY*1.1,
'J6',salary*1.15,
'J5',SALARY*1.2,
SALARY*1.05) AS "�λ� �� �޿�"
FROM EMPLOYEE;


------------------------------------------------------------------------------------------------

-- CASE 
-- ���ϰ��� �ϴ� �� �Ǵ� �÷��� ���ǽİ� ������ ������� ��ȯ
/* [ǥ����]
    CASE WHEN ���ǽ�1 THEN �����1
            WHEN ���ǽ�2 THEN �����2
            ...
            ELSE �����
    END
*/
-- ���ǽ��� ���� ������ ����

-- EMPLOYEE ���̺���
-- ��� ����� ���, �̸�, �ֹε�Ϲ�ȣ, ������ ��ȸ
SELECT EMP_NAME, EMP_NO,
    CASE WHEN SUBSTR(EMP_NO,8,1) = '1' THEN '��'
    ELSE '��'
END AS "����"
FROM EMPLOYEE;

-- ������ �޿��� �λ��ϰ��� �Ѵ�
-- �����ڵ尡 J7 �� ������ 10% �λ�
-- �����ڵ尡 J6 �� ������ 15% �λ�
-- �����ڵ尡 J5 �� ������ 20% �λ�
-- �� �� ������ ������ 5%�λ�
-- EMPLOYEE ���̺��� 
-- �̸�, �����ڵ�, �λ� �� �޿�, �λ� �� �޿� ��ȸ
SELECT EMP_NAME, JOB_CODE, SALARY AS �λ����޿�, 
CASE WHEN JOB_CODE = 'J7' THEN SALARY * 1.1
        WHEN JOB_CODE = 'J6' THEN SALARY * 1.15
        WHEN JOB_CODE = 'J5' THEN SALARY * 1.2
        ELSE SALARY * 1.05
END AS �λ��ı޿�
FROM EMPLOYEE;

-- EMPLOYEE ���̺���
-- ��� ����� �����, �޿�, �޿��� ����� ��ȸ
-- 5000000 �ʰ� -> 1���
-- 3500000 �ʰ� 5000000 ���� -> 2���
-- 2000000 �ʰ� 3500000 ���� -> 3���
-- 2000000 ���� 4���
SELECT EMP_NAME, SALARY, 
CASE WHEN SALARY> 5000000 THEN '1���'
        WHEN SALARY> 3500000 THEN '2���'
        WHEN SALARY> 2000000 THEN '3���'
        ELSE '4���'
END AS ���
FROM EMPLOYEE;

-- EMPLOYEE ���̺��� ���, �����, �޿�, ���� ��ȸ
-- �޿��� 500�� �̻��̰ų�, 250�� ����  'A'
-- ������ 'B'�� �����Ͽ� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY,
CASE WHEN SALARY >= 5000000 
                OR SALARY <= 2500000 
                THEN 'A'
        ELSE 'B'
    END AS ����
FROM EMPLOYEE
ORDER BY ����;

-- �μ��ڵ尡 D5�̸� �ѹ���,
                -- D6�̸� ��ȹ��
                -- D9�̸� �����η� ó���Ͻÿ�.
-- ��, �μ��ڵ尡 D5, D6,D9�� ������ ������ ��ȸ��
SELECT EMP_NAME, DEPT_CODE,
CASE WHEN DEPT_CODE = 'D5' THEN '�ѹ���'
WHEN DEPT_CODE = 'D6' THEN '��ȹ��'
WHEN DEPT_CODE = 'D9' THEN '������'
END AS �μ�
FROM EMPLOYEE
WHERE DEPT_CODE IN('D5','D6','D9');

------------------------------------------------------------------------------------------------

-- �׷� �Լ�
-- �ϳ� �̻��� ���� �׷����� ���� �����ϸ�
-- ����, ��� ���� �ϳ��� �÷������� ��ȯ�ϴ� �Լ�

-- SUM(NUMBER Ÿ���� �÷���) : �հ踦 ���Ͽ� ����

-- EMPLOYEE ���̺��� �� ����� �޿� �� ��ȸ
SELECT SUM(SALARY) FROM EMPLOYEE;

-- EMPLOYEE ���̺��� ���� ����� �޿� ���� ��ȸ
SELECT SUM(SALARY) 
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8,1) ='1' ;

SELECT dept_code, SUM(SALARY)
FROM EMPLOYEE
GROUP BY dept_code;

-- EMPLOYEE ���̺��� �μ��ڵ尡 D5�� ������
-- ���ʽ� ���� ������ ��ȸ
SELECT SUM(SALARY + (SALARY * NVL(BONUS,0))*12) AS ���ʽ����Կ����հ�
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';

-- AVG(NUMBER Ÿ�� �÷�) : ��� �� ����

-- EMPLOYEE ���̺��� �� ����� �޿� ��� ��ȸ
-- �޿� ���(�Ҽ��� �� °�ڸ����� ǥ��)
SELECT ROUND(AVG(SALARY),2) FROM EMPLOYEE;

-- ���ʽ� ��� ��ȸ
-- �Ҽ��� �� ° �ڸ� �ݿø�
-- ���� NULL �ΰ�� 0 ���� ó�� // NULL �� ���� AVG
SELECT ROUND(AVG(NVL(BONUS,0)),2)
FROM EMPLOYEE;
--NULLó�� ������ ��
SELECT ROUND(AVG(BONUS),2)
FROM EMPLOYEE;
-- AVG �Լ� ���� �� NULL���� ��꿡�� ���� 

-- MAX( �÷���) : �ش� �÷����� ���� ū �� ����
-- MIN( �÷���) : �ش� �÷����� ���� ���� �� ���� 
-- �÷��� Ÿ���� ��� ����(ANY TYPE)

-- EMPLOYEE ���̺��� ���� ���� �޿��� ����  ���� �޿� ��ȸ
SELECT MAX(SALARY), MIN(SALARY), COUNT(*), ROUND(AVG(SALARY)), SUM(SALARY)
FROM EMPLOYEE;

-- EMPLOYEE ���̺��� ���� ������ �Ի���, ���� �ֱ� �Ի��� ��ȸ
SELECT  MIN(HIRE_DATE) AS ����������Ի��� , MAX(HIRE_DATE) AS �����ֱ��Ի���
FROM EMPLOYEE;

-- EMPLOYEE ���̺��� 
-- ���ĺ� ������ ���� ���� �̸���, ���� ����(= ���� ū(MAX)) �̸��� ��ȸ
SELECT MIN(EMAIL), MAX(EMAIL)
FROM EMPLOYEE;

-- EMPLOYEE ���̺��� 
-- ����� 200���� ����� �����ϰ�
-- �̸��� ���ĺ� ������ ���� ���� �̸���,
-- ���� �ֱ� �Ի���,
-- ���� ���� �޿� ��ȸ
SELECT MIN(EMAIL), MAX(HIRE_DATE), MAX(SALARY)
FROM EMPLOYEE
WHERE EMP_ID <> 200;

-- COUNT(* | �÷���) : ������ �����ϴ� �� ������ ����
SELECT COUNT(*) FROM EMPLOYEE;
--> COUNT(*) : NULL�� ������ ��ü �� ���� ����

SELECT COUNT(BONUS) FROM EMPLOYEE;
--> COUNT(�÷���) : �ش� �÷����� NULL���� ������ ������ ����

SELECT COUNT(DISTINCT DEPT_CODE) FROM EMPLOYEE;
--> COUNT(DISTINCT �÷���) : �ش� �÷����� �ߺ��� ������ ���� ���� ����

-- EMPLOYEE ���̺��� �μ��ڵ尡 D5�� ������ �� ��ȸ 
SELECT COUNT(*)
FROM EMPLOYEE
WHERE DEPT_CODE='D5';

-- �������� �Ի��Ϸκ��� �⵵�� ������,
-- �� �⵵�� �Ի� �ο����� ���Ͻÿ�.
-- �Ʒ��� �⵵�� �Ի��� �ο����� ��ȸ�Ͻÿ�
-- => TO_CHAR , DECODE, COUNT ���
--------------------------------------------
-- ��ü ������ 2001�� 2002�� 2003�� 2004��
--------------------------------------------
SELECT COUNT(*) AS ��ü������,
COUNT(DECODE(TO_CHAR(EXTRACT(YEAR FROM HIRE_DATE)),'2001','2001' ) )AS "2001��",
COUNT(DECODE(TO_CHAR(EXTRACT(YEAR FROM HIRE_DATE)),'2002','2002' ) )AS "2002��",
COUNT(DECODE(TO_CHAR(EXTRACT(YEAR FROM HIRE_DATE)),'2003','2003' ) )AS "2003��",
COUNT(DECODE(TO_CHAR(EXTRACT(YEAR FROM HIRE_DATE)),'2004','2004' ) )AS "2004��"
FROM EMPLOYEE;








