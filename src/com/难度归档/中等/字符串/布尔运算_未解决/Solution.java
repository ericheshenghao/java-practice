package com.难度归档.中等.字符串.布尔运算_未解决;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

class Solution {
    public int countEval(String s, int result) {
        // 可以添加的括号数量
        int n = s.length()/3;
        // 回溯
        trace(s,1,result,n);


        return 1;
    }

    private void trace(String s,int start, int res, int n) {
        for(int i =start;i<s.length();i++){
           String temp= String.valueOf(s.charAt(i));
            if(i%2==0){
                temp+= "(" + s.substring(i,i+2) + ")";
                trace(s,i,res,n--);
            }
        }
    }

    public static void main(String[] args) throws ScriptException {
        Solution solution = new Solution();
        String s = "1^0|0|1";
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        int eval = (int) engine.eval(s);
        System.out.println(eval);

        int i = solution.countEval("1^0|0|1", 0);

    }
}