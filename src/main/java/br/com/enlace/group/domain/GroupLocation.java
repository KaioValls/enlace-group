package br.com.enlace.group.domain;

import br.com.enlace.group.domain.util.AbstractAuditable;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "group_locations")
public class GroupLocation extends AbstractAuditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY)
    private List<Group> group;

    @Column(length = 200)
    private String address;

    @Column(length = 100)
    private String city;

    @Column(length = 2)
    private String state;

    @Column(name = "zip_code", length = 10)
    private String zipCode;

    private Double latitude;
    private Double longitude;

    @Column(name = "meeting_place", length = 150)
    private String meetingPlace;

    @Column(name = "is_online", nullable = false)
    private Boolean isOnline;

    @Column(name = "online_meeting_url")
    private String onlineMeetingUrl;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getMeetingPlace() {
        return meetingPlace;
    }

    public void setMeetingPlace(String meetingPlace) {
        this.meetingPlace = meetingPlace;
    }

    public Boolean getOnline() {
        return isOnline;
    }

    public void setOnline(Boolean online) {
        isOnline = online;
    }

    public String getOnlineMeetingUrl() {
        return onlineMeetingUrl;
    }

    public void setOnlineMeetingUrl(String onlineMeetingUrl) {
        this.onlineMeetingUrl = onlineMeetingUrl;
    }
}
