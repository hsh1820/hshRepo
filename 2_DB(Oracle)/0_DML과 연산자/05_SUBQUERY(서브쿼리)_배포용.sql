/*
  SELECT문 해석 순서
  
  5 : SELECT 컬럼명 AS 별칭, 계산식, 함수식
  1 : FROM 참조할 테이블명 
     + JOIN  -> JOIN을 포함한 하나의 FROM절
  2 : WHERE 컬럼명 | 함수식 비교연산자 비교값
  3 : GROUP BY 그룹을 묶을 컬럼명
  4 : HAVING 그룹함수식 비교연산자 비교값
  6 : ORDER BY 컬럼명 | 별칭 | 컬럼순번 정렬방식 [NULLS FIRST | LAST];
*/

----------------------------------------------------------------------------------------------------------------------------------

-- SUBQUERY(서브쿼리)
/*
- 하나의 SQL문 안에 포함된 또다른 SQL문.
- 메인 쿼리(기존 쿼리)를 위해 보조 역할을 하는 쿼리문.
*/

-- SUBQUERY 특이사항
-- 1) 메인 쿼리가 실행되기 전 한 번만 실행
-- 2) 비교 연산자 오른쪽에 기술
-- 3) 서브쿼리는 반드시 괄호로 묶어야 함
-- 4) 서브쿼리와 비교할 항목은 반드시 서브쿼리의 
-- SELECT한 항목의 개수와 자료형을 일치시켜야 함



-- 간단 서브쿼리 예시 1
-- 부서코드가 노옹철사원과 같은 소속의 직원의 
-- 이름, 부서코드 조회하기

-- 1) 사원명이 노옹철인 사람의 부서 조회
SELECT DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '노옹철';
-- 부서코드 D9 확인

-- 2) 부서코드가 D9인 직원을 조회
SELECT EMP_NAME, DEPT_CODE 
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

-- 3) 부서코드가 노옹철사원과 같은 소속의 직원의 
-- 이름, 부서코드 조회하기
SELECT EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE
                                 FROM EMPLOYEE
                                 WHERE EMP_NAME= '노옹철');

-- 간단 서브쿼리 예시 2                   
-- 전 직원의 평균 급여보다 많은 급여를 받고 있는 직원의 
-- 사번, 이름, 직급코드 ,급여 조회

-- 1) 전 직원의 평균 급여 조회 
SELECT ROUND(AVG(SALARY))
FROM EMPLOYEE;

-- 2) 전 직원들중 급여가 3047663원 이상인 사원들의 사번, 이름, 직급코드, 급여 조회
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY >= 3047663;

-- 3) 전 직원의 평균 급여보다 많은 급여를 받고 있는 직원의 
-- 사번, 이름, 직급코드 ,급여 조회

SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY >= (SELECT ROUND(AVG(SALARY))
                            FROM EMPLOYEE) ;
                            
----------------------------------------------------------------------------------------------------------------------------------

/*  서브쿼리의 유형
     
     - 단일행 서브쿼리 : 서브쿼리의 조회 결과 값의 개수가 1개인 서브쿼리
     
     - 다중행 서브쿼리 : 서브쿼리의 조회 결과 값의 개수가 여러개인 서브쿼리
     
     - 다중열 서브쿼리 : 서브쿼리의 SELECT 절에 나열된 컬럼 수가 여러개인 서브쿼리
     
     - 다중행, 다중열 서브쿼리 : 서브쿼리 조회 결과가 여러 행, 여러 컬럼을 가지는 서브쿼리
    
     - 상관 서브쿼리 : 상호연관 서브쿼리
        서브쿼리가 만든 결과 값을 메인 쿼리가 비교연산할 때
        메인쿼리 테이블의 값이 변경되면
        서브쿼리의 결과 값도 변경되는 서브쿼리
    
     - 스칼라 서브쿼리 : SELECT 절에 사용되는 서브쿼리 
    
     * 서브쿼리의 유형에 따라 서브쿼리 앞에 붙는 연산자가 달라진다.
    
*/
----------------------------------------------------------------------------------------------------------------------------------

