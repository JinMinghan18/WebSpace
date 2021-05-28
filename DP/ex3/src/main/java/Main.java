public class Main {
    public static void main(String[] args) {
        Factory factory = new SupermarketCardFactory();
        Card card = factory.createCard("Gold");
        card = factory.createCard("Silver");
        card = factory.createCard("Common");
        System.out.println("____________________________________");
        Factory factory2 = new HairCutCardFactory();
        Card card2 = factory2.createCard("Gold");
        card2 = factory2.createCard("Silver");
        card2 = factory2.createCard("Common");

    }

}
