package com.fundacionjala.katabank;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 7/7/2016.
 */
public class OCR {

    String regexOne = "(     \\|  \\|)";
    String regexTwo = "( \\_  \\_\\|\\|\\_ )";
    String regexThree="( \\_  \\_\\| \\_\\|)";
    String regexFour="(   \\|\\_\\|  \\|)";
    String regexFive="( \\_ \\|\\_  \\_\\|)";
    String regexSix="( \\_ \\|\\_ \\|\\_\\|)";
    String regexSeven="( \\_   \\|  \\|)";
    String regexEight = "( \\_ \\|\\_\\|\\|\\_\\|)";
    String regexNine="( \\_ \\|\\_\\| \\_\\|)";
    Map<String,Integer> listRegex= new HashMap<String,Integer>();

    public OCR(){
        listRegex.put(regexOne,1);
        listRegex.put(regexTwo,2);
        listRegex.put(regexThree,3);
        listRegex.put(regexFour,4);
        listRegex.put(regexFive,5);
        listRegex.put(regexSix,6);
        listRegex.put(regexSeven,7);
        listRegex.put(regexEight,8);
        listRegex.put(regexNine,9);
    }

    public int parseStringToNumber(String number) {
        Integer value = 0;
        for (String pattern: listRegex.keySet()) {
            if (Pattern.compile(pattern).matcher(number).find()){
                return listRegex.get(pattern);
            }
        }

        return value;
    }
}
