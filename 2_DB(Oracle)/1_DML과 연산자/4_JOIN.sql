/* 

[JOIN 용어 정리]
    오라클                                     SQL:1999 표준 (ANSI)
    
등가 조인                                  내부조인(INNER JOIN)
                                               JOIN USING / JOIN ON
                                               + 자연 조인 (NATURAL JOIN, 등가 조인 방법 중 하나)
                                               -> ANSI에서만 표현 가능 ( 오라클에서 사용은 할 수 있으나 표현식이 존재하지 않음 )

포괄 조인                                  왼쪽 외부 조인 ( LEFT OUTER JOIN )                                               
                                               오른쪽 외부 조인 ( RIGHT OUTER JOIN )
                                               전체 외부 조인 ( FULL OUTER JOIN ) --> 오라클 구문으로 사용 못 함

비등가 조인                               JOIN ON
자체 조인

CARTESIAN PRODUCT                교차 조인 ( CROSS JOIN )
(카티션 곱)
-> 테이블 간의 곱 집합

*/


------------------------------------------------------------------------------------------

-- JOIN 
-- 하나 이상의 테이블에서 데이터를 조회하기 위해 사용하는 구문
-- 수행 결과는 하나의 Result Set 으로 나옴

/*   [  JOIN이 필요한 이유  ]
- 관계형 데이터베이스에서 SQL을 이용한 테이블 간의 '관계'를 맺는 방법.

- 관계형 데이터베이스(RDBMS)는 최소한의 데이터를 테이블에 담고 있어 
원하는 정보를 테이블에서 조회해야 할 경우 
하나 이상의 테이블에서 데이터를 읽어와야 하는 경우가 많음.
이 때, 무작정 데이터를 읽어오는 것이 아닌 
테이블 간의 연결고리(서로 같은 값을 가진 컬럼)로 관계가 맺어진 데이터를 추출해야 함.
-- 'JOIN'을 통해 이를 구현 가능

*/

-- ANSI 표준 구문
-- ANSI는 미국 국립 표준 협회를 뜻함
-- 미국의 산업표준화기구 ISO에 가입되어있다.
-- ANSI에서 제정된 표준을 ANSI라고 하고
-- 여기서 제정한 표준 중 가장 유명한 것이 'ASCII코드'이다.

-- 사번, 사원의 이름, 부서명을 모두 조회하기
select emp_id, emp_name, dept_code
from employee;
-- 사번, 사원명은 EMPLOYEE 테이블에서만 조회 가능

select dept_id, dept_title
from department;
-- 부서명은 DEPARTMENT 테이블에서만 조회 가능

--> 부서 코드(DEPT_ID, DEPT_CODE) 는 두 테이블 모두 조회 가능.
-- > 등가 조인 : 같은 컬럼 값을 가지고 JOIN

-- 1. [ ANSI ] 내부 조인( INNER JOIN, 오라클의 등가 조인( EQUAL JOIN ) )
--> 연결되는 컬럼의 값이 일치하는 행들만 조인됨.
-- ( 일치하는 값이 없는 행은 조인에서 제외됨 )
-- 값을 일치하는 기호로 = 을 사용

------------------------------------------------------------------------------------------
--  [ INNER JOIN , 등가 조인 ]
-- JOIN의 기본 값은 INNER 조인
-- JOIN 만 사용시 생략 가능

-- 오라클 전용 구문
-- FROM 절에 ','( 콤마 ) 로 구분하여 합칠 테이블명을 기술
-- WHERE 절에 합치기에 사용될 컬럼명을 명시

-- 1) 연결에 사용될 두 컬럼명이 다른 경우. => 같은 값이나 컬럼명 다름
select emp_id, emp_name, dept_title
from employee, department
where dept_code = dept_id;

-- 2) 연결에 사용할 두 컬럼명이 같은 경우
-- 사번, 이름, 직급명 조회 
select emp_id, emp_name, job_name
from employee, job
where job.job_code = employee.job_code;

-- 3) 별칭 사용
select emp_id, emp_name, job_name
from employee e, job 
where e.job_code = j.job_code;


------------------------------------------------------------------------------------------
-- ANSI 표준 구문
-- 1) 연결에 사용할 컬럼명이 다를 경우
    --> JOIN ON () 구문 사용
