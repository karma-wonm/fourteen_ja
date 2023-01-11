public class PosterMovie {
    private int lastMovie = 10;
    private PurchaseItem[] items = new PurchaseItem[0];

    public PosterMovie(int lastMovie) {
        this.lastMovie = lastMovie;
    }

    public PosterMovie() {

    }

    public void save(PurchaseItem item) {
        PurchaseItem[] tmp = new PurchaseItem[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public PurchaseItem[] findLast() {
        if (lastMovie > items.length){
            lastMovie = items.length;
        }
        PurchaseItem[] last = new PurchaseItem[lastMovie];
        for (int i = 0; i < lastMovie; i++) {
            last[i] = items[items.length - 1 - i];
        }
        return last;
    }

    public PurchaseItem[] findAll() {

        return items;
    }
}
