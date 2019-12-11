/*
  SELECT�� �ؼ� ����
  
  5 : SELECT �÷��� AS ��Ī, ����, �Լ���
  1 : FROM ������ ���̺�� 
     + JOIN  -> JOIN�� ������ �ϳ��� FROM��
  2 : WHERE �÷��� | �Լ��� �񱳿����� �񱳰�
  3 : GROUP BY �׷��� ���� �÷���
  4 : HAVING �׷��Լ��� �񱳿����� �񱳰�
  6 : ORDER BY �÷��� | ��Ī | �÷����� ���Ĺ�� [NULLS FIRST | LAST];
*/

----------------------------------------------------------------------------------------------------------------------------------

-- SUBQUERY(��������)
/*
- �ϳ��� SQL�� �ȿ� ���Ե� �Ǵٸ� SQL��.
- ���� ����(���� ����)�� ���� ���� ������ �ϴ� ������.
*/

-- SUBQUERY Ư�̻���
-- 1) ���� ������ ����Ǳ� �� �� ���� ����
-- 2) �� ������ �����ʿ� ���
-- 3) ���������� �ݵ�� ��ȣ�� ����� ��
-- 4) ���������� ���� �׸��� �ݵ�� ���������� 
-- SELECT�� �׸��� ������ �ڷ����� ��ġ���Ѿ� ��



-- ���� �������� ���� 1
-- �μ��ڵ尡 ���ö����� ���� �Ҽ��� ������ 
-- �̸�, �μ��ڵ� ��ȸ�ϱ�

-- 1) ������� ���ö�� ����� �μ� ��ȸ
SELECT DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '���ö';
-- �μ��ڵ� D9 Ȯ��

-- 2) �μ��ڵ尡 D9�� ������ ��ȸ
SELECT EMP_NAME, DEPT_CODE 
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

-- 3) �μ��ڵ尡 ���ö����� ���� �Ҽ��� ������ 
-- �̸�, �μ��ڵ� ��ȸ�ϱ�
SELECT EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE
                                 FROM EMPLOYEE
                                 WHERE EMP_NAME= '���ö');

-- ���� �������� ���� 2                   
-- �� ������ ��� �޿����� ���� �޿��� �ް� �ִ� ������ 
-- ���, �̸�, �����ڵ� ,�޿� ��ȸ

-- 1) �� ������ ��� �޿� ��ȸ 
SELECT ROUND(AVG(SALARY))
FROM EMPLOYEE;

-- 2) �� �������� �޿��� 3047663�� �̻��� ������� ���, �̸�, �����ڵ�, �޿� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY >= 3047663;

-- 3) �� ������ ��� �޿����� ���� �޿��� �ް� �ִ� ������ 
-- ���, �̸�, �����ڵ� ,�޿� ��ȸ

SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY >= (SELECT ROUND(AVG(SALARY))
                            FROM EMPLOYEE) ;
                            
----------------------------------------------------------------------------------------------------------------------------------

/*  ���������� ����
     
     - ������ �������� : ���������� ��ȸ ��� ���� ������ 1���� ��������
     
     - ������ �������� : ���������� ��ȸ ��� ���� ������ �������� ��������
     
     - ���߿� �������� : ���������� SELECT ���� ������ �÷� ���� �������� ��������
     
     - ������, ���߿� �������� : �������� ��ȸ ����� ���� ��, ���� �÷��� ������ ��������
    
     - ��� �������� : ��ȣ���� ��������
        ���������� ���� ��� ���� ���� ������ �񱳿����� ��
        �������� ���̺��� ���� ����Ǹ�
        ���������� ��� ���� ����Ǵ� ��������
    
     - ��Į�� �������� : SELECT ���� ���Ǵ� �������� 
    
     * ���������� ������ ���� �������� �տ� �ٴ� �����ڰ� �޶�����.
    
*/
----------------------------------------------------------------------------------------------------------------------------------

-- 1. ������ �������� (SINGLE ROW SUBQUERY)
-- ���������� ��ȸ ��� ���� ������ 1���� ��������
-- ������ �������� �տ��� �� ������ ���
-- <, >, <=, >=, =, !=, ^=, <>
-- WHERE ������ �������� ���� ���������� ����� 
-- ���������� WHERE ������ ���� ��� ���� 1:1�� �����ؾ� ��
-- ���������� �÷��� �Ű�Ƚᵵ ��


