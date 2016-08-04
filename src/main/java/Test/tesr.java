package Test;

import classHolders.ObjectHolder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by noname on 04.08.16.
 */
public class tesr {
    public static void main(String[] args) {
        Map<String, Object> map = ObjectHolder.getSingletoneMap();
        for (Map.Entry<String, Object> entry : map.entrySet())
        {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
    }
}
