package com.xmm.biz.vo.result;

import com.xmm.biz.constant.ResultValueEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "返回结果基类")
public class BaseResult<T> implements Serializable {

	private static final long serialVersionUID = -8767713269764707611L;

	@ApiModelProperty("状态码: 1/2/3")
	private int statusCode;

	@ApiModelProperty("提示信息")
	private String message;

	@ApiModelProperty("业务数据")
	private T data;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public static <T> BaseResult<T> newInstance() {
		return new BaseResult<T>(ResultValueEnum.SYS_OK);
	}

	public static <T> BaseResult<T> newInstance(ResultValueEnum resultValueEnum) {
		return new BaseResult<T>(resultValueEnum);
	}

	public void setResultValueEnum(ResultValueEnum resultValueEnum){
		this.statusCode = resultValueEnum.getKey();
		this.message = resultValueEnum.getTitle();
	}

	private BaseResult(ResultValueEnum resultValueEnum) {
		super();
		this.statusCode = resultValueEnum.getKey();
		this.message = resultValueEnum.getTitle();
	}
}
