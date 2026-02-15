package entities;

public class OrderItem {
    private Integer quantity;
    private Double price;
    Product product;

    public OrderItem() {
    }

    public OrderItem(Integer quantity,Product product) {
        this.quantity = quantity;
        this.price = product.getPrice();
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return product.getPrice();
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double subTotal() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return product.getName() + ", $ " + String.format("%.2f", price ) + ", Quantity: " + quantity + ", Subtotal: $ " + String.format("%.2f", subTotal());
    }
}
