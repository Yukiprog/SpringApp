package com.example.demo.login.domain.model;


import java.util.Date;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SignupForm {

    //必須入力、メールアドレス形式
    @NotBlank
    @Email
    private String userId;

    //必須入力、長さ4から100桁までの半角英数のみ
    @NotBlank
    @Length(min=4,max=100)
    @Pattern(regexp="^[a-zA-Z0-9]+$")
    private String password;

    //必須入力
    @NotBlank
    private String userName;

    //ポイント@DateTimeFormat
    //必須入力
    @NotNull
    @DateTimeFormat(pattern="yyyy/MM/dd")
    private Date birthday;

    //値が20から100
    @Min(20)
    @Max(100)
    private int age;

    //false飲み可能
    @AssertFalse
    private boolean marriage;
}
