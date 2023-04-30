package com.gdy.thieseback.util;


import com.gdy.thieseback.entity.Parameter;
import lombok.val;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListHelper {

    public static <T> T FirstOrDefault(List<T> list){
        return list.stream().findFirst().orElse(null);
    }

    public static Map<String, Integer> MapSpiltLastGroup(Map<String, Integer> map){
        Map<String, Integer> result = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String mapKey = entry.getKey();
            Integer mapValue = entry.getValue();

            String[] items = mapKey.split(Parameter.splitChar);
            for(val item : items){
                if(result.containsKey(item)){
                    val num = result.get(item);
                    result.put(item, num + mapValue);
                }else{
                    result.put(item, mapValue);
                }
            }
        }
        return result;
    }
}
