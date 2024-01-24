plugins { // 프로젝트에 사용할 플러그인 추가
    id 'java'
    id 'org.springframework.boot' version '3.0.2' // 프로젝트에 사용할 스프링 부트 플러그인
    id 'io.spring.dependency-management' version '1.1.0' // 스프링의 의존성을 자동으로 관리
}

group = '지정한 그룹 이름' // 프로젝트를 설정할 때 작성한 그룹 이름
version = '1.0' // 프로젝트 버전
sourceCompatibility = '17' // 자바 소스를 컴파일할 때 사용할 자바 버전

repositories { // 의존성을 받을 저장소 지정
    mavenCentral()
}

dependencies { // 프로젝트를 개발하며 필요한 기능의 의존성을 입력
    implementation 'org.springframework.boot:spring-boot-starter-web'
    // 기본값을 모두 지우고 웹 관련 기능을 제공
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    // 테스트 기능을 제공
}

test {
    useJUnitPlatform()
}