-- 1. 단일행 서브쿼리 (SINGLE ROW SUBQUERY)
-- 서브쿼리의 조회 결과 값의 개수가 1개인 서브쿼리
-- 단일행 서브쿼리 앞에는 비교 연산자 사용
-- <, >, <=, >=, =, !=, ^=, <>
-- WHERE 절에서 서브쿼리 사용시 서브쿼리한 결과가 
-- 메인쿼리의 WHERE 절에서 비교할 결과 값과 1:1로 대응해야 함
-- 메인쿼리의 컬럼은 신경안써도 됨


-- 예제 1-1
-- 전 직원의 급여 평균보다 많은 급여를 받는 직원의 
-- 이름, 직급, 부서, 급여를 직급 순으로 정렬하여 조회
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > (SELECT ROUND(AVG(SALARY))
                            FROM EMPLOYEE)
                            --> 조회하는 컬럼 1개, 결과 1개 조회
ORDER BY EMP_NAME,JOB_CODE, DEPT_CODE
;

-- 예제 1-2                    
-- 가장 적은 급여를 받는 직원의
-- 사번, 이름, 직급, 부서, 급여, 입사일을 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE,SALARY,HIRE_DATE
FROM EMPLOYEE
WHERE SALARY = (SELECT MIN(SALARY)
                            FROM EMPLOYEE)
;

-- 예제 1-3
-- 노옹철 사원의 급여보다 많이 받는 직원의
-- 사번, 이름, 부서, 직급, 급여를 조회                 
SELECT EMP_ID, EMP_NAME, DEPT_CODE,SALARY,HIRE_DATE
FROM EMPLOYEE
WHERE SALARY > (SELECT SALARY
                            FROM EMPLOYEE
                            WHERE EMP_NAME = '노옹철');


-- ** 서브쿼리는 WHERE 절 뿐만 아니라
-- SELECT , FROM ,HAVING 절에서도 사용 가능


-- 예제 1-4
-- 부서별(부서가 없는 사람 포함) 급여의 합계 중 가장 큰 부서의
-- 부서명, 급여 합계를 조회 

-- 1) 부서별 급여 합 중 가장 큰값 조회
SELECT MAX(SUM(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE
;

-- 2) 부서별 급여합이 17700000인 부서의 부서명과 급여 합 조회
SELECT DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE= DEPT_ID)
--> 부서가 없는 직원도 있기 때문에 LEFT JOIN
GROUP BY DEPT_TITLE
HAVING SUM(SALARY) = 17700000
;
SELECT * FROM EMPLOYEE;

-- 3) 부서별(부서가 없는 사람 포함) 급여의 합계 중 가장 큰 부서의
-- 부서명, 급여 합계를 조회 
SELECT DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE= DEPT_ID)
--> 부서가 없는 직원도 있기 때문에 LEFT JOIN
GROUP BY DEPT_TITLE
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY))
                                        FROM EMPLOYEE
                                        GROUP BY DEPT_CODE);
                                        --> 컬럼 1 개, 결과 값 1개

----------------------------------------------------------------------------------------------------------------------------------


-- 2. 다중행 서브쿼리(MULTI ROW SUBQUERY)
-- 서브쿼리의 조회 결과 값의 개수가 여러 행인 서브쿼리
/*
    다중행 서브쿼리 앞에는 일반 비교연산자 사용 X    
    
    - IN / NOT IN
    -> 여러 개의 결과 값 중 하나라도 일치하는 값이 있다면
                                                    일치하는 값이 없다면
    
    -  >ANY, <ANY                                                    
    -> 여러 개의 결과값 중에서 하나라도 큰 / 작은 경우 
    --> 여러 개의 결과값 중에서 가장 작은 값 보다 크냐 ? / 가장 큰 값보다 작냐?
    
    - > ALL, < ALL 
    -> 여러 개의 결과값의 모든 값보다 큰 / 작은 경우
    --> 여러개의 결과값의 모든 값 중에서
         가장 큰 값보다 크냐 ? / 가장 작은 값보다 작냐?
         
    - EXISTS / NOT EXISTS : 값이 존재하냐? / 존재하지 않냐?  ==> 다중행 쿼리에서만 사용
         
*/
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY IN (SELECT MAX(SALARY)
FROM EMPLOYEE
GROUP BY  DEPT_CODE)
 ;

