package ya.praktikum.service;

import ya.praktikum.model.Discountable;
import ya.praktikum.model.Food;

public class ShoppingCart {
    private Food[] items;

    public ShoppingCart(Food[] items) {
        this.items = items;
    }

    public double getTotalWithoutDiscount() {
        double total = 0.0;
        for (int i = 0; i < items.length; i++) {
            total += items[i].getAmount() * items[i].getPrice();
        }
        return total;
    }

    public double getTotalWithDiscount() {
        double total = 0.0;
        for (int i = 0; i < items.length; i++) {
            Food item = items[i];
            double pricePerKg = item.getPrice();
            int amount = item.getAmount();
            double discount = item.getDiscount();
            double finalPrice = pricePerKg * (100 - discount) / 100;
            total += amount * finalPrice;

        }
        return total;
    }

    public double getVegetarianTotalWithoutDiscount() {
        double total = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i].isVegetarian()) {
                total += items[i].getAmount() * items[i].getPrice();
            }
        }
        return total;
    }
}