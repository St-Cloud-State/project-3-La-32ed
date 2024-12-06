import javax.swing.*;
import java.awt.event.*;

public class MoveButton {
    private JButton button;
    private View view;

    public MoveButton(View view) {
        this.view = view;
        button = new JButton("Move");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Enable move mode by setting the mouse handler in the drawing panel
                view.getDrawingPanel().setMouseHandler(new MouseHandler(view));
            }
        });
    }

    public JButton getButton() {
        return button;
    }
}
