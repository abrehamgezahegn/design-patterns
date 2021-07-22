interface ComponentWithClickHandler{
    public void handleClick();
}

class OnClick {
    private String text;
    public OnClick(String text){
        this.text = text;
    }
    public void action(){
        System.out.println("on click fired");
    }
}

class Component implements ComponentWithClickHandler{
    private OnClick onClick = null;
    private ComponentWithClickHandler nextComponent = null;
    private String componentName = null;
    

    public void handleClick(){
        if(onClick != null){
            this.onClick.action();
            System.out.print("Click event handled by: ");
            System.out.println(this.componentName);
        }else if (nextComponent != null) {
            this.nextComponent.handleClick();
        }else {
            System.out.println("Event left unhandled");
        }
    }

    public void setNext(ComponentWithClickHandler component){
        this.nextComponent = component;
    }

    public void setOnClick(OnClick onClick, String componentName){
        this.onClick = onClick;
        this.componentName = componentName;
    }

}

class Div extends Component{
    private String divName = "";

    public Div(String name){
        divName = name;
    }
    
}

class Body extends Component {
    private String bgColor = "#fff";

    public Body(String bgColor){
        this.bgColor = bgColor;
    }

}

class Table extends Component {
    private int rows;
    private int columns;

    public Table(int rows , int columns){
        this.rows = rows;
        this.columns  = columns;
    }
}


class ChainOfResponsibility{

    public static void main(String []args){
        Body body = new Body("#ff45");
        Div div = new Div("div-ide");
        Table table = new Table(4,6);

        OnClick onClick = new OnClick("Do something");

        table.setNext(div);
        div.setNext(body);

        // div.setOnClick(onClick, "Div component");
        table.setOnClick(onClick, "Table component");

        table.handleClick();

    }

}