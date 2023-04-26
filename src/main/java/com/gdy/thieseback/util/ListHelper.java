package com.gdy.thieseback.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListHelper {

    public static <T> T FirstOrDefault(List<T> list){
        return list.stream().findFirst().orElse(null);
    }

    public static <T> Map<String, List<T>> GroupBy(List<T> list, String fieldName){
        Map<String,List<T>> map = new HashMap<>();
        for(T t : list){
            if(map.containsKey(fieldName)){
                map.get(fieldName).add(t);
            }else{
                List<T> newList = new ArrayList<>();
                newList.add(t);
                map.put(fieldName, newList);
            }
        }
        return map;
    }
}
