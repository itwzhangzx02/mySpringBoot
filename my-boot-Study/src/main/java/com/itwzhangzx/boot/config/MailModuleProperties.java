package com.itwzhangzx.boot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 加一个@Component注解，将这个bean让Spring管理起来
 *
 * @ConfigurationProperties注解比@value注解功能更强大，但是不能使用 SPel表达式
 * @Validated注解用于参数校验 JSR-303
 */

@Component
@ConfigurationProperties(prefix = "myapp.mail")
@Validated
public class MailModuleProperties {
	@Email
	private String email;
	@NotNull
	private Boolean enabled;
	@NotEmpty
	private String name;
	@Size(max = 5, min = 1)
	private List<String> servers;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getServers() {
		return servers;
	}

	public void setServers(List<String> servers) {
		this.servers = servers;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MailModuleProperties{" +
				"email='" + email + '\'' +
				", enabled=" + enabled +
				", name='" + name + '\'' +
				", servers=" + servers +
				'}';
	}
}
