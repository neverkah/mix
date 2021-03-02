import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
/**
 * 通过UrlConnection调用Webservice服务
 *
 */
public class App {

    public static void main(String[] args) throws Exception {
        //服务的地址
        URL wsUrl = new URL("http://10.18.89.164:11111/hello");

        HttpURLConnection conn = (HttpURLConnection) wsUrl.openConnection();

        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");

        OutputStream os = conn.getOutputStream();

        //请求体
        //  String soap = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:web=\"http://WebXml.com.cn/\">"+
        //  "<soap:Header/> <soap:Body><web:getMobileCodeInfo><web:mobileCode>15200791660</web:mobileCode></web:getMobileCodeInfo></soap:Body></soap:Envelope>";


        // String soap = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:sun=\"http://www.primeton.com/SunfiSoapWebService\">   <soapenv:Header/>   <soapenv:Body>      <sun:login>         <!--Optional:-->         <sun:userCode>34</sun:userCode>         <!--Optional:-->         <sun:password>33333</sun:password>      </sun:login>   </soapenv:Body></soapenv:Envelope>";
        //  String soap = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:log=\"http://logic.common.sunline/\">"+
        // "<soapenv:Header/><soapenv:Body><log:sayHello/></soapenv:Body></soapenv:Envelope>";

        String soap = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:exam=\"http://example.org/\">"+
                "<soapenv:Header/><soapenv:Body><exam:sayHi/></soapenv:Body></soapenv:Envelope>";
        os.write(soap.getBytes());

        InputStream is = conn.getInputStream();

        byte[] b = new byte[1024];
        int len = 0;
        String s = "";
        while((len = is.read(b)) != -1){
            String ss = new String(b,0,len,"UTF-8");
            s += ss;
        }
        System.out.println(s);

        is.close();
        os.close();
        conn.disconnect();
    }


    public HashMap<String, String> getInfoOfDataFile(String fileName) throws Exception {

        // String[] str = fileName.split("_");
        HashMap<String, String> para = new HashMap<String, String>();
        try {
            if (fileName.endsWith(".ctl")) {
                para.put("prefix", fileName.substring(0, 2));
                para.put("batchId", fileName.substring(2, 15));
                para.put("serial", "0");
            } else {
                para.put("prefix", fileName.substring(0, 4));
                para.put("batchId", fileName.substring(4, 17));
                para.put("serial", "0");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("filename =" + fileName);
            throw e;
        }

        return para;
    };
}