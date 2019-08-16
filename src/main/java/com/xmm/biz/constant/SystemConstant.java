package com.xmm.biz.constant;



/**
 * 系统常量类
 */
public class SystemConstant {

	/**
	 * 分页,默认页码
	 */
	public static final int PAGE_NUM = 1;

	/**
	 * 分页,默认每页显示条数
	 */
	public static final int PAGE_SIZE = 10;

	/**
	 * token用途
	 */
	public static final String TOKEN_PURPOSE = "TOKEN_PURPOSE";

	/**
	 * token用途-登录标识
	 */
	public static final String IS_LOGIN = "IS_LOGIN";

	/**
	 * token用途-修改密码标识
	 */
	public static final String CHANGE_PASSWORD = "CHANGE_PASSWORD";

	/**
	 * API客户类型枚举类
	 */
	public enum ApiTypeEnum implements BaseEnum<Integer> {
		ANDROID(10,"Android系统"),
		IOS(11,"IOS系统");
		private int key;
		private String title;

		ApiTypeEnum(int key, String title) {
			this.key = key;
			this.title = title;
		}

		public Integer getKey() {
			return this.key;
		}

		public String getTitle() {
			return this.title;
		}
		public static ApiTypeEnum valueOf(int key){
			for(ApiTypeEnum type:values()){
				if(type.getKey()==key){
					return type;
				}
			}
			return null;
		}
		@Override
		public String toString() {
			return "["+this.key + ":" + this.title+"]";
		}
	}
}
