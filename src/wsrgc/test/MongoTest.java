package wsrgc.test;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.bson.Document;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Set;

import static com.mongodb.client.model.Filters.eq;

public class MongoTest {

    private static Logger logger = Logger.getLogger(MongoTest.class);

    public static void main(String[] args) {

        //MongoDB
        MongoClientOptions.Builder build = new MongoClientOptions.Builder();

        //源
        MongoClientURI mcuFrom;
        MongoClient clientFrom;

        //MongoBD源库
        MongoDatabase databaseFrom;

        WriteConcern writeconcern = new WriteConcern(1);
        build.writeConcern(writeconcern);
        build.connectionsPerHost(20);

        String date = "20200326";

        mcuFrom = new MongoClientURI("mongodb://139.168.200.172:27017", build);
        clientFrom = new MongoClient(mcuFrom);
        databaseFrom = clientFrom.getDatabase("EMAE" + date.substring(0, 4));

        MongoCollection<Document> coll = databaseFrom.getCollection("ECU_POWER_" + date.substring(0, 6));

        Jedis jedis = new Jedis("139.168.200.170", 6379);
        Set<String> ecuSet = jedis.smembers(date);

        SqlSession session = null;
        SqlSessionFactory sqlMapper = null;
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            sqlMapper = new SqlSessionFactoryBuilder().build(reader, "mongoData");
        } catch (IOException e) {
            e.printStackTrace();
        }


        int countAll = 0;
        int countError = 0;

        for (String ecuId : ecuSet) {
            Document doc = coll.find(eq("_id", ecuId + date)).first();
            if (doc != null) {
                StringBuilder sb = new StringBuilder();
                countAll++;
                List<String> time = (List<String>) doc.get("T");
                List<String> power = (List<String>) doc.get("P");
                List<String> energy = (List<String>) doc.get("I");
                List<Integer> flag = (List<Integer>) doc.get("F");

                int count = -1;
                boolean hasFlag = false;

                for (int i = 0; i < flag.size(); i++) {

                    if (flag.get(i) == 1) {
                        count++;
                    }

                    if (flag.get(i) > 0 && (Double.parseDouble(power.get(i)) == 0 || Double.parseDouble(energy.get(i)) == 0)) {
                        hasFlag = true;
                        logger.info(ecuId + ":" + i + " / " + time.get(count));
                        sb.append("('");
                        sb.append(ecuId);
                        sb.append("','");
                        sb.append(date);
                        sb.append("','");
                        sb.append(time.get(count));
                        sb.append("',");
                        sb.append(i);
                        sb.append(",'");
                        sb.append(energy.get(i));
                        sb.append("','");
                        sb.append(power.get(i));
                        sb.append("'),");
                    }
                }

                if (hasFlag) {
                    countError++;
                    logger.info(ecuId + " : error +++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    try {
                        session = sqlMapper.openSession();
                        session.insert("insertMongoZeroData", sb.substring(0, sb.length() - 1));
                        session.commit();
                        session.close();
                    } catch (Exception e) {
                        logger.error(e.getMessage());
                        session.close();
                    } finally {
                        if (session != null) {
                            session.close();
                        }
                    }

                } else {
//                    logger.info(ecuId + " : correct");
                }
            }
        }

        logger.info(countError + " / " + countAll);
    }
}
