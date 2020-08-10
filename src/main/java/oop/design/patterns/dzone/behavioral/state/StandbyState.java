package oop.design.patterns.dzone.behavioral.state;

public class StandbyState implements State {

    public void pressPlay(MP3PlayerContext context) {
        context.setState(new PlayingState());
    }
}
