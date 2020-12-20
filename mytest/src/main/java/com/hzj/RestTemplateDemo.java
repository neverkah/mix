package com.hzj;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RestTemplateDemo {

    final static String uri = "http://localhost:8080/employees";

    final static String youdaoTranslateUri = "http://fanyi.youdao.com/translate_o?smartresult=dict&smartresult=rule";

    final static String googleUri = "https://google-translate1.p.rapidapi.com/language/translate/v2";

    final  static  String nlpUri = "https://nlp-translation.p.rapidapi.com/v1/translate";

    public static void main(String[] args) {
        RestTemplate template = new RestTemplate();
        String uri = "http://localhost:8080/employees";

        //    RestTemplate template = new RestTemplate();

        //  Booking booking = new Booking();// create bookingbject

        URI location = template.postForLocation(uri, null);


        System.out.println("bingo ");
    }

    public static boolean isNumber(String line) {
        String pattern = "[0-9]+";

        return isRegxpMatches(line, pattern);
    }

    public static boolean isTimeRange(String line) {
        String pattern = "[0-9][0-9]:[0-9][0-9]:[0-9][0-9],[0-9][0-9][0-9] --> [0-9][0-9]:[0-9][0-9]:[0-9][0-9],[0-9][0-9][0-9]";
        return isRegxpFind(line, pattern);
    }

    ;

    public static boolean isRegxpFind(String line, String pattern) {
        // 按指定模式在字符串查找

        //    String pattern = "[0-9][0-9]:[0-9][0-9]:[0-9][0-9],[0-9][0-9][0-9] --> [0-9][0-9]:[0-9][0-9]:[0-9][0-9],[0-9][0-9][0-9]";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find()) {
            //   System.out.println("Found value: " + m.group(0) );
            return true;
        }

        return false;

    }


