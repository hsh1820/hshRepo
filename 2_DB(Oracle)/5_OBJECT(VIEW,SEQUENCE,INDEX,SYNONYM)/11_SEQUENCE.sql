-- SEQUENCE 
-- 순차적으로 정수 값을 자동으로 생성하는 객체
-- 자동 번호 발생기 역할을 함
    --> 보통 PRIMARY KEY 생성하는 역할에 사용됨

/*
    [ 표현식 ]
CREATE SEQUENCE 시퀀스명
① [START WITH 숫자]                         -> 처음 발생시킬 시작 값, 기본값 1
② [INCREMENT BY 숫자]                      -> 다음 값에 대한 증가치, 기본값 1
③ [MAXVALUE 숫자 | NOMAXVALUE]      -> 발생시킬 최대값, 10의 27승-1까지 가능
④ [MINVALUE 숫자 | NOMINVALUE]        -> 발생시킬 최소값, -10의 26승
⑤ [CYCLE | NOCYCLE]                          -> 시퀀스가 최대값까지 증가 완료 시
                                                         CYCLE은 START WITH 설정 값으로 돌아감
                                                         NOCYCLE은 에러 발생
⑥ [CACHE | NOCACHE]                        -> CACHE는 메모리 상에서 시퀀스 값 관리
기본값 20

*/

CREATE SEQUENCE SEQ_EMPID
START WITH 300
INCREMENT  BY 5
MAXVALUE 310
NOCYCLE 
NOCACHE ;

-- 사용자가 생성한 SEQUENCE 확인
SELECT * FROM USER_SEQUENCES;
-- LAST_NUMBER : 해당 시퀀스가 실행됐을 때 마지막으로 생성된 값

----------------------------------------------------------------------

-- SEQUENCE  사용

/*
    시퀀스명.CURRVAL : 현재의 생성된 시퀀스의 값을 나타내는 구문 : LAST_NUMBER 컬럼값 조회
    
    시퀀스명.NEXTVAL : 시퀀스를 증가시킨 값
        - 이전에 있던 기존 시퀀스 값에서 INCREMENT BY에 지정한 크기만큼 증가한 값
        
*/


-- ** 시퀀스 사용 시 NEXTVAL를 수행한 후에만 CURRVAL 호출이 가능함 
/*
    CURRVAL  는 마지막으로 수행한 NEXTVAL의 값을 저장하여 보여주는 임시 값 
    
    시퀀스 생성 이후 한 번도 NEXTVAL를 호출하지 않으면 오류가 발생
    
*/

-- NEXTVAL를 수행하지 않고 CURRVAL 호출해 보기 
SELECT SEQ_EMPID.CURRVAL FROM DUAL; --> 에러발생

--NEXTVAL 수행 후 CURRVAL 호출하기
SELECT SEQ_EMPID.NEXTVAL FROM DUAL;
SELECT SEQ_EMPID.CURRVAL FROM DUAL;
-- NEXTVAL가 시퀀스 생성 후 처음으로 수행된 경우
-- START WITH 값을 반환

SELECT SEQ_EMPID.CURRVAL FROM DUAL; -- 300
SELECT SEQ_EMPID.NEXTVAL FROM DUAL; -- 305
SELECT SEQ_EMPID.NEXTVAL FROM DUAL; -- 310
SELECT SEQ_EMPID.NEXTVAL FROM DUAL; -- 315 --> 에러발생
-- 지정한 MAXVALUE 값을 초과할 수 없음

SELECT SEQ_EMPID.CURRVAL FROM DUAL; --310
-- CURRVAL 은 마지막으로 성공한 NEXTVAL 값을 반환

-- 사용 가능한 구문  
-- 조회할때 사용하는 서브쿼리 에서 사용불가  INSERT 서브쿼리에서는 사용가능
-- INSERT 문의 VALUE 절 ****
-- UPDATE문의 SET절

-- 서번을 저장할 새로운 시퀀스를 생성하여
-- 새로운 사원 추가

CREATE SEQUENCE SEQ_EID 
START WITH 300
 INCREMENT BY 1 --> 1증가가 기본값
 MAXVALUE 10000
 NOCYCLE
 NOCACHE;
 
INSERT INTO EMPLOYEE VALUES(
    SEQ_EID.NEXTVAL,     '홍길동',    '000101-1234567',    'gd_hone@kh.or.kr',    '01043214321',    'D2','J7','S5', 2500000, 0.1, 200, SYSDATE,NULL,DEFAULT);

SELECT * FROM EMPLOYEE;

INSERT INTO EMPLOYEE VALUES(
    SEQ_EID.NEXTVAL,     '홍길순',    '000101-2234567',    'gs_hone@kh.or.kr',    '01043214321',    'D2','J7','S5', 2500000, 0.1, 200, SYSDATE,NULL,DEFAULT);
    
SELECT * FROM EMPLOYEE
WHERE EMP_ID = 301;

-- 시퀀스 삭제 
DROP SEQUENCE SEQ_EMPID ;

-- 시퀀스 수정
ALTER SEQUENCE SEQ_EID
INCREMENT BY 2
MAXVALUE 5000
NOCYCLE
CACHE 20;
-- CACHE 20 : 다음 시퀀스 개수 
--오류 보고 -
--ORA-02283: cannot alter starting sequence number
--02283. 00000 -  "cannot alter starting sequence number"

-- * CACHE 
-- 미리 다음 작업의 결과를 만들어 두는 공간
--> 결과가 완성되어 있기 때문에 호출 시 반환만 하면 되므로
--  속도가 빠름 
--  대신, 미리 일정 공간을 차지하고 있으므로 적당한 크기를 가지는 것이 중요

-- SEQUENCE 에서의 CACHE
-- 지정된 숫자만큼 다음에 나올 NEXTVAL의 결과들을 미리 생성해 둠


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

COMMENT ON COLUMN USER_TEST.USER_NO IS '회원번호';
COMMENT ON COLUMN USER_TEST.USER_ID IS '회원아이디';
COMMENT ON COLUMN USER_TEST.USER_PWD IS '비밀번호';
COMMENT ON COLUMN USER_TEST.PNO IS '주민등록번호';
COMMENT ON COLUMN USER_TEST.GENDER IS '성별';
COMMENT ON COLUMN USER_TEST.PHONE IS '연락처';
COMMENT ON COLUMN USER_TEST.ADDRESS IS '주소';
COMMENT ON COLUMN USER_TEST.STATUS IS '탈퇴여부';

ALTER TABLE USER_TEST ADD CONSTRAINT CC CHECK( GENDER IN ('남','여'));
ALTER TABLE USER_TEST ADD CONSTRAINT STAT CHECK( STATUS IN ('Y','N'));
