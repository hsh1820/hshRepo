/*
    데이터 딕셔너리란?
    - 자원을 효율적으로 관리하기 위한 다양한 정보를 저장하는 시스템 테이블
    - 데이터 딕셔너리는 사용자가 테이블을 생성하거나 사용자를 변경하는 등의 
      작업을 진행할 때 데이터베이스 서버(오라클 DBMS가 자체적으로)에 의해 자동으로 갱신되는 테이블  
      
    - USER_TABLES : 사용자 계정이 소유한 테이블의 정보를 조회할 수 있는
      딕셔너리 뷰 (= 사전에서 만들어 놓은 가상의 테이블)

    - USER_TAB_COLUMNS : 사용자가 작성한 테이블의 컬럼과 관련된 정보 확인용 뷰      

    - USER_CONSTRAINTS : 사용자가 작성한 제약조건을 확인하는 뷰

    - USER_CONS_COLUMNS : 제약 조건이 걸려있는 컬럼 확인용 뷰


  -- 딕셔너리 종류 추가될 때 마다 쓰기
  
  
  
  
  
  
  
  
  
  
      
*/

/*
    DDL (DATA DEFINITION LANGUAGE) : 데이터 정의 언어
    
    - 객체(OBJECT)를 만들고(CREATE), 수정하고(ALTER), 삭제(DROP) 하는 등의
        데이터의 전체적인 구조를 정의하는 언어로 
        주로 DB관리자, 설계자가 사용하는 언어
        
    * 오라클에서의 객체(OBJECT) 종류
           테이블(TABLE), 뷰(VIEW), 시퀀스(SEQUENCE), 
           인덱스(INDEX), 패키지(PACKAGE(객체들을 묶어 놓을 수 있는 객체)), 트리거(TRIGGER),
           프로시져(PROCEDURE), 함수(FUNCTION), 
           동의어(SYNONYM), 사용자(USER), 
*/
----------------------------------------------------------------------
/*
    < CREATE >
    - 테이블이나 인덱스, 뷰 등 다양한 DB 객체를 생성하는 구문
    
    1. 테이블 만들기
    - 테이블이란?
        행(ROW)과 열(COLUMN) 으로 구성되는 
        가장 기본적인 데이터베이스 객체
        
        데이터베이스 내에서 모든 데이터는 테이블을 통해 저장됨 
        
        [표현식]
        CREATE TABLE 테이블명 (
            컬럼명 자료형(크기) [제약조건] [기본값],
            컬럼명 자료형(크기) [제약조건] [기본값],            
            ...
        
        [제약조건]      
        
        );
        
        주로사용하는 데이터형
        - CHAR, VARCHAR2, NUMBER, NUMBER(길이), DATE
        - LOB(CLOB- 대용량 데이터를 DB에 저장할 때 사용), TIMESTAMP
        
        
        

*/

-- DROP TABLE MEMBER;

CREATE TABLE MEMBER (
    MEMBER_ID        VARCHAR2(20),
    MEMEBER_PWD    VARCHAR2(20),
    MEMBER_NAME    VARCHAR2(30),
    ENROLL_DATE      DATE DEFAULT SYSDATE  
    
);

-- 생성된 테이블 확인 방법 
-- 1) SELCT *
SELECT * FROM member;

-- 2) 좀더 확실한 방법 ) 
SELECT * FROM USER_TABLES;
-- USER_TABLES : 사용자가 작성한 테이블을 확인할 수 있는 
--                      가상의 테이블( == 뷰) 
-- 데이터 딕셔너리에 정의되어 있음으로 인해 뷰로 사용가능

-- 컬럼 코멘트(주석) 추가
COMMENT ON COLUMN MEMBER.MEMBER_ID IS  '회원아이디';
COMMENT ON COLUMN MEMBER.MEMEBER_PWD IS  '회원비밀번호';
COMMENT ON COLUMN MEMBER.MEMBER_NAME IS  '회원이름';
COMMENT ON COLUMN MEMBER.ENROLL_DATE IS  '회원가입일';


-- 생성된 테이블 컬럼 정보 확인
SELECT * FROM USER_TAB_COLUMNS
WHERE TABLE_NAME = 'MEMBER';
-- USER_TAB_COLUMNS : 사용자가 작성한 테이블의 컬럼과 관련된 정보 확인용 뷰


