package wsrgc.test;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherTest {

    private static Logger logger = Logger.getLogger(WeatherTest.class);

    public static void main(String[] args) {
        String parameter = "cityId="+"1233"+"&token="+"073854b56a84f8a4956ba3e273f6c9d7";

        while (true) {
            try {
                URL url = new URL("http://aliv11.data.moji.com/whapi/json/alicityweather/briefforecast6days");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Accept-Charset", "UTF-8");
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
                connection.setRequestProperty("Authorization", "APPCODE " + "a11213431e4f42409859767a53bb8209");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000); //1258
                connection.setRequestProperty("Content-Length", "" + Integer.toString(parameter.getBytes().length));
                connection.setRequestProperty("Accept-Language", "en_US");
                connection.setUseCaches(false);
                connection.setAllowUserInteraction(true);
                connection.setDoInput(true);
                connection.setDoOutput(true);
                DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
                wr.writeBytes(parameter);
                wr.flush();
                wr.close();

                //解析数据
//            int resultCode = connection.getResponseCode();
                InputStream is = connection.getInputStream();
                BufferedReader rd = new BufferedReader(new InputStreamReader(is));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = rd.readLine()) != null) {
                    response.append(line);
                }
                logger.info(response.toString());
            } catch (IOException e) {
                logger.info("Request Error: " + e.getMessage());
                e.printStackTrace();
            }

            try {
                Thread.sleep(60 * 60 * 1000);
            } catch (InterruptedException e) {
                logger.info("Interrupt Error: " + e.getMessage());
                e.printStackTrace();
            }

        }
    }
}
