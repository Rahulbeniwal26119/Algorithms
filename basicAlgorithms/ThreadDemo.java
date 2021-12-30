class NewThread implements Runnable{

        Thread t;
        NewThread(){
                t = new Thread(this, "Demo Thread");
                System.out.println("Child Thread" + " " + t);
        }

        public void run(){
                try{
                        for(int i=5; i > 0; i--){
                                System.out.println("child thread" + " " + i);
                                Thread.sleep(1000);
                        }
                }
                catch(InterruptedException e){
                        System.out.println("Child Interrupted");
                }
                System.out.println("Existing child thread");
        }

}

class ThreadDemo{
                public static void main(String []args){
                        NewThread nt = new NewThread();
                        nt.t.start();

                        try{
                                for(int i=5; i > 0; i--){
                                        System.out.println("Main Thread : " + i);
                                        Thread.sleep(1000);
                                }
                        }
                        catch(InterruptedException e){
                                System.out.println("Main Thread interrupted");
                        }
                        System.out.println("Main thread existing");
                }
}




                


