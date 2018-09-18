package reversestrinfarray;

import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class ReverseStrinfArray {

    public static void main(String[] args) {

        String[] strDays= new String[]{"Sunday","Monday","Tuesday","Wednesday"};
        List<String>list=Arrays.asList(strDays);
        Collections.reverse(list);
        strDays=(String[])list.toArray();
        System.out.println("String Array reversed");
        
        for(int i=0;i<strDays.length;i++){
            System.out.println(strDays[i]);
        }
        
    }

}