SELECT * FROM EMPLOYEE;

-- 예제 2-1
-- 부서별 최고 급여를 받는 직원의 
-- 이름, 직급, 부서, 급여를 부서 순으로 정렬하여 조회
SELECT MAX(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

SELECT EMP_NAME, JOB_CODE, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY IN (SELECT MAX(SALARY)
                            FROM EMPLOYEE
                            GROUP BY DEPT_CODE)
                            ORDER BY DEPT_CODE;




-- 예제 2-2
-- 사수에 해당하는 직원에 대해 조회 
-- 사번, 이름, 부서명, 직급명, 구분(사수 / 직원)


-- 1) 사수에 해당하는 사원 번호 조회
SELECT DISTINCT(MANAGER_ID)
FROM EMPLOYEE
WHERE MANAGER_ID IS NOT NULL
;

-- 2) 직원의 사번, 이름, 부서명, 직급 조회
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE);

-- 3) 사수에 해당하는 직원에 대한 정보 추출 조회(이 때, 구분은 '사수'로)
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, '사수' 구분/* SELECT 절에  '사수' 값 가진 열추가  */
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
WHERE EMP_ID IN (SELECT DISTINCT(MANAGER_ID)
                                FROM EMPLOYEE
                                WHERE MANAGER_ID IS NOT NULL) ;
                                -- MANAGER_ID 를 가진 사람들중 
                                -- EMP_ID 가 MANAGER_ID에 해당하는 사람들 조회

-- 4) 일반 직원에 해당하는 사원들 정보 조회 (이때, 구분은 '사원'으로)
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, '사원' 구분
FROM EMPLOYEE 
LEFT JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
JOIN JOB USING (JOB_CODE)
WHERE EMP_ID NOT IN (  SELECT DISTINCT(MANAGER_ID)
                                        FROM EMPLOYEE
                                        WHERE MANAGER_ID IS NOT NULL);
                                        
                                                                                    
-- 5) 3, 4의 조회 결과를 하나로 합침 -> UNION
-- 사수에 해당하는 직원에 대해 조회 
-- 사번, 이름, 부서명, 직급명, 구분(사수 / 직원)

SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, '사수' 구분
/* SELECT 절에  '사수' 값 가진 열추가  */
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
WHERE EMP_ID IN (SELECT DISTINCT(MANAGER_ID)
                                FROM EMPLOYEE
                                WHERE MANAGER_ID IS NOT NULL) 
                                -- MANAGER_ID 를 가진 사람들중 
                                -- EMP_ID 가 MANAGER_ID에 해당하는 사람들 조회
UNION

SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, '사원' 구분
FROM EMPLOYEE 
LEFT JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
JOIN JOB USING (JOB_CODE)
WHERE EMP_ID NOT IN (  SELECT DISTINCT(MANAGER_ID)
                                        FROM EMPLOYEE
                                        WHERE MANAGER_ID IS NOT NULL);

-- 6) 3, 4의 조회 결과를 하나로 합침 ->SUBQUERY
-- * SELECT 절에서도 서브쿼리 사용 가능
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME,
    CASE WHEN EMP_ID IN (
                                            SELECT DISTINCT(MANAGER_ID)
                                            FROM EMPLOYEE
                                            WHERE MANAGER_ID IS NOT NULL) THEN '사수'
                                            -- EMP_ID 가  서브쿼리SELECT문결과중 하나라도 
                                            -- 일치 한다면                                             
                                    ELSE '사원'                                        
                            END "구분"
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID )
JOIN JOB USING (JOB_CODE);