-- ���� 1-1
-- �� ������ �޿� ��պ��� ���� �޿��� �޴� ������ 
-- �̸�, ����, �μ�, �޿��� ���� ������ �����Ͽ� ��ȸ
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > (SELECT ROUND(AVG(SALARY))
                            FROM EMPLOYEE)
                            --> ��ȸ�ϴ� �÷� 1��, ��� 1�� ��ȸ
ORDER BY EMP_NAME,JOB_CODE, DEPT_CODE
;

-- ���� 1-2                    
-- ���� ���� �޿��� �޴� ������
-- ���, �̸�, ����, �μ�, �޿�, �Ի����� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE,SALARY,HIRE_DATE
FROM EMPLOYEE
WHERE SALARY = (SELECT MIN(SALARY)
                            FROM EMPLOYEE)
;

-- ���� 1-3
-- ���ö ����� �޿����� ���� �޴� ������
-- ���, �̸�, �μ�, ����, �޿��� ��ȸ                 
SELECT EMP_ID, EMP_NAME, DEPT_CODE,SALARY,HIRE_DATE
FROM EMPLOYEE
WHERE SALARY > (SELECT SALARY
                            FROM EMPLOYEE
                            WHERE EMP_NAME = '���ö');


-- ** ���������� WHERE �� �Ӹ� �ƴ϶�
-- SELECT , FROM ,HAVING �������� ��� ����


-- ���� 1-4
-- �μ���(�μ��� ���� ��� ����) �޿��� �հ� �� ���� ū �μ���
-- �μ���, �޿� �հ踦 ��ȸ 

-- 1) �μ��� �޿� �� �� ���� ū�� ��ȸ
SELECT MAX(SUM(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE
;

-- 2) �μ��� �޿����� 17700000�� �μ��� �μ���� �޿� �� ��ȸ
SELECT DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE= DEPT_ID)
--> �μ��� ���� ������ �ֱ� ������ LEFT JOIN
GROUP BY DEPT_TITLE
HAVING SUM(SALARY) = 17700000
;
SELECT * FROM EMPLOYEE;

-- 3) �μ���(�μ��� ���� ��� ����) �޿��� �հ� �� ���� ū �μ���
-- �μ���, �޿� �հ踦 ��ȸ 
SELECT DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE= DEPT_ID)
--> �μ��� ���� ������ �ֱ� ������ LEFT JOIN
GROUP BY DEPT_TITLE
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY))
                                        FROM EMPLOYEE
                                        GROUP BY DEPT_CODE);
                                        --> �÷� 1 ��, ��� �� 1��

----------------------------------------------------------------------------------------------------------------------------------


-- 2. ������ ��������(MULTI ROW SUBQUERY)
-- ���������� ��ȸ ��� ���� ������ ���� ���� ��������
/*
    ������ �������� �տ��� �Ϲ� �񱳿����� ��� X    
    
    - IN / NOT IN
    -> ���� ���� ��� �� �� �ϳ��� ��ġ�ϴ� ���� �ִٸ�
                                                    ��ġ�ϴ� ���� ���ٸ�
    
    -  >ANY, <ANY                                                    
    -> ���� ���� ����� �߿��� �ϳ��� ū / ���� ��� 
    --> ���� ���� ����� �߿��� ���� ���� �� ���� ũ�� ? / ���� ū ������ �۳�?
    
    - > ALL, < ALL 
    -> ���� ���� ������� ��� ������ ū / ���� ���
    --> �������� ������� ��� �� �߿���
         ���� ū ������ ũ�� ? / ���� ���� ������ �۳�?
         
    - EXISTS / NOT EXISTS : ���� �����ϳ�? / �������� �ʳ�?  ==> ������ ���������� ���
         
*/
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY IN (SELECT MAX(SALARY)
FROM EMPLOYEE
GROUP BY  DEPT_CODE)
 ;

SELECT * FROM EMPLOYEE;

