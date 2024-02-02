package w12;

import java.util.Random;

/**
 * �۾��� �ɰ��� ���� �����尡 ������ ���������ν� �ż��� �۾��� ��ĥ �� ������ ���δ�.
 * �������� �迭�� �ְ� �迭�� �ִ� ������ ���� �� ���� ������� ���Ѵ�.
 * 1) �ϳ��� ������� ���Ѵ�.
 * 2) �ھ� ������ŭ�� �����带 �����ϰ�, �迭�� �ھ� ������ŭ���� �ɰ� ��
 * 	  �� �����尡 �ɰ��� �� �迭�� ���� ���ϰ� �ϰ�, ���������� �� ���� ���Ͽ� ���� ���� ���Ѵ�. 
 */
public class DivideAndConquer extends Thread {
 
	// �� ���α׷��� �����ϴ� ��ǻ�Ͱ� �� ���� �ھ ���� �ִ����� �˾Ƴ���.
    static int cores = 10;
    
    // ��ü �迭
    final static int NUM_OF_VALUES =  cores * 55000000;
    static int[] values = new int[NUM_OF_VALUES]; 
 
    // �ھ� ������ŭ �ɰ��� �迭 (portion)
    static int portionSize = values.length / cores;	// �ɰ��� �� �迭(portion)�� ũ��
    static int[] portionResults = new int[cores];	// �ɰ��� �� �迭�� ��
    private int portionNumber;						// �ɰ��� �迭���� �Ϸ� ��ȣ
 
    public DivideAndConquer(int portionNumber) {
        this.portionNumber = portionNumber;
    }
 
    public void run() {
        // �ɰ��� �迭(portion)�� ���� ���Ѵ�.
        int sum =0;
        int baseIndex = portionNumber * portionSize;
        for( int i=baseIndex; i<baseIndex + portionSize; i++) {
            sum += values[i];
        }
        portionResults[portionNumber] = sum;
    }
 
    public static void generateInts() {
        Random randomGenerator = new Random();
        for( int i=0; i<values.length; i++ ) {
            int randomInt = randomGenerator.nextInt(10);
            values[i] = randomInt;
        }
    }
 
    public static void main(String args[]) {
 
        generateInts();
        
        System.out.println("cores = " + cores);
 
        /***********************************
                (1) �ϳ��� ������� ����Ѵ�.
        ************************************/
        {
            System.out.println("�ϳ��� ������� ���.");
            int total = 0;
            long startTime = System.currentTimeMillis();
 
            for( int i=0; i<values.length; i++ ) {
                total += values[i];
            }
 
            long elapsedTime = System.currentTimeMillis() - startTime;
 
            System.out.println("��: " + total);
            System.out.println("��� �ҿ� �ð�: " + elapsedTime + " ms\n");
        }
 
        /***********************************
               (2) ���� ���� ������� ����Ѵ�.
        ************************************/
        {
            System.out.println("���� ���� ������� ���.");
            int total = 0;
            long startTime = System.currentTimeMillis();
 
            Thread[] thread = new Thread[cores];
 
            for( int i=0; i<cores; i++ ) {
            	// �ɰ��� �� �迭�� �κ����� ����ϴ� �����带 �����ϰ� start��Ų��.
				thread[i] = new DivideAndConquer(i);
				thread[i].start();
			}
 
            // ��� �����尡 ���� ������ �������.
            // �����尡 ��� ���� �Ŀ� ���� �������� �Ѿ��.
            for( int i=0; i<cores; i++ ) {
                try {
                    thread[i].join();	// thread[i]�� ���� ������ ��ٸ���. 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
 
            // �ɰ��� �� �迭�� ���� ��� ���Ͽ� ������ ���Ѵ�.
			for (int i = 0; i < cores; i++)
				total += portionResults[i];
			
            long elapsedTime = System.currentTimeMillis() - startTime;
 
            System.out.println("��: " + total);
            System.out.println("��� �ҿ� �ð�: " + elapsedTime + " ms\n");
        }
    }
}