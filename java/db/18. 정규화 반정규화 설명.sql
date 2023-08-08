/*
정규화 : 테이블을 쪼개는 과정
 - 데이터의 중복을 최소화하고, 데이터의 일관성과 무결성(개체, 참조)을 유지하기 위해서
제1 정규화
- 각 열은 원자값만 포함해야 한다.
- 각 행은 기본키를 가져야 한다.
- 중복된 데이터를 제거해서 복수개의 행으로 구성한다.
제2 정규화
- 제1 정규화를 만족
- 주요 속성에 완전 종속되어야 한다.
제3 정규화
- 제2 정규화를 만족
- 이행적 종속성을 제거해야한다.
-> A->C : A를 통해 C를 알수 있는 테이블을 A->B, B->C를 통해 알수 있도록 테이블을 추가해서 구성
역정규화(반정규화) : 테이블을 합치는 과정
 - 성능향상을 목적으로 데이터 중복을 허용하는 것
 
*/