import java.awt.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class MoveCommand extends Command {
    private List<Item> itemsToMove; // Ensure this is declared as a class-level variable
    private int dx, dy;

    public MoveCommand(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
        itemsToMove = new ArrayList<>(); // Initialize the list

        // Collect selected items
        Enumeration enumeration = model.getSelectedItems();
        while (enumeration.hasMoreElements()) {
            Item item = (Item) enumeration.nextElement();
            itemsToMove.add(item);
        }
    }

    public void execute() {
        for (Item item : itemsToMove) {
            item.translate(dx, dy);
        }
        model.setChanged();
    }

    public boolean undo() {
        for (Item item : itemsToMove) {
            item.translate(-dx, -dy);
        }
        model.setChanged();
        return true;
    }

    public boolean redo() {
        execute();
        return true;
    }
}

