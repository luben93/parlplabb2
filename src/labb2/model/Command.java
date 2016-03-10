package labb2.model;

import javafx.scene.canvas.GraphicsContext;

import java.util.Stack;

/**
 * Created by luben on 2016-03-10.
 */ // 1. The clone() contract
public interface Command {
    void execute(GraphicsContext con);
}

