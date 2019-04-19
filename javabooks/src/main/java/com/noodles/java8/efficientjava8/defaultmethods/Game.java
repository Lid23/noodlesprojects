package com.noodles.java8.efficientjava8.defaultmethods;


import java.util.Arrays;
import java.util.List;

public class Game {

    public static void main(String...args){
        List<Resizable> resizableShapes =
                Arrays.asList(new Square(),
                        new Triangle(), new Ellipse());
        Utils.paint(resizableShapes);
    }
}

