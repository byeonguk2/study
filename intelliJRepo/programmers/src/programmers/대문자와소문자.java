package programmers;

public class 대문자와소문자 {

    public static void main(String[] args) {

        대문자와소문자 solution = new 대문자와소문자();

        String my_string = "cccCCC";

        System.out.println(solution.solution(my_string));

    }

    public String solution(String my_string) {

        char[] cArr = my_string.toCharArray();

        String answer = "";
        for (char c : cArr) {
            // 대문자 확인
            if (Character.isUpperCase(c)){
                answer += Character.toLowerCase(c);
            // 소문자 확인
            }else{
                answer += Character.toUpperCase(c);
            }
        }

        return answer;
    }

}
