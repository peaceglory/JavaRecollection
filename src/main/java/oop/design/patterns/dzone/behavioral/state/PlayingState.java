package oop.design.patterns.dzone.behavioral.state;

public class PlayingState implements State {

    public void pressPlay(MP3PlayerContext context) {
        context.setState(new StandbyState());
    }
}