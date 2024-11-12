package simulation_implementation.과일_가져가기;

import java.util.*;

class Solution {
    public int solution(int[][] fruit){
        int answer = 0;

        int numberOfStudent = fruit.length;
        int[] minFruitIdxArr = new int[numberOfStudent];

        // init minFruitIdxArr
        for (int studentIdx = 0; studentIdx < numberOfStudent; studentIdx++) {
            int min = Integer.MAX_VALUE;

            for (int fruitIdx = 0; fruitIdx < 3; fruitIdx++) {
                int count = fruit[studentIdx][fruitIdx];

                if (count < min) {
                    min = count;
                    minFruitIdxArr[studentIdx] = fruitIdx;
                }
            }
        }

        // exchange
        for (int studentIdx = 0; studentIdx < numberOfStudent; studentIdx++) {
            int minFruitIdx = minFruitIdxArr[studentIdx];

            for (int exchangeStudentIdx = 0; exchangeStudentIdx < numberOfStudent; exchangeStudentIdx++) {
                if (studentIdx == exchangeStudentIdx) {
                    continue;
                }

                int exchangeMinFruitIdx = minFruitIdxArr[exchangeStudentIdx];
                if (exchangeMinFruitIdx == minFruitIdx) {
                    continue;
                }

                fruit[studentIdx][minFruitIdx]++;
                fruit[studentIdx][exchangeMinFruitIdx]--;
                if (fruit[studentIdx][exchangeMinFruitIdx] < fruit[studentIdx][minFruitIdx]) {
                    minFruitIdxArr[studentIdx] = exchangeMinFruitIdx;
                }

                fruit[exchangeStudentIdx][exchangeMinFruitIdx]++;
                fruit[exchangeStudentIdx][minFruitIdx]--;
                if (fruit[exchangeStudentIdx][minFruitIdx] < fruit[exchangeStudentIdx][exchangeMinFruitIdx]) {
                    minFruitIdxArr[exchangeStudentIdx] = minFruitIdx;
                }

                break;
            }
        }

        for (int studentIdx = 0; studentIdx < numberOfStudent; studentIdx++) {
            int minFruitIdx = minFruitIdxArr[studentIdx];
            answer += fruit[studentIdx][minFruitIdx];
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}