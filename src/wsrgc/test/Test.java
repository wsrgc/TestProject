package wsrgc.test;

import com.alibaba.fastjson.JSONArray;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.logging.SimpleFormatter;

public class Test
{
    private int i;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public Test(int index) {
        this.i = index;
    }

    public static void main(String[] args) throws InterruptedException {

//        List<Integer> resultList = new ArrayList<>();
//
//        List<Integer> listTemp = new ArrayList<>();
//        listTemp.add(1);
//        listTemp.add(2);
//        listTemp.add(3);
//        listTemp.add(4);
//        listTemp.add(7);
//        listTemp.add(9);
//        listTemp.add(12);
//
//
//        List<Integer> listTemp1 = new ArrayList<>();
//        listTemp1.add(5);
//        listTemp1.add(11);
//        listTemp1.add(13);
//        listTemp1.add(14);
//        listTemp1.add(15);
//
//
//        int index = 0;
//        for(Integer a : listTemp){
//            for(int i=index; i<listTemp1.size();i++){
//                if(listTemp1.get(i) < a){
//                    resultList.add(listTemp1.get(i));
//                    index++;
//                }
//            }
//            resultList.add(a);
//        }
//
//        if(index < listTemp1.size()){
//            resultList.addAll(listTemp1.subList(index, listTemp1.size()));
//        }
//
//        List<String> listTempJ = new ArrayList<>();
//        for (int i = 0; i < 30; i++) {
//            listTempJ.add(Integer.toString(i));
//        }
//
//        String jsonList = JSONArray.toJSONString(listTempJ);
//        System.out.println(jsonList);

//        Map<String, String> oldMap = new HashMap<>();
//        oldMap.put("1", "1");
//        oldMap.put("2", "2");
//        oldMap.put("3", "3");
//
//        Map<String, String> newMap = new HashMap<>(oldMap);
//
//        System.out.println(newMap);
//
//        newMap.clear();
//
//        System.out.println(oldMap);
//        System.out.println(newMap);
//
//        List<String> list1 = new ArrayList<>();
//
//        list1.add("1");
//
//        list1.add("2");
//
//        list1.add("3");
//
//
//        System.out.println(JSONArray.toJSONString(new ArrayList<>(Collections.singletonList(list1.get(1)))));
//
//        for (String s : list1) {
//            System.out.println(s);
//        }


//        Calendar cal = Calendar.getInstance();
//        cal.set(Calendar.YEAR, 2020);
//
//        for (int i = 0; i < 12; i++) {
//            cal.set(Calendar.MONTH, i);
//            System.out.println(cal.getActualMaximum(Calendar.DATE));
//        }

//        String param1 = "0.4312222222";
//        String param2 = "0.5687773777";
//        BigDecimal a1 = new BigDecimal(param1);
//        BigDecimal b1 = new BigDecimal(param2);
//        System.out.println(a1.add(b1).setScale(6, BigDecimal.ROUND_HALF_UP).toString());

//        System.out.println(LocalDate.of(
//                2010,
//                2,
//                1
//        ).lengthOfMonth());

//        int year = 2016;
//        int index = 0;
//        System.out.println(index);
//        for (int i = 1; i <= 12; i++) {
//            index += LocalDate.of(year, i, 1).lengthOfMonth();
//            System.out.println(index);
//        }

//        StringBuilder a = new StringBuilder();
//        a.append("123");
//        try {
//            System.out.println(a.toString());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

//        System.out.println(LocalDate.of(2020,
//                1,
//                1).getDayOfYear());

//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.HOUR_OF_DAY, 12);
//        calendar.set(Calendar.MINUTE, 00);
//        calendar.set(Calendar.SECOND, 00);
//        Date date = calendar.getTime(); // 第一次执行定时任务的时间
//
//        System.out.println(date.before(new Date()));

//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 10; i++) {
//            sb.append(i);
//        }
//        System.out.println(sb.substring(0, sb.length() - 1));

//        List<String> timeStringList = new ArrayList<>();
//        timeStringList.add("04:45:24");
//        timeStringList.add("05:05:24");
//        timeStringList.add("05:15:24");
//        timeStringList.add("05:30:24");
//        timeStringList.add("05:35:24");
//        timeStringList.add("05:40:24");
//        timeStringList.add("05:45:24");
//        timeStringList.add("06:45:24");
//
//        List<Integer> flagList = new ArrayList<>();
//        flagList.add(0);
//        flagList.add(0);
//        flagList.add(1);
//        flagList.add(0);
//        flagList.add(0);
//        flagList.add(0);
//        flagList.add(1);
//        flagList.add(0);
//        flagList.add(1);
//        flagList.add(0);
//        flagList.add(0);
//        flagList.add(1);
//        flagList.add(1);
//        flagList.add(1);
//        flagList.add(1);
//        flagList.add(0);
//        flagList.add(0);
//        flagList.add(0);
//        flagList.add(0);
//        flagList.add(0);
//        flagList.add(0);
//        flagList.add(0);
//        flagList.add(0);
//        flagList.add(0);
//        flagList.add(0);
//        flagList.add(0);
//        flagList.add(1);
//
//        List<Integer> powerList = new ArrayList<>();
//        powerList.add(0);
//        powerList.add(0);
//        powerList.add(11);
//        powerList.add(0);
//        powerList.add(0);
//        powerList.add(0);
//        powerList.add(12);
//        powerList.add(0);
//        powerList.add(112);
//        powerList.add(0);
//        powerList.add(0);
//        powerList.add(132);
//        powerList.add(144);
//        powerList.add(146);
//        powerList.add(156);
//        powerList.add(0);
//        powerList.add(0);
//        powerList.add(0);
//        powerList.add(0);
//        powerList.add(0);
//        powerList.add(0);
//        powerList.add(0);
//        powerList.add(0);
//        powerList.add(0);
//        powerList.add(0);
//        powerList.add(0);
//        powerList.add(123);
//
//        List<Integer> energyList = new ArrayList<>();
//        energyList.add(0);
//        energyList.add(0);
//        energyList.add(2);
//        energyList.add(0);
//        energyList.add(0);
//        energyList.add(0);
//        energyList.add(3);
//        energyList.add(0);
//        energyList.add(4);
//        energyList.add(0);
//        energyList.add(0);
//        energyList.add(5);
//        energyList.add(6);
//        energyList.add(7);
//        energyList.add(8);
//        energyList.add(0);
//        energyList.add(0);
//        energyList.add(0);
//        energyList.add(0);
//        energyList.add(0);
//        energyList.add(0);
//        energyList.add(0);
//        energyList.add(0);
//        energyList.add(0);
//        energyList.add(0);
//        energyList.add(0);
//        energyList.add(9);
//
//        List<Long> longList = new ArrayList<>();
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
//        for(String time : timeStringList){
//            try {
//                longList.add(sdf.parse("20200326 "+time).getTime());
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }
//
//        int interval = getTimeInterval(longList);
//
//        long firstTime = longList.get(0) - (getFirstData(flagList) * interval * 60 * 1000);
//
//        List<Long> newLongList = new ArrayList<>();
//
//        int count = 0;
//        for (int i = 0; i < flagList.size(); i++) {
//            if (flagList.get(i) == 1) {
//                count++;
//                newLongList.add(longList.get(count - 1));
//            } else {
//                int nullCount = getNullCount(flagList, i);
//                if (nullCount <= Math.floor(30 / interval) && nullCount > 0) {
//                    flagList.set(i, 1);
//                    powerList.set(i, powerList.get(i + nullCount));
//                    newLongList.add(firstTime + i * interval * 60 * 1000);
//                }
//            }
//        }
//
//        List<Double> energyListResult = new ArrayList<>();
//        List<Integer> powerListResult = new ArrayList<>();
//
//        for (int i = 0; i < flagList.size(); i++) {
//            if (flagList.get(i) == 1) {
//                powerListResult.add(powerList.get(i));
//                energyListResult.add(Double.parseDouble(Integer.toString(energyList.get(i))));
//            }
//        }
//
//        for (int i = 0; i < energyListResult.size(); i++) {
//            if (energyListResult.get(i) == 0) {
//                int count1 = getNullCountDouble(energyListResult, i);
//                System.out.println(count1);
//                for (int j = 0; j < count1 + 1; j++) {
//                    energyListResult.set(i + j, energyListResult.get(i + count1) / (count1 + 1));
//                }
//                i += count1;
//            }
//        }
//
//        System.out.println(newLongList);
//        System.out.println(powerListResult);
//        System.out.println(energyListResult);

//        String date = "20200402";
//        System.out.println((int)Math.ceil(Double.parseDouble(date.substring(4, 6)) / 3));



    }

    private static int getTimeInterval(List<Long> longList) {
        for (int i = 0; i < longList.size() - 1; i++) {
            if ((longList.get(i + 1) - longList.get(i)) / (60 * 1000) < 20) {
                return ((longList.get(i + 1) - longList.get(i)) / (60 * 1000)) % 4 == 0 ? 4 : 5;
            }
        }
        return 0;
    }

    private static int getNullCount(List<Integer> list, int first) {
        boolean hasData = false;
        int count = 0;
        for (int i = first; i < list.size(); i++) {
            if (list.get(i) == 0) {
                count++;
            } else {
                hasData = true;
                break;
            }
        }
        if (hasData) {
            return count;
        }
        return 0;
    }

    private static int getNullCountDouble(List<Double> list, int first) {
        boolean hasData = false;
        int count = 0;
        for (int i = first; i < list.size(); i++) {
            if (list.get(i) == 0) {
                count++;
            } else {
                hasData = true;
                break;
            }
        }
        if (hasData) {
            return count;
        }
        return 0;
    }

    private static int getFirstData(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 1) {
                return i;
            }
        }
        return 0;
    }
}
