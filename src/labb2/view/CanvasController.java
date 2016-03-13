package labb2.view;

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

    private Stack<Canvas> canvasList = new Stack<>();

    private Shape current = null;
    private Point start = null;


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

    public void undoLast(){
        if(!canvasList.empty()) {
            try {
                pane.getChildren().remove(canvasList.pop());
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    public void restoreSave(int index){
        for (int i = 0; i < index; i++) {
            canvasList.add(new Canvas(400,400));
            pane.getChildren().add(canvasList.peek());
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
                Main.commands.push(current.setStop(p).setLayer(canvasList.size()-1).execute(canvasList));
                current = (Shape) current.clone();
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
        canvasList.add(new Canvas(400,400));
        pane.getChildren().add(canvasList.peek());
//        gc = canvasList.peek().getGraphicsContext2D();
        canvasList.peek().addEventHandler(MouseEvent.MOUSE_CLICKED, t -> mouseClicked(Point.pointFactory((int) t.getX(), (int) t.getY())));
    }

    public void attributeClicked(Command c) {

        Main.commands.push(c.setLayer(canvasList.size()-1).execute(canvasList));
    }

    public int getCanvasListSize() {
        return canvasList.size();
    }

    public int getCurrentLayer() {
        return getCanvasListSize();//TODO implement with select commands
    }
}
