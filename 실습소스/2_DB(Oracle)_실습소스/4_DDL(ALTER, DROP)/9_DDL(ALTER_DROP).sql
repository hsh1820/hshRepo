-- DDL

-- ALTER 
-- ��ü�� �����ϴ� ����

-- [ ǥ���� ]

/*
    - ���̺� ��ü ���� ��
    ALTER TABLE[ / SEQUENCE] ���̺��
    ������ ����
    
    - ������ ���뿡 ���� �͵�
    ( ������ ) ���̺��� ������ ���õ�
        1) �÷� �߰� / ���� / ����
        2) �������� �߰� / ����
        3) �÷� �ڷ��� ����
        4) DEFAULT �� ����
        5) ���̺� ��, �÷� ��, �������� �� ����    
*/

-- 1. �÷� �߰�, ����, ���� 
SELECT * FROM DEPT_COPY;

-- �÷� �߰�(ADD)
ALTER TABLE DEPT_COPY
ADD (CNAME VARCHAR2(20));

SELECT * FROM DEPT_COPY;

-- �÷� �߰� �� DEFAULT �� ����
ALTER TABLE DEPT_COPY ADD (LNAME VARCHAR2(40) DEFAULT '�ѱ�');

SELECT * FROM DEPT_COPY;

-- �÷� ����(MODIFY)
ALTER TABLE DEPT_COPY 
MODIFY DEPT_ID CHAR(3)
MODIFY DEPT_TITLE VARCHAR2(30)
MODIFY LOCATION_ID VARCHAR2(2)
MODIFY CNAME CHAR(20)
MODIFY LNAME DEFAULT  '�̱�';

-- �÷������� ���ǻ��� 
-- �÷��� ������ ���� ũ�⸦ ������ ��
-- ������ ��ϵ� �� ���� ���� ũ��δ� ���� �Ұ�
ALTER TABLE DEPT_COPY 
MODIFY DEPT_TITLE VARCHAR2(30);

-- LNAME �÷� DEFAULT  �� '�ѱ�'���� ���� �ϱ�
ALTER TABLE DEPT_COPY
MODIFY LNAME DEFAULT '�ѱ�';

INSERT  INTO DEPT_COPY
VALUES ('D11', '�����', 'L2',NULL,DEFAULT);

SELECT * FROM DEPT_COPY;

-- �÷� ����(DROP COLUMN �÷���)
CREATE TABLE DEPT_COPY2
AS SELECT * FROM DEPT_COPY;

SELECT * FROM DEPT_COPY2;

SELECT COLUMN_NAME, DATA_TYPE, NULLABLE, DATA_DEFAULT, COLUMN_ID, COMMENTS
FROM USER_TAB_COLUMNS
NATURAL  JOIN USER_COL_COMMENTS
WHERE TABLE_NAME = 'DEPT_COPY2';
-- ���̺� ���� �� NOT NULL �������Ǹ� ī��
-- COLUMN_ID : �÷��� ������� ����
-- �� ������ DEVELOPER ȯ���� �ƴϿ��� �� ��밡��

-- DEPT_ID �÷� ����
ALTER TABLE DEPT_COPY2 
DROP COLUMN DEPT_ID;

SELECT * FROM DEPT_COPY2;

SELECT COLUMN_NAME, DATA_TYPE, NULLABLE, DATA_DEFAULT, COLUMN_ID, COMMENTS
FROM USER_TAB_COLUMNS
NATURAL  JOIN USER_COL_COMMENTS
WHERE TABLE_NAME = 'DEPT_COPY2';

-- ���̺��� ��� �÷� ���� 
ALTER TABLE DEPT_COPY2
DROP COLUMN LOCATION_ID;

ALTER TABLE DEPT_COPY2
DROP COLUMN CNAME;

ALTER TABLE DEPT_COPY2
DROP COLUMN LNAME;

SELECT * FROM DEPT_COPY2;

