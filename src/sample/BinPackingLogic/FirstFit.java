package sample.BinPackingLogic;

/**
 * Created by Xsignati on 24.01.2017.
 */
public class FirstFit extends SearchStrategy{
    @Override
    public Bin search(Bin bin, Box box) {
        if(bin.getBinState() == Bin.BinState.FULL) {
            for (Bin subBin : bin.getChildren()) {
                Bin foundNode;
                if((foundNode = search(subBin, box)) != null) return foundNode;
            }
        }
        else if (boxFitsToBin(bin, box))
            return bin;
        return null;
    }
}