DESC MEMBER;
-- DESC (DESCRIBE, 묘사) : 테이블의 구조를 간단히 표시하는 구문 -- 스크립트
-- 오라클에서만 사용 가능 

-- 샘플데이터 삽입
INSERT INTO MEMBER 
VALUES ('MEM1','1234ABCD','홍길동','2019-11-20');
INSERT INTO MEMBER 
VALUES ('MEM2','QWER1234','김영희',SYSDATE);
INSERT INTO MEMBER 
VALUES ('MEM3','1Q2W3E4R','박철수',DEFAULT );
INSERT INTO MEMBER(MEMBER_ID, MEMEBER_PWD,MEMBER_NAME) 
VALUES ('MEM4','ZXCV9876','김태훈');


--DELETE FROM MEMBER WHERE MEMBER_NAME = '김태훈';
SELECT * FROM MEMBER;


----------------------------------------------------------------------

-- 제약 조건 (CONSTRAINTS)
/*
    - 사용자가 원하는 조건의 데이터만 유지하기 위해서 
    특정 컬럼에 설정하는 제약
    
    - 테이블 작성 시 컬럼에 대해 값 기록에 대한 제약조건 설정 가능
    
    - 제약조건을 거는 이유 : 데이터의 무결성을 보장하기 위해서 사용

    - 입력 데이터에 문제가 없는지 자동으로 검사할 목적으로 사용
    
    - 데이터의 수정 / 삭제 가능 여부 검사 목적으로 사용
    --> 관계형 데이터 베이스에서 생기는 문제점을 막기 위해 사용
    ---> JOIN시 각 테이블에서 참조되는 컬럼명/값이 한쪽에서 변경될 때 JOIN되어 있는 테이블에서도
    변경할지 검사 가능
    
    * 제약 조건의 종류
        PRIMARY KEY 
        UNIQUE 
        NOT NULL
        CHECK
        FOREIGN KEY
        
*/

-- NOT NULL 제약조건
-- 해당 컬럼에 반드시 값이 기록되어야 하는 경우에 사용하는 제약조건
-- 데이터 삽입, 수정 시 NULL 값을 허용하지 않도록
-- ** 컬럼레벨에서 제한을 한다. ** 

-- 제약 조건 없는 테이블
CREATE TABLE MEM_NOCONST(
    MEM_NO          NUMBER,
    MEM_ID           VARCHAR2(20),
    MEM_PWD        VARCHAR2(20),
    MEM_NAME      VARCHAR2(30),
    MEM_GENDER    CHAR(1),
    MEM_PHONE     VARCHAR2(20),
    MEM_EMAIL      VARCHAR2(50)
);



INSERT INTO MEM_NOCONST
VALUES (1,'user01','pass01','홍길동','M', '010-1234-1234', 'gd_hong123@kh.or.kr');

--SELECT * FROM mem_noconst;
--SELECT * FROM USER_TABLES;
--select * from USER_TAB_COLUMNS
--where TABLE_NAME= 'MEM_NOCONST';  -- 컬럼명 대소문자 구분함
--(UPPER( & TABLE_NAME) )
INSERT INTO MEM_NOCONST
VALUES (2,null,null,null,null, '010-1234-1234', 'aaa@kh.or.kr');


-- NOT NULL 제약조건을 설정한 테이블 생성
-- 1) 컬럼 레벨 방식 : 컬럼 기입 시 컬럼 뒤쪽에 제약조건 추가 방법
-- 2) 테이블 레벨 방식 : 테이블 생성구문 마지막에 별도 추가 
CREATE TABLE MEM_NOTNULL(
    MEM_NO          NUMBER          NOT NULL,
    MEM_ID           VARCHAR2(20)   NOT NULL,
    MEM_PWD        VARCHAR2(20)   NOT NULL,
    MEM_NAME      VARCHAR2(30)   NOT NULL,
    MEM_GENDER    CHAR(1),
    MEM_PHONE     VARCHAR2(20),
    MEM_EMAIL      VARCHAR2(50)
)
;

-- 제약 조건 확인
SELECT * FROM USER_CONSTRAINTS;
-- USER_CONSTRAINTS : 사용자가 작성한 제약조건을 확인하는 뷰

