package com.gdy.thieseback.req;import io.swagger.annotations.ApiModel;import io.swagger.annotations.ApiModelProperty;import lombok.AllArgsConstructor;import lombok.Data;import lombok.EqualsAndHashCode;import lombok.NoArgsConstructor;import java.util.Date;@EqualsAndHashCode(callSuper = true)@AllArgsConstructor@NoArgsConstructor@Data@ApiModel("双选会、宣讲会")public class EmployMeetingReq extends PageReq {    @ApiModelProperty(value = "时间")    private Date time;    @ApiModelProperty(value = "双选会名称")    private String name;    @ApiModelProperty(value = "主办方")    private String master;    @ApiModelProperty(value = "地址")    private String place;    @ApiModelProperty(value = "展位数量")    private int amount;    @ApiModelProperty(value = "专业")    private String major;    @ApiModelProperty(value = "0-宣讲会1-双选会")    private String type;    @ApiModelProperty(value = "状态")    private Integer flag;    public Integer getFlag() {        return flag;    }    public void setFlag(Integer flag) {        this.flag = flag;    }    public Date getTime() {        return time;    }    public void setTime(Date time) {        this.time = time;    }    public String getName() {        return name;    }    public void setName(String name) {        this.name = name;    }    public String getMaster() {        return master;    }    public void setMaster(String master) {        this.master = master;    }    public String getPlace() {        return place;    }    public void setPlace(String place) {        this.place = place;    }    public int getAmount() {        return amount;    }    public void setAmount(int amount) {        this.amount = amount;    }    public String getMajor() {        return major;    }    public void setMajor(String major) {        this.major = major;    }    public String getType() {        return type;    }    public void setType(String type) {        this.type = type;    }    @Override    public String toString() {        return "reqEmployMeeting{" +                "name='" + name + '\'' +                ", master='" + master + '\'' +                ", place='" + place + '\'' +                ", amount=" + amount +                ", major='" + major + '\'' +                ", type='" + type + '\'' +                ", state=" + flag +                '}';    }}