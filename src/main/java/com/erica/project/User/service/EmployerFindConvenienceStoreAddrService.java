package com.erica.project.User.service;

import com.erica.project.apply.KakaoApi.KakaoPlace;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


@Service
public class EmployerFindConvenienceStoreAddrService {
    // 카카오 api 받아서 편의점이름 입력시 주소를 반환해주는 기능 구현
    // 키워드로 검색하기 api 활용

    // 메서드 구현: 카카오api의 키워드로 검색하기 api 호출하는 메서드 구현 - resttemplate을 사용하여 api호출
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${kakao.api.key}")
    private String apiKey;

    // JSON 형태의 응답을 반환
    public ArrayList<KakaoPlace> findAddrByStorename(String storeName) throws JsonProcessingException
    {

        //url 생성
        String url = UriComponentsBuilder.fromHttpUrl("https://dapi.kakao.com/v2/local/search/keyword.json")
                .queryParam("query", URLEncoder.encode(storeName, StandardCharsets.UTF_8))
                .queryParam("category_group_code", "CS2")
                .build()
                .toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "KakaoAK " + apiKey); // Kakao에서 요구하는 인증 방식의 접두사, 여기에 실제 API 키가 추가됨
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Api 호출
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        String jsonResponse =  response.getBody(); // JSON 응답을 그대로 반환 (필요시 가공)

        // Json 문자열을 KakaoPlace 객체형의 배열로 변환
        ObjectMapper mapper = new ObjectMapper();

        JsonNode rootNode = mapper.readTree(jsonResponse);
        JsonNode documentsNode = rootNode.path("documents");

        ArrayList<KakaoPlace> places = mapper.readValue(documentsNode.toString(),new TypeReference<ArrayList<KakaoPlace>>(){});

        return places;

    }
}
