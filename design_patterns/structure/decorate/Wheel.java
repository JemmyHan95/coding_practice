package decorate;

import decorate.Tank;

public abstract class Wheel implements Tank {
    private Tank tank;

    public Wheel(Tank tank) {
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