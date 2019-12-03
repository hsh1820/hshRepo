DROP TABLE MEMBER;

CREATE TABLE MEMBER (
  MEMBER_ID VARCHAR2(30) PRIMARY KEY,
  MEMBER_PWD VARCHAR2(30) NOT NULL,
  MEMBER_NAME VARCHAR2(30) NOT NULL,
  GENDER VARCHAR2(10) CHECK (GENDER IN('M','F')),
  EMAIL VARCHAR2(50) NOT NULL,
  PHONE VARCHAR2(30) NOT NULL,
  ADDRESS VARCHAR2(100),
  AGE NUMBER,
  ENROLL_DATE DATE DEFAULT SYSDATE
);


INSERT INTO MEMBER VALUES ('user01', 'pass01', 'ȫ�浿', 'M', 'hong_gd@kh.or.kr', '010-1234-1234', '��⵵ �����ֽ� ���ݵ�', '20', sysdate);
INSERT INTO MEMBER VALUES ('user02', 'pass02', '������', 'M', 'kim_ys@kh.or.kr', '010-1234-1234', '��⵵ ����� ���յ�', '19', sysdate);
INSERT INTO MEMBER VALUES ('user03', 'pass03', '�̼���', 'M', 'lee_ss@kh.or.kr', '010-1234-1234', '����� ������ ���ﵿ', '12', sysdate);
INSERT INTO MEMBER VALUES ('user04', 'pass04', '�迵��', 'M', 'kim_yh@kh.or.kr', '010-1234-1234', '����� ���Ǳ� ��õ��', '27', sysdate);
INSERT INTO MEMBER VALUES ('user05', 'pass05', '��ö��', 'M', 'park_cs@kh.or.kr', '010-1234-1234', '��⵵ ������ ������', '20', sysdate);
INSERT INTO MEMBER VALUES ('user06', 'pass06', '���缮', 'M', 'you_js@kh.or.kr', '010-1234-1234', '��õ������ ��籸 ���絿', '20', sysdate);

COMMIT;

SELECT * FROM MEMBER;