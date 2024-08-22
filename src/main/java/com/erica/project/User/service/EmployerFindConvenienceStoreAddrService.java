//package com.erica.project.User.service;
//
//import com.erica.project.apply.KakaoApi.KakaoPlace;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import java.net.URI;
//import java.net.http.HttpHeaders;
//
//@Service
//public class EmployerFindConvenienceStoreAddrService {
//    // 카카오 api 받아서 편의점이름 입력시 주소를 반환해주는 기능 구현
//    // 키워드로 검색하기 api 활용
//
//    // 메서드 구현: 카카오api의 키워드로 검색하기 api 호출하는 메서드 구현 - resttemplate을 사용하여 api호출
//    private final RestTemplate restTemplate = new RestTemplate();
//
//    @Value("${kakao.api.key}")
//    private String apiKey;
//
//    // JSON 형태의 응답을 반환
//    public KakaoPlace findAddrByStorename(String storeName) throws JsonProcessingException {
//
//        // uri 생성
//        URI uri = UriComponentsBuilder.fromUriString("https://dapi.kakao.com/")
//                        .path("/v2/local/search/keyword.json")  // 기본 url 뒤에 추가할 경로 설정 - Kakao 로컬 API에서 키워드 검색을 위한 엔드포인트
//                        .queryParam("query", storeName)
//                        .queryParam("category_group_code", "CS2") // 카테고리 별 편의점 코드
//                        .build()
//                        .encode()
//                        .toUri();
//
//        //
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Authorization", "KakaoAK" + apiKey); // Kakao에서 요구하는 인증 방식의 접두사, 여기에 실제 API 키가 추가됨
//        HttpEntity<String> entity = new HttpEntity<String>(headers);
//
//        // Api 호출
//        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
//
//        String jsonResponse =  response.getBody(); // JSON 응답을 그대로 반환 (필요시 가공)
//
//        // Json 문자열을 KakaoPlace 객체형의 배열로 변환
//        ObjectMapper mapper = new ObjectMapper();
//
//        KakaoPlace[] places = mapper.readValue(jsonResponse, KakaoPlace[].class);
//        if(places.length > 0){
//            return places[0];
//        }
//        else{
//            return null;
//        }
//    }
//}
