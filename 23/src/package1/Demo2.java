package package1;

class Shape {
    public void draw() {
        System.out.println("Shape.draw()");
    }
}

class circle extends Shape {
    @Override
    public void draw() {
        System.out.println("⚪");
    }
}

class rect extends Shape {
    @Override
    public void draw() {
        System.out.println("■");
    }
}

public class Demo2 {
    public static void main(String[] args) {
        Shape shape = new circle();
        Shape shape1 = new rect();
//        shape.draw();
//        shape1.draw();
        drawMap(shape);
        drawMap(shape1);
    }

    public static void drawMap(Shape shape) {
        shape.draw();
    }
}
