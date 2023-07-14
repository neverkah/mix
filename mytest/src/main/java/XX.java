import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XX {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("xxx");
        list.add("bbb");
        Iterator<String> si = list.iterator();
        xxx(si.next());

        while (si.hasNext()) {
            System.out.println(si.next());
        }

        for (String s : list) {
            System.out.println(s);
        }

    }

    public static void xxx(String s) {
        s = new String("xx");

        System.out.println(s);

    }
}
