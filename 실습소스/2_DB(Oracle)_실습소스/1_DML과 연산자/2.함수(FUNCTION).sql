-- 함수(FUCTION)
-- 컬럼의 값을 읽어서 계산한 결과를 리턴함

-- 단일행(SINGLE ROW) 함수
--> 컬럼에 기록된 N개의 값을 읽어서 N개의 결과를 리턴

-- 그룹(GROUP) 함수
--> 컬럼에 기록된 N개의 값을 읽어서 1개의 결과를 리턴



----------------------------------------------------------------------

-- 1. 문자 관련 함수
-- LENGTH(문자) / LENGTHB(문자의 바이트 길이)
SELECT LENGTH('오라클'), LENGTHB('오라클')
-- 오라클 11G XE 버전은 문자1개를 3BYTE로 취급
-- NVARCHAR2 : 문자 1개를 유니코드 값으로 받아서 문자 1개당 2BYTE로 변수타입 변경가능
FROM DUAL;
/*
오라클 Express Edtion (XE버전)은
한글을 3byte로 인식

2byte로 인식 시키고 싶을 경우
저장되는 컬럼의 타입을 NVARCHAR2로 지정
*/

-- EMPLOYEE 테이블에서
-- 모든 사원의 이름, 이메일, 이메일 길이, 이메일 바이트 크기 조회
SELECT EMP_NAME, EMAIL, LENGTH(EMAIL), LENGTHB(EMAIL)
FROM employee;

----------------------------------------------------------------------
-- INSTR
--> INSTR('문자열' | '컬럼명', '문자', 찾을 위치의 시작값, [순번])
-- 순번생략시 기본값 : 1 

SELECT INSTR('AABAACAABBAA','B',4,2) 
FROM DUAL;

----------------------------------------------------------------------
-- LTRIM / RTRIM 은 자습할때 한번씩 사용

-- TRIM
-- 주어진 컬럼이나 문자열의 앞 / 뒤 / 양쪽에 있는 지정한 문자를 제거
-- 문자를 지정하지 않은 경우 공백제거
-- 제거한 위치를 지정하지 않은 경우 양쪽 공백제거가 기본값
-- 메모리를 줄이고, 오류를 줄일 수 있는 가장 쉬운 방법
SELECT TRIM('            백동현                 ') FROM DUAL;

-- 양쪽 문자 제거
SELECT TRIM( BOTH 'Z' FROM 'ZZZKHZZZ') FROM DUAL;
SELECT TRIM('Z' FROM 'ZZZKHZZZ') FROM DUAL;

-- 앞쪽 문자 제거
SELECT TRIM(LEADING 'Z' FROM 'ZZZKHZZZ ') FROM DUAL;

-- 뒤쪽 문자 제거
SELECT TRIM(TRAILING 'Z' FROM 'ZZZKHZZZ') FROM DUAL;

----------------------------------------------------------------------
-- ** SUBSTR
-- 컬럼이나 문자열에서 지정한 위치부터 지정한 개수의 문자열을
-- 잘라내어 반환 ( 자바에 String subString()과 유사함)
-- 공백도 하나의 문자로 간주함
--> SUBSTR(STRING, POSITION , [LENGTH])
----> STRING : 문자 타입 컬럼 또는 문자열
----> POSITION : 문자열을 잘라낼 위치, 양수면 시작방향부터, 음수면 끝방향 기준
----> LENGTH : 반환할 문자 개수(생략 시 끝까지) (음수 작성시 NULL 리턴)
SELECT SUBSTR('SHOWMETHEMONEY',1,4) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY',4) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY',5,2) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY',7,3) FROM DUAL;
SELECT SUBSTR('SHOWMETHEMONEY',-8,3) FROM DUAL;

-- EMPLOYEE 테이블에서
-- EMP_NAME, EMAIL@이후를 제외한 아이디 조회
SELECT EMP_NAME, SUBSTR(EMAIL,1,INSTR(EMAIL,'@')-1)
FROM EMPLOYEE;

-- REPLACE
-- 컬럼의 문자 또는 문자열에서 특정 문자(열)을 지정한 문자(열)로 변환 후 반환 
--> REPLACE(STRING, 변환전 문자(열), 변환후 문자(열))
SELECT REPLACE('서울시 강남구 역삼동', '역삼동', '삼성동') FROM DUAL;