select emp_id, emp_name, dept_title
from employee
join department on (dept_code = dept_id);

-- 2) 연결에 사용할 컬럼명이 같은 경우
  --> JOIN USING() 구문 사용  ==> 컬럼명이 같을 경우에 사용하는 것이기 떄문에 using문에 테이블명시 필요 없음
select emp_id, emp_name, job_name
from employee
join job using(job_code);

-- 부서별 지역명 조회
-- 오라클 전용 구문
select dept_title, local_name
from department,location
where department.location_id = location.local_code;
-- ANSI 전용 구문

select dept_title, local_name
from department
join location on(location_id = local_code);
------------------------------------------------------------------------------------------

-- 2. 외부 조인( OUTER JOIN )
-- 두 테이블에 지정하는 컬럼값이 일치하지 않는 행도
-- 조인 결과에 포함시킴
    --> 반드시 OUTER JOIN 임을 명시해야 함.

-- INNER JOIN, OUTER JOIN을 비교할 쿼리문
select emp_id, emp_name, dept_title
from employee
join department on (dept_code = dept_id);

-- 1) LEFT {OUTER} JOIN
-- 합치기에 사용된 두 테이블 중 
-- 왼편에 기술된 테입르의 컬럼 수를 기준으로 JOIN 을 진행

-- ANSI 표준 구문
select emp_id, emp_name, dept_title
from employee
left outer join department on (dept_code = dept_id)
--where dept_title is null
;

-- 오라클 구문
-- where 절의 컬럼명 기준으로 좌,우 결정
select emp_id, emp_name, dept_title
from employee, department
where employee.dept_code = department.dept_id(+)/* and dept_title is null */;
-- (+) : 왼쪽 컬럼의 결과 값에 맞춰서 오른쪽 테이블 결과 값을 더하는 것
-- 왼쪽에 기술된 컬럼을 기준으로 컬럼값을 추가하겠다.


------------------------------------------------------------------------------------------

-- 2) RIGTH [OUTER] JOIN
-- 합치기에 사용한 두 테이블 중
-- 오른편에 기술된 테이블의 컬럼 수를 기준으로 JOIN

-- ANSI 표준 구문
select emp_id, emp_name, dept_title
from employee
RIGHT OUTER JOIN department on (dept_code = dept_id)
where emp_name is null;
-- DEPARTMENT 테이블에서 아무 관계가 맺어져 있지 않은
-- 해외 영업3부, 마케팅부, 국내영업부가 마지막에 추가 됨 
-- right join 을 사용 하긴 하지만 left join 을 더 많이 사용
select emp_id, emp_name, dept_title
from department
left outer join employee on(dept_code = dept_id);
--where emp_id is null;
-- 기주이 되는 테이블 순서에 따라서
-- LEFT, RIGHT  JOIN의 결과가 같을 수 있음.

-- 오라클 구문
select emp_id, emp_name, dept_title
from employee, department
where dept_code(+) = dept_id;
-- 추가되는 테이블쪽에 (+) 기재


------------------------------------------------------------------------------------------

-- 3) FULL [OUTER] JOIN 
-- 합치기에 사용한 두 테이블이 가진 모든 행을
-- 결과에 포함시키는 조인
-- INNER + LEFT + RIGHT
-- ANSI 표준 구문
select emp_id, emp_name, dept_title
from employee
full outer join department on (dept_code= dept_id);

-- 오라클 전용 구문
select emp_id, emp_name, dept_title
from employee, department;
--where dept_code(+) = dept_id(+); 
--> 오라클 전용 구문은 FULL OUTER JOIN 사용 못함

------------------------------------------------------------------------------------------

-- 3. 교차 조인 ( CROSS JOIN, 오라클 CARTESIAN PRODUCT ) 
-- 조인되는 테이블의 각 행들이 모두 매핑된 데이터가 조회됨 (곱집합)
-- AI, 빅데이터 쪽에서 자주 사용
-- Result Set 에는 NULL 값을 제외하고 조회됨 
-- 

select emp_id, emp_name, dept_title
from employee
cross join department ;

------------------------------------------------------------------------------------------

