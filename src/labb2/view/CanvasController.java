package labb2.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import labb2.Main;
import labb2.model.Command;
import labb2.model.Point;
import labb2.model.Shape;

import java.util.Stack;

public class CanvasController extends Controller {

    @FXML
    private Pane pane;

    private ObservableList<Canvas> canvasList = FXCollections.observableList(new Stack<Canvas>());

    private Shape current = null;
    private Point start = null;
    private Canvas layer;


//    public void undoLast() {
//        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
//        if (!Main.commands.isEmpty()) {
//            Command last = Main.commands.pop();//TODO last set to current??
////            System.out.println("pop " + last);
//
//            Command c =(Command) PrototypesModule.findAndCloneAttributes("stroke", Color.BLACK.toString());
//            c.execute(gc);
//            Main.commands.addLast(c);
//            c= (Command) PrototypesModule.findAndCloneAttributes("fill", Color.BLACK.toString());
//            c.execute(gc);
//            Main.commands.addLast(c);
//
//
//            Main.commands.stream().forEachOrdered(command -> command.execute(gc));
////            for (int i = 0; i < Main.commands.size(); i++) {
////                Main.commands.peekLast().execute(gc);
////                Main.commands.peekFirst().execute(gc);
////            }
//        }
//    }

    public void undoLast() {
        if (!canvasList.isEmpty()) {
            try {
                Canvas tmp = canvasList.remove(canvasList.size()-1);
                pane.getChildren().remove(tmp);
                main.removeLayer(tmp);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    public void restoreSave(int index) {
        for (int i = 0; i < index; i++) {
            Canvas tmp=new Canvas(400, 400);
            canvasList.add(tmp);
            pane.getChildren().add(tmp);
        }
//        pane.getChildren().addAll(canvasList);
        Main.commands.forEach(command -> command.execute(canvasList));
        initialize();
    }


    private void mouseClicked(Point p) {
        System.out.println(p);
        if (current != null) {
            if (start == null) {
                start = p;
                current.setStart(start);
            } else {
                Main.commands.push(current.setStop(p).setLayer(canvasList.indexOf(layer)).execute(canvasList));
                current = (Shape) current.clone();
                main.addCanvasLayer(layer);
                layer.getGraphicsContext2D().stroke();
                initialize();
                main.resetAttributes(current);

            }
        }
    }


    public void toolClicked(Shape a) {
        initialize();
        current = a;
    }

    @Override
    protected void initialize() {
        start = null;
        layer = new Canvas(400, 400);
        canvasList.add(layer);
        pane.getChildren().add(layer);
//        gc = canvasList.peek().getGraphicsContext2D();
        layer.addEventHandler(MouseEvent.MOUSE_CLICKED, t -> mouseClicked(Point.pointFactory((int) t.getX(), (int) t.getY())));



    }


    public void attributeClicked(Command c) {
        int tmp = canvasList.indexOf(layer);
        Main.commands.push(c.setLayer(tmp).execute(canvasList));
   }

    public int getCanvasListSize() {
        return canvasList.size();
    }

    public void setCurrentLayer(Canvas l) {
        layer = l;
    }

    public int getCurrentLayer() {
        return canvasList.indexOf(layer);
    }
}
