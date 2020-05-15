package oop.design.patterns.dzone.state;

public interface State {

    void pressPlay(MP3PlayerContext context);

    default String name() {
        return getClass().getSimpleName();
    }
}