SELECT * FROM USER_CONS_COLUMNS;
-- 제약조건의 종류(CONSTRAINT_TYPE)는 없음
-- USER_CONS_COLUMNS : 제약 조건이 걸려있는 컬럼 확인용 뷰


INSERT INTO MEM_NOTNULL
VALUES (1,'user01','pass01','홍길동','M', '010-1234-1234', 'gd_hong123@kh.or.kr');


INSERT INTO MEM_NOTNULL
VALUES (2,null,null,null,null, '010-1234-1234', 'aaa@kh.or.kr');
-- 오류 보고 - ORA-01400: cannot insert NULL into ("KH"."MEM_NOTNULL"."MEM_ID")
--> NOT NULL 제약조건을 위배하여 오류 발생 

SELECT * FROM MEM_NOTNULL;


-- 컬럼레벨로 제약조건명 설정하기

CREATE TABLE MEM_NOTNULL2(
    MEM_NO          NUMBER          CONSTRAINT MEM_NN2_NO_NN    NOT NULL ,
    MEM_ID           VARCHAR2(20)   NOT NULL ,
    MEM_PWD        VARCHAR2(20)   NOT NULL ,
    MEM_NAME      VARCHAR2(30)   NOT NULL ,
    MEM_GENDER    CHAR(1),
    MEM_PHONE     VARCHAR2(20),
    MEM_EMAIL      VARCHAR2(50)    
);

-- 제약조건 확인 
SELECT * FROM USER_CONS_COLUMNS C1
JOIN USER_CONSTRAINTS C2 USING(CONSTRAINT_NAME)
WHERE C2.TABLE_NAME = 'MEM_NOTNULL2';



----------------------------------------------------------------------

-- * UNIQUE 제약 조건
-- 컬럼 입력 밧에 대해서 중복을 제한하는 제약조건
-- 기존에 컬럼에 존재하는 데이터 중 중복이 있으면 안됨.
-- 컬럼레벨, 테이블 레벨 모두 설정 가능

INSERT INTO MEM_NOTNULL
VALUES (1,'user01','pass01','홍길동','M', '010-1234-1234', 'gd_hong123@kh.or.kr');

SELECT * FROM MEM_NOTNULL;

-- 데이터 중복에 대한 제약조건 UNIQUE가 설정된 테이블 생성
-- 1) 컬럼 레벨로 UNIQUE 설정
CREATE TABLE MEM_UNIQUE(
    MEM_NO          NUMBER          NOT NULL UNIQUE ,
    MEM_ID           VARCHAR2(20)   NOT NULL UNIQUE,
    MEM_PWD        VARCHAR2(20)   NOT NULL ,
    MEM_NAME      VARCHAR2(30)   NOT NULL ,
    MEM_GENDER    CHAR(1),
    MEM_PHONE     VARCHAR2(20),
    MEM_EMAIL      VARCHAR2(50)
);
-- 컬럼레벨로 제약조건 설정 시 띄어쓰기를 통해 여러개 설정 가능


INSERT INTO MEM_UNIQUE
VALUES (1,'user01','pass01','홍길동','M', '010-1234-1234', 'gd_hong123@kh.or.kr');
-- 오류 보고 - ORA-00001: unique constraint (KH.SYS_C007053) violated
--> UNIQUE의 경우 어떤 컬럼에서 오류 발생했는지 알려주지 않음

-- 오류 보고에 나타난 제약조건 명을 이용하여 
-- 해당 제약조건이 설정된 테이블명, 컬럼명, 제약조건 타입 조회

SELECT UCC.TABLE_NAME, UCC.COLUMN_NAME, 
            UC.CONSTRAINT_TYPE
FROM USER_CONSTRAINTS UC, USER_CONS_COLUMNS UCC
WHERE UCC.CONSTRAINT_NAME = UC.CONSTRAINT_NAME
AND UCC.CONSTRAINT_NAME = 'SYS_C007053';

/*
 * 제약조건 찾을 때 
SELECT UCC.TABLE_NAME, UCC.COLUMN_NAME, 
            UC.CONSTRAINT_TYPE
FROM USER_CONSTRAINTS UC, USER_CONS_COLUMNS UCC
WHERE UCC.CONSTRAINT_NAME = UC.CONSTRAINT_NAME
AND UCC.CONSTRAINT_NAME = '제약조건타입명'

*/


