public class HairCutCardFactory implements Factory{
    private static int ID_all;
    int id;
    @Override
    public Card createCard(String types) {
        if(types.equals("Gold")){
            id= ++ID_all;
            return new HairCutGoldCard(id);
        }

        else if(types.equals("Silver")){
            id = ++ID_all;
            return new HairCutSilverCard(id);
        }

        else if(types.equals("Common")){
            id = ++ID_all;
            return new HairCutCommonCard(id);
        }
        else {
            System.out.println("No such type");
            return null;
        }
    }
}
