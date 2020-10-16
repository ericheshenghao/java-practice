package com.力扣练习.简单.字符串.二进制求和;

class Solution {
    public String addBinary(String a, String b) {
        Long i = Long.valueOf(a) + Long.valueOf(b);

//        System.out.println(i);
        String res= "";
        while (i >0) {
            Long remain = i%10;
          if(remain>1){
              res= (remain-2)+res;
              i = i/10+1;
          }else {
              res= remain+res;
              i=i/10;
          }

        }



        return  res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.addBinary("1110110101", "1110111011");
        System.out.println(s);
        // 2022
    }
}
