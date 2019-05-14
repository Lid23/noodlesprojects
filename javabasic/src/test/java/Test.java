import com.noodles.utils.Base64Util;

import java.io.UnsupportedEncodingException;

/**
 * @program: noodlesprojects
 * @description: Test
 * @author: Eric
 * @create: 2019-05-14 09:09
 **/
public class Test {

    public static void main(String[] args) throws UnsupportedEncodingException {
        // 有 rm -rf / 数据恢复经验
        String backDev = "5pyJIHJtIC1yZiAvIOaVsOaNruaBouWkjee7j+mqjA==";

        //处事不惊，临危不惧
        String frontDev = "5aSE5LqL5LiN5oOK77yM5Li05Y2x5LiN5oOn";
        String decodeBase64 = new String(Base64Util.decode(frontDev), "UTF-8");
        System.out.println(decodeBase64);

    }
}
