public class PosterMovie {
    private int lastMovie = 10;
    private PurchaseItem[] items = new PurchaseItem[0];



    public PosterMovie() {

    }

    public PosterMovie(int lastMovie) {
        this.lastMovie = lastMovie;
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

    public PurchaseItem findById(int idItems) {
        PurchaseItem find = new PurchaseItem(null, 0 );
        for (PurchaseItem item : items) {
            if (idItems == item.getId()) {
                find = item;
            }
        }
        return find;
    }
    public void removeById(int idItems) {
        PurchaseItem remove = new PurchaseItem(null, 0);
        if (remove != findById(idItems)) {
            PurchaseItem[] tmp = new PurchaseItem[items.length - 1];
            int itemsId = 0;
            for (PurchaseItem item : items) {
                if (idItems != item.getId()) {
                    tmp[itemsId] = item;
                    itemsId++;
                }
            }
            items = tmp;
        }else {
            return;
        }
    }


    void removeAll() {
        PurchaseItem[] tmp = new PurchaseItem[items.length];
        items = tmp;
    }


}