-- 예제 2-3
-- 대리 직급의 직원들 중에서 과장 직급의 최소 급여보다 많이 받는 직원의
-- 사번, 이름, 직급, 급여를 조회하세요
-- 단, > ANY 혹은 < ANY 연산자를 사용하세요




-- 1) 직급이 대리인 직원들의 사번, 이름, 직급명, 급여 조회
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '대리';

SELECT * FROM EMPLOYEE;
SELECT * FROM DEPARTMENT;
SELECT * FROM JOB;
-- 2) 직급이 과장인 직원들 급여 조회
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '과장';

-- 3) 대리 직급의 직원들 중에서 과장 직급의 최소 급여보다 많이 받는 직원
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '대리' 
AND SALARY > ANY (SELECT SALARY 
                        FROM EMPLOYEE
                        JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
                        JOIN JOB USING (JOB_CODE)
                        WHERE JOB_NAME = '과장');
       
-- 예제 2-4
-- 차장 직급 급여의 가장 큰 값보다 많이 받는 과장 직급의 직원
-- 사번, 이름, 직급, 급여를 조회하세요
-- 단, > ALL 혹은 < ALL 연산자를 사용하세요

SELECT EMP_ID,EMP_NAME,JOB_NAME, SALARY
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '과장' AND 
SALARY > ANY (SELECT SALARY
                        FROM EMPLOYEE
                        JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
                        JOIN JOB USING (JOB_CODE)
                        WHERE JOB_NAME = '차장');
-- 차장 전체의 월급보다 많이 받는 과장
-- ANY 사용시 : 각 차장의 월급중 하나라도 더 많이 받는 과장 조회가 됨


-- ** 서브쿼리 중첩 사용[응용]

-- NATIONAL_CODE가 KO인 부서에서 근무하고 있는 직원의 
-- 모든 정보 조회

-- LOCATION 테이블에서 NATIONAL_CODE가 KO인 LOCAL_CODE 조회
SELECT LOCAL_CODE 
FROM LOCATION
WHERE NATIONAL_CODE = 'KO';

-- DEPARTMENT 테이블에서 LOCATION_ID 가 L1 인 부서 코드 조회
SELECT DEPT_ID
FROM DEPARTMENT
WHERE LOCATION_ID = 'L1';

-- 위 두 쿼리문을 하나로 합침
SELECT DEPT_ID
FROM DEPARTMENT
WHERE LOCATION_ID = (SELECT LOCAL_CODE 
                                    FROM LOCATION
                                    WHERE NATIONAL_CODE = 'KO');
                                    
                                    
-- 최종적으로 부서가 한국인 곳에서 근무하고 있는 직원 정보 모두 조회
SELECT * 
FROM EMPLOYEE
WHERE DEPT_CODE IN (SELECT DEPT_ID
                                    FROM DEPARTMENT
                                    WHERE LOCATION_ID = (SELECT LOCAL_CODE 
                                                                        FROM LOCATION
                                                                        WHERE NATIONAL_CODE = 'KO'));


                              
                              
----------------------------------------------------------------------------------------------------------------------------------

-- 3.  다중열 서브쿼리
-- 서브쿼리 SELECT 절에 나열된 컬럼 수가 여러 개인 서브쿼리


-- 예제 3-1
-- 퇴사한 여직원//과 같은 부서, //같은 직급에 해당//하는
-- 사원의 이름, 직급, 부서, 입사일을 조회        

-- 1) 퇴사한 여직원 조회
SELECT EMP_NAME, JOB_CODE,DEPT_CODE, hire_date
FROM EMPLOYEE
WHERE ENT_YN= 'Y' 
AND SUBSTR(EMP_NO,8,1) = '2'
;

SELECT * FROM EMPLOYEE ;

-- 2) 퇴사한 여직원과 같은 부서, 같은 직급 (단일열(= 단일행) 표현 시 -> 하나의 컬럼만 비교)
SELECT EMP_NAME,JOB_CODE, DEPT_CODE , hire_date
FROM EMPLOYEE
-- 퇴사한 여직원과 같은 부서
WHERE DEPT_CODE = ( SELECT DEPT_CODE 
                                    FROM EMPLOYEE
                                    WHERE ENT_YN= 'Y' 
                                    AND SUBSTR(EMP_NO,8,1) = '2')                                 
