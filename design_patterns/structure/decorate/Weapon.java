package decorate;

public abstract class Weapon implements Tank {
    private Tank tank;

    public Weapon(Tank tank) {
        this.tank = tank;
    }

    @Override
    public String climb() {
        return tank.climb();
    }

    @Override
    public String shoot() {
        return tank.shoot();
    }
}