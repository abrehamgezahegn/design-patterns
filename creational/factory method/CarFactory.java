public interface Car {

    public String assemble();

}

public class Tesla implements Car {
    public String assemble(){
        System.out.println("Assembling parts of Tesla...")
        return "Tesla assembled"
    } 
}

public class Mercedes implements Car {
    public String assemble(){
        System.out.println("Assembling parts of Mercedes...")
        return "Mercedes assembled"

    } 
}

public class Volswagon implements Car {
    public String assemble(){
        System.out.println("Assembling parts of Volswagon...")
        return "Vols assembled"

    } 
}



public class CarFactoryMethod {
    public static Car getAssembler(budget) {
        if(args.budget > 100000) {
            return new Tesla()
        }else if (args.budget > 80000) {
            return new Mercedes()
        }else if (args.budget > 70000) {
            return new Volswagon()  
        }
    }
} 


carFactory = CarFactoryMethod()
carFactory.getAssembler(100000)