-- ���� 2-1
-- �μ��� �ְ� �޿��� �޴� ������ 
-- �̸�, ����, �μ�, �޿��� �μ� ������ �����Ͽ� ��ȸ
SELECT MAX(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

SELECT EMP_NAME, JOB_CODE, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY IN (SELECT MAX(SALARY)
                            FROM EMPLOYEE
                            GROUP BY DEPT_CODE)
                            ORDER BY DEPT_CODE;




-- ���� 2-2
-- ����� �ش��ϴ� ������ ���� ��ȸ 
-- ���, �̸�, �μ���, ���޸�, ����(��� / ����)


-- 1) ����� �ش��ϴ� ��� ��ȣ ��ȸ
SELECT DISTINCT(MANAGER_ID)
FROM EMPLOYEE
WHERE MANAGER_ID IS NOT NULL
;

-- 2) ������ ���, �̸�, �μ���, ���� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE);

-- 3) ����� �ش��ϴ� ������ ���� ���� ���� ��ȸ(�� ��, ������ '���'��)
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, '���' ����/* SELECT ����  '���' �� ���� ���߰�  */
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
WHERE EMP_ID IN (SELECT DISTINCT(MANAGER_ID)
                                FROM EMPLOYEE
                                WHERE MANAGER_ID IS NOT NULL) ;
                                -- MANAGER_ID �� ���� ������� 
                                -- EMP_ID �� MANAGER_ID�� �ش��ϴ� ����� ��ȸ

-- 4) �Ϲ� ������ �ش��ϴ� ����� ���� ��ȸ (�̶�, ������ '���'����)
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, '���' ����
FROM EMPLOYEE 
LEFT JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
JOIN JOB USING (JOB_CODE)
WHERE EMP_ID NOT IN (  SELECT DISTINCT(MANAGER_ID)
                                        FROM EMPLOYEE
                                        WHERE MANAGER_ID IS NOT NULL);
                                        
                                                                                    
-- 5) 3, 4�� ��ȸ ����� �ϳ��� ��ħ -> UNION
-- ����� �ش��ϴ� ������ ���� ��ȸ 
-- ���, �̸�, �μ���, ���޸�, ����(��� / ����)

SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, '���' ����
/* SELECT ����  '���' �� ���� ���߰�  */
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
WHERE EMP_ID IN (SELECT DISTINCT(MANAGER_ID)
                                FROM EMPLOYEE
                                WHERE MANAGER_ID IS NOT NULL) 
                                -- MANAGER_ID �� ���� ������� 
                                -- EMP_ID �� MANAGER_ID�� �ش��ϴ� ����� ��ȸ
UNION

SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, '���' ����
FROM EMPLOYEE 
LEFT JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
JOIN JOB USING (JOB_CODE)
WHERE EMP_ID NOT IN (  SELECT DISTINCT(MANAGER_ID)
                                        FROM EMPLOYEE
                                        WHERE MANAGER_ID IS NOT NULL);

-- 6) 3, 4�� ��ȸ ����� �ϳ��� ��ħ ->SUBQUERY
-- * SELECT �������� �������� ��� ����
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME,
    CASE WHEN EMP_ID IN (
                                            SELECT DISTINCT(MANAGER_ID)
                                            FROM EMPLOYEE
                                            WHERE MANAGER_ID IS NOT NULL) THEN '���'
                                            -- EMP_ID ��  ��������SELECT������� �ϳ��� 
                                            -- ��ġ �Ѵٸ�                                             
                                    ELSE '���'                                        
                            END "����"
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID )
JOIN JOB USING (JOB_CODE);


-- ���� 2-3
-- �븮 ������ ������ �߿��� ���� ������ �ּ� �޿����� ���� �޴� ������
-- ���, �̸�, ����, �޿��� ��ȸ�ϼ���
-- ��, > ANY Ȥ�� < ANY �����ڸ� ����ϼ���




-- 1) ������ �븮�� �������� ���, �̸�, ���޸�, �޿� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '�븮';

SELECT * FROM EMPLOYEE;
SELECT * FROM DEPARTMENT;
SELECT * FROM JOB;
-- 2) ������ ������ ������ �޿� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '����';

-- 3) �븮 ������ ������ �߿��� ���� ������ �ּ� �޿����� ���� �޴� ����
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '�븮' 
AND SALARY > ANY (SELECT SALARY 
                        FROM EMPLOYEE
                        JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
                        JOIN JOB USING (JOB_CODE)
                        WHERE JOB_NAME = '����');
       
