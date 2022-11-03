public class PosterMovie {
    private int lastMovie = 10;
    private int id;
    private PurchaseItem[] items = new PurchaseItem[0];

    public PosterMovie(int lastMovie) {
        this.lastMovie = lastMovie;
    }

    public PosterMovie() {

    }

    public PosterMovie(int id, int lastMovie) {
        this.lastMovie = lastMovie;
        this.id = id;
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
        PurchaseItem[] last = new PurchaseItem[lastMovie];
        for (int i = 0; i < lastMovie; i++) {
            last[i] = items[items.length - 1 - i];
        }
        return last;
    }

    public PurchaseItem[] findAll() {

        return items;
    }

    public PurchaseItem findById(int id) {
        PurchaseItem item = new PurchaseItem("null");
        id = id - 1;
        for (int i = 0; i < items.length; i++) {
            if (i == id) {
                item = items[i];
            }
        }
        return item;
    }

    public void removeById(int id) {
        PurchaseItem[] tmp = new PurchaseItem[items.length - 1];
        if (id > 0) {
            int remove = id - 1;
            int itemsId = 0;
            for (int i = 0; i < items.length; i++) {
                if (i != remove) {
                    tmp[itemsId] = items[i];
                    itemsId++;
                }
            }
        }
        items = tmp;
    }

    void removeAll() {
        PurchaseItem[] tmp = new PurchaseItem[items.length];
        items = tmp;
    }
}
