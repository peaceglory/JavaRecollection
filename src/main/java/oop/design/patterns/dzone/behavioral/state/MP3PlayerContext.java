package oop.design.patterns.dzone.behavioral.state;

//Context
public class MP3PlayerContext {
    private State state;

    public MP3PlayerContext(State state) {
        setState(state);
    }

    public void play() {
        state.pressPlay(this);
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}