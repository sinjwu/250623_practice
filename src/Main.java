class SumThread extends Thread {
    private int[] array;
    private int start, end;
    private int partialSum = 0; //외부에서 받아올 필요 X(항상 0이기 때문)

    public SumThread(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }
    @Override
    public void run() {
        for(int i = start; i < end; i++) {
            partialSum += array[i];
        }
    }
    public int getPartialSum() {
        return partialSum;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] numbers = new int[100];
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        int numThreads = 4;
        int chunkSize = numbers.length / numThreads;
        SumThread[] threads = new SumThread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = (i == numThreads - 1) ? numbers.length : start + chunkSize;
            //배열 길이가 4의 배수가 아닐 경우를 대비해서 마지막 i값에 대해 삼항연산자로 처리
            threads[i] = new SumThread(numbers, start, end);
            threads[i].start();
        }
        int totalSum = 0;
        try {
            for (SumThread thread : threads) {
                thread.join(); //unhandledexception이 뜸
                int threadResult = thread.getPartialSum();
                System.out.println("현재 스레드의 총합 결과: " + threadResult);
                totalSum += threadResult;
            }
        } catch(InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
        System.out.println("모든 스레드의 총합: " + totalSum);
    }
}