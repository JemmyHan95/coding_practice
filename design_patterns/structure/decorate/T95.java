package decorate;

public class T95 implements Tank {
    @Override
    public String climb() {
        return "T95 is running on plain ground...";
    }
    
    @Override
    public String shoot() {
        return "Shooting...";
    }
}