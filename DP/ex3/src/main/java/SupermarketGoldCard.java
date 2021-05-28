public class SupermarketGoldCard extends Card{
    public SupermarketGoldCard(int id){
        this.ID = id;
        this.level = "Gold";
        sayHi();
    }
    @Override
    public void sayHi(){
        System.out.println("Supermarket Card" + ID + "\nThis card is a " + level +" Supermarket card");
    }
}
