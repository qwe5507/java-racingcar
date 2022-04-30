# [1~2 주차] NextStep TDD 과정 - 자동차 경주 게임

## 진행 방법

* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

---------------------

## 3단계 - 자동차 경주 구현 목록

* [X] 입력 View
    * [X] 자동차 시도횟수 메시지 출력 및 입력
    * [X] 자동차 이름 메시지 출력 및 입력


* [X] 출력 View
    * [X] 자동차 이름과 문자 "-" 을 출력
      > pobi: ---<br>
      you: -----

    * [X] 우승차 출력 메시지
      > 최종 우승: pobi, you


* [X] 도메인별 기능
    * [X] 1 ~ 9 랜덤숫자 생성
    * [X] 차 이동 조건
        * [X] 값이 4 ~ 9 사이일 경우
    * [X] 우승자 조회


* [X] 유효성 체크
    * [X] IllegalArgumentException 처리
        * [X] 이동조건 값 1 ~ 9의 범위에 없는 경우
        * [X] 차이름 5글자 초과
        * [X] 차이름 공백일 경우
        * [X] 차이름 중복
        * [X] 테스트 코드에 hasMessage 적용
        * [X] CustomException 처리

* [X] 도메인 객체 분리
    * [X] RacingGame
    * [X] Car
        * [X] Movable 전략패턴
        * [X] ~~생성자 인자 int Position 추가~~
            * [X] 생성자 인자 Position 객체로 변경
        * [X] Position 비교 메서드
        * [X] CarName 객체 적용
        * [X] Position 객체 적용
        * [X] TryCount 객체 적용
    * [X] CarName
        * [X] 유효성체크
            * [X] 글자가 5자 초과시 예외
            * [X] 공백일경우 예외
        * [X] 일급 컬렉션
    * [X] Cars
        * [X] 모든차 이동
    * [X] Position
        * [X] Position 증가
        * [X] Position 값 생성자 초기화
        * [X] Position 비교 메서드
    * [X] WinnerCars
        * [X] 우승차 찾기
    * [X] MovableStrategy
        * [X] NormalMove
    * [X] Random
    * [X] TryCount
        * [X] 시도횟수 초과시 예외
        * [X] 시도횟수 기준 완료유무

----------------

## 1~2 주차 수업정리

* ### TDD 학습요령
    * TDD는 객체를 추출하는 것
    * 즉 의존관계를 분리한다
    * ***도메인 지식이 중요*** (그래서 DDD가 더 어렵다는 것인가?)
    * 하지만 처음엔 어려움
        * 우선 기능목록을 작성 후 기능별로 단위테스트에 집중한다.
        * 기능목록 작성도 어렵다면 일단 막 구현 후, 메서드 단위로 쪼개가며 단위테스트를 역으로 진행
        * TDD 처음 공부시 stream 사용을 지양해 보는 것을 추천
    * 단위 테스트를 처음 작성할 때, 일단 클래스를 만들어라

* ### TDD 를 위한 생성자 오버라이딩
    * 단위테스트 편의를 위한 생성자 오버라이딩은 적극권장 (By. 포비)
        * 단, TDD를 위한 메서드 작성은 절대 금지<br>
          안티패턴임
    * 기존의 인스턴스에 영향을 미치지 않으므로 괜찮음
    * 생성자가 많아질 수록 확장성 또한 좋아짐


* ### ***상태 객체에게 메시지를 보내라***
    * 항상 상태객체에게 질문을 하라
      > ex) car의 위치값을 구할 때
      > * (틀린 방식) if (car.getPosition() == 3) {...}
      > * (올바른 방식) if (car.isPosition(3)) {...}
    * 위처럼 최대한 getter 를 줄여라
        * 테스트하기 용이해짐
        * 중복이 제거됨
        * 응집성 높아짐
    * getter가 보인다? 상태객체에게 물어라. 대화하듯이
        * ~~마 값 내놔라!! 마 이게 맞냐? 진짜 맞냐고?~~
        * 단, DTO에서만 적극적으로 써라. 롬복도 마찬가지


* ### 메서드는 접근 제어자를 써서 서서히 오픈하라
    * private -> package -> public
    * 프로젝트가 확장되며 필요할 때 권한을 풀어가면 됨


* ### getter, setter는 도메인에선 최대한 쓰지마라
    * 앞서 언급한 상태 객체에게 메시지를 보내도록 구현
    * View 처럼 진짜 필요한 곳에서만 사용(DTO)


* ### 메서드 이름도 도메인과 관련되게 짓자
  > car.isMaxPosition(5)<br>
  > -> car.isWinner(5)

* ### 서비스에 biz 로직을 절대 만들지마라
    * 도메인에서 충분히 구현 가능하다
    * 포비 개인 경험상 95% 의 개발자들이 서비스에 구현했다고 한다


* ### 클래스 분리
    * 원시값을 클래스에 포장
    * 일급 컬렉션
        * 하나의 필드변수만 가진다
        * 불변
        * 생성자
            * 객체가 값에 대한 책임을 져야한다
            * 유효성 체크도 진행해서 값의 정확성을 클래스가 보장
        * equals 를 필수적으로 오버라이딩 하자
    * 생성자가 여러개일 경우 인자가 가장 많은 생성자에 로직구현과 초기화를 하고<br>
      마지막 단락에 생성자를 놓는다.
    * public 으로 열린 도메인 메서드의 코드는 리팩토리를 통해 최대한 줄여라
        * 1줄도 괜찮다고 생각함 (By.포비)
        * 마치 함수형 프로그래밍이나 체이닝처럼
  > public Car(String name) {<br>
  > &nbsp;&nbsp;&nbsp;&nbsp;this(name, 0);<br>
  > }<br><Br>
  > public Car(String name, int position) {<br>
  > &nbsp;&nbsp;&nbsp;&nbsp;this.name = new CarName(name);<br>
  > &nbsp;&nbsp;&nbsp;&nbsp;this.position = new Position(position);<br>
  > }
