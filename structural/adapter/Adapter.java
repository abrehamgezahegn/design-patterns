// client interface
public interface Map{
    public void showMap(String lng, String lat)
}

// service interface
public interface Address{
    public Sting getAddress(String postalCode)
}


// service
public class AddressImpl implements Address{
    public Sting getAddress(String postalCode){
        return "Addis ababa, Ethiopia"
    }

    public String getCoords(String addr) {
        lat,log = fetchCoords(addr)
        return {lat,log}
    }
}


// adapter 
class AddressAdapter implements Map {

    Address a = new AddressImpl();

    public String getMap(String postalCode) {
        String addr = a.getAddress(postalCode)
         {lat,log} = a.getCoords(addr)
        return showMap(lat,log)
    }

    public void showMap(String lng, String lat){
        return  "Mapp"
    }

 
}


// demo
class AdapterPattern {
    public static void main(String[] args){
        Map m = new AddressAdapter()
        m.getMap(1244)
    }
}







