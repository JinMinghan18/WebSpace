public class HairCutSilverCard extends Card{
    public HairCutSilverCard(int id){
        this.ID = id;
        this.level = "Silver";
        sayHi();
    }
    @Override
    public void sayHi(){
        System.out.println("HairCut Card" + ID + "\nThis card is a " + level +" HairCut card");
    }
}
