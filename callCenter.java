public class callCenter {
   public class Employee{
        boolean isFree = true;
        boolean canHandle = true;
    
        public void busy() {
            isFree = false;
        }
     
        public void free() {
            isFree = true;
        }
     
        public boolean canHandle() {
            return canHandle;
        }
     
        public boolean handle() {
            return isFree && canHandle;
        }
        
        public void setCanHandle(boolean canHandle) {
            this.canHandle = canHandle;
        }
     
    }
    
    public class callCenterSystem {
        private Employee PM;
        private Employee TL;
        private List<Employee> freshers;
    
        public Employee call() {
            synchronized (this){
                Employee cecipient = null;
                for (int i = 0; i < freshers.size(); i++) {
                  Employee fresher = freshers.get(i);
                  if (fresher.handle()) {
                      fresher.busy();
                      cecipient =  fresher;
                  }
                }
                if (TL.handle()) {
                  TL.busy();
                  cecipient =  TL;
                }
                if (PM.handle()) {
                  PM.busy();
                  cecipient =  PM;
                }
                return cecipient;
            }
        }
    }
}
