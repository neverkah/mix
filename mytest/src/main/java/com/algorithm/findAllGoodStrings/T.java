package com.algorithm.findAllGoodStrings;

import org.junit.Test;

import java.util.Random;

public class T {
    public static void main(String[] args) {
        String s = "acd";
        int x = 1000000000 + 7;
        System.out.println('{' + 0);
        System.out.println('a' + 0);
        System.out.println("qnz".compareTo("qn"));
    }

    @Test
    public void test6() {
        while (true) {
            int n = 500;
            StringBuilder s1 = new StringBuilder();
            StringBuilder s2 = new StringBuilder();
            StringBuilder evil = new StringBuilder();
            Random r = new Random();
            for (int i = 1; i <= 500; i++) {
                s1.append((char) (r.nextInt(26) + 97));
                s2.append((char) (r.nextInt(26) + 97));
            }
            for (int i = 1; i <= 50; i++) {
                evil.append((char) (r.nextInt(26) + 97));
            }
            if (s1.toString().compareTo(s2.toString()) <= 0) {
                System.out.println(Solution.findGoodStrings(n, s1.toString(), s2.toString(), evil.toString()));
                break;
            }
        }
//        String s1 = "abd", s2 = "efg", evil = "ac";
    }

    @Test
    public void test() {
        int n = 8;
        String s1 = "pzdanyao",
                s2 = "wgpmtywi",
                evil = "sdka";
        System.out.println(Solution.findGoodStrings(n, s1, s2, evil));
    }

    @Test
    public void test3() {
        int n = 3;
        String s1 = "qye",
                s2 = "vkv",
                evil = "qn";
        System.out.println(Solution.findGoodStrings(n, s1, s2, evil));
        System.out.println(new Solution2().findGoodStrings(n, s1, s2, evil));
    }

    @Test
    public void test9() {
        int n = 500;
        String s1 = "msefmreuttipbujumdavdehhhdxsdiedzztfsftqzvkczbzjoabijtzodujveqawdzedigtrthpunktdbjqghhlayeyczddmdovgglkxsehptaafgucwwygakkzkziyilcntljatbthrjmamxgvpnuwpurbjeujekkijspijzemopfbskqjndukahlnhckuazivgnubprvmnhnstsvkuuyqcuvgyjictywjjbfrevrsjxkitgfwsmsamaantybyughtrkvgtmvtwwisiuyragfkfutmiumyepjmlgiitzlmccpobkwtznytpgnjcfkswdbtdwmvhdlqzfusbgheialgjvewsizcytgmptzhcegteiyscqfsnrwhrdnnhvmvfylovolegpjgtjvungjwmubxtnykhdqxfqpratnhauuubofeimcdwpgqhghqkwpysqyjyabkzuocxrzevlxmzmagludzmwjuxkbafowisiwhenipmjnhq";
        String s2 = "vnkosvqcsmmxzxfiiidzoozbcdbvbnlbmthrplmzsfquyasdcvxrsyimzhuyqxlonvilykehawlevnoiqwkgxmipqnpqihnevqzfiwliyaiyrkzwihnllydmsvnswmtytzhpywdqfyyontcespmdzfvgjyjziqpnqgbqjjfikivvxmcgbxbztweltqwqbaofxztzjfbmvdjbkspgqczmfhpznmiabyfiondzpigbmaqamdfwcyvuqxhvvqyzfxmnfcorviqihjieulxqhgvdixhubhigibbxnlytjzpesebiygjiavpnnlxyxmdxwlnmmnghpfetwkoympfqvydrajbvecfnyegfnzrfcpgvhtwrcyllivpzsreszxlorksbbtfxslorrtehdchqvpbgwjjgaonufbmaplnuvmqrbgkewoeqwqcmlbnpfgvujztzhgdsytcqfrnebwkxogocljslaoyjfxhkgbwtkbzqcuaylzbdwyhs";
        String evil = "siaazeypwyelcthrureemetwxkge";
        long start = System.currentTimeMillis();
        System.out.println(Solution.findGoodStrings(n, s1, s2, evil));
        long end = System.currentTimeMillis();
        System.out.println("Solution sovled " + (end - start) + " ms");
        start = System.currentTimeMillis();
        System.out.println(new Solution2().findGoodStrings(n, s1, s2, evil));
        end = System.currentTimeMillis();
        System.out.println("Solution2 sovled " + (end - start) + " ms");
        start = System.currentTimeMillis();
        System.out.println(new Solution3().findGoodStrings(n, s1, s2, evil));
        end = System.currentTimeMillis();
        System.out.println("Solution3 sovled " + (end - start) + " ms");
    }

