package com.noodles.jdbc.oracle;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.noodles.json.utils.JsonUtils;
import org.apache.commons.codec.Charsets;

/**
 * 文件名：JdbcTest.java
 * 描述：
 * 作者：KJ00019
 * 日期：2019年4月3日下午2:19:07
 */
public class JdbcTest {


    Connection conn = null;
    PreparedStatement pst;
    ResultSet rSet;

    public static void main(String args[]) throws Exception {
        test();

    }


    public static void test(){
        JdbcTest jdbcTest = null;
        try {
            String filePath = "d:/11.txt";


            jdbcTest = new JdbcTest();

            /**初始化*/
            jdbcTest.init();

            List<String> fileStrList = Files.readAllLines(Paths.get(filePath), Charsets.UTF_8);

            for (int i = 0; i<fileStrList.size(); i++) {

                if(i%50 == 0){
                    jdbcTest.close();
                    jdbcTest.init();
                }
                String fileStr = fileStrList.get(i);
                String[] fileStrArr = fileStr.split(",");
                String acctNo = fileStrArr[0];
                Date dbDate = jdbcTest.getDbDate(acctNo);


                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
                String dbDateStr = simpleDateFormat.format(dbDate);
                System.out.println(dbDateStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            /**释放资源*/
            jdbcTest.close();
        }

    }

    /**
     * 初始化
     */
    public void init() {
        String driverName = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@10.180.14.31:1215:yrzdb";
        String user = "nlp_ac";
        String password = "U_db_ordin_22XV";
        try {
            /**加载驱动*/
            Class.forName(driverName);

            /**获取连接*/
            conn = DriverManager.getConnection(url, user, password);

            //System.out.println("数据库连接成功....");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public void close() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                conn = null;
            }

            //System.out.println("数据库连接关闭成功....");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Date getDbDate(String acctNo) throws Exception {

        String sqlString = "select db_date from a_loan_mas t where t.apply_code in (select apply_code from a_loan_id_mas where acct_no = '" + acctNo + "')";
        pst = conn.prepareStatement(sqlString);
        rSet = pst.executeQuery();

        /**遍历结果*/
        Date dbDate = null;
        while (rSet.next()) {
			dbDate = rSet.getDate("DB_DATE");
        }

        if(dbDate ==  null){
			System.out.println("获取日期为空：" + acctNo);
		}

        return dbDate;

    }

    public List<ApplyLoanDataInfoBean> getApplyLoanDataInfoByApplyCode(String applyCode) throws Exception {

        String sqlString = "select * from apply_loan_info t where t.apply_code = '" + applyCode + "'";
        pst = conn.prepareStatement(sqlString);
        rSet = pst.executeQuery();

        /**遍历结果*/
        List<ApplyLoanDataInfoBean> applyLoanDataInfoBeanList = new ArrayList<>();
        while (rSet.next()) {
            ApplyLoanDataInfoBean applyLoanDataInfoBean = new ApplyLoanDataInfoBean();
            applyLoanDataInfoBean.setFunderCode(rSet.getString("FUNDER_CODE"));
            applyLoanDataInfoBean.setCustSourceCode(rSet.getString("CUST_SOURCE_CODE"));
            applyLoanDataInfoBean.setApplyLoanProduct(rSet.getString("APPLY_LOAN_PRODUCT"));
            applyLoanDataInfoBean.setApplyLoanAmount(rSet.getInt("APPLY_LOAN_AMOUNT"));
            applyLoanDataInfoBeanList.add(applyLoanDataInfoBean);
        }

        return applyLoanDataInfoBeanList;
    }

}
