package decorate;

public class LayserCannon extends Weapon {
    public LayserCannon(Tank tank) {
        super(tank);
    }

    @Override
    public String climb() {
        return super.climb();
    }

    @Override
    public String shoot() {
        return "LayserCannon charging..." + super.shoot();
    }
}