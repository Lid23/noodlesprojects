import com.noodles.utils.Base64Util;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.concurrent.atomic.LongAdder;

/**
 * @program: noodlesprojects
 * @description: Test
 * @author: Eric
 * @create: 2019-05-14 09:09
 **/
public class Test {

    public static void main(String[] args) throws UnsupportedEncodingException {
        Integer i = 258;
        Integer j = 258;
        System.out.println(i==j);
        System.out.println(j);

        Double d1 = 0.0;
        System.out.println(d1 == 0);
        System.out.println(d1.compareTo(0.0) == 0);


        LongAdder current = new LongAdder();
        current.add(1000);
        System.out.println(current.longValue());

        current.add(10000);
        System.out.println(current.longValue());

        long d = 1000;
        current.add(-1000);
        System.out.println(current.longValue());


        Boolean b = new Boolean("false");
        if(b){
			System.out.println(b);
		}else {
			System.out.println(false);
		}
    }
}
