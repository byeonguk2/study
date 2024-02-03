package programmers;

public class 가장큰수찾기 {

    public static void main(String[] args) {

        가장큰수찾기 solution = new 가장큰수찾기();

        int[] array = {9, 10, 11, 8};

        for (int i : solution.solution(array)) {
            System.out.println(i);
        }

    }

    public int[] solution(int[] array) {

        int[] answer = new int[2];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(array[i] < array[j]){
                    answer[0] = array[j];
                    answer[1] = j;
                }
            }
        }

        return answer;

    }

}
