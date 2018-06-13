package com.gmail.grind3x.model;

import com.gmail.grind3x.util.Base64Adapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Arrays;
import java.util.Objects;

@XmlRootElement(name = "advertisement")
public class Advertisement {
    private Long id;
    private String title;
    private String text;
    private byte[] image;

    public Advertisement() {
    }

    public Advertisement(Long id, String title, String text, byte[] image) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.image = image;
    }

    @XmlElement
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @XmlElement
    @XmlJavaTypeAdapter(Base64Adapter.class)
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @XmlElement
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advertisement that = (Advertisement) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(text, that.text) &&
                Arrays.equals(image, that.image);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(id, title, text);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
