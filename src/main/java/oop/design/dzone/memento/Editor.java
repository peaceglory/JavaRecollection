package oop.design.dzone.memento;

//Originator
public class Editor {
    //state
    private String editorContents;
    private CareTaker careTaker;

    public Editor(CareTaker careTaker) {
        this.careTaker = careTaker;
        this.editorContents = "INITIAL";
        save();
    }

    public void setState(String contents) {
        this.editorContents = contents;
    }

    public void save() {
        careTaker.addSnapshot(new EditorMemento(editorContents));
    }

    public void undo() {
        editorContents = careTaker.revertSnapshot().getSavedState();
    }

    public String getEditorContents() {
        return editorContents;
    }
}