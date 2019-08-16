package com.xmm.biz.constant;

/**
 * API返回枚举类<br/>
 * 1~29系统级别错误 	例如:SYS_**<br/>
 * 30~99其他错误	例如：OTHER_**<br/>
 * 100~199订单错误	例如：ORDER_**<br/>
 * 200~299积分错误	例如：INTE_**<br/>
 * 300~399支付错误	例如：PAY_**<br/>
 * 400~499第三方错误	例如：THRID_**<br/>
 * 500~599文件上传错误	例如：UPLOAD_**
 *
 */
public enum ResultValueEnum implements BaseEnum<Integer>{
	//1~29系统错误////////////////////////////////////////////////////////
	/**1:系统成功*/
	SYS_OK(1,"OK"),
	/**2:系统错误*/
	SYS_ERROR(2,"系统错误"),
	/**3:参数错误*/
	SYS_PARAMETER_ERROR(3,"参数错误"),
	/**4:解析POJO错误*/
	SYS_PARSE_POJO_ERROR(4,"解析POJO错误"),
	/**5:当前访问客户不存在*/
	SYS_NOT_EXIST_CLIENT(5,"当前访问渠道不存在"),
	/**6:签名错误**/
	SYS_SIGN_ERROR(6,"参数签名错误"),
	/**7:应用程序错误*/
	SYS_APPLICATION_ERROR(7,"应用程序错误"),
	/**8:无访问权限**/
	SYS_NO_ACCESS_PERMISSIONS(8,"无访问权限"),
	/**9:站点不存在，未在系统中登记*/
	SYS_WEBSIZE_NOT_EXIST(9,"站点不存在，未在系统中登记"),
	/**10:生成失败二维码*/
	SYS_QR_FAIR(10,"生成失败二维码"),
	/**11:短信发送数量限制已满*/
	SYS_SMS_SEND_LIMIT_ERROR(11,"短信发送数量限制已满"),
	/**12:渠道类型不合法*/
	SYS_CHANNEL_NOT_LEGAL(12,"渠道类型不合法"),
	/**13:用户未登录*/
	SYS_USER_NO_LOGIN(13,"用户未登录"),
	/**14:发送短信失败*/
	SYS_MESSAGE_FAIL(14,"发送短信失败"),
	/**15:操作超时*/
	SYS_TIME_OUT(15,"操作超时"),
	/**16:重复提交*/
	SYS_SUB_REPEAT(16,"重复提交"),
	/**17:上次操作系统进行中，请稍后...*/
	SYS_EXECUTING(17,"上次操作系统进行中，请稍后..."),
	/**18:参数为空*/
	SYS_PARAMETER_ISNULL(18,"参数为空"),
	/**19:此操作已经过期*/
	SYS_EXE_OVERDUE(19,"此操作已经过期"),
	/**20:调用第三方返回结果失败*/
	SYS_EXE_THIRD_FAIL(20,"调用第三方返回结果失败"),
	/**21:版本号为空*/
	SYS_VERSION_ISNULL(21,"版本号为空"),
	/**22:无升级版本*/
	SYS_NOT_HAVE_NEW_VERSION(22,"无升级版本"),
	/**23:无数据*/
	SYS_NOTE_HAD_DATA(23,"无数据"),
	/**24:未检查到TOKEN*/
	SYS_TOKEN_NULL(24,"未检查到token"),
	/**25:TOKEN验证失败*/
	SYS_TOKEN_ANOMALY(25,"token解析异常"),
	/**26:接口已停止使用*/
	SYS_API_IS_STOP(26,"接口已停止使用"),
	/**27:用户无操作权限*/
	SYS_USER_NOT_HAVE_POWER(27,"用户无操作权限"),

