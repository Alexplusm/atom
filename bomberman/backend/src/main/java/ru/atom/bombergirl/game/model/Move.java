package ru.atom.bombergirl.game.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Move implements Action {
    private Movable.Direction direction;

    public Move(@JsonProperty("direction") Movable.Direction direction) {
        this.direction = direction;
    }

    @Override
    public void act(Pawn pawn) {
        pawn.move(direction);
    }
}
