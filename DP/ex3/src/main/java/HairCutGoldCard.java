public class HairCutGoldCard extends Card{
    public HairCutGoldCard(int id){
        this.ID = id;
        this.level = "Gold";
        sayHi();
    }
    @Override
    public void sayHi(){
        System.out.println("HairCut Card" + ID + "\nThis card is a " + level +" HairCut card");
    }
}
