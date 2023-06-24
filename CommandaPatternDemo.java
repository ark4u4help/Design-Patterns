// Command interface
interface Order {
    void execute();
}

// Receiver class
class Stock {
    private String name = "ABC";
    private int quantity = 10;

    void buy() {
        System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + " ] bought");
    }

    void sell() {
        System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + " ] sold");
    }
}

// Concrete command classes
class BuyStock implements Order {
    private Stock stock;

    BuyStock(Stock stock) {
        this.stock = stock;
    }

    public void execute() {
        stock.buy();
    }
}

class SellStock implements Order {
    private Stock stock;

    SellStock(Stock stock) {
        this.stock = stock;
    }

    public void execute() {
        stock.sell();
    }
}

// Invoker class
class Broker {
    private List<Order> orderList = new ArrayList<>();

    void takeOrder(Order order) {
        orderList.add(order);
    }

    void placeOrders() {
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}

// Demo class
public class CommandPatternDemo {
    public static void main(String[] args) {
        Stock stock = new Stock();

        BuyStock buyStockOrder = new BuyStock(stock);
        SellStock sellStockOrder = new SellStock(stock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }
}