-- 2) 테이블 레벨로 UNIQUE 설정
CREATE TABLE MEM_UNIQUE2(
    MEM_NO          NUMBER          NOT NULL ,
    MEM_ID           VARCHAR2(20)   NOT NULL ,
    MEM_PWD        VARCHAR2(20)   NOT NULL ,
    MEM_NAME      VARCHAR2(30)   NOT NULL ,
    MEM_GENDER    CHAR(1),
    MEM_PHONE     VARCHAR2(20),
    MEM_EMAIL      VARCHAR2(50),
    CONSTRAINT MEM_UNIQUE2_MEM_NO UNIQUE(MEM_NO),
    CONSTRAINT MEM_UNIQUE2_MEM_ID UNIQUE(MEM_ID)
);

-- 테이블 레벨 제약조건 설정 구문 
-- [CONSTRAINT 제약조건 명] 제약조건(컬럼명)
INSERT INTO MEM_UNIQUE2
VALUES (1,'user01','pass01','홍길동','M', '010-1234-1234', 'gd_hong123@kh.or.kr');
-- 테이블 레벨로 제약조건 설정 시 오류보고에서 오류난 제약조건 명 바로 확인 가능 

----------------------------------------------------------------------

-- 복합키 
-- UNIQUE의 응용 버전
-- 두 개 이상의 컬럼을 묶어서 제약조건 설정
-- UNIQUE, PRIMARY KEY 가능
-- * 반드시 테이블 레벨로만 설정
-- 문제점 : 묶어놓은 컬럼의 데이터 중 둘 중 하나라도 값이 다르면 서로 다른 값으로 인식
-- 동명이인의 값을 넣을 때 사용
-- EX) A강의장 AAA , B강의장 AAA

CREATE TABLE MEM_UNIQUE3(
    MEM_NO          NUMBER          NOT NULL ,
    MEM_ID           VARCHAR2(20)   NOT NULL ,
    MEM_PWD        VARCHAR2(20)   NOT NULL ,
    MEM_NAME      VARCHAR2(30)   NOT NULL ,
    MEM_GENDER    CHAR(1),
    MEM_PHONE     VARCHAR2(20),
    MEM_EMAIL      VARCHAR2(50),
    UNIQUE(MEM_NO, MEM_ID)
);


INSERT INTO MEM_UNIQUE3
VALUES (1,'user01','pass01','홍길동','M', '010-1234-1234', 'gd_hong123@kh.or.kr');
INSERT INTO MEM_UNIQUE3
VALUES (2,'user01','pass01','홍길동','M', '010-1234-1234', 'gd_hong123@kh.or.kr');
INSERT INTO MEM_UNIQUE3
VALUES (2,'user02','pass02','홍길동','M', '010-1234-1234', 'gd_hong123@kh.or.kr');
INSERT INTO MEM_UNIQUE3
VALUES (2,'user02','pass02','홍길동','M', '010-1234-1234', 'gd_hong123@kh.or.kr');
-- 오류 보고 - ORA-00001: unique constraint (KH.SYS_C007065) violated

SELECT * FROM MEM_UNIQUE3;


----------------------------------------------------------------------

-- CHECK 제약 조건
-- 컬럼에 기록되는 값을 제한할 수 있는 제약 조건
-- CHECK(컬럼명 비교연산자 비교값)
--> 비교값으로는 고정된 리터럴만 사용 가능
---> 서브쿼리, 함수 사용 불가
---> 변할수 있는 값이나 함수는 사용 불가능
-- 컬럼, 테이블 레벨 모두 설정 가능

CREATE TABLE MEM_CHECK(
    MEM_NO          NUMBER          NOT NULL ,
    MEM_ID           VARCHAR2(20)   NOT NULL ,
    MEM_PWD        VARCHAR2(20)   NOT NULL ,
    MEM_NAME      VARCHAR2(30)   NOT NULL ,
    MEM_GENDER    CHAR(1)           CHECK(MEM_GENDER IN ('M','F')),
    MEM_PHONE     VARCHAR2(20),
    MEM_EMAIL      VARCHAR2(50),
    CONSTRAINT MEM_CHECK_MEM_NO UNIQUE(MEM_NO),
    CONSTRAINT MEM_CHECK_MEM_ID UNIQUE(MEM_ID)
    -- CHECK(GENDER IN ('M','F'))
);

