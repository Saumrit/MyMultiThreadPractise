package mythread.practise.randomclassesforpractise;

import java.util.Objects;

public class AddressDTO {
    private String city;
    private String village;

    public AddressDTO() {
    }
    public AddressDTO(String city, String village) {
        this.city = city;
        this.village = village;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getVillage() {
        return village;
    }
    public void setVillage(String village) {
        this.village = village;
    }

//    @Override
//    public String toString() {
//        return "AddressDTO{" +
//                "city='" + city + '\'' +
//                ", village='" + village + '\'' +
//                '}';
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressDTO that)) return false;
        return Objects.equals(city, that.city) && Objects.equals(village, that.village);
    }


}
