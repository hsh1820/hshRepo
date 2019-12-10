-- 전체 사원 정보 조회
SELECT
    *
FROM
    employee;

-- EMPLOYEE 테이블에서 사번, 이름, 월급 모두 조회

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

-- 실습문제 --
-- 1. JOB 테이블의 보든 정보를 조회

SELECT
    *
FROM
    job;
-- 2. JOB 테이블의 직급명만 조회

SELECT
    job_name
FROM
    job;
-- 3. DEPARTMENT 테이블의 모든 정보 조회

SELECT
    *
FROM
    department;
-- 4. EMPLOYEE 테이블의 이름, 이메일, 전화번호, 고용일 조회

SELECT
    emp_name,
    email,
    phone,
    hire_date
FROM
    employee;
-- 5. EMPLOYEE 테이블의 고용일, 사원명, 월급 조회

SELECT
    hire_date,
    emp_name,
    salary
FROM
    employee;

-- 컬럼 값 산술 연산
-- EMPLOYEE 테이블에서 직원의 이름과 연봉 조회

SELECT
    emp_name,
    salary * 12
FROM
    employee;
    
-- EMPLOYEE 테이블에서 직원의 이름과 연봉 조회, 보너스가 반영된 연봉

SELECT
    emp_name,
    salary * 12,
    ( salary + ( salary * bonus ) ) * 12
FROM
    employee;
-- 산술 연산 시 NULL 값이 포함되어 있으면 결과가 NULL이 됨.

---- 실습문제 ----
-- 1. EMPLOYEE 테이블에서 이름, 연봉, 총수령액(연봉+보너스), 실수령액(총 수령액 - 세금3%)
select Emp_name as 이름 , salary*12 as 연봉, (salary*12)+ bonus as 총수령액, (salary*12)+ bonus-(((salary*12)+ bonus)*0.3) as 실수령액
from Employee;
-- 2.EMPLOYEE 테이블에서 
-- 이름, 고용일, 근무일수(오늘 날짜 - 고용일) 조회
-- *DATE 형식 끼리는 산술 연산가능
-- *현재 시간(날짜)를 조회하는 키워드 == SYSDATE
select emp_name, hire_date,to_date(to_char(sysdate-hire_date,'yy/mm/dd')) as 근무일수
from EMPLOYEE;

select * from EMPLOYEE;

SELECT to_char(trunc(sysdate,'dd')  ) FROM dual ; 

select (mod((trunc(sysdate)-hire_date),12) ) as 년월일 from employee;

   select
 to_date('20090301', 'yyyymmdd')+1 - to_date('20090225', 'yyyymmdd')
from dual;

select 
trunc(sysdate-hire_date)
from employee;

