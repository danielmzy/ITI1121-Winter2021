import java.util.Random;

/**
 * Simulates an operating system for the purposes of testing a scheduler. It creates
 * a bunch of jobs and then runs them until they are done outputing the information
 * on which job is scheduled and when.
 * 
 * @author Robert Warren
 */
public class Simulation
{
        private Queue scheduler;
        
        private static final int DEFAULT_TIME = 100;
        private static final int NUMBER_OF_JOBS = 10;
        private static final int PRIORITY_LEVELS = 3;
        private static final int MAX_DURATION = 1000;
        
        /**
         * Creates an Operating System Simulator to test a given scheduler.
         * 
         * @param scheduler The scheduler to test. The scheduler should use the Queue
         * interface.
         */
        public Simulation(Queue scheduler)
        {
                this.scheduler = scheduler;
        }
        
        /**
         * Runs the simulator by creating a certain number of Jobs and then running
         * until all the Jobs are completed. It outputs a progress report at each time
         * it retrieves a new Job from the scheduler and runs it. By default it runs
         * each Job for 100 milliseconds at a time, however, if a Job finishes before
         * that time has elapsed the remaining time is given to the next Job.
         */
        public void run()
        {
                if (scheduler == null)
                {
                        return;
                }
                
                Random generator = new Random();
                System.out.println("Creating jobs...");
                for (int i = 0; i < NUMBER_OF_JOBS; i ++)
                {
                        Job temp = new Job(generator.nextInt(PRIORITY_LEVELS), 
                                           generator.nextInt(MAX_DURATION));
                        scheduler.enqueue(temp);
                        System.out.println(temp);
                }
                
                System.out.println();
                System.out.println("Running jobs...");
                int time = DEFAULT_TIME;
                while (!scheduler.isEmpty())
                {
                        Job active = scheduler.dequeue();                        
                        
                        System.out.println("Running Job " + active.getId() + " for " + time + " milliseconds..");
                        if (active.getDuration() >= time)
                        {
                                active.run(time);
                                time = DEFAULT_TIME;
                        }
                        else
                        {
                                time = DEFAULT_TIME + time - active.getDuration();
                                active.run(active.getDuration()); 
                        }                        
                        System.out.print("..." + active);   
                        
                        if (active.getDuration() > 0)
                        {
                                scheduler.enqueue(active);
                                System.out.println();
                        }
                        else
                        {
                                System.out.println(" COMPLETE!");
                        }
                }
        }
        
        /**
         * The main method creates the scheduler and the operating system simulator
         * on which to test it. It also runs the simulator. Modify the main method
         * in order to change the scheduler and compare the results.
         */
        public static void main(String[] args)
        {
                Queue jobs = null; // Replace null with the queue you want to test
                Simulation simulator = new Simulation(jobs);
                simulator.run();
        }
}