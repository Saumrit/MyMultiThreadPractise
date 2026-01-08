package mythread.practise.randomclassesforpractise;

public class AddressOperarion {

    public AddressDTO addressDTO= new AddressDTO();

    private static final AddressOperarion instance = new AddressOperarion();

    private AddressOperarion() {}

    /**
     * make sure only Object of AddressOperarion is created through out the programme
     * @return AddressOperarion
     */
    public static AddressOperarion getInstance() {
        return instance;
    }

    public AddressDTO registerNewAddress(){

        addressDTO.setCity("City: "+Thread.currentThread().getName());
        addressDTO.setVillage("Village: "+Thread.currentThread().getName());
        System.out.println("AddressOperarion hashcode is "+hashCode());
        System.out.println("addressDTO hashcode is "+addressDTO.hashCode());
        //System.out.println("But reference of addressDTO is "+Integer.toHexString(addressDTO.hashCode()));

        return addressDTO;
    }
}
