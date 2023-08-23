/*
join 문법
-- 테이블1의 왜래키가 테이블2의 기본키를 참조하는 경우
-- JOIN은 일반적으로 외래키와 기본키를 연결하지만, 상황에 따라서는 외래키가 아닌 속성을 기본키와 연결할 수 있다.
SELECT
	테이블1.속성명1, 테이블1.속성명2, ..., 테이블2.속성명1, 테이블2.속성명2, ...
FROM
	테이블1
INNER JOIN | LEFT JOIN | RIGHT JOIN -- INNER 조인과 OUTER 조인 둘다 가능
	테이블2
ON
	테이블1.외래키 = 테이블2.기본키
[INNER JOIN | LEFT JOIN | RIGHT JOIN
	테이블3
ON 테이블1.외래키 = 테이블3.기본키]
[WHERE 절]
[GROUP BY절]
[HAVING 절]
[ORDER BY 절]
[LIMIT 절]
*/
SELECT 
    COURSE.*, TITLE
FROM
    COURSE
JOIN
    SUBJECT
ON
	COURSE.SUBJECT_CODE = SUBJECT.CODE;
    
-- 대학물리를 수강하는 학생들 수를 조회하는 쿼리
-- JOIN 사용X
SELECT
	SUBJECT_CODE AS 과목코드,COUNT(*) AS 수강생수
FROM
	COURSE
WHERE
	SUBJECT_CODE IN (SELECT
			CODE
		FROM
			SUBJECT
		WHERE
			TITLE = '대학물리')
GROUP BY
	SUBJECT_CODE;
-- JOIN사용
SELECT
	SUBJECT_CODE AS 과목코드, COUNT(*) AS 수강생수
FROM
	COURSE
JOIN
	SUBJECT
ON
	SUBJECT_CODE = CODE
WHERE
	TITLE = '대학물리'
GROUP BY SUBJECT_CODE;

-- 유재석 학생이 수강하는 과목의 수를 조회하는 쿼리
-- JOIN 사용X
SELECT
	STUDENT_NUM AS 유재석학번, COUNT(*) AS 수강과목수
FROM
	COURSE
WHERE
	STUDENT_NUM = (SELECT NUM FROM STUDENT WHERE NAME = '유재석')
GROUP BY
	STUDENT_NUM;
-- JOIN 사용
SELECT 
    NAME AS 이름, STUDENT_NUM AS 유재석학번, COUNT(*) AS 수강과목수
FROM
    COURSE
JOIN
    STUDENT
ON
	STUDENT_NUM = STUDENT.NUM
WHERE
	NAME = '유재석'
GROUP BY
	STUDENT_NUM;
    
-- 유재석 학생이 수강하는 과목명을 조회하는 쿼리
SELECT 
	NAME AS 이름, TITLE AS 수강과목
FROM
    COURSE
JOIN
	STUDENT ON STUDENT_NUM = STUDENT.NUM
JOIN
    SUBJECT ON SUBJECT_CODE = CODE
WHERE
	NAME = '유재석';
    
-- 이순신 교수님이 강의하는 과목명을 조회하는 쿼리
SELECT
	distinct PROFESSOR_NAME AS 교수, TITLE AS 과목명
FROM
	COURSE
		JOIN
	SUBJECT ON SUBJECT_CODE = CODE
WHERE
	PROFESSOR_NAME = '이순신';