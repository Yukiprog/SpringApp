package com.example.demo.login.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.domain.model.GroupOrder;
import com.example.demo.login.domain.model.SignupForm;

@Controller
public class SignupController {

    //ポイント1：ラジオボタンの実装
    private Map<String,String> radioMarriage;

    //ラジオボタンの初期化メソッド
    private Map<String,String> initRadioMarriage(){
        Map<String,String> radio = new LinkedHashMap<>();

        //既婚、未婚をMapに格納
        radio.put("既婚","true");
        radio.put("未婚","false");
        return radio;
    }

    //ユーザ登録画面のGET用コントローラー
    @GetMapping("/signup")
    //@ModelAttributeで指定したクラスはデフォルトではクラス名の始めを小文字に変えた文字列がキーになる
    public String getSignUp(@ModelAttribute SignupForm form,Model model) {

        //ラジオボタンの初期化メソッド呼び出し
        //上にあるよ
        radioMarriage = initRadioMarriage();

        //ラジオボタン用のMapをModelに格納
        model.addAttribute("radioMarriage", radioMarriage);

        //signup.htmlに画面遷移
        return "login/signup";
    }

    //ユーザー登録画面のPOST用コントローラー
    @PostMapping("/signup")
    public String postSignUp(@ModelAttribute @Validated(GroupOrder.class) SignupForm form,BindingResult bindingResult,Model model) {
        if(bindingResult.hasErrors()) {
            return getSignUp(form, model);
        }
        System.out.println(form);

        //ポイント2：リダイレクト
        //login.htmlにリダイレクト
        return "redirect:/login";
    }
}
