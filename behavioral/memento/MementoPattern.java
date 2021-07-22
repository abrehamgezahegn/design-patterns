import java.util.HashMap;
import java.util.Map;

class Editor {
    private String text;
    private int curX;
    private int curY;
    private  CareTaker careTaker;
    private  String savePoint;

    public Editor(String text, int curX, int curY, CareTaker careTaker) {
        this.text = text;
        this.curX = curX;
        this.curY = curY;
        this.careTaker = careTaker;
        this.savePoint = "START";
    }


    public void setText(String text){
        this.text = text;
    }

    public void setCurX(int x){
        this.curX = x;
    }

    public void setCurY(int y){
        this.curY = y;
    }

    public void createSnapShot(String savePoint){
         careTaker.saveMemento(new Memento(text,curX, curY), savePoint );
         this.savePoint = savePoint;
    }

    public void undo(){
        setOriginatorState(this.savePoint);
    }

    public void undo(String savepointName){
        setOriginatorState(savepointName);
    }
    public void undoAll(){
        setOriginatorState("INITIAL");
        careTaker.clearSavepoints();
    }
    private void setOriginatorState(String savepoint){
        Memento mem = careTaker.getMemento(savepoint);
        this.curX = mem.getCurX();
        this.curY = mem.getCurY();
    }

}


class CareTaker {
    private final Map<String, Memento>savepointStorage = new HashMap<String, Memento>();
    public void saveMemento(Memento memento,String savepointName){
        System.out.println("Saving state..."+savepointName);
        savepointStorage.put(savepointName, memento);
    }
    public Memento getMemento(String savepointName){
        System.out.println("Undo at ..."+savepointName);
        return savepointStorage.get(savepointName);
    }
    public void clearSavepoints(){
        System.out.println("Clearing all save points...");
        savepointStorage.clear();
    }
}

class Memento {
    private String text;
    private int curX;
    private int curY;

    public Memento(String text, int curX, int curY){
        this.text = text;
        this.curX = curX;
        this.curY = curY;
    }

    public String getText() {
        return text;
    }

    public int getCurX() {
        return curX;
    }

    public int getCurY() {
        return curY;
    }
}

public class MementoPattern{
    public static void main(String[] args) {
        CareTaker careTaker = new CareTaker();
        Editor editor = new Editor("", 0, 0, careTaker);
        editor.setCurX(12);
        editor.setCurX(1);
        editor.setText("Music is a beautiful thing");

        editor.createSnapShot("1");

        editor.setCurX(152);
        editor.setCurX(1);
        editor.setText("Music is a beautiful thing. Let me tell you something about music");

        editor.createSnapShot("2");
        editor.undo();
        System.out.print("State: " +editor);

        editor.setCurX(152);
        editor.setCurX(1);
        editor.setText("Music is a beautiful thing. Let me tell you something about music. It's beautiful");

        editor.createSnapShot("3");

        editor.undo("1");
        System.out.print("State: " +editor);
    }
}