-- 4. 비등가 조인 ( NON EQUAL JOIN )
-- '조인하는 컬럼이 숫자인 경우에만 사용'
-- '='(등호)를 사용하지 않는 조인 
--> 범위 지정하여 값을 '비교' 
--> 조인하는 값이 서로 같지 않을 때 범위를 지정하여 값을 맞춘다?
-- 지정한 컬럼 값이 일치하는 경우가 아닌 
-- 값의 범위에 포함되는 행들을 연결하는 조인

-- 사원명, 급여, 급여 등급
-- 사원의 급여에 따라 알맞은 급여등급으로 조회할 것
select emp_name, salary, e.sal_level
from employee e
join sal_grade s on (salary between min_sal and max_sal);

------------------------------------------------------------------------------------------

-- 5. 자체 조인 ( SELF JOIN )
-- 자기가 자신을 JOIN 
-- 사번, 이름, 부서코드, 관리자 조회
select emp_id, emp_name, manager_id
from employee;

-- ANSI 표준 구문
select e.emp_id, e.emp_name, e.dept_code, e.manager_id, m.emp_name
from employee e
join employee m on (e.manager_id = m.emp_id);

-- 오라클 전용 구문
select e.emp_id, e.emp_name, e.dept_code, e.manager_id,m.emp_name
from employee e, employee m
where e.manager_id = m.emp_id;

 
------------------------------------------------------------------------------------------

--6. 자연 조인 ( NATURAL JOIN )
-- 동일한 타입과 이름을 가진 컬럼이 있는 테이블들 간의 조인시
-- 조인과 구문을 간단히 표현한 방법

-- * 반드시 두 테이블 간의 동일한 컬럼명, 타입을 가진 컬럼이 필요
--> 없을 경우 교차조인 발생
select emp_name, job_name
from employee e 
join job j on (e.job_code = j.job_code);

select emp_name, job_name
from employee 
join job using (job_code);

select emp_name, job_name
from employee
natural join job; 
-- 동일한 컬럼명과 타입을 찾아서 알아서 조인


------------------------------------------------------------------------------------------


-- 7. 다중 조인 
-- N 개의 테이블들을 조인하여 조회할 경우
-- 조인 순서가 매우 중요함!

-- 사번, 사원명, 부서코드, 부서명, 지역명
select emp_id, emp_name, dept_code, dept_title, local_name
from employee
join department on (dept_code = dept_id) 
join location on (location_id = local_code);

-- 조인 순서를 지키지 않은 경우
select emp_id, emp_name, dept_code, dept_title, local_name
from employee
left join location on (location_id = local_code)
join department on (dept_code = dept_id);

-- FROM 절에서 JOIN 발생 시 
-- 위에서부터 차례대로 JOIN을 한번 실행할 때 마다
-- RESULT SET이 새롭게 만들어짐
--> JOIN 순서를 지켜야 함
-- (RESULT SET을 테이블로 취급 가능)

-- 조인관계가 제대로 맺어지지 않은 상태로 없는 컬럼 접근 시 에러 발생

-- 사원 중 누락된 하동운, 이오리도 조회 결과에 포함해서 조회하기
select emp_id, emp_name, dept_code, dept_title, local_name
from employee
left join department on (dept_code = dept_id) 
left join location on (location_id = local_code);
-- join 시  inner join은 null값을 제외한 결과만 조인함
--> null 값을 제외하지 않을 모든 테이블에 left join 필요


-- 오라클 구문
select emp_id, emp_name, dept_code, dept_title, local_name
from employee  , department , location 
where dept_code = dept_id and 
location_id = local_code;


-- 직급이 대리이면서 아시아 지역에 근무하는 직원 조회
-- 사번, 이름, 직급명, 부서명, 근무지역명, 급여를 조회하세요

-- 오라클 구문
select emp_id, emp_name, job_name ,dept_title, local_name, salary
from employee e , department, location, job j
where (dept_code = dept_id) and
(location_id = local_code) and
(e.job_code= j.job_code) and
job_name = '대리' and
local_name = 'ASIA1';


-- ANSI 구문
select emp_id, emp_name, job_name ,dept_title, local_name, salary
from employee
left join department on (dept_code = dept_id)
left join location on (location_id = local_code)
 join job using (job_code)
where job_name = '대리' and
local_name = 'ASIA1';