-- ���� 2-4
-- ���� ���� �޿��� ���� ū ������ ���� �޴� ���� ������ ����
-- ���, �̸�, ����, �޿��� ��ȸ�ϼ���
-- ��, > ALL Ȥ�� < ALL �����ڸ� ����ϼ���

SELECT EMP_ID,EMP_NAME,JOB_NAME, SALARY
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '����' AND 
SALARY > ANY (SELECT SALARY
                        FROM EMPLOYEE
                        JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
                        JOIN JOB USING (JOB_CODE)
                        WHERE JOB_NAME = '����');
-- ���� ��ü�� ���޺��� ���� �޴� ����
-- ANY ���� : �� ������ ������ �ϳ��� �� ���� �޴� ���� ��ȸ�� ��


-- ** �������� ��ø ���[����]

-- NATIONAL_CODE�� KO�� �μ����� �ٹ��ϰ� �ִ� ������ 
-- ��� ���� ��ȸ

-- LOCATION ���̺��� NATIONAL_CODE�� KO�� LOCAL_CODE ��ȸ
SELECT LOCAL_CODE 
FROM LOCATION
WHERE NATIONAL_CODE = 'KO';

-- DEPARTMENT ���̺��� LOCATION_ID �� L1 �� �μ� �ڵ� ��ȸ
SELECT DEPT_ID
FROM DEPARTMENT
WHERE LOCATION_ID = 'L1';

-- �� �� �������� �ϳ��� ��ħ
SELECT DEPT_ID
FROM DEPARTMENT
WHERE LOCATION_ID = (SELECT LOCAL_CODE 
                                    FROM LOCATION
                                    WHERE NATIONAL_CODE = 'KO');
                                    
                                    
-- ���������� �μ��� �ѱ��� ������ �ٹ��ϰ� �ִ� ���� ���� ��� ��ȸ
SELECT * 
FROM EMPLOYEE
WHERE DEPT_CODE IN (SELECT DEPT_ID
                                    FROM DEPARTMENT
                                    WHERE LOCATION_ID = (SELECT LOCAL_CODE 
                                                                        FROM LOCATION
                                                                        WHERE NATIONAL_CODE = 'KO'));


                              
                              
----------------------------------------------------------------------------------------------------------------------------------

-- 3.  ���߿� ��������
-- �������� SELECT ���� ������ �÷� ���� ���� ���� ��������


-- ���� 3-1
-- ����� ������//�� ���� �μ�, //���� ���޿� �ش�//�ϴ�
-- ����� �̸�, ����, �μ�, �Ի����� ��ȸ        

-- 1) ����� ������ ��ȸ
SELECT EMP_NAME, JOB_CODE,DEPT_CODE, hire_date
FROM EMPLOYEE
WHERE ENT_YN= 'Y' 
AND SUBSTR(EMP_NO,8,1) = '2'
;

SELECT * FROM EMPLOYEE ;

-- 2) ����� �������� ���� �μ�, ���� ���� (���Ͽ�(= ������) ǥ�� �� -> �ϳ��� �÷��� ��)
SELECT EMP_NAME,JOB_CODE, DEPT_CODE , hire_date
FROM EMPLOYEE
-- ����� �������� ���� �μ�
WHERE DEPT_CODE = ( SELECT DEPT_CODE 
                                    FROM EMPLOYEE
                                    WHERE ENT_YN= 'Y' 
                                    AND SUBSTR(EMP_NO,8,1) = '2')                                 
AND JOB_CODE = ( SELECT JOB_CODE
                                    FROM EMPLOYEE
                                    WHERE ENT_YN= 'Y' 
                                    AND SUBSTR(EMP_NO,8,1) = '2' )     
-- ���� �������� ���� (���¸� ����)
AND ENT_YN = 'N'                                    
;
             
-- 3) ����� �������� ���� �μ�, ���� ���� (���� �� ��������)
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE 
WHERE (DEPT_CODE, JOB_CODE) --�ϳ��� ���� �÷��̶�� ��� 
= (SELECT DEPT_CODE, JOB_CODE
    FROM EMPLOYEE
    WHERE ENT_YN = 'Y'
    AND SUBSTR(EMP_NO, 8,1) = '2')
    AND ENT_YN = 'N';
    
             
