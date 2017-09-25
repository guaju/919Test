package com.guaju.a919test.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by guaju on 2017/9/21.
 */

public class LoginModel {

    public boolean format(String phoneNum){
        /**
         *       先写一个正则表达式规则
         *       {3}表示前边的数字或者符号有3位 ，如果想让前边的数字有至少一位用 "+"表示
         *       如果想表示0位或者多位  *表示
         *       \d表示正整数   \s表示 空格  \w表示 字母
         *       [a,b,c]表示从中取一位 数字
         *       如果想表达除去9以外的所有东西 [^9]
         *
         *
         *       然后去定义matcher，让matcher去匹配
         */
         String format="^1[3,4,5,6,7,8]\\d{9}$";
        Pattern pattern = Pattern.compile(format);
        Matcher matcher= pattern.matcher(phoneNum);
       return matcher.matches();
    }
}
