import java.util.List;

public class MoveCommand {
    private List<Item> items;
    private int dx, dy;

    public MoveCommand(List<Item> items, int dx, int dy) {
        this.items = items;
        this.dx = dx;
        this.dy = dy;
    }

    public void execute() {
        for (Item item : items) {
            item.translate(dx, dy);
        }
    }

    public void undo() {
        for (Item item : items) {
            item.translate(-dx, -dy);
        }
    }

    public void redo() {
        execute();
    }
}