ALTER TABLE DEPT_COPY2
DROP COLUMN DEPT_TITLE;
--���� ���� -
    --ORA-12983: cannot drop all columns in a table
    --12983. 00000 -  "cannot drop all columns in a table"
    --*Cause:    An attempt was made to drop all columns in a table.
    --*Action:   Make sure at least one column remains in the table after
    --           the drop column operation.
    -- ���̺� ���� �ִ� �÷��� ���ٸ� ���� �ǹ̰� �����Ƿ�
    -- �÷��� ������ ���� ����.
    
-- TCL�� �ۿ��� �� �ִ� ������ DML �� ����
--> DDL�� ALTER������ ���ۿ� ������� �ʰ� �ٷ� DB�� �ݿ��� �ȴ�.
    --> DDL ���������� ROLLBACK �Ұ���

-- ROLLBACK;    

SELECT * FROM DEPT_COPY2;

-- ���� �� �Խ��� �Խñ� ������ UPDATE�� ���� (0�̸� �Ⱥ����ְ�, 1�̸� �����ִ� ��) => ������ ����


-- ���������� �����Ǿ��ִ� �÷� ����
CREATE TABLE TB1 (
    PK NUMBER PRIMARY KEY ,
    FK NUMBER REFERENCES TB1,
    COL1 NUMBER ,
    CHECK (PK > 0 AND COL1 > 0 )
    -- ������ �����Ͱ� ������ �� PK, COL1�� 0���� ū���̾������ ������ ���� ����
    -- TB1 ���̺��� 4��(PK,FK,CHECK)�� �������� �����Ǿ� �ִ� ��
    --> �ϳ��� �������Ǳ������� 2���� ���������� �����Ǿ���.
);

SELECT * FROM TB1;

-- ���̺� ������ �������� Ȯ��
SELECT * FROM USER_CONSTRAINTS UC
JOIN USER_CONS_COLUMNS UCC USING(CONSTRAINT_NAME)
WHERE UC.TABLE_NAME = 'TB1';

-- PK �÷� ����
ALTER TABLE TB1
DROP COLUMN PK;
--���� ���� -
    --ORA-12992: cannot drop parent key column
    --12992. 00000 -  "cannot drop parent key column"
    --*Cause:    An attempt was made to drop a parent key column.
    --*Action:   Drop all constraints referencing the parent key column, or
    --           specify CASCADE CONSTRAINTS in statement.
-- PK �� FK�� ���� �ϰ� �ֱ� ������ PK ������ ���� ���Ἲ ����
--> CASCADE CONSTRAINT (���� ���Ἲ) �����϶�� �˸���

-- ���� �������� (FK) �� �Բ� PK�÷� ����
ALTER TABLE TB1
DROP COLUMN PK CASCADE CONSTRAINTS;


-- ���̺� ������ �������� Ȯ��
SELECT * FROM USER_CONSTRAINTS UC
JOIN USER_CONS_COLUMNS UCC USING(CONSTRAINT_NAME)
WHERE UC.TABLE_NAME = 'TB1';
--> PK �÷��� �������� ������ ����Ǿ��ִ� PK, CHECK(PK, COL1) ���� ���� 3���� �����ȴ�.
-- CASCADE CONSTRAINTS  �ɼ� : ���� �Ǿ��ִ� ���� ���� ������ PK�� ���ӵǾ��ִ� FK�� �������ǵ� ���� 
-- > �� 4���� �������� ��� ����


----------------------------------------------------------------------

-- 2. �������� �߰� / ���� 

-- DEPT_COPY ���̺��� �������� Ȯ��
SELECT * FROM USER_CONSTRAINTS UC
JOIN USER_CONS_COLUMNS UCC USING(CONSTRAINT_NAME)
WHERE UC.TABLE_NAME = 'DEPT_COPY';

-- �÷� �������� �߰�(ADD CONSTRAINT)
ALTER TABLE DEPT_COPY 
ADD CONSTRAINT DCOPY_DID_PK PRIMARY KEY (DEPT_ID)
ADD CONSTRAINT DCOPY_DTITLE_UNQ UNIQUE (DEPT_TITLE)
-- > SQL ������ ���������� SQL DEVELOPER ������ ���Ͽ�
-- �������� ����
MODIFY LNAME CONSTRAINT DCOPY_LNAME_NN NOT NULL ;

