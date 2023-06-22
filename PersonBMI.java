public class Person {
private double height;
private double weight;

public void setHeight(double h)
{
height= h;
}
public void setWeight(double w)
{
weight= w;
}
}
class PersonBMI extends Person
{
public void setHeight(double h)
{
super.setHeight(h);
super.setWeight(h);
}
public void setWeight(double w)
{
super.setHeight(h);
super.setWeight(h);
}
public static void main(String[] args) {

}
}
