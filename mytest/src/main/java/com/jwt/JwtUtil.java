package com.jwt;

import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author yueyi2019
 */
public class JwtUtil {


    public static void main(String[] args) {


    String tooken =     createToken("xxxxx",new Date());

        System.out.println(tooken);


//        String t = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ4eHh4eCIsImlhdCI6MTYzNjg3NTk5OCwiZXhwIjoxNjM2ODc2MDA4fQ.JI2gUhRW_eSiJZumpZbZz8xCbdiM2vSGKruAIDtZQcI";

        String role = parseToken(tooken);

        System.out.println(role);







    }



    /**
     * 密钥，仅服务端存储
     */
    private static String secret = "ko346134h_we]rg3in_yip1!";

    /**
     *
     * @param subject
     * @param issueDate 签发时间
     * @return
     */
    public static String createToken(String subject, Date issueDate) {
    	
    	
        Calendar c = Calendar.getInstance();  
        c.setTime(issueDate);  
        c.add(Calendar.SECOND, 100);
        
    	
    	MyDefaultClaims mdc = new MyDefaultClaims();

    	mdc.setSubject(subject);
    	mdc.setIssuedAt(issueDate);
        mdc.setExpiration(c.getTime());
        mdc.setRole("admin");

        String compactJws = Jwts.builder()
                .setClaims(mdc)
                		
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
        return compactJws;

    }

    /**
     * 解密 jwt
     * @param token
     * @return
     * @throws Exception
     */
    public static String parseToken(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
//             MyDefaultClaims mdc = (MyDefaultClaims)claims;
            if (claims != null){
                return claims.get("role").toString();
            }
        }catch (ExpiredJwtException e){
            e.printStackTrace();
            System.out.println("jwt过期了");
        }

        return "";
    }

}