-- DEPT_COPY ���̺��� �������� Ȯ��
SELECT * FROM USER_CONSTRAINTS UC
JOIN USER_CONS_COLUMNS UCC USING(CONSTRAINT_NAME)
WHERE UC.TABLE_NAME = 'DEPT_COPY';
-- NOT NULL �� CONSTRAINT_TYPE �� C, SEARCH_CONDITION �� "LNAME" IS NOT NULL 
-- �������� P, U �̰� SEARCH_CONDITION �� (NULL)
-- �ڵ������� �߰��Ǵ� ������������ C, "DEPT_ID" IS NOT NULL, C, "LOCATION_ID"IS NOT NULL



-- �������� ����(DROP CONSTRAINT �������Ǹ�)
ALTER TABLE DEPT_COPY
DROP CONSTRAINT DCOPY_DID_PK;

-- DEPT_COPY ���̺��� �������� Ȯ��
SELECT * FROM USER_CONSTRAINTS UC
JOIN USER_CONS_COLUMNS UCC USING(CONSTRAINT_NAME)
WHERE UC.TABLE_NAME = 'DEPT_COPY';
-- PK ���������� �����ص� NOT NULL üũ�ϴ� ���������� �Ⱥ��� 


-- DEPT_COPY ���̺� �ִ� ��� �������� ����
ALTER TABLE DEPT_COPY 
DROP CONSTRAINT DCOPY_DTITLE_UNQ
DROP CONSTRAINT DCOPY_LNAME_NN
DROP CONSTRAINT SYS_C007168
DROP CONSTRAINT SYS_C007169
;

-- �÷��� NULL ���� ����� �� �ְ� ����
ALTER TABLE DEPT_COPY 
MODIFY LNAME CONSTRAINT DCOPY_LNAME_NN NOT NULL ;

ALTER TABLE DEPT_COPY
MODIFY  LNAME NULL;
--> NOT NULL �������� ������

SELECT * FROM USER_CONSTRAINTS UC
JOIN USER_CONS_COLUMNS UCC USING(CONSTRAINT_NAME)
WHERE UC.TABLE_NAME = 'DEPT_COPY';


----------------------------------------------------------------------

-- 3. �÷���, �������Ǹ�, ���̺�� �����ϱ� 

-- �÷��� ����(RENAME COLUMN �÷��� TO �����)
SELECT * FROM DEPT_COPY;

ALTER TABLE DEPT_COPY 
RENAME COLUMN DEPT_TITLE 
TO DEPT_NAME;

SELECT * FROM DEPT_COPY;

-- �������Ǹ� ����(RENAME CONSTRAINT �������Ǹ� TO �����)

ALTER TABLE DEPT_COPY 
ADD CONSTRAINT DCOPY_DID_PK PRIMARY KEY (DEPT_ID)
ADD CONSTRAINT DCOPY_DTITLE_UNQ UNIQUE (DEPT_NAME)
MODIFY LNAME CONSTRAINT DCOPY_LN NOT NULL;


SELECT * FROM USER_CONSTRAINTS UC
JOIN USER_CONS_COLUMNS UCC USING(CONSTRAINT_NAME)
WHERE UC.TABLE_NAME = 'DEPT_COPY';

-- DCOPY_DTITLE_UNQ ����������
-- DCOPY_DNAME_UNQ �� �̸� ����
ALTER TABLE DEPT_COPY 
RENAME CONSTRAINT DCOPY_DTITLE_UNQ TO DCOPY_DNAME_UNQ;

SELECT * FROM USER_CONSTRAINTS UC
JOIN USER_CONS_COLUMNS UCC USING(CONSTRAINT_NAME)
WHERE UC.TABLE_NAME = 'DEPT_COPY';