AND JOB_CODE = ( SELECT JOB_CODE
                                    FROM EMPLOYEE
                                    WHERE ENT_YN= 'Y' 
                                    AND SUBSTR(EMP_NO,8,1) = '2' )     
-- 현재 재직중인 직원 (이태림 제외)
AND ENT_YN = 'N'                                    
;
             
-- 3) 퇴사한 여직원과 같은 부서, 같은 직급 (다중 열 서브쿼리)
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE 
WHERE (DEPT_CODE, JOB_CODE) --하나의 비교할 컬럼이라고 명시 
= (SELECT DEPT_CODE, JOB_CODE
    FROM EMPLOYEE
    WHERE ENT_YN = 'Y'
    AND SUBSTR(EMP_NO, 8,1) = '2')
    AND ENT_YN = 'N';
    
             
----------------------------------------------------------------------------------------------------------------------------------        
           
-- 4. 다중행 다중열 서브쿼리
-- 서브쿼리의 조회 결과 행 수와 컬럼 수가 여려개인 서브쿼리

-- 예제 4-1
-- 본인 직급의 평균 급여를 받고 있는 직원의
-- 사번, 이름, 직급, 급여를 조회하세요
-- 단, 급여와 급여 평균은 만원단위로 계산하세요 TRUNC(컬럼명, -5)      

-- 1) 급여를 200, 600만 받는 직원 (200만, 600만이 평균급여라 생각 할 경우)
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY IN (2000000, 6000000);

-- 2) 직급별 평균 급여
SELECT JOB_CODE, TRUNC(AVG(SALARY),-4) -- -4 는 뒤에서부터 숫자자리까지 절사
FROM EMPLOYEE
GROUP BY JOB_CODE
;

-- 3) 본인 직급의 평균 급여를 받고 있는 직원
 SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE, SALARY) IN (
    SELECT JOB_CODE, TRUNC(AVG(SALARY),-4) -- -4 는 뒤에서부터 숫자자리까지 절사
    FROM EMPLOYEE
    GROUP BY JOB_CODE);             
 
---------------------------------------------------------------------------------------------------------------------------------- 

-- 5. 상[호연]관 서브쿼리
-- 상관 쿼리는 메인쿼리가 사용하는 테이블 값을
-- 서브쿼리가 이용해서 결과를 만드는 서브쿼리

-- 메인쿼리의 테이블 값이 변경되면
-- 쿼리의 결과값도 바뀌게됨.

-- 예제 5-1
-- 사수가 있는 직원의 사번, 이름, 부서명, 사수사번 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, MANAGER_ID
FROM EMPLOYEE E
WHERE EXISTS ( SELECT EMP_ID
                        FROM EMPLOYEE M
                        WHERE E.MANGER_ID  = M.EMP_ID )
; 
-- SELECT 절에서 조회하는 컬럼 중 서브쿼리의 SELECT 절 결과가 하나라도 있는 경우 TRUE
-- 같은 테이블을 서브쿼리로 참조할 때 사용.
-- 속도빠름



-- 예제 5-2
-- 직급별 급여 평균보다 급여를 많이 받는 직원의 
-- 이름, 직급코드, 급여 조회
SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE E
WHERE SALARY > (SELECT AVG(SALARY)
                            FROM EMPLOYEE M
                            WHERE E.JOB_CODE = M.JOB_CODE) --E.JOB_CODE 와 M.JOB_CODE 가 동일한 사원들의 월급 평균
; 
-- E.JOB_CODE 와 M.JOB_CODE 에서 맞는 결과(평균)를 가져와서 WHERE 절에서 비교 연산
-- 메인쿼리에서 SELECT한 결과(E.JOB_CODE)와 서브쿼리의 결과 값(M.JOB_CODE)을 하나씩 가져와서 결과 조회



---------------------------------------------------------------------------------------------------------------------------------- 

