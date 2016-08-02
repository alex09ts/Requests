package test;

import classHolders.ObjectHolder;
import requestHandlers.GetRequestHandler;
import requestHandlers.HandlerInterface;
import utils.ClassFinder;

import java.util.Map;

/**
 * Created by noname on 02.08.16.
 */
public class Main {
    public static void main(String[] args) {
        ObjectHolder oh = new ObjectHolder();
        oh.getList();
        Map<String, Object> map = oh.getSingletoneMap();
        for (Map.Entry<String, Object> entry : map.entrySet())
        {
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
        HandlerInterface o = (HandlerInterface)map.get("requestHandlers.GetRequestHandler");
        o.method1();
    }
}
