/*3.Simulate a Flipkart-style cart item insertion by creating a CartItem class with overloaded
 * constructors: one for just productId, one for productId and quantity, and one that copies an
 * existing CartItem. Show how each constructor could represent a different way of adding an item
 * to the cart.
 */

class CartIteam {
    int productid;
    int quantity;

    // Constructor for adding an item with only productId
    // Quantity is set to 1 by default
    public CartIteam(int productid) {
        this.productid = productid;
        this.quantity = 1;
    }

    // Constructor for adding an item with productId and quantity
    public CartIteam(int productid, int quantity) {
        this.productid = productid;
        this.quantity = quantity;
    }

    // Copy constructor for copying an existing cart item
    public CartIteam(CartIteam c) {
        this.productid = c.productid;
        this.quantity = c.quantity;
    }

    // Method to display cart item details
    void display() {
        System.out.println("ProductId : " + productid);
        System.out.println("Quantity : " + quantity);
        System.out.println();
    }
}

public class Flipcart_stylecart {

    public static void main(String[] args) {

        // Add item using only productId
        CartIteam c1 = new CartIteam(1010023);
        System.out.println("Using 1-parameter constructor");
        c1.display();

        // Add item using productId and quantity
        CartIteam c2 = new CartIteam(1010108, 2);
        System.out.println("Using 2-parameter constructor");
        c2.display();

        // Create a new cart item by copying an existing item
        CartIteam c3 = new CartIteam(c2);
        System.out.println("Using copy constructor");
        c3.display();
    }
}