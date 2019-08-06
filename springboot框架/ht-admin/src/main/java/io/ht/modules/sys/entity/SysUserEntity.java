package io.ht.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;


/**
 * 系统用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:28:55
 */
@TableName("sys_user")
public class SysUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	@TableId
	private Long userId;

	/**
	 * 用户名
	 */

	private String username;

	/**
	 * 密码
	 */

	private String password;



	// 这部分单独建一个业务表，两表一一对应
	// /**
	// * 邮箱
	// */
	// @NotBlank(message="邮箱不能为空",groups = {AddGroup.class, UpdateGroup.class})
	// @Email(message="邮箱格式不正确", groups = {AddGroup.class, UpdateGroup.class})
	// private String email;
	//
	// /**
	// * 手机号
	// */
	// private String mobile;

	/**
	 * 状态 0：禁用 1：正常
	 */
	private Integer status;







	/**
	 * 设置：
	 * 
	 * @param userId
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * 获取：
	 * 
	 * @return Long
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * 设置：用户名
	 * 
	 * @param username
	 *            用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 获取：用户名
	 * 
	 * @return String
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 设置：密码
	 * 
	 * @param password
	 *            密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取：密码
	 * 
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置：状态 0：禁用 1：正常
	 * 
	 * @param status
	 *            状态 0：禁用 1：正常
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 获取：状态 0：禁用 1：正常
	 * 
	 * @return Integer
	 */
	public Integer getStatus() {
		return status;
	}



}
