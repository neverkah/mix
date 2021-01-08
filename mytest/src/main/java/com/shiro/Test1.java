package com.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import java.io.File;

public class Test1 {


    @Test
    public void test1(){


        Subject currentUser = SecurityUtils.getSubject();

        System.out.println(currentUser);
    }

    @Test
    public void test2(){
        File f = new File("J:\\Elisa.and.Marcela.2019.SPANISH.1080p.WEBRip.x264-RARBG\\Elisa.and.Marcela.2019.SPANISH.1080p.WEBRip.x264-RARBG_1609136793468.srt");
        String hex = new Md5Hash(f).toHex();

        System.out.println(hex);


    }



}
