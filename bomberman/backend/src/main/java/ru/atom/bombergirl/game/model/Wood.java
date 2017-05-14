package ru.atom.bombergirl.game.model;

import ru.atom.bombergirl.game.geometry.Point;
import ru.atom.bombergirl.mmserver.GameSession;

public class Wood implements Block, GameObject, Positionable {

    private Point position;
    private final int id;

    public Wood(int x, int y) {
        this.position = new Point(x, y);
        id = GameSession.nextValue();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Point getPosition() {
        return position;
    }

}
