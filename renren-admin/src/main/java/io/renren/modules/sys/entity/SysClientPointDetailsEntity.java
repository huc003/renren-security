package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户点细节
 * 
 * @author ºú³É
 * @email hucheng003@gmail.com
 * @date 2018-09-28 14:09:43
 */
@TableName("sys_client_point_details")
public class SysClientPointDetailsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增标识
	 */
	@TableId
	private Integer id;
	/**
	 * 积分（可负）
	 */
	private Integer point;
	/**
	 * 用户标识
	 */
	private Integer userId;
	/**
	 * 积分来源
	 */
	private Integer sourceType;
	/**
	 * 添加时间
	 */
	private Date addtime;
	/**
	 * 积分类型（1.增加 2.扣除）
	 */
	private Integer pointType;
	/**
	 * 
	 */
	private String source;
	/**
	 * 
	 */
	private Date expiredTime;
	/**
	 * 剩余积分
	 */
	private Integer overage;
	/**
	 * 已使用积分
	 */
	private Integer pointUsed;

	/**
	 * 设置：自增标识
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：自增标识
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：积分（可负）
	 */
	public void setPoint(Integer point) {
		this.point = point;
	}
	/**
	 * 获取：积分（可负）
	 */
	public Integer getPoint() {
		return point;
	}
	/**
	 * 设置：用户标识
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户标识
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：积分来源
	 */
	public void setSourceType(Integer sourceType) {
		this.sourceType = sourceType;
	}
	/**
	 * 获取：积分来源
	 */
	public Integer getSourceType() {
		return sourceType;
	}
	/**
	 * 设置：添加时间
	 */
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	/**
	 * 获取：添加时间
	 */
	public Date getAddtime() {
		return addtime;
	}
	/**
	 * 设置：积分类型（1.增加 2.扣除）
	 */
	public void setPointType(Integer pointType) {
		this.pointType = pointType;
	}
	/**
	 * 获取：积分类型（1.增加 2.扣除）
	 */
	public Integer getPointType() {
		return pointType;
	}
	/**
	 * 设置：
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * 获取：
	 */
	public String getSource() {
		return source;
	}
	/**
	 * 设置：
	 */
	public void setExpiredTime(Date expiredTime) {
		this.expiredTime = expiredTime;
	}
	/**
	 * 获取：
	 */
	public Date getExpiredTime() {
		return expiredTime;
	}
	/**
	 * 设置：剩余积分
	 */
	public void setOverage(Integer overage) {
		this.overage = overage;
	}
	/**
	 * 获取：剩余积分
	 */
	public Integer getOverage() {
		return overage;
	}
	/**
	 * 设置：已使用积分
	 */
	public void setPointUsed(Integer pointUsed) {
		this.pointUsed = pointUsed;
	}
	/**
	 * 获取：已使用积分
	 */
	public Integer getPointUsed() {
		return pointUsed;
	}
}
