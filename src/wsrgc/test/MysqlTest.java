package wsrgc.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MysqlTest {

    private static String O ="111111111111";
    private static String E ="111111111112";
    private static String Y ="2020";

    public static void main(String[] args) {

        SqlSession session = null;
        try {
            SqlSessionFactory sqlMapper;
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            sqlMapper = new SqlSessionFactoryBuilder().build(reader, "mongoData");
            session = sqlMapper.openSession();

//            insert(session);
            select(session);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    private static void insert(SqlSession session) {

        Map<String, String> map = new HashMap<>();
        map.put("O", O);
        map.put("E", E);
        map.put("Y", Y);

        List<String> listE1 = new ArrayList<>();
        List<String> listE2 = new ArrayList<>();
        List<String> listOE = new ArrayList<>();

        for (int i = 0; i < 366; i++) {
            listE1.add("0.00002" + i % 10);
            listE2.add("0.00002" + i % 10);
            listOE.add("0.00002" + i % 10);
        }

        map.put("E1", JSONArray.toJSONString(listE1));
        map.put("E2", JSONArray.toJSONString(listE2));
        map.put("OE", JSONArray.toJSONString(listOE));

        session.insert("insertOptData", map);
        session.commit();
    }

    private static void select(SqlSession session) {
//        Map<String, String> queryMap = new HashMap<>();
////        queryMap.put("O", O);
////        queryMap.put("E", E);
////        queryMap.put("Y", Y);
////        Map<String, String> result = session.selectOne("selectOptData", queryMap);
////
////        List<String> listE1 = JSONArray.parseArray(result.get("E1"), String.class);
////        List<String> listE2 = JSONArray.parseArray(result.get("E2"), String.class);
////        List<String> listOE = JSONArray.parseArray(result.get("OE"), String.class);
////
////        for (int i = 0; i < 30; i++) {
////            listE1.set(12 * i, null);
////            listE2.set(12 * i, null);
////            listOE.set(12 * i, null);
////        }
////
////        queryMap.put("E1", JSONArray.toJSONString(listE1));
////        queryMap.put("E2", JSONArray.toJSONString(listE2));
////        queryMap.put("OE", JSONArray.toJSONString(listOE));
////
////        session.insert("updateOptData", queryMap);
////        session.commit();
////
////        Map<String, String> result1 = session.selectOne("selectOptData", queryMap);
////
////        List<String> listE11 = JSONArray.parseArray(result1.get("E1"), String.class);
////        List<String> listE21 = JSONArray.parseArray(result1.get("E2"), String.class);
////        List<String> listOE1 = JSONArray.parseArray(result1.get("OE"), String.class);
////
////        System.out.println(listE11);
////        System.out.println(listE21);
////        System.out.println(listOE1);

        List<Map<String, String>> result = session.selectList("selectTest", "402881be673f2e11016744570d8b00dc");

        for (Map<String, String> stringStringMap : result) {
            System.out.println(stringStringMap);

        }

    }
}
