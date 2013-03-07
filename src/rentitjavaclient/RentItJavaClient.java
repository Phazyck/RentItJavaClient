package rentitjavaclient;

import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint;
import javax.xml.bind.JAXBElement;
import org.datacontract.schemas._2004._07.rentittest.NodeOfint;

/**
 *
 * @author Oliver
 */
public class RentItJavaClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            System.out.println(next());
        }
        
        int[] arr = new int[] {2,3,5,7,11,13};
        ArrayOfint aoi = new ArrayOfint();
        for(int i : arr) {
            aoi.getInt().add(i);
        }
        NodeOfint n = toNodes(aoi);
        while(n != null) {
            System.out.println(n.getElement());
            n = n.getNext().getValue();
        }
    }

    private static Integer next() {
        org.tempuri.RentItService service = new org.tempuri.RentItService();
        org.tempuri.IRentItService port = service.getBasicHttpBindingIRentItService();
        return port.next();
    }

    private static NodeOfint toNodes(com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfint array) {
        org.tempuri.RentItService service = new org.tempuri.RentItService();
        org.tempuri.IRentItService port = service.getBasicHttpBindingIRentItService();
        return port.toNodes(array);
    }
}
