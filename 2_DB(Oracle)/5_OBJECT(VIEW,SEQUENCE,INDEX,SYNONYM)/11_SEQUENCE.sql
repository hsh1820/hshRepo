-- SEQUENCE 
-- ���������� ���� ���� �ڵ����� �����ϴ� ��ü
-- �ڵ� ��ȣ �߻��� ������ ��
    --> ���� PRIMARY KEY �����ϴ� ���ҿ� ����

/*
    [ ǥ���� ]
CREATE SEQUENCE ��������
�� [START WITH ����]                         -> ó�� �߻���ų ���� ��, �⺻�� 1
�� [INCREMENT BY ����]                      -> ���� ���� ���� ����ġ, �⺻�� 1
�� [MAXVALUE ���� | NOMAXVALUE]      -> �߻���ų �ִ밪, 10�� 27��-1���� ����
�� [MINVALUE ���� | NOMINVALUE]        -> �߻���ų �ּҰ�, -10�� 26��
�� [CYCLE | NOCYCLE]                          -> �������� �ִ밪���� ���� �Ϸ� ��
                                                         CYCLE�� START WITH ���� ������ ���ư�
                                                         NOCYCLE�� ���� �߻�
�� [CACHE | NOCACHE]                        -> CACHE�� �޸� �󿡼� ������ �� ����
�⺻�� 20

*/

CREATE SEQUENCE SEQ_EMPID
START WITH 300
INCREMENT  BY 5
MAXVALUE 310
NOCYCLE 
NOCACHE ;

-- ����ڰ� ������ SEQUENCE Ȯ��
SELECT * FROM USER_SEQUENCES;
-- LAST_NUMBER : �ش� �������� ������� �� ���������� ������ ��

----------------------------------------------------------------------

-- SEQUENCE  ���

/*
    ��������.CURRVAL : ������ ������ �������� ���� ��Ÿ���� ���� : LAST_NUMBER �÷��� ��ȸ
    
    ��������.NEXTVAL : �������� ������Ų ��
        - ������ �ִ� ���� ������ ������ INCREMENT BY�� ������ ũ�⸸ŭ ������ ��
        
*/


-- ** ������ ��� �� NEXTVAL�� ������ �Ŀ��� CURRVAL ȣ���� ������ 
/*
    CURRVAL  �� ���������� ������ NEXTVAL�� ���� �����Ͽ� �����ִ� �ӽ� �� 
    
    ������ ���� ���� �� ���� NEXTVAL�� ȣ������ ������ ������ �߻�
    
*/

-- NEXTVAL�� �������� �ʰ� CURRVAL ȣ���� ���� 
SELECT SEQ_EMPID.CURRVAL FROM DUAL; --> �����߻�

--NEXTVAL ���� �� CURRVAL ȣ���ϱ�
SELECT SEQ_EMPID.NEXTVAL FROM DUAL;
SELECT SEQ_EMPID.CURRVAL FROM DUAL;
-- NEXTVAL�� ������ ���� �� ó������ ����� ���
-- START WITH ���� ��ȯ

SELECT SEQ_EMPID.CURRVAL FROM DUAL; -- 300
SELECT SEQ_EMPID.NEXTVAL FROM DUAL; -- 305
SELECT SEQ_EMPID.NEXTVAL FROM DUAL; -- 310
SELECT SEQ_EMPID.NEXTVAL FROM DUAL; -- 315 --> �����߻�
-- ������ MAXVALUE ���� �ʰ��� �� ����

SELECT SEQ_EMPID.CURRVAL FROM DUAL; --310
-- CURRVAL �� ���������� ������ NEXTVAL ���� ��ȯ

-- ��� ������ ����  
-- ��ȸ�Ҷ� ����ϴ� �������� ���� ���Ұ�  INSERT �������������� ��밡��
-- INSERT ���� VALUE �� ****
-- UPDATE���� SET��

-- ������ ������ ���ο� �������� �����Ͽ�
-- ���ο� ��� �߰�

CREATE SEQUENCE SEQ_EID 
START WITH 300
 INCREMENT BY 1 --> 1������ �⺻��
 MAXVALUE 10000
 NOCYCLE
 NOCACHE;
 
INSERT INTO EMPLOYEE VALUES(
    SEQ_EID.NEXTVAL,     'ȫ�浿',    '000101-1234567',    'gd_hone@kh.or.kr',    '01043214321',    'D2','J7','S5', 2500000, 0.1, 200, SYSDATE,NULL,DEFAULT);

SELECT * FROM EMPLOYEE;

INSERT INTO EMPLOYEE VALUES(
    SEQ_EID.NEXTVAL,     'ȫ���',    '000101-2234567',    'gs_hone@kh.or.kr',    '01043214321',    'D2','J7','S5', 2500000, 0.1, 200, SYSDATE,NULL,DEFAULT);
    
SELECT * FROM EMPLOYEE
WHERE EMP_ID = 301;

-- ������ ���� 
DROP SEQUENCE SEQ_EMPID ;

-- ������ ����
ALTER SEQUENCE SEQ_EID
INCREMENT BY 2
MAXVALUE 5000
NOCYCLE
CACHE 20;
-- CACHE 20 : ���� ������ ���� 
--���� ���� -
--ORA-02283: cannot alter starting sequence number
--02283. 00000 -  "cannot alter starting sequence number"

-- * CACHE 
-- �̸� ���� �۾��� ����� ����� �δ� ����
--> ����� �ϼ��Ǿ� �ֱ� ������ ȣ�� �� ��ȯ�� �ϸ� �ǹǷ�
--  �ӵ��� ���� 
--  ���, �̸� ���� ������ �����ϰ� �����Ƿ� ������ ũ�⸦ ������ ���� �߿�

-- SEQUENCE ������ CACHE
-- ������ ���ڸ�ŭ ������ ���� NEXTVAL�� ������� �̸� ������ ��


SELECT * FROM USER_SEQUENCES;






----------------------------------------------------------------------

CREATE TABLE USER_TEST (
    USER_NO      NUMBER PRIMARY KEY NOT NULL  ,
    USER_ID       VARCHAR2(20) UNIQUE,
    USER_PWD    VARCHAR2(20) NOT NULL,
    PNO VARCHAR2(20) NOT NULL UNIQUE,
    GENDER VARCHAR2(3) ,
    PHONE VARCHAR2(20),
    ADDRESS VARCHAR2(100),
    STATUS VARCHAR2(3)  NOT NULL 
);

COMMENT ON COLUMN USER_TEST.USER_NO IS 'ȸ����ȣ';
COMMENT ON COLUMN USER_TEST.USER_ID IS 'ȸ�����̵�';
COMMENT ON COLUMN USER_TEST.USER_PWD IS '��й�ȣ';
COMMENT ON COLUMN USER_TEST.PNO IS '�ֹε�Ϲ�ȣ';
COMMENT ON COLUMN USER_TEST.GENDER IS '����';
COMMENT ON COLUMN USER_TEST.PHONE IS '����ó';
COMMENT ON COLUMN USER_TEST.ADDRESS IS '�ּ�';
COMMENT ON COLUMN USER_TEST.STATUS IS 'Ż�𿩺�';

ALTER TABLE USER_TEST ADD CONSTRAINT CC CHECK( GENDER IN ('��','��'));
ALTER TABLE USER_TEST ADD CONSTRAINT STAT CHECK( STATUS IN ('Y','N'));
