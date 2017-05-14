package ru.atom.bombergirl.game.model;

import ru.atom.bombergirl.game.geometry.Point;
import ru.atom.bombergirl.mmserver.GameSession;

public class Fire implements GameObject, Positionable, Temporary, Tickable {

    private Point position;
    private final long lifetime = 500;
    private long workTime = 0;
    private boolean isDead = false;
    private final int id;

    public Fire(int x, int y) {
        this.position = new Point(x, y);
        this.id = GameSession.nextValue();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void tick(long elapsed) {
        workTime += elapsed;
        if (elapsed >= lifetime) {
            isDead = true;
        }

    }

    @Override
    public long getLifetimeMillis() {
        return lifetime;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public boolean isDead() {
        return isDead;
    }

}
