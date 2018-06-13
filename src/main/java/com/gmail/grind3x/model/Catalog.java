package com.gmail.grind3x.model;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlRootElement
public class Catalog {
    @XmlElement(name = "advertisement")
    private List<Advertisement> advertisements = new ArrayList<>();

    public Catalog() {
    }

    public void add(Advertisement advertisement) {
        if (advertisement == null) {
            throw new IllegalArgumentException();
        }
        advertisements.add(advertisement);
    }

    public void addAll(List<Advertisement> list) {
        if (list == null) {
            throw new IllegalArgumentException();
        }
        advertisements.addAll(list);
    }

    public List<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public static Catalog fromXML(String xmlString) {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Catalog.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (Catalog) unmarshaller.unmarshal(new StringReader(xmlString));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Advertisement getAdvById(Long id) {
        for (Advertisement advertisement : advertisements) {
            if (advertisement.getId() == id) {
                return advertisement;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Catalog catalog = (Catalog) o;
        return Objects.equals(advertisements, catalog.advertisements);
    }

    @Override
    public int hashCode() {

        return Objects.hash(advertisements);
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "advertisements=" + advertisements +
                '}';
    }
}