----------------------------------------------------------------------------------------------------------------------------------        
           
-- 4. ������ ���߿� ��������
-- ���������� ��ȸ ��� �� ���� �÷� ���� �������� ��������

-- ���� 4-1
-- ���� ������ ��� �޿��� �ް� �ִ� ������
-- ���, �̸�, ����, �޿��� ��ȸ�ϼ���
-- ��, �޿��� �޿� ����� ���������� ����ϼ��� TRUNC(�÷���, -5)      

-- 1) �޿��� 200, 600�� �޴� ���� (200��, 600���� ��ձ޿��� ���� �� ���)
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY IN (2000000, 6000000);

-- 2) ���޺� ��� �޿�
SELECT JOB_CODE, TRUNC(AVG(SALARY),-4) -- -4 �� �ڿ������� �����ڸ����� ����
FROM EMPLOYEE
GROUP BY JOB_CODE
;

-- 3) ���� ������ ��� �޿��� �ް� �ִ� ����
 SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE, SALARY) IN (
    SELECT JOB_CODE, TRUNC(AVG(SALARY),-4) -- -4 �� �ڿ������� �����ڸ����� ����
    FROM EMPLOYEE
    GROUP BY JOB_CODE);             
 
---------------------------------------------------------------------------------------------------------------------------------- 

-- 5. ��[ȣ��]�� ��������
-- ��� ������ ���������� ����ϴ� ���̺� ����
-- ���������� �̿��ؼ� ����� ����� ��������

-- ���������� ���̺� ���� ����Ǹ�
-- ������ ������� �ٲ�Ե�.

-- ���� 5-1
-- ����� �ִ� ������ ���, �̸�, �μ���, ������ ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, MANAGER_ID
FROM EMPLOYEE E
WHERE EXISTS ( SELECT EMP_ID
                        FROM EMPLOYEE M
                        WHERE E.MANGER_ID  = M.EMP_ID )
; 
-- SELECT ������ ��ȸ�ϴ� �÷� �� ���������� SELECT �� ����� �ϳ��� �ִ� ��� TRUE
-- ���� ���̺��� ���������� ������ �� ���.
-- �ӵ�����



-- ���� 5-2
-- ���޺� �޿� ��պ��� �޿��� ���� �޴� ������ 
-- �̸�, �����ڵ�, �޿� ��ȸ
SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE E
WHERE SALARY > (SELECT AVG(SALARY)
                            FROM EMPLOYEE M
                            WHERE E.JOB_CODE = M.JOB_CODE) --E.JOB_CODE �� M.JOB_CODE �� ������ ������� ���� ���
; 
-- E.JOB_CODE �� M.JOB_CODE ���� �´� ���(���)�� �����ͼ� WHERE ������ �� ����
-- ������������ SELECT�� ���(E.JOB_CODE)�� ���������� ��� ��(M.JOB_CODE)�� �ϳ��� �����ͼ� ��� ��ȸ



---------------------------------------------------------------------------------------------------------------------------------- 

-- 6. ��Į�� ��������
-- SELECT ���� ���Ǵ� ��������
-- ����� 1�ุ ��ȯ
-- * SQL ���� ���� ���� '��Į��'��� �Ѵ�


-- ���� 6-1
-- �� �������� ���� ������ �޿� ��� ��ȸ
SELECT EMP_NAME, JOB_CODE, SALARY,
FLOOR((SELECT AVG(SALARY) FROM EMPLOYEE M
WHERE E.JOB_CODE = M.JOB_CODE )) "���� ���" 
FROM EMPLOYEE E
;-- E.JOB_CODE : J1 , M.JOB_CODE : J2 
-- J1 - J2, J3, 

-- ��Į�� : SELECT ���� ���Ǹ鼭, �� ������� 1���� ����������
-- ��Į�󱸹� ���� GROUP BY �� �Ƚᵵ �׷��Լ� (AVG, SUM,MAX/MIN ... ) ��밡��
-- ���ñ� : ������ 

    


---------------------------------------------------------------------------------------------------------------------------------- 

