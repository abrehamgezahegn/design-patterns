interface Security{
    
    public String getSecurityName();
    public void deploySecurity();
}

class Firewall implements Security {
    private String name;
    public Firewall(String name){
        this.name = name;
    }

    public void deploySecurity(){
        System.out.print("Deploying firewall...");
    }

    public String getSecurityName(){
        return this.name;
    }
} 


class Encryption implements Security {
    private String name;
    public Encryption(String name){
        this.name = name;
    }

    public void deploySecurity(){
        System.out.print("Deploying encryption...");
    }

    public String getSecurityName(){
        return this.name;
    }
} 



abstract class CloudApp {
    private Security security;
    private String appType;

    public CloudApp(Security security, String appType){
        this.security = security;
        this.appType = appType;
    }

    public abstract void build();
    public abstract void deploySecurity(); 
}

class WebApp extends CloudApp{
    private Security security;
    private String appType;

    public WebApp(Security security, String appType){
        super(security,appType);
        this.security = security;
        this.appType = appType;
    }

    public void build(){
        System.out.print("Building webapp...");
    }
    public void deploySecurity(){
        security.deploySecurity();
        System.out.print("Deployed webapp security");
    }
}

class MobileApp extends CloudApp{
    private Security security;
    private String appType;

    public MobileApp(Security security, String appType){
        super(security,appType);
        this.security = security;
        this.appType = appType;
    }

    public void build(){
        System.out.print("Building mobile app...");
    }
    public void deploySecurity(){
        security.deploySecurity();
        System.out.print("Deployed mobile security");
    }
}

public class BridgePattern{

    public static void main(String[] args){
        Security sec1 = new Firewall("FireWall");
        Security sec2 = new Encryption("Encryption");

        CloudApp webApp1 = new WebApp(sec1, "Saas webapp");
        webApp1.build();
        webApp1.deploySecurity();

        CloudApp webApp2 = new WebApp(sec2, "Marketplace webapp");
        webApp2.build();
        webApp2.deploySecurity();

        MobileApp mobileApp1 = new MobileApp(sec1, "Some mobile app");
        mobileApp1.build();
        mobileApp1.deploySecurity();

        MobileApp mobileApp2 = new MobileApp(sec2, "Some mobile app");
        mobileApp2.build();
        mobileApp2.deploySecurity();

    } 
}