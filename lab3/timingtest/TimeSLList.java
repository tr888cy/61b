package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 1; i < Ns.size(); i = i+1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE

        AList<Integer> Ns = new AList<Integer>();
        AList<Double> times = new AList<Double>();
        AList<Integer> opCounts = new AList<Integer>();


        for (int N = 1000; N<128001; N = N * 2){

            //Create an SLList.
            SLList<Integer> SLint = new SLList<>();


            //Add N items to the SLList.
            for (int i = 0; i < N; i++) {
                SLint.addFirst(0);

            }
            Ns.addLast(N);
            //Start the timer.
            Stopwatch sw = new Stopwatch();

            //Perform M getLast operations on the SLList.
            int M = 10000;
            for (int j = 1; j <= M; j++) {
                SLint.getLast();


                }
            opCounts.addLast(M);
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
        }

        //Check the timer. This gives the total time to complete all M operations.
        printTimingTable(Ns, times, opCounts);

    }



}
