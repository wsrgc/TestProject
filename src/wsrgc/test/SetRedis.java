package wsrgc.test;

import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SetRedis {

    private static Logger logger = Logger.getLogger(SetRedis.class);

    public static void main(String[] args) {

//        jedis.sadd("ECULISTDELAY", "203000017280");
//        jedis.sadd("203000017280", "20190101");
//        jedis.sadd("203000017280", "20200101");
//        jedis.sadd("203000017280", "20200201");

//        jedis.sadd("ECULISTDELAY", "204000018103");
//        jedis.sadd("204000018103", "20190101");
//        jedis.sadd("204000018103", "20200101");
//        jedis.sadd("204000018103", "20200201");

//        jedis.sadd("ECULISTDELAY", "216000017808");
//        jedis.sadd("216000017808", "20190101");
//        jedis.sadd("216000017808", "20200101");
//        jedis.sadd("216000017808", "20200201");

//        jedis.sadd("ECULISTDELAY", "216000004388");
//        jedis.sadd("216000004388", "20190101");
//        jedis.sadd("216000004388", "20200101");
//        jedis.sadd("216000004388", "20200201");

//        jedis.sadd("ECULISTDELAY", "216000012954");
//        jedis.sadd("216000012954", "20190101");
//        jedis.sadd("216000012954", "20200101");
//        jedis.sadd("216000012954", "20200201");

//        Jedis jedis = new Jedis("139.168.200.170", 6379);
//
//        String fileName = "C:\\Users\\ycx\\Desktop\\bufa2.txt";
//        File file = new File(fileName);
//        BufferedReader reader = null;
//        int count = 0;
//        try {
//            reader = new BufferedReader(new FileReader(file));
//            String tempStr;
//            while ((tempStr = reader.readLine()) != null) {
//                jedis.sadd("ECULISTDELAY", tempStr.split(":")[1]);
//                jedis.sadd(tempStr.split(":")[1], tempStr.split(":")[0]);
//                logger.info(++count);
//                logger.info(tempStr);
//                logger.info(tempStr.split(":")[1]);
//                logger.info(tempStr.split(":")[0]);
//                if (count == 5000) {
//                    break;
//                }
//            }
//        } catch (IOException e) {
//            logger.error(count);
//            logger.error(e.getMessage());
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e1) {
//                    logger.info(e1.getMessage());
//                }
//            }
//        }

    }
}
