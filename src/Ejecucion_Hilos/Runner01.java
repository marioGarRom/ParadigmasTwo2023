package Ejecucion_Hilos;

class Runner1 implements Runnable{
    @Override
    public void run(){
        for (int i = 0; i < 1000; ++i)
            System.out.println("Runner1: " + i);
    }
}

class Runner2 implements Runnable{
    @Override
    public void run(){
        for (int i = 0; i < 1000; ++i)
            System.out.println("\t\tRunner2: " + i);
    }
}

class Main{
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runner1());
        Thread t2 = new Thread(new Runner2());

        t1.start();
        t2.start();
    }
}


