package models;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "access_card_table")
public class AccessCard {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "incrementator")
    @GenericGenerator(name = "incrementator", strategy = "increment")
    private int accessCardId;
    private Boolean active;

    @ManyToOne
    private Room room;

    @ManyToOne
    private Worker worker;

    public AccessCard(){}

    public AccessCard(Boolean active, Room room, Worker worker) {
        this.active = active;
        this.room = room;
        this.worker = worker;
    }

    public int getAccessCardId() {
        return accessCardId;
    }

    public void setAccessCardId(int accessCardId) {
        this.accessCardId = accessCardId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }
}