-- EMPLOYEE 테이블에서 직원의 이름과 연봉(별칭 : 연봉(원)),
-- 보너스가 반영된 연봉(별칭 : 총 소득(원)), 조회하기
-- (보너스가 반영된 연봉 = (급여+(급여*보너스)) *12
select emp_name, 
salary*12 as "연봉(원)", 
(salary*12)+((salary*12)*bonus) as "총 소득(원)"
from employee;

-- 리터럴

-- EMPLOYEE 테이블에서 직원의 
-- 사번, 이름, 급여, 단위(데이터 : 원) 조회
select emp_id, emp_name, salary,
'원' as 단위 
from employee;

-- DISTINCT
-- 컬럼에 포함된 중복값을 한 번씩만 표시하고자 할 때 
-- 사용하는 키워드

-- EMPLOYEE 테이블에서 직원의 직급 코드 조회
select * from employee;
select job_code from employee;
-- EMPLOYEE 테이블에서 직원의 직급 코드 중복 제거하여 조회
select DISTINCT job_code from employee ;

-- ***** where 절 *****
-- 조회할 테이블에서 조건이 맞는 값을 가진 행을 골라내는 구문
/* [표현식]
SELECT 컬럼명
FROM 테이블명
WHERE 조건식;
*/

-- * 비교연산자
-- =(같다), > (크다), < (작다) >= (크거나같다), <=(작거나 같다)
-- !=, ^=, <> (같지않다)
select * from employee;
-- EMPLOYEE 테이블에서 부서코드가 'D9'인 직원의 이름, 부서코드 조회
select emp_name, employee.dept_code
from employee
where dept_code = 'D9';
-- EMPLOYEE 테이블에서 급여가 4000000 이상인 직원의 이름, 급여 조회
select emp_name, salary
from employee
where salary > 4000000 ;
-- EMPLOYEE 테이블에서 부서코드가 D9가 아닌 사원의 사번, 이름, 부서코드 조회
select emp_id, emp_name,dept_code 
from employee
where dept_code <> 'D9';

-- EMPLOYEE 테이블에서 퇴사 여부가 N 인 직원을 조회하고
-- 근무 여부를 '재직중' 으로 표시하여
-- 사번, 이름, 고용일, 근무여부를 조회
select emp_id, emp_name,hire_date,'재직중' as 근무여부
from employee
where ent_yn = 'N';

-- EMPLOYEE 테이블에서
-- 실 수령액(총수령액(연봉+보너스) - (연봉*세금 %3)이 5천만원 이상인 사원의 
-- 이름, 월급, 실수령액, 고용일 조회
select emp_name, salary,((salary + (salary*bonus))*12)-(salary*12*0.03) as 실수령액, hire_date
from employee
where ((salary+(salary*bonus))*12)-(salary*12*0.03) >= 50000000;

-- EMPLOYEE 테이블에서 부서코드가 'D6' 이고
-- 급여를 200만 이상 받는 직원의
-- 이름, 부서코드, 급여를 조회
select emp_name, dept_code, salary
from employee
where dept_code = 'D6' and salary > 2000000;
-- EMPLOYEE 테이블에서 부서코드가 'D6' 이거나
-- 급여를 200만 이상 받는 직원의
-- 이름, 부서코드, 급여를 조회
select emp_name, dept_code, salary
from employee
where dept_code = 'D6' or salary > 2000000;

-- EMPLOYEE 테이블에서 
-- 급여를 350만원 이상 600만원 이하로 받는 직원의
-- 사번, 이름, 급여, 부서코드, 직급코드를 조회
select emp_name, dept_code, salary, dept_code, job_code
from employee
where salary > 3500000 and salary > 6000000;

select *
from employee;

-- 실습 문제 -- 
-- 1. EMPLOYEE 테이블에서 월급이 4000000이상이고 job_code가 j2인 사원의 전체 내용 조회
select *
from employee
where salary > 4000000 and job_code = 'J2';
-- 2. EMPLOYEE 테이블에서 dept_code가 d9이거나 d5인 사원중
-- 고용일이 02년 1월 1일 보다 빠른 사원의
-- 이름, 부서코드, 고용일 조회
-- tip 다중 조건일 경우 순서 중요 먼저 조건을 검색해야되는 경우 괄로를 묶을 것
select emp_name, dept_code, hire_date
from employee
where (dept_code = 'D9' or dept_code = 'D5') and hire_date < '020101';

-- BETWEEN 'a' and 'b'
-- >> a 이상 b 이하

-- EMPLOYEE 테이블에서 
-- 급여를 350만원 이상 600만원 이하로 받는 직원의
-- 사번, 이름, 급여, 부서코드, 직급코드를 조회
select emp_id, emp_name, salary, dept_code
from employee
where salary BETWEEN 3500000 and 6000000;

-- EMPLOYEE 테이블에서 
-- 급여를 350만원 미만 600만원 초과로 받는 직원의
-- 사번, 이름, 급여, 부서코드, 직급코드를 조회
select emp_id, emp_name, salary, dept_code
from employee
where salary NOT BETWEEN 3500000 and 6000000;
-- NOT 키워드는 컬럼명 또는 BETWEEN 앞에 붙이는게 가능

-- EMPLOYEE 테이블에서 
-- 고용일이 '90/01/01' ~ '01/01/01' 인 사원의 
-- 모든 정보 조회
select *
from EMPLOYEE
where HIRE_DATE between '900101' and '010101';

-- 연결 연산자(||)
-- 여러 컬럼을 하나의 컬럼인 것 처럼 연결하거나 
-- 컬럼과 리터럴을 연결할 수 있다.

-- EMPLOYEE 테이블에서 사번, 이름, 급여를 연결하여 조회
select emp_id || emp_name || salary 
from employee;

-- 컬럼과 리터럴 연결
select emp_name || '의 월급은' || salary || '원 입니다.' as 메세지
from employee;

-- ** LIKE
-- 비교하려는 값이 지정한 특정 패턴을 만족시키는지 조회 할 때
-- 비교대상컬럼명 LIKE '문자패턴'
-- 형식으로 검사 가능
/* 
1) 문자패턴
'A%' (A로 시작하는 값)
'%A' (A로 끝나는 값)
'%A%' (A가 포함되는 값)

2) 문자수 
'_' : (한 글자)
'__' : (두 글자)
*/
-- from employee 에서 
-- 성이 전씨인 사원의 
-- 사번, 이름, 고용일 조회
select emp_id, emp_name, hire_date
from employee
where emp_name like '전%';

-- from employee 에서 이름에 '하'가 포함된 직원의
-- 이름, 주민번호, 부서코드 조회
select emp_name, emp_no, dept_code
from employee
where emp_name like '%하%';

-- EMPLOYEE 테이블에서 
-- 전화번호 네 번째 자리가 7로 시작하는 사원의 
-- 사번, 이름, 전화번호 조회
select emp_id, emp_name, phone
from employee
where phone like '___7%';

-- EMPLOYEE 테이블에서 
-- 이메일 중 앞글자가 세자리인 사원의
-- 사번, 이름, 이메일 주소 조회
select emp_id, emp_name, email
from employee
where email like '____%';

select emp_id, emp_name, email
from employee
where email like '___@_%'ESCAPE '@';

-- NOT LIKE
-- 특정 패턴을 만족하지 않는 값을 조회

-- EMPLOYEE 테이블에서 
-- 김씨 성이 아닌 사원의 사번, 이름, 고용일 조회
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE /*NOT*/ EMP_NAME NOT LIKE '김%';

-- EMPLOYEE 테이블에서
-- 이름 끝이 '연'으로 끝나는 사원의 이름 조회
SELECT emp_name
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%연';

-- EMPLOYEE 테이블에서
-- 전화번호 처음 3자리가 010이 아닌 사원의 이름, 전화번호를 조회

SELECT emp_name, PHONE
FROM EMPLOYEE
WHERE PHONE NOT LIKE '010%';
-- EMPLOYEE 테이블에서
-- 메일주소 '_'의 앞이 4자 이면서 DEPT_CODE가 D9 또는 D6이고
-- 고용일이 90/01/01 ~ 00/12/01이고,
-- 급여가 270만 이상인 사원의 전체를 조회
SELECT *
FROM EMPLOYEE
WHERE (EMAIL LIKE '____#_%' ESCAPE '#') AND 
(DEPT_CODE = 'D9' OR DEPT_CODE = 'D6') AND
(hire_date BETWEEN '900101' AND  '001201') AND
(salary >= 2700000);

-- IS NULL : 컬럼값이 NULL인 경우
-- IS NOT NULL : 컬럼값이 NULL이 아닌 경우

-- EMPLOYEE 테이블에서
-- 보너스를 받지 않는 사원의
-- 사번, 이름, 급여, 보너스 조회
SELECT emp_id, emp_NAME, salary, bonus
FROM EMPLOYEE
WHERE bonus IS NULL;

-- EMPLOYEE 테이블에서
-- 보너스를 받는 사원의
-- 사번, 이름, 급여, 보너스 조회
SELECT emp_id, emp_NAME, salary, bonus
FROM EMPLOYEE
WHERE bonus IS NOT NULL;

-- EMPLOYEE 테이블에서
-- 관리자도 없고, 부서배치도 받지 않은 사원의 
-- 사원명, 관리자, 부서코드 조회
SELECT EMP_NAME, MANAGER_ID, DEPT_CODE
FROM employee
WHERE MANAGER_ID IS NULL AND DEPT_CODE IS NULL;

-- EMPLOYEE 테이블에서
-- 부서 배치를 받았지만 
-- 보너스를 지급받지 못하는 사원의
-- 이름, 보너스, 부서코드 조회
SELECT emp_name, boNUS, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL
AND bonus IS NULL;

-- 비교하려는 값과 목록에 일치하는 값이 있으면 TRUE를 반환하는 연산자
-- 비교대상컬럼명 IN(XXX,...);

-- EMPLOYEE 테이블에서
-- D6 부서와 D8부서원들의 
-- 이름, 부서코드, 급여 조회

-- IN 사용 X
SELECT emp_name, DEPT_CODE, salary
FROM employee
WHERE DEPT_CODE = 'D6' OR dept_code = 'D8';

-- IN 사용 O
SELECT emp_name, DEPT_CODE, salary
FROM employee
WHERE DEPT_CODE IN ('D6','D8');

-- 연산자 우선순위
/*
1. 산술 연산자
2. 연결 연산자
3. 비교 연산자
4. IS NULL / IS NOT NULL , LIKE, IN / NOT IN
5. BETWEEN AND / NOT BETWEEN AND
6. 논리 연산자 - NOT
7. 논리 연산자 - AND 
8. 논리 연산자 - OR // OR 가 먼저와도 AND 절 부터 확인
*/

--------------------------------------------------------

-- *** ORDER BY 절
-- SELECT한 결과를 정렬할 때 작성하는 구문
-- SELECT 구문 제일 마지막에 작성
-- SELECT 실행 순서 중 가장 마지막 
-- 실행 순서 : 1 FROM -> 2 WHERE -> 3 SELECT -> 5 ORDER BY
/* [표현식]
SELECT 컬럼명[,컬럼명,...]
FROM 테이블명
[WHERE 조건식]
[ORDER BY 컬럼명 | 별칭 | 컬럼순서 정렬방법 [NULLS FIRST | LAST]]
--[NULLS FIRST | LAST] : NULL 값을 가진 데이터의 위치
-- NULLS FIRST : 정렬 기준인 컬럼에 NULL 값이 있으면 앞부분에 정렬하기
-- NULLS LAST : NULLS FIRST의 반대
*/

-- EMPLOYEE 테이블에서
-- 급여 오름차순 순서대로 
-- 이름,급여, 부서코드, 직급코드, 고용일 조회
SELECT emp_name, SALARY, DEPT_CODE, job_code, hire_date
FROM employee
ORDER BY SALARY ; -- ASC : 오름차순(생략가능)

-- EMPLOYEE 테이블에서
-- 연봉 내림차순 순서대로 
-- 이름,연봉, 부서코드, 직급코드, 고용일 조회
SELECT emp_name, (SALARY*12) AS 연봉, DEPT_CODE, job_code, hire_date
FROM employee
ORDER BY 2 DESC;
ORDER BY (SALARY*12) DESC;
ORDER BY '연봉' DESC;