-- ���̺�� ����(RENAME ���̺�� TO �����)
--> DEPT_COPY ���̺� DEPT_TEST �� �̸� ����
ALTER TABLE DEPT_COPY
RENAME TO DEPT_TEST;

SELECT * FROM DEPT_COPY;
--> ���̺���� ����Ǿ� ��ȸ�� ���ٰ� ���� �߻�

SELECT * FROM DEPT_TEST;


----------------------------------------------------------------------

-- DROP
-- �����ͺ��̽� ��ü�� �����ϴ� ����

-- ���̺� ����(DROP TABLE ���̺��)
-- TB1 ���̺� ����
DROP TABLE TB1;

SELECT * FROM TB1;

-- DEPT_TEST
DROP TABLE DEPT_TEST;

CREATE TABLE EMP_COPY
AS SELECT * FROM EMPLOYEE;

CREATE TABLE DEPT_COPY
AS SELECT * FROM DEPARTMENT;

SELECT * FROM DEPT_COPY;
SELECT * FROM EMP_COPY;

-- EMP_CODE -> PK
ALTER TABLE EMP_COPY
ADD CONSTRAINT EMP_PK  PRIMARY KEY (EMP_ID);
-- DEPT_ID -> PK
ALTER TABLE DEPT_COPY
ADD CONSTRAINT DEPT_PK  PRIMARY KEY (DEPT_ID);

-- DEPT_COPY FOREIGN KEY �߰�
ALTER TABLE DEPT_COPY
ADD CONSTRAINT DEPT_FK  FOREIGN KEY (DEPT_ID) REFERENCES EMP_COPY(EMP_ID);


-- DEPT_COPY FOREIGN KEY �߰�
ALTER TABLE DEPT_COPY
DROP CONSTRAINT DEPT_FK
DROP CONSTRAINT SYS_C007194
DROP CONSTRAINT SYS_C007195
;

SELECT * FROM USER_CONSTRAINTS UC
JOIN USER_CONS_COLUMNS UCC USING(CONSTRAINT_NAME)
WHERE UC.TABLE_NAME = 'EMP_COPY';

SELECT * FROM USER_CONSTRAINTS UC
JOIN USER_CONS_COLUMNS UCC USING(CONSTRAINT_NAME)
WHERE UC.TABLE_NAME = 'DEPT_COPY';
-- DEPT_COPY FK => R

DROP TABLE DEPT_COPY ;
--> FK �������� ������ ���� �Ұ�
--> EMP_COPY�� FOREIGN KEY �������ǿ� ���Ͽ� ������ �Ұ�����

-- EMP_COPY�� FOREIGN KEY �������ǰ� �Բ� 
-- DEPT_COPY ���̺� �����ϱ�
DROP TABLE DEPT_COPY
CASCADE CONSTRAINT ;

SELECT * FROM USER_CONSTRAINTS UC
JOIN USER_CONS_COLUMNS UCC USING(CONSTRAINT_NAME)
WHERE UC.TABLE_NAME = 'EMP_COPY';
--> R -> C �� ����
-- > �����������ִ� ���¿��� ���� ���������� �����ϸ� �ٸ� ������ �������ǵ� ���� �����ȴ�.
--> PK - FK ������ �� FK �������� ������ PK�� �������� ������ 

SELECT * FROM USER_CONSTRAINTS UC
JOIN USER_CONS_COLUMNS UCC USING(CONSTRAINT_NAME)
WHERE UC.TABLE_NAME = 'DEPT_COPY';


SELECT STUDENT_NO, STUDENT_NAME
FROM
    (SELECT STUDENT_NO, STUDENT_NAME, AVG(POINT) ����
    FROM TB_GRADE
    JOIN TB_STUDENT USING(STUDENT_NO)
    WHERE DEPARTMENT_NO 
        = (SELECT DEPARTMENT_NO
            FROM TB_DEPARTMENT
            WHERE DEPARTMENT_NAME = '������а�')
    GROUP BY STUDENT_NO, STUDENT_NAME
    ORDER BY ���� DESC)
WHERE ROWNUM = 1;
