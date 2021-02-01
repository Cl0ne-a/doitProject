package com.project.doit;

public enum Colour {
    GREEN ("GREEN"),
    RED("RED");
    private String colour;
    private Colour(String colour) {
        this.colour = colour;
    }

    public String getColour(){
        return colour;
    }


}
