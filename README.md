###  !!!!!!!!!!!! 변수 작명 규칙 !!!!!!!!!!!!
*카멜 표기법*을 따름 : 첫 글자는 소문자, 뒷 단어 첫글자는 대문자  
ex. JobPost => jobPost
    UserRepository => userRepository

#### 엔티티 필드 작명시
@id (primary key)의 경우, 클래스명 + '_' + id 로 작성
@id의 자료형은 Long으로 통일
나머지 필드는 위와 동일
ex. JobPost의 경우 jobPost_id  (첫 글자는 소문자)

유저가 로그인시 사용하는 아이디의 경우 username 으로 사용

### DTO작명
클라이언트 => 서버 : Request_ + "관련내용"+Dto
ex. 공고글 작성 폼을 클라이언트에서 서버로 전송하는 dto의 경우 Request_JobPostDto로 작명

ex. 서버 => 클라이언트 : Response_ + "관련내용"+Dto

### 유저관련

1



### 공고글 관련
