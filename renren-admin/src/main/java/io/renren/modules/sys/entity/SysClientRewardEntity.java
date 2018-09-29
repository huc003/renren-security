package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 红包信息表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-09-27 11:27:13
 */
@TableName("sys_client_reward")
public class SysClientRewardEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 用户id
	 */
	private Integer userId;
	/**
	 * 金额
	 */
	private BigDecimal money;
	/**
	 * 获取方式1 注册红包、2 实名认证、  3 手机认证
	 */
	private Integer type;
	/**
	 * 状态【0:未使用（默认）;1:已使用;2:冻结;】
	 */
	private Integer isUse;
	/**
	 * 红包过期时间【0:不过期;时间戳就表示红包到期的时间;】
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date timeout;
	/**
	 * 获取红包时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date addtime;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 被推荐人id
	 */
	private Integer recommendedId;
	/**
	 * 红包使用时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date usetime;
	/**
	 * 红包编号
	 */
	private String rewardNo;
	/**
	 * 红包类型【1:活动红包;2:推荐红包;】
	 */
	private Integer rewardStyle;
	/**
	 * 红包名称
	 */
	private String rewardName;
	/**
	 * 是否可叠加使用【1:是;2:否;】
	 */
	private Integer useTogether;
	/**
	 * 微信账号
	 */
	private String weixinId;
	/**
	 * 满多少可使用
	 */
	private BigDecimal moneyLimit;
	/**
	 * 标记【0:到期不提醒;1:到期提醒;2：已提醒;】
	 */
	private Integer sign;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：金额
	 */
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	/**
	 * 获取：金额
	 */
	public BigDecimal getMoney() {
		return money;
	}
	/**
	 * 设置：获取方式1 注册红包、2 实名认证、  3 手机认证
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：获取方式1 注册红包、2 实名认证、  3 手机认证
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：状态【0:未使用（默认）;1:已使用;2:冻结;】
	 */
	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}
	/**
	 * 获取：状态【0:未使用（默认）;1:已使用;2:冻结;】
	 */
	public Integer getIsUse() {
		return isUse;
	}
	/**
	 * 设置：红包过期时间【0:不过期;时间戳就表示红包到期的时间;】
	 */
	public void setTimeout(Date timeout) {
		this.timeout = timeout;
	}
	/**
	 * 获取：红包过期时间【0:不过期;时间戳就表示红包到期的时间;】
	 */
	public Date getTimeout() {
		return timeout;
	}
	/**
	 * 设置：获取红包时间
	 */
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	/**
	 * 获取：获取红包时间
	 */
	public Date getAddtime() {
		return addtime;
	}
	/**
	 * 设置：用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：用户名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：被推荐人id
	 */
	public void setRecommendedId(Integer recommendedId) {
		this.recommendedId = recommendedId;
	}
	/**
	 * 获取：被推荐人id
	 */
	public Integer getRecommendedId() {
		return recommendedId;
	}
	/**
	 * 设置：红包使用时间
	 */
	public void setUsetime(Date usetime) {
		this.usetime = usetime;
	}
	/**
	 * 获取：红包使用时间
	 */
	public Date getUsetime() {
		return usetime;
	}
	/**
	 * 设置：红包编号
	 */
	public void setRewardNo(String rewardNo) {
		this.rewardNo = rewardNo;
	}
	/**
	 * 获取：红包编号
	 */
	public String getRewardNo() {
		return rewardNo;
	}
	/**
	 * 设置：红包类型【1:活动红包;2:推荐红包;】
	 */
	public void setRewardStyle(Integer rewardStyle) {
		this.rewardStyle = rewardStyle;
	}
	/**
	 * 获取：红包类型【1:活动红包;2:推荐红包;】
	 */
	public Integer getRewardStyle() {
		return rewardStyle;
	}
	/**
	 * 设置：红包名称
	 */
	public void setRewardName(String rewardName) {
		this.rewardName = rewardName;
	}
	/**
	 * 获取：红包名称
	 */
	public String getRewardName() {
		return rewardName;
	}
	/**
	 * 设置：是否可叠加使用【1:是;2:否;】
	 */
	public void setUseTogether(Integer useTogether) {
		this.useTogether = useTogether;
	}
	/**
	 * 获取：是否可叠加使用【1:是;2:否;】
	 */
	public Integer getUseTogether() {
		return useTogether;
	}
	/**
	 * 设置：微信账号
	 */
	public void setWeixinId(String weixinId) {
		this.weixinId = weixinId;
	}
	/**
	 * 获取：微信账号
	 */
	public String getWeixinId() {
		return weixinId;
	}
	/**
	 * 设置：满多少可使用
	 */
	public void setMoneyLimit(BigDecimal moneyLimit) {
		this.moneyLimit = moneyLimit;
	}
	/**
	 * 获取：满多少可使用
	 */
	public BigDecimal getMoneyLimit() {
		return moneyLimit;
	}
	/**
	 * 设置：标记【0:到期不提醒;1:到期提醒;2：已提醒;】
	 */
	public void setSign(Integer sign) {
		this.sign = sign;
	}
	/**
	 * 获取：标记【0:到期不提醒;1:到期提醒;2：已提醒;】
	 */
	public Integer getSign() {
		return sign;
	}
}
