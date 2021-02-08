public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            x = 1/x;
            n = -n;
        }
        return pow(x, n);
    }

    private double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double half = pow(x, n / 2);
        return half * half * (n % 2 == 0 ? 1.0 : x);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        double result = solution.myPow(2.0, 10);
        System.out.println(result);
    }