INSERT INTO MEM_CHECK
VALUES (1,'user01','pass01','홍길동','M', '010-1234-1234', 'gd_hong123@kh.or.kr');
INSERT INTO MEM_CHECK
VALUES (2,'user02','pass02','홍길순','F', '010-1234-1234', 'gd_hong123@kh.or.kr');
INSERT INTO MEM_CHECK
VALUES (3,'user03','pass03','홍길동','A', '010-1234-1234', 'gd_hong123@kh.or.kr');
-- 오류 보고 - ORA-02290: check constraint (KH.SYS_C007079) violated

SELECT * FROM MEM_CHECK;



----------------------------------------------------------------------

-- PRIMARY KEY ( 기본키 ) 제약 조건
-- 테이블에서 한 행의 정보를 식별할 수 있게 하기위하여 
-- 사용할 컬럼에 추가하는 제약조건
--> 각 행들을 구분할 수 있는 식별자 역할을 지정할 경우 사용
--> NOT NULL, UNIQUE가 적용되어있는 컬럼이 있어도 그 컬럼은 
-- PRIMARY KEY 역할 하지 못함
-- EX) 회원번호, 부서코드, 직급코드, 수강생번호, 주민등록번호
-- PRIMARY KEY는 NOT NULL 제약 조건 + UNIQUE 제약조건의 형태
-- 한 테이블당 한 번만 한 컬럼 또는 복합키로 설정 가능
-- 컬럼, 테이블 레벨 모두 설정 가능

CREATE TABLE MEM_PRIMARYKEY(
    MEM_NO          NUMBER          PRIMARY KEY ,
    MEM_ID           VARCHAR2(20)   NOT NULL    UNIQUE,
    MEM_PWD        VARCHAR2(20)   NOT NULL ,
    MEM_NAME      VARCHAR2(30)   NOT NULL ,
    MEM_GENDER    CHAR(1)           CHECK(MEM_GENDER IN ('M','F')),
    MEM_PHONE     VARCHAR2(20),
    MEM_EMAIL      VARCHAR2(50)    
    -- PRIMARY KEY (MEM_NO)
    -- CONSTRAINT MEM_PK PRIMARY KEY (MEM_NO)
);


-- NOT NULL + UNIQUE 제약 조건을 한 컬럼에 지정하여도
-- 해당 컬럼은 PRIMARY KEY는 아님.
-- PRIMARY KEY 는 테이블 내에서 각 행들을 식별해주는
-- 유일한 값을 지정하는 것이기 때문에 
-- 중복X, NULL 값 삽입X의 같은 제약조건이여도 의미가 다름.
-- PRIMARY KEY 조건을 가진 컬럼은 자동으로 '인덱스'가 생성됨
-- PRIMARY KEY를 복합키로 사용하면 속도가 향상됨 

SELECT * FROM mem_primarykey;

INSERT INTO MEM_PRIMARYKEY
VALUES (1,'user02','pass02','홍길동','M', '010-1234-1234', 'gd_hong123@kh.or.kr');
-- 오류 보고 - ORA-00001: unique constraint (KH.SYS_C007086) violated

INSERT INTO MEM_PRIMARYKEY
VALUES (NULL,'user02','pass02','홍길동','M', '010-1234-1234', 'gd_hong123@kh.or.kr');
-- 오류 보고 - ORA-01400: cannot insert NULL into ("KH"."MEM_PRIMARYKEY"."MEM_NO")

-- PRIMARY KEY 복합키 설정
-- 테이블 레벨만 가능
CREATE TABLE MEM_PRIMARYKEY2(
    MEM_NO          NUMBER          ,
    MEM_ID           VARCHAR2(20)   NOT NULL    UNIQUE,
    MEM_PWD        VARCHAR2(20)   NOT NULL ,
    MEM_NAME      VARCHAR2(30)   NOT NULL ,
    MEM_GENDER    CHAR(1)           CHECK(MEM_GENDER IN ('M','F')),
    MEM_PHONE     VARCHAR2(20),
    MEM_EMAIL      VARCHAR2(50),    
    CONSTRAINT MEM_PK2_PK PRIMARY KEY (MEM_NO,MEM_ID)
);