SELECT EMAIL, REPLACE(EMAIL,'kh.or.kr', 'gmail.com') as 변환후
from employee;

----------------------------------------------------------------------

-- ROUND : 반올림
--> ROUND( 숫자 | 숫자로된 컬럼 [, 위치])
SELECT ROUND(123.456) FROM DUAL;
SELECT ROUND(123.678) FROM DUAL;
-- 반올림하여 소수점 첫 째자리 까지 조회
SELECT ROUND(123.456,1) FROM DUAL;
SELECT ROUND(123.456,2) FROM DUAL;

SELECT ROUND(123.456, -2) FROM DUAL;

----------------------------------------------------------------------


-- EXTRACT  : 년, 월, 일 정보를 추출하여 반환
-- EXTRACT(YEAR FROM 날짜타입) : 년도 반환
-- EXTRACT(MONTH FROM 날짜타입) : 월반환
-- EXTRACT(DAY FROM 날짜타입) : 일 반환

-- EMPLOYEE 테이블에서
-- 모든 사원의 이름, 입사 년도, 입사월, 입사일 조회
SELECT EMP_NAME, EXTRACT(YEAR FROM HIRE_DATE) "입사년도",
EXTRACT(MONTH FROM HIRE_DATE)"입사 월",
EXTRACT(DAY FROM HIRE_DATE) "입사 일"
FROM EMPLOYEE;


------------- 실습문제----------------------------
-- 1. EMPLOYEE 테이블에서 사원명, 입사일-오늘, 오늘-입사일 조회
-- 단, 별칭은 근무일수1, 근무일수2로 하고
-- 모두 정수처리, 양수가 되도록 처리
SELECT EMP_NAME, ABS(FLOOR(hire_date-SYSDATE)) AS 근무일수1, 
FLOOR(ABS(SYSDATE-HIRE_DATE)) AS 근무일수2
FROM EMPLOYEE;
-- 내림 먼저하고 절대값으로 변경시 절대값 변경후 내림한 값과 +1 차이있음

-- 2. EMPLOYEE 테이블에서 사번이 홀수인 직원들의 정보 모두 조회
SELECT * 
FROM employee
WHERE  NOT MOD(EMP_ID,2) = 0;
-- 원칙적으로는 형변환을 통해 타입을 맞춰주는 것이 좋음
WHERE MOD(TO_NUMBER(EMP_ID),2)=1;
-- 3. EMPLOYEE 테이블에서 근무 년수가 20년(240개월) 이상인 직원 정보 조회
SELECT *
FROM employee
WHERE TRUNC(MONTHS_BETWEEN(SYSDATE,hire_date)) >= 240;

SELECT *
FROM employee
WHERE ADD_MONTHS(hire_date,240) < SYSDATE ;

-- 4. EMPLOYEE 테이블에서 사원명, 입사일, 입사한 월의 근무일수를 조회
SELECT EMP_NAME, hire_date, LAST_DAY( HIRE_DATE)-hire_date AS 입사월의근무일수
FROM EMPLOYEE;
EXTRACT(DAY FROM LAST_DAY(hire_date)) - EXTRACT(DAY FROM HIRE_DATE);

-- 날짜 포맷 변경
-- DDL구문
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';

----------------------------------------------------------------------

-- 4. 형변환 함수
-- TO_CHAR( 날짜 | 숫자[, FORMAT]) 
---> 날짜 또는 숫자형 데이터를 문자형 데이터로 변경
----> FORMAT이 지정되어있으면 해당 포맷 형태로 변경
SELECT TO_CHAR(1234) FROM DUAL;
SELECT TO_CHAR(1234, '99999') FROM DUAL;
-- 5칸을 지정 후 오른쪽 정렬, 빈칸은 공백을 채움
SELECT TO_CHAR(1234, '00000') FROM DUAL;


SELECT TO_CHAR(1234, '$99999') FROM DUAL;
-- 5칸 오른쪽정렬 현재 설정된 나라의 화폐단위 반환

-- 자릿수 콤마로 구분
SELECT TO_CHAR(1234, 'L999,999,999') FROM DUAL;

