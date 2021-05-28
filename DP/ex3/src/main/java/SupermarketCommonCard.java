public class SupermarketCommonCard extends Card{
    public SupermarketCommonCard(int id){
        this.ID = id;
        this.level = "Common";
        sayHi();
    }
    @Override
    public void sayHi(){
        System.out.println("Supermarket Card" + ID + "\nThis card is a " + level +" Supermarket card");
    }
}
