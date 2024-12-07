import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MoveButton extends JButton implements ActionListener {
    private JPanel drawingPanel;
    private View view;
    private MouseHandler mouseHandler;
    private UndoManager undoManager;

    public MoveButton(UndoManager undoManager, View view, JPanel drawingPanel) {
        super("Move");
        this.undoManager = undoManager;
        this.view = view;
        this.drawingPanel = drawingPanel;
        addActionListener(this);
        mouseHandler = new MouseHandler();
    }

    public void actionPerformed(ActionEvent event) {
        view.setCursor(new Cursor(Cursor.MOVE_CURSOR));
        drawingPanel.addMouseListener(mouseHandler);
        drawingPanel.addMouseMotionListener(mouseHandler);
    }

    private class MouseHandler extends MouseAdapter {
        private Point startPoint;

        @Override
        public void mousePressed(MouseEvent e) {
            startPoint = e.getPoint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            Point endPoint = e.getPoint();
            int dx = endPoint.x - startPoint.x;
            int dy = endPoint.y - startPoint.y;

            if (dx != 0 || dy != 0) {
                MoveCommand moveCommand = new MoveCommand(dx, dy);
                undoManager.beginCommand(moveCommand);
                undoManager.endCommand(moveCommand);
            }

            view.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            drawingPanel.removeMouseListener(this);
            drawingPanel.removeMouseMotionListener(this);
        }
    }
}