SELECT TO_CHAR(1234, '000,000,000') FROM DUAL;

SELECT TO_CHAR(1000, '9.9EEEE') FROM DUAL;

SELECT TO_CHAR(1234,'999') FROM DUAL;
--> 설정한 포맷의 범위를 넘어 선 경우 #으로 출력됨

-- EMPLOYEE 테이블에서
-- 사원명, 급여 조회
-- 단, 급여는 '\9,000,000'형식으로 표시할 것
SELECT EMP_NAME, TO_CHAR(salary, 'L9,000,000') "급여"
FROM EMPLOYEE;

------------------------------------------------------------------------------------------
-- 날짜 데이터에 포맷 적용하기
SELECT TO_CHAR(SYSDATE, 'AM HH:MI:SS') FROM DUAL;
-- AM, PM 은 오전, 오후의 표기식 지정이지 결국 SYSDATE 기준으로 출력해줌

SELECT  TO_CHAR(SYSDATE,'YYYY-MM-DD PM HH:MI:SS') FROM DUAL;
SELECT  TO_CHAR(SYSDATE,'YYYY-MM-DD DAY HH:MI:SS') FROM DUAL;
SELECT  TO_CHAR(SYSDATE,'YYYY-MM-DD DY HH:MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YEAR, Q') ||'분기' FROM DUAL;

-- EMPLOYEE 테이브에서
-- 모든 사원의 이름, 고용일 조회
-- 단 , 고용일은 '2019-11-14' 형식으로 조회할 것
SELECT EMP_NAME, TO_CHAR(hire_date,'YYYY"년"MM"월"DD"일"') 고용일  
FROM EMPLOYEE;

------------------------------------------------------------------------------------
-- TO_DATE : 문자 또는 숫자형 데이터를 날짜형으로 변환
SELECT TO_DATE('20191114') FROM DUAL;
SELECT TO_DATE('20191114','YYYYMMDD') FROM DUAL;
SELECT TO_DATE(20191114,'YYYYMMDD') FROM DUAL;

SELECT TO_DATE('191114','YYMMDD') FROM DUAL;

SELECT TO_CHAR(TO_DATE('191114','YYMMDD'),'YYYY-MM-DD') FROM DUAL;

SELECT TO_DATE('981114','YYMMDD') FROM DUAL;
SELECT TO_CHAR(TO_DATE('981114','YYMMDD'),'YYYY-MM-DD') FROM DUAL;-- 2000년도가 기준
SELECT TO_CHAR(TO_DATE('981114','RRMMDD'),'RRRR-MM-DD') FROM DUAL; -- 1900년도가 기준

-- EMPLOYEE 테이블에서
-- 2000년도 부터 입사한 사원의 
-- 사번, 이름, 입사일 조회
SELECT EMP_ID, EMP_NAME, hire_date
FROM EMPLOYEE
WHERE hire_date >= TO_DATE('000101', 'YYMMDD');

-------------------------------------------------------------------------------
-- TO_NUMBER
SELECT TO_NUMBER('123456789') FROM DUAL;
SELECT '100' + '100' FROM DUAL;
-- 문자값 내부에 숫자만 존재하므로
-- 오라클이 자동으로 숫자로 형변환이 가능함
SELECT '1,000' + '1,000' FROM DUAL;
-- 문자값 내부가 숫자 + 문자의 형태로 자동 형변환 불가

SELECT TO_NUMBER('1,000', '9,999') + TO_NUMBER('1,000', '9,999') FROM DUAL;

-------------------------------------------------------------------------------
-- 5. NULL 처리 함수
-- NVL( 컬럼명, 컬럼값이 NULL일 때 변경할 값)
SELECT EMP_NAME, NVL( BONUS,0)
FROM EMPLOYEE;

SELECT EMP_NAME, (SALARY*12) + (SALARY*12*NVL(BONUS,0) ) AS 총수령액
FROM EMPLOYEE;


 -- NVL2 (컬럼명, 변경값1, 변경값2)
-- 해당 컬럼에 값이 있으면 변경값1로 변경
-- 해당 컬럼이 NULL 이면 변경값2로 변경

