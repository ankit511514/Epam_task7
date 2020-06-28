import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*MEDIATOR PATTERN*/
class a
{
    int number;
    a(int n)
    {
        number=n;
    }
    protected void print()
    {
        System.out.println("HI"+number);
    }
}
class b extends a
{
    b(int n)
    {
        super(n);
    }
}
/*ABSTRACT FACTORY METHOD*/
interface ComputerFactory
{
    Computer createComputer();
}
class PcFactory implements ComputerFactory
{
   String RAM;
   PcFactory(String r)
   {
       RAM=r;
   }

    @Override
    public Computer createComputer() {
        return new Pc(RAM);
    }
}
abstract class Computer
{
    public abstract String getRam();
}
class Pc extends Computer
{
    String RAM;
    Pc(String r)
    {
        RAM=r;
    }
    public String getRam()
    {
        return RAM;
    }
}
/*COMPOSITE*/ /*AND*/ /*TEMPLATE METHOD*/
interface Shape
{
    void draw(String color);
}
class Triangle implements Shape
{
    @Override
    public void draw(String color) {
        System.out.println("Triangle Color:-"+color);
    }
}
class Circle implements Shape
{
    @Override
    public void draw(String color) {
        System.out.println("Circle color:-"+color);
    }
}
class Drawing implements Shape
{
    ArrayList<Shape> shape=new ArrayList<Shape>();

    @Override
    public void draw(String color) {
        for (Shape sh: shape)
        {
            sh.draw("Red");
        }
    }
}
class Color
{
    String color()
    {
        return "red";
    }
}
/*SINGLETON METHOD*/
public class Design
{
    public static final Design design=new Design();
    private Design()
    {}
    public static Design DesignInstance()
    {
        return design;
    }
    public static void main(String args[])
    {
        Drawing d1=new Drawing();
        Color col=new Color();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        d1.draw(col.color());//BRIDGE METHOD
        b abc=new b(n);
        abc.print();
    }
}
