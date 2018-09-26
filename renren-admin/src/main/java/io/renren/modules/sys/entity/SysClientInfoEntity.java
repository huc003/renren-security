package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 *
 * @author hucheng
 * @email hucheng003@gmail.com
 * @date 2018-09-25 13:32:18
 */
@Data
@TableName("sys_client_info")
public class SysClientInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	@TableId
	private Integer userId;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String passWord;
	/**
	 * 邀请用户id
	 */
	private Integer inviteUserid;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 身份证
	 */
	private String cardId;
	/**
	 * 姓名
	 */
	private String realName;
	/**
	 * 昵称
	 */
	private String nickName;
	/**
	 * 生日
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date birthday;
	/**
	 * 手机号
	 */
	private String phone;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 性别
	 */
	private Integer sex;
	/**
	 * 添加时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date addTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;

}
