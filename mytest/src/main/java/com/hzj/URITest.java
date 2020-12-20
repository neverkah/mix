package com.hzj;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class URITest {


    public static void main(String[] args) throws UnsupportedEncodingException {

        String URL = "Man kümmert sich um euer Gepäck";
        String encodeURI = URLEncoder.encode(URL, "UTF-8");

        System.out.println(encodeURI);
    }
}