-- 7. �ζ��� ��(INLINE-VIEW)
-- FROM ���� ���Ǵ� ��������
-- ���������� ���� ����� ����(RESULT SET) �� ���̺� ��� ���


-- ���� 7-1 : �ζ��κ並 Ȱ���� TOP-N�м�
-- �� ���� �� �޿��� ���� ���� 5����
-- ����, �̸�, �޿� ��ȸ


-- * ROWNUM : SELECT ������ ���. ��ȸ�� ������� 1���� ��ȣ�� �ű�� �÷�
-- ��ȸ ������� ��ȣ �ű��
SELECT ROWNUM, EMP_NAME, SALARY
FROM EMPLOYEE;

-- �޿� �������� �����Ͽ� ��ȣ �ű��
SELECT ROWNUM,EMP_NAME, SALARY
FROM EMPLOYEE  
ORDER BY SALARY DESC;
--> ORDER BY �ؼ� ������ �������̱� ������
-- ��ȣ���� �Ű��� �� �޿� ������������ ���ĵ�

-- ���������� �̿��Ͽ� ���� ����� ���� ���� ��
-- ROWNUM�� �̿��Ͽ� ���� �Ű���
-- ���ΰ� ������ SELECT �÷�����  ���������
SELECT ROWNUM, EMP_NAME, SALARY
FROM (SELECT EMP_NAME, SALARY
            FROM EMPLOYEE
            ORDER BY SALARY DESC) -- �ζ��κ�
WHERE ROWNUM <= 5;
-- ROWNUM�� ���������� SELECT �� ����� WHERE������ �������� ��� ����


-- ���� 7-2
-- �޿� ����� 3�� �ȿ� ��� �μ��� 
-- �μ��ڵ�� �μ���, ��ձ޿��� ��ȸ
SELECT ROWNUM, DEPT_CODE,DEPT_TITLE, ��ձ޿�  -- ������������ ���� ��Ī ��밡��
FROM (SELECT DEPT_CODE, DEPT_TITLE, FLOOR(AVG(SALARY)) ��ձ޿�
            FROM EMPLOYEE
            LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
            GROUP BY DEPT_CODE, DEPT_TITLE 
            ORDER BY ��ձ޿� DESC)
WHERE ROWNUM  <= 3;



SELECT JOB_CODE, DEPT_TITLE, TRUNC(AVG(SALARY))
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
GROUP BY JOB_CODE, DEPT_TITLE
;


---------------------------------------------------------------------------------------------------------------------------------- 

-- 8. WITH
-- ���������� �̸��� �ٿ��ְ� 
-- �������� ��� �� �̸��� �ҷ� ����ϰ� ��
-- �ζ��κ�� ���� ���������� �ַ� ����
-- ����ӵ��� ��������, ���������� ���������� ������ ����


-- ���� 8-1
-- �� ������ �޿� ���� 
-- ����, �̸�, �޿� ��ȸ

WITH TOPN_SAL AS (SELECT EMP_NAME,SALARY
                                FROM EMPLOYEE
                                ORDER BY SALARY DESC)
                                
SELECT ROWNUM,EMP_NAME, SALARY
FROM TOPN_SAL 
;

---------------------------------------------------------------------------------------------------------------------------------- 

-- 9. RANK() OVER / DENSE_RANK() OVER
-- ��ȸ�Ǵ� ����� ���� ������ �Ű���

--  RANK() OVER : 
-- ������ ���� ������ ����� ������ �ο� �� ��ŭ �ǳ� �ٰ� ���
-- EX) ���� 1�� 2�� --> 1�� -> 1�� -> 3��
-- �� ���� �޿� ����
SELECT EMP_NAME, SALARY, 
RANK() OVER  (ORDER BY SALARY DESC) AS ����
FROM EMPLOYEE;

-- DENSE_RANK() OVER : 
-- ������ ���� ������ ����� �ǳʶ��� �ʰ� ���ʴ�� ����
SELECT EMP_NAME, SALARY, 
DENSE_RANK() OVER  (ORDER BY SALARY DESC) AS ����
FROM EMPLOYEE;


-- ������а����� �� ������ ���� ���� �л��� �̸��� �й�

