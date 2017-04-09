package exp.privatebank.util;

import java.util.ArrayList;
import java.util.List;

public class Util {

//    PrivateBank API return wrong ukrainian names. This method
//    will make string correct
    public static String convertToPBStyle(String word){
        List<Character> list = new ArrayList<>();
        for (Character c: word.toCharArray()){
            list.add(c);
        }
        StringBuilder result = new StringBuilder();
        for(Character item: list){
            if(item.equals('і')){
                item = 'i';
            }
            result.append(item);
        }

        return result.toString();
    }

    public static String makeCapitalLetter(String cityName){
        List<Character> list = new ArrayList<>();
        for (Character c: cityName.toCharArray()){
            list.add(c);
        }
        list.set(0,Character.toUpperCase(list.get(0)));
        StringBuilder result = new StringBuilder();
        for(Character item: list){
            result.append(item);
        }

        return result.toString();
    }
}