INSERT INTO MEM_PRIMARYKEY2
VALUES (1,'user02','pass02','홍길동','M', '010-1234-1234', 'gd_hong123@kh.or.kr');
INSERT INTO MEM_PRIMARYKEY2
VALUES (1,'user01','pass01','홍길동','M', '010-1234-1234', 'gd_hong123@kh.or.kr');
INSERT INTO MEM_PRIMARYKEY2
VALUES (1,'user02','pass01','홍길동','M', '010-1234-1234', 'gd_hong123@kh.or.kr');
-- 오류 보고 -ORA-00001: unique constraint (KH.MEM_PK2_PK) violated
SELECT * FROM MEM_PRIMARYKEY2;

----------------------------------------------------------------------

-- *** FOREIGN KEY *** (외래키) 제약조건
-- 해당 컬럼에 참조된 다른 테이블이 제공하는 값만 
-- 사용할 수 있도록하는 제약 조건
-- 두 테이블간에 관계가 생김 

-- 관계형 데이터베이스(RDBMS)는 테이블 마다 관계가 맺어져 있는데
-- 이 관계를 맺기 위해 사용하는 제약조건이 FOREIGN KEY 이다
--> 테이블간의 연결고리 역할
-- 이 때, 부모 테이블(참조 당하는 테이블)의 PRIMARY KEY 를
-- 자식 테이블(참조를 하는 컬럼을 보유한 테이블) 의
-- FOREIGN KEY 로 지정을 하게 됨.

-- 회원등급을 나타내는 테이블 (부모 테이블)
CREATE TABLE MEM_GRADE (
    GRADE_CODE      NUMBER PRIMARY KEY,
    GRADE_NAME     VARCHAR2(30) NOT NULL
);


SELECT * FROM MEM_GRADE ;

-- 회원 테이블 생성 ( 자식 테이블 )
CREATE TABLE MEM ( 
    MEM_NO         NUMBER           PRIMARY KEY,
    MEM_ID           VARCHAR2(20)   NOT NULL ,
    MEM_PWD        VARCHAR2(20)   NOT NULL,
    MEM_NAME      VARCHAR2(30)   NOT NULL,
    GRADE_CODE     NUMBER          REFERENCES MEM_GRADE(GRADE_CODE),
    MEM_GENDER    CHAR(1)          CHECK (MEM_GENDER IN('M','F')),
    MEM_PHONE     VARCHAR2(20),
    MEM_EMAIL      VARCHAR2(50)
    -- FOREIGN KEY (GRADE_CODE) REFERENCES MEM_GRADE [ (GRADE_CODE) ]
           --> FOREIGN KEY 설정 시 자동으로 부모 기본키를 참조하므로 생략 가능
);


-- 회원 등급은 10, 20, 30, NULL 만 가능
--> 부모 테이블(MEM_GRADE)의 GRADE_CODE에 있는 값만 가능
INSERT INTO MEM
VALUES (1,'user01','pass01','홍길동', 10, 'M', '010-1234-1234', 'gd_hong123@kh.or.kr');
INSERT INTO MEM
VALUES (2,'user02','pass02','홍길순', 20, 'F', '010-1234-5678', 'gs_hong123@kh.or.kr');
INSERT INTO MEM
VALUES (3,'user03','pass03','이순신', 30, 'M', '010-1212-1212', 'ss_Lee@kh.or.kr');
INSERT INTO MEM
VALUES (4,'user04','pass04','김지원', NULL, 'F', '010-5006-2791', 'jw_kim@kh.or.kr');
INSERT INTO MEM
VALUES (5,'user05','pass05','백동현',40, 'M', '010-2247-1339', 'baekdh@iei.or.kr');
--> 입력하려는 값 중 GRADE_CODE 가 부모 테이블에 존재하지 않아
-- 찾을 수 없다 (참조할 수 없다)라는 오류를 발생 시킴
    --> 이런 상황을 참조 무결성이 위배된 상황
    
-- 오류 보고 -ORA-02291: integrity constraint (KH.SYS_C007101) violated - parent key not found
-- integrity : 무결성
-- 참조 무결성 
-- 참조하는 테이블의 컬럼 값에 없는 데이터를 삽입할 수 없게하는 것
-- 양측의 데이터 일치성이 깨어짐 -> 데이터 제어가 불가능함 => 참조 무결성 위배

-- FOREIGN KEY 는 연결고리 역할을 하기 때문에
-- 테이블을 연결하여 조회하는 JOIN 구문에 사용할 컬럼으로 적합

