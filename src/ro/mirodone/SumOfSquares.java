package ro.mirodone;

public class SumOfSquares {

    // Returns count of minimum squares that sum to n
    int getMinSquares(int n) {

        // We need to add a check here for n. If user enters 0 or 1 or 2
        // the below array creation will go OutOfBounds.
        if (n <= 3)
            return n;

        // Create a dynamic programming table
        // to store sq
        int dp[] = new int[n + 1];

        // getMinSquares table for base case entries
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        // getMinSquares rest of the table using recursive
        // formula
        for (int i = 4; i <= n; i++) {
            // max value is i as i can always be represented
            // as 1*1 + 1*1 + ...
            dp[i] = i;

            // Go through all smaller numbers to
            // to recursively find minimum
            for (int x = 1; x <= Math.ceil(Math.sqrt(i)); x++) {
                int temp = x * x;
                if (temp > i)
                    break;
                else
                    dp[i] = Math.min(dp[i], 1 + dp[i - temp]);
            }
        }

        // Store result and free dp[]
        int res = dp[n];

        return res;
    }

}
