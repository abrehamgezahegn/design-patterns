interface CarFactory{
    public CarComponent getCarComponent(String type);
}

class KoreanCarFactory implements CarFactory {

    public CarComponent getCarComponent(String type){
        if(type == "tire"){
            return new KoreanTire();
        }else if (type == "body"){
            return new KoreanBody();
        }

        return  null;
    }
}



class USCarFactory implements CarFactory {

    public CarComponent getCarComponent(String type){
        if(type == "tire"){
            return new USTire();
        }else if (type == "body"){
            return new USBody();
        }
         return  null;
    }



}

interface CarComponent {
    public void build();
}

interface Tire  extends CarComponent {
    public void build();
}

class KoreanTire implements Tire {
    public void build(){
        System.out.println("Building korean tire");
    }
}


class USTire implements Tire {
    public void build(){
        System.out.println("Building US tire");
    }
}


interface Body extends CarComponent {
    public void build();
}


class KoreanBody implements Body {
    public void build(){
        System.out.println("Building korean body");
    }
}

class USBody implements Body {
    public void build(){
        System.out.println("Building US body");
    }
}


class FactoryConfig {

    public CarFactory getFactoryByCountry(String country) {
        if (country == "US") {
            return new USCarFactory();
        }else if (country == "korea"){
            return new KoreanCarFactory();
        }
        return  null;

    }
}

class AbstractFactoryPattern {
    public static void main(String[] args){

        String country = "US";

        FactoryConfig factConfig = new FactoryConfig();
        CarFactory carFactory = factConfig.getFactoryByCountry(country);

        CarComponent tire = carFactory.getCarComponent("tire");
        CarComponent body = carFactory.getCarComponent("body");
        tire.build();
        body.build();        
     
     

    }
}






