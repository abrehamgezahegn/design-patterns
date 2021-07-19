interface Car {

    public String assemble();

}

class Tesla implements Car {
    public String assemble(){
        System.out.println("Assembling parts of Tesla...");
        return "Tesla assembled";
    } 
}

class Mercedes implements Car {
    public String assemble(){
        System.out.println("Assembling parts of Mercedes...");
        return "Mercedes assembled";

    } 
}

class Volswagon implements Car {
    public String assemble(){
        System.out.println("Assembling parts of Volswagon...");
        return "Vols assembled";

    } 
}



class CarFactory {
    public CarFactory(String name){
        System.out.print("afasdfas");
    }
    public static Car getAssembler(int budget) {
        if(budget > 100000) {
            return new Tesla();
        }else if (budget > 80000) {
            return new Mercedes();
        }else if (budget > 70000) {
            return new Volswagon();
        }
    return null;
    }

    public static void main(String []args){
        CarFactory carFactory = new CarFactory("Hmm");
        Car car = carFactory.getAssembler(100000);
        System.out.print("car");
    }
} 