-- EMPLOYEE 테이블에서
-- 기존 보너스를 받던 사원의 보너스를 0.8로
-- 보너스를 받지 못했던 사원의 보너스를 0.3으로 변경하여
-- 이름, 기존 보너스, 변경된 보너스 조회
SELECT EMP_NAME, BONUS, NVL2(BONUS, 0.8 , 0.3) 
FROM EMPLOYEE;

-- NULLIF (비교대상1, 비교대상2)
-- 두 개의 값이 동일하면 NULL, 다르면 비교대상1 반환
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



-- 함수 연습 문제

--1. EMPLOYEE 테이블에서
--  직원명과 주민번호를 조회
--  단, 주민번호 9번째 자리부터 끝까지는 '*'문자로 채움
--  예 : 홍길동 771120-1******
-- HINT. 연결 연산자
SELECT EMP_NAME,  SUBSTR(EMP_NO,1,8)|| '******' AS 주민번호
FROM EMPLOYEE;
--2. EMPLOYEE 테이블에서
--  직원명, 직급코드, 연봉(원) 조회
--  단, 총수령액은 ￦57,000,000 으로 표시
--  (총수령액은 보너스가 적용된 1년치 급여)
SELECT EMP_NAME, JOB_CODE, TO_CHAR((SALARY*12*BONUS),'L999,999,999')
FROM EMPLOYEE;
-- 3. EMPLOYEE 테이블에서
--   부서코드가 D5, D9인 직원들 중에서 2004년도에 입사한 직원의 
--   사번 사원명 부서코드 입사일 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, hire_date
FROM EMPLOYEE
WHERE (DEPT_CODE = 'D5' OR DEPT_CODE = 'D9') AND
(HIRE_DATE > '040101') AND (HIRE_DATE < '041231');

WHERE DEPT_CODE IN('D5', 'D9')
AND TO_NUMBER(SUBSTR(HIRE_DATE,1,2))= 4;
-- 4. EMPLOYEE 테이블에서
--   직원명, 입사일, 입사한 달의 근무일수 조회
--   단, 입사한 날도 근무일수에 포함해서 +1 할 것
SELECT EMP_NAME, HIRE_DATE,  (LAST_DAY( HIRE_DATE)-hire_date)+1 AS "근무일수 +1"
FROM EMPLOYEE;
--5. EMPLOYEE 테이블에서
--  직원명, 부서코드, 생년월일, 나이(만) 조회
--  단, 생년월일은 주민번호에서 추출해서, 
--  ㅇㅇ년 ㅇㅇ월 ㅇㅇ일로 출력되게 함.
--  나이는 주민번호에서 추출해서 날짜데이터로 변환한 다음, 계산
SELECT EMP_NAME, DEPT_CODE,  TO_CHAR(TO_DATE(SUBSTR(EMP_NO,1,6), 'RRMMDD'),'RR"년"MM"월"DD"일"') AS 생년월일, ROUND(MONTHS_BETWEEN(SYSDATE,TO_DATE(SUBSTR(EMP_NO,1,6),'RRMMDD'))/12) AS 나이
FROM EMPLOYEE;

SELECT * FROM EMPLOYEE;

------------------------------------------------------------------------------------------------

-- 6. 선택함수
-- 여러 가지 경우에 선택을 할 수 있는 기능 제공

-- DECODE( 계산식 | 컬럼명, 조건값1, 선택값1, 조건값2, 선택값2 ... , 기본값)
-- 비교하고자 하는 값 또는 컬럼이 조건식과 조건값과 같으면
-- 해당 선택값을 반환
-- 모든 조건값이 불일치되면 기본값 반환
-- 일치하는 값을 확인하는 함수(Java의 switch와 비슷)

-- EMPLOYEE 테이블에서
-- 모든 사원의 사번, 이름, 주민등록번호, 성별을 조회
SELECT EMP_ID, EMP_NAME, EMP_NO,
    DECODE(SUBSTR(EMP_NO,8,1),'1','남','2', '여') AS 성별
FROM EMPLOYEE;

