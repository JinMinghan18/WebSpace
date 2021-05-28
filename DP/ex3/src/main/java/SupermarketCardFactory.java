

public class SupermarketCardFactory implements Factory{
    private static int ID_all = 0;
    int id;
    @Override
    public Card createCard(String types) {
        if(types.equals("Gold")){
            id = ++ID_all;
            return new SupermarketGoldCard(id);
        }

        else if(types.equals("Silver")){
            id = ++ID_all;
            return new SupermarketSilverCard(id);
        }
        else if(types.equals("Common")){
            id = ++ID_all;
            return new SupermarketCommonCard(id);
        }
        else {
            System.out.println("No such type");
            return null;
        }
    }
}
