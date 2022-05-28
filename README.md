# 지하철 노선도 관리
## 도메인
지하철 역(station)
- 지하철 역 속성
- 이름(name)  

지하철 구간(section)
- 지하철 (상행 방향)역과 (하행 방향)역 사이의 연결 정보
- 지하철 구간 속성
    - 길이(distance)  
    
지하철 노선(line)
- 지하철 구간의 모음으로 구간에 포함된 지하철 역의 연결 정보
- 지하철 노선 속성
    - 노선 이름(name)
    - 노선 색(color)
    
## 기능 요구사항
- 지하철역 인수 테스트를 완성하세요.
- [x] 지하철역 목록 조회 인수 테스트 작성하기
- [x] 지하철역 삭제 인수 테스트 작성하기
- 인수 조건을 기반으로 지하철 노선 관리 기능을 구현하세요.
- [ ] 지하철 노선 생성
- [ ] 지하철 노선 목록 조회
- [ ] 지하철 노선 조회
- [ ] 지하철 노선 수정
- [ ] 지하철 노선 삭제

## 프로그래밍 요구사항
- 아래의 순서로 기능을 구현하세요.
    - 인수 조건을 검증하는 인수 테스트 작성
    - 인수 테스트를 충족하는 기능 구현
- 인수 테스트의 결과가 다른 인수 테스트에 영향을 끼치지 않도록 인수 테스트를 서로 격리 시키세요.
- 인수 테스트의 재사용성과 가독성, 그리고 빠른 테스트 의도 파악을 위해 인수 테스트를 리팩터링 하세요.
> ! 각각의 테스트를 동작시키면 잘 동작하지만 한번에 동작시키면 실패할 수 있습니다. 이번 단계에서는 이 부분에 대해 고려하지 말고 각각의 인수 테스트를 작성하는 것에 집중해서 진행하세요.

## 인수 조건
- [x] Feature: 지하철역 생성하기  
    Scenario: 지하철역 생성    
    When: 사용자는 지하철역 생성을 요청한다.   
    Then: 지하철 역이 생성된다.  
    Then: 사용자는 지하철역 목록 조회 시 생성한 역을 찾을 수 있다.

- [x] Feature: 지하철역 생성 실패  
    Scenario: 같은 지하철역 생성  
    Given: 지하철역이 생성되어 있다.  
    When: 사용자는 같은 이름의 지하철역 생성을 요청한다.      
    Then: 지하철 역이 생성되지 않는다.  
    
- [x] Feature: 지하철역 목록 조회하기  
    Scenario: 지하철역 목록 조회  
    Given: 2개의 지하철역이 생성되어 있다.  
    When: 사용자는 지하철역 목록을 요청한다.  
    Then: 사용자는 2개의 지하철역 목록을 응답받는다.
    
- [x] Feature: 지하철역 삭제하기  
    Scenario: 지하철역 삭제  
    Given: 지하철역이 생성되어 있다.  
    When: 사용자는 지하철역 삭제를 요청한다.  
    Then: 사용자는 지하철역 목록 조회 시 생성한 역을 찾을 수 없다.
    
- [x] Feature: 지하철 노선 생성하기  
    Scenario: 지하철 노선 생성    
    When: 사용자는 지하철 노선 생성을 요청한다.  
    Then: 지하철 노선이 생성된다.  

- [X] Feature: 지하철 노선 목록 조회하기  
    Scenario: 지하철 노선 목록 조회  
    Given: 2개의 지하철 노선이 생성되어 있다.  
    When: 사용자는 지하철 노선 목록 조회를 요청한다.  
    Then: 사용자는 2개의 지하철 노선 목록을 응답받는다.  

- [x] Feature: 지하철 노선 조회하기  
    Scenario: 지하철 노선 조회  
    Given: 지하철 노선이 생성되어 있다.  
    When: 사용자는 생성한 지하철 노선 조회를 요청한다.  
    Then: 사용자는 생성한 지하철 노선의 정보를 응답받는다.  
    
- [x] Feature: 지하철 노선 수정하기  
    Scenario: 지하철 노선 수정   
    Given: 지하철 노선이 생성되어 있다.  
    When: 사용자는 생성한 지하철 노선 수정을 요청한다.  
    Then: 사용자는 지하철 노선 조회 시 수정된 정보를 응답받는다.
    
- [x] Feature: 지하철 노선 삭제하기  
    Scenario: 지하철 노선 삭제  
    Given: 지하철역이 생성되어 있다.  
    When: 사용자는 지하철 노선 삭제를 요청한다.  
    Then: 사용자는 지하철역 목록 조회 시 생성한 역을 찾을 수 없다.