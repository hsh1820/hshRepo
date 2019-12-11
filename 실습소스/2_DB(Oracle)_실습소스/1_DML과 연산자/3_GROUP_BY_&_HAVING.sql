/*  SELECT 구문 해석 순서
SELECT 컬럼명 AS 별칭, 계산식, 함수식, ...
FROM 참조할 테이블명
WHERE 컬럼명 | 함수식 비교연산자 비교값
GROUP BY 그룹으로 묶을 컬럼명
HAVING 그룹함수식 비교연산자 비교값 
ORDER BY 컬럼명 | 별칭 | 컬럼순번 정렬방식 [ NULLS FIRST / LAST ];

*/


-- EMPLOYEE 테이블에서
-- 부서코드가 D5 이면 총무부, D6이면 기획부
-- D9이면 영업부로 처리하시오
-- 단, 부서코드가 D5, D6, D9인 직원의 정보만 조회
-- => CASE 구문 사용
-- 부서코드 오름차순으로 정렬

SELECT emp_name, dept_code,
CASE 
    WHEN dept_code='D5' THEN '총무부'
    WHEN dept_code='D6' THEN '기획부'
    WHEN dept_code='D9' THEN '영업부'
END
FROM employee
WHERE dept_code IN ('D5','D6','D9')
ORDER BY dept_code;


------------------------------------------------------------------------------------------------

-- GROUP BY 절
-- 같은 값들이 여러개 기록된 컬럼을 가지고
-- 같은 값들을 하나의 그룹으로 묶어주는 구문

-- GROUP BY 컬럼명 | 함수식 [, 컬럼명 | 함수식 ... ]
--> 여러 개의 값을 묶어서 하나로 처리할 목적으로 사용함
-- 그룹으로 묶은 값에 대해서 SELECT 절에서 그룹함수를 사용함
SELECT nvl(dept_code,0), SUM(salary)
FROM employee/* ;  에러 발생 */
GROUP BY dept_code;  -- SUM(SALARY) -> 부서별로 GROUP BY 되어 조회

-- EMPLOYEE 테이블에서 
-- 부서코드, 그룹(=부서를 그룹으로)별 급여의 합계, 그룹별 급여의 평균(정수처리), 인원수를 조회
-- 부서코드 순으로 정렬
-- 보통 정수처리시 FLOOR / TRUNC 많이 사용
SELECT dept_code 부서코드, 
SUM(salary) 합계, 
floor(AVG(salary)) 평균, 
COUNT(*) 인원수
FROM employee
GROUP BY dept_code
ORDER BY dept_code;

-- EMPLOYEE 테이블에서 
-- 부서코드와 그룹별 보너스를 받는 사원의 수를 조회
-- 부서코드 순으로 정렬
SELECT dept_code, COUNT(bonus)
FROM employee
WHERE bonus IS NOT NULL 
GROUP BY dept_code
ORDER BY dept_code;

-- EMPLOYEE테이블에서 성별과 성별 별 급여 평균(정수처리), 급여 합계, 인원 수 조회하고
-- 인원수로 내림차순 정렬
SELECT 
decode(substr(emp_no,8,1),'1', '남', '2','여') AS 성별,
floor(AVG(salary)) 평균,
SUM(salary) 합계,
COUNT(*) 인원수
FROM employee
GROUP BY decode(substr(emp_no,8,1),'1', '남', '2','여') 
ORDER BY 인원수 DESC;
--  SELECT 절의 해석 순서가 GROUP BY 절 보다 늦기 때문에 별칭이 지정되지 않은 상태이므로 사용불가

-- EMPLOYEE테이블에서 부서 코드 별로 같은 직급인 사원의 급여 합계를 조회하고
-- 부서 코드 순으로 정렬

SELECT dept_code, job_code, SUM(salary)
FROM employee
GROUP BY dept_code, job_code
HAVING SUM(salary) >= 3000000
ORDER BY dept_code;
-- GROUP 별 묶는 순서는 상관없음

-- 그룹 함수로 구해 올 그룹에 대한 조건을 설정할 때 사용하는 구문* 
-- HAVING 컬럼명 | 함수식 비교연산자 비교값 

-- 부서별 급여 평균이 300만 이상인 부서 조회
-- HAVING 몰랐을 때
SELECT dept_code, floor(AVG(salary))
FROM employee
WHERE salary >= 3000000
GROUP BY dept_code
ORDER BY dept_code;
--> 각 부서별로 급여가 3000000이상인 직원들의 급여만 평균값이 계산되어 조회됨

-- HAVING 사용
SELECT dept_code, floor(AVG(salary))
FROM employee
GROUP BY dept_code
HAVING floor(AVG(salary)) >= 3000000
ORDER BY dept_code;

-- EMPLOYEE 테이블에서
-- 부서별 그룹의 급여 합계 중 9백만원을 초과하는 부서의
-- 부서코드와 급여 합계를 조회
-- 부서코드 순으로 정렬
SELECT dept_code 부서코드, SUM(salary) 급여합계
FROM employee
GROUP BY dept_code
HAVING SUM(salary) > 9000000
ORDER BY dept_code;

-- [ 참고 ] SUBQUERY
-- 급여 합계가 가장 많은 부서의 
-- 부서코드와 부서 합계를 조회
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

-- SET OPERATION (집합 연산)
/*
    - 여러가지의 조건이 있을 때 그에 해당하는
    여러 개의 결과의 값을 결합하고 싶을 때 사용하는 연산
    
    - 초보자들이 사용하기 쉽다는 장점이 있다.
        --> 조건을 어떻게 엮어야 하는지 생각하기 쉽기 때문
        --> 대신 연산 과정이 늘어난기 때문에 속도저하가 발생
        
    UNION (합집합) == OR
    INTERSECT (교집합) == AND
    UNION ALL == UNION + INTERSECT
        --> 중복된 결과가 두 번 포함됨
    MINUS (차집합) --> 중복 제거    
*/

-- UNION : 여러 개의 쿼리 결과를 하나로 합치는 연산자
-- 중복된 영역을 하나로 합침 == 중복된 값이 있으면 하나로 보여줌

-- EMPLOYEE 테이블에서
-- 부서코드가 'D5'인 직원과
-- 급여가 300만 이상인 직원의
-- 사번, 이름, 부서코드, 급여를 조회
SELECT emp_id,emp_name, dept_code,salary
FROM employee
WHERE dept_code = 'D5' 

-- EMPLOYEE 테이블에서
-- 부서코드가 'D5'인 직원과
-- 급여가 300만 초과인 직원의
-- 사번, 이름, 부서코드, 급여를 조회
UNION

SELECT emp_id,emp_name, dept_code,salary
FROM employee
WHERE salary > 3000000;

-- 위 쿼리 문을 OR 연산을 이용해서 조회하기
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

SELECT DISTINCT(department_name)|| '의 정원은 ' || CAPACITY ||'입니다.'  AS "학과별 정원"
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
substr(student_address,1,3) = '전주시'
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

SELECT professor_name 교수이름, 
round(months_between(sysdate,TO_DATE(substr(professor_ssn,1,2),'YY'))/12+100) 나이
FROM tb_professor
ORDER BY 나이;

SELECT substr(professor_name,2,3) 이름
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

SELECT round(AVG(POINT),1) 평점
FROM tb_grade
WHERE student_no = 'A517178';
SELECT *
FROM tb_student;

SELECT department_no 학과번호,
COUNT(*) "학생수(명)"
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


