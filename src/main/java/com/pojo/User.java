package com.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class User{

	@SerializedName("UserName")
	@Expose
	private String userName;

	@SerializedName("ID")
	@Expose
	private int iD;

	@SerializedName("Password")
	@Expose
	private String password;
}