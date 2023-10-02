### 미션 요약
#### 1. 다리 생성
- `다리 길이`: User에게 입력 받는다.
- `다리 이동가능 경로`: System이 칸마다 0, 1 중 한 값으로 결정 with _랜덤_
  - 랜덤 값이 0 : 아래 칸 이동가능
  - 랜덤 값이 1 : 위 칸 이동가능
#### 2. 플레이어 이동
- `이동 위치`: User에게 입력 받는다. (U or D)
- `이동 결과 반환`: User가 입력한 위치가 
  - 이동 가능하면 O 반환
  - 불가능하면 X 반환
#### 3. 게임 분기
- `다리를 끝까지 건넌다`
  - _종료_ with 게임 성공 + 시도 횟수 출력
- `다리를 건너다 실패한다` 
  - _재시작_ -> 2번으로 이동
  - _종료_ with 게임 실패 + 시도 횟수 출력


### 클래스 설명
📂 **controller**
 - `BridgeGame` 클래스

📂 **service**
- ㄴㅇㄹ

📂 **view**
- `InputView` 클래스: 
- `OutputView` 클래스 :

🗒️`Application` 클래스  
🗒️`BridgeMaker` 클래스  
🗒️`BridgeNumberGenerator` 클래스  
🗒️`BridgeRandomNumberGenerator` 클래스  


### 유의한 점
- 클래스의 필드는 private OR public?
  - public 클래스는 가변 필드를 직접 노출하면 안된다.
  - 참고: [public 클래스에서는 public 필드가 아닌 접근자 메서드를 사용하라](https://incheol-jung.gitbook.io/docs/study/effective-java/undefined-2/2020-03-20-effective-16item)
- 예외처리 범위 구분하기
  - 도메인(input 값) 예외처리 외에도 서비스 단에서의 예외처리, 컨트롤러 단에서의 예외처리가 필요할 수 있다.
  - 이전 로또 문제에서 간과했던 부분! (로또 당첨번호와 로또 보너스 번호가 중복인지 비교하지 못했음)
- TDD
  - 컨트롤러에서 메소드 하나 완성할때마다 테스트 클래스 생성하기