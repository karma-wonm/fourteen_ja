public class MovieManager {
    private PosterMovie poster;

    public MovieManager(PosterMovie poster) {
        this.poster = poster;
    }

    public void add(PurchaseItem item) {

        poster.save(item);
    }

    public PurchaseItem[] getAll() {
        return poster.findAll();

    }

    public PurchaseItem findByIdObject(int id) {
        PurchaseItem byId = poster.findById(id);
        return byId;
    }
    public void removeById(int id){
       poster.removeById(id);

    }
    public void removeAll(){
        poster.removeAll();
    }



    public PurchaseItem[] getItems() {
        PurchaseItem[] all = poster.findAll();
        PurchaseItem[] reverse = new PurchaseItem[all.length];
        for (int i = 0; i < all.length; i++) {
            reverse[i] = all[all.length - i - 1];
        }
        return reverse;
    }

}
