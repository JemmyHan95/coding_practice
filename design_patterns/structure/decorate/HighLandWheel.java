package decorate;

public class HighLandWheel extends Wheel {

    public HighLandWheel(Tank tank) {
        super(tank);
    }

    @Override
    public String climb() {
        return super.climb() + "Climbing high land...";
    }

    @Override
    public String shoot() {
        return super.shoot();
    }
}