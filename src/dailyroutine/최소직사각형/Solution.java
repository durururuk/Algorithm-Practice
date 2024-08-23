package src.dailyroutine.최소직사각형;

import java.util.Arrays;

/**
 * main, PRINT_RESULT 는 테스트 케이스 실행 및 결과 확인을 위한 함수입니다.
 * [답안지 복사] 기능을 사용하는 경우 해당 함수들을 제외하며, 답안에 필요한 코드만 복사됩니다.
 * 테스트 케이스 추가 등 함수 내부 변경은 가능하나, 함수 이름 변경시 [답안지 복사] 기능이 제대로 동작하지 않습니다.
 *
 * 또한, 기본 설정으로 [답안지 복사] 사용시 해당 주석과 작성하신 주석을 제외하여 복사됩니다.
 * [주석 복사] 여부는 설정을 통해 변경할 수 있습니다.
 *
 * [도움말 주석] 옵션은 설정을 통해 제거할 수 있습니다.
 *
 * - [답안지 복사]
 *   코드 - 답안지 복사 (기본 단축키 cmd + shift + w)
 *
 * - [도움말 주석]
 *   설정 - 도구 - 프로그래머스 헬퍼 - 도움말 주석
 *
 * - [주석 복사]
 *   설정 - 도구 - 프로그래머스 헬퍼 - 주석 복사
 *
 * GitHub: https://github.com/azqazq195/programmers_helper
 */
class Solution {
    public static void main(String[] args) {
        int[][] sizes1 = new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int answer1 = 4000;
        int result1 = new Solution().solution(sizes1);
        PRINT_RESULT(1, result1, answer1);

        int[][] sizes2 = new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        int answer2 = 120;
        int result2 = new Solution().solution(sizes2);
        PRINT_RESULT(2, result2, answer2);

        int[][] sizes3 = new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
        int answer3 = 133;
        int result3 = new Solution().solution(sizes3);
        PRINT_RESULT(3, result3, answer3);
    }

    public static void PRINT_RESULT(int index, int result, int answer) {
        boolean correct = result == answer;
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(result).append("\n");
        sb.append("\t- 기댓값: \t").append(answer).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    public int solution(int[][] sizes) {
        int answer = 0;
        for(int[] size : sizes) {
            if(size[0] < size[1]) {
                int temp = size[1];
                size[1] = size[0];
                size[0] = temp;
            }
        }

        int maxFirst = Arrays.stream(sizes).mapToInt(size -> size[0]).max().orElseThrow();
        int maxLast = Arrays.stream(sizes).mapToInt(size -> size[1]).max().orElseThrow();
        answer = maxFirst * maxLast;

        return answer;
    }
}