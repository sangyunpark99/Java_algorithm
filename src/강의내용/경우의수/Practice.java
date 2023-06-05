package 강의내용.경우의수;

// Practice
// 약수 구하기, 두 수의 최대공약수와 최소공배수 구하기
// 활용 ) 1-10의 수 중 A의 약수 또는 B의 약수인 경우의 수
// 활용 ) 1-10의 수 중 A의 약수이면서 B의 약수인 경우

import java.util.ArrayList;

public class Practice {

    // 약수
    public ArrayList getDivisor(int num){
        ArrayList result = new ArrayList();

        for (int i = 1; i < (int)num/2; i++){ // 절반 보다 큰 수는 나눠떨어지는 수가 나오지 않는다.
            if(num % i == 0){
                result.add(i);
            }
        }

        result.add(num); // 자기 자신의 값 추가

        return result;
    }

    // 최대 공약수
    public int getGCD(int numA, int numB){
        int gcd = -1;

        ArrayList divisorA = this.getDivisor(numA);
        ArrayList divisorB = this.getDivisor(numB);

        for(int itemA: (ArrayList<Integer>)divisorA){
            for(int itemB: (ArrayList<Integer>)divisorB){
                if(itemA == itemB){
                    if(itemA > gcd){
                        gcd = itemA;
                    }
                }
            }
        }

        return gcd;
    }


    // 최소 공배수 - 최대 공약수의 배수
    // 두 수의 곱 / 최대 공약수
    public int getLCM(int numA, int numB){

        int lcm = -1;

        int gcd = this.getGCD(numA, numB);

        if(gcd != -1){ // 최대 공약수가 존재하는 경우
            lcm = (numA * numB) / gcd;
        }

        return lcm;
    }

    public static void main(String[] args) {
        // Test
        int number1 = 10;
        int number2 = 6;

        Practice p = new Practice();

        ArrayList l1 = p.getDivisor(number1);
        ArrayList l2 = p.getDivisor(number2);

        System.out.println(l1);
        System.out.println(l2);

        System.out.println("최대 공약수 : " + p.getGCD(number1, number2));
        System.out.println("최소 공배수 : " + p.getGCD(number1, number2));
    }
}
