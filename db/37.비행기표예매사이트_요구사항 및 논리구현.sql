/*
비행기표 예매 사이트

- 사용자들은 회원가입을 통해 회원이 되거나 비회원으로 비행기표를 예매할 수 있다
- 회원은 비행기표를 예매할 때 결제한 금액의 10%의 마일리지를 얻을 수 있다
- 회원가입시 아이디, 비번, 이름, 전화번호를 입력한다

- 관리자는 비행기 노선을 등록할 수 있으며 등록시 비행기모델, 출발지, 도착지, 출발시간(yyyy-MM-dd hh-mm-ss), 도착시간을 입력한다
- 비용은 일반석기준 국내선은 5만원/시간 국외선은 10만원/시간이며 비즈니스석은 2배 퍼스트석은 4배이다

- 비행기는 모델별로 퍼스트석, 비지니스석, 일반석의 좌석수와 적재화물용량을 가진다
- 공항은 국가를 가진다

- 예매할때는 출발지, 목적지, 날짜, 좌석수를 선택하면 해당하는 노선을 보여주며 가격순으로 정렬하여 나타낸다
- 노선을 선택하면 등급별 비용과 남은 좌석정보를 보여주고 원하는 좌석을 선택한다
- 결제시 보유마일리지를 보여주며 비용의 일부를 마일리지로 결제 가능하다
- 예매를 완료하면 예매표번호를 발급한다

- 환불정책은 출발날자를 기준으로 3일전엔 75% 하루전엔 25%를 환급한다

회원
아이디(PK) 비번 이름 전화번호 마일리지 권한(User, Admin)
노선
노선번호(PK) 비행기모델(FK) 출발지(FK) 도착지(FK) 출발시간 도착시간
비행기모델
모델명(PK) 퍼스트석 비지니스석 일반석
좌석
좌석번호(PK) 비행기모델(FK)
예매표
예매표번호(PK) 아이디(FK) 노선번호(FK) 좌석번호(FK) 총비용 사용마일리지 결제금액
마일리지
마일리지번호(PK) 아이디(FK) 
공항
공항명(PK) 국가
샘플데이터
- 한국 김포 인천 제주 김해 광주
- 미국 뉴욕 워싱턴 
- 중국 베이징 홍콩 상하이
- 일본 도쿄 오사카
- 영국 런던
- 프랑스 파리
- 호주 캔버라
*/