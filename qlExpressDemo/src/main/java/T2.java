import com.ql.util.express.ExportItem;

import java.util.HashMap;
import java.util.Map;

public class T2 {


    public static void main(String[] args) {
        ExportItem[] arrExportItem =    new ExportItem[0];

        System.out.println(arrExportItem.length);


        Map<String ,People> mapPeole = new HashMap<String, People>();

        mapPeole.put("zhangsan",new People("zhangsan",1));
        mapPeole.put("lisi",new People("lisi",2));
        mapPeole.put("wangwu",new People("wangwu",3));

        People[] arrInitPeople = new People[100];

       People[] arrPeople  =  (People[])mapPeole.values().toArray(arrInitPeople);

        System.out.println(arrPeople.length);



    }
}
