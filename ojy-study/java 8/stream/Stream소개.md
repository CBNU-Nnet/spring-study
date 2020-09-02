# Stream

### Stream 소개

------------------

**Stream**

- 데이터를 담고 있는 저장소를 소스로 사용하여 처리하는 것
- Functional하다 , 스트림이 처리하는 데이터 소스를 변경하지 않는다
    ```
    public static void main(String[] args){

        List<String> name = new ArrayList<>();
        name.add("Keesun");
        name.add("whiteship");
        name.add("toby");
        name.add("foo");

        Stream<String> stringStream =name.stream().map(String::toUpperCase);
        name.forEach(System.out::println);
  }

  //stream에 넣으면 대문자가아니라 소문자로 코드변경 없이 그대로 출력함
  ```

4. 스트림으로 처리하는 데이터는 오직 한번만 처리함(위의 예시와 동일)

5. 무제한일 수도 있다.(Short Circuit 메소드를 사용해서 제한할 수 있다)

6. 중개 오퍼레이션은 근본적으로 lazy하다
    ```
    name.stream().map((s)->{
            System.out.println(s);
            return s.toUpperCase();
        });
    //출력이 안됨
    ```
    - terminal 오퍼레이션이 오기전까지 일을하지않음
    - 중개형 오퍼레이션은 올수도 있고 안올 수 도 있는데 종료형 오퍼레이션은 반드시 와야함
    - 단지 정의한 것 뿐임

7. 손쉽게 병렬처리를 할 수 있다
    - for문은 병렬처리를 하지 못하지만 parallelStream()을 사용하면 병렬적
    으로 처리를 함
    - 하지만 무조건 빨라지고 좋은것은 아니고 좀더 느려질 수도 있음

<br/>

**스트림 파이프라인**

- 0또는 다수의 중개 오퍼레이션과 하나의 종료 오퍼레이션으로 구성한다
- 스트림의 데이터 소스는 오직 터미널 오퍼레이션을 실행할 때에만 처리한다

<br/>

**중개 오퍼레이션**
- Stream 리턴
- filter,map,limit...

**종료 오퍼레이션**
- Stream을 리턴하지 않음
- collect,allMatch,count,forEach,min,max

<br/>

### Stream API

-------------------------------

**걸러내기**

1. Filter
    - 오퍼레이션에서 필터를하고 그 다음 종료 오퍼레이션이 들어옴
    ```
    springClasses.stream()
        .filter(oc->oc.getTitle().startsWith("spring"))
        .forEach(oc -> System.out.println(oc.getId()));
    ```

    ```
    System.out.println("close되지 않은 수업");
    springClasses.stream()
        .filter(Predicate.not(OnlineClass::isClosed))
        .forEach(oc -> System.out.println(oc.getId()));
    ```

**변경하기**

1. Map
    - 들어올땐 online클래스로 들어오지만 나갈때는 다른 클래스로 나갈 수있음

    oc->stream->forEach
    ```
    springClasses.stream()
        .map(oc-oc.getTitle)
        .forEach(System.out::println);
    ```

2. stream의 데이터가 list안으로 들어가는데 flat형태(online 클래스들을 다 풀어냄)
    - 첫번째 리스트에 4개의 클래스, 두번째 리스트에 3개의 클래스가 들어있으면 
    ->4->3으로 온라인클래스를 다루는 stream으로 flat시킬수 있음
    - operator를 작성할 때마다 operate가 달라질 수 있기 때문에 object type이 무엇인지 알아야한다 
    
    ```
    keesunEvents.stream().flatMap(Collection::stream)
    .forEach(oc->System.out.println(oc.getId());
    ``


**생성하기**

1. iterate
    ```
    Stream.iterate(10,i->i+1)
        .forEach(System.out::println);
    
    //무한대로 계속 출력
    ```

**스트림에 데이터가 특정 조건을 만족하는지 확인**
1. allMatch, anyMatch
    ```
    javaClasses.stream().anyMatch(oc->oc.getTitle().contains("Test"));

    //자바 수업중에 Test가 들어있는 수업이 있는지 확인
    ```

<br/>

*순서에 따라 오퍼레이트 타입 달라짐*
    ```
    List<String> spring = springClasses.stream()
        .filter(oc->oc.getTitle().contains("spring"))
        .map(OnlinceClass::getTitle)
        .collect(Collectors.toList());
    
    spring.forEach(System.out::println);

    //스프링 수업중에 제목이 spring이 들어간 제목만 모아서 List로 만들기
    ```
    ```
    List<String> spring = springClasses.stream()
        .map(OnlinceClass::getTitle)
        .filter(t->t.contains("spring"))
        .collect(Collectors.toList());
    
    spring.forEach(System.out::println);