SELECT MEM_ID, MEM_NAME, GRADE_CODE, GRADE_NAME
FROM MEM
LEFT JOIN MEM_GRADE USING(GRADE_CODE);



-- 부모 테이블의 값을 삭제할 경우 
DELETE FROM MEM_GRADE WHERE GRADE_CODE = 10;
-- 오류 보고 -ORA-02292: integrity constraint (KH.SYS_C007101) violated - child record found
-- 자식 테이블에 GRADE_CODE 가 10인 값이 기록이 되어 있어
-- 삭제 시 참조 무결성을 위배하게 되어 에러가 발생됨.


-- FOREIGN KEY 삭제 옵션
-- 부모 테이블의 데이터 삭제 시 
-- 자식 테이블의 기록된 데이터를 삭제 또는 NULL 로 반환하는 옵션

-- 1) ON DELETE SET NULL
-- 부모 테이블 데이터 삭제 시 자식 데이터 NULL 로 변경하는 옵션
CREATE TABLE MEM2 ( 
    MEM_NO         NUMBER           PRIMARY KEY,
    MEM_ID           VARCHAR2(20)   NOT NULL ,
    MEM_PWD        VARCHAR2(20)   NOT NULL,
    MEM_NAME      VARCHAR2(30)   NOT NULL,
    GRADE_CODE     NUMBER          REFERENCES MEM_GRADE(GRADE_CODE) ON DELETE SET NULL,
    MEM_GENDER    CHAR(1)          CHECK (MEM_GENDER IN('M','F')),
    MEM_PHONE     VARCHAR2(20),
    MEM_EMAIL      VARCHAR2(50)
);

INSERT INTO MEM_GRADE
VALUES (40, 'VVIP');

SELECT * FROM MEM_GRADE;
INSERT INTO MEM2
VALUES (1,'user01','pass01','홍길동', 10, 'M', '010-1234-1234', 'gd_hong123@kh.or.kr');
INSERT INTO MEM2
VALUES (2,'user02','pass02','홍길순', 20, 'F', '010-1234-5678', 'gs_hong123@kh.or.kr');

SELECT * FROM MEM2;
--자식 테이블 중 아무도 참조하고 있지 않은 값 40 을 삭제
DELETE  FROM MEM_GRADE 
WHERE GRADE_CODE = 40;
--> 삭제를 진행해도 참조 무결성이 깨지지 않으므로 삭제 가능
--> 즉, 해당 값을 가진 자식 테이블이 없음

-- 다시 추가 
INSERT INTO MEM_GRADE VALUES(40,'VVIP');

-- 자식 테이블에 GRADE_CODE = 40 인 데이터 추가
INSERT INTO MEM2
VALUES (3,'user03','pass03','고길동', 40, 'M', '010-1234-5678', 'gs_hong123@kh.or.kr');

SELECT * FROM MEM2;
SELECT * FROM MEM_GRADE;

-- 부모 테이블에서 자식에 참조 당하고 있는 컬럼 값 삭제
DELETE  FROM MEM_GRADE 
WHERE GRADE_CODE = 40;
-- 삭제 완료 스크립트는 나옴
SELECT * FROM MEM2;
-- 자식 테이블에서 참조하고있는 컬럼의 값은 NULL로 치환
--> GRADE_CODE 가 40인 컬럼 값이 NULL로 변환
--> 이로인해 참조 무결성이 지켜짐


-- 2) ON DELETE CASCADE 옵션
-- 부모 테이블 데이터 삭제 시 
-- 해당 데이터를 참조하고있던 자식 테이블의 행을 삭제시키는 옵션
--> 계단식 삭제라고 함

-- 
CREATE TABLE MEM3 ( 
    MEM_NO         NUMBER           PRIMARY KEY,
    MEM_ID           VARCHAR2(20)   NOT NULL ,
    MEM_PWD        VARCHAR2(20)   NOT NULL,
    MEM_NAME      VARCHAR2(30)   NOT NULL,
    GRADE_CODE     NUMBER          REFERENCES MEM_GRADE(GRADE_CODE) ON DELETE CASCADE,
    MEM_GENDER    CHAR(1)          CHECK (MEM_GENDER IN('M','F')),
    MEM_PHONE     VARCHAR2(20),
    MEM_EMAIL      VARCHAR2(50)
);

