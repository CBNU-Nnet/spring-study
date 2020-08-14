<h1>스프링 DB 접근 기술</h1>

<h3>H2 데이터베이스 설치</h3>

----------------

- https://www.h2.database.com 에서 다운로드 설치
- h2 열고 데이터 베이스 파일 생성
    - jdbc:h2:~/test(최초 한번)
    - ~/test.mv.db 파일 생성 확인
    - 이후부터는 jdbc:h2:tcp://localhost/~/test 이렇게 접속

<b> 테이블 생성하기</b>

<p>h2 콘솔 열고 create table</p>

![createmember](createmember.PNG)

<br>

<p> 이후 프로젝트 루트에 sql/ddl.sql파일 생성
