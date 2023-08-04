USE SHOPPINGMALL;

-- 회원아이디가 abc123, 비번이 1234, 번호가 011-1234-5678,
-- 주소가 서울시 강남구 KH빌딩, 주소 상세가 6층 361반, 우편번호 01234인 회원이 가입을 했을 때 쿼리
-- 권한은 ADMIN, USER 중 하나
INSERT INTO MEMBER(ME_ID, ME_PW, ME_PHONE, ME_ADDR, ME_ADDR_DETAIL, ME_POST, ME_AUTHORITY, ME_NAME)
	VALUES ('abc123', 1234, '011-1234-5678', '서울시 강남구 KH빌딩', '6층 361반', '01234', 'USER', '홍길동');
INSERT INTO MEMBER(ME_ID, ME_PW, ME_PHONE, ME_ADDR, ME_ADDR_DETAIL, ME_POST, ME_AUTHORITY, ME_NAME)
	VALUES ('admin', 'admin', '011-1111-1111', '서울시 강남구 KH빌딩', '3층 301반', '01231', 'ADMIN', '임꺽정');
INSERT INTO MEMBER(ME_ID, ME_PW, ME_PHONE, ME_ADDR, ME_ADDR_DETAIL, ME_POST, ME_AUTHORITY, ME_NAME)
	VALUES ('qwe123', 'qwe1234', '011-9999-5678', '서울시 강남구 KH빌딩', '1층 161반', '01234', 'USER', '유재석');
    
-- 제품코드가 ABC001, 제품명이 KH무선마우스, 제품설명이 KH무선마우스입니다., 가격이 15000원
-- 종류가 무선 / 유선 제품을 등록하는 쿼리를 작성
-- PRODUCT 테이블과 OPTION테이블에 데이터를 추가
INSERT INTO PRODUCT	VALUES ('ABC001', 'KH무선마우스', 'KH무선마우스입니다', '15000');
INSERT INTO `OPTION`(OP_NAME, OP_PR_CODE) VALUES ('무선', 'ABC001'), ('유선', 'ABC001');

-- 제품 코드가 ABC001인 제품의 제품정보와 옵션을 조회하는 쿼리
SELECT * FROM PRODUCT
	JOIN `OPTION` ON PR_CODE = OP_PR_CODE
    WHERE PR_CODE = 'ABC001';
