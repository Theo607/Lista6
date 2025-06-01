package GRID;

public class AnimalState {
    private boolean alive;
    private int index;
    private String type;
    private boolean clicked;

    public AnimalState(int index, String type) {
        this.alive = true;
        this.index = index;
        this.type = type;
        this.clicked = false;
    }

    public void kill() {
        this.alive = false;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public boolean lives() {
        return alive;
    }

    public int getIndex() {
        return index;
    }

    public String getType() {
        return type;
    }

    public boolean isClicked() {
        return clicked;
    }

    public String getEmoji() {
        if(type.equals("Hare")){
            return "\uD83D\uDC07"; // Hare emoji
        }
        if(type.equals("Wolf")){
            return "\uD83D\uDC3A"; // Wolf emoji
        }
        return "";
    }

    
    
}
