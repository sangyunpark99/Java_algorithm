package 강의내용.지수와로그;

public class Practice {
    static double pow(int a, double b) {
        double result = 1;
        boolean isMinus = false;

        if(b == 0){
            return 1;
        } else if (b < 0){
            b *= -1;
            isMinus = true;
        }

        for(int i = 0; i < b; i++){
            result *= a;
        }

        return isMinus?1/result:result;
    }

    public double sqrt(int a){
        double result = 1;

        for(int i = 0; i < 10; i++){
            result = (result + (a/result))/2;
        }

        return result;
    }
}