	//30~99其他错误////////////////////////////////////////////////////////
	/**30:账号不存在,不能找回密码*/
	OTHER_USER_NOT_EXIST(30,"账号不存在"),
	/**31:账户已经存在*/
	OTHER_USER_PHONE_ERROR(31,"账户已经存在"),
	/**32:操作未成功*/
	OTHER_COMMON_MODIFY_ERROR(32,"操作未成功"),
	/**33:必填项不合法*/
	OTHER_COMMON_WRONGFUL_ERROR(33,"必填项不合法"),
	/**44:未能找到合适的数据*/
	OTHER_SAERCH_RESULT_ISEMTPY(44,"未能找到合适的数据"),
	/**55:账号或密码错误*/
	OTHER_LOGIN_VALIDATE_FAIL(55,"账号或密码错误"),
	/**56:密码不匹配*/
	OTHER_PASSWORD_NOT_MATCH(56,"密码不匹配"),
	/**57:验证码错误*/
	OTHER_RANDCODE_ERROR(57,"验证码错误"),
	/**58:原密码错误*/
	OTHER_OLD_PASSWORD_ERROR(58,"原密码错误"),
	/**63:用户注册失败*/
	OTHER_USER_REGISTER_FAIL(63,"用户注册失败"),
	/**64:验证码不能为空*/
	OTHER_USER_RANDOM_EMPTY(64,"验证码不能为空"),
	/**65:验证码不匹配*/
	OTHER_USER_RANDOM_MATCH(65,"验证码不匹配"),
	/**66:手机验证码不匹配*/
	OTHER_PHONE_KEY_MATCH(66,"手机验证码不匹配"),
	/**67:用户设置密码*/
	OTHER_PHONE_SETTING_PWD(67,"用户设置密码"),
	/**68:用户已被锁定*/
	OTHER_USER_LOCK(68,"用户已被锁定"),
	/**69:用户自动登录失败**/
	OTHER_USER_LOGIN_AUTO_FAIL(69,"用户自动登录失败"),
	/**70:用户未绑定银行卡**/
	OTHER_USER_NOT_BINDING(70,"用户未绑定银行卡"),
	/**71:暂不支持绑定该银行**/
	OTHER_BANK_NOT_OPEN(71,"暂不支持绑定该银行"),
	/**72:用户已绑定银行卡**/
	OTHER_USER_IS_BINDING(72,"用户已绑定银行卡"),
	/**73:不能小于最小购买量**/
	OTHER_GOODS_LESS_MINBUY(73,"不能小于最小购买量"),
	/**74:商品已下架**/
	OTHER_GOODS_STATE_ERROR(74,"商品已下架"),
	/**75:商品剩余量不足**/
	OTHER_GOODS_SURPLUS_ERROR(75,"商品剩余量不足"),
	/**76:用户绑定银行卡审核中**/
	OTHER_USER_BANK_EXAMINE(76,"用户绑定银行卡审核中"),
	/**77:库存订单不存在**/
	OTHER_ORDER_IS_NULL(77,"库存订单不存在"),
	/**78:提现金额不能超过总收益**/
	OTHER_WITHDRAW_GREATER_THAN_PROFIT(78,"提现金额不能超过总收益"),
	/**79:用户该银行卡已停止使用**/
	OTHER_USER_BANK_STOP_USE(79,"用户该银行卡已停止使用"),
	/**80:用户该银行卡审核失败**/
	OTHER_USER_BANK_EXAMINE_FAIL(80,"用户该银行卡审核失败"),
	/**81:商品未到销售日期或已过期**/
	OTHER_GOODS_SALESTIME_ERROR(81,"商品未到销售日期或已过期"),
	/**82:账号未设置完毕，请联系管理员*/
	OTHER_USER_NOT_POWER(82,"账号未设置完毕，请联系管理员"),
	/**83:组织下存在人员,不可删除该组织*/
	OTHER_GROUP_HAVE_PERSON(83,"组织下存在人员,不可删除该组织"),