-- 직원의 급여를 인상하고자 한다
-- 직급코드가 J7 인 직원은 10% 인상
-- 직급코드가 J6 인 직원은 15% 인상
-- 직급코드가 J5 인 직원은 20% 인상
-- 그 외 직급의 직원은 5%인상
-- EMPLOYEE 테이블에서 
-- 이름, 직급코드, 인상 전 급여, 인상 후 급여 조회
SELECT EMP_NAME, JOB_CODE, salary AS "인상 전 급여",  
DECODE(JOB_CODE,
'J7',SALARY*1.1,
'J6',salary*1.15,
'J5',SALARY*1.2,
SALARY*1.05) AS "인상 후 급여"
FROM EMPLOYEE;


------------------------------------------------------------------------------------------------

-- CASE 
-- 비교하고자 하는 값 또는 컬럼이 조건식과 같으면 결과값을 반환
/* [표현식]
    CASE WHEN 조건식1 THEN 결과값1
            WHEN 조건식2 THEN 결과값2
            ...
            ELSE 결과값
    END
*/
-- 조건식은 범위 설정이 가능

-- EMPLOYEE 테이블에서
-- 모든 사원의 사번, 이름, 주민등록번호, 성별을 조회
SELECT EMP_NAME, EMP_NO,
    CASE WHEN SUBSTR(EMP_NO,8,1) = '1' THEN '남'
    ELSE '여'
END AS "성별"
FROM EMPLOYEE;

-- 직원의 급여를 인상하고자 한다
-- 직급코드가 J7 인 직원은 10% 인상
-- 직급코드가 J6 인 직원은 15% 인상
-- 직급코드가 J5 인 직원은 20% 인상
-- 그 외 직급의 직원은 5%인상
-- EMPLOYEE 테이블에서 
-- 이름, 직급코드, 인상 전 급여, 인상 후 급여 조회
SELECT EMP_NAME, JOB_CODE, SALARY AS 인상전급여, 
CASE WHEN JOB_CODE = 'J7' THEN SALARY * 1.1
        WHEN JOB_CODE = 'J6' THEN SALARY * 1.15
        WHEN JOB_CODE = 'J5' THEN SALARY * 1.2
        ELSE SALARY * 1.05
END AS 인상후급여
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서
-- 모든 사원의 사원명, 급여, 급여별 등급을 조회
-- 5000000 초과 -> 1등급
-- 3500000 초과 5000000 이하 -> 2등급
-- 2000000 초과 3500000 이하 -> 3등급
-- 2000000 이하 4등급
SELECT EMP_NAME, SALARY, 
CASE WHEN SALARY> 5000000 THEN '1등급'
        WHEN SALARY> 3500000 THEN '2등급'
        WHEN SALARY> 2000000 THEN '3등급'
        ELSE '4등급'
END AS 등급
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 사원, 사원명, 급여, 구분 조회
-- 급여가 500만 이상이거나, 250만 이하  'A'
-- 나머지 'B'로 구분하여 조회
SELECT EMP_ID, EMP_NAME, SALARY,
CASE WHEN SALARY >= 5000000 
                OR SALARY <= 2500000 
                THEN 'A'
        ELSE 'B'
    END AS 구분
FROM EMPLOYEE
ORDER BY 구분;

-- 부서코드가 D5이면 총무부,
                -- D6이면 기획부
                -- D9이면 영업부로 처리하시오.
-- 단, 부서코드가 D5, D6,D9인 직원의 정보만 조회함
SELECT EMP_NAME, DEPT_CODE,
CASE WHEN DEPT_CODE = 'D5' THEN '총무부'
WHEN DEPT_CODE = 'D6' THEN '기획부'
WHEN DEPT_CODE = 'D9' THEN '영업부'
END AS 부서
FROM EMPLOYEE
WHERE DEPT_CODE IN('D5','D6','D9');

------------------------------------------------------------------------------------------------

-- 그룹 함수
-- 하나 이상의 행을 그룹으로 묶어 연산하며
-- 총합, 평균 등을 하나의 컬럼값으로 반환하는 함수

-- SUM(NUMBER 타입의 컬럼명) : 합계를 구하여 리턴

-- EMPLOYEE 테이블에서 전 사원의 급여 합 조회
SELECT SUM(SALARY) FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 남자 사원의 급여 총합 조회
SELECT SUM(SALARY) 
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8,1) ='1' ;

SELECT dept_code, SUM(SALARY)
FROM EMPLOYEE
GROUP BY dept_code;