select emp_id, emp_name, job_name ,dept_title, local_name, salary
from employee
left join department on (dept_code = dept_id)
left join location on (location_id = local_code)
natural join job  
where job_name = '대리' and 
dept_title= 'ASIA1';


------------------------------------------------------------------------------------------

-- 1. 주민번호가 70년대 생이면서 성별이 여자이고, 성이 ‘전’씨인 직원들의
-- 사원명, 주민번호, 부서명, 직급명을 조회하시오.
select emp_name, emp_no, dept_title,job_name
from employee
join job using(job_code)
join department on (dept_code=dept_id)
where substr(emp_no,8,1)='2' and emp_name like '전%';

select emp_name, emp_no, dept_title, job_name
from employee e, department, job j 
where e.job_code = j.job_code and
dept_code = dept_id and
substr(emp_no,8,1)='2' and emp_name like '전%';

-- 2. 이름에 '형'자가 들어가는 직원들의 사번, 사원명, 부서명을 조회하시오.
select emp_id, emp_name, job_name
from employee
join department on (dept_code=dept_id)
join job using(job_code)
where emp_name like '%형%';

select emp_id, emp_name, job_name
from employee e, department, job j
where dept_code = dept_id and
e.job_code = j.job_code and
emp_name like '%형%';


-- 3. 해외영업 1부, 2부에 근무하는 사원의
-- 사원명, 직급명, 부서코드, 부서명을 조회하시오.
select emp_name, job_name, dept_code, dept_title
from employee
join department on (dept_code=dept_id)
join job using(job_code)
where dept_title in( '해외영업1부','해외영업2부') ;

select emp_name, job_name, dept_code, dept_title
from employee e, department, job j
where dept_code = dept_id and
e.job_code = j.job_code and
dept_title in ('해외영업1부','해외영업2부');

--4. 보너스포인트를 받는 직원들의 사원명, 보너스포인트, 부서명, 근무지역명을 조회하시오.
select emp_name, bonus,dept_title, local_name
from employee
join department on (dept_code=dept_id)
join location on (location_id = local_code)
where bonus is not null;

select emp_name, bonus, dept_title, local_name
from employee, department, location
where dept_code = dept_id and
location_id = local_code and
bonus is not null;
--5. 부서가 있는 사원의 사원명, 직급명, 부서명, 지역명 조회
select emp_name, job_name, dept_title, local_name 
from employee
join department on (dept_code=dept_id)
join job using (job_code)
join location on (location_id = local_code)
where dept_title is not null;

select emp_name, job_name, dept_title, local_name
from employee e, department, job j, location
where dept_code = dept_id and
e.job_code = j.job_code and
location_id = local_code and
dept_title is not null;

-- 6. 급여등급별 최소급여(MIN_SAL)보다 많이 받는 직원들의
--사원명, 직급명, 급여, 연봉(보너스포함)을 조회하시오.
--연봉에 보너스포인트를 적용하시오.
select  emp_name, job_name, salary, SALARY + (SALARY * NVL(BONUS,0))*12
from employee
join job using (job_code)
join sal_grade  using (sal_level)
where min_sal < SALARY + (SALARY * NVL(BONUS,0))*12;


-- 7.한국(KO)과 일본(JP)에 근무하는 직원들의
-- 사원명, 부서명, 지역명, 국가명을 조회하시오.
select  emp_name, dept_title, local_name, 
decode(national_code, 'KO','한국','CH','중국', 'JP','일본', 'RU', '러시아' ) 국가명
from employee
join department on(dept_code = dept_id)
join location on (location_id = local_code)
where national_code in('KO' ,'JP');

-- 8. 같은 부서에 근무하는 직원들의 사원명, 부서코드, 동료이름을 조회하시오.
-- SELF JOIN 사용
select e.emp_name, e.dept_code, n.emp_name
from employee e 
join employee n on (n.dept_code = e.dept_code);

-- 9. 보너스포인트가 없는 직원들 중에서 직급코드가 J4 와 J7 인 직원들의 사원명, 직급명, 급여를
-- 조회하시오.
-- 단, JOIN, IN 사용할 것
select emp_name, job_name, salary
from employee
join job using(job_code)
where bonus is null and
job_code in ('J4','J7');

