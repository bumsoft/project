package com.erica.project.springSecurity;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException
    {
        //강제 인터셉트였다면 원래 요청얻기
        RequestCache requestCache = new HttpSessionRequestCache();
        SavedRequest savedRequest = requestCache.getRequest(request, response);

        //로그인 성공시 이동할 페이지
        String url = null;


        if(savedRequest != null) //강제였다면, url을 원래 요청으로 설정
        {
            url = savedRequest.getRedirectUrl();

            requestCache.removeRequest(request, response);
        }
        else //권한별 이동 설정
        {
            url = determineTargetUrl(authentication);
        }

        if(url == null)
        {
            url = "/";
        }

        response.sendRedirect(url);
    }

    private String determineTargetUrl(Authentication authentication)
    {
        boolean isAdmin = false;
        boolean isEmployee = false;
        boolean isEmployer = false;
        for(GrantedAuthority authority : authentication.getAuthorities())
        {
            if(authority.getAuthority().equals("ROLE_ADMIN"))
            {
                isAdmin = true;
            } else if (authority.getAuthority().equals("ROLE_EMPLOYER"))
            {
                isEmployer = true;
            }else if(authority.getAuthority().equals("ROLE_EMPLOYEE"))
            {
                isEmployee = true;
            }
        }
        if(isAdmin) return "/"; //관리자면 홈으로 보냄
        if(isEmployer) return "/employer";
        if(isEmployee) return "/employee";
        else return "/";
    }
}