INSERT INTO MEM_GRADE
VALUES (40, 'VVIP');


INSERT INTO MEM3
VALUES (1,'user01','pass01','홍길동', 10, 'M', '010-1234-1234', 'gd_hong123@kh.or.kr');
INSERT INTO MEM3
VALUES (2,'user02','pass02','홍길순', 20, 'F', '010-1234-5678', 'gs_hong123@kh.or.kr');

SELECT * FROM MEM3;
-- 자식 테이블에 GRADE_CODE = 40 인 데이터 추가
INSERT INTO MEM3
VALUES (3,'user03','pass03','고길동', 40, 'M', '010-1234-5678', 'gs_hong123@kh.or.kr');

-- 부모 테이블의 컬럼값 중 참조 당하고 있는 값 삭제 
DELETE FROM MEM_GRADE WHERE GRADE_CODE = 40;
-- 정상적으로 삭제 진행

-- 삭제 후 자식 테이블 확인
SELECT * FROM MEM3;
-- GRADE_CODE = 40 인 행 삭제



----------------------------------------------------------------------

-- SUBQUERY 를 이용한 테이블 생성 
-- 테이블 복사, 특정 조회 형태를 저장한 테이블 생성 가능
-- DDL에서 사용하는 서브쿼리 구문은 () 없음
-- 컬럼명, 데이터 타입, 컬럼 값이 모두 복사되고 
-- 제약조건은 NOT NULL 만 복사가 됨

-- EMPLOYEE 테이블 복사
CREATE TABLE EMPLOYEE_COPY 
AS SELECT* FROM EMPLOYEE;

SELECT * FROM EMPLOYEE_COPY;

-- 사번, 이름, 급여, 부서명, 직급명을 저장하고 있는 테이블 생성
CREATE TABLE EMPLOYEE_COPY2
AS SELECT EMP_ID, EMP_NAME, SALARY, DEPT_TITLE, JOB_NAME
    FROM EMPLOYEE
    LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
    JOIN JOB USING(JOB_CODE);
    
    SELECT * FROM EMPLOYEE_COPY2;
    
    
-- 테이블의 컬럼, 데이터 타입만 복사하기
CREATE TABLE  EMPLOYEE_COPY3
AS SELECT * FROM EMPLOYEE
WHERE 1 = 0;
-- WHERE 절은 조건이 TRUE 일 때 값을 조회하는 것이라서 
-- 컬럼만 복사할 때는 무조건 결과가 FALSE 경우를 입력한다.

SELECT * FROM EMPLOYEE_COPY3;


----------------------------------------------------------------------

-- 제약 조건 추가

-- ALTER TABLE 테이블명 ADD 제약조건(PK, FK, U, CHECK)
-- ALTER TABLE 테이블명 MODIFY 컬럼명 NOT NULL

-- 테이블 제약조건 확인

SELECT * FROM USER_CONSTRAINTS UC
JOIN USER_CONS_COLUMNS UCC USING (CONSTRAINT_NAME)
WHERE UC.TABLE_NAME = 'EMPLOYEE_COPY';
-- CONTSTRAINT_TYPE = C : CHECK 
-- SEARCH_CONDITION  = NOT NULL 제약조건을 CHECK하는 제약조건

-- EMP_ID 에 PRIMARY KEY 제약조건 추가
ALTER TABLE EMPLOYEE_COPY ADD PRIMARY KEY(EMP_ID);

-- EMPLOYEE 테이블의 DEPT_CODE 컬럼이 
-- DEPARTMENT 테이블의 기본키를 참조하도록 FOREIGN KEY 제약조건 추가
ALTER TABLE  EMPLOYEE ADD FOREIGN KEY (DEPT_CODE)
REFERENCES DEPARTMENT ;


ALTER TABLE DEPARTMENT ADD FOREIGN KEY (LOCATION_ID)
REFERENCES LOCATION;

ALTER TABLE EMPLOYEE ADD FOREIGN KEY (JOB_CODE)
REFERENCES JOB;

ALTER TABLE EMPLOYEE ADD FOREIGN KEY (SAL_LEVEL)
REFERENCES SAL_GRADE;


ALTER TABLE LOCATION ADD FOREIGN KEY (NATIONAL_CODE)
REFERENCES NATIONAL;