SELECT MAX(POINT)
FROM TB_GRADE
WHERE (
;
SELECT rownum,STUDENT_NO, STUDENT_NAME
FROM (
;
select  rownum, STUDENT_NO, STUDENT_NAME
from 
    (SELECT  STUDENT_NO, STUDENT_NAME, SUM(POINT)
    FROM TB_STUDENT s
    JOIN TB_DEPARTMENT d  on (s.DEPARTMENT_NO= d.DEPARTMENT_NO)
    JOIN TB_GRADE USING (STUDENT_NO)
    JOIN TB_CLASS USING(CLASS_NO)
    WHERE DEPARTMENT_NAME = '������а�'
    group by STUDENT_NO, STUDENT_NAME
    order by SUM(POINT) desc  )    
    
where rownum < 2



;



SELECT * FROM TB_STUDENT;
SELECT * FROM TB_CLASS;
SELECT * FROM TB_CLASS_PROFESSOR;
SELECT * FROM TB_DEPARTMENT;
SELECT * FROM TB_GRADE;
SELECT * FROM TB_PROFESSOR;



SELECT STUDENT_NO, STUDENT_NAME
FROM EMPLOYEE
WHERE 
;
-- 1. ������ ����� �����ִ� �μ������� ��ȸ�Ͻÿ� (��, �������� ����)
SELECT EMP_ID, EMP_NAME, PHONE, HIRE_DATE
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) = (SELECT DEPT_CODE, JOB_CODE 
                                                    FROM EMPLOYEE
                                                    WHERE EMP_NAME = '������')
AND EMP_ID <> (SELECT EMP_ID 
                                                    FROM EMPLOYEE
                                                    WHERE EMP_NAME = '������');


-- ���, �����, ��ȭ��ȣ, �����, �μ���
-- 2. ������� 2000�⵵ ������ ����� �� �޿��� ���� ���� �����
-- ���, �����, ��ȭ��ȣ, �޿�, ���޸��� ��ȸ�Ͻÿ�.

                            
SELECT EMP_ID, EMP_NAME, PHONE, SALARY, JOB_NAME
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE SALARY = (SELECT MAX(SALARY)
                            FROM EMPLOYEE
                            WHERE EXTRACT(YEAR FROM HIRE_DATE) > 2000 );

-- 3. ���ö ����� ���� �μ�, ���� ������ ����� ��ȸ�Ͻÿ�. (��, ���ö ����� ����)
-- ���, �̸�, �μ��ڵ�, �����ڵ�, �μ���, ���޸�
SELECT EMP_ID, EMP_NAME, JOB_CODE, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE (DEPT_CODE, JOB_CODE) = (SELECT DEPT_CODE, JOB_CODE 
                                                    FROM EMPLOYEE
                                                    WHERE EMP_NAME = '���ö')
AND EMP_ID <> (SELECT EMP_ID 
                                                    FROM EMPLOYEE
                                                    WHERE EMP_NAME = '���ö');                                                     ;

-- 4. 2000�⵵�� �Ի��� ����� �μ��� ������ ���� ����� ��ȸ�Ͻÿ�
-- ���, �̸�, �μ��ڵ�, �����ڵ�, �����
SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE,hire_date
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE)= (
                            SELECT DEPT_CODE, JOB_CODE
                            FROM EMPLOYEE
                            WHERE EXTRACT(YEAR FROM HIRE_DATE) = 2000);
-- 5. 77��� ���� ����� ������ �μ��̸鼭 ������ ����� ������ �ִ� ����� ��ȸ�Ͻÿ�
-- ���, �̸�, �μ��ڵ�, �����ȣ, �ֹι�ȣ, �����

SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE,hire_date
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE,MANAGER_ID)= (
                            SELECT DEPT_CODE, JOB_CODE,MANAGER_ID
                            FROM EMPLOYEE
                            WHERE SUBSTR(EMP_NO,1,2) = '77' 
                            AND SUBSTR(EMP_NO,8,1) = '2'                            
                            );                           
                            
-- 6. �μ��� �Ի����� ���� ���� �����
-- ���, �̸�, �μ���(NULL�̸� '�ҼӾ���'), ���޸�, �Ի����� ��ȸ�ϰ�
-- �Ի����� ���� ������ ��ȸ�Ͻÿ�
-- ��, ����� ������ �����ϰ� ��ȸ..