-- 6. 스칼라 서브쿼리
-- SELECT 절에 사용되는 서브쿼리
-- 결과로 1행만 반환
-- * SQL 에서 단일 값을 '스칼라'라고 한다


-- 예제 6-1
-- 각 직원들이 속한 직급의 급여 평균 조회
SELECT EMP_NAME, JOB_CODE, SALARY,
FLOOR((SELECT AVG(SALARY) FROM EMPLOYEE M
WHERE E.JOB_CODE = M.JOB_CODE )) "직급 평균" 
FROM EMPLOYEE E
;-- E.JOB_CODE : J1 , M.JOB_CODE : J2 
-- J1 - J2, J3, 

-- 스칼라 : SELECT 절에 사용되면서, 그 결과값이 1개인 서브쿼리문
-- 스칼라구문 사용시 GROUP BY 절 안써도 그룹함수 (AVG, SUM,MAX/MIN ... ) 사용가능
-- 사용시기 : 면접때 

    


---------------------------------------------------------------------------------------------------------------------------------- 

-- 7. 인라인 뷰(INLINE-VIEW)
-- FROM 절에 사용되는 서브쿼리
-- 서브쿼리가 만든 결과의 집합(RESULT SET) 을 테이블 대신 사용


-- 예제 7-1 : 인라인뷰를 활용한 TOP-N분석
-- 전 직원 중 급여가 높은 상위 5명의
-- 순위, 이름, 급여 조회


-- * ROWNUM : SELECT 절에서 사용. 조회된 순서대로 1부터 번호를 매기는 컬럼
-- 조회 순서대로 번호 매기기
SELECT ROWNUM, EMP_NAME, SALARY
FROM EMPLOYEE;

-- 급여 내림차순 정렬하여 번호 매기기
SELECT ROWNUM,EMP_NAME, SALARY
FROM EMPLOYEE  
ORDER BY SALARY DESC;
--> ORDER BY 해석 순서가 마지막이기 때문에
-- 번호부터 매겨진 후 급여 내림차순으로 정렬됨

-- 서브쿼리를 이용하여 정렬 결과를 먼저 만든 후
-- ROWNUM을 이용하여 순서 매개기
-- 메인과 서브의 SELECT 컬럼끼리  맞춰줘야함
SELECT ROWNUM, EMP_NAME, SALARY
FROM (SELECT EMP_NAME, SALARY
            FROM EMPLOYEE
            ORDER BY SALARY DESC) -- 인라인뷰
WHERE ROWNUM <= 5;
-- ROWNUM은 개별적으로 SELECT 한 결과를 WHERE절에서 조건으로 사용 가능


-- 예제 7-2
-- 급여 평균이 3위 안에 드는 부서의 
-- 부서코드와 부서명, 평균급여를 조회
SELECT ROWNUM, DEPT_CODE,DEPT_TITLE, 평균급여  -- 서브쿼리에서 정한 별칭 사용가능
FROM (SELECT DEPT_CODE, DEPT_TITLE, FLOOR(AVG(SALARY)) 평균급여
            FROM EMPLOYEE
            LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
            GROUP BY DEPT_CODE, DEPT_TITLE 
            ORDER BY 평균급여 DESC)
WHERE ROWNUM  <= 3;



SELECT JOB_CODE, DEPT_TITLE, TRUNC(AVG(SALARY))
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
GROUP BY JOB_CODE, DEPT_TITLE
;


---------------------------------------------------------------------------------------------------------------------------------- 

-- 8. WITH
-- 서브쿼리에 이름을 붙여주고 
-- 서브쿼리 사용 시 이름을 불러 사용하게 함
-- 인라인뷰로 사용될 서브쿼리에 주로 사용됨
-- 실행속도가 빨라지고, 메인쿼리가 간결해지는 장점이 있음


-- 예제 8-1
-- 전 직원의 급여 순위 
-- 순위, 이름, 급여 조회

WITH TOPN_SAL AS (SELECT EMP_NAME,SALARY
                                FROM EMPLOYEE
                                ORDER BY SALARY DESC)
                                
