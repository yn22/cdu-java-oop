package threads;

import model.Cylinder;
import model.IWeight;
import model.Wood;
import store.ProductStore;
import store.WoodDirectory;

public class CylinderShop extends WoodShop {
        public CylinderShop(String name, WoodDirectory wd, ProductStore ps, int n) {
            super(name, wd, ps, n);
        }

        @Override
        IWeight createProduct() {
            int woodId = rnd.nextInt(wd.getArr().size());
            Wood wood = wd.get(woodId);
            float length = 1 + rnd.nextFloat() * 10;
            float diameter = 0.1f + rnd.nextFloat();
            Cylinder cylinder;
            try {
                cylinder = new Cylinder(wood, length, diameter);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            return cylinder;
        }
}