    @Test
    public void test4() {
        int n = 411;
        String s1 = "iahmnredehjtqrgspfhufwslpihpygazallpoanlrivcijbehekyfvvyinlsfqcmuhfnxubpksaknlhmciqdsuojbrcpanefsefwkvmafzdgaewoorjxmyxbaezmcdguyhzsiwgzjsgutcnwvqxakfebkbqzxwjjraglhaxhlzwzujscatqfgjjyfoxquongytgjbutelctdympdxszhodqkbvehfxeoxctlsczpjlizvpubotdutdiqfyltjwajetzpsgbcaifcbmzcpkziqxlevfvrxxmznosjvapvuwsjghvweexlltlzfpywubadtcacscvfdbvuieivylcefjtlsmluucqldrwccdnyydcxskeajnoaluhkrqmybpwrltdfyfkifjckcnsxhnbrjkloiqz",
                s2 = "yveimokyspovttaqsuxvesucdpgwdpdbxcipftkhmgbrscfmzigcwzqjvldhdturdzirprfyzgthfpewltigeekwmoulbuunnubvbjilksebmpwinruotdpuurgfppcmkuxfltrrywlvqjpjqgnraduqehrijyadnmtmssifwfzsxxpkquzopgysdbipbnzkppwbxrhgsrucrmfgnwxgihrjueszkjuswqflbptyzqhvrvoacyknpezevghpruomrxbrolcqqarpevhwlerzibhnbrutcehlbzuxnnrnbaziplfhxrvadcljhlpagfuwwppevcpxvtuctdsugzoxxmjnpjqjshmhxgfxdzuslqeaipnkcgnyicokxrdmnnretegoacbqmikvtkppgsdswtjdlsc",
                evil = "ha";
        System.out.println(Solution.findGoodStrings(n, s1, s2, evil));
        System.out.println(new Solution2().findGoodStrings(n, s1, s2, evil));
        System.out.println(new Solution3().findGoodStrings(n, s1, s2, evil));
    }

    @Test
    public void test8() {
        int n = 3;
        String s1 = "aaa",
                s2 = "aaz",
                evil = "aa";
        System.out.println(Solution.findGoodStrings(n, s1, s2, evil));
        System.out.println(new Solution2().findGoodStrings(n, s1, s2, evil));
        System.out.println(new Solution3().findGoodStrings(n, s1, s2, evil));
    }

    @Test
    public void test1() {
        System.out.println(Solution.neighbor("zz", 5, true));
    }

    @Test
    public void test2() {
        while (true) {
            Random r = new Random();
            int n = r.nextInt(500) + 1;
            int m = r.nextInt(50) + 1;
            StringBuilder s1 = new StringBuilder();
            StringBuilder s2 = new StringBuilder();
            StringBuilder evil = new StringBuilder();
            try {
                for (int i = 1; i <= n; i++) {
                    s1.append((char) (r.nextInt(26) + 97));
                    s2.append((char) (r.nextInt(26) + 97));
                }
                for (int i = 1; i <= m; i++) {
                    evil.append((char) (r.nextInt(26) + 97));
                }
                if (s1.toString().compareTo(s2.toString()) <= 0) {
                    int x1 = Solution.findGoodStrings(n, s1.toString(), s2.toString(), evil.toString());
                    int x2 = new Solution2().findGoodStrings(n, s1.toString(), s2.toString(), evil.toString());
                    if (x1 != x2) {
                        System.out.println(n + " " + s1 + " " + s2 + " " + evil);
                        System.out.println(x1 + " " + x2);
                        System.out.println();
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("xxxx");
            }
        }
    }
}
