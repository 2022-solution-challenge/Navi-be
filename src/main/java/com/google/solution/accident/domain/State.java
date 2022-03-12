package com.google.solution.accident.domain;

public enum State {
    CA;


    public static State of(String stateString) {
        for (State state : values()) {
            if (stateString.equals(state.name())) {
                return state;
            }
        }
        return null;
    }
}