-- EMPLOYEE 테이블에서 부서코드가 D5인 직원의
-- 보너스 포함 연봉을 조회
SELECT SUM(SALARY + (SALARY * NVL(BONUS,0))*12) AS 보너스포함연봉합계
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';

-- AVG(NUMBER 타입 컬럼) : 평균 값 리턴

-- EMPLOYEE 테이블에서 전 사원의 급여 평균 조회
-- 급여 평균(소수점 둘 째자리까지 표현)
SELECT ROUND(AVG(SALARY),2) FROM EMPLOYEE;

-- 보너스 평균 조회
-- 소수점 셋 째 자리 반올림
-- 값이 NULL 인경우 0 으로 처리 // NULL 값 포함 AVG
SELECT ROUND(AVG(NVL(BONUS,0)),2)
FROM EMPLOYEE;
--NULL처리 안했을 때
SELECT ROUND(AVG(BONUS),2)
FROM EMPLOYEE;
-- AVG 함수 수행 시 NULL값은 계산에서 제외 

-- MAX( 컬럼명) : 해당 컬럼에서 가장 큰 갑 리턴
-- MIN( 컬럼명) : 해당 컬럼에서 가장 작은 값 리턴 
-- 컬럼명 타입은 모두 가능(ANY TYPE)

-- EMPLOYEE 테이블에서 가장 높은 급여와 가장  낮은 급여 조회
SELECT MAX(SALARY), MIN(SALARY), COUNT(*), ROUND(AVG(SALARY)), SUM(SALARY)
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 가장 오래된 입사일, 가장 최근 입사일 조회
SELECT  MIN(HIRE_DATE) AS 가장오래된입사일 , MAX(HIRE_DATE) AS 가장최근입사일
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 
-- 알파벳 순위가 가장 빠른 이메일, 가장 늦은(= 가장 큰(MAX)) 이메일 조회
SELECT MIN(EMAIL), MAX(EMAIL)
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 
-- 사번이 200번인 사원을 제외하고
-- 이메일 알파벳 순서가 가장 빠른 이메일,
-- 가장 최근 입사일,
-- 가장 높은 급여 조회
SELECT MIN(EMAIL), MAX(HIRE_DATE), MAX(SALARY)
FROM EMPLOYEE
WHERE EMP_ID <> 200;

-- COUNT(* | 컬럼명) : 조건을 만족하는 행 개수를 리턴
SELECT COUNT(*) FROM EMPLOYEE;
--> COUNT(*) : NULL을 포함한 전체 행 개수 리턴

SELECT COUNT(BONUS) FROM EMPLOYEE;
--> COUNT(컬럼명) : 해당 컬럼에서 NULL값을 제외한 개수를 리턴

SELECT COUNT(DISTINCT DEPT_CODE) FROM EMPLOYEE;
--> COUNT(DISTINCT 컬럼명) : 해당 컬럼에서 중복을 제거한 행의 개수 리턴

-- EMPLOYEE 테이블에서 부서코드가 D5인 직원의 수 조회 
SELECT COUNT(*)
FROM EMPLOYEE
WHERE DEPT_CODE='D5';

-- 직원들의 입사일로부터 년도만 가지고,
-- 각 년도별 입사 인원수를 구하시오.
-- 아래의 년도에 입사한 인원수를 조회하시오
-- => TO_CHAR , DECODE, COUNT 사용
--------------------------------------------
-- 전체 직원수 2001년 2002년 2003년 2004년
--------------------------------------------
SELECT COUNT(*) AS 전체직원수,
COUNT(DECODE(TO_CHAR(EXTRACT(YEAR FROM HIRE_DATE)),'2001','2001' ) )AS "2001년",
COUNT(DECODE(TO_CHAR(EXTRACT(YEAR FROM HIRE_DATE)),'2002','2002' ) )AS "2002년",
COUNT(DECODE(TO_CHAR(EXTRACT(YEAR FROM HIRE_DATE)),'2003','2003' ) )AS "2003년",
COUNT(DECODE(TO_CHAR(EXTRACT(YEAR FROM HIRE_DATE)),'2004','2004' ) )AS "2004년"
FROM EMPLOYEE;








