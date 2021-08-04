/**
 * This class represents a ficitional operating system job (such as a program) that
 * our operating system simulator will simulate. The job stores two pieces of 
 * information: the owner of the job and the duration of the job. The owner is either
 * the (operating) system, the user or an application (i.e. another job). The duration
 * is the number of milliseconds that the job needs to be run in order to be complete.
 * 
 * The job is run by successive calls the run method. Each call to the method runs
 * the job for a given number of milliseconds. Once the job has been run, successive
 * calls to run don't do anything.
 * 
 * @author Robert Warren
 */
public class Job
{
        /**
         * This constant indicates that an application is the owner of the job.
         */
        public static final int APPLICATION = 0;
        
        /**
         * This constant indicates that the user is the owner of the job.
         */
        public static final int USER = 1;
        
        /**
         * This constant indicates that the operating system is the owner of the job.
         */
        public static final int SYSTEM  = 2;
        
        private int owner;
        private int duration;
        private int id;
        
        private static int currentId = 0;
                        
        /**
         * The constructor for Job initializes its three instance variables. It gets
         * the owner and the duration (in milliseconds) from the user and assigns
         * a unique id to the Job.
         * 
         * @param owner Either 0, 1 or 2 inidicating who created the Job.
         * @param duration The number of milliseconds the Job must run until completion.
         */
        public Job(int owner, int duration)
        {
                this.owner = owner;
                this.duration = duration;
                this.id = currentId ++;
        }
        
        /**
         * Gets the unique id of the Job.
         * 
         * @return An integer id unique to this Job.
         */
        public int getId()
        {
                return this.id;
        }
        
        /**
         * Gets the owner of the Job.
         * 
         * @return 0, 1 or 2 indicating the owner, an application, the user or
         * the system respectively, of the Job.
         */
        public int getOwner()
        {
                return this.owner;
        }
        
        /**
         * Gets the remaining duration, in milliseconds, of the Job.
         * 
         * @return An integer containing the remaining duration of the Job.
         */
        public int getDuration()
        {
                return this.duration;
        }
        
        /**
         * Runs the job for a certain number of milliseconds.
         * 
         * @param time An integer containing the number of milliseconds that the
         * job should be run.
         */
        public void run(int time)
        {
                this.duration -= time;
                
                if (this.duration < 0)
                {
                        this.duration = 0;
                }
                
                try
                {
                        if (time > duration)
                        {                                
                                Thread.sleep(time);
                        }
                        else
                        {
                                Thread.sleep(duration);
                        }
                }
                catch (Exception e)
                {
                        // Do nothing
                }
        }
        
        /**
         * Determines if two Jobs are equal by comparing their unique ids.
         * 
         * @param other The Job to compare with this Job.
         * @return True if the two Jobs have the same id, false otherwise.
         */
        public boolean equals(Job other)
        {
                return this.getId() == other.getId();
        }
        
        /**
         * Produces a String representation of the Job.
         * 
         * @return A String representation of the job.
         */
        public String toString()
        {
                StringBuffer result = new StringBuffer();
                
                result.append("Job ");
                result.append(getId());
                
                result.append(" owned by ");
                switch(getOwner())
                {
                        case SYSTEM: result.append("the system "); break;
                        case USER: result.append("the user "); break;
                        case APPLICATION: result.append("an application "); break;
                        default: result.append(" ERROR "); break;
                }
                
                result.append("has ");
                result.append(duration);
                result.append(" microseconds remaining;");
                
                return result.toString();
        }
}