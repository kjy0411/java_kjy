-- 등록된 영화를 조회하는 쿼리
SELECT
	MO_TITLE AS 영화목록
FROM
	MOVIE;

-- 장르가 드라마인 영화를 조회하는 쿼리
SELECT
	MO_TITLE AS '드라마 장르 영화'
FROM
	MOVIE
		JOIN
	MOVIE_GENRE ON MO_NUM = MG_MO_NUM
WHERE
	MG_GE_NAME = '드라마';
    
-- 개봉전인 영화를 조회하는 쿼리
SELECT
	MO_TITLE AS '개봉전 영화'
FROM
	MOVIE
WHERE
	MO_OPENING_DATE > NOW();
    
-- 상영 종료된 영화를 조회하는 쿼리(현재 개봉중인 영화는 오늘을 기준으로 2주까지 스케줄이 반드시 등록이 됨)
SELECT
	MO_TITLE AS 상영종료영화
FROM
	MOVIE
		LEFT JOIN	-- 상영 종료된 영화는 상영 정보가 없기 때문에 INNER JOIN을 하면 상영 종료된 영화가 조회되지 않음
	MOVIE_SCHEDULE ON MO_NUM = MS_MO_NUM
WHERE
	MO_OPENING_DATE <= NOW()
GROUP BY
	MO_NUM
HAVING
	COUNT(MS_NUM) = 0;
    
-- 영화 콘크리트 유토피아 리뷰를 조회하는 쿼리
SELECT
	*
FROM
	REVIEW
WHERE
	RE_MO_NUM = (SELECT
			MO_NUM
		FROM
			MOVIE
        WHERE
			MO_TITLE = '콘크리트 유토피아');

-- 15세 관람가 영화를 조회하는 쿼리
SELECT
	*
FROM
	MOVIE
WHERE
	MO_AG_NAME = '15세관람가';
    
-- 이병헌이 출연한 영화를 조회하는 쿼리
SELECT
	MO_TITLE AS 영화,
    FP_NAME AS 영화인
FROM
	MOVIE
		JOIN
	ROLE ON MO_NUM = RO_MO_NUM
		JOIN
	FILM_PERSON ON FP_NUM = RO_FP_NUM
WHERE
	FP_NAME = '이병헌';
    
-- 2023년에 개봉한 영화를 조회하는 쿼리
SELECT
	*
FROM
	MOVIE
WHERE
	MO_OPENING_DATE LIKE '2023%';
    
-- 2023년에 개봉한 한국 영화를 조회하는 쿼리
SELECT
	CP_CT_NAME AS 국가,
    MO_TITLE AS 영화
FROM
	MOVIE
		JOIN
	COUNTRY_PRODUCTION ON MO_NUM = CP_MO_NUM
WHERE
	MO_OPENING_DATE LIKE '2023%' AND CP_CT_NAME = '한국';
    
-- 각 영화의 리뷰수를 조회하는 쿼리
SELECT
	MO_TITLE AS 영화,
    COUNT(RE_NUM) AS 리뷰수
FROM
	MOVIE
		LEFT JOIN
    REVIEW ON MO_NUM = RE_MO_NUM
GROUP BY
	MO_NUM;
    
-- CGV강남에서 상영하는 모든 영화 스케쥴을 조회하는 쿼리
-- 영화 제목, 상영시간, 상영관이름
SELECT
	MO_TITLE AS 영화,
    MS_START_TIME AS 상영시간,
    SC_NAME AS 상영관이름
FROM
	MOVIE_SCHEDULE
		JOIN
	MOVIE ON MO_NUM = MS_MO_NUM
		JOIN
	SCREEN ON SC_NUM = MS_SC_NUM
WHERE
	SC_TH_NUM = (SELECT TH_NUM FROM THEATER WHERE TH_NAME = 'CGV강남');
    
-- 영화 예매율 순으로 가장 예매율이 높은 영화 1개를 조회하는 쿼리
-- 예매율이 같은 경우 개봉일이 늦은 영화를 조회
SELECT
	MO_TITLE AS 영화,
    MO_RESERVATION_RATE AS 예매율,
    RANK() OVER(ORDER BY MO_RESERVATION_RATE DESC) AS 순위
FROM
	MOVIE
ORDER BY
	MO_RESERVATION_RATE DESC, MO_OPENING_DATE DESC
LIMIT 1;