SELECT ROWNUM,EMP_NAME, SALARY
FROM TOPN_SAL 
;

---------------------------------------------------------------------------------------------------------------------------------- 

-- 9. RANK() OVER / DENSE_RANK() OVER
-- 조회되는 결과에 따라서 순위를 매겨줌

--  RANK() OVER : 
-- 동일한 순위 이후의 등수를 동일한 인원 수 만큼 건너 뛰고 계산
-- EX) 공동 1위 2명 --> 1등 -> 1등 -> 3등
-- 전 직원 급여 순위
SELECT EMP_NAME, SALARY, 
RANK() OVER  (ORDER BY SALARY DESC) AS 순위
FROM EMPLOYEE;

-- DENSE_RANK() OVER : 
-- 동일한 순위 이후의 등수를 건너뛰지 않고 차례대로 증가
SELECT EMP_NAME, SALARY, 
DENSE_RANK() OVER  (ORDER BY SALARY DESC) AS 순위
FROM EMPLOYEE;


-- 국어국문학과에서 총 평점이 가장 높은 학생의 이름과 학번

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
    WHERE DEPARTMENT_NAME = '국어국문학과'
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
-- 1. 전지연 사원이 속해있는 부서원들을 조회하시오 (단, 전지연은 제외)
SELECT EMP_ID, EMP_NAME, PHONE, HIRE_DATE
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) = (SELECT DEPT_CODE, JOB_CODE 
                                                    FROM EMPLOYEE
                                                    WHERE EMP_NAME = '전지연')
AND EMP_ID <> (SELECT EMP_ID 
                                                    FROM EMPLOYEE
                                                    WHERE EMP_NAME = '전지연');


-- 사번, 사원명, 전화번호, 고용일, 부서명
-- 2. 고용일이 2000년도 이후인 사원들 중 급여가 가장 높은 사원의
-- 사번, 사원명, 전화번호, 급여, 직급명을 조회하시오.

                            
SELECT EMP_ID, EMP_NAME, PHONE, SALARY, JOB_NAME
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE SALARY = (SELECT MAX(SALARY)
                            FROM EMPLOYEE
                            WHERE EXTRACT(YEAR FROM HIRE_DATE) > 2000 );

-- 3. 노옹철 사원과 같은 부서, 같은 직급인 사원을 조회하시오. (단, 노옹철 사원은 제외)
-- 사번, 이름, 부서코드, 직급코드, 부서명, 직급명
SELECT EMP_ID, EMP_NAME, JOB_CODE, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE (DEPT_CODE, JOB_CODE) = (SELECT DEPT_CODE, JOB_CODE 
                                                    FROM EMPLOYEE
                                                    WHERE EMP_NAME = '노옹철')
AND EMP_ID <> (SELECT EMP_ID 
                                                    FROM EMPLOYEE
                                                    WHERE EMP_NAME = '노옹철');                                                     ;

-- 4. 2000년도에 입사한 사원과 부서와 직급이 같은 사원을 조회하시오
-- 사번, 이름, 부서코드, 직급코드, 고용일
SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE,hire_date
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE)= (
                            SELECT DEPT_CODE, JOB_CODE
                            FROM EMPLOYEE
                            WHERE EXTRACT(YEAR FROM HIRE_DATE) = 2000);
-- 5. 77년생 여자 사원과 동일한 부서이면서 동일한 사수를 가지고 있는 사원을 조회하시오
-- 사번, 이름, 부서코드, 사수번호, 주민번호, 고용일

SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE,hire_date
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE,MANAGER_ID)= (
                            SELECT DEPT_CODE, JOB_CODE,MANAGER_ID
                            FROM EMPLOYEE
                            WHERE SUBSTR(EMP_NO,1,2) = '77' 
                            AND SUBSTR(EMP_NO,8,1) = '2'                            
                            );                           
                            
-- 6. 부서별 입사일이 가장 빠른 사원의
-- 사번, 이름, 부서명(NULL이면 '소속없음'), 직급명, 입사일을 조회하고
-- 입사일이 빠른 순으로 조회하시오
-- 단, 퇴사한 직원은 제외하고 조회..




