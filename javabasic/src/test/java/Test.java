import com.noodles.utils.Base64Util;

import java.io.UnsupportedEncodingException;
import java.util.Collections;

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
    }
}
