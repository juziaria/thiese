package com.gdy.thieseback.util;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class AddressHelper {
    private final String regex = "(?<province>[^省]+自治区|.*?省|.*?行政区|.*?市)(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|.*?市|.*?县)(?<county>[^县]+县|.+区|.+市|.+旗|.+海域|.+岛)?(?<town>[^区]+区|.+镇)?(?<village>.*)";

    private String province;    //省
    private String city;        //市
    private String county;      //区
    private String town;        //镇
    private String village;     //村

    private String place;

    public AddressHelper(String address){
        Matcher m = Pattern.compile(this.regex).matcher(address);

        while (m.find()) {
            this.province = m.group("province");
            this.city = m.group("city");
            this.county = m.group("county");
            this.town = m.group("town");
            this.village = m.group("village");

            this.place = String.format("%s%s", this.province, this.city);
        }
    }

}