select emp_name, job_name, salary
from employee e, job j
where  e.job_code = j.job_code and
bonus is null and 
j.job_code in ('J4', 'J7');





------------------------------------------------------------------------------------------



-- 1. 학생 이름과 주소지를 표시하시오. 단, 출력 헤더는 '학생이름','주소지' 로 하고, 정렬은 이름으로 오름차순 표시하도록한다.
select student_name "학생이름",
student_address "주소지"
from tb_student
order by student_name ;



-- 2. 휴학중인 학생들의 이름과 주민번호를 나아가 적은 순서로 화면에 출력하시오
select student_name ,
student_ssn
from tb_student
where absence_yn = 'Y'
order by student_ssn desc;
-- 3. 주소지가 강원도나 경기도인 학생들 중 1900 년대 학번을 가진 학생들의 이름과 학번, 주소를 이름의 오름차순으로 화면에 출력하시오. 단, 출력헤더에는
-- '학생이름','학번', '거주지 주소' 가 출력되도록 한다.
select student_name, student_no, student_address
from tb_student
where student_address like '강원%' or student_address like '경기%' and
substr(student_no,1,1) <> 'A' 
order by student_name;

-- 4. 현재 법학과 교수 중 가장 나이가 많은 사람부터 이름을 확인할 수 있는 SQ문장을 작성하시오, (법학과의 '학과코드'는 학과 테이블(TB_DEPARTMENT)을 조회해서 찾아내도록하자)
select professor_name, professor_ssn
from tb_professor
where department_no = 005
order by professor_ssn  ;


-- 5. 2004년 2학기에 'C3118100' 과목을 수강한 학생들의 학점을 조회하려고 한다. 학점이 높은 학생부터 표시하고, 학점이 같으면 학번이 낮은 학생부터 표시하는 
-- 구문을 작성해보시오.
select student_no , point
from tb_student
join tb_grade using (student_no)
where class_no = 'C3118100' and 
term_no = 200402
order by point desc  ,student_no  ;


select student_no, student_name, department_name
from tb_student
join tb_department using (department_no)
order by student_no;

select class_name , department_name
from tb_class
join tb_department using (department_no)
;


select class_name , professor_name
from tb_class
join tb_class_professor using(class_no)
join tb_professor using(professor_no)
order by professor_no ;

select class_name , professor_name
from tb_class 
join tb_class_professor  using (class_no)
join tb_department  using (department_no)
join tb_professor using (professor_no)

where category = '인문사회';



select student_no, student_name,  round(avg(point),1) "전체 평점"
from tb_student
join tb_grade using(student_no)
join tb_department using(department_no)
join tb_class using(class_no)
where  department_name = '음악학과'
group by student_no, student_name;

select department_name, student_name, professor_name
from tb_student
join tb_department using(department_no)
join tb_professor on( COACH_PROFESSOR_NO = professor_no)
where student_no = 'A313047';
;

select student_name, term_no term_name
from tb_student
join tb_grade using(student_no)
join tb_class using(class_no)
where substr(term_no,1,4) = 2007 and
class_name = '인간관계론'
group by student_name, term_no
;

select class_name, department_name,category, professor_no
from tb_class
 join tb_department using (department_no)
left join tb_class_professor using(class_no)
where category = '예체능' and
professor_no is null
;

select student_name,  
decode(professor_name, null,'지도교수 미지정',professor_name)  지도교수
from tb_student
join tb_department using(department_no)
left join tb_professor on ( COACH_PROFESSOR_NO = professor_no)
where department_name = '서반아어학과'
order by student_no 
;

select student_no, student_name, department_name, round(avg(point),1)
from tb_student
join tb_department using (department_no)
join tb_grade using (student_no)
where absence_yn = 'N' 
group by student_no, student_name, department_name
having avg(point) >= 4.0
;

select class_no, class_name, round(avg(point),8)
from tb_grade
join tb_class using( class_no)
join tb_department using(department_no)
where department_name = '환경조경학과' and 
class_type <> '논문지도'
group by class_no, class_name;

select t.student_name, t.student_address
from tb_student t
join tb_student s on (s.department_no = t.department_no)
where t.department_no = 017;



select * from tb_student;
select * from tb_class;
select * from tb_class_professor;
select * from tb_department;
select * from tb_grade;
select * from tb_professor;





