-- ����
SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE,'�ҼӾ���'), JOB_NAME, HIRE_DATE
FROM EMPLOYEE
left JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
WHERE HIRE_DATE < any (
        SELECT MIN(HIRE_DATE)
        FROM EMPLOYEE
        group by dept_code
)

order by hire_date 
;
-- 6. �μ��� �Ի����� ���� ���� �����
-- ���, �̸�, �μ���(NULL�̸� '�ҼӾ���'), ���޸�, �Ի����� ��ȸ�ϰ�
-- �Ի����� ���� ������ ��ȸ�Ͻÿ�
-- ��, ����� ������ �����ϰ� ��ȸ..

SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE,'�ҼӾ���'), JOB_NAME, HIRE_DATE
FROM EMPLOYEE 
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
WHERE HIRE_DATE IN (SELECT MIN(HIRE_DATE)
                                FROM EMPLOYEE 
                                WHERE ENT_YN <> 'Y'
                                GROUP BY DEPT_CODE )                                
ORDER BY HIRE_DATE                                 
;


SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE,'�ҼӾ���'), JOB_NAME, HIRE_DATE
FROM EMPLOYEE E
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
WHERE HIRE_DATE IN (SELECT MIN(HIRE_DATE)
                                FROM EMPLOYEE J
                                WHERE 
                                J.DEPT_CODE = E.DEPT_CODE
                                AND ENT_YN <> 'Y' 
                                OR E.DEPT_CODE IS NULL AND J.DEPT_CODE IS NULL)                                
                                -- ����������� ���ܵ� NULL �� 
ORDER BY HIRE_DATE                                 
;







SELECT MIN(HIRE_DATE)
FROM EMPLOYEE
GROUP BY DEPT_CODE;
-- 7. ���޺� ���̰� ���� � ������
-- ���, �̸�, ���޸�, ����, ���ʽ� ���� ������ ��ȸ�ϰ�
-- ���̼����� �������� �����ϼ���
-- �� ������ \124,800,000 ���� ��µǰ� �ϼ���. (\ : �� ���� ��ȣ)


SELECT EMP_ID, EMP_NAME, JOB_NAME, (EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,2),'RR'))) ���� 
,TO_CHAR( (SALARY + (SALARY*NVL(BONUS,0)))*12, 'L999,999,999') ����
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE EMP_NO IN 
            (SELECT MAX(EMP_NO)
            FROM EMPLOYEE
            GROUP BY JOB_CODE
            )
ORDER BY ���� DESC              ;




SELECT EMP_ID, EMP_NAME, JOB_NAME,DEPT_CODE, (EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,2),'RR'))) ���� 
,TO_CHAR( (SALARY + (SALARY*NVL(BONUS,0)))*12, 'L999,999,999') ����
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,2),'RR')) IN
                    (   SELECT  MIN(EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,2),'RR'))) ����
                        FROM EMPLOYEE
                        GROUP BY JOB_CODE                         
                        )                           

ORDER BY ���� DESC ;











SELECT EMP_ID, EMP_NAME, JOB_NAME,
EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,2),'RR')) ����,
TO_CHAR( (SALARY + (SALARY*NVL(BONUS,0)))*12, 'L999,999,999') ���ʽ����Կ���
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE EMP_NO IN (    SELECT MAX(EMP_NO)
                                FROM EMPLOYEE
                                GROUP BY JOB_CODE)
ORDER BY ���� DESC;                                
    






SELECT EMP_ID, EMP_NAME, JOB_NAME, 
    EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO, 1, 2), 'RR')) + 1 ����,
    TO_CHAR((SALARY + SALARY * NVL(BONUS, 0)) * 12, 'L999,999,999') ���ʽ����Կ���
FROM EMPLOYEE E
JOIN JOB J ON(E.JOB_CODE = J.JOB_CODE)
WHERE 
    EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO, 1, 2), 'RR')) + 1 =  
        (SELECT MIN(EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO, 1, 2), 'RR')) + 1)
            FROM EMPLOYEE M
            WHERE E.JOB_CODE = M.JOB_CODE)
ORDER BY ���� DESC;



