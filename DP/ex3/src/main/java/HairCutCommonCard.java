public class HairCutCommonCard extends Card{
    public HairCutCommonCard(int id){
        this.ID = id;
        this.level = "Common";
        sayHi();
    }
    @Override
    public void sayHi(){
        System.out.println("HairCut Card" + ID + "\nThis card is a " + level +" HairCut card");
    }
}