-- 메인
SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE,'소속없음'), JOB_NAME, HIRE_DATE
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
-- 6. 부서별 입사일이 가장 빠른 사원의
-- 사번, 이름, 부서명(NULL이면 '소속없음'), 직급명, 입사일을 조회하고
-- 입사일이 빠른 순으로 조회하시오
-- 단, 퇴사한 직원은 제외하고 조회..

SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE,'소속없음'), JOB_NAME, HIRE_DATE
FROM EMPLOYEE 
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
WHERE HIRE_DATE IN (SELECT MIN(HIRE_DATE)
                                FROM EMPLOYEE 
                                WHERE ENT_YN <> 'Y'
                                GROUP BY DEPT_CODE )                                
ORDER BY HIRE_DATE                                 
;


SELECT EMP_ID, EMP_NAME, NVL(DEPT_TITLE,'소속없음'), JOB_NAME, HIRE_DATE
FROM EMPLOYEE E
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE)
WHERE HIRE_DATE IN (SELECT MIN(HIRE_DATE)
                                FROM EMPLOYEE J
                                WHERE 
                                J.DEPT_CODE = E.DEPT_CODE
                                AND ENT_YN <> 'Y' 
                                OR E.DEPT_CODE IS NULL AND J.DEPT_CODE IS NULL)                                
                                -- 상관쿼리에서 제외된 NULL 값 
ORDER BY HIRE_DATE                                 
;







SELECT MIN(HIRE_DATE)
FROM EMPLOYEE
GROUP BY DEPT_CODE;
-- 7. 직급별 나이가 가장 어린 직원의
-- 사번, 이름, 직급명, 나이, 보너스 포함 연봉을 조회하고
-- 나이순으로 내림차순 정렬하세요
-- 단 연봉은 \124,800,000 으로 출력되게 하세요. (\ : 원 단위 기호)


SELECT EMP_ID, EMP_NAME, JOB_NAME, (EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,2),'RR'))) 나이 
,TO_CHAR( (SALARY + (SALARY*NVL(BONUS,0)))*12, 'L999,999,999') 연봉
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE EMP_NO IN 
            (SELECT MAX(EMP_NO)
            FROM EMPLOYEE
            GROUP BY JOB_CODE
            )
ORDER BY 나이 DESC              ;




SELECT EMP_ID, EMP_NAME, JOB_NAME,DEPT_CODE, (EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,2),'RR'))) 나이 
,TO_CHAR( (SALARY + (SALARY*NVL(BONUS,0)))*12, 'L999,999,999') 연봉
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,2),'RR')) IN
                    (   SELECT  MIN(EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,2),'RR'))) 나이
                        FROM EMPLOYEE
                        GROUP BY JOB_CODE                         
                        )                           

ORDER BY 나이 DESC ;











SELECT EMP_ID, EMP_NAME, JOB_NAME,
EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO,1,2),'RR')) 나이,
TO_CHAR( (SALARY + (SALARY*NVL(BONUS,0)))*12, 'L999,999,999') 보너스포함연봉
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE EMP_NO IN (    SELECT MAX(EMP_NO)
                                FROM EMPLOYEE
                                GROUP BY JOB_CODE)
ORDER BY 나이 DESC;                                
    






SELECT EMP_ID, EMP_NAME, JOB_NAME, 
    EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO, 1, 2), 'RR')) + 1 나이,
    TO_CHAR((SALARY + SALARY * NVL(BONUS, 0)) * 12, 'L999,999,999') 보너스포함연봉
FROM EMPLOYEE E
JOIN JOB J ON(E.JOB_CODE = J.JOB_CODE)
WHERE 
    EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO, 1, 2), 'RR')) + 1 =  
        (SELECT MIN(EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO, 1, 2), 'RR')) + 1)
            FROM EMPLOYEE M
            WHERE E.JOB_CODE = M.JOB_CODE)
ORDER BY 나이 DESC;



