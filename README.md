# 충북대학교 소프트웨어학과 전공동아리 Spring 스터디 Repository

+ 참여인원 
1. 신수웅
2. 이선명
3. 오지영
4. 이예나

**사용 방법 : 브랜치를 나눠서 PR(Pull Request) 요청을 해주시기 바랍니다.**

1. 이 레포지토리를 자신의 Github로 Fork 한다. 
2. `git checkout -b study/suung` **study/자기이름(영문)** 해당 규칙으로 브랜치 생성
3. `git add suung` 기존 자신이 정리한 내용들의 폴더를 추가 한 후 복붙 (폴더명은 자신의 이름 영문)
4. `git commit -m '~~~'` 나눈 브랜치에서 commit 수행
5. `git checkout master & git merge study/suung` 마스터 브랜치로 빠져나온 후 나눈 브랜치 병합 
6. 자신이 Fork를 뜬 레포지토리에서 이 레포지토리로 PR(Pull Request) 요청을 한다. 
 
+ 규칙 
1. Commit 메세지는 제목과 내용이 포함되도록 (제목과 본문은 한칸 띄어쓰기) 

+ 예시 
```bash
git commit -m 'inflearn 1section completed 
> 
> 이번 강의에서는 스프링 빈과 의존관계에 대해서 배웠으며 ~ (해당 강의 내용 요약)'
```
2. PR은 섹션 1개가 끝날때마다 하기
3. 모르거나 헷갈리는 부분은 [Discussion](https://github.com/orgs/CBNU-Nnet/teams/spring-study/discussions)란에 질문

+ 참고자료 
1. [좋은 git 커밋 메시지를 작성하기 위한 7가지 약속](https://meetup.toast.com/posts/106)
