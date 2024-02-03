package programmers;

public class 최대값만들기2 {

    public static void main(String[] args) {

        최대값만들기2 solution = new 최대값만들기2();

        int[] numbers = {10, 20, 30, 5, 5, 20, 5};

        System.out.println(solution.solution(numbers));

    }

    public int solution(int[] numbers) {

        int answer = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                int result = numbers[i] * numbers[j];
                if(result > answer && numbers[i] != numbers[j]){
                    answer = result;
                }
            }
        }

        return answer;
    }

}
