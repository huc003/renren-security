package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户积分
 * 
 * @author ºú³É
 * @email hucheng003@gmail.com
 * @date 2018-09-28 09:15:13
 */
@TableName("sys_client_point")
public class SysClientPointEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户标识
	 */
	@TableId
	private Integer userId;
	/**
	 * 拥有积分
	 */
	private Integer point;
	/**
	 * 使用积分
	 */
	private Integer pointUsed;
	/**
	 * 过期积分
	 */
	private Integer pointExpired;
	/**
	 * 冻结积分
	 */
	private Integer pointFrozen;
	/**
	 * 修改时间
	 */
	private Date updateTime;

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
	 * 设置：拥有积分
	 */
	public void setPoint(Integer point) {
		this.point = point;
	}
	/**
	 * 获取：拥有积分
	 */
	public Integer getPoint() {
		return point;
	}
	/**
	 * 设置：使用积分
	 */
	public void setPointUsed(Integer pointUsed) {
		this.pointUsed = pointUsed;
	}
	/**
	 * 获取：使用积分
	 */
	public Integer getPointUsed() {
		return pointUsed;
	}
	/**
	 * 设置：过期积分
	 */
	public void setPointExpired(Integer pointExpired) {
		this.pointExpired = pointExpired;
	}
	/**
	 * 获取：过期积分
	 */
	public Integer getPointExpired() {
		return pointExpired;
	}
	/**
	 * 设置：冻结积分
	 */
	public void setPointFrozen(Integer pointFrozen) {
		this.pointFrozen = pointFrozen;
	}
	/**
	 * 获取：冻结积分
	 */
	public Integer getPointFrozen() {
		return pointFrozen;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
}
