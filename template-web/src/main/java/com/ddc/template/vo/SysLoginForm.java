package com.ddc.template.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.ddc.template.common.validator.group.AddGroup;
import com.ddc.template.common.validator.group.UpdateGroup;

/**
 * 登录表单
 *
 * @author harry.zhang
 */
public class SysLoginForm {
	
	@NotBlank(message="用户名不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String username;
	
	@NotBlank(message="密码不能为空", groups = AddGroup.class)
    private String password;
	
	@NotNull(message="请选择店铺", groups = AddGroup.class)
    private Integer shopId;
	
	@NotBlank(message="platform不能为空", groups = AddGroup.class)
    private String platform;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

}
