package model.cells.gifts;

public class GiftFactory {

    public Gift getGift (char selector) {

        switch (selector) {

            case 'a':
                return new AmmoGift();

            case 'h':
                return new HealthGift();

            case 't':
                return new ArmorGift();

        }

        return null;
    }

}