//    HttpRequest request = HttpRequest.newBuilder()
//            .uri(URI.create("https://google-translate1.p.rapidapi.com/language/translate/v2"))
//            .header("content-type", "application/x-www-form-urlencoded")
//            .header("accept-encoding", "application/gzip")
//            .header("x-rapidapi-key", "e6e9b79a52msh6f12809bbba6f76p1b5bafjsn16b4852f6196")
//            .header("x-rapidapi-host", "google-translate1.p.rapidapi.com")
//            .method("POST", HttpRequest.BodyPublishers.ofString("q=Hello%2C%20world!&source=en&target=es"))
//            .build();
//    HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//System.out.println(response.body());

    public static boolean isRegxpMatches(String line, String pattern) {
        // 按指定模式在字符串查找

        //    String pattern = "[0-9][0-9]:[0-9][0-9]:[0-9][0-9],[0-9][0-9][0-9] --> [0-9][0-9]:[0-9][0-9]:[0-9][0-9],[0-9][0-9][0-9]";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.matches()) {
            //   System.out.println("Found value: " + m.group(0) );
            return true;
        }

        return false;

    }

    public static String translate(String URL) throws UnsupportedEncodingException {


        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("MyRequestHeader", "MyValue");
        requestHeaders.set("Content-Type", "application/x-www-form-urlencoded");
        requestHeaders.set("accept-encoding", "application/gzip");
        requestHeaders.set("x-rapidapi-key", "e6e9b79a52msh6f12809bbba6f76p1b5bafjsn16b4852f6196");
        requestHeaders.set("x-rapidapi-host", "google-translate1.p.rapidapi.com");

        //                       Man+k%C3%BCmmert+sich+um+euer+Gep%C3%A4ck

        String encodeURI = URLEncoder.encode(URL, "UTF-8");
        String requestBody = "q=#{src}&source=de&target=zh-CN";
        requestBody = requestBody.replace("#{src}", encodeURI);

        HttpEntity<?> requestEntity = new HttpEntity(requestBody, requestHeaders);

        RestTemplate template = new RestTemplate();
        ResponseEntity<String> response = template.exchange(
                googleUri,
                HttpMethod.POST, requestEntity, String.class);

        String responseHeader = response.getHeaders().getFirst("MyResponseHeader");
        String body = response.getBody();


        //System.out.println(body);
        return body;
    }

    @Test
    public void translateNlpTest() throws UnsupportedEncodingException {
        String s = translateNlp("darin eindringen dürfen");

        System.out.println(s);
    }


    public static String translateNlp(String URL) throws UnsupportedEncodingException {

//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://nlp-translation.p.rapidapi.com/v1/translate"))
//                .header("content-type", "application/x-www-form-urlencoded")
//                .header("x-rapidapi-key", "e6e9b79a52msh6f12809bbba6f76p1b5bafjsn16b4852f6196")
//                .header("x-rapidapi-host", "nlp-translation.p.rapidapi.com")
//                .method("POST", HttpRequest.BodyPublishers.ofString("from=en&text=Hello%20World&to=es"))
//                .build();
//        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println(response.body());




            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.set("MyRequestHeader", "MyValue");
            requestHeaders.set("Content-Type", "application/x-www-form-urlencoded");
            requestHeaders.set("accept-encoding", "application/gzip");
            requestHeaders.set("x-rapidapi-key", "e6e9b79a52msh6f12809bbba6f76p1b5bafjsn16b4852f6196");
            requestHeaders.set("x-rapidapi-host", "nlp-translation.p.rapidapi.com");

            //                       Man+k%C3%BCmmert+sich+um+euer+Gep%C3%A4ck

            String encodeURI = URLEncoder.encode(URL, "UTF-8");
            String requestBody = "from=ru&text=#{src}&to=zh-CN";
            requestBody = requestBody.replace("#{src}", encodeURI);

            HttpEntity<?> requestEntity = new HttpEntity(requestBody, requestHeaders);

            RestTemplate template = new RestTemplate();
            ResponseEntity<String> response = template.exchange(
                    nlpUri,
                    HttpMethod.POST, requestEntity, String.class);

            String responseHeader = response.getHeaders().getFirst("MyResponseHeader");
            String body = response.getBody();


            //System.out.println(body);
            return body;


    }



    public static String translateYandex(String URL) throws UnsupportedEncodingException {

//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://yandextranslatezakutynskyv1.p.rapidapi.com/translate"))
//                .header("content-type", "application/x-www-form-urlencoded")
//                .header("x-rapidapi-key", "e6e9b79a52msh6f12809bbba6f76p1b5bafjsn16b4852f6196")
//                .header("x-rapidapi-host", "YandexTranslatezakutynskyV1.p.rapidapi.com")
//                .method("POST", HttpRequest.BodyPublishers.ofString("apiKey=undefined&lang=undefined&text=undefined"))
//                .build();
//        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println(response.body());




        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("MyRequestHeader", "MyValue");
        requestHeaders.set("Content-Type", "application/x-www-form-urlencoded");
        requestHeaders.set("accept-encoding", "application/gzip");
        requestHeaders.set("x-rapidapi-key", "e6e9b79a52msh6f12809bbba6f76p1b5bafjsn16b4852f6196");
        requestHeaders.set("x-rapidapi-host", "YandexTranslatezakutynskyV1.p.rapidapi.com");

        //                       Man+k%C3%BCmmert+sich+um+euer+Gep%C3%A4ck

        String encodeURI = URLEncoder.encode(URL, "UTF-8");
        String requestBody = "from=de&text=#{src}&to=zh-CN";
        requestBody = requestBody.replace("#{src}", encodeURI);

        HttpEntity<?> requestEntity = new HttpEntity(requestBody, requestHeaders);

        RestTemplate template = new RestTemplate();
        ResponseEntity<String> response = template.exchange(
                nlpUri,
                HttpMethod.POST, requestEntity, String.class);

        String responseHeader = response.getHeaders().getFirst("MyResponseHeader");
        String body = response.getBody();


        //System.out.println(body);
        return body;


    }

    @Test
    public void testxxx() {
        boolean b = isNumber("1");
        Assert.assertTrue(b);
    }

    @Test
    public void isRegxpMatchesTest1() {
        String line = "01:25:57,160 --> 01:26:00,437 x";
        String pattern = "[0-9][0-9]:[0-9][0-9]:[0-9][0-9],[0-9][0-9][0-9] --> [0-9][0-9]:[0-9][0-9]:[0-9][0-9],[0-9][0-9][0-9]";
        boolean b = isRegxpMatches(line, pattern);
        Assert.assertFalse(b);
    }

    @Test
    public void test1() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("MyRequestHeader", "MyValue");
        requestHeaders.set("Content-Type", "application/json");
        requestHeaders.set("Accept", "*/*");
        HttpEntity<?> requestEntity = new HttpEntity(requestHeaders);

        RestTemplate template = new RestTemplate();
        ResponseEntity<String> response = template.exchange(
                uri,
                HttpMethod.POST, requestEntity, String.class);

        String responseHeader = response.getHeaders().getFirst("MyResponseHeader");
        String body = response.getBody();

        System.out.println(body);


    }

    @Test
    public void translatesubtitles() throws Exception {
        File file = new File("D:\\迅雷下载\\Siberia.Monamour.2011.720p.BluRay.x264-WiKi\\Siberia_Monamour_1_2011_Rus\\Siberia. Monamour.srt");


        List<String> lineList = FileUtils.readLines(file, "windows-1251");


        Map<String, String> lineConvertmap = new LinkedHashMap<>();
        String timeRange = null;
        for (int i = 0; i < lineList.size(); i++) {


            String line = lineList.get(i);

            if (StringUtils.isNotBlank(line) && isTimeRange(line)) {
                timeRange = line;


            }


            if (timeRange != null && StringUtils.isNotBlank(line) && !isNumber(line) && !isTimeRange(line)) {
                if (lineConvertmap.containsKey(timeRange)) {
                    if (null != lineConvertmap.get(timeRange)) {
                        lineConvertmap.put(timeRange, lineConvertmap.get(timeRange) + " " + line);
                    }

                } else {
                    lineConvertmap.put(timeRange, line);
                }
            }


        }

        int countNumber = 0;
        for (Map.Entry<String, String> entry : lineConvertmap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(++countNumber);
            System.out.println(key);

            if(StringUtils.isNotBlank(value)){
                String destLine = translateNlp(value);
//                data":{"translations":[{"translatedText
//                 {"status":200,"from":"de","to":"zh-CN","original_text":"1","translated_text":{"zh-CN":"1个"},"translated_characters":1}

                destLine = JSON.parseObject(destLine).getJSONObject("translated_text")
                        .getString("zh-CN");

                System.out.println(value);
                System.out.println(destLine);
                System.out.println();
            }

        }




    }

    @Test
    public void isTimeRangeTest() {
        boolean b = isTimeRange("01:25:57,160 --> 01:26:00,437");
        Assert.assertTrue(b);
    }

    @Test
    public void isTimeRangeTest2() {
        boolean b = isTimeRange("Nein, das glaube ich nicht, Weihnachten");
        Assert.assertFalse(b);
    }

    @Test
    public void testD() {
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "[0-9]";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find()) {
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
            System.out.println("Found value: " + m.group(3));
        } else {
            System.out.println("NO MATCH");
        }

    }

    @Test
    public void testRegxp() {
        String content = "I am noob " +
                "from runoob.com.";

        String pattern = ".*runoob.*";

        boolean isMatch = Pattern.matches(pattern, content);

        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
    }
}
