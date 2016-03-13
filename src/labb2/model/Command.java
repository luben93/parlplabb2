package labb2.model;

import javafx.scene.canvas.Canvas;

import java.io.Serializable;
import java.util.List;

/**
 * Created by luben on 2016-03-10.
 */ // 1. The clone() contract
public interface Command extends Serializable{
    Command execute(List<Canvas> c);
    Command setLayer(int layer);
    String getName();
    int getLayer();
}

