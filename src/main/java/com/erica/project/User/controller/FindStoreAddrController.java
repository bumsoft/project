//package com.erica.project.User.controller;
//
//import com.erica.project.User.service.EmployerFindConvenienceStoreAddrService;
//import com.erica.project.apply.KakaoApi.KakaoPlace;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//// 본적으로 메서드의 반환값을 JSON이나 XML 형식으로 변환하여 HTTP 응답의 본문(body)에 담아 반환
//@RestController  // restful api 활용할 때 사용
//public class FindStoreAddrController {
//
//    @Autowired
//    private EmployerFindConvenienceStoreAddrService employerFindConvenienceStoreAddrService;
//
//    @GetMapping("/api/find-address")
//    public ResponseEntity<KakaoPlace> findStoreAddr(@RequestParam String storeName) throws JsonProcessingException {
//        KakaoPlace place = employerFindConvenienceStoreAddrService.findAddrByStorename(storeName);
//        return ResponseEntity.ok(place);
//    }
//}
