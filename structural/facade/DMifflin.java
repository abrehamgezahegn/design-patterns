class Manager {
   public Manager(String name){

   } 

   public static void signPaperWork(){
       // do some work
       System.out.print("Signing paper work")
   }

   public static void setUncessaryMeeting(){
       System.out.print("Everyone in the conference room in 5 seconds")
   }

   public static void doPerformanceReview(){
       System.out.print("Okay, let's do your performance review")
       System.out.print("Listen to her pauses? Stanley, thats genius!")
   }

}

class Accountant{
    public Accountant(String name){

    }

    public static void processPayment(){
        // do some heavy work
        System.out.print("Processing payment")
    }

    public static void convinceManager(){
        // do some calculations
        System.out.print("Actually in this case, gaining money makes more sense than losing!")
    }

    public static void giveOutPayCheck(){
        // write pay checks
        System.out.print("Handing pay checks")
    }
}

class Sales {
    public Sales(String name){

    }

    public static void bookClient(){
        // do some heavy work
        System.out.print("Booking client")
    }

    public static void prankDwight(){
        System.out.print("Buy accessories..., spend unreasonable amount of time planning..., pull of prank..." )
    }
}

// Facade  - responsible for 
class OfficeAdmin{
    public OfficeAdmin(String name, Manager mgr, Accountant acc , Sales salesman){
        this.name = name
        this.michael = mgr
        this.oscar = acc
        this.jim = salesman
    }


    public static void processATask(){
        System.out.print("Admin is processing a task")
        jim.bookClient()
        michael.setUncessaryMeeting()
        michael.doPerformanceReview()
        jim.prankDwight()
        oscar.convinceManager()
        jim.bookClient()
        michael.signPaperWork()
    }

      public static void processDelivery(){
        System.out.print("Admin is processing a delivery")
        michael.setUncessaryMeeting()
        michael.doPerformanceReview()
        jim.bookClient()
        michael.signPaperWork()
    }

}

class DMifflin{

    public static void main(String args[]) {
        Manager michael = new Manager("Michale");
        Accountant oscar = new Accountant("Oscar");
        Sales jim = new Sales("jim");

        OfficeAdmin pam = new OfficeAdmin("Pam", michael,oscar,jim)
        pam.processATask()

    }
}