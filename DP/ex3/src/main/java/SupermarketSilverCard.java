public class SupermarketSilverCard extends Card{
    public SupermarketSilverCard(int id){
        this.ID = id;
        this.level = "Silver";
        sayHi();
    }
    @Override
    public void sayHi(){
        System.out.println("Supermarket Card" + ID + "\nThis card is a " + level +" Supermarket card");
    }
}
