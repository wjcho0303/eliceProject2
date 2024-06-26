<h1> 🎀 엘리스 2차 팀 프로젝트 🖥</h1> 
- 본 프로젝트는 1차 개인 프로젝트와는 달리 팀 프로젝트로 진행되었습니다. <br/>
- 팀 구성원은 모두 백엔드 개발자이며, 페이지는 Thymeleaf를 사용한 SSR(Server-side Rendering) 방식으로 구현하였습니다. <br/>
<br/>
<br/>

---

<h3>※ 프로젝트 개요 </h3>
- 프로젝트 진행 기간 : 2024.03.25 (월) ~ 2024.04.19 (금) (4주간) <br/>
- 프로젝트 목표: 쇼핑몰의 회원, 카테고리, 상품, 장바구니, 주문 도메인 CRUD 구현 <br/>
<br/>
<br/>

---

<h3>※ 협업 방식</h3>
월, 수, 금 오전 10시 30분에 만나 간단히 스크럼을 진행했으며,<br/>
이 외에 수시로 주 소통 채널인 디스코드 채팅방을 통해 의사소통하였습니다. <br/>
원격 저장소는 gitLab을 사용하였으며, commit과 pull 을 자주하도록 소통하여 <br/>
코드 충돌을 최소화 하였습니다.<br/>
<br/>
<br/>

---

<h3>※ 기획과정 및 담당영역</h3>
먼저 플로우 차트를 작성하여 클라이언트의 역할 별로 웹 사이트가 <br/>
어떠한 흐름으로 동작할지에 대해 작성해놓았습니다. <br/>
그 후에 ERD를 작성하여 데이터베이스 다이어그램을 그렸습니다. <br/>
그 후 각 도메인 별로 API 문서를 작성하여 요청과 응답에 대한 밑그림을 그렸습니다. <br/>
<br/>
주요 담당 역할은 다음과 같습니다: <br/>
User - 임준용, 최윤기<br/>
Category, 이미지 업로드 - 조웅진<br/>
Product - 정진서<br/>
Cart - 민경진<br/>
Order - 김민상<br/>
<br/>
<br/>

---

<h3>※ 트러블 슈팅</h3>
이미지를 업로드 받기 위해 application.properties에 별도의 파일 경로값을 정해놓은 후<br/>
Controller 레이어에서 @Value 어노테이션을 사용하여 설정값을 사용했습니다.<br/>
그 결과 이미지를 업로드했을 때 해당 어노테이션 값의 경로를 이용할 수 있었습니다.<br/>

서버의 로컬 저장소로 이미지를 업로드 받는 데까지는 구현하였으나,<br/>
타임리프 템플릿 엔진에서 업로드 된 직후에는 이미지를 게시하지 못하는 문제가 있었습니다.<br/>
이러한 이미지 업로드 문제는 3차 프로젝트에서 해결하게 됩니다.<br/>
<br/>
<br/>

---

<h3>※ 개선할 점</h3>
개선할 점은 사실 한두 가지가 아니었습니다.<br/>
이 2차 프로젝트는 저에게 있어 아쉬운 프로젝트였습니다.<br/>
사실 우리 팀이 우수상을 받게 되었지만, 이 프로젝트에서 제가 담당한 역할은 크지 않았습니다.<br/>
카테고리 CRUD와 이미지 업로드 기능 외에는 작업한 것이 거의 없었습니다.<br/>
사실 2차 프로젝트를 할 당시에는 CRUD 마저도 아직 감이 잡히지 않았던 상태라서 그렇게 했었던 것 같기도 하지만 <br/>
결과물을 보니 1차 프로젝트와 크게 다르지 않아 성장이 많이 더디다고 느꼈던 프로젝트입니다.<br/>
<br/>
지금 생각해보면 카테고리나 이미지 업로드 외에도 AWS S3를 활용한 이미지 업로드라든지, 이메일 발송 기능이라든지<br/>
좀 더 도전적으로 코드를 작성할 수 있었는데, 그렇게 하지 못한 점이 후회되는 프로젝트였습니다.<br/>
<br/>
1차 프로젝트와 2차 프로젝트는 단순한 CRUD를 실습해보는 느낌 정도였는데,<br/>
이로 인해 3차 프로젝트 때는 더 적극적이고 열심히 해야겠다는 생각을 갖게 되었습니다.<br/>
그리고 실제로 3차 프로젝트 때는 1차 프로젝트와 2차 프로젝트에 비해서 정말 적극적으로 코드를 연구하고 작업을 진행하게 되었습니다.<br/>
<br/>
<br/>
