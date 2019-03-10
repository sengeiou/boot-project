package com.xzm.tyb.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * User:frankwoo(吴峻申) <br>
 * Date:2017/8/24 <br>
 * Time:下午4:29 <br>
 * Mail:frank_wjs@hotmail.com <br>
 */
@ApiModel(value = "生成ID所需的参数")
public class MakeID {
  @Max(1023)
  @Min(0)
  @ApiModelProperty(value = "机器ID")
  @JsonProperty("worker")
  private long machine = -1;

  @ApiModelProperty(value = "时间戳", required = true)
  @JsonProperty("timeStamp")
  private long time = -1;

  @Max(4095)
  @Min(0)
  @ApiModelProperty(value = "序列号", required = true)
  @JsonProperty("sequence")
  private long seq = -1;

  public long getMachine() {
    return machine;
  }

  public void setMachine(long machine) {
    this.machine = machine;
  }

  public long getTime() {
    return time;
  }

  public void setTime(long time) {
    this.time = time;
  }

  public long getSeq() {
    return seq;
  }

  public void setSeq(long seq) {
    this.seq = seq;
  }
}