	//500~599文件系统错误///////////////////////////////////////////////////////
	/**500:上传文件格式错误*/
	UPLOAD_FORMAT_ERROR(500,"上传文件格式错误"),
	/**501:上传文件大小超过限制*/
	UPLOAD_SIZE_ERROR(501,"上传文件大小超过限制"),
	/**502:上传文件为空*/
	UPLOAD_NULL_ERROR(502,"上传文件为空"),
	/**503:上传文件错误*/
	UPLOAD_ERROR(503,"上传文件错误"),
	/**504:允许上传文件类型或参数设置错误*/
	UPLOAD_ALLOW_TYPE_ERROR(504,"允许上传文件类型或参数设置错误"),
	/**504:删除文件失败错误*/
	UPLOAD_DELETE_ERROR(505,"删除文件失败错误"),

	//600~699短信系统错误///////////////////////////////////////////////////////
	MSG_MSGTEMPLET_EMPTY(600,"获取短信模板为空"),
	MSG_MSGTEMPLET_NO_EXIST(601,"短信模板不存在"),
	MSG_MESSAGE_FAIL(602,"消息发送失败"),
	MSG_RANDCODE_ERROR(603,"短信验证码错误"),
	MSG_TYPE_ERROR(604,"短信类型未定义"),

	//700~799接口入参错误///////////////////////////////////////////////////////
	INPUT_PAGE_LESS_ONE(700,"页码或每页显示条数必须大于0"),
	INPUT_REALNAME_NOT_CN(701,"姓名必须为中文"),
	INPUT_IDCARDNO_ERROR(702,"身份证号不合法"),
	INPUT_ACCOUNTNUM_ERROR(703,"银行卡号不合法"),
	INPUT_BANKID_ERROR(704,"请选择银行卡所属的银行"),
	INPUT_PHONE_ERROR(705,"手机号码不合法"),
	INPUT_RANDOMCODE_ERROR(706,"短信验证码不合法"),
	INPUT_GOODSID_ERROR(707,"请选择商品"),
	INPUT_QUANTITY_ERROR(708,"请选择购买数量"),
	INPUT_GOODSTYPE_ERROR(709,"商品类型不合法"),
	INPUT_SALESTIMETYPE_ERROR(710,"销售日期类型不合法"),
	INPUT_PASSWORD_ERROR(711,"密码不合法"),
	INPUT_PASSWORD_NOT_EQUALS(712,"两次输入的密码不一致"),
	INPUT_BANKINFOID_ERROR(713,"请选择银行卡"),
	INPUT_WITHDRAW_AMOUNT_ERROR(714,"提现金额错误"),
	INPUT_AD_INFO_ERROR(715,"广告模板类型错误"),
	INPUT_PAYCODE_ERROR(716,"请选择支付方式"),
	INPUT_VERSION_ERROR(717,"版本号错误"),
	INPUT_APPTYPE_ERROR(718,"系统类型错误"),
	INPUT_USERNAME_ERROR(719,"用户名不合法"),
	INPUT_GROUP_NAME_ERROR(720,"组织名不能为空"),
	INPUT_GROUP_PARENTID_ERROR(721,"上级组织不能为空"),
	INPUT_ID_ERROR(722,"ID不能为空"),
	INPUT_SORT_ERROR(723,"序号不能为空");

	private int key;

	private String msg;

	ResultValueEnum(int key, String msg){
		this.key=key;
		this.msg=msg;
	}
	public Integer getKey() {
		return this.key;
	}

	public String getTitle() {
		return this.msg;
	}

	/**
	 * 根据错误编号查询具体错误类型
	 * @param key 错误编号
	 * @return {@link ResultValueEnum}
	 */
	public static ResultValueEnum queryByKey(int key){
		ResultValueEnum result=query(key);
		if(null==result){
			result=ResultValueEnum.SYS_ERROR;
		}
		return result;
	}

	private static ResultValueEnum query(int key){
		if(key > 0){
			ResultValueEnum[] values = ResultValueEnum.values();
			for(ResultValueEnum result : values){
				if(result.getKey() == key){
					return result;
				}
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "[key="+this.key+",title="+this.name()+"]";